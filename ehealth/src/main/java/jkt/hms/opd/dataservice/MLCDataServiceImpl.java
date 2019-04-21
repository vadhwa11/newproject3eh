package jkt.hms.opd.dataservice;



import static jkt.hms.util.RequestConstants.ADMISSION_NUMBER;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import jkt.hms.masters.business.ExpiryDetails;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MedicoLegalDetails;
import jkt.hms.masters.business.MlcMaterialObjects;
import jkt.hms.masters.business.MortuaryRegisterDetails;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.PatientWiseMlc;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;



public class MLCDataServiceImpl extends HibernateDaoSupport implements	MLCDataService {

	
	// *********************---------------------------------------- Commom UHID -------------------------------------***********************//

	
	@Override
	public Map<String, Object> showUHIDJsp() {
		 Map<String, Object> map = new HashMap<String, Object>();
			List<Patient> patientList = new ArrayList<Patient>();
			Session session = (Session) getSession();
			try {
				patientList=session.createCriteria(Patient.class).list();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("patientList", patientList);
			return map;
			
	}
	@Override
	public Map<String, Object> getPaitentDetail(Map<String, Object> detailsMap) {
		 Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientHindIdList = new ArrayList<Patient>();
		List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
		String uhinId="";
		//String mlcType="";
		if(detailsMap.get("uhinId")!=null){
			uhinId=(String) detailsMap.get("uhinId");
		}
		/*if(detailsMap.get("mlcType")!=null){
			mlcType=(String) detailsMap.get("mlcType");
		}*/
		Session session = null;
		session = (Session) getSession();
		try {

			patientHindIdList= session.createCriteria(Patient.class).add(Restrictions.eq("HinNo",uhinId)).list();
			/*if(mlcType!="")
			{
				medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).createAlias("Hin", "Hin").add(Restrictions.eq("Hin.HinNo",uhinId))
						.add(Restrictions.like("MlcType",mlcType).ignoreCase())
						.list();
				if(medicoLegalDetailsList.size()>0){
					map.put("medicoLegalDetailsList", medicoLegalDetailsList);
				}
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientHindIdList", patientHindIdList);
		return map;
	}


	
	
	
		
		
	// *********************---------------------------------------- Start of  Method by Mansi -------------------------------------***********************//

	@Override
	public Map<String, Object> addExamOfMaleAccusedSexualOffence(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		PatientWiseMlc patientWiseMlc=null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session= (Session) getSession();
		String message ="";
		int medicoLegalDetailsId=0;
		String transactionSequenceName = "ExamOfMaleAccusedSexual";
		List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
		List<MlcMaterialObjects> materialObjectsList = new ArrayList<MlcMaterialObjects>();
		String mlcType="";
		String report="";
		Transaction tx=null;
		
		try {
			tx = session.beginTransaction();
			 if(box.getString("flag").equalsIgnoreCase("submit")){
					
			patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
					           .add(Restrictions.eq("MlcType","Examination of a male accused in sexual offence"))
					           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();
			
			PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());
			
			if(wiseMlc!=null){
				wiseMlc.setStatus("AT");
			}
							MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
				if(box.getInt("hinId")!=0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				medicoLegalDetails.setHin(patient);
				}
				if(box.getInt("detailId")!=0){
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(box.getInt("detailId"));
					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
					}
				
				medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
				if(!box.getString("refMLDate").equals("")){
					medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
					}
				
					if(!box.getString("receivedDate").equals("")){
				
				medicoLegalDetails.setReceivedDate(HMSUtil.convertStringTypeDateToDateType(box.getString("receivedDate")));
				}
				medicoLegalDetails.setReceivedTime(box.getString("receivedTime"));
				medicoLegalDetails.setReceivedFrom(box.getString("receivedFrom"));
				medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
				medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
				medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
				medicoLegalDetails.setConsent(box.getString("consent"));
					if(!box.getString("requisitionDate").equals("")){
				
					medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
				}
				medicoLegalDetails.setRequisitionTime(box.getString("requisitionTime"));
				medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
				
				medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
				medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
					if(!box.getString("commencementOfExaminationDate").equals("")){
				medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
				}
				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
				medicoLegalDetails.setClinicalHistory(box.getString("clinicalHistory"));
				medicoLegalDetails.setHistoryOfIllness(box.getString("clinicalHistoryPresent"));
				medicoLegalDetails.setHistorySexualDev(box.getString("historyOfSexualDevelopment"));
				medicoLegalDetails.setMaritalHistory(box.getString("maritalHistory"));
				medicoLegalDetails.setAgeOfMarriage(box.getString("ageOfMarriage"));
				medicoLegalDetails.setChildren(box.getString("whetherHavingChildren"));
				medicoLegalDetails.setHistoryInjuryCause(box.getString("historyAndAllegedCauseOfInjury"));
				medicoLegalDetails.setWeight(box.getInt("weight"));
				medicoLegalDetails.setHeight(box.getInt("height"));
				medicoLegalDetails.setBuild(box.getString("build"));
				medicoLegalDetails.setHair(box.getString("hair"));
				medicoLegalDetails.setPlength(box.getInt("length"));
				medicoLegalDetails.setPenis(box.getString("penis"));
				
				medicoLegalDetails.setCircumference(box.getInt("circumference"));
				medicoLegalDetails.setDiseaseInjury(box.getString("disease"));
				medicoLegalDetails.setInjuryDetails(box.getString("diseasePresent"));
				
				
				medicoLegalDetails.setSkin(box.getString("skin"));
				medicoLegalDetails.setSmegmaDeposits(box.getString("smegmaDeposits"));
				
				medicoLegalDetails.setSensation(box.getString("sensations"));
				medicoLegalDetails.setDischargeTenderness(box.getString("urethralDischarge"));
				medicoLegalDetails.setScrotum(box.getString("scrotum"));
				medicoLegalDetails.setRightTestis(box.getString("rightTestis"));
				medicoLegalDetails.setLeftTestis(box.getString("leftTestis"));
				medicoLegalDetails.setDevelopmentTestis(box.getString("developmentOfTestis"));
				medicoLegalDetails.setReflexes(box.getString("sensationsReflexes"));
				medicoLegalDetails.setTestisDiseaseInjury(box.getString("diseaseDeformity"));
				medicoLegalDetails.setRightTestis(box.getString("rightTestis"));
				medicoLegalDetails.setPulse(box.getInt("pulse"));
				if(!box.getString("address").equals("")){
					medicoLegalDetails.setPatientAddress(box.getString("address"));
			        }
				
				medicoLegalDetails.setFindings(box.getString("otherFindings"));
				medicoLegalDetails.setInjuryOnBody(box.getString("injuries"));
				medicoLegalDetails.setBp(box.getString("bp"));
				
				
				medicoLegalDetails.setExaminationTime(box.getString("examConcludedTime"));
				
					if(!box.getString("examinationConcludedDate").equals("")){
				medicoLegalDetails.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinationConcludedDate")));
				}
				medicoLegalDetails.setOpinion(box.getString("opinion"));
				
				medicoLegalDetails.setReasonForConclusion(box.getString("reasonForConclusion"));
				medicoLegalDetails.setMlcType("Examination of a male accused in sexual offence");
				if(box.getInt("inPatientId")!=0){
					Inpatient inp=new Inpatient();
					inp.setId(box.getInt("inPatientId"));
					medicoLegalDetails.setInpatient(inp);	
				}
		
				
				
				if(box.getInt("empId")!=0){
				MasEmployee doctor = new MasEmployee();
				doctor.setId(box.getInt("empId"));
				medicoLegalDetails.setDoctor(doctor);
				}
				
				if(box.getInt("userId")!=0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					medicoLegalDetails.setLastChgBy(users);
					}
				
					if(!box.getString(CHANGED_DATE).equals("")){
				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
				
				  sequenceNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
		 							.list();
		 			if(sequenceNoList.size()>0){
		            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
		 			int orderNo = transactionSequence.getTransactionSequenceNumber();
		 			orderNo = orderNo + 1;
		 			int id = transactionSequence.getId();

		 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
		 			transactionSequence2.setTransactionSequenceNumber(orderNo);
		 			hbt.update(transactionSequence2);
		 			}else if (sequenceNoList.size() == 0) {
		 				TransactionSequence tsObj = new TransactionSequence();
		 				tsObj.setStatus("y");
		 				tsObj.setTransactionPrefix("EOM");
		 				tsObj.setTransactionSequenceName(transactionSequenceName);
		 				tsObj.setTransactionSequenceNumber(1);
		 				tsObj.setCreatedby("admin");
		 				tsObj.setStatus("y");
		 				MasHospital hospital= new MasHospital();
		 				hospital.setId(box.getInt("hospitalId"));
		 				tsObj.setHospital(hospital);
		 				
		 				hbt.save(tsObj);
		 				
		 			}
				
				hbt.save(medicoLegalDetails);
				
				int count = 0;
                if(box.getInt("hdb") != 0){
                    count = box.getInt("hdb");
                }
                
                for (int i = 1; i <= count; i++) {
                    MlcMaterialObjects materialObjects = new MlcMaterialObjects();
                    
                    if(box.getString("slNo"+i).equalsIgnoreCase("y")){
                        
                        
                        if(!box.getString("materialObjects"+i).equals("")){
                            materialObjects.setMaterialObjects(box.getString("materialObjects"+i));
                        }
                
				
				        
                        materialObjects.setMedicoLegalDetails(medicoLegalDetails);
						hbt.save(materialObjects);
				      hbt.update(wiseMlc);
				     
                    }
				}
                
                
                
                
				successfullyAdded = true;

				medicoLegalDetailsId=medicoLegalDetails.getId();
            mlcType=medicoLegalDetails.getMlcType();
		      tx.commit();
			 }
			 else if (box.getString("flag").equalsIgnoreCase("authorization")) {
					
				 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
				           .add(Restrictions.eq("MlcType","Examination of a male accused in sexual offence"))
				           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

		            PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

		           if(wiseMlc!=null){
			          wiseMlc.setStatus("C");
		               }
					
					
					List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
					medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
							.list();
					 
				if(medicoLegalDetailsList.size()>0){
						MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
						
						
						if(box.getInt("hinId")!=0){
							Patient patient = new Patient();
							patient.setId(box.getInt("hinId"));
							medicoLegalDetails.setHin(patient);
							}
							if(box.getInt("detailId")!=0){
								OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
								opdPatientDetails.setId(box.getInt("detailId"));
								medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
								}
							
							medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
							if(!box.getString("refMLDate").equals("")){
								medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
								}
							
								if(!box.getString("receivedDate").equals("")){
							
							medicoLegalDetails.setReceivedDate(HMSUtil.convertStringTypeDateToDateType(box.getString("receivedDate")));
							}
							medicoLegalDetails.setReceivedTime(box.getString("receivedTime"));
							medicoLegalDetails.setReceivedFrom(box.getString("receivedFrom"));
							medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
							medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
							medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
							medicoLegalDetails.setConsent(box.getString("consent"));
								if(!box.getString("requisitionDate").equals("")){
							
								medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
							}
							medicoLegalDetails.setRequisitionTime(box.getString("requisitionTime"));
							medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
							
							medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
							medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
							medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
								if(!box.getString("commencementOfExaminationDate").equals("")){
							medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
							}
							medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
							medicoLegalDetails.setHistoryOfIllness(box.getString("clinicalHistoryPresent"));
							medicoLegalDetails.setHistorySexualDev(box.getString("historyOfSexualDevelopment"));
							medicoLegalDetails.setMaritalHistory(box.getString("maritalHistory"));
							medicoLegalDetails.setAgeOfMarriage(box.getString("ageOfMarriage"));
							medicoLegalDetails.setChildren(box.getString("whetherHavingChildren"));
							medicoLegalDetails.setHistoryInjuryCause(box.getString("historyAndAllegedCauseOfInjury"));
							medicoLegalDetails.setWeight(box.getInt("weight"));
							medicoLegalDetails.setHeight(box.getInt("height"));
							medicoLegalDetails.setBuild(box.getString("build"));
							medicoLegalDetails.setHair(box.getString("hair"));
							medicoLegalDetails.setPlength(box.getInt("length"));
							medicoLegalDetails.setPenis(box.getString("penis"));
							
							medicoLegalDetails.setCircumference(box.getInt("circumference"));
							medicoLegalDetails.setDiseaseInjury(box.getString("disease"));
							medicoLegalDetails.setInjuryDetails(box.getString("diseasePresent"));
							
							
							medicoLegalDetails.setSkin(box.getString("skin"));
							medicoLegalDetails.setSmegmaDeposits(box.getString("smegmaDeposits"));
							
							medicoLegalDetails.setSensation(box.getString("sensations"));
							medicoLegalDetails.setDischargeTenderness(box.getString("urethralDischarge"));
							medicoLegalDetails.setScrotum(box.getString("scrotum"));
							medicoLegalDetails.setRightTestis(box.getString("rightTestis"));
							medicoLegalDetails.setLeftTestis(box.getString("leftTestis"));
							medicoLegalDetails.setDevelopmentTestis(box.getString("developmentOfTestis"));
							medicoLegalDetails.setReflexes(box.getString("sensationsReflexes"));
							medicoLegalDetails.setTestisDiseaseInjury(box.getString("diseaseDeformity"));
							medicoLegalDetails.setRightTestis(box.getString("rightTestis"));
							medicoLegalDetails.setPulse(box.getInt("pulse"));
							if(!box.getString("address").equals("")){
								medicoLegalDetails.setPatientAddress(box.getString("address"));
						        }
							
							medicoLegalDetails.setFindings(box.getString("otherFindings"));
							medicoLegalDetails.setInjuryOnBody(box.getString("injuries"));
							medicoLegalDetails.setBp(box.getString("bp"));
							
							
							medicoLegalDetails.setExaminationTime(box.getString("examConcludedTime"));
							
								if(!box.getString("examinationConcludedDate").equals("")){
							medicoLegalDetails.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinationConcludedDate")));
							}
							medicoLegalDetails.setOpinion(box.getString("opinion"));
							
							medicoLegalDetails.setReasonForConclusion(box.getString("reasonForConclusion"));
							medicoLegalDetails.setMlcType("Examination of a male accused in sexual offence");
							if(box.getInt("inPatientId")!=0){
								Inpatient inp=new Inpatient();
								inp.setId(box.getInt("inPatientId"));
								medicoLegalDetails.setInpatient(inp);	
							}
							
							
							
							if(box.getInt("empId")!=0){
							MasEmployee doctor = new MasEmployee();
							doctor.setId(box.getInt("empId"));
							medicoLegalDetails.setDoctor(doctor);
							}
							
							if(box.getInt("userId")!=0){
								Users users = new Users();
								users.setId(box.getInt("userId"));
								medicoLegalDetails.setLastChgBy(users);
								}
							
								if(!box.getString(CHANGED_DATE).equals("")){
							medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
							}
							medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
							
							

							int count = 0;
			                if(box.getInt("hdb") != 0){
			                    count = box.getInt("hdb");
			                }
			                
			                
			        	  	materialObjectsList = session
				 					.createCriteria(MlcMaterialObjects.class)
				 					.createAlias("MedicoLegalDetails", "ml")
						 			.add(Restrictions.eq("ml.Id", box.getInt("mediCoId")))
				 							.list();
				 			if(materialObjectsList.size()>0){
								hbt.deleteAll(materialObjectsList);
				 				
				 			}
			                for (int i = 1; i <= count; i++) {

			                
			                	MlcMaterialObjects materialObjects = new MlcMaterialObjects();
			                    if(box.getString("slNo"+i).equalsIgnoreCase("y")){
			                        
			                        
			                        if(!box.getString("materialObjects"+i).equals("")){
			                            materialObjects.setMaterialObjects(box.getString("materialObjects"+i));
			                        }
			                
							
							        
			                        materialObjects.setMedicoLegalDetails(medicoLegalDetails);
									hbt.save(materialObjects);
							      
			                    	
			                    }
							}
				        
				    	hbt.update(wiseMlc);
						hbt.saveOrUpdate(medicoLegalDetails);
						mlcType=medicoLegalDetails.getMlcType();
						medicoLegalDetailsId=medicoLegalDetails.getId();	
						successfullyAdded = true;
						tx.commit();
				}
				else {

					MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
					if(box.getInt("hinId")!=0){
					Patient patient = new Patient();
					patient.setId(box.getInt("hinId"));
					medicoLegalDetails.setHin(patient);
					}
					if(box.getInt("detailId")!=0){
						OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
						opdPatientDetails.setId(box.getInt("detailId"));
						medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
						}
					
					medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
					if(!box.getString("refMLDate").equals("")){
						medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
						}
					
						if(!box.getString("receivedDate").equals("")){
					
					medicoLegalDetails.setReceivedDate(HMSUtil.convertStringTypeDateToDateType(box.getString("receivedDate")));
					}
					medicoLegalDetails.setReceivedTime(box.getString("receivedTime"));
					medicoLegalDetails.setReceivedFrom(box.getString("receivedFrom"));
					medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
					medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
					medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
					medicoLegalDetails.setConsent(box.getString("consent"));
						if(!box.getString("requisitionDate").equals("")){
					
						medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
					}
					medicoLegalDetails.setRequisitionTime(box.getString("requisitionTime"));
					medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
					
					medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
					medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
					medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
						if(!box.getString("commencementOfExaminationDate").equals("")){
					medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
					}
					medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
					medicoLegalDetails.setHistoryOfIllness(box.getString("clinicalHistoryPresent"));
					medicoLegalDetails.setHistorySexualDev(box.getString("historyOfSexualDevelopment"));
					medicoLegalDetails.setMaritalHistory(box.getString("maritalHistory"));
					medicoLegalDetails.setAgeOfMarriage(box.getString("ageOfMarriage"));
					medicoLegalDetails.setChildren(box.getString("whetherHavingChildren"));
					medicoLegalDetails.setHistoryInjuryCause(box.getString("historyAndAllegedCauseOfInjury"));
					medicoLegalDetails.setWeight(box.getInt("weight"));
					medicoLegalDetails.setHeight(box.getInt("height"));
					medicoLegalDetails.setBuild(box.getString("build"));
					medicoLegalDetails.setHair(box.getString("hair"));
					medicoLegalDetails.setPlength(box.getInt("length"));
					medicoLegalDetails.setPenis(box.getString("penis"));
					
					medicoLegalDetails.setCircumference(box.getInt("circumference"));
					medicoLegalDetails.setDiseaseInjury(box.getString("disease"));
					medicoLegalDetails.setInjuryDetails(box.getString("diseasePresent"));
					
					
					medicoLegalDetails.setSkin(box.getString("skin"));
					medicoLegalDetails.setSmegmaDeposits(box.getString("smegmaDeposits"));
					
					medicoLegalDetails.setSensation(box.getString("sensations"));
					medicoLegalDetails.setDischargeTenderness(box.getString("urethralDischarge"));
					medicoLegalDetails.setScrotum(box.getString("scrotum"));
					medicoLegalDetails.setRightTestis(box.getString("rightTestis"));
					medicoLegalDetails.setLeftTestis(box.getString("leftTestis"));
					medicoLegalDetails.setDevelopmentTestis(box.getString("developmentOfTestis"));
					medicoLegalDetails.setReflexes(box.getString("sensationsReflexes"));
					medicoLegalDetails.setTestisDiseaseInjury(box.getString("diseaseDeformity"));
					medicoLegalDetails.setRightTestis(box.getString("rightTestis"));
					medicoLegalDetails.setPulse(box.getInt("pulse"));
					if(!box.getString("address").equals("")){
						medicoLegalDetails.setPatientAddress(box.getString("address"));
				        }
					
					medicoLegalDetails.setFindings(box.getString("otherFindings"));
					medicoLegalDetails.setInjuryOnBody(box.getString("injuries"));
					medicoLegalDetails.setBp(box.getString("bp"));
					
					
					medicoLegalDetails.setExaminationTime(box.getString("examConcludedTime"));
					
						if(!box.getString("examinationConcludedDate").equals("")){
					medicoLegalDetails.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinationConcludedDate")));
					}
					medicoLegalDetails.setOpinion(box.getString("opinion"));
					
					medicoLegalDetails.setReasonForConclusion(box.getString("reasonForConclusion"));
					medicoLegalDetails.setMlcType("Examination of a male accused in sexual offence");
					if(box.getInt("inPatientId")!=0){
						Inpatient inp=new Inpatient();
						inp.setId(box.getInt("inPatientId"));
						medicoLegalDetails.setInpatient(inp);	
					}
					
					
					
					if(box.getInt("empId")!=0){
					MasEmployee doctor = new MasEmployee();
					doctor.setId(box.getInt("empId"));
					medicoLegalDetails.setDoctor(doctor);
					}
					
					if(box.getInt("userId")!=0){
						Users users = new Users();
						users.setId(box.getInt("userId"));
						medicoLegalDetails.setLastChgBy(users);
						}
					
						if(!box.getString(CHANGED_DATE).equals("")){
					medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					}
					medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
					
					String srNo=box.getString("refMLNo");
					String yr = "";
					if(srNo!=null){ 
 						 yr = srNo.substring(4, 8);
 						
					}				
					sequenceNoList = session
			 					.createCriteria(TransactionSequence.class)
			 					.add(Restrictions.eq("TransactionSequenceName",
			 							transactionSequenceName))
			 							.createAlias("Hospital", "hosp")
					 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
					 			.add(Restrictions.eq("FinanicalYear", yr))
			 							.list();
			 			if(sequenceNoList.size()>0){
			            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
			 			int orderNo = transactionSequence.getTransactionSequenceNumber();
			 			orderNo = orderNo + 1;
			 			int id = transactionSequence.getId();

			 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
			 			transactionSequence2.setTransactionSequenceNumber(orderNo);
			 			hbt.update(transactionSequence2);
			 			}else if (sequenceNoList.size() == 0) {
			 				TransactionSequence tsObj = new TransactionSequence();
			 				tsObj.setStatus("y");
			 				tsObj.setTransactionPrefix("EOM");
			 				tsObj.setTransactionSequenceName(transactionSequenceName);
			 				tsObj.setTransactionSequenceNumber(1);
			 				tsObj.setCreatedby("admin");
			 				tsObj.setStatus("y");
			 				
			 				tsObj.setFinanicalYear(yr);
			 			
			 				
			 				
			 				MasHospital hospital= new MasHospital();
			 				hospital.setId(box.getInt("hospitalId"));
			 				tsObj.setHospital(hospital);
			 				
			 				hbt.save(tsObj);
			 				
			 			}
					
					hbt.save(medicoLegalDetails);
					
					int count = 0;
	                if(box.getInt("hdb") != 0){
	                    count = box.getInt("hdb");
	                }
	                
	                for (int i = 1; i <= count; i++) {
	                    MlcMaterialObjects materialObjects = new MlcMaterialObjects();
	                    
	                    if(box.getString("slNo"+i).equalsIgnoreCase("y")){
	                        
	                        
	                        if(!box.getString("materialObjects"+i).equals("")){
	                            materialObjects.setMaterialObjects(box.getString("materialObjects"+i));
	                        }
	                
					
					        
	                        materialObjects.setMedicoLegalDetails(medicoLegalDetails);
							hbt.save(materialObjects);
					      hbt.update(wiseMlc);
					     
	                    }
					}
					successfullyAdded = true;

					medicoLegalDetailsId=medicoLegalDetails.getId();
	            mlcType=medicoLegalDetails.getMlcType();
			      tx.commit();
					
				}
				report="need report";
			 }
	}catch (DataAccessException e) {
		e.printStackTrace();
		if(tx==null){
			tx.rollback();
		}
		
	}
	//map = showUHIDJsp();
	map.put("successfullyAdded", successfullyAdded);
	map.put("medicoLegalDetailsId", medicoLegalDetailsId);
	map.put("mlcType", mlcType);
	map.put("message", message);
	map.put("report", report);
	return map;
	}
	@Override
	public Map<String, Object> addExamOfFemaleVictimOfSexualAssault(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		PatientWiseMlc patientWiseMlc=null;
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session= (Session) getSession();
		String message ="";
		int medicoLegalDetailsId=0;
		String mlcType="";
		Transaction tx=null;
		String transactionSequenceName = "ExamOfFemaleVictimOfSexual";
		String report="";
		List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
		List<MlcMaterialObjects> materialObjectsList = new ArrayList<MlcMaterialObjects>();
		try {
		/*	List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
			medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
					.add(Restrictions.like("MlcType", "Female Victim").ignoreCase())
					.list();
			
			if(medicoLegalDetailsList.size()  == 0){*/
			tx = session.beginTransaction();
			 if(box.getString("flag").equalsIgnoreCase("submit")){
					
					
			 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
			           .add(Restrictions.eq("MlcType","Examination of a female victim of sexual assault"))
			           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

	         PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

	          if(wiseMlc!=null){
		            wiseMlc.setStatus("AT");
	                 }
					 
			
				MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
				if(box.getInt("hinId")!=0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				medicoLegalDetails.setHin(patient);
				}
				
				medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
				if(!box.getString("refMLDate").equals("")){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
				}
				if(box.getInt("detailId")!=0){
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(box.getInt("detailId"));
					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
					}
				medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
				medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
				medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
				medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
				medicoLegalDetails.setConsent(box.getString("consent"));
				medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
				
				medicoLegalDetails.setEducationalStatus(box.getString("educationalStatus"));
				medicoLegalDetails.setWitnesses1(box.getString("femaleWitness"));
				medicoLegalDetails.setHistoryByInjured(box.getString("statedBySubject"));
				medicoLegalDetails.setMaritalHistory(box.getString("maritalStatus"));
				medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
				medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
				if(!box.getString("commencementOfExaminationDate").equals("")){
				medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
				}
				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
				
				if(!box.getString("allegedActDate").equals("")){
				medicoLegalDetails.setAllegedActDate(HMSUtil.convertStringTypeDateToDateType(box.getString("allegedActDate")));
				}
				medicoLegalDetails.setAllegedActTime(box.getString("allegedActTime"));
				medicoLegalDetails.setPlaceOfAct(box.getString("allegedActPlace"));
				
				medicoLegalDetails.setConsciousnessState(box.getString("stateOfConsciousness"));
				medicoLegalDetails.setInvolvedPersonNumber(box.getString("numberOfPerson"));
				medicoLegalDetails.setInvolvedPersonName(box.getString("nameOfPerson"));
				medicoLegalDetails.setDetailsOfPosition(box.getString("detailsOfPosition"));
				medicoLegalDetails.setDegreeOfViolence(box.getString("degreeOfViolence"));
				medicoLegalDetails.setPain(box.getString("Pain"));
				medicoLegalDetails.setUrinated(box.getString("urinated"));
				medicoLegalDetails.setAnyOtherInformation(box.getString("otherInformation"));
				medicoLegalDetails.setResistenceOffred(box.getString("resistanceOffered"));
				medicoLegalDetails.setReason(box.getString("resistanceOfferedNo"));
				medicoLegalDetails.setReasonDelayComplain(box.getString("reasonsForDelay"));
				medicoLegalDetails.setPreviousExp(box.getString("previousExperience"));
				medicoLegalDetails.setFrequency(box.getString("frequency"));
				if(!box.getString("address").equals("")){
					medicoLegalDetails.setPatientAddress(box.getString("address"));
			        }
				
					if(!box.getString("lastSexualActDate").equals("")){
				medicoLegalDetails.setLastSexualActDate(HMSUtil.convertStringTypeDateToDateType(box.getString("lastSexualActDate")));
				}
				medicoLegalDetails.setAgeOfMenarche(box.getString("ageOfMenarche"));
				medicoLegalDetails.setPeriods(box.getString("periods"));
				medicoLegalDetails.setMenstrualHistory(box.getString("menstrualHistory"));
				medicoLegalDetails.setMenstruatingNow(box.getString("whetherMmenstruatingNow"));
				
					if(!box.getString("dateOfLastMenstrualPeriod").equals("")){
				medicoLegalDetails.setLastMenstrualDate(HMSUtil.convertStringTypeDateToDateType(box.getString("dateOfLastMenstrualPeriod")));
				}
				medicoLegalDetails.setOtherHistory(box.getString("otherRelevantHistory"));
				medicoLegalDetails.setPregnant(box.getString("whetherPregnantNow"));
				
				medicoLegalDetails.setNoOfPregnancies(box.getInt("noOfPreviousPregnancies"));
				medicoLegalDetails.setTypeOfDelivery(box.getString("typeOfDeliveryOtherDetails"));
				medicoLegalDetails.setPregnant(box.getString("whetherPregnantNow"));
				
				medicoLegalDetails.setClothes(box.getString("clothes"));
				medicoLegalDetails.setWeight(box.getInt("weight"));
				medicoLegalDetails.setHeight(box.getInt("height"));
				medicoLegalDetails.setBuild(box.getString("build"));
				medicoLegalDetails.setMentalCondition(box.getString("mentalCondition"));
				
				
				medicoLegalDetails.setSecSexualChar(box.getString("secondarySexual"));
				medicoLegalDetails.setHair(box.getString("hairOther"));
				medicoLegalDetails.setHairOther(box.getString("hairOther"));
				medicoLegalDetails.setAppearanceOfLabia(box.getString("appearance"));
				
				medicoLegalDetails.setHymen(box.getString("hymen"));
				medicoLegalDetails.setTornCondition(box.getString("hymenOther"));
				medicoLegalDetails.setFresh(box.getString("Fresh"));
				medicoLegalDetails.setHymenTorn(box.getString("hymenTorn"));
				medicoLegalDetails.setFourchette(box.getString("fourchette"));
				medicoLegalDetails.setFourchetteDetails(box.getString("fourchetteDetails"));
				medicoLegalDetails.setPosteriorCommissure(box.getString("posteriorCommissure"));
				medicoLegalDetails.setPosteriorCommissureDetails(box.getString("posteriorCommissureDetails"));
				medicoLegalDetails.setVagina(box.getString("vagina"));
				medicoLegalDetails.setRugae(box.getString("rugae"));
				medicoLegalDetails.setDischarge(box.getString("discharge"));
				medicoLegalDetails.setDischargeDetails(box.getString("dischargePresent"));
				medicoLegalDetails.setInjuriesInVagina(box.getString("injuriesVagina"));
				medicoLegalDetails.setAppearanceOfPerineum(box.getString("perineum"));
				medicoLegalDetails.setPhyExamOther(box.getString("otherAny"));
				medicoLegalDetails.setInjuryOnBody(box.getString("injuriesOnTheBody"));
				medicoLegalDetails.setSysExaminationFindings(box.getString("systemicexamination"));
				
				medicoLegalDetails.setExaminationPlace(box.getString("placeExamination"));
				
				medicoLegalDetails.setExaminationTime(box.getString("examConcludedTime"));
				if(!box.getString("examinationConcludedDate").equals("")){
				medicoLegalDetails.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinationConcludedDate")));
				}
				medicoLegalDetails.setOpinion(box.getString("opinion"));
				
				medicoLegalDetails.setReasonForConclusion(box.getString("reasonForConclusion"));
				medicoLegalDetails.setMlcType("Examination of a female victim of sexual assault");

                if(box.getInt("inPatientId")!=0){
                    Inpatient inp=new Inpatient();
                   inp.setId(box.getInt("inPatientId"));
                    medicoLegalDetails.setInpatient(inp);	
                        }
				
				
				if(box.getInt("empId")!=0){
				MasEmployee doctor = new MasEmployee();
				doctor.setId(box.getInt("empId"));
				medicoLegalDetails.setDoctor(doctor);
				}
				
				if(box.getInt("userId")!=0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					medicoLegalDetails.setLastChgBy(users);
					}
				if(!box.getString(CHANGED_DATE).equals("")){
				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
				
				
				String srNo=box.getString("refMLNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
		 			if(sequenceNoList.size()>0){
		            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
		 			int orderNo = transactionSequence.getTransactionSequenceNumber();
		 			orderNo = orderNo + 1;
		 			int id = transactionSequence.getId();

		 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
		 			transactionSequence2.setTransactionSequenceNumber(orderNo);
		 			hbt.update(transactionSequence2);
		 			}else if (sequenceNoList.size() == 0) {
		 				TransactionSequence tsObj = new TransactionSequence();
		 				tsObj.setStatus("y");
		 				tsObj.setTransactionPrefix("EOF");
		 				tsObj.setTransactionSequenceName(transactionSequenceName);
		 				tsObj.setTransactionSequenceNumber(1);
		 				tsObj.setCreatedby("admin");
		 				tsObj.setStatus("y");
		 				MasHospital hospital= new MasHospital();
		 				hospital.setId(box.getInt("hospitalId"));
		 				tsObj.setHospital(hospital);
		 				tsObj.setFinanicalYear(yr);
		 				hbt.save(tsObj);
		 				
		 			}
	             
				
				hbt.save(medicoLegalDetails);
				
				int count = 0;
                if(box.getInt("hdb") != 0){
                    count = box.getInt("hdb");
                }
                
                for (int i = 1; i <= count; i++) {
                    MlcMaterialObjects materialObjects = new MlcMaterialObjects();
                    
                    if(box.getString("slNo"+i).equalsIgnoreCase("y")){
                        
                        
                        if(!box.getString("materialObjects"+i).equals("")){
                            materialObjects.setMaterialObjects(box.getString("materialObjects"+i));
                        }
                
				
				        
                        materialObjects.setMedicoLegalDetails(medicoLegalDetails);
						hbt.save(materialObjects);
				
                    }
				}
				successfullyAdded = true;

				medicoLegalDetailsId=medicoLegalDetails.getId();
            mlcType=medicoLegalDetails.getMlcType();

           hbt.update(wiseMlc); 
		 tx.commit();
			 }
			 else if (box.getString("flag").equalsIgnoreCase("authorization")) {
					
				 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
				           .add(Restrictions.eq("MlcType","Examination of a female victim of sexual assault"))
				           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

		            PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

		           if(wiseMlc!=null){
			          wiseMlc.setStatus("C");
		               }
					
					
					List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
					medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
							.list();
					 
				if(medicoLegalDetailsList.size()>0){
						MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
						
						
						if(box.getInt("hinId")!=0){
							Patient patient = new Patient();
							patient.setId(box.getInt("hinId"));
							medicoLegalDetails.setHin(patient);
							}
							
							medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
							if(!box.getString("refMLDate").equals("")){
							medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
							}
							if(box.getInt("detailId")!=0){
								OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
								opdPatientDetails.setId(box.getInt("detailId"));
								medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
								}
							medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
							medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
							medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
							medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
							medicoLegalDetails.setConsent(box.getString("consent"));
							medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
							
							medicoLegalDetails.setEducationalStatus(box.getString("educationalStatus"));
							medicoLegalDetails.setWitnesses1(box.getString("femaleWitness"));
							medicoLegalDetails.setHistoryByInjured(box.getString("statedBySubject"));
							medicoLegalDetails.setMaritalHistory(box.getString("maritalStatus"));
							medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
							medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
							medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
							if(!box.getString("commencementOfExaminationDate").equals("")){
							medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
							}
							medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
							
							if(!box.getString("allegedActDate").equals("")){
							medicoLegalDetails.setAllegedActDate(HMSUtil.convertStringTypeDateToDateType(box.getString("allegedActDate")));
							}
							medicoLegalDetails.setAllegedActTime(box.getString("allegedActTime"));
							medicoLegalDetails.setPlaceOfAct(box.getString("allegedActPlace"));
							
							medicoLegalDetails.setConsciousnessState(box.getString("stateOfConsciousness"));
							medicoLegalDetails.setInvolvedPersonNumber(box.getString("numberOfPerson"));
							medicoLegalDetails.setInvolvedPersonName(box.getString("nameOfPerson"));
							medicoLegalDetails.setDetailsOfPosition(box.getString("detailsOfPosition"));
							medicoLegalDetails.setDegreeOfViolence(box.getString("degreeOfViolence"));
							medicoLegalDetails.setPain(box.getString("Pain"));
							medicoLegalDetails.setUrinated(box.getString("urinated"));
							medicoLegalDetails.setAnyOtherInformation(box.getString("otherInformation"));
							medicoLegalDetails.setResistenceOffred(box.getString("resistanceOffered"));
							medicoLegalDetails.setReason(box.getString("resistanceOfferedNo"));
							medicoLegalDetails.setReasonDelayComplain(box.getString("reasonsForDelay"));
							medicoLegalDetails.setPreviousExp(box.getString("previousExperience"));
							medicoLegalDetails.setFrequency(box.getString("frequency"));
							if(!box.getString("address").equals("")){
								medicoLegalDetails.setPatientAddress(box.getString("address"));
						        }
							
								if(!box.getString("lastSexualActDate").equals("")){
							medicoLegalDetails.setLastSexualActDate(HMSUtil.convertStringTypeDateToDateType(box.getString("lastSexualActDate")));
							}
							medicoLegalDetails.setAgeOfMenarche(box.getString("ageOfMenarche"));
							medicoLegalDetails.setPeriods(box.getString("periods"));
							medicoLegalDetails.setMenstrualHistory(box.getString("menstrualHistory"));
							medicoLegalDetails.setMenstruatingNow(box.getString("whetherMmenstruatingNow"));
							
								if(!box.getString("dateOfLastMenstrualPeriod").equals("")){
							medicoLegalDetails.setLastMenstrualDate(HMSUtil.convertStringTypeDateToDateType(box.getString("dateOfLastMenstrualPeriod")));
							}
							medicoLegalDetails.setOtherHistory(box.getString("otherRelevantHistory"));
							medicoLegalDetails.setPregnant(box.getString("whetherPregnantNow"));
							
							medicoLegalDetails.setNoOfPregnancies(box.getInt("noOfPreviousPregnancies"));
							medicoLegalDetails.setTypeOfDelivery(box.getString("typeOfDeliveryOtherDetails"));
							medicoLegalDetails.setPregnant(box.getString("whetherPregnantNow"));
							
							medicoLegalDetails.setClothes(box.getString("clothes"));
							medicoLegalDetails.setWeight(box.getInt("weight"));
							medicoLegalDetails.setHeight(box.getInt("height"));
							medicoLegalDetails.setBuild(box.getString("build"));
							medicoLegalDetails.setMentalCondition(box.getString("mentalCondition"));
							
							
							medicoLegalDetails.setSecSexualChar(box.getString("secondarySexual"));
							medicoLegalDetails.setHair(box.getString("hairOther"));
							medicoLegalDetails.setAppearanceOfLabia(box.getString("appearance"));
							
							medicoLegalDetails.setHymen(box.getString("hymen"));
							medicoLegalDetails.setTornCondition(box.getString("hymenOther"));
							
							medicoLegalDetails.setFourchette(box.getString("fourchette"));
							medicoLegalDetails.setFourchetteDetails(box.getString("fourchetteDetails"));
							medicoLegalDetails.setPosteriorCommissure(box.getString("posteriorCommissure"));
							medicoLegalDetails.setPosteriorCommissureDetails(box.getString("posteriorCommissureDetails"));
							medicoLegalDetails.setVagina(box.getString("vagina"));
							medicoLegalDetails.setRugae(box.getString("rugae"));
							medicoLegalDetails.setDischarge(box.getString("discharge"));
							medicoLegalDetails.setDischargeDetails(box.getString("dischargePresent"));
							medicoLegalDetails.setInjuriesInVagina(box.getString("injuriesVagina"));
							medicoLegalDetails.setAppearanceOfPerineum(box.getString("perineum"));
							medicoLegalDetails.setPhyExamOther(box.getString("otherAny"));
							medicoLegalDetails.setInjuryOnBody(box.getString("injuriesOnTheBody"));
							medicoLegalDetails.setSysExaminationFindings(box.getString("systemicexamination"));
							
							medicoLegalDetails.setExaminationPlace(box.getString("placeExamination"));
							
							medicoLegalDetails.setExaminationTime(box.getString("examConcludedTime"));
							if(!box.getString("examinationConcludedDate").equals("")){
							medicoLegalDetails.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinationConcludedDate")));
							}
							medicoLegalDetails.setOpinion(box.getString("opinion"));
							
							medicoLegalDetails.setReasonForConclusion(box.getString("reasonForConclusion"));
							medicoLegalDetails.setMlcType("Examination of a female victim of sexual assault");

			                if(box.getInt("inPatientId")!=0){
			                    Inpatient inp=new Inpatient();
			                   inp.setId(box.getInt("inPatientId"));
			                    medicoLegalDetails.setInpatient(inp);	
			                        }
							
							
							if(box.getInt("empId")!=0){
							MasEmployee doctor = new MasEmployee();
							doctor.setId(box.getInt("empId"));
							medicoLegalDetails.setDoctor(doctor);
							}
							
							if(box.getInt("userId")!=0){
								Users users = new Users();
								users.setId(box.getInt("userId"));
								medicoLegalDetails.setLastChgBy(users);
								}
							if(!box.getString(CHANGED_DATE).equals("")){
							medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
							}
							medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
							
							

							int count = 0;
			                if(box.getInt("hdb") != 0){
			                    count = box.getInt("hdb");
			                }
			         	  	materialObjectsList = session
				 					.createCriteria(MlcMaterialObjects.class)
				 					.createAlias("MedicoLegalDetails", "ml")
						 			.add(Restrictions.eq("ml.Id", box.getInt("mediCoId")))
				 							.list();
				 			if(materialObjectsList.size()>0){
								hbt.deleteAll(materialObjectsList);
				 				
				 			}
			                for (int i = 1; i <= count; i++) {

			               
			                	
						 		MlcMaterialObjects materialObjects = new MlcMaterialObjects();
			                    if(box.getString("slNo"+i).equalsIgnoreCase("y")){
			                        
			                        
			                        if(!box.getString("materialObjects"+i).equals("")){
			                            materialObjects.setMaterialObjects(box.getString("materialObjects"+i));
			                        }
			                
							
							        
			                        materialObjects.setMedicoLegalDetails(medicoLegalDetails);
									hbt.save(materialObjects);
							      
			                    	
			                    }
							}
				        
				    	hbt.update(wiseMlc);
						hbt.saveOrUpdate(medicoLegalDetails);
						mlcType=medicoLegalDetails.getMlcType();
						medicoLegalDetailsId=medicoLegalDetails.getId();	
						successfullyAdded = true;
						tx.commit();
				}
				else {

					MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
					if(box.getInt("hinId")!=0){
					Patient patient = new Patient();
					patient.setId(box.getInt("hinId"));
					medicoLegalDetails.setHin(patient);
					}
					
					medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
					if(!box.getString("refMLDate").equals("")){
					medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
					}
					if(box.getInt("detailId")!=0){
						OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
						opdPatientDetails.setId(box.getInt("detailId"));
						medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
						}
					medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
					medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
					medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
					medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
					medicoLegalDetails.setConsent(box.getString("consent"));
					medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
					
					medicoLegalDetails.setEducationalStatus(box.getString("educationalStatus"));
					medicoLegalDetails.setWitnesses1(box.getString("femaleWitness"));
					medicoLegalDetails.setHistoryByInjured(box.getString("statedBySubject"));
					medicoLegalDetails.setMaritalHistory(box.getString("maritalStatus"));
					medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
					medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
					medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
					if(!box.getString("commencementOfExaminationDate").equals("")){
					medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
					}
					medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
					
					if(!box.getString("allegedActDate").equals("")){
					medicoLegalDetails.setAllegedActDate(HMSUtil.convertStringTypeDateToDateType(box.getString("allegedActDate")));
					}
					medicoLegalDetails.setAllegedActTime(box.getString("allegedActTime"));
					medicoLegalDetails.setPlaceOfAct(box.getString("allegedActPlace"));
					
					medicoLegalDetails.setConsciousnessState(box.getString("stateOfConsciousness"));
					medicoLegalDetails.setInvolvedPersonNumber(box.getString("numberOfPerson"));
					medicoLegalDetails.setInvolvedPersonName(box.getString("nameOfPerson"));
					medicoLegalDetails.setDetailsOfPosition(box.getString("detailsOfPosition"));
					medicoLegalDetails.setDegreeOfViolence(box.getString("degreeOfViolence"));
					medicoLegalDetails.setPain(box.getString("Pain"));
					medicoLegalDetails.setUrinated(box.getString("urinated"));
					medicoLegalDetails.setAnyOtherInformation(box.getString("otherInformation"));
					medicoLegalDetails.setResistenceOffred(box.getString("resistanceOffered"));
					medicoLegalDetails.setReason(box.getString("resistanceOfferedNo"));
					medicoLegalDetails.setReasonDelayComplain(box.getString("reasonsForDelay"));
					medicoLegalDetails.setPreviousExp(box.getString("previousExperience"));
					medicoLegalDetails.setFrequency(box.getString("frequency"));
					if(!box.getString("address").equals("")){
						medicoLegalDetails.setPatientAddress(box.getString("address"));
				        }
					
						if(!box.getString("lastSexualActDate").equals("")){
					medicoLegalDetails.setLastSexualActDate(HMSUtil.convertStringTypeDateToDateType(box.getString("lastSexualActDate")));
					}
					medicoLegalDetails.setAgeOfMenarche(box.getString("ageOfMenarche"));
					medicoLegalDetails.setPeriods(box.getString("periods"));
					medicoLegalDetails.setMenstrualHistory(box.getString("menstrualHistory"));
					medicoLegalDetails.setMenstruatingNow(box.getString("whetherMmenstruatingNow"));
					
						if(!box.getString("dateOfLastMenstrualPeriod").equals("")){
					medicoLegalDetails.setLastMenstrualDate(HMSUtil.convertStringTypeDateToDateType(box.getString("dateOfLastMenstrualPeriod")));
					}
					medicoLegalDetails.setOtherHistory(box.getString("otherRelevantHistory"));
					medicoLegalDetails.setPregnant(box.getString("whetherPregnantNow"));
					
					medicoLegalDetails.setNoOfPregnancies(box.getInt("noOfPreviousPregnancies"));
					medicoLegalDetails.setTypeOfDelivery(box.getString("typeOfDeliveryOtherDetails"));
					medicoLegalDetails.setPregnant(box.getString("whetherPregnantNow"));
					
					medicoLegalDetails.setClothes(box.getString("clothes"));
					medicoLegalDetails.setWeight(box.getInt("weight"));
					medicoLegalDetails.setHeight(box.getInt("height"));
					medicoLegalDetails.setBuild(box.getString("build"));
					medicoLegalDetails.setMentalCondition(box.getString("mentalCondition"));
					
					
					medicoLegalDetails.setSecSexualChar(box.getString("secondarySexual"));
					medicoLegalDetails.setHair(box.getString("hairOther"));
					medicoLegalDetails.setAppearanceOfLabia(box.getString("appearance"));
					
					medicoLegalDetails.setHymen(box.getString("hymen"));
					medicoLegalDetails.setTornCondition(box.getString("hymenOther"));
					
					medicoLegalDetails.setFourchette(box.getString("fourchette"));
					medicoLegalDetails.setFourchetteDetails(box.getString("fourchetteDetails"));
					medicoLegalDetails.setPosteriorCommissure(box.getString("posteriorCommissure"));
					medicoLegalDetails.setPosteriorCommissureDetails(box.getString("posteriorCommissureDetails"));
					medicoLegalDetails.setVagina(box.getString("vagina"));
					medicoLegalDetails.setRugae(box.getString("rugae"));
					medicoLegalDetails.setDischarge(box.getString("discharge"));
					medicoLegalDetails.setDischargeDetails(box.getString("dischargePresent"));
					medicoLegalDetails.setInjuriesInVagina(box.getString("injuriesVagina"));
					medicoLegalDetails.setAppearanceOfPerineum(box.getString("perineum"));
					medicoLegalDetails.setPhyExamOther(box.getString("otherAny"));
					medicoLegalDetails.setInjuryOnBody(box.getString("injuriesOnTheBody"));
					medicoLegalDetails.setSysExaminationFindings(box.getString("systemicexamination"));
					
					medicoLegalDetails.setExaminationPlace(box.getString("placeExamination"));
					
					medicoLegalDetails.setExaminationTime(box.getString("examConcludedTime"));
					if(!box.getString("examinationConcludedDate").equals("")){
					medicoLegalDetails.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinationConcludedDate")));
					}
					medicoLegalDetails.setOpinion(box.getString("opinion"));
					
					medicoLegalDetails.setReasonForConclusion(box.getString("reasonForConclusion"));
					medicoLegalDetails.setMlcType("Examination of a female victim of sexual assault");

	                if(box.getInt("inPatientId")!=0){
	                    Inpatient inp=new Inpatient();
	                   inp.setId(box.getInt("inPatientId"));
	                    medicoLegalDetails.setInpatient(inp);	
	                        }
					
					
					if(box.getInt("empId")!=0){
					MasEmployee doctor = new MasEmployee();
					doctor.setId(box.getInt("empId"));
					medicoLegalDetails.setDoctor(doctor);
					}
					
					if(box.getInt("userId")!=0){
						Users users = new Users();
						users.setId(box.getInt("userId"));
						medicoLegalDetails.setLastChgBy(users);
						}
					if(!box.getString(CHANGED_DATE).equals("")){
					medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					}
					medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
					
					String srNo=box.getString("refMLNo");
					String yr = "";
					if(srNo!=null){ 
							 yr = srNo.substring(4, 8);
							
					}				
					sequenceNoList = session
			 					.createCriteria(TransactionSequence.class)
			 					.add(Restrictions.eq("TransactionSequenceName",
			 							transactionSequenceName))
			 							.createAlias("Hospital", "hosp")
					 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
					 			.add(Restrictions.eq("FinanicalYear", yr))
			 							.list();
					
					
			 			if(sequenceNoList.size()>0){
			            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
			 			int orderNo = transactionSequence.getTransactionSequenceNumber();
			 			orderNo = orderNo + 1;
			 			int id = transactionSequence.getId();

			 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
			 			transactionSequence2.setTransactionSequenceNumber(orderNo);
			 			hbt.update(transactionSequence2);
			 			}else if (sequenceNoList.size() == 0) {
			 				TransactionSequence tsObj = new TransactionSequence();
			 				tsObj.setStatus("y");
			 				tsObj.setTransactionPrefix("EOF");
			 				tsObj.setTransactionSequenceName(transactionSequenceName);
			 				tsObj.setTransactionSequenceNumber(1);
			 				tsObj.setCreatedby("admin");
			 				tsObj.setStatus("y");
			 				MasHospital hospital= new MasHospital();
			 				hospital.setId(box.getInt("hospitalId"));
			 				tsObj.setHospital(hospital);
			 				tsObj.setFinanicalYear(yr);
			 				hbt.save(tsObj);
			 				
			 			}
		             
					
					hbt.save(medicoLegalDetails);
					
					int count = 0;
	                if(box.getInt("hdb") != 0){
	                    count = box.getInt("hdb");
	                }
	                
	                for (int i = 1; i <= count; i++) {
	                    MlcMaterialObjects materialObjects = new MlcMaterialObjects();
	                    
	                    if(box.getString("slNo"+i).equalsIgnoreCase("y")){
	                        
	                        
	                        if(!box.getString("materialObjects"+i).equals("")){
	                            materialObjects.setMaterialObjects(box.getString("materialObjects"+i));
	                        }
	                
					
					        
	                        materialObjects.setMedicoLegalDetails(medicoLegalDetails);
							hbt.save(materialObjects);
					
	                    }
					}
					successfullyAdded = true;

					medicoLegalDetailsId=medicoLegalDetails.getId();
	            mlcType=medicoLegalDetails.getMlcType();

	           hbt.update(wiseMlc); 
			 tx.commit();
					
				}
				report="need report";
			 }
	}catch (DataAccessException e) {
		e.printStackTrace();
		if(tx==null){
			tx.rollback();	
		}
	}
	//map = showUHIDJsp();
	map.put("successfullyAdded", successfullyAdded);
	map.put("medicoLegalDetailsId", medicoLegalDetailsId);
	map.put("mlcType", mlcType);
	map.put("message", message);
	map.put("report", report);
	return map;
	}
	@Override
	public Map<String, Object> addExamOfVictimOfUnnaturalSexualOffence(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		PatientWiseMlc patientWiseMlc=null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session= (Session) getSession();
		Transaction tx=null;
		String message ="";
		int medicoLegalDetailsId=0;
		String mlcType="";
		String report="";
		String transactionSequenceName = "ExamOfVictimOfUnnaturalSexual";
		List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
		List<MlcMaterialObjects> materialObjectsList = new ArrayList<MlcMaterialObjects>();
		try {
                 tx = session.beginTransaction();
                 if(box.getString("flag").equalsIgnoreCase("submit")){
         			
			
                 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
      		           .add(Restrictions.eq("MlcType","Examination of a victim of unnatural sexual offence"))
      		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

               PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

                if(wiseMlc!=null){
      	            wiseMlc.setStatus("AT");
                       }
		
			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
				if(box.getInt("hinId")!=0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				medicoLegalDetails.setHin(patient);
				}
				if(box.getInt("detailId")!=0){
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(box.getInt("detailId"));
					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
					}
				
				medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
				if(!box.getString("refMLDate").equals("")){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
				}
				medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
				medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
				medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
				medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
				medicoLegalDetails.setConsent(box.getString("consent"));
				if(!box.getString("requisitionDate").equals("")){
				medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
				}
				medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
				
				medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
				medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
				if(!box.getString("commencementOfExaminationDate").equals("")){
				medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
				}
				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
				
				
				medicoLegalDetails.setHistoryByInjured(box.getString("statedBySubject"));
				medicoLegalDetails.setExaminationPlace(box.getString("placeExamination"));
	
				medicoLegalDetails.setChangedClothing(box.getString("changedClothing"));
				medicoLegalDetails.setBathed(box.getString("bathed"));
				medicoLegalDetails.setMouthWashed(box.getString("washed"));
				medicoLegalDetails.setVomiting(box.getString("vomiting"));
				medicoLegalDetails.setPain(box.getString("pain"));
				medicoLegalDetails.setBleedingFromAnus(box.getString("bleeding"));
				medicoLegalDetails.setLossOfConsciousness(box.getString("consciousness"));
				
				if(!box.getString("address").equals("")){
					medicoLegalDetails.setPatientAddress(box.getString("address"));
			        }
				
				medicoLegalDetails.setWeight(box.getInt("weight"));
				medicoLegalDetails.setHeight(box.getInt("height"));
				medicoLegalDetails.setBuild(box.getString("build"));
				medicoLegalDetails.setMentalCondition(box.getString("mentalCondition"));
				medicoLegalDetails.setClothes(box.getString("clothes"));
				medicoLegalDetails.setGait(box.getString("gait"));
				medicoLegalDetails.setLipsOralCavity(box.getString("lips"));
				medicoLegalDetails.setAnalMucosa(box.getString("anusAnalMucosa"));
				medicoLegalDetails.setTears(box.getString("tears"));
				medicoLegalDetails.setTearsDetails(box.getString("tearsPresent"));
				medicoLegalDetails.setDepressionAnus(box.getString("depressionOfAnus"));
				medicoLegalDetails.setHemorrhoids(box.getString("hemorrhoids"));
				medicoLegalDetails.setBimanualLateral(box.getString("bimanualLateral"));
				medicoLegalDetails.setStainsBloodSemenLub(box.getString("stains"));
				medicoLegalDetails.setAnalSphincter(box.getString("analSphincter"));
				medicoLegalDetails.setSphincterTone(box.getString("sphincterTone"));
				medicoLegalDetails.setEvidenceStd(box.getString("evidenceOfSTD"));
				medicoLegalDetails.setRectalExamSpeculum(box.getString("rectal"));
				medicoLegalDetails.setInnerThighRegionsPereneum(box.getString("inner"));
				
				medicoLegalDetails.setPenis(box.getString("penis"));
				medicoLegalDetails.setScrotum(box.getString("scrotum"));
				
				
				medicoLegalDetails.setInjuryOnBody(box.getString("injuriesOnTheBody"));
				medicoLegalDetails.setSysExaminationFindings(box.getString("systemicExaminationFindings"));
				medicoLegalDetails.setOpinion(box.getString("opinion"));

                  if(box.getInt("inPatientId")!=0){
                         Inpatient inp=new Inpatient();
                        inp.setId(box.getInt("inPatientId"));
                           medicoLegalDetails.setInpatient(inp);	
                 }
				
				medicoLegalDetails.setMlcType("Examination of a victim of unnatural sexual offence");
				
				if(box.getInt("empId")!=0){
				MasEmployee doctor = new MasEmployee();
				doctor.setId(box.getInt("empId"));
				medicoLegalDetails.setDoctor(doctor);
				}
				
				if(box.getInt("userId")!=0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					medicoLegalDetails.setLastChgBy(users);
					}
				if(!box.getString(CHANGED_DATE).equals("")){
				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
				

				String srNo=box.getString("refMLNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
		 			if(sequenceNoList.size()>0){
		            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
		 			int orderNo = transactionSequence.getTransactionSequenceNumber();
		 			orderNo = orderNo + 1;
		 			int id = transactionSequence.getId();

		 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
		 			transactionSequence2.setTransactionSequenceNumber(orderNo);
		 			hbt.update(transactionSequence2);
		 			}else if (sequenceNoList.size() == 0) {
		 				TransactionSequence tsObj = new TransactionSequence();
		 				tsObj.setStatus("y");
		 				tsObj.setTransactionPrefix("EOV");
		 				tsObj.setTransactionSequenceName(transactionSequenceName);
		 				tsObj.setTransactionSequenceNumber(1);
		 				tsObj.setCreatedby("admin");
		 				tsObj.setStatus("y");
		 				MasHospital hospital= new MasHospital();
		 				hospital.setId(box.getInt("hospitalId"));
		 				tsObj.setHospital(hospital);
		 				tsObj.setFinanicalYear(yr);

		 				hbt.save(tsObj);
		 				
		 			}
	             
	 			
				hbt.update(wiseMlc);
				hbt.save(medicoLegalDetails);
				tx.commit();
				int count = 0;
                if(box.getInt("hdb") != 0){
                    count = box.getInt("hdb");
                }
                
                for (int i = 1; i <= count; i++) {
                    MlcMaterialObjects materialObjects = new MlcMaterialObjects();
                    
                    if(box.getString("slNo"+i).equalsIgnoreCase("y")){
                        
                        
                        if(!box.getString("materialObjects"+i).equals("")){
                            materialObjects.setMaterialObjects(box.getString("materialObjects"+i));
                        }
                
				
				        
                        materialObjects.setMedicoLegalDetails(medicoLegalDetails);
						hbt.save(materialObjects);
				
                    }
					}
				successfullyAdded = true;
				medicoLegalDetailsId=medicoLegalDetails.getId();
                mlcType=medicoLegalDetails.getMlcType();
			
                 }
                 else if (box.getString("flag").equalsIgnoreCase("authorization")) {
         			
            		 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
            		           .add(Restrictions.eq("MlcType","Examination of a victim of unnatural sexual offence"))
            		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

                        PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

                       if(wiseMlc!=null){
            	          wiseMlc.setStatus("C");
                           }
            			
            			
            			List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
            			medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
            					.list();
            			 
            		if(medicoLegalDetailsList.size()>0){
            				MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
            				
            				if(box.getInt("hinId")!=0){
                				Patient patient = new Patient();
                				patient.setId(box.getInt("hinId"));
                				medicoLegalDetails.setHin(patient);
                				}
                				if(box.getInt("detailId")!=0){
                					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
                					opdPatientDetails.setId(box.getInt("detailId"));
                					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
                					}
                				
                				medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
                				if(!box.getString("refMLDate").equals("")){
                				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
                				}
                				medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
                				medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
                				medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
                				medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
                				medicoLegalDetails.setConsent(box.getString("consent"));
                				if(!box.getString("requisitionDate").equals("")){
                				medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
                				}
                				medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
                				
                				medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
                				medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
                				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
                				if(!box.getString("commencementOfExaminationDate").equals("")){
                				medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
                				}
                				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
                				
                				
                				medicoLegalDetails.setHistoryByInjured(box.getString("statedBySubject"));
                				medicoLegalDetails.setExaminationPlace(box.getString("placeExamination"));
                	
                				medicoLegalDetails.setChangedClothing(box.getString("changedClothing"));
                				medicoLegalDetails.setBathed(box.getString("bathed"));
                				medicoLegalDetails.setMouthWashed(box.getString("washed"));
                				medicoLegalDetails.setVomiting(box.getString("vomiting"));
                				medicoLegalDetails.setPain(box.getString("pain"));
                				medicoLegalDetails.setBleedingFromAnus(box.getString("bleeding"));
                				medicoLegalDetails.setLossOfConsciousness(box.getString("consciousness"));
                				
                				if(!box.getString("address").equals("")){
                					medicoLegalDetails.setPatientAddress(box.getString("address"));
                			        }
                				
                				medicoLegalDetails.setWeight(box.getInt("weight"));
                				medicoLegalDetails.setHeight(box.getInt("height"));
                				medicoLegalDetails.setBuild(box.getString("build"));
                				medicoLegalDetails.setMentalCondition(box.getString("mentalCondition"));
                				medicoLegalDetails.setClothes(box.getString("clothes"));
                				medicoLegalDetails.setGait(box.getString("gait"));
                				medicoLegalDetails.setLipsOralCavity(box.getString("lips"));
                				medicoLegalDetails.setAnalMucosa(box.getString("anusAnalMucosa"));
                				medicoLegalDetails.setTears(box.getString("tears"));
                				medicoLegalDetails.setTearsDetails(box.getString("tearsPresent"));
                				medicoLegalDetails.setDepressionAnus(box.getString("depressionOfAnus"));
                				medicoLegalDetails.setHemorrhoids(box.getString("hemorrhoids"));
                				medicoLegalDetails.setBimanualLateral(box.getString("bimanualLateral"));
                				medicoLegalDetails.setStainsBloodSemenLub(box.getString("stains"));
                				medicoLegalDetails.setAnalSphincter(box.getString("analSphincter"));
                				medicoLegalDetails.setSphincterTone(box.getString("sphincterTone"));
                				medicoLegalDetails.setEvidenceStd(box.getString("evidenceOfSTD"));
                				medicoLegalDetails.setRectalExamSpeculum(box.getString("rectal"));
                				medicoLegalDetails.setInnerThighRegionsPereneum(box.getString("inner"));
                				
                				medicoLegalDetails.setPenis(box.getString("penis"));
                				medicoLegalDetails.setScrotum(box.getString("scrotum"));
                				
                				
                				medicoLegalDetails.setInjuryOnBody(box.getString("injuriesOnTheBody"));
                				medicoLegalDetails.setSysExaminationFindings(box.getString("systemicExaminationFindings"));
                				medicoLegalDetails.setOpinion(box.getString("opinion"));

                                  if(box.getInt("inPatientId")!=0){
                                         Inpatient inp=new Inpatient();
                                        inp.setId(box.getInt("inPatientId"));
                                           medicoLegalDetails.setInpatient(inp);	
                                 }
                				
                				medicoLegalDetails.setMlcType("Examination of a victim of unnatural sexual offence");
                				
                				if(box.getInt("empId")!=0){
                				MasEmployee doctor = new MasEmployee();
                				doctor.setId(box.getInt("empId"));
                				medicoLegalDetails.setDoctor(doctor);
                				}
                				
                				if(box.getInt("userId")!=0){
                					Users users = new Users();
                					users.setId(box.getInt("userId"));
                					medicoLegalDetails.setLastChgBy(users);
                					}
                				if(!box.getString(CHANGED_DATE).equals("")){
                				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
                				}
                				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
                				
                				
                				int count = 0;
    			                if(box.getInt("hdb") != 0){
    			                    count = box.getInt("hdb");
    			                }

		                	  	materialObjectsList = session
					 					.createCriteria(MlcMaterialObjects.class)
					 					.createAlias("MedicoLegalDetails", "ml")
							 			.add(Restrictions.eq("ml.Id", box.getInt("mediCoId")))
					 							.list();
					 			if(materialObjectsList.size()>0){
									hbt.deleteAll(materialObjectsList);
					 				
					 			}
    			                for (int i = 1; i <= count; i++) {

    			                	
    						 		MlcMaterialObjects materialObjects = new MlcMaterialObjects();
    			                    if(box.getString("slNo"+i).equalsIgnoreCase("y")){
    			                        
    			                        
    			                        if(!box.getString("materialObjects"+i).equals("")){
    			                            materialObjects.setMaterialObjects(box.getString("materialObjects"+i));
    			                        }
    			                
    							
    							        
    			                        materialObjects.setMedicoLegalDetails(medicoLegalDetails);
    									hbt.save(materialObjects);
    							      
    			                    	
    			                    }
    							}
    				        
    				    	hbt.update(wiseMlc);
    						hbt.saveOrUpdate(medicoLegalDetails);
    						mlcType=medicoLegalDetails.getMlcType();
    						medicoLegalDetailsId=medicoLegalDetails.getId();	
    						successfullyAdded = true;
    						tx.commit();
            				
            				
            		}
            		else {

            			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
        				if(box.getInt("hinId")!=0){
        				Patient patient = new Patient();
        				patient.setId(box.getInt("hinId"));
        				medicoLegalDetails.setHin(patient);
        				}
        				if(box.getInt("detailId")!=0){
        					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
        					opdPatientDetails.setId(box.getInt("detailId"));
        					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
        					}
        				
        				medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
        				if(!box.getString("refMLDate").equals("")){
        				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
        				}
        				medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
        				medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
        				medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
        				medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
        				medicoLegalDetails.setConsent(box.getString("consent"));
        				if(!box.getString("requisitionDate").equals("")){
        				medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
        				}
        				medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
        				
        				medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
        				medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
        				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
        				if(!box.getString("commencementOfExaminationDate").equals("")){
        				medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
        				}
        				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
        				
        				
        				medicoLegalDetails.setHistoryByInjured(box.getString("statedBySubject"));
        				medicoLegalDetails.setExaminationPlace(box.getString("placeExamination"));
        	
        				medicoLegalDetails.setChangedClothing(box.getString("changedClothing"));
        				medicoLegalDetails.setBathed(box.getString("bathed"));
        				medicoLegalDetails.setMouthWashed(box.getString("washed"));
        				medicoLegalDetails.setVomiting(box.getString("vomiting"));
        				medicoLegalDetails.setPain(box.getString("pain"));
        				medicoLegalDetails.setBleedingFromAnus(box.getString("bleeding"));
        				medicoLegalDetails.setLossOfConsciousness(box.getString("consciousness"));
        				
        				if(!box.getString("address").equals("")){
        					medicoLegalDetails.setPatientAddress(box.getString("address"));
        			        }
        				
        				medicoLegalDetails.setWeight(box.getInt("weight"));
        				medicoLegalDetails.setHeight(box.getInt("height"));
        				medicoLegalDetails.setBuild(box.getString("build"));
        				medicoLegalDetails.setMentalCondition(box.getString("mentalCondition"));
        				medicoLegalDetails.setClothes(box.getString("clothes"));
        				medicoLegalDetails.setGait(box.getString("gait"));
        				medicoLegalDetails.setLipsOralCavity(box.getString("lips"));
        				medicoLegalDetails.setAnalMucosa(box.getString("anusAnalMucosa"));
        				medicoLegalDetails.setTears(box.getString("tears"));
        				medicoLegalDetails.setTearsDetails(box.getString("tearsPresent"));
        				medicoLegalDetails.setDepressionAnus(box.getString("depressionOfAnus"));
        				medicoLegalDetails.setHemorrhoids(box.getString("hemorrhoids"));
        				medicoLegalDetails.setBimanualLateral(box.getString("bimanualLateral"));
        				medicoLegalDetails.setStainsBloodSemenLub(box.getString("stains"));
        				medicoLegalDetails.setAnalSphincter(box.getString("analSphincter"));
        				medicoLegalDetails.setSphincterTone(box.getString("sphincterTone"));
        				medicoLegalDetails.setEvidenceStd(box.getString("evidenceOfSTD"));
        				medicoLegalDetails.setRectalExamSpeculum(box.getString("rectal"));
        				medicoLegalDetails.setInnerThighRegionsPereneum(box.getString("inner"));
        				
        				medicoLegalDetails.setPenis(box.getString("penis"));
        				medicoLegalDetails.setScrotum(box.getString("scrotum"));
        				
        				
        				medicoLegalDetails.setInjuryOnBody(box.getString("injuriesOnTheBody"));
        				medicoLegalDetails.setSysExaminationFindings(box.getString("systemicExaminationFindings"));
        				medicoLegalDetails.setOpinion(box.getString("opinion"));

                          if(box.getInt("inPatientId")!=0){
                                 Inpatient inp=new Inpatient();
                                inp.setId(box.getInt("inPatientId"));
                                   medicoLegalDetails.setInpatient(inp);	
                         }
        				
        				medicoLegalDetails.setMlcType("Examination of a victim of unnatural sexual offence");
        				
        				if(box.getInt("empId")!=0){
        				MasEmployee doctor = new MasEmployee();
        				doctor.setId(box.getInt("empId"));
        				medicoLegalDetails.setDoctor(doctor);
        				}
        				
        				if(box.getInt("userId")!=0){
        					Users users = new Users();
        					users.setId(box.getInt("userId"));
        					medicoLegalDetails.setLastChgBy(users);
        					}
        				if(!box.getString(CHANGED_DATE).equals("")){
        				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
        				}
        				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));

			        					String srNo=box.getString("refMLNo");
							String yr = "";
							if(srNo!=null){ 
									 yr = srNo.substring(4, 8);
									
							}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
        				 
        		 			if(sequenceNoList.size()>0){
        		            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
        		 			int orderNo = transactionSequence.getTransactionSequenceNumber();
        		 			orderNo = orderNo + 1;
        		 			int id = transactionSequence.getId();

        		 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
        		 			transactionSequence2.setTransactionSequenceNumber(orderNo);
        		 			hbt.update(transactionSequence2);
        		 			}else if (sequenceNoList.size() == 0) {
        		 				TransactionSequence tsObj = new TransactionSequence();
        		 				tsObj.setStatus("y");
        		 				tsObj.setTransactionPrefix("EOV");
        		 				tsObj.setTransactionSequenceName(transactionSequenceName);
        		 				tsObj.setTransactionSequenceNumber(1);
        		 				tsObj.setCreatedby("admin");
        		 				tsObj.setStatus("y");
        		 				MasHospital hospital= new MasHospital();
        		 				hospital.setId(box.getInt("hospitalId"));
        		 				tsObj.setHospital(hospital);
        		 				tsObj.setFinanicalYear(yr);

        		 				hbt.save(tsObj);
        		 				
        		 			}
        	             
        	 			
        				hbt.update(wiseMlc);
        				hbt.save(medicoLegalDetails);
        				tx.commit();
        				int count = 0;
                        if(box.getInt("hdb") != 0){
                            count = box.getInt("hdb");
                        }
                        
                        for (int i = 1; i <= count; i++) {
                            MlcMaterialObjects materialObjects = new MlcMaterialObjects();
                            
                            if(box.getString("slNo"+i).equalsIgnoreCase("y")){
                                
                                
                                if(!box.getString("materialObjects"+i).equals("")){
                                    materialObjects.setMaterialObjects(box.getString("materialObjects"+i));
                                }
                        
        				
        				        
                                materialObjects.setMedicoLegalDetails(medicoLegalDetails);
        						hbt.save(materialObjects);
        				
                            }
        					}
        				successfullyAdded = true;
        				medicoLegalDetailsId=medicoLegalDetails.getId();
                        mlcType=medicoLegalDetails.getMlcType();
            			successfullyAdded = true;
            			tx.commit();
            	
            			
            		}
            		report="need report";
            	 }
            		 
		}catch (DataAccessException e) {
			e.printStackTrace();
			if(tx==null){
				tx.rollback();
			}
			
		}
		//map = showUHIDJsp();
		map.put("successfullyAdded", successfullyAdded);
		map.put("medicoLegalDetailsId", medicoLegalDetailsId);
		map.put("mlcType", mlcType);
		map.put("message", message);
		map.put("report", report);
		return map;
	}
	@Override
	public Map<String, Object> addExamOfEvidenceOfRecentDelivery(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		PatientWiseMlc mlcsList=null;
		PatientWiseMlc patientWiseMlc=null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session= (Session) getSession();
		String message ="";
		int medicoLegalDetailsId=0;
		String report="";
		String mlcType="";
		String transactionSequenceName = "ExamOfEvidenceOfRecentDelivery";
		List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
		Transaction tx=null;
		try {
			tx=session.beginTransaction(); 
			if(box.getString("flag").equalsIgnoreCase("submit")){
				
				
			 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
			           .add(Restrictions.eq("MlcType","Examination for evidence of recent delivery"))
			           .add(Restrictions.eq("OpdPatientDetail.Id",box.getInt("detailId"))).uniqueResult();

	         PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

	          if(wiseMlc!=null){
		            wiseMlc.setStatus("AT");
	                 }
		MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
				if(box.getInt("hinId")!=0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				medicoLegalDetails.setHin(patient);
				}
				if(box.getInt("detailId")!=0){
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(box.getInt("detailId"));
					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
					}
				medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
				if(!box.getString("refMLDate").equals("")){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
				}
				medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
				medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
				medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
				medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
				medicoLegalDetails.setConsent(box.getString("consent"));
				if(!box.getString("requisitionDate").equals("")){
				medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
				}
				medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
				medicoLegalDetails.setMaritalHistory(box.getString("maritalStatus"));
				medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
				medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
				if(!box.getString("commencementOfExaminationDate").equals("")){
				medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
				}
				if(!box.getString("address").equals("")){
					medicoLegalDetails.setPatientAddress(box.getString("address"));
			        }
				
				medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
				medicoLegalDetails.setWeight(box.getInt("weight"));
				medicoLegalDetails.setHeight(box.getInt("height"));
				medicoLegalDetails.setBuild(box.getString("build"));
				medicoLegalDetails.setOpinion(box.getString("opinion"));
		     	medicoLegalDetails.setMlcType("Examination for evidence of recent delivery");
		     	medicoLegalDetails.setConjunctiva(box.getString("conjunctivalPallor"));
		     	medicoLegalDetails.setSysExaminationFindings(box.getString("systemicexamination"));
		     	medicoLegalDetails.setUrinated(box.getString("pregnancy"));
		     	medicoLegalDetails.setAnyOtherInformation(box.getString("anyOther"));
		     	medicoLegalDetails.setBreasts(box.getString("breasts"));
		     	medicoLegalDetails.setAreolaNippal(box.getString("areolanipple"));
		     	medicoLegalDetails.setNippal(box.getString("nipple"));
		     	medicoLegalDetails.setAbdomin(box.getString("abdomen"));
		     	medicoLegalDetails.setStriaeGravidarum(box.getString("gravidarum"));
		     	medicoLegalDetails.setLabia(box.getString("labia"));
		     	medicoLegalDetails.setLabialTenderness(box.getString("tenderness"));
		     	medicoLegalDetails.setInjLabial(box.getString("injuriesToLabia"));
		     	medicoLegalDetails.setCervicalLips(box.getString("cervical"));
		     	medicoLegalDetails.setCervicalMucusPlug(box.getString("cervicalMucusPlug"));
		     	medicoLegalDetails.setExternalOs(box.getString("externalOs"));
		     	medicoLegalDetails.setInjCervical(box.getString("injuries"));
		     	medicoLegalDetails.setLochiaDischarge(box.getString("lochiaDischargeOs"));
		     	
		     	medicoLegalDetails.setUsgAbdomen(box.getString("usgAbdomen"));
		     	medicoLegalDetails.setMenstrualTime(box.getString("menstrualTime"));
		    
		     	
		       	medicoLegalDetails.setCervixInjDetail(box.getString("injuriesPresent"));
		    	medicoLegalDetails.setVaginaInjDetail(box.getString("injuriesToLabiaPresent"));
		    	medicoLegalDetails.setLochiaDischargeDetail(box.getString("lochiaDischargeOsPresent"));
		    	medicoLegalDetails.setAntenatalCheckup(box.getString("checkup"));
		    	if(box.getString("menstrualDate")!=null &&!box.getString("menstrualDate").equals("")){
		    	medicoLegalDetails.setLastMenstrualDate(HMSUtil.convertStringTypeDateToDateType(box.getString("menstrualDate")));
		    	}
		    	medicoLegalDetails.setMenstrualHistory((box.getString("menarche")));
		    	medicoLegalDetails.setVagina(box.getString("vagina"));
		    	medicoLegalDetails.setInjuriesInVagina(box.getString("injuriesToVagina"));
		    	medicoLegalDetails.setInjDetailVagina(box.getString("injuriesToVaginaPresent"));
		    	medicoLegalDetails.setAnyOtherDetail(box.getString("anyOtherDetail"));
		    	medicoLegalDetails.setUterusPalpable(box.getString("uterusPalpable"));
		    	medicoLegalDetails.setUterus(box.getString("uterus"));
		     	
				if(box.getInt("empId")!=0){
				MasEmployee doctor = new MasEmployee();
				doctor.setId(box.getInt("empId"));
				medicoLegalDetails.setDoctor(doctor);
				}

                       if(box.getInt("inPatientId")!=0){
                               Inpatient inp=new Inpatient();
                                 inp.setId(box.getInt("inPatientId"));
                              medicoLegalDetails.setInpatient(inp);	
                              }
				
				if(box.getInt("userId")!=0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					medicoLegalDetails.setLastChgBy(users);
					}
				if(!box.getString(CHANGED_DATE).equals("")){
				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
				 

String srNo=box.getString("refMLNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
		 			if(sequenceNoList.size()>0){
		            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
		 			int orderNo = transactionSequence.getTransactionSequenceNumber();
		 			orderNo = orderNo + 1;
		 			int id = transactionSequence.getId();

		 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
		 			transactionSequence2.setTransactionSequenceNumber(orderNo);
		 			hbt.update(transactionSequence2);
		 			}else if (sequenceNoList.size() == 0) {
		 				TransactionSequence tsObj = new TransactionSequence();
		 				tsObj.setStatus("y");
		 				tsObj.setTransactionPrefix("EOE");
		 				tsObj.setTransactionSequenceName(transactionSequenceName);
		 				tsObj.setTransactionSequenceNumber(1);
		 				tsObj.setCreatedby("admin");
		 				tsObj.setStatus("y");
		 				MasHospital hospital= new MasHospital();
		 				hospital.setId(box.getInt("hospitalId"));
		 				tsObj.setHospital(hospital);
		 				tsObj.setFinanicalYear(yr);
		 				hbt.save(tsObj);
		 				
		 			}
				hbt.save(medicoLegalDetails);
				hbt.update(wiseMlc);
				tx.commit();
				successfullyAdded = true;
				medicoLegalDetailsId=medicoLegalDetails.getId();
	            mlcType=medicoLegalDetails.getMlcType();
			}
			 else if (box.getString("flag").equalsIgnoreCase("authorization")) {
					
				 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
				           .add(Restrictions.eq("MlcType","Examination for evidence of recent delivery"))
				           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

		            PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

		           if(wiseMlc!=null){
			          wiseMlc.setStatus("C");
		               }
					
					
					List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
					medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
							.list();
					 
				if(medicoLegalDetailsList.size()>0){
						MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
						
						
						if(box.getInt("hinId")!=0){
							Patient patient = new Patient();
							patient.setId(box.getInt("hinId"));
							medicoLegalDetails.setHin(patient);
							}
							if(box.getInt("detailId")!=0){
								OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
								opdPatientDetails.setId(box.getInt("detailId"));
								medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
								}
							medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
							if(!box.getString("refMLDate").equals("")){
							medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
							}
							medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
							medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
							medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
							medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
							medicoLegalDetails.setConsent(box.getString("consent"));
							if(!box.getString("requisitionDate").equals("")){
							medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
							}
							medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
							medicoLegalDetails.setMaritalHistory(box.getString("maritalStatus"));
							medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
							medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
							medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
							if(!box.getString("commencementOfExaminationDate").equals("")){
							medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
							}
							if(!box.getString("address").equals("")){
								medicoLegalDetails.setPatientAddress(box.getString("address"));
						        }
							
							medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
							medicoLegalDetails.setWeight(box.getInt("weight"));
							medicoLegalDetails.setHeight(box.getInt("height"));
							medicoLegalDetails.setBuild(box.getString("build"));
							medicoLegalDetails.setOpinion(box.getString("opinion"));
					     	medicoLegalDetails.setMlcType("Examination for evidence of recent delivery");
					     	medicoLegalDetails.setConjunctiva(box.getString("conjunctivalPallor"));
					     	medicoLegalDetails.setSysExaminationFindings(box.getString("systemicexamination"));
					     	medicoLegalDetails.setUrinated(box.getString("pregnancy"));
					     	medicoLegalDetails.setAnyOtherInformation(box.getString("anyOther"));
					     	medicoLegalDetails.setBreasts(box.getString("breasts"));
					     	medicoLegalDetails.setAreolaNippal(box.getString("areolanipple"));
					     	medicoLegalDetails.setNippal(box.getString("nipple"));
					     	medicoLegalDetails.setAbdomin(box.getString("abdomen"));
					     	medicoLegalDetails.setStriaeGravidarum(box.getString("gravidarum"));
					     	medicoLegalDetails.setLabia(box.getString("labia"));
					     	medicoLegalDetails.setLabialTenderness(box.getString("tenderness"));
					     	medicoLegalDetails.setInjLabial(box.getString("injuriesToLabia"));
					     	medicoLegalDetails.setCervicalLips(box.getString("cervical"));
					     	medicoLegalDetails.setCervicalMucusPlug(box.getString("cervicalMucusPlug"));
					     	medicoLegalDetails.setExternalOs(box.getString("externalOs"));
					     	medicoLegalDetails.setInjCervical(box.getString("injuries"));
					     	medicoLegalDetails.setLochiaDischarge(box.getString("lochiaDischargeOs"));
					     	
					     	medicoLegalDetails.setUsgAbdomen(box.getString("usgAbdomen"));
					     	medicoLegalDetails.setMenstrualTime(box.getString("menstrualTime"));
					    
					     	
					       	medicoLegalDetails.setCervixInjDetail(box.getString("injuriesPresent"));
					    	medicoLegalDetails.setVaginaInjDetail(box.getString("injuriesToLabiaPresent"));
					    	medicoLegalDetails.setLochiaDischargeDetail(box.getString("lochiaDischargeOsPresent"));
					    	medicoLegalDetails.setAntenatalCheckup(box.getString("checkup"));
					    	if(box.getString("menstrualDate")!=null &&!box.getString("menstrualDate").equals("")){
					    	medicoLegalDetails.setLastMenstrualDate(HMSUtil.convertStringTypeDateToDateType(box.getString("menstrualDate")));
					    	}
					    	medicoLegalDetails.setMenstrualHistory((box.getString("menarche")));
					    	medicoLegalDetails.setVagina(box.getString("vagina"));
					    	medicoLegalDetails.setInjuriesInVagina(box.getString("injuriesToVagina"));
					    	medicoLegalDetails.setInjDetailVagina(box.getString("injuriesToVaginaPresent"));
					    	medicoLegalDetails.setAnyOtherDetail(box.getString("anyOtherDetail"));
					    	medicoLegalDetails.setUterusPalpable(box.getString("uterusPalpable"));
					    	medicoLegalDetails.setUterus(box.getString("uterus"));
					     	
							if(box.getInt("empId")!=0){
							MasEmployee doctor = new MasEmployee();
							doctor.setId(box.getInt("empId"));
							medicoLegalDetails.setDoctor(doctor);
							}

			                       if(box.getInt("inPatientId")!=0){
			                               Inpatient inp=new Inpatient();
			                                 inp.setId(box.getInt("inPatientId"));
			                              medicoLegalDetails.setInpatient(inp);	
			                              }
							
							if(box.getInt("userId")!=0){
								Users users = new Users();
								users.setId(box.getInt("userId"));
								medicoLegalDetails.setLastChgBy(users);
								}
							if(!box.getString(CHANGED_DATE).equals("")){
							medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
							}
							medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
							 
			                
			            
				        
				    	hbt.update(wiseMlc);
						hbt.saveOrUpdate(medicoLegalDetails);
						mlcType=medicoLegalDetails.getMlcType();
						medicoLegalDetailsId=medicoLegalDetails.getId();	
						successfullyAdded = true;
						tx.commit();
				}
				else {

					MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
					if(box.getInt("hinId")!=0){
						Patient patient = new Patient();
						patient.setId(box.getInt("hinId"));
						medicoLegalDetails.setHin(patient);
						}
						if(box.getInt("detailId")!=0){
							OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
							opdPatientDetails.setId(box.getInt("detailId"));
							medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
							}
						medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
						if(!box.getString("refMLDate").equals("")){
						medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
						}
						medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
						medicoLegalDetails.setPoliceStation(box.getString("policeStation"));						
						medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
						medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
						medicoLegalDetails.setConsent(box.getString("consent"));
						if(!box.getString("requisitionDate").equals("")){
						medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
						}
						medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
						medicoLegalDetails.setMaritalHistory(box.getString("maritalStatus"));
						medicoLegalDetails.setAccompByAddress(box.getString("accompaniedByAddress"));
						medicoLegalDetails.setAccompByName(box.getString("accompaniedByName"));
						medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
						if(!box.getString("commencementOfExaminationDate").equals("")){
						medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencementOfExaminationDate")));
						}
						if(!box.getString("address").equals("")){
							medicoLegalDetails.setPatientAddress(box.getString("address"));
					        }
						
						medicoLegalDetails.setExamCommTime(box.getString("commencementOfExaminationTime"));
						medicoLegalDetails.setWeight(box.getInt("weight"));
						medicoLegalDetails.setHeight(box.getInt("height"));
						medicoLegalDetails.setBuild(box.getString("build"));
						medicoLegalDetails.setOpinion(box.getString("opinion"));
				     	medicoLegalDetails.setMlcType("Examination for evidence of recent delivery");
				     	medicoLegalDetails.setConjunctiva(box.getString("conjunctivalPallor"));
				     	medicoLegalDetails.setSysExaminationFindings(box.getString("systemicexamination"));
				     	medicoLegalDetails.setUrinated(box.getString("pregnancy"));
				     	medicoLegalDetails.setAnyOtherInformation(box.getString("anyOther"));
				     	medicoLegalDetails.setBreasts(box.getString("breasts"));
				     	medicoLegalDetails.setAreolaNippal(box.getString("areolanipple"));
				     	medicoLegalDetails.setNippal(box.getString("nipple"));
				     	medicoLegalDetails.setAbdomin(box.getString("abdomen"));
				     	medicoLegalDetails.setStriaeGravidarum(box.getString("gravidarum"));
				     	medicoLegalDetails.setLabia(box.getString("labia"));
				     	medicoLegalDetails.setLabialTenderness(box.getString("tenderness"));
				     	medicoLegalDetails.setInjLabial(box.getString("injuriesToLabia"));
				     	medicoLegalDetails.setCervicalLips(box.getString("cervical"));
				     	medicoLegalDetails.setCervicalMucusPlug(box.getString("cervicalMucusPlug"));
				     	medicoLegalDetails.setExternalOs(box.getString("externalOs"));
				     	medicoLegalDetails.setInjCervical(box.getString("injuries"));
				     	medicoLegalDetails.setLochiaDischarge(box.getString("lochiaDischargeOs"));
				     	
				     	medicoLegalDetails.setUsgAbdomen(box.getString("usgAbdomen"));
				     	medicoLegalDetails.setMenstrualTime(box.getString("menstrualTime"));
				    
				     	
				       	medicoLegalDetails.setCervixInjDetail(box.getString("injuriesPresent"));
				    	medicoLegalDetails.setVaginaInjDetail(box.getString("injuriesToLabiaPresent"));
				    	medicoLegalDetails.setLochiaDischargeDetail(box.getString("lochiaDischargeOsPresent"));
				    	medicoLegalDetails.setAntenatalCheckup(box.getString("checkup"));
				    	if(box.getString("menstrualDate")!=null &&!box.getString("menstrualDate").equals("")){
				    	medicoLegalDetails.setLastMenstrualDate(HMSUtil.convertStringTypeDateToDateType(box.getString("menstrualDate")));
				    	}
				    	medicoLegalDetails.setMenstrualHistory((box.getString("menarche")));
				    	medicoLegalDetails.setVagina(box.getString("vagina"));
				    	medicoLegalDetails.setInjuriesInVagina(box.getString("injuriesToVagina"));
				    	medicoLegalDetails.setInjDetailVagina(box.getString("injuriesToVaginaPresent"));
				    	medicoLegalDetails.setAnyOtherDetail(box.getString("anyOtherDetail"));
				    	medicoLegalDetails.setUterusPalpable(box.getString("uterusPalpable"));
				    	medicoLegalDetails.setUterus(box.getString("uterus"));
				     	
						if(box.getInt("empId")!=0){
						MasEmployee doctor = new MasEmployee();
						doctor.setId(box.getInt("empId"));
						medicoLegalDetails.setDoctor(doctor);
						}

		                       if(box.getInt("inPatientId")!=0){
		                               Inpatient inp=new Inpatient();
		                                 inp.setId(box.getInt("inPatientId"));
		                              medicoLegalDetails.setInpatient(inp);	
		                              }
						
						if(box.getInt("userId")!=0){
							Users users = new Users();
							users.setId(box.getInt("userId"));
							medicoLegalDetails.setLastChgBy(users);
							}
						if(!box.getString(CHANGED_DATE).equals("")){
						medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
						}
						medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
						 

							String srNo=box.getString("refMLNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
				 			if(sequenceNoList.size()>0){
				            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
				 			int orderNo = transactionSequence.getTransactionSequenceNumber();
				 			orderNo = orderNo + 1;
				 			int id = transactionSequence.getId();

				 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
				 			transactionSequence2.setTransactionSequenceNumber(orderNo);
				 			hbt.update(transactionSequence2);
				 			}else if (sequenceNoList.size() == 0) {
				 				TransactionSequence tsObj = new TransactionSequence();
				 				tsObj.setStatus("y");
				 				tsObj.setTransactionPrefix("EOE");
				 				tsObj.setTransactionSequenceName(transactionSequenceName);
				 				tsObj.setTransactionSequenceNumber(1);
				 				tsObj.setCreatedby("admin");
				 				tsObj.setStatus("y");
				 				MasHospital hospital= new MasHospital();
				 				hospital.setId(box.getInt("hospitalId"));
				 				tsObj.setHospital(hospital);
				 				tsObj.setFinanicalYear(yr);
				 				hbt.save(tsObj);
				 				
				 			}
						hbt.save(medicoLegalDetails);
						hbt.update(wiseMlc);
						tx.commit();
						successfullyAdded = true;
						medicoLegalDetailsId=medicoLegalDetails.getId();
			            mlcType=medicoLegalDetails.getMlcType();
					
				}
				report="need report";
			 }
		}catch (DataAccessException e) {
			e.printStackTrace();
			if(tx==null){
				tx.rollback();
			}
		}
		//map = showUHIDJsp();
		map.put("successfullyAdded", successfullyAdded);
		map.put("message", message);
		map.put("medicoLegalDetailsId", medicoLegalDetailsId);
		map.put("mlcType", mlcType);
		map.put("report", report);
		return map;
	}
		
	
	// *********************---------------------------------------- End of  Method by Mansi -------------------------------------***********************//
	
	
	//==================================code by anamika-===================================
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getMedicoLegalDetailsForMortuary(Box box) {
		 Map<String, Object> map = new HashMap<String, Object>();
		List<MedicoLegalDetails> medicoLegalList = new ArrayList<MedicoLegalDetails>();
		Session session = (Session) getSession();
		medicoLegalList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("PatientStatus", "Death").ignoreCase())
				.createAlias("Hin", "hin").add(Restrictions.eq("hin.HinNo", box.getString("hinNo"))).list();
		map.put("medicoLegalList", medicoLegalList);
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitMortuaryRegister(Box box) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 List<MortuaryRegisterDetails> existingMortuaryRegisterList = new ArrayList<MortuaryRegisterDetails>();
		 PatientWiseMlc patientWiseMlc = new PatientWiseMlc();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			boolean flag = true;
			String msg = "";
			Session session = (Session)getSession();
			/*String mortuaryType = "";*/
			existingMortuaryRegisterList = session.createCriteria(MortuaryRegisterDetails.class).createAlias("PatientWiseMlc", "pwm")
										.add(Restrictions.eq("pwm.Id", box.getInt("patiientMlcId"))).list();
			System.out.println("existingMortuaryRegisterList=="+existingMortuaryRegisterList.size());
		try {
			if(existingMortuaryRegisterList.size()>0){
				msg = "Record already exist!!!!!";
				
			}else{
				MortuaryRegisterDetails mortuaryRegisterDetails = new MortuaryRegisterDetails();
				if(!box.getString("slNo").equals("")){
					mortuaryRegisterDetails.setSerialNo(box.getString("slNo"));
				}
				
				if(!box.getString("time").equals("")){
					mortuaryRegisterDetails.setMortuaryRegTime(box.getString("time"));
				}
				if(!box.getString("date").equals("")){
					mortuaryRegisterDetails.setMortuaryRegDate(HMSUtil.convertStringTypeDateToDateType(box.getString("date")));
				}
				if(!box.getString("causeOfDeath").equals("")){
					mortuaryRegisterDetails.setCauseOfDeath(box.getString("causeOfDeath"));
				}
				if(!box.getString("deceasedBroughtFrom").equals("")){
					mortuaryRegisterDetails.setDeceasedBroughtFrom(box.getString("deceasedBroughtFrom"));
				}
				if(!box.getString("deceasedBroughtBy").equals("")){
					mortuaryRegisterDetails.setDeceasedBroughtBy(box.getString("deceasedBroughtBy"));
				}
				if(!box.getString("bodyKeptInMortuaryDate").equals("")){
					mortuaryRegisterDetails.setDeadBodyKeptDate(HMSUtil.convertStringTypeDateToDateType(box.getString("bodyKeptInMortuaryDate")));
				}
				if(box.getString("bodyKeptInMortuaryTime")!=null && !box.getString("bodyKeptInMortuaryTime").equals("")){
					mortuaryRegisterDetails.setDeadBodyKeptTime(box.getString("bodyKeptInMortuaryTime"));
				}
				if(!box.getString("intimationGivenTo").equals("")){
					mortuaryRegisterDetails.setInitimationGiven(box.getString("intimationGivenTo"));
				}
				if(!box.getString("articlesOnBody").equals("")){
					mortuaryRegisterDetails.setArticlesOnBody(box.getString("articlesOnBody"));
				}
				if(!box.getString("otherRemarks").equals("")){
					mortuaryRegisterDetails.setMortuaryRegRemarks(box.getString("otherRemarks"));
				}
				if(!box.getString("bodyHandedOverTo").equals("")){
					mortuaryRegisterDetails.setBodyHandedOver(box.getString("bodyHandedOverTo"));
				}
				if(!box.getString("bodyHandedOverTime").equals("")){
					mortuaryRegisterDetails.setHandOverTime(box.getString("bodyHandedOverTime"));
				}
				if(!box.getString("bodyHandedOverDate").equals("")){
					mortuaryRegisterDetails.setHandOverDate(HMSUtil.convertStringTypeDateToDateType(box.getString("bodyHandedOverDate")));
				}
				if(!box.getString("cremation").equals("")){
					mortuaryRegisterDetails.setCremation(box.getString("cremation"));
				}
				if(!box.getString("receivedDeadBodyTime").equals("")){
					mortuaryRegisterDetails.setBodyReceivedTime(box.getString("receivedDeadBodyTime"));
				}
				if(!box.getString("receivedDeadBodyDate").equals("")){
					mortuaryRegisterDetails.setBodyReceivedDate(HMSUtil.convertStringTypeDateToDateType(box.getString("receivedDeadBodyDate")));
				}
				if(box.getInt("receivingById") != 0){
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("receivingById"));
					mortuaryRegisterDetails.setDeadBodyReceivedBy(masEmployee);
				}
				if(box.getInt("patiientWiseMlcId") != 0){
					patientWiseMlc.setId(box.getInt("patiientWiseMlcId"));
					mortuaryRegisterDetails.setPatientWiseMlc(patientWiseMlc);
				}
				mortuaryRegisterDetails.setPostmortemStatus("Mortuary Register");
				mortuaryRegisterDetails.setStatus("m");
				hbt.save(mortuaryRegisterDetails);
				/*mortuaryType = mortuaryRegisterDetails.getPostmortemStatus();*/
				// added by amit das on 03-06-2016
				patientWiseMlc.setStatus("A");
				hbt.update(patientWiseMlc);
				
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		map.put("msg", msg);
		/*map.put("mortuaryType", mortuaryType);*/
		map.put("patientMlcId", box.getInt("patiientMlcId"));
		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPostmortemDetails(Box box) {
		 Map<String, Object> map = new HashMap<String, Object>();
			List<MortuaryRegisterDetails> mortuaryDetailList = new ArrayList<MortuaryRegisterDetails>();
			Session session = (Session) getSession();
			mortuaryDetailList = session.createCriteria(MortuaryRegisterDetails.class)
					.createAlias("MedicoLegalDetails", "mlc").createAlias("mlc.Hin", "hin").add(Restrictions.eq("hin.HinNo", box.getString("hinNo"))).list();
			map.put("mortuaryDetailList", mortuaryDetailList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPostmortemExaminationJsp(Box box) {
		 Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee>doctorList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MortuaryRegisterDetails> mortuaryDetails=new ArrayList<MortuaryRegisterDetails>();
		/*List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
		List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();*/
		Session session = (Session)getSession();
		/*List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();*/
		
		try{
		/*Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	*/
		
		
		doctorList = session.createCriteria(MasEmployee.class).createAlias("EmpCategory", "empCategory")
					.add(Restrictions.eq("empCategory.EmpCategoryCode", "01")).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		mortuaryDetails=session.createCriteria(MortuaryRegisterDetails.class).add(Restrictions.eq("Id", box.getInt("mortuaryRegdDetailId"))).list();
		System.out.println(mortuaryDetails.size());
		/*mlcList=cr.list();
		  patientWiseMlcs=crMlc.list();
			patientHistories=crHis.list();
			details=crMedico.list();*/
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		map.put("employeeList", employeeList);
		/*map.put("mlcList", mlcList);*/
		/*map.put("patientWiseMlcs", patientWiseMlcs);*/
		/*map.put("patientHistories", patientHistories);*/
		/*map.put("details", details);*/
		map.put("doctorList", doctorList);
		map.put("mortuaryDetails", mortuaryDetails);
		
		
		
		return map;
	}

	@Override
	public Map<String, Object> updatePostMortemExamination(Box box) {
		 Map<String, Object> map = new HashMap<String, Object>();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			/*PatientWiseMlc patientWiseMlc=null;*/
			boolean flag = true;
			/*String msg = "";*/
			String mortuaryType = "";
			/*String mlcType="";
		    int medicoLegalDetailsId=0;*/
		    /*boolean successfullyAdded = false;*/
			Session session = (Session) getSession();
			Transaction tx=null;
		try {
				
				MortuaryRegisterDetails mortuaryRegisterDetails =(MortuaryRegisterDetails)hbt.load(MortuaryRegisterDetails.class, box.getInt("mortuaryRegdDetailId"));
				if(!box.getString("crimeNo").equals("")){
					mortuaryRegisterDetails.setCrimeNo(box.getString("crimeNo"));
				}
				
				if(!box.getString("requisitionFrom").equals("")){
					mortuaryRegisterDetails.setRequisitionFrom(box.getString("requisitionFrom"));
				}
				if(!box.getString("allegedDeathInquest").equals("")){
					mortuaryRegisterDetails.setAsPerInquest(box.getString("allegedDeathInquest"));
				}
				if(!box.getString("remarksAny").equals("")){
					mortuaryRegisterDetails.setRemarks(box.getString("remarksAny"));
				}
				
				if(box.getInt("medicalOfficer") != 0){
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("medicalOfficer"));
					mortuaryRegisterDetails.setDoctor(masEmployee);
				}
				if(box.getInt("assistedBy1") != 0){
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("assistedBy1"));
					mortuaryRegisterDetails.setAssistedBy1(masEmployee);
				}
				if(box.getInt("assistedBy2") != 0){
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("assistedBy2"));
					mortuaryRegisterDetails.setAssistedBy2(masEmployee);
				}
				if(!box.getString("crimeDate").equals("")){
					mortuaryRegisterDetails.setCrimeDate(HMSUtil.convertStringTypeDateToDateType(box.getString("crimeDate")));
				}
				
				
				mortuaryRegisterDetails.setPostmortemStatus("POSTMORTEM EXAMINATION");
				mortuaryRegisterDetails.setStatus("p");
				
				hbt.update(mortuaryRegisterDetails);
				mortuaryType = mortuaryRegisterDetails.getPostmortemStatus();
				flag = true;
			/*}
			else {
				tx=session.beginTransaction();
				 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
				           .add(Restrictions.eq("MlcType","POSTMORTEM EXAMINATION"))
				           .add(Restrictions.eq("OpdPatientDetail.Id",box.getInt("detailId"))).uniqueResult();

		         PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

		          if(wiseMlc!=null){
			            wiseMlc.setStatus("A");
		                 }
			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
					if(box.getInt("hinId")!=0){
					Patient patient = new Patient();
					patient.setId(box.getInt("hinId"));
					medicoLegalDetails.setHin(patient);
					}
					
					
					if(!box.getString("crimeNo").equals("")){
						medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
					}

					if(!box.getString("crimeDate").equals("")){
						medicoLegalDetails.setCrimeDate(HMSUtil.convertStringTypeDateToDateType(box.getString("crimeDate")));
					}
					medicoLegalDetails.setPoliceStation(box.getString("policeStation"));
					
					
					if(!box.getString("requisitionFrom").equals("")){
						medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
					}
					if(!box.getString("allegedDeathInquest").equals("")){
						medicoLegalDetails.setCauseDeath(box.getString("allegedDeathInquest"));
					}
					if(!box.getString("remarksAny").equals("")){
						medicoLegalDetails.setRemarks(box.getString("remarksAny"));
					}
					
					if(box.getInt("medicalOfficer") != 0){
						MasEmployee masEmployee = new MasEmployee();
						
						masEmployee.setId(box.getInt("medicalOfficer"));
										
						medicoLegalDetails.setDoctor(masEmployee);
					}
					if(box.getInt("assistedBy1") != 0){
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(box.getInt("assistedBy1"));
					medicoLegalDetails.setAssiste1(masEmployee);
					}
					if(box.getInt("assistedBy2") != 0){
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(box.getInt("assistedBy2"));
					medicoLegalDetails.setAssiste2(masEmployee);
					}
					if(!box.getString("crimeDate").equals("")){
						medicoLegalDetails.setCrimeDate(HMSUtil.convertStringTypeDateToDateType(box.getString("crimeDate")));
					}
					
					
					medicoLegalDetails.setMlcType("POSTMORTEM EXAMINATION");
					
					hbt.save(medicoLegalDetails);
					hbt.update(wiseMlc);
					tx.commit();
					successfullyAdded = true;
					 mlcType=medicoLegalDetails.getMlcType();
					medicoLegalDetailsId=medicoLegalDetails.getId();
					hbt.flush();
					map.put("successfullyAdded", successfullyAdded);
				
					map.put("medicoLegalDetailsId", medicoLegalDetailsId);
					map.put("mlcType", mlcType);  
		
				
				*/	
		}catch (DataAccessException e) {
			e.printStackTrace();
			if(tx==null){
				tx.rollback();
			}
		}
		map.put("mlcType", mortuaryType);
		map.put("mortuaryRegdDetailId", box.getInt("mortuaryRegdDetailId"));
		map.put("flag", flag);
		//map.put("msg", msg);
		return map;
	}
	@Override
	public Map<String, Object> updatePostMortemDetailedNotes(Box box) {
		 Map<String, Object> map = new HashMap<String, Object>();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			boolean flag = true;
			String msg = "";
			 String mortuaryType = "";
			Session session = (Session)getSession();
		try {
			
			
				MortuaryRegisterDetails mortuaryRegisterDetails =(MortuaryRegisterDetails)hbt.load(MortuaryRegisterDetails.class, box.getInt("mortuaryRegdDetailId"));
				if(!box.getString("hcPcNo").equals("")){
					mortuaryRegisterDetails.setHcPcNo(box.getString("hcPcNo"));
				}
				if(!box.getString("bodyIdentifiedBy").equals("")){
					mortuaryRegisterDetails.setBodyIndentifiedBy(box.getString("bodyIdentifiedBy"));
				}
				if(!box.getString("firstSeenTime").equals("")){
					mortuaryRegisterDetails.setFirstSeenTime(box.getString("firstSeenTime"));
				}
				if(!box.getString("firstSeenDate").equals("")){
					mortuaryRegisterDetails.setFirstSeenDate(HMSUtil.convertStringTypeDateToDateType(box.getString("firstSeenDate")));
				}
				if(!box.getString("commencedTime").equals("")){
					mortuaryRegisterDetails.setCommencedTime(box.getString("commencedTime"));
				}
				if(!box.getString("commencedDate").equals("")){
					mortuaryRegisterDetails.setCommencedDate(HMSUtil.convertStringTypeDateToDateType(box.getString("commencedDate")));
				}
				
				if(box.getInt("conductedBy") != 0){
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("conductedBy"));
					mortuaryRegisterDetails.setConductedBy(masEmployee);
				}
				if(box.getInt("assistedBy1") != 0){
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("assistedBy1"));
					//mortuaryRegisterDetails.setDoctor(masEmployee);
				}
				if(box.getInt("assistedBy2") != 0){
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("assistedBy2"));
					//mortuaryRegisterDetails.setDoctor(masEmployee);
				}
				if(!box.getString("sentBy").equals("")){
					mortuaryRegisterDetails.setSentBy(box.getString("sentBy"));
				}
				
				if(!box.getString("sceneExamination").equals("")){
					mortuaryRegisterDetails.setSceneExamination(box.getString("sceneExamination"));
				}
				if(!box.getString("otherArticles").equals("")){
					mortuaryRegisterDetails.setClothesWeaponsOtherArticles(box.getString("otherArticles"));
				}
				if(!box.getString("generalBody").equals("")){
					mortuaryRegisterDetails.setBody(box.getString("generalBody"));
				}
				if(!box.getString("build").equals("")){
					mortuaryRegisterDetails.setBuild(box.getString("build"));
				}
				if(!box.getString("nourishment").equals("")){
					mortuaryRegisterDetails.setNourishment(box.getString("nourishment"));
				}
				if(!box.getString("smell").equals("")){
					mortuaryRegisterDetails.setSmell(box.getString("smell"));
				}
				if(!box.getString("facialApp").equals("")){
					mortuaryRegisterDetails.setFacialAppearence(box.getString("facialApp"));
				}
				if(!box.getString("eyes").equals("")){
					mortuaryRegisterDetails.setEyes(box.getString("eyes"));
				}
				if(!box.getString("pupils").equals("")){
					mortuaryRegisterDetails.setPupils(box.getString("pupils"));
				}
				if(!box.getString("conjunctivae").equals("")){
					mortuaryRegisterDetails.setConjunctivae(box.getString("conjunctivae"));
				}
				if(!box.getString("mouth").equals("")){
					mortuaryRegisterDetails.setMouth(box.getString("mouth"));
				}
				if(!box.getString("tongue").equals("")){
					mortuaryRegisterDetails.setTongue(box.getString("tongue"));
				}
				if(!box.getString("lips").equals("")){
					mortuaryRegisterDetails.setLips(box.getString("lips"));
				}
				if(!box.getString("circumOrReg").equals("")){
					mortuaryRegisterDetails.setCircumOralRegions(box.getString("circumOrReg"));
				}
				if(!box.getString("oralCavity").equals("")){
					mortuaryRegisterDetails.setOralCavity(box.getString("oralCavity"));
				}
				if(!box.getString("aspectsOfLips").equals("")){
					mortuaryRegisterDetails.setInnerAspectsOfLips(box.getString("aspectsOfLips"));
				}
				if(!box.getString("ear").equals("")){
					mortuaryRegisterDetails.setEars(box.getString("ear"));
				}
				if(!box.getString("urethralOri").equals("")){
					mortuaryRegisterDetails.setUrethralOrifice(box.getString("urethralOri"));
				}
				if(!box.getString("anus").equals("")){
					mortuaryRegisterDetails.setAnus(box.getString("anus"));
				}
				if(!box.getString("rigorMortis").equals("")){
					mortuaryRegisterDetails.setRigorMortis(box.getString("rigorMortis"));
				}
				if(!box.getString("stainning").equals("")){
					mortuaryRegisterDetails.setPostmortemStaining(box.getString("stainning"));
				}
				if(!box.getString("driedSaliMark").equals("")){
					mortuaryRegisterDetails.setDriedSalivaryDribbleMark(box.getString("driedSaliMark"));
				}
				if(!box.getString("smearingsBody").equals("")){
					mortuaryRegisterDetails.setSmearingOnBody(box.getString("smearingsBody"));
				}
				if(!box.getString("postmtBiteMarks").equals("")){
					mortuaryRegisterDetails.setPostmortemAntBiteMarks(box.getString("postmtBiteMarks"));
				}
				if(!box.getString("postmtOthBitMarks").equals("")){
					mortuaryRegisterDetails.setAquaticOtherAnimalBiteRemarks(box.getString("postmtOthBitMarks"));
				}
				if(!box.getString("burnsDueToSunlight").equals("")){
					mortuaryRegisterDetails.setBurnsDueToExposureToSunlight(box.getString("burnsDueToSunlight"));
				}
				if(!box.getString("decompositionChanges").equals("")){
					mortuaryRegisterDetails.setDecompositionChanges(box.getString("decompositionChanges"));
				}
				if(!box.getString("anyOthFindings").equals("")){
					mortuaryRegisterDetails.setOtherFindings(box.getString("anyOthFindings"));
				}
				if(!box.getString("external").equals("")){
					mortuaryRegisterDetails.setExternal(box.getString("external"));
				}
				if(!box.getString("internal").equals("")){
					mortuaryRegisterDetails.setInternal(box.getString("internal"));
				}
				if(!box.getString("scalp").equals("")){
					mortuaryRegisterDetails.setScalp(box.getString("scalp"));
				}
				if(!box.getString("skull").equals("")){
					mortuaryRegisterDetails.setSkull(box.getString("skull"));
				}
				if(!box.getString("meningesCerVess").equals("")){
					mortuaryRegisterDetails.setMeningesCerebralVessels(box.getString("meningesCerVess"));
				}
				if(!box.getString("brain").equals("")){
					mortuaryRegisterDetails.setBrain(box.getString("brain"));
				}
				if(!box.getString("musclesOfNeck").equals("")){
					mortuaryRegisterDetails.setTissuesMusclesOfNeck(box.getString("musclesOfNeck"));
				}
				if(!box.getString("mouthPyarynx").equals("")){
					mortuaryRegisterDetails.setMouthPharynx(box.getString("mouthPyarynx"));
				}
				if(!box.getString("cartilagesNeck").equals("")){
					mortuaryRegisterDetails.setCartilagesOfNeck(box.getString("cartilagesNeck"));
				}
				if(!box.getString("hyoidBone").equals("")){
					mortuaryRegisterDetails.setHyoidBone(box.getString("hyoidBone"));
				}
				if(!box.getString("ribsChestWall").equals("")){
					mortuaryRegisterDetails.setRibsAndChestWall(box.getString("ribsChestWall"));
				}
				if(!box.getString("pleuralCaviti").equals("")){
					mortuaryRegisterDetails.setPleuralCavities(box.getString("pleuralCaviti"));
				}
				if(!box.getString("diaphram").equals("")){
					mortuaryRegisterDetails.setDiaphragm(box.getString("diaphram"));
				}
				if(!box.getString("mediastinumThymus").equals("")){
					mortuaryRegisterDetails.setMediastinumAndThymus(box.getString("mediastinumThymus"));
				}
				if(!box.getString("oesophagus").equals("")){
					mortuaryRegisterDetails.setOesophagus(box.getString("oesophagus"));
				}
				if(!box.getString("tracheaBronchi").equals("")){
					mortuaryRegisterDetails.setTracheaAndBronchi(box.getString("tracheaBronchi"));
				}
				if(!box.getString("lungsRight").equals("")){
					mortuaryRegisterDetails.setLungsRight(box.getString("lungsRight"));
				}
				if(!box.getString("lungsLeft").equals("")){
					mortuaryRegisterDetails.setLungsLeft(box.getString("lungsLeft"));
				}
				if(!box.getString("heart").equals("")){
					mortuaryRegisterDetails.setHeart(box.getString("heart"));
				}
				if(!box.getString("coronaries").equals("")){
					mortuaryRegisterDetails.setCoronaries(box.getString("coronaries"));
				}
				if(!box.getString("aorta").equals("")){
					mortuaryRegisterDetails.setAorta(box.getString("aorta"));
				}
				if(!box.getString("abdominalWall").equals("")){
					mortuaryRegisterDetails.setAbdominalWall(box.getString("abdominalWall"));
				}
				if(!box.getString("peritonealCavity").equals("")){
					mortuaryRegisterDetails.setPeritonealCavity(box.getString("peritonealCavity"));
				}
				if(!box.getString("liver").equals("")){
					mortuaryRegisterDetails.setLiver(box.getString("liver"));
				}
				if(!box.getString("gallBillaryPass").equals("")){
					mortuaryRegisterDetails.setGallBladderBillaryPassages(box.getString("gallBillaryPass"));
				}
				if(!box.getString("spleen").equals("")){
					mortuaryRegisterDetails.setSpleen(box.getString("spleen"));
				}
				if(!box.getString("kindeyRight").equals("")){
					mortuaryRegisterDetails.setKidneysLeft(box.getString("kindeyRight"));
				}
				if(!box.getString("kindeyLeft").equals("")){
					mortuaryRegisterDetails.setKidneysLeft(box.getString("kindeyLeft"));
				}
				
				if(!box.getString("pancreas").equals("")){
					mortuaryRegisterDetails.setPancreas(box.getString("pancreas"));
				}
				
				if(!box.getString("adrenalGlandRight").equals("")){
					mortuaryRegisterDetails.setAdrenalGlandsRight(box.getString("adrenalGlandRight"));
				}
				if(!box.getString("adrenalGlandLeft").equals("")){
					mortuaryRegisterDetails.setAdrenalGlandsLeft(box.getString("adrenalGlandLeft"));
				}
				if(!box.getString("stomachContents").equals("")){
					mortuaryRegisterDetails.setStomatchContents(box.getString("stomachContents"));
				}
				if(!box.getString("intestimesMesentery").equals("")){
					mortuaryRegisterDetails.setIntestinesMesentery(box.getString("intestimesMesentery"));
				}
				if(!box.getString("urinaryBladder").equals("")){
					mortuaryRegisterDetails.setUrinaryBladder(box.getString("urinaryBladder"));
				}
				if(!box.getString("genitalOrgans").equals("")){
					mortuaryRegisterDetails.setGenitalOrgans(box.getString("genitalOrgans"));
				}
				if(!box.getString("spinalColumn").equals("")){
					mortuaryRegisterDetails.setSpinalColumnCord(box.getString("spinalColumn"));
				}
				if(!box.getString("additionalObservation").equals("")){
					mortuaryRegisterDetails.setAdditionalObservations(box.getString("additionalObservation"));
				}
				if(!box.getString("postmortConcludedTime").equals("")){
					mortuaryRegisterDetails.setExamConcluldedTime(box.getString("postmortConcludedTime"));
				}
				if(!box.getString("postmortConcludedDate").equals("")){
					mortuaryRegisterDetails.setExamConcludedDate(HMSUtil.convertStringTypeDateToDateType(box.getString("postmortConcludedDate")));
				}
				if(!box.getString("opinionCouseDeath").equals("")){
					mortuaryRegisterDetails.setOpinionAsToCauseOfDeath(box.getString("opinionCouseDeath"));
				}
				mortuaryRegisterDetails.setPostmortemStatus("POST MORTEM DETAILED NOTES");
				mortuaryRegisterDetails.setStatus("d");  // Status - "d" --> Done (Process completed for Mortuary Registration)
				hbt.update(mortuaryRegisterDetails);
				mortuaryType = mortuaryRegisterDetails.getPostmortemStatus();
				int count = 0;
				if(box.getInt("hdb") != 0){
					count = box.getInt("hdb");
				}
				System.out.println("count=="+count);
				for (int i = 1; i <= count; i++) {
					MlcMaterialObjects materialObjects = new MlcMaterialObjects();
					System.out.println("slNo====="+box.getString("slNo"+i));
					if(box.getString("slNo"+i).equalsIgnoreCase("y")){
						if(!box.getString("object"+i).equals("")){
							materialObjects.setMaterialObjects(box.getString("object"+i));
						}
						if(!box.getString("chemical"+i).equals("")){
							materialObjects.setChemicalAnalysis("y");
						}else{
							materialObjects.setChemicalAnalysis("n");
						}
						/*if(box.getInt("mlcId") != 0){
							MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
							medicoLegalDetails.setId(box.getInt("mlcId"));
							materialObjects.setMedicoLegalDetails(medicoLegalDetails);
						}*/
						if(box.getInt("mortuaryRegdDetailId") != 0){
							MortuaryRegisterDetails morRegisterDetails = new MortuaryRegisterDetails();
							morRegisterDetails.setId(box.getInt("mortuaryRegdDetailId"));
							materialObjects.setMortuaryReg(morRegisterDetails);
						}
						
						hbt.save(materialObjects);
						
					}
				}
				
				flag = true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		//map.put("mlcType", mortuaryType);
		map.put("mortuaryRegdDetailId", box.getInt("mortuaryRegdDetailId"));
		//map.put("msg", msg);
		return map;
	}
	@Override
	public Map<String, Object> showPostmortemDetailNotesJsp(Box box) {
		 Map<String, Object> map = new HashMap<String, Object>();
			
			List<MortuaryRegisterDetails> mortuaryDetails= new ArrayList<MortuaryRegisterDetails>();
			Session session = (Session)getSession();
			
			mortuaryDetails=session.createCriteria(MortuaryRegisterDetails.class).add(Restrictions.eq("Id", box.getInt("mortuaryRegdDetailId"))).list();
			System.out.println(mortuaryDetails.size());
			
			map.put("mortuaryDetails", mortuaryDetails);
			return map;
	}
	
	
	//----------------------------------End of code by anamika----------------------------------------------------------------
	

	//------------------ Avinash-----------------------------
	
	
	
	@Override
	public Map<String, Object> showTreatment_Dischargr_JSP() {
		 Map<String, Object> map = new HashMap<String, Object>();
//			List<Patient> patientList = new ArrayList<Patient>();
			List<MasEmployee> emplist = new ArrayList<MasEmployee>();
			
			Session session = (Session) getSession();
			try {
//				patientList=session.createCriteria(Patient.class).list();
				int empCategoryCodeForDoctor =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "empCategoryCodeForDoctor"));
				System.out.println(empCategoryCodeForDoctor);
				emplist=session.createCriteria(MasEmployee.class).createAlias("EmpCategory", "cat").add(Restrictions.eq("cat.Id", empCategoryCodeForDoctor)).list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(emplist.size()+"emp");
//			map.put("patientList", patientList);
			map.put("emplist", emplist);
		
			return map;
	}
	@Override
	public Map<String, Object> submmitDrunknessCertifikate(
			MedicoLegalDetails details,int opdId,int hospitalId) {
		 Map<String, Object> map = new HashMap<String, Object>();
		Session session= (Session) getSession();
          Transaction tx=null;
          PatientWiseMlc patientWiseMlc=null;
			boolean saveFlag = false;
			String mlcType="";
			int medicoLegalDetailsId=0;
			String transactionSequenceName = "Drunkness";
			List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
			try {
				
				
				tx = session.beginTransaction();
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
				           .add(Restrictions.eq("MlcType","Certificate Of Drunkness"))
				           .add(Restrictions.eq("OpdPatientDetail.id" ,opdId)).uniqueResult();

		       
		          sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", hospitalId))
		 							.list();
		 			if(sequenceNoList.size()>0){
		            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
		 			int orderNo = transactionSequence.getTransactionSequenceNumber();
		 			orderNo = orderNo + 1;
		 			int id = transactionSequence.getId();

		 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
		 			transactionSequence2.setTransactionSequenceNumber(orderNo);
		 			hbt.update(transactionSequence2);
		 			}else if (sequenceNoList.size() == 0) {
		 				TransactionSequence tsObj = new TransactionSequence();
		 				tsObj.setStatus("y");
		 				tsObj.setTransactionPrefix("DC");
		 				tsObj.setTransactionSequenceName("Drunkness");
		 				tsObj.setTransactionSequenceNumber(1);
		 				tsObj.setCreatedby("admin");
		 				tsObj.setStatus("y");
		 				MasHospital hospital= new MasHospital();
		 				hospital.setId(hospitalId);
		 				tsObj.setHospital(hospital);
		 				
		 				hbt.save(tsObj);
		 				
		 			}
		 			  PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

			          if(wiseMlc!=null){
				            wiseMlc.setStatus("AT");
			                 }
			          
			              
                hbt.update(wiseMlc);
				hbt.save(details);
				mlcType=details.getMlcType();
				
				medicoLegalDetailsId=details.getId();
				hbt.flush();
				hbt.clear();
				tx.commit();
				saveFlag = true;
			} catch (Exception e) {
				e.printStackTrace();
                if(tx==null){
			     tx.rollback();
		            }
			}
			map.put("medicoLegalDetailsId", medicoLegalDetailsId);	
		map.put("saveFlag", saveFlag);
		map.put("mlcType", mlcType);
		
		return map;
	}
	@Override
	public Map<String, Object> submmitMedicoRegister(
			MedicoLegalDetails details) {
		
		 Map<String, Object> map = new HashMap<String, Object>();
		  
			boolean saveFlag = false;
			try {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(details);
				hbt.flush();
				hbt.clear();
				saveFlag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		map.put("saveFlag", saveFlag);
		
		return map;
	}
	@Override
	public Map<String, Object> submmitTreetmentDischarge(MedicoLegalDetails details,int opdId,int hospitalId,String refNo) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 	String mlcType="";
			PatientWiseMlc mlcsList=null;
			PatientWiseMlc patientWiseMlc=null;
			boolean saveFlag = false;
			Transaction tx=null;
			int medicoLegalDetailsId=0;
			String transactionSequenceName = "TreatmentDischarge";
			List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
			
			Session session= (Session) getSession();
			try {

				 
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				tx = session.beginTransaction();
				
				tx = session.beginTransaction();
				 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
				           .add(Restrictions.eq("MlcType","Treatment / Discharge Certificate"))
				           .add(Restrictions.eq("OpdPatientDetail.Id",opdId)).uniqueResult();
				 PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

		          if(wiseMlc!=null){
			            wiseMlc.setStatus("AT");
		                 }

					String srNo=refNo;
		String yr = "";
		if(srNo!=null){ 
				 yr = srNo.substring(4, 8);
				
		}				
		sequenceNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionSequenceName",
							transactionSequenceName))
							.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id",hospitalId))
		 			.add(Restrictions.eq("FinanicalYear", yr))
							.list();
		          
		 			if(sequenceNoList.size()>0){
		            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
		 			int orderNo = transactionSequence.getTransactionSequenceNumber();
		 			orderNo = orderNo + 1;
		 			int id = transactionSequence.getId();

		 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
		 			transactionSequence2.setTransactionSequenceNumber(orderNo);
		 			hbt.update(transactionSequence2);
		 			}else if (sequenceNoList.size() == 0) {
		 				TransactionSequence tsObj = new TransactionSequence();
		 				tsObj.setStatus("y");
		 				tsObj.setTransactionPrefix("TD");
		 				tsObj.setTransactionSequenceName(transactionSequenceName);
		 				tsObj.setTransactionSequenceNumber(1);
		 				tsObj.setCreatedby("admin");
		 				tsObj.setStatus("y");
		 				MasHospital hospital= new MasHospital();
		 				hospital.setId(hospitalId);
		 				tsObj.setHospital(hospital);
		 				tsObj.setFinanicalYear(yr);
		 				hbt.save(tsObj);
		 				
		 			}
		          
				
				hbt.save(details);
				hbt.update(wiseMlc);
				hbt.flush();
				hbt.clear();
				tx.commit();
				mlcType=details.getMlcType();
				medicoLegalDetailsId=details.getId();
				saveFlag = true;
			} catch (Exception e) {
				e.printStackTrace();
				if(tx==null){
					tx.rollback();
					
				}
			}
			map.put("medicoLegalDetailsId", medicoLegalDetailsId);
			map.put("mlcType", mlcType);
			map.put("saveFlag", saveFlag);
		 
		 
		return map;
	}
	@Override
	public Map<String, Object> getMedicolegalRegisterDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		session = (Session) getSession();
		String status = box.getString("uhinId");
		
		
		List<MasEmployee> emplist = new ArrayList<MasEmployee>();
		List<MedicoLegalDetails> details=new ArrayList<MedicoLegalDetails>();
		
		try {
			Criteria criteria=session.createCriteria(MedicoLegalDetails.class)
					.createAlias("Hin","id")
					.add(Restrictions.eq("id.HinNo", status));
			details=criteria.list();
			emplist=session.createCriteria(MasEmployee.class).createAlias("EmpCategory", "cat").add(Restrictions.eq("cat.Id", 1)).list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(details.size());
		map.put("details", details);
		map.put("emplist", emplist);
		
		return map;
	}
	@Override
	public Map<String, Object> getDetailAndDisplay(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		session = (Session) getSession();
		String status = box.getString("serialNo");
		List<MasEmployee> emplist = new ArrayList<MasEmployee>();
		List<MedicoLegalDetails> details=new ArrayList<MedicoLegalDetails>();
		
		try {
			Criteria criteria=session.createCriteria(MedicoLegalDetails.class)
							.add(Restrictions.eq("SerialNo", status));
			details=criteria.list();
			emplist=session.createCriteria(MasEmployee.class).createAlias("EmpCategory", "cat").add(Restrictions.eq("cat.Id", 1)).list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(details.size());
		map.put("details", details);
		map.put("emplist", emplist);
		
		return map;
	}
	

	
	//------------------- End Avinash--------------------------------
	

	//	VK
	
	@Override
	public Map<String, Object> addAccidentalRegistration(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		PatientWiseMlc mlcsList=null;
		PatientWiseMlc patientWiseMlc=null;
		String transactionSequenceName = "Accidental Reg";
		List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session= (Session) getSession();
		String message ="";
		String report="";
		int medicoLegalDetailsId=0;
		String mlcType="";
		Transaction tx=null;
		try {
			tx = session.beginTransaction();
	 if(box.getString("flag").equalsIgnoreCase("submit")){
			
		 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Accident Register-cum-Wound Certificate"))
		           .add(Restrictions.eq("OpdPatientDetail.Id",box.getInt("detailId"))).uniqueResult();

         PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

          if(wiseMlc!=null){
	            wiseMlc.setStatus("AT");
                 }
		
			List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
			medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
					.list();
			 
		
				MedicoLegalDetails details = new MedicoLegalDetails();
				
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				details.setHin(patient);
				
				if(box.getInt("detailId")!=0){
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(box.getInt("detailId"));
					details.setOpdPatientDetail(opdPatientDetails);
					}
				
				details.setSerialNo(box.getString("serialNo"));
		        details.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("exdate")));
		        details.setExaminationTime(box.getString("extime"));
		        details.setOpinion(box.getString("opinion"));
		        if(!box.getString("sheets").equals(""))
		        	details.setNoOfAdditionalSheets(Integer.parseInt(box.getString("sheets")));
		        details.setIdMark1(box.getString("idmark1"));
		        details.setIdMark2(box.getString("idmark2"));
		        details.setBroughtBy(box.getString("bbname"));
		        details.setBroughtByAddress(box.getString("bbaddress"));
		        details.setRequisitionFrom(box.getString("requifrom"));
		        details.setHistoryInjuryCause(box.getString("injury"));
		        details.setHistoryByInjured(box.getString("stmt"));
		        details.setInjuryDetails(box.getString("detail"));
		        details.setWitnesses1(box.getString("witness1"));
		        details.setWitnesses1Father(box.getString("sodo1"));
		        details.setWitnesses1Address(box.getString("witaddress1"));
		        details.setWitnesses2(box.getString("witness2"));
		        details.setWitnesses2Father(box.getString("sodo2"));
		        details.setWitnesses2Address(box.getString("witaddress2"));
		        details.setPhysicalExamination(box.getString("physical"));
		        details.setPatientStatus(box.getString("admitted"));
		        details.setPoliceStation(box.getString("police"));
		        details.setMlcType("Accident Register-cum-Wound Certificate");
		        details.setInjuryType(box.getString("injuriesAppeared"));
		        if(!box.getString("address").equals("")){
		        details.setPatientAddress(box.getString("address"));
		        }
                if(box.getInt("inPatientId")!=0){
                         Inpatient inp=new Inpatient();
                  inp.setId(box.getInt("inPatientId"));
                  details.setInpatient(inp);	
                              }
                
                
             if(box.getInt("detailId")!=0){
                    OpdPatientDetails opd=new OpdPatientDetails();
                    opd.setId(box.getInt("detailId"));
                    details.setOpdPatientDetail(opd);
                         }
             
             sequenceNoList = session
 					.createCriteria(TransactionSequence.class)
 					.add(Restrictions.eq("TransactionSequenceName",
 							transactionSequenceName))
 							.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
 							.list();
 			if(sequenceNoList.size()>0){
            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
 			int orderNo = transactionSequence.getTransactionSequenceNumber();
 			orderNo = orderNo + 1;
 			int id = transactionSequence.getId();

 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
 			transactionSequence2.setTransactionSequenceNumber(orderNo);
 			hbt.update(transactionSequence2);
 			}else if (sequenceNoList.size() == 0) {
 				TransactionSequence tsObj = new TransactionSequence();
 				tsObj.setStatus("y");
 				tsObj.setTransactionPrefix("AR");
 				tsObj.setTransactionSequenceName("Accidental Reg");
 				tsObj.setTransactionSequenceNumber(1);
 				tsObj.setCreatedby("admin");
 				tsObj.setStatus("y");
 				MasHospital hospital= new MasHospital();
 				hospital.setId(box.getInt("hospitalId"));
 				tsObj.setHospital(hospital);
 				
 				hbt.save(tsObj);
 				
 			}

		        
		   //     hbt.update(wiseMlc);
		    	hbt.update(wiseMlc);
				hbt.save(details);
				mlcType=details.getMlcType();
				medicoLegalDetailsId=details.getId();	
				successfullyAdded = true;
				tx.commit();
				report="not report";
		
	 }
	 else if (box.getString("flag").equalsIgnoreCase("authorization")) {
			
		 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Accident Register-cum-Wound Certificate"))
		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

            PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

           if(wiseMlc!=null){
	          wiseMlc.setStatus("C");
               }
			
			
			List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
			medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
					.list();
			 
		if(medicoLegalDetailsList.size()>0){
				MedicoLegalDetails details = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
				
				
				details.setSerialNo(box.getString("serialNo"));
		        details.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("exdate")));
		        details.setExaminationTime(box.getString("extime"));
		        details.setOpinion(box.getString("opinion"));
		        if(!box.getString("sheets").equals(""))
		        	details.setNoOfAdditionalSheets(Integer.parseInt(box.getString("sheets")));
		        details.setIdMark1(box.getString("idmark1"));
		        details.setIdMark2(box.getString("idmark2"));
		        details.setBroughtBy(box.getString("bbname"));
		        details.setBroughtByAddress(box.getString("bbaddress"));
		        details.setRequisitionFrom(box.getString("requifrom"));
		        details.setHistoryInjuryCause(box.getString("injury"));
		        details.setHistoryByInjured(box.getString("stmt"));
		        details.setInjuryDetails(box.getString("detail"));
		        details.setWitnesses1(box.getString("witness1"));
		        details.setWitnesses1Father(box.getString("sodo1"));
		        details.setWitnesses1Address(box.getString("witaddress1"));
		        details.setWitnesses2(box.getString("witness2"));
		        details.setWitnesses2Father(box.getString("sodo2"));
		        details.setWitnesses2Address(box.getString("witaddress2"));
		        details.setPhysicalExamination(box.getString("physical"));
		        details.setPatientStatus(box.getString("admitted"));
		        details.setPoliceStation(box.getString("police"));
		        details.setMlcType("Accident Register-cum-Wound Certificate");
		        if(box.getInt("hinId")!=0)
				{
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				details.setHin(patient);
				}
		        if(box.getInt("inPatientId")!=0){
                    Inpatient inp=new Inpatient();
                      inp.setId(box.getInt("inPatientId"));
                      details.setInpatient(inp);	
                         }
		        
		    	hbt.update(wiseMlc);
				hbt.saveOrUpdate(details);
				mlcType=details.getMlcType();
				medicoLegalDetailsId=details.getId();	
				successfullyAdded = true;
				tx.commit();
		}
		else {

			MedicoLegalDetails details = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0)
			{
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			details.setHin(patient);
			}
			details.setSerialNo(box.getString("serialNo"));
	        details.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("exdate")));
	        details.setExaminationTime(box.getString("extime"));
	        details.setOpinion(box.getString("opinion"));
	        if(!box.getString("sheets").equals(""))
	        	details.setNoOfAdditionalSheets(Integer.parseInt(box.getString("sheets")));
	        details.setIdMark1(box.getString("idmark1"));
	        details.setIdMark2(box.getString("idmark2"));
	        details.setBroughtBy(box.getString("bbname"));
	        details.setBroughtByAddress(box.getString("bbaddress"));
	        details.setRequisitionFrom(box.getString("requifrom"));
	        details.setHistoryInjuryCause(box.getString("injury"));
	        details.setHistoryByInjured(box.getString("stmt"));
	        details.setInjuryDetails(box.getString("detail"));
	        details.setWitnesses1(box.getString("witness1"));
	        details.setWitnesses1Father(box.getString("sodo1"));
	        details.setWitnesses1Address(box.getString("witaddress1"));
	        details.setWitnesses2(box.getString("witness2"));
	        details.setWitnesses2Father(box.getString("sodo2"));
	        details.setWitnesses2Address(box.getString("witaddress2"));
	        details.setPhysicalExamination(box.getString("physical"));
	        details.setPatientStatus(box.getString("admitted"));
	        details.setPoliceStation(box.getString("police"));
	        details.setMlcType("Accident Register-cum-Wound Certificate");
	        if(box.getInt("inPatientId")!=0){
                Inpatient inp=new Inpatient();
             inp.setId(box.getInt("inPatientId"));
               details.setInpatient(inp);	
                     }
	         
			hbt.save(details);
			mlcType=details.getMlcType();
			medicoLegalDetailsId=details.getId();	
			successfullyAdded = true;
			tx.commit();
	
			
		}
		report="need report";
	 }
		 
		}catch (DataAccessException e) {
			e.printStackTrace();
			if (tx == null) {
				tx.rollback();
			}
		}
		//map = showUHIDJsp();
		map.put("successfullyAdded", successfullyAdded);
		map.put("medicoLegalDetailsId", medicoLegalDetailsId);
		map.put("message", message);
		map.put("mlcType", mlcType);
		map.put("report", report);
		
		return map;
	}
		
	// *********************---------------------------------------- Hospital Session and Report Connection -------------------------------------***********************//

	public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Integer hospitalId = 0;
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		try {
			List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
			masHospitaList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Id", hospitalId)).add(Restrictions.eq("Status","y").ignoreCase()).list();
			mapResponse.put("masHospitaList", masHospitaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapResponse;
	}
	@Override
	public Map<String, Object> getConnection() {
		Session session = (Session) getSession();
		Connection con = (Connection) session.connection();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conn", con);
		return map;
	}
	

  
public Map<String, Object> getAdmissionNumberList(Map requestParameters) {
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	boolean hinNoFound = false;
	String uhinId = "";
	try {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (requestParameters.get("uhinId") != null) {
			uhinId = (String) requestParameters.get("uhinId").toString().trim();
		}
		

		inpatientList = session.createCriteria(Inpatient.class).createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", uhinId)).list();
		map.put("inpatientList", inpatientList);
		
		if (inpatientList != null && inpatientList.size() > 0) {
			hinNoFound = true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	map.put("inpatientList", inpatientList);
	map.put("hinNoFound", hinNoFound);
	return map;
}

@SuppressWarnings("unchecked")
@Override
public Map<String, Object> checkWoundCertificate(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MedicoLegalDetails> medicoLegalList = new ArrayList<MedicoLegalDetails>();
	Session session = (Session)getSession();
	medicoLegalList = session.createCriteria(MedicoLegalDetails.class).createAlias("Hin", "hin")
				.add(Restrictions.eq("hin.HinNo", box.getString("uhid"))).add(Restrictions.eq("IssueToPatient", "y").ignoreCase()).list();
	map.put("medicoLegalList", medicoLegalList);
	/*Date examinationDate =medicoLegalList.get(0) .getExaminationDate();
	String examDate =HMSUtil.convertDateToStringWithoutTime(examinationDate);
	String curDate = currentDate+" "+currentTime;
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
	Date d1 = null;
	Date d2 = null;
	 try {
	    d1 = format.parse(examDate);
	    d2 = format.parse(curDate);
		} catch (ParseException e) {
		    e.printStackTrace();
		}    
			 long diff = d2.getTime() - d1.getTime();
			 long diffHours = diff / (60 * 60 * 1000);
			 long diffInDays = diff / (24 * 60 * 60 * 1000);
			 System.out.println("diff=="+diff);*/
	return map;
}

@Override
public Map<String, Object> updateWoundCertificateStatus(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MedicoLegalDetails> medicoLegalList = new ArrayList<MedicoLegalDetails>();
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session = (Session)getSession();
	medicoLegalList = session.createCriteria(MedicoLegalDetails.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.HinNo", box.getString("hinNo"))).list();
	int medicoId = 0;
	if(medicoLegalList.size()>0){
		medicoId  = (Integer)medicoLegalList.get(0).getId();
		//Date examinationDate =medicoLegalList.get(0) .getExaminationDate();
		
		MedicoLegalDetails medicoLegalDetails =(MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, medicoId);
		medicoLegalDetails.setIssueToPatient("y");
		hbt.update(medicoLegalDetails);
	}
	
	return map;
}
//----------------------------

public Map<String, Object> getWaitingListCouseOfDeathFinal() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	String[] status={"OPINION OF CAUSE OF DEATH"};
	 Criteria cr=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.in("MlcType", status))
	           .add(Restrictions.eq("Status","A"));
	
	mlcList=cr.list();

	
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getCouseOfDeathFinal(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	int hinId=0;
	String transactionSequenceName = "CouseOfDeathFinal";
	String orderNo = "";
	
	Session session = (Session) getSession();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
	/*
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
	*/
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Final opinion as to cause of death").ignoreCase());
	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	
	
	mlcList=cr.list();
patientWiseMlcs=crMlc.list();
	patientHistories=crHis.list();
	details=crMedico.list();

	Date currentDate = new Date();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
	String dateVal="";
	try {
		dateVal = formatterOut.format(formatterIn.parse(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	/*List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
	medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Final opinion as to cause of death").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
	String srNo="";
	int yr=0;
	for(MedicoLegalDetails m:medicoLegalDetails){
		srNo=m.getSerialNo();
			if(srNo!=null){ 
			yr = Integer.parseInt(srNo.substring(4, 8));
	}
	}	

	int year = Calendar.getInstance().get(Calendar.YEAR);
	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		if(year==yr){
		int s= sequenceNo+1;
		orderNo = dateVal+"-"+s;
		}else{
			orderNo=dateVal+"-"+1;
		}}else{
		orderNo=dateVal+"-"+1;	
		}
*/int year = Calendar.getInstance().get(Calendar.YEAR);
sequenceNoList = session.createCriteria(TransactionSequence.class)
.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
		.createAlias("Hospital", "hosp")
			.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
			.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
		list();

if(sequenceNoList.size()>0){
TransactionSequence transactionSequence = sequenceNoList.get(0);
int sequenceNo = transactionSequence.getTransactionSequenceNumber();


int s= sequenceNo+1;

orderNo = dateVal+"-"+s;

}else{
orderNo=dateVal+"-"+1;	
}/*
	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	
	patientAddress=session.createCriteria(PatientAddress.class) .add(Restrictions.eq("Hin.Id", hinId)).list();
	
	
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details);
 map.put("patientWiseMlcs", patientWiseMlcs);
 map.put("patientAddress", patientAddress);
 map.put("orderNo", orderNo);
	return map;
}

@Override
public Map<String, Object> getWaitingListPostMartemCertificate() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	String[] status={"POSTMORTEM CERTIFICATE"};
	try{
		Criteria cr=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.in("MlcType", status))
	           .add(Restrictions.eq("Status","A"));
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getWaitingListEstimationofAge() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	String[] status={"EXAMINATION FOR ESTIMATION OF AGE"};
	try{
		 Criteria cr=session.createCriteria(PatientWiseMlc.class)
				    .add(Restrictions.in("MlcType", status))
		           .add(Restrictions.eq("Status","A"));
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
		
	}
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getWaitingListChemicalAnalysis() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	String[] status={"Chemical Analysis"};
	try{
		 Criteria cr=session.createCriteria(PatientWiseMlc.class)
				    .add(Restrictions.in("MlcType", status))
		           .add(Restrictions.eq("Status","A"));
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getWaitingListVictimAllegedDrugged() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	Session session = (Session) getSession();
	String[] status={"Examination Of Victim Alleged Drugged"};
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
				    .add(Restrictions.in("MlcName", status))
		           .add(Restrictions.eq("MlcStatus","Authorized"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getWaitingListMedicalOfficerCertificate() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	Session session = (Session) getSession();
	String[] status={"Examination by a Medical Officer"};
	try{
		Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.in("MlcName", status))
	           .add(Restrictions.eq("MlcStatus","Authorized"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getWaitingListExaminationbySMOTTmember() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	Session session = (Session) getSession();
	String[] status={"Examination by a Specialist Medical Officer/Team"};
	try{
		Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.in("MlcName", status))
	           .add(Restrictions.eq("MlcStatus","Authorized"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getWaitingListDNAprofilingexaminationFSL() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	Session session = (Session) getSession();
	String[] status={"Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc"};
	try{
		Criteria cr=session.createCriteria(OpdPatientDetails.class)
				    .add(Restrictions.in("MlcName", status))
		           .add(Restrictions.eq("MlcStatus","Authorized"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getWaitingListPreserveDuringPostmortem() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	Session session = (Session) getSession();
	String[] status={"Preserved During Postmortem Examination"};
	try{
		Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.in("MlcName", status))
	           .add(Restrictions.eq("MlcStatus","Authorized"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getWaitingListFormatForReferring() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	Session session = (Session) getSession();
	String[] status={"REFERRING A POSTMORTEM EXAMINATION"};
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
				    .add(Restrictions.in("MlcName", status))
		           .add(Restrictions.eq("MlcStatus","Authorized"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> addCouseOfDeathFinal(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	PatientWiseMlc patientWiseMlc=null;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String mlcType="";
	String transactionSequenceName = "CouseOfDeathFinal";
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	
	Transaction tx=null;
	try {
		tx = session.beginTransaction();
		

				
			 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
			           .add(Restrictions.eq("MlcType","Final opinion as to cause of death"))
			           .add(Restrictions.eq("OpdPatientDetail.Id",box.getInt("detailId"))).uniqueResult();

	         PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

	          if(wiseMlc!=null){
		            wiseMlc.setStatus("A");
	                 }
		MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
			
			medicoLegalDetails.setSerialNo(box.getString("pmNo"));
			if(!box.getString("postdate").equals("")){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("postdate")));
				}
			
				if(!box.getString("recdate").equals("")){
				medicoLegalDetails.setReceivedDate(HMSUtil.convertStringTypeDateToDateType(box.getString("recdate")));
			    }
		//	medicoLegalDetails.setReceivedTime(box.getString("receivedTime"));
			
				
			medicoLegalDetails.setReceivedFrom(box.getString("receivedFrom"));
			medicoLegalDetails.setPoliceStation(box.getString("policestation"));						
		
			medicoLegalDetails.setConsent(box.getString("consent"));
				if(!box.getString("requisitionDate").equals("")){
			
				medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
			}
				 if(box.getInt("inPatientId")!=0){
						Inpatient inp=new Inpatient();
						inp.setId(box.getInt("inPatientId"));
						medicoLegalDetails.setInpatient(inp);	
					        }
				medicoLegalDetails.setRequisitionTime(box.getString("requisitionTime"));
			medicoLegalDetails.setCrimeNo(box.getString("crno"));
			medicoLegalDetails.setPostmortemPoliceStation(box.getString("ofPolice"));
			if(!box.getString("podate").equals("")){
				medicoLegalDetails.setPostmortemDate(HMSUtil.convertStringTypeDateToDateType(box.getString("podate")));
			    }
			medicoLegalDetails.setPostmortemCertificateNo(box.getString("pcno"));
			medicoLegalDetails.setLaboratory(box.getString("lebotry"));
			medicoLegalDetails.setChemicalAnalysisNo(box.getInt("cmano"));
			
			if(!box.getString("andate").equals("")){
				medicoLegalDetails.setChemicalAnalysisDate(HMSUtil.convertStringTypeDateToDateType(box.getString("andate")));
			    }
			  if(box.getInt("inpationId")!=0 ){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
	
			medicoLegalDetails.setOpinion(box.getString("opinion"));
			medicoLegalDetails.setMlcType("Final opinion as to cause of death");
			
			if(box.getInt("empId")!=0){
			MasEmployee doctor = new MasEmployee();
			doctor.setId(box.getInt("empId"));
			medicoLegalDetails.setDoctor(doctor);
			}
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));

			String srNo=box.getString("pmNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
			if(sequenceNoList.size()>0){
            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
			int orderNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = orderNo + 1;
			int id = transactionSequence.getId();

			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
			transactionSequence2.setTransactionSequenceNumber(orderNo);
			hbt.update(transactionSequence2);
			}else if (sequenceNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTransactionPrefix("OC");
				tsObj.setTransactionSequenceName(transactionSequenceName);
				tsObj.setTransactionSequenceNumber(1);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				MasHospital hospital= new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				tsObj.setHospital(hospital);
				tsObj.setFinanicalYear(yr);
				hbt.save(tsObj);
				
			}
			
			hbt.save(medicoLegalDetails);
			successfullyAdded = true;
			hbt.update(wiseMlc); 
			
			mlcType=medicoLegalDetails.getMlcType();
			medicoLegalDetailsId=medicoLegalDetails.getId();
			 tx.commit();
	
	 
		 
}catch (DataAccessException e) {
	if(tx!=null){
		tx.rollback();	
	}
	e.printStackTrace();
}
//map = showUHIDJsp();
map.put("successfullyAdded", successfullyAdded);
map.put("mlcType", mlcType);
map.put("medicoLegalDetailsId", medicoLegalDetailsId);
map.put("message", message);
return map;
}

@Override
public Map<String, Object> addChemicalAnalysis(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	PatientWiseMlc patientWiseMlc=null;
	String mlcType="";
	String report="";
	String transactionSequenceName = "ChemicalAnalysis";
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();

	Transaction tx=null;
	try {
		tx = session.beginTransaction();
		 if(box.getString("flag").equalsIgnoreCase("submit")){
				
		 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Chemical Analysis"))
		           .add(Restrictions.eq("OpdPatientDetail.Id",box.getInt("detailId"))).uniqueResult();
		   PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

         if(wiseMlc!=null){
	            wiseMlc.setStatus("AT");
                }
		 
		 
		 
			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
			medicoLegalDetails.setSerialNo(box.getString("refname"));
			if(!box.getString("date").equals("")){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("date")));
				}
			medicoLegalDetails.setPatientAddress(box.getString("address"));
			medicoLegalDetails.setCrimeNo(box.getString("crno"));
			medicoLegalDetails.setPoliceStation(box.getString("ofPolice"));	
			medicoLegalDetails.setExaminationPlace(box.getString("conducted"));
			medicoLegalDetails.setMaterialObjectsPreserved(box.getString("mpreserved"));
			medicoLegalDetails.setPreservativeUsed(box.getString("preservative"));
			medicoLegalDetails.setSamplePaking(box.getString("packing"));
			medicoLegalDetails.setSealed(box.getString("tied")+","+box.getString("sealed"));
			medicoLegalDetails.setHistoryOfIllness(box.getString("history"));
			medicoLegalDetails.setFindings(box.getString("findings"));
			medicoLegalDetails.setExaminationRequired(box.getString("examination"));
			medicoLegalDetails.setMlcType("Chemical Analysis");
			
			if(box.getInt("empId")!=0){
			MasEmployee doctor = new MasEmployee();
			doctor.setId(box.getInt("empId"));
			medicoLegalDetails.setDoctor(doctor);
			}
			  if(box.getInt("inpationId")!=0 ){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			
            

				String srNo=box.getString("refname");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
			if(sequenceNoList.size()>0){
           TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
			int orderNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = orderNo + 1;
			int id = transactionSequence.getId();

			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
			transactionSequence2.setTransactionSequenceNumber(orderNo);
			hbt.update(transactionSequence2);
			}else if (sequenceNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTransactionPrefix("CHR");
				tsObj.setTransactionSequenceName(transactionSequenceName);
				tsObj.setTransactionSequenceNumber(1);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				MasHospital hospital= new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				tsObj.setHospital(hospital);
				tsObj.setFinanicalYear(yr);
				hbt.save(tsObj);
				
			}

			
			hbt.save(medicoLegalDetails);
			 hbt.update(wiseMlc); 
			 tx.commit();
			 
			successfullyAdded = true;
			medicoLegalDetailsId=medicoLegalDetails.getId();
	        mlcType=medicoLegalDetails.getMlcType();
		
		 } else if (box.getString("flag").equalsIgnoreCase("authorization")) {
			 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
			           .add(Restrictions.eq("MlcType","Chemical Analysis"))
			           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

			PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

			if(wiseMlc!=null){
		            wiseMlc.setStatus("C");
	           }

	
		
			List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
			medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
					.list();
			 
		if(medicoLegalDetailsList.size()>0){
				MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
				System.out.println(box.getInt("mediCoId"));
				System.out.println(box.getInt("hinId"));
				
		 
				if(box.getInt("hinId")!=0){
					Patient patient = new Patient();
					patient.setId(box.getInt("hinId"));
					medicoLegalDetails.setHin(patient);
					}
					if(box.getInt("detailId")!=0){
						OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
						opdPatientDetails.setId(box.getInt("detailId"));
						medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
						}
					medicoLegalDetails.setSerialNo(box.getString("refname"));
					if(!box.getString("date").equals("")){
						medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("date")));
						}
					medicoLegalDetails.setPatientAddress(box.getString("address"));
					medicoLegalDetails.setCrimeNo(box.getString("crno"));
					medicoLegalDetails.setPoliceStation(box.getString("ofPolice"));	
					medicoLegalDetails.setExaminationPlace(box.getString("conducted"));
					medicoLegalDetails.setMaterialObjectsPreserved(box.getString("mpreserved"));
					medicoLegalDetails.setPreservativeUsed(box.getString("preservative"));
					medicoLegalDetails.setSamplePaking(box.getString("packing"));
					medicoLegalDetails.setSealed(box.getString("tied")+","+box.getString("sealed"));
					medicoLegalDetails.setHistoryOfIllness(box.getString("history"));
					medicoLegalDetails.setFindings(box.getString("findings"));
					medicoLegalDetails.setExaminationRequired(box.getString("examination"));
					medicoLegalDetails.setMlcType("Chemical Analysis");
					
					if(box.getInt("empId")!=0){
					MasEmployee doctor = new MasEmployee();
					doctor.setId(box.getInt("empId"));
					medicoLegalDetails.setDoctor(doctor);
					}
					  if(box.getInt("inpationId")!=0 ){
						   Inpatient inp=new Inpatient();
							  inp.setId(box.getInt("inpationId")); 
						   medicoLegalDetails.setInpatient(inp);
						   }
					
					if(box.getInt("userId")!=0){
						Users users = new Users();
						users.setId(box.getInt("userId"));
						medicoLegalDetails.setLastChgBy(users);
						}
					
						if(!box.getString(CHANGED_DATE).equals("")){
					medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					}
					medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
					
			    	hbt.update(wiseMlc);
								hbt.saveOrUpdate(medicoLegalDetails);
								mlcType=medicoLegalDetails.getMlcType();
								medicoLegalDetailsId=medicoLegalDetails.getId();	
								successfullyAdded = true;
								tx.commit();
		}
		else {

			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
			medicoLegalDetails.setSerialNo(box.getString("refname"));
			if(!box.getString("date").equals("")){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("date")));
				}
			medicoLegalDetails.setPatientAddress(box.getString("address"));
			medicoLegalDetails.setCrimeNo(box.getString("crno"));
			medicoLegalDetails.setPoliceStation(box.getString("ofPolice"));	
			medicoLegalDetails.setExaminationPlace(box.getString("conducted"));
			medicoLegalDetails.setMaterialObjectsPreserved(box.getString("mpreserved"));
			medicoLegalDetails.setPreservativeUsed(box.getString("preservative"));
			medicoLegalDetails.setSamplePaking(box.getString("packing"));
			medicoLegalDetails.setSealed(box.getString("tied")+","+box.getString("sealed"));
			medicoLegalDetails.setHistoryOfIllness(box.getString("history"));
			medicoLegalDetails.setFindings(box.getString("findings"));
			medicoLegalDetails.setExaminationRequired(box.getString("examination"));
			medicoLegalDetails.setMlcType("Chemical Analysis");
			
			if(box.getInt("empId")!=0){
			MasEmployee doctor = new MasEmployee();
			doctor.setId(box.getInt("empId"));
			medicoLegalDetails.setDoctor(doctor);
			}
			  if(box.getInt("inpationId")!=0 ){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			
            

String srNo=box.getString("refname");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
			if(sequenceNoList.size()>0){
           TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
			int orderNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = orderNo + 1;
			int id = transactionSequence.getId();

			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
			transactionSequence2.setTransactionSequenceNumber(orderNo);
			hbt.update(transactionSequence2);
			}else if (sequenceNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTransactionPrefix("CHR");
				tsObj.setTransactionSequenceName("transactionSequenceName");
				tsObj.setTransactionSequenceNumber(1);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				MasHospital hospital= new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				tsObj.setHospital(hospital);
				tsObj.setFinanicalYear(yr);

				hbt.save(tsObj);
				
			}

			
			hbt.save(medicoLegalDetails);
			 hbt.update(wiseMlc); 
			 tx.commit();
			 
			successfullyAdded = true;
			medicoLegalDetailsId=medicoLegalDetails.getId();
	        mlcType=medicoLegalDetails.getMlcType();
		}
		report="need report";
	}		
	
}catch (DataAccessException e) {
	if(tx==null){
		tx.rollback();	
	}
	e.printStackTrace();
}
//map = showUHIDJsp();
map.put("successfullyAdded", successfullyAdded);
map.put("medicoLegalDetailsId", medicoLegalDetailsId);
map.put("mlcType", mlcType);
map.put("message", message);
map.put("report", report);
return map;
}

@Override
public Map<String, Object> getWaitingListAccidentalRegistration() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	try{
		String[] status={"ACCIDENT REGISTER-CUM-WOUND CERTIFICATE"};
	Criteria cr=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.in("MlcType", status))
	           .add(Restrictions.eq("Status","A"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getAccidentalRegistration(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	int hinId=0;
	String transactionSequenceName = "Accidental Reg";
	String orderNo = "";
	Session session = (Session) getSession();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Accident Register-cum-Wound Certificate").ignoreCase());
	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	

	
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();



Date currentDate = new Date();
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
String date = (String) utilMap.get("currentDate");
SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
String dateVal="";
try {
	dateVal = formatterOut.format(formatterIn.parse(date));
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
/*List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Accident Register-cum-Wound Certificate").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
String srNo="";
int yr=0;
for(MedicoLegalDetails m:medicoLegalDetails){
	srNo=m.getSerialNo();
		if(srNo!=null){ 
		yr = Integer.parseInt(srNo.substring(4, 8));
}
}	

int year = Calendar.getInstance().get(Calendar.YEAR);
sequenceNoList = session
		.createCriteria(TransactionSequence.class)
		.add(Restrictions.eq("TransactionSequenceName",
				transactionSequenceName))
				.createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId"))).
				list();
if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	if(year==yr)
	{
		int s= sequenceNo+1;
		orderNo = dateVal+"-"+s;
	}else{
		orderNo=dateVal+"-"+1;
		}
	}else{
	orderNo=dateVal+"-"+1;	
	}
*/int year = Calendar.getInstance().get(Calendar.YEAR);
sequenceNoList = session.createCriteria(TransactionSequence.class)
.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
		.createAlias("Hospital", "hosp")
			.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
			.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
		list();

if(sequenceNoList.size()>0){
TransactionSequence transactionSequence = sequenceNoList.get(0);
int sequenceNo = transactionSequence.getTransactionSequenceNumber();


int s= sequenceNo+1;

orderNo = dateVal+"-"+s;

}else{
orderNo=dateVal+"-"+1;	
}	/*sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	
	
	
	patientAddress=session.createCriteria(PatientAddress.class) .add(Restrictions.eq("Hin.Id", hinId)).list();
	
	
	 
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details); map.put("patientWiseMlcs", patientWiseMlcs);
 map.put("patientAddress", patientAddress);
 map.put("orderNo", orderNo);
 
 
	return map;
}

@Override
public Map<String, Object> getWaitingListExamOfMaleAccusedSexualOffence() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	String[] status={"Examination of a male accused in sexual offence"};
	
	try{
		Criteria cr=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.in("MlcType", status))
	           .add(Restrictions.eq("Status","A"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}

	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getExamOfMaleAccusedSexual(Box box) {	
	Map<String, Object> map = new HashMap<String, Object>();
List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
int hinId=0;
String transactionSequenceName = "ExamOfMaleAccusedSexual";
String orderNo = "";
Session session = (Session) getSession();
List<MlcMaterialObjects> materialObjectsList = new ArrayList<MlcMaterialObjects>();
try{
Criteria cr=session.createCriteria(OpdPatientDetails.class)
		    .add(Restrictions.eq("Id", box.getInt("requestId")));
Criteria crHis=session.createCriteria(OpdPatientHistory.class)
	    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
/*
Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
	    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
*/
Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
.add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Examination of a male accused in sexual offence").ignoreCase());


Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
.add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));




patientWiseMlcs=crMlc.list();
mlcList=cr.list();
patientHistories=crHis.list();
details=crMedico.list();
if(details.size()>0){
MedicoLegalDetails medicoLegalDetails =details.get(0);
int mediCoId= medicoLegalDetails.getId();

materialObjectsList=session.createCriteria(MlcMaterialObjects.class)
.add(Restrictions.eq("MedicoLegalDetails.Id",mediCoId)).list();

}




Date currentDate = new Date();
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
String date = (String) utilMap.get("currentDate");
SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
String dateVal="";
try {
	dateVal = formatterOut.format(formatterIn.parse(date));
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
/*List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Examination of a male accused in sexual offence").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
String srNo="";
int yr=0;
for(MedicoLegalDetails m:medicoLegalDetails){
	srNo=m.getSerialNo();
		if(srNo!=null){ 
		yr = Integer.parseInt(srNo.substring(4, 8));
}
}	*/

int year = Calendar.getInstance().get(Calendar.YEAR);
sequenceNoList = session.createCriteria(TransactionSequence.class)
		.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
				.createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
					.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
				list();

if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	

	int s= sequenceNo+1;

	orderNo = dateVal+"-"+s;
	
	}else{
	orderNo=dateVal+"-"+1;	
	}




/*

sequenceNoList = session
.createCriteria(TransactionSequence.class)
.add(Restrictions.eq("TransactionSequenceName",
		transactionSequenceName))
		.createAlias("Hospital", "hosp")
			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
		list();
if(sequenceNoList.size()>0){
TransactionSequence transactionSequence = sequenceNoList.get(0);
int sequenceNo = transactionSequence.getTransactionSequenceNumber();
orderNo = sequenceNo + 1;
}else{
orderNo=1;	
}*/
if(patientWiseMlcs.size()>0){
	if(patientWiseMlcs.get(0).getHin()!=null){
		hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
	}else{
		hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
	}
	
}
patientAddress=session.createCriteria(PatientAddress.class)
.add(Restrictions.eq("Hin.Id", hinId)).list();

}catch(Exception e){
	e.printStackTrace();
}
map.put("mlcList", mlcList);
map.put("patientHistories", patientHistories);
map.put("details", details);
map.put("patientWiseMlcs", patientWiseMlcs);
map.put("patientAddress", patientAddress);
map.put("orderNo", orderNo);
map.put("materialObjectsList", materialObjectsList);
return map;}

@Override
public Map<String, Object> getWaitingListExamOfFemaleVictimOfSexualAssault() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	String[] status={"EXAMINATION OF A FEMALE VICTIM OF SEXUAL ASSAULT"};
	try{
		Criteria cr=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.in("MlcType", status))
	           .add(Restrictions.eq("Status","A"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getExamOfFemaleVictimOfSexualAssault(Box box) {

	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	Session session = (Session) getSession();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	List<MlcMaterialObjects> materialObjectsList = new ArrayList<MlcMaterialObjects>();
	int hinId=0;
	String transactionSequenceName = "ExamOfFemaleVictimOfSexual";
	String orderNo = "";
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
/*	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
	
*/	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Examination of a female victim of sexual assault").ignoreCase());

	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	

	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();
	if(details.size()>0){
		MedicoLegalDetails medicoLegalDetails =details.get(0);
		int mediCoId= medicoLegalDetails.getId();

		materialObjectsList=session.createCriteria(MlcMaterialObjects.class)
		.add(Restrictions.eq("MedicoLegalDetails.Id",mediCoId)).list();

		}
	
	
	
	
	Date currentDate = new Date();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
	String dateVal="";
	try {
		dateVal = formatterOut.format(formatterIn.parse(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	/*List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
	medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Examination of a female victim of sexual assault").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
	String srNo="";
	int yr=0;
	for(MedicoLegalDetails m:medicoLegalDetails){
		srNo=m.getSerialNo();
			if(srNo!=null){ 
			yr = Integer.parseInt(srNo.substring(4, 8));
	}
	}	
*/
	int year = Calendar.getInstance().get(Calendar.YEAR);
	sequenceNoList = session.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
						.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
					list();

	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		

		int s= sequenceNo+1;

		orderNo = dateVal+"-"+s;
		
		}else{
		orderNo=dateVal+"-"+1;	
		}
	/*sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	patientAddress=session.createCriteria(PatientAddress.class)
		    .add(Restrictions.eq("Hin.Id", hinId)).list();

	
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details);
 map.put("patientWiseMlcs", patientWiseMlcs);
 map.put("patientAddress", patientAddress);
 map.put("orderNo", orderNo);
 map.put("materialObjectsList", materialObjectsList);
	return map;
	
	
}
@Override
public Map<String, Object> getWaitingListDunknness() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	String[] status={"Certificate Of Drunkness"};
	
	try{
		Criteria cr=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.in("MlcType", status))
	           .add(Restrictions.eq("Status","A"));
	
	mlcList=cr.list();
	
	}catch(Exception e){
		e.printStackTrace();
	}
	map.put("mlcList", mlcList);
	return map;
}


@Override
public Map<String, Object> getDunknness(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	Session session = (Session) getSession();
	int hinId=0;
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	String transactionSequenceName = "Dunknness";
	String orderNo = "";
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
/*	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
*/	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Certificate Of Drunkness").ignoreCase());

	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));

	
	
	
   patientWiseMlcs=crMlc.list();
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();

	Date currentDate = new Date();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
	String dateVal="";
	try {
		dateVal = formatterOut.format(formatterIn.parse(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	/*List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
	medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Certificate Of Drunkness").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
	String srNo="";
	int yr=0;
	for(MedicoLegalDetails m:medicoLegalDetails){
		srNo=m.getSerialNo();
			if(srNo!=null){ 
			yr = Integer.parseInt(srNo.substring(4, 8));
	}
	}	

	int year = Calendar.getInstance().get(Calendar.YEAR);*/
	int year = Calendar.getInstance().get(Calendar.YEAR);
	sequenceNoList = session.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
						.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
					list();

	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		

		int s= sequenceNo+1;

		orderNo = dateVal+"-"+s;
		
		}else{
		orderNo=dateVal+"-"+1;	
		}/*
	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		if(yr!=0 && year==yr){
		int s= sequenceNo+1;
		orderNo = dateVal+"-"+s;
		}else{
			orderNo=dateVal+"-"+1;
		}}else{
		orderNo=dateVal+"-"+1;	
		}*/

	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	patientAddress=session.createCriteria(PatientAddress.class)
		    .add(Restrictions.eq("Hin.Id", hinId)).list();
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details);
 map.put("patientAddress", patientAddress);
map.put("patientWiseMlcs", patientWiseMlcs);
map.put("orderNo", orderNo);
	return map;
}

@Override
public Map<String, Object> getWaitingListExamOfVictimOfUnnaturalSexualOffence() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	String[] status={"EXAMINATION OF A VICTIM OF UNNATURAL SEXUAL OFFENCE"};
	try{
		Criteria cr=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.in("MlcType", status))
	           .add(Restrictions.eq("Status","A"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getWaitingListTreatment_Dischargr_JSP() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	String[] status={"TREATMENT DISCHARGE CERTIFICATE"};
	try{
		Criteria cr=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.in("MlcType", status))
	           .add(Restrictions.eq("Status","A"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getExamOfVictimOfUnnaturalSexualOffence(Box box) {


	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	Session session = (Session) getSession();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	List<MlcMaterialObjects> materialObjectsList = new ArrayList<MlcMaterialObjects>();
	int hinId=0;
	String transactionSequenceName = "ExamOfVictimOfUnnaturalSexual";
	String orderNo = "";
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
/*	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
	
*/	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Examination of a victim of unnatural sexual offence").ignoreCase());

	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	
	
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();
	if(details.size()>0){
		MedicoLegalDetails medicoLegalDetails =details.get(0);
		int mediCoId= medicoLegalDetails.getId();

		materialObjectsList=session.createCriteria(MlcMaterialObjects.class)
		.add(Restrictions.eq("MedicoLegalDetails.Id",mediCoId)).list();

		}

	Date currentDate = new Date();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
	String dateVal="";
	try {
		dateVal = formatterOut.format(formatterIn.parse(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int year = Calendar.getInstance().get(Calendar.YEAR);
	sequenceNoList = session.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
						.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
					list();

	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		

		int s= sequenceNo+1;

		orderNo = dateVal+"-"+s;
		
		}else{
		orderNo=dateVal+"-"+1;	
		}
	/*List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
	medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Examination of a victim of unnatural sexual offence").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
	String srNo="";
	int yr=0;
	for(MedicoLegalDetails m:medicoLegalDetails){
		srNo=m.getSerialNo();
			if(srNo!=null){ 
			yr = Integer.parseInt(srNo.substring(4, 8));
	}
	}	
*/
	//int year = Calendar.getInstance().get(Calendar.YEAR);
	/*sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		if(yr!=0 && year==yr){
		int s= sequenceNo+1;
		orderNo = dateVal+"-"+s;
		}else{
			orderNo=dateVal+"-"+1;
		}}else{
		orderNo=dateVal+"-"+1;	
		}*/
	/*sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	System.out.println(box.getInt("hospitalId")+"hosId");
	System.out.println(sequenceNoList.size());
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
/*	patientAddress=session.createCriteria(PatientAddress.class)
		    .add(Restrictions.eq("Hin.Id", hinId)).list();*/
	patientAddress = (List) session
			.createSQLQuery(
					"select *  from patient_address pa on pa.hin_id ="
							+ hinId + " and pa.address_type_id = "
									+ "CASE    WHEN (EXISTS(select address from patient_address where address_type_id = 2)) THEN 2"
									+ "  WHEN (EXISTS(select address from patient_address where address_type_id = 1)) THEN 1"
									+ "  ELSE 4	END ").list();
	
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details);
 map.put("patientWiseMlcs", patientWiseMlcs);
 map.put("patientAddress", patientAddress);
 map.put("orderNo", orderNo);
 map.put("materialObjectsList", materialObjectsList);
	return map;
	
}

@Override
public Map<String, Object> getTreatment_Dischargr(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	Session session = (Session) getSession();
//	List<Patient> patientList = new ArrayList<Patient>();
	List<MasEmployee> emplist = new ArrayList<MasEmployee>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	
	int hinId=0;
	String transactionSequenceName = "TreatmentDischarge";
	String orderNo = "";
	
	try{
		Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
		Criteria crHis=session.createCriteria(OpdPatientHistory.class)
			    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
/*		Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
			    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
*/		
		Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
			    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Treatment / Discharge Certificate").ignoreCase());

		Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
		inpatientList = session.createCriteria(Inpatient.class).createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", box.getString("uhinId"))).list();
		map.put("inpatientList", inpatientList);
		patientWiseMlcs=crMlc.list();
		
//	patientList=session.createCriteria(Patient.class).list();
	int empCategoryCodeForDoctor =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "empCategoryCodeForDoctor"));
	emplist=session.createCriteria(MasEmployee.class).createAlias("EmpCategory", "cat").add(Restrictions.eq("cat.Id", empCategoryCodeForDoctor)).list();
	
	mlcList=cr.list();

		
	/*List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
	medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Treatment / Discharge Certificate").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
	String srNo="";
	int yr=0;
	for(MedicoLegalDetails m:medicoLegalDetails){
		srNo=m.getSerialNo();
			if(srNo!=null){ 
			yr = Integer.parseInt(srNo.substring(4, 8));
	}
	}	*/

	//int year = Calendar.getInstance().get(Calendar.YEAR);
	
	


Date currentDate = new Date();
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
String date = (String) utilMap.get("currentDate");
SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
String dateVal="";
try {
	dateVal = formatterOut.format(formatterIn.parse(date));
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


int year = Calendar.getInstance().get(Calendar.YEAR);
sequenceNoList = session.createCriteria(TransactionSequence.class)
		.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
				.createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
					.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
				list();

if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	

	int s= sequenceNo+1;

	orderNo = dateVal+"-"+s;
	
	}else{
	orderNo=dateVal+"-"+1;	
	}


	/*
	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	details=crMedico.list();
	
	patientAddress=session.createCriteria(PatientAddress.class) .add(Restrictions.eq("Hin.Id", hinId)).list();
	
	
	}catch(Exception e){
		e.printStackTrace();
	}
		
//	map.put("patientList", patientList);
	map.put("emplist", emplist);
     map.put("mlcList", mlcList);
     map.put("patientHistories", patientHistories);
     map.put("details", details);
     map.put("inpatientList", inpatientList);
     map.put("patientWiseMlcs", patientWiseMlcs);
     map.put("patientAddress", patientAddress);
     map.put("orderNo", orderNo);
	return map;
}

@Override
public Map<String, Object> getWaitingListExamOfEvidenceOfRecentDelivery() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	String[] status={"EXAMINATION FOR EVIDENCE OF RECENT DELIVERY"};
	try{
	
		Criteria cr=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.in("MlcType", status))
	           .add(Restrictions.eq("Status","A"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getEvidenceOfRecentDelivery(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	int hinId=0;
	String transactionSequenceName = "ExamOfEvidenceOfRecentDelivery";
	String orderNo = "";
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
/*	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
*/	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Examination for evidence of recent delivery").ignoreCase());

	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	
	
	mlcList=cr.list();
	patientWiseMlcs=crMlc.list();
	patientHistories=crHis.list();
	details=crMedico.list();

	Date currentDate = new Date();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
	String dateVal="";
	try {
		dateVal = formatterOut.format(formatterIn.parse(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	/*List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
	medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Examination for evidence of recent delivery").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
	String srNo="";
	int yr=0;
	for(MedicoLegalDetails m:medicoLegalDetails){
		srNo=m.getSerialNo();
			if(srNo!=null){ 
			yr = Integer.parseInt(srNo.substring(4, 8));
	}
	}	

	int year = Calendar.getInstance().get(Calendar.YEAR);
*/	
	
	int year = Calendar.getInstance().get(Calendar.YEAR);
	sequenceNoList = session.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
						.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
					list();

	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		

		int s= sequenceNo+1;

		orderNo = dateVal+"-"+s;
		
		}else{
		orderNo=dateVal+"-"+1;	
		}
	/*
	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	patientAddress=session.createCriteria(PatientAddress.class)
		    .add(Restrictions.eq("Hin.Id", hinId)).list();
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details);
 map.put("patientWiseMlcs", patientWiseMlcs);
 map.put("patientAddress", patientAddress);
 map.put("orderNo", orderNo);

	return map;
}

@Override
public Map<String, Object> getWaitingListPostExaminToPoliceSurgun() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	String[] status={"POSTMORTEM CERTIFICATE"};
	try{
		Criteria cr=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.in("MlcType", status))
	           .add(Restrictions.eq("Status","A"));
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
	
	map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> addPostMartemCertificate(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	PatientWiseMlc patientWiseMlc=null;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String mlcType="";
	Transaction tx=null;
	try {
		tx = session.beginTransaction();
		patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","POSTMORTEM CERTIFICATE"))
		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

      PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

       if(wiseMlc!=null){
	            wiseMlc.setStatus("A");
              }

		MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			
					
		     medicoLegalDetails.setPostmortemSerNo(box.getString("pmno"));
		     
			if(!box.getString("postdate").equals("")){
				medicoLegalDetails.setPostmortemDate(HMSUtil.convertStringTypeDateToDateType(box.getString("postdate")));
				}
			
				if(!box.getString("receivedDate").equals("")){
				medicoLegalDetails.setReceivedDate(HMSUtil.convertStringTypeDateToDateType(box.getString("receivedDate")));
			    }
				medicoLegalDetails.setCrimeNo(box.getString("crimeNo"));
				medicoLegalDetails.setPoliceStation(box.getString("ofPolice"));	
				medicoLegalDetails.setReceivedFrom(box.getString("receivedFrom"));
				medicoLegalDetails.setReceivedTime(box.getString("receivedTime"));
				if(!box.getString("resdate").equals("")){
				medicoLegalDetails.setReceivedDate(HMSUtil.convertStringTypeDateToDateType(box.getString("resdate")));
				}
				medicoLegalDetails.setPostmortemCertificateNo(box.getString("pmcertificateNo"));
				medicoLegalDetails.setPostmoremTime(box.getString("atTime"));
				if(!box.getString("ondate").equals("")){
				medicoLegalDetails.setPostmortemDate(HMSUtil.convertStringTypeDateToDateType(box.getString("ondate")));
				}
				medicoLegalDetails.setConcludedAt(box.getString("coAt"));
				medicoLegalDetails.setCauseDeath(box.getString("resionDeath"));
				medicoLegalDetails.setLatterCrimeNo(box.getString("latterCrimeNo"));
				if(box.getString("crdate")!=null && !box.getString("crdate").equals("")){
				medicoLegalDetails.setCrimeDate(HMSUtil.convertStringTypeDateToDateType(box.getString("crdate")));
				}
				medicoLegalDetails.setFindings(box.getString("postMortem"));
				medicoLegalDetails.setOpinion(box.getString("opinion"));
				
			medicoLegalDetails.setMlcType("POSTMORTEM CERTIFICATE");
			
			if(box.getInt("empId")!=0){
			MasEmployee doctor = new MasEmployee();
			doctor.setId(box.getInt("empId"));
			medicoLegalDetails.setDoctor(doctor);
			}
			
			 if(box.getInt("inPatientId")!=0){
					Inpatient inp=new Inpatient();
					inp.setId(box.getInt("inPatientId"));
					medicoLegalDetails.setInpatient(inp);	
				        }
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			hbt.save(medicoLegalDetails);
			medicoLegalDetailsId=medicoLegalDetails.getId();
			mlcType=medicoLegalDetails.getMlcType();
			successfullyAdded = true;
			hbt.update(wiseMlc); 
			 tx.commit();

}catch (DataAccessException e) {
	if(tx==null){
		tx.rollback();	
	}
	e.printStackTrace();
}
//map = showUHIDJsp();
map.put("successfullyAdded", successfullyAdded);
map.put("medicoLegalDetailsId", medicoLegalDetailsId);
map.put("mlcType", mlcType);
map.put("message", message);
return map;
}

@Override
public Map<String, Object> addEstimationofAge(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	PatientWiseMlc patientWiseMlc=null;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String mlcType="";
	String report="";
	String transactionSequenceName = "EstimationofAge";
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	
	
	Transaction tx=null;
	try {
		tx = session.beginTransaction(); 
		if(box.getString("flag").equalsIgnoreCase("submit")){
			
		patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Examination for estimation of age"))
		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

      PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

       if(wiseMlc!=null){
	            wiseMlc.setStatus("AT");
              }


			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
			medicoLegalDetails.setRequisitionFrom(box.getString("reqname"));
			medicoLegalDetails.setRequisitionTime(box.getString("time"));
			medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
			   if(!box.getString("refMLDate").equals("")){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
				}
			   if(!box.getString("requisitionDate").equals("")){
				medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
				}
				medicoLegalDetails.setCrimeNo(box.getString("crimeNo")); 
				medicoLegalDetails.setPoliceStation(box.getString("policestation"));
				medicoLegalDetails.setConsent(box.getString("consent"));
				medicoLegalDetails.setIdMark1(box.getString("marks1"));
				medicoLegalDetails.setIdMark2(box.getString("marks2"));
				medicoLegalDetails.setWeight(box.getInt("weight"));
				medicoLegalDetails.setHeight(box.getInt("height"));
				medicoLegalDetails.setBuild(box.getString("build"));
			//	medicoLegalDetails.setHair(box.getString("moustache"));
			    medicoLegalDetails.setOpinion(box.getString("opinion"));
			    medicoLegalDetails.setMlcType("Examination for estimation of age");
			    medicoLegalDetails.setBreasts(box.getString("breasts"));
			    if(box.getString("menstrualDate")!=null){
			    medicoLegalDetails.setLastMenstrualDate(HMSUtil.convertStringTypeDateToDateType(box.getString("menstrualDate")));
			    }
			    medicoLegalDetails.setVoice(box.getString("voice"));
			    medicoLegalDetails.setAdamApple(box.getString("adamApple"));
			    medicoLegalDetails.setMoustache( box.getString("moustache"));
			    medicoLegalDetails.setPubicHair( box.getString("pubicHair"));
			    medicoLegalDetails.setAxillary( box.getString("axillary"));
			    medicoLegalDetails.setChestHair( box.getString("chest"));
			    medicoLegalDetails.setElbow(box.getString("elbow"));
			    medicoLegalDetails.setExternalGenitalia(box.getString("genitalia"));
			    medicoLegalDetails.setTeeth( box.getInt("teeth"));
			    medicoLegalDetails.setTemporary( box.getInt("temporaryteeth"));
			    medicoLegalDetails.setPermanentTeeth( box.getInt("permanentteeth"));
			    medicoLegalDetails.setDetailsTeeth( box.getString("detailsteath"));
			    medicoLegalDetails.setShoulder( box.getString("shoulder"));
			    medicoLegalDetails.setWrist(box.getString("wrist"));
			    medicoLegalDetails.setPelvis(box.getString("pelvis"));
			    medicoLegalDetails.setSkullJaw( box.getString("skull"));
			    medicoLegalDetails.setOpinion(box.getString("opinion"));				
			    medicoLegalDetails.setExamCommTime(box.getString("exTime"));	   
				   if(!box.getString("examinDate").equals("")){
						medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinDate")));
						}

			    medicoLegalDetails.setMenarchyEjaculation(box.getString("ejaculation"));
			    medicoLegalDetails.setPatientAddress(box.getString("address"));
				
			if(box.getInt("empId")!=0){
			MasEmployee doctor = new MasEmployee();
			doctor.setId(box.getInt("empId"));
			medicoLegalDetails.setDoctor(doctor);
			}
			  if(box.getInt("inpationId")!=0 ){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			/* sequenceNoList = session
	 					.createCriteria(TransactionSequence.class)
	 					.add(Restrictions.eq("TransactionSequenceName",
	 							transactionSequenceName))
	 							.createAlias("Hospital", "hosp")
			 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
	 							.list();*/

String srNo=box.getString("refMLNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
	 			if(sequenceNoList.size()>0){
	            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
	 			int orderNo = transactionSequence.getTransactionSequenceNumber();
	 			orderNo = orderNo + 1;
	 			int id = transactionSequence.getId();

	 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
	 			transactionSequence2.setTransactionSequenceNumber(orderNo);
	 			hbt.update(transactionSequence2);
	 			}else if (sequenceNoList.size() == 0) {
	 				TransactionSequence tsObj = new TransactionSequence();
	 				tsObj.setStatus("y");
	 				tsObj.setTransactionPrefix("EOA");
	 				tsObj.setTransactionSequenceName(transactionSequenceName);
	 				tsObj.setTransactionSequenceNumber(1);
	 				tsObj.setCreatedby("admin");
	 				tsObj.setStatus("y");
	 				MasHospital hospital= new MasHospital();
	 				hospital.setId(box.getInt("hospitalId"));
	 				tsObj.setHospital(hospital);
	 				tsObj.setFinanicalYear(yr);

	 				hbt.save(tsObj);
	 				
	 			}
			
			
			hbt.save(medicoLegalDetails);
			medicoLegalDetailsId=medicoLegalDetails.getId();
			mlcType=medicoLegalDetails.getMlcType();
			successfullyAdded = true;
			hbt.update(wiseMlc); 
			 tx.commit();
	
		}
		
		
		 else if (box.getString("flag").equalsIgnoreCase("authorization")) {
				
			 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
			           .add(Restrictions.eq("MlcType","Examination for estimation of age"))
			           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

	            PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

	           if(wiseMlc!=null){
		          wiseMlc.setStatus("C");
	               }
				
				
				List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
				medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
						.list();
				 
			if(medicoLegalDetailsList.size()>0){
					MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
					
					
					if(box.getInt("hinId")!=0){
					Patient patient = new Patient();
					patient.setId(box.getInt("hinId"));
					medicoLegalDetails.setHin(patient);
					}
					if(box.getInt("detailId")!=0){
						OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
						opdPatientDetails.setId(box.getInt("detailId"));
						medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
						}
					medicoLegalDetails.setRequisitionFrom(box.getString("reqname"));
					medicoLegalDetails.setRequisitionTime(box.getString("time"));
					medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
					   if(!box.getString("refMLDate").equals("")){
						medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
						}
					   if(!box.getString("requisitionDate").equals("")){
						medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
						}
						medicoLegalDetails.setCrimeNo(box.getString("crimeNo")); 
						medicoLegalDetails.setPoliceStation(box.getString("policestation"));
						medicoLegalDetails.setConsent(box.getString("consent"));
						medicoLegalDetails.setIdMark1(box.getString("marks1"));
						medicoLegalDetails.setIdMark2(box.getString("marks2"));
						medicoLegalDetails.setWeight(box.getInt("weight"));
						medicoLegalDetails.setHeight(box.getInt("height"));
						medicoLegalDetails.setBuild(box.getString("build"));
					//	medicoLegalDetails.setHair(box.getString("moustache"));
					    medicoLegalDetails.setOpinion(box.getString("opinion"));
					    medicoLegalDetails.setMlcType("Examination for estimation of age");
					    medicoLegalDetails.setBreasts(box.getString("breasts"));
					    if(box.getString("menstrualDate")!=null){
					    medicoLegalDetails.setLastMenstrualDate(HMSUtil.convertStringTypeDateToDateType(box.getString("menstrualDate")));
					    }
					    medicoLegalDetails.setVoice(box.getString("voice"));
					    medicoLegalDetails.setAdamApple(box.getString("adamApple"));
					    medicoLegalDetails.setMoustache( box.getString("moustache"));
					    medicoLegalDetails.setPubicHair( box.getString("pubicHair"));
					    medicoLegalDetails.setAxillary( box.getString("axillary"));
					    medicoLegalDetails.setChestHair( box.getString("chest"));
					    medicoLegalDetails.setElbow(box.getString("elbow"));
					    medicoLegalDetails.setExternalGenitalia(box.getString("genitalia"));
					    medicoLegalDetails.setTeeth( box.getInt("teeth"));
					    medicoLegalDetails.setTemporary( box.getInt("temporaryteeth"));
					    medicoLegalDetails.setPermanentTeeth( box.getInt("permanentteeth"));
					    medicoLegalDetails.setDetailsTeeth( box.getString("detailsteath"));
					    medicoLegalDetails.setShoulder( box.getString("shoulder"));
					    medicoLegalDetails.setWrist(box.getString("wrist"));
					    medicoLegalDetails.setPelvis(box.getString("pelvis"));
					    medicoLegalDetails.setSkullJaw( box.getString("skull"));
					    medicoLegalDetails.setOpinion(box.getString("opinion"));				
					    medicoLegalDetails.setExamCommTime(box.getString("exTime"));	   
						   if(!box.getString("examinDate").equals("")){
								medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinDate")));
								}

					    medicoLegalDetails.setMenarchyEjaculation(box.getString("ejaculation"));
					    medicoLegalDetails.setPatientAddress(box.getString("address"));
						
					if(box.getInt("empId")!=0){
					MasEmployee doctor = new MasEmployee();
					doctor.setId(box.getInt("empId"));
					medicoLegalDetails.setDoctor(doctor);
					}
					  if(box.getInt("inpationId")!=0 ){
						   Inpatient inp=new Inpatient();
							  inp.setId(box.getInt("inpationId")); 
						   medicoLegalDetails.setInpatient(inp);
						   }
					
					if(box.getInt("userId")!=0){
						Users users = new Users();
						users.setId(box.getInt("userId"));
						medicoLegalDetails.setLastChgBy(users);
						}
					
						if(!box.getString(CHANGED_DATE).equals("")){
					medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					}
					medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
					
			        
			    	hbt.update(wiseMlc);
					hbt.saveOrUpdate(medicoLegalDetails);
					mlcType=medicoLegalDetails.getMlcType();
					medicoLegalDetailsId=medicoLegalDetails.getId();	
					successfullyAdded = true;
					tx.commit();
			}
			else {

				MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
				if(box.getInt("hinId")!=0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				medicoLegalDetails.setHin(patient);
				}
				if(box.getInt("detailId")!=0){
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(box.getInt("detailId"));
					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
					}
				medicoLegalDetails.setRequisitionFrom(box.getString("reqname"));
				medicoLegalDetails.setRequisitionTime(box.getString("time"));
				medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
				   if(!box.getString("refMLDate").equals("")){
					medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
					}
				   if(!box.getString("requisitionDate").equals("")){
					medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
					}
					medicoLegalDetails.setCrimeNo(box.getString("crimeNo")); 
					medicoLegalDetails.setPoliceStation(box.getString("policestation"));
					medicoLegalDetails.setConsent(box.getString("consent"));
					medicoLegalDetails.setIdMark1(box.getString("marks1"));
					medicoLegalDetails.setIdMark2(box.getString("marks2"));
					medicoLegalDetails.setWeight(box.getInt("weight"));
					medicoLegalDetails.setHeight(box.getInt("height"));
					medicoLegalDetails.setBuild(box.getString("build"));
				//	medicoLegalDetails.setHair(box.getString("moustache"));
				    medicoLegalDetails.setOpinion(box.getString("opinion"));
				    medicoLegalDetails.setMlcType("Examination for estimation of age");
				    medicoLegalDetails.setBreasts(box.getString("breasts"));
				    if(box.getString("menstrualDate")!=null){
				    medicoLegalDetails.setLastMenstrualDate(HMSUtil.convertStringTypeDateToDateType(box.getString("menstrualDate")));
				    }
				    medicoLegalDetails.setVoice(box.getString("voice"));
				    medicoLegalDetails.setAdamApple(box.getString("adamApple"));
				    medicoLegalDetails.setMoustache( box.getString("moustache"));
				    medicoLegalDetails.setPubicHair( box.getString("pubicHair"));
				    medicoLegalDetails.setAxillary( box.getString("axillary"));
				    medicoLegalDetails.setChestHair( box.getString("chest"));
				    medicoLegalDetails.setElbow(box.getString("elbow"));
				    medicoLegalDetails.setExternalGenitalia(box.getString("genitalia"));
				    medicoLegalDetails.setTeeth( box.getInt("teeth"));
				    medicoLegalDetails.setTemporary( box.getInt("temporaryteeth"));
				    medicoLegalDetails.setPermanentTeeth( box.getInt("permanentteeth"));
				    medicoLegalDetails.setDetailsTeeth( box.getString("detailsteath"));
				    medicoLegalDetails.setShoulder( box.getString("shoulder"));
				    medicoLegalDetails.setWrist(box.getString("wrist"));
				    medicoLegalDetails.setPelvis(box.getString("pelvis"));
				    medicoLegalDetails.setSkullJaw( box.getString("skull"));
				    medicoLegalDetails.setOpinion(box.getString("opinion"));				
				    medicoLegalDetails.setExamCommTime(box.getString("exTime"));	   
					   if(!box.getString("examinDate").equals("")){
							medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinDate")));
							}

				    medicoLegalDetails.setMenarchyEjaculation(box.getString("ejaculation"));
				    medicoLegalDetails.setPatientAddress(box.getString("address"));
					
				if(box.getInt("empId")!=0){
				MasEmployee doctor = new MasEmployee();
				doctor.setId(box.getInt("empId"));
				medicoLegalDetails.setDoctor(doctor);
				}
				  if(box.getInt("inpationId")!=0 ){
					   Inpatient inp=new Inpatient();
						  inp.setId(box.getInt("inpationId")); 
					   medicoLegalDetails.setInpatient(inp);
					   }
				
				if(box.getInt("userId")!=0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					medicoLegalDetails.setLastChgBy(users);
					}
				
					if(!box.getString(CHANGED_DATE).equals("")){
				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
				
				String srNo=box.getString("refMLNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
		 			if(sequenceNoList.size()>0){
		            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
		 			int orderNo = transactionSequence.getTransactionSequenceNumber();
		 			orderNo = orderNo + 1;
		 			int id = transactionSequence.getId();

		 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
		 			transactionSequence2.setTransactionSequenceNumber(orderNo);
		 			hbt.update(transactionSequence2);
		 			}else if (sequenceNoList.size() == 0) {
		 				TransactionSequence tsObj = new TransactionSequence();
		 				tsObj.setStatus("y");
		 				tsObj.setTransactionPrefix("EOA");
		 				tsObj.setTransactionSequenceName(transactionSequenceName);
		 				tsObj.setTransactionSequenceNumber(1);
		 				tsObj.setCreatedby("admin");
		 				tsObj.setStatus("y");
		 				MasHospital hospital= new MasHospital();
		 				hospital.setId(box.getInt("hospitalId"));
		 				tsObj.setHospital(hospital);
		 				tsObj.setFinanicalYear(yr);
		 				hbt.save(tsObj);
		 				
		 			}
				
				
				hbt.save(medicoLegalDetails);
				medicoLegalDetailsId=medicoLegalDetails.getId();
				mlcType=medicoLegalDetails.getMlcType();
				successfullyAdded = true;
				hbt.update(wiseMlc); 
				 tx.commit();
		
				
			}
			report="need report";
		 }
		
}catch (DataAccessException e) {
	if(tx==null){
		tx.rollback();	
	}
	e.printStackTrace();
}

map.put("successfullyAdded", successfullyAdded);
map.put("medicoLegalDetailsId", medicoLegalDetailsId);
map.put("mlcType", mlcType);
map.put("message", message);
map.put("report", report);
return map;
}

@Override
public Map<String, Object> getPostMartemCertificate(int id) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	Session session = (Session) getSession();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", id));
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
	return map;
}

@Override
public Map<String, Object> getChemicalAnalysis(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	Session session = (Session) getSession();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	int hinId=0;
	String transactionSequenceName = "ChemicalAnalysis";
	String orderNo = "";
	
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	try{
		Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
		Criteria crHis=session.createCriteria(OpdPatientHistory.class)
			    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
/*		Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
			    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
*/		
		Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
				.add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Chemical Analysis").ignoreCase());

		Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
		
		patientWiseMlcs=crMlc.list();
		
	
	mlcList=cr.list();
	details=crMedico.list();

	Date currentDate = new Date();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
	String dateVal="";
	try {
		dateVal = formatterOut.format(formatterIn.parse(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	/*List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
	medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Chemical Analysis").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
	String srNo="";
	int yr=0;
	for(MedicoLegalDetails m:medicoLegalDetails){
		srNo=m.getSerialNo();
			if(srNo!=null){ 
			yr = Integer.parseInt(srNo.substring(4, 8));
	}
	}	

	int year = Calendar.getInstance().get(Calendar.YEAR);
*//*	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		if(yr!=0 && year==yr){
		int s= sequenceNo+1;
		orderNo = dateVal+"-"+s;
		}else{
			orderNo=dateVal+"-"+1;
		}}else{
		orderNo=dateVal+"-"+1;	
		}*/
	int year = Calendar.getInstance().get(Calendar.YEAR);
	sequenceNoList = session.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
						.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
					list();

	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		

		int s= sequenceNo+1;

		orderNo = dateVal+"-"+s;
		
		}else{
		orderNo=dateVal+"-"+1;	
		}
	/*sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	
	
	
	patientAddress=session.createCriteria(PatientAddress.class) .add(Restrictions.eq("Hin.Id", hinId)).list();
	
	
	
	}catch(Exception e){
		e.printStackTrace();
	}

     map.put("mlcList", mlcList);
       map.put("details", details);
     map.put("patientWiseMlcs", patientWiseMlcs);
     map.put("patientAddress", patientAddress);
     map.put("orderNo", orderNo);
     
	return map;
}

@Override
public Map<String, Object> addMedicalOfficerCertificate(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	 PatientWiseMlc patientWiseMlc=null;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String mlcType="";
	String transactionSequenceName = "MedicalOfficerCertificate";
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	String report="";
	Transaction tx=null;
	try {
		tx = session.beginTransaction();
		 if(box.getString("flag").equalsIgnoreCase("submit")){
		patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Examination by a Medical Officer"))
		           .add(Restrictions.eq("OpdPatientDetail.Id",box.getInt("detailId"))).uniqueResult();

		
		
		PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());
		System.out.println(wiseMlc);
		if(wiseMlc!=null){
	            wiseMlc.setStatus("AT");
           }


			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
			
			
			medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
			if(!box.getString("refMLDate").equals("")){
			medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
			}
			medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
		
			
			   if(!box.getString("requisitionDate").equals("")){
				medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
				}
			   medicoLegalDetails.setCrimeNo(box.getString("crNO"));
			   
			   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));	
			   medicoLegalDetails.setConsent(box.getString("consent"));
			   medicoLegalDetails.setExaminationPlace(box.getString("placeExamination"));
				
				medicoLegalDetails.setExaminationTime(box.getString("examConcludedTime"));
				if(!box.getString("examinationConcludedDate").equals("")){
				medicoLegalDetails.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinationConcludedDate")));
				}
		  
			medicoLegalDetails.setIdMark1(box.getString("idmark1"));
			medicoLegalDetails.setIdMark2(box.getString("idmark2"));
			//medicoLegalDetails.setInjuryDetails(box.getString("injury"));
			medicoLegalDetails.setHistoryOfIllness(box.getString("illness"));
			medicoLegalDetails.setHeight(box.getInt("height"));
			medicoLegalDetails.setWeight(box.getInt("weight"));
			
			if(box.getString("buildnourishment")!=null && !box.getString("buildnourishment").equals("")){		
			medicoLegalDetails.setBuild(box.getString("buildnourishment"));
	}
		
			
			  if(box.getInt("inpationId")!=0 ){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
			medicoLegalDetails.setRemarks(box.getString("remarks"));
			medicoLegalDetails.setPulse(box.getInt("pulse"));
			medicoLegalDetails.setBp(box.getString("bp"));
					
		   medicoLegalDetails.setOpinion(box.getString("opinion"));
			medicoLegalDetails.setMlcType("Examination by a Medical Officer");
			medicoLegalDetails.setInjuryDetails(box.getString("injuries"));
			medicoLegalDetails.setInvResult(box.getString("investigations"));
			medicoLegalDetails.setPallor(box.getString("pallor"));
			medicoLegalDetails.setDeformity(box.getString("deformity"));
			medicoLegalDetails.setGis(box.getString("gis"));
			medicoLegalDetails.setRs( box.getString("rs"));
			medicoLegalDetails.setNs(box.getString("ns"));
			medicoLegalDetails.setCvs(box.getString("cvs"));
			//medicoLegalDetails.setInjuryOnBody(box.getString("injuries"));
			//medicoLegalDetails.setInvResult(box.getString("investigations"));
			
			if(box.getInt("empId")!=0){
			MasEmployee doctor = new MasEmployee();
			doctor.setId(box.getInt("empId"));
			medicoLegalDetails.setDoctor(doctor);
			}
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			
			String srNo=box.getString("refMLNo");
			String yr = "";
			if(srNo!=null){ 
					 yr = srNo.substring(4, 8);
					
			}				
			sequenceNoList = session
	 					.createCriteria(TransactionSequence.class)
	 					.add(Restrictions.eq("TransactionSequenceName",
	 							transactionSequenceName))
	 							.createAlias("Hospital", "hosp")
			 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
			 			.add(Restrictions.eq("FinanicalYear", yr))
	 							.list();
	 			if(sequenceNoList.size()>0){
	            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
	 			int orderNo = transactionSequence.getTransactionSequenceNumber();
	 			orderNo = orderNo + 1;
	 			int id = transactionSequence.getId();

	 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
	 			transactionSequence2.setTransactionSequenceNumber(orderNo);
	 			hbt.update(transactionSequence2);
	 			}else if (sequenceNoList.size() == 0) {
	 				TransactionSequence tsObj = new TransactionSequence();
	 				tsObj.setStatus("y");
	 				tsObj.setTransactionPrefix("MED");
	 				tsObj.setTransactionSequenceName(transactionSequenceName);
	 				tsObj.setTransactionSequenceNumber(1);
	 				tsObj.setCreatedby("admin");
	 				tsObj.setStatus("y");
	 				MasHospital hospital= new MasHospital();
	 				hospital.setId(box.getInt("hospitalId"));
	 				tsObj.setHospital(hospital);
	 				tsObj.setFinanicalYear(yr);
	 				hbt.save(tsObj);
	 			}
			hbt.save(medicoLegalDetails);
			medicoLegalDetailsId=medicoLegalDetails.getId();
			mlcType=medicoLegalDetails.getMlcType();
			successfullyAdded = true;
			hbt.update(wiseMlc); 
			 tx.commit();
		 }
		 else if (box.getString("flag").equalsIgnoreCase("authorization")) {
				patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
				           .add(Restrictions.eq("MlcType","Examination by a Medical Officer"))
				           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

				PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

				if(wiseMlc!=null){
			            wiseMlc.setStatus("C");
		           }
	
		
			
				List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
				medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
						.list();
				 
			if(medicoLegalDetailsList.size()>0){
					MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
					System.out.println(box.getInt("mediCoId"));
					System.out.println(box.getInt("hinId"));
					
					if(box.getInt("hinId")!=0){
						Patient patient = new Patient();
						patient.setId(box.getInt("hinId"));
						medicoLegalDetails.setHin(patient);
						}
						if(box.getInt("detailId")!=0){
							OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
							opdPatientDetails.setId(box.getInt("detailId"));
							medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
							}
						
						
						medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
						if(!box.getString("refMLDate").equals("")){
						medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
						}
						medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
					
						
						   if(!box.getString("requisitionDate").equals("")){
							medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
							}
						   medicoLegalDetails.setCrimeNo(box.getString("crNO"));
						   
						   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));	
						   medicoLegalDetails.setConsent(box.getString("consent"));
						   medicoLegalDetails.setExaminationPlace(box.getString("placeExamination"));
							
							medicoLegalDetails.setExaminationTime(box.getString("examConcludedTime"));
							if(!box.getString("examinationConcludedDate").equals("")){
							medicoLegalDetails.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinationConcludedDate")));
							}
					  
						medicoLegalDetails.setIdMark1(box.getString("idmark1"));
						medicoLegalDetails.setIdMark2(box.getString("idmark2"));
						//medicoLegalDetails.setInjuryDetails(box.getString("injury"));
						medicoLegalDetails.setHistoryOfIllness(box.getString("illness"));
						medicoLegalDetails.setHeight(box.getInt("height"));
						medicoLegalDetails.setWeight(box.getInt("weight"));
						
						if(box.getString("buildnourishment")!=null && !box.getString("buildnourishment").equals("")){		
						medicoLegalDetails.setBuild(box.getString("buildnourishment"));
				}
					
						
						  if(box.getInt("inpationId")!=0 ){
							   Inpatient inp=new Inpatient();
								  inp.setId(box.getInt("inpationId")); 
							   medicoLegalDetails.setInpatient(inp);
							   }
						medicoLegalDetails.setRemarks(box.getString("remarks"));
						medicoLegalDetails.setPulse(box.getInt("pulse"));
						medicoLegalDetails.setBp(box.getString("bp"));
								
					   medicoLegalDetails.setOpinion(box.getString("opinion"));
						medicoLegalDetails.setMlcType("Examination by a Medical Officer");
						medicoLegalDetails.setInjuryDetails(box.getString("injuries"));
						medicoLegalDetails.setInvResult(box.getString("investigations"));
						medicoLegalDetails.setPallor(box.getString("pallor"));
						medicoLegalDetails.setDeformity(box.getString("deformity"));
						medicoLegalDetails.setGis(box.getString("gis"));
						medicoLegalDetails.setRs( box.getString("rs"));
						medicoLegalDetails.setNs(box.getString("ns"));
						medicoLegalDetails.setCvs(box.getString("cvs"));
						//medicoLegalDetails.setInjuryOnBody(box.getString("injuries"));
						//medicoLegalDetails.setInvResult(box.getString("investigations"));
						
						if(box.getInt("empId")!=0){
						MasEmployee doctor = new MasEmployee();
						doctor.setId(box.getInt("empId"));
						medicoLegalDetails.setDoctor(doctor);
						}
						
						if(box.getInt("userId")!=0){
							Users users = new Users();
							users.setId(box.getInt("userId"));
							medicoLegalDetails.setLastChgBy(users);
							}
						
							if(!box.getString(CHANGED_DATE).equals("")){
						medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
						}
						medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
						
						
						/*  sequenceNoList = session
				 					.createCriteria(TransactionSequence.class)
				 					.add(Restrictions.eq("TransactionSequenceName",
				 							transactionSequenceName))
				 							.createAlias("Hospital", "hosp")
						 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 							.list();
				 			if(sequenceNoList.size()>0){
				            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
				 			int orderNo = transactionSequence.getTransactionSequenceNumber();
				 			orderNo = orderNo + 1;
				 			int id = transactionSequence.getId();

				 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
				 			transactionSequence2.setTransactionSequenceNumber(orderNo);
				 			hbt.update(transactionSequence2);
				 			}else if (sequenceNoList.size() == 0) {
				 				TransactionSequence tsObj = new TransactionSequence();
				 				tsObj.setStatus("y");
				 				tsObj.setTransactionPrefix("MED");
				 				tsObj.setTransactionSequenceName(transactionSequenceName);
				 				tsObj.setTransactionSequenceNumber(1);
				 				tsObj.setCreatedby("admin");
				 				tsObj.setStatus("y");
				 				MasHospital hospital= new MasHospital();
				 				hospital.setId(box.getInt("hospitalId"));
				 				tsObj.setHospital(hospital);
				 				
				 				hbt.save(tsObj);
				 			}*/
			        
			    	hbt.update(wiseMlc);
					hbt.saveOrUpdate(medicoLegalDetails);
					mlcType=medicoLegalDetails.getMlcType();
					medicoLegalDetailsId=medicoLegalDetails.getId();	
					successfullyAdded = true;
					tx.commit();
			}
			else {

				MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
				if(box.getInt("hinId")!=0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				medicoLegalDetails.setHin(patient);
				}
				if(box.getInt("detailId")!=0){
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(box.getInt("detailId"));
					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
					}
				
				
				medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
				if(!box.getString("refMLDate").equals("")){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
				}
				medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
			
				
				   if(!box.getString("requisitionDate").equals("")){
					medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
					}
				   medicoLegalDetails.setCrimeNo(box.getString("crNO"));
				   
				   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));	
				   medicoLegalDetails.setConsent(box.getString("consent"));
				   medicoLegalDetails.setExaminationPlace(box.getString("placeExamination"));
					
					medicoLegalDetails.setExaminationTime(box.getString("examConcludedTime"));
					if(!box.getString("examinationConcludedDate").equals("")){
					medicoLegalDetails.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinationConcludedDate")));
					}
			  
				medicoLegalDetails.setIdMark1(box.getString("idmark1"));
				medicoLegalDetails.setIdMark2(box.getString("idmark2"));
				//medicoLegalDetails.setInjuryDetails(box.getString("injury"));
				medicoLegalDetails.setHistoryOfIllness(box.getString("illness"));
				medicoLegalDetails.setHeight(box.getInt("height"));
				medicoLegalDetails.setWeight(box.getInt("weight"));
				
				if(box.getString("buildnourishment")!=null && !box.getString("buildnourishment").equals("")){		
				medicoLegalDetails.setBuild(box.getString("buildnourishment"));
		}
			
				
				  if(box.getInt("inpationId")!=0 ){
					   Inpatient inp=new Inpatient();
						  inp.setId(box.getInt("inpationId")); 
					   medicoLegalDetails.setInpatient(inp);
					   }
				medicoLegalDetails.setRemarks(box.getString("remarks"));
				medicoLegalDetails.setPulse(box.getInt("pulse"));
				medicoLegalDetails.setBp(box.getString("bp"));
						
			   medicoLegalDetails.setOpinion(box.getString("opinion"));
				medicoLegalDetails.setMlcType("Examination by a Medical Officer");
				medicoLegalDetails.setInjuryDetails(box.getString("injuries"));
				medicoLegalDetails.setInvResult(box.getString("investigations"));
				medicoLegalDetails.setPallor(box.getString("pallor"));
				medicoLegalDetails.setDeformity(box.getString("deformity"));
				medicoLegalDetails.setGis(box.getString("gis"));
				medicoLegalDetails.setRs( box.getString("rs"));
				medicoLegalDetails.setNs(box.getString("ns"));
				medicoLegalDetails.setCvs(box.getString("cvs"));
				//medicoLegalDetails.setInjuryOnBody(box.getString("injuries"));
				//medicoLegalDetails.setInvResult(box.getString("investigations"));
				
				if(box.getInt("empId")!=0){
				MasEmployee doctor = new MasEmployee();
				doctor.setId(box.getInt("empId"));
				medicoLegalDetails.setDoctor(doctor);
				}
				
				if(box.getInt("userId")!=0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					medicoLegalDetails.setLastChgBy(users);
					}
				
					if(!box.getString(CHANGED_DATE).equals("")){
				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
				
				
				String srNo=box.getString("refMLNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
		 			if(sequenceNoList.size()>0){
		            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
		 			int orderNo = transactionSequence.getTransactionSequenceNumber();
		 			orderNo = orderNo + 1;
		 			int id = transactionSequence.getId();

		 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
		 			transactionSequence2.setTransactionSequenceNumber(orderNo);
		 			hbt.update(transactionSequence2);
		 			}else if (sequenceNoList.size() == 0) {
		 				TransactionSequence tsObj = new TransactionSequence();
		 				tsObj.setStatus("y");
		 				tsObj.setTransactionPrefix("MED");
		 				tsObj.setTransactionSequenceName(transactionSequenceName);
		 				tsObj.setTransactionSequenceNumber(1);
		 				tsObj.setCreatedby("admin");
		 				tsObj.setStatus("y");
		 				MasHospital hospital= new MasHospital();
		 				hospital.setId(box.getInt("hospitalId"));
		 				tsObj.setHospital(hospital);
		 				tsObj.setFinanicalYear(yr);
		 				hbt.save(tsObj);
		 			}
				hbt.save(medicoLegalDetails);
				medicoLegalDetailsId=medicoLegalDetails.getId();
				mlcType=medicoLegalDetails.getMlcType();
				successfullyAdded = true;
				hbt.update(wiseMlc); 
				 tx.commit();
		
				
			}
			report="need report";
		 }
		 
       }catch (DataAccessException e) {
	e.printStackTrace();
	if(tx!=null){
		tx.rollback();	
	}
       }

map.put("successfullyAdded", successfullyAdded);
map.put("mlcType", mlcType);
map.put("medicoLegalDetailsId", medicoLegalDetailsId);
map.put("message", message);
map.put("report", report);

return map;
}

@Override
public Map<String, Object> addVictimAllegedDrugged(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	PatientWiseMlc patientWiseMlc=null;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String mlcType="";
	String transactionSequenceName = "VictimAllegedDrugged";
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	
	
	
	Transaction tx=null;
	try {
		tx=session.beginTransaction();
		patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Examination of a victim alleged to have been drugged"))
		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

     PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());
     if(wiseMlc!=null){
         wiseMlc.setStatus("A");
    }

		

			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			
			if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
			
			medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
			   if(!box.getString("refMLDate").equals("")){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
				}
			   if(!box.getString("requisitionDate").equals("")){
					medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
					}
				   
			   
			   medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
			   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));	
			   medicoLegalDetails.setPostmortemCertificateNo(box.getString("PCNo"));
			   medicoLegalDetails.setConsent(box.getString("consent"));
				medicoLegalDetails.setExamCommTime(box.getString("exTime"));	   
			   if(!box.getString("examinDate").equals("")){
					medicoLegalDetails.setExamCommDate(HMSUtil.convertStringTypeDateToDateType(box.getString("examinDate")));
					}
			   medicoLegalDetails.setIncidentTime(box.getString("insTime"));	   
			   if(!box.getString("insDate").equals("")){
					medicoLegalDetails.setIncidentDate(HMSUtil.convertStringTypeDateToDateType(box.getString("insDate")));
					}
			 
			   medicoLegalDetails.setModeOfAdminitration(box.getString("madminitration"));
			 
			medicoLegalDetails.setIdMark1(box.getString("identificationOne"));
			medicoLegalDetails.setIdMark2(box.getString("identificationTwo"));
			medicoLegalDetails.setPatientAddress(box.getString("address"));
			
		medicoLegalDetails.setConsciousnessState(box.getString("consciousness"));
			medicoLegalDetails.setRemarks(box.getString("remarks"));
	   	    	medicoLegalDetails.setUnconsciousnessPeriod(box.getString("uPeriod"));
	    	medicoLegalDetails.setRecovery(box.getString("recovery"));
	    	medicoLegalDetails.setRemember(box.getString("remember"));
	    	medicoLegalDetails.setClothing(box.getString("clothing"));
	    	medicoLegalDetails.setConsciousnessLevel(box.getString("conscilevel"));
	    	medicoLegalDetails.setAlertness(box.getString("alertness"));
	    	medicoLegalDetails.setGeneralDisposition(box.getString("disposition"));
	    	
			
			medicoLegalDetails.setSpeech(box.getString("speech"));
			medicoLegalDetails.setMemory(box.getString("memory"));
			medicoLegalDetails.setOrientation(box.getString("orientation"));
			medicoLegalDetails.setPlaceOfAct(box.getString("person"));
			medicoLegalDetails.setReactionTime(box.getString("reaction"));
			medicoLegalDetails.setHeight(box.getInt("height"));
			medicoLegalDetails.setWeight(box.getInt("weight"));
			
			if(box.getString("nourishment")!=null && !box.getString("nourishment").equals("")){		
			medicoLegalDetails.setBuild(box.getString("nourishment"));
	}
			medicoLegalDetails.setConjunctiva(box.getString("conjunctivalPallor"));
			medicoLegalDetails.setPupils(box.getString("pupils"));
			medicoLegalDetails.setAnalMucosa(box.getString("mucosa"));
			medicoLegalDetails.setLipsOralCavity(box.getString("lips"));
		  medicoLegalDetails.setOralCavity(box.getString("cavity"));
		   medicoLegalDetails.setCircumOral(box.getString("circum-oral"));
			medicoLegalDetails.setMarksOfInjection(box.getString("marksInj"));
			medicoLegalDetails.setMuscularCoOrdination(box.getString("muscular"));
			
			
			medicoLegalDetails.setReflexes(box.getString("reflexes"));
			medicoLegalDetails.setRombergsSign(box.getString("rombergs"));
			medicoLegalDetails.setFingerNoseTest(box.getString("fingerNose"));
			medicoLegalDetails.setGait(box.getString("gait"));
			medicoLegalDetails.setPulse(box.getInt("pulse"));
			medicoLegalDetails.setBp(box.getString("bp"));
			medicoLegalDetails.setInjuryDetails(box.getString("injury"));
			medicoLegalDetails.setSysExaminationFindings(box.getString("remark"));
			medicoLegalDetails.setNasalSwabs(box.getString("nasalswabs"));
			medicoLegalDetails.setStomachAspirate(box.getString("stomachaspirate"));
			
		medicoLegalDetails.setVomiting(box.getString("vomitus"));
			
			medicoLegalDetails.setBleedingFromAnus(box.getString("blood"));
			medicoLegalDetails.setUrinated(box.getString("urine"));
			medicoLegalDetails.setConsent(box.getString("consent"));
			medicoLegalDetails.setMlcType("Examination of a victim alleged to have been drugged");
			medicoLegalDetails.setOpinion(box.getString("opinion"));
		
			
			if(box.getInt("empId")!=0){
			MasEmployee doctor = new MasEmployee();
			doctor.setId(box.getInt("empId"));
			medicoLegalDetails.setDoctor(doctor);
			}
			  if(box.getInt("inpationId")!=0){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
				   
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			String srNo=box.getString("refMLNo");
			String yr = "";
			if(srNo!=null){ 
					 yr = srNo.substring(4, 8);
					
			}				
			sequenceNoList = session
	 					.createCriteria(TransactionSequence.class)
	 					.add(Restrictions.eq("TransactionSequenceName",
	 							transactionSequenceName))
	 							.createAlias("Hospital", "hosp")
			 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
			 			.add(Restrictions.eq("FinanicalYear", yr))
	 							.list();
	 			if(sequenceNoList.size()>0){
	            TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
	 			int orderNo = transactionSequence.getTransactionSequenceNumber();
	 			orderNo = orderNo + 1;
	 			int id = transactionSequence.getId();

	 			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
	 			transactionSequence2.setTransactionSequenceNumber(orderNo);
	 			hbt.update(transactionSequence2);
	 			}else if (sequenceNoList.size() == 0) {
	 				TransactionSequence tsObj = new TransactionSequence();
	 				tsObj.setStatus("y");
	 				tsObj.setTransactionPrefix("VAD");
	 				tsObj.setTransactionSequenceName(transactionSequenceName);
	 				tsObj.setTransactionSequenceNumber(1);
	 				tsObj.setCreatedby("admin");
	 				tsObj.setStatus("y");
	 				MasHospital hospital= new MasHospital();
	 				hospital.setId(box.getInt("hospitalId"));
	 				tsObj.setHospital(hospital);
	 				tsObj.setFinanicalYear(yr);
	 				hbt.save(tsObj);
	 				
	 			}
			hbt.save(medicoLegalDetails);
			hbt.update(wiseMlc); 
			 tx.commit();
			medicoLegalDetailsId=medicoLegalDetails.getId();
			mlcType=medicoLegalDetails.getMlcType();
			successfullyAdded = true;
			
	
	
}catch (DataAccessException e) {
	e.printStackTrace();
	if(tx!=null){
		tx.rollback();	
	}
}

map.put("successfullyAdded", successfullyAdded);
map.put("medicoLegalDetailsId", medicoLegalDetailsId);
map.put("mlcType", mlcType);
map.put("message", message);

return map;
}

@Override
public Map<String, Object> addExaminationbySMOTTmember(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	PatientWiseMlc patientWiseMlc=null;
	int medicoLegalDetailsId=0;
	String mlcType="";
	Transaction tx=null;
	String report="";
	String transactionSequenceName = "SMOTTmember";
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	
	try {
		tx = session.beginTransaction();
		 if(box.getString("flag").equalsIgnoreCase("submit")){
				
				
		
		patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Examination by a Specialist Medical Officer/Team of Specialist Medical Officers"))
		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

  PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());
  if(wiseMlc!=null){
      wiseMlc.setStatus("AT");
 }


			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
			
			
			  medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
			  if(!box.getString("refMLDate").equals("")){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
				}
			   medicoLegalDetails.setCrimeNo(box.getString("crNo"));
			   medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
			   
			   if(!box.getString("requisitionDate").equals("")){
					medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
					} 
			   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));	
			   medicoLegalDetails.setArrestTime(box.getString("time"));
			   if(box.getString("pDate")!=null && !box.getString("pDate").equals("")){
			   medicoLegalDetails.setArrestDate(HMSUtil.convertStringTypeDateToDateType(box.getString("pDate")));
			   }
			   medicoLegalDetails.setConsent(box.getString("consent"));
			 
		  
			medicoLegalDetails.setIdMark1(box.getString("mark1"));
			medicoLegalDetails.setIdMark2(box.getString("mark2"));
			
			medicoLegalDetails.setHistoryByInjured(box.getString("history"));
			  if(!box.getString("address").equals("")){
				  medicoLegalDetails.setPatientAddress(box.getString("address"));
			        }
			medicoLegalDetails.setRemarks(box.getString("remark"));
			
			medicoLegalDetails.setInvResult(box.getString("invest"));
			  medicoLegalDetails.setOpinion(box.getString("opinion"));
			medicoLegalDetails.setMlcType("Examination by a Specialist Medical Officer/Team of Specialist Medical Officers");
			
			if(box.getInt("empId")!=0){
			MasEmployee doctor = new MasEmployee();
			doctor.setId(box.getInt("empId"));
			medicoLegalDetails.setDoctor(doctor);
			}
			  if(box.getInt("inpationId")!=0){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
				   
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			  

String srNo=box.getString("refMLNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
			if(sequenceNoList.size()>0){
           TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
			int orderNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = orderNo + 1;
			int id = transactionSequence.getId();

			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
			transactionSequence2.setTransactionSequenceNumber(orderNo);
			hbt.update(transactionSequence2);
			}else if (sequenceNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTransactionPrefix("SMO");
				tsObj.setTransactionSequenceName(transactionSequenceName);
				tsObj.setTransactionSequenceNumber(1);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				MasHospital hospital= new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				tsObj.setHospital(hospital);
				tsObj.setFinanicalYear(yr);
				hbt.save(tsObj);
				
			}
			
			hbt.save(medicoLegalDetails);
			medicoLegalDetailsId=medicoLegalDetails.getId();
			mlcType=medicoLegalDetails.getMlcType();
			
			successfullyAdded = true;
			hbt.update(wiseMlc); 
			 tx.commit();
		 }
		 else if (box.getString("flag").equalsIgnoreCase("authorization")) {
				
			 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
					 .add(Restrictions.eq("MlcType","Examination by a Specialist Medical Officer/Team of Specialist Medical Officers"))
			           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

	            PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

	           if(wiseMlc!=null){
		          wiseMlc.setStatus("C");
	               }
				
				
				List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
				medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
						.list();
				 
			if(medicoLegalDetailsList.size()>0){
					MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
					
					
					
					if(box.getInt("hinId")!=0){
					Patient patient = new Patient();
					patient.setId(box.getInt("hinId"));
					medicoLegalDetails.setHin(patient);
					}
					if(box.getInt("detailId")!=0){
						OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
						opdPatientDetails.setId(box.getInt("detailId"));
						medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
						}
					
					
					  medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
					  if(!box.getString("refMLDate").equals("")){
						medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
						}
					   medicoLegalDetails.setCrimeNo(box.getString("crNo"));
					   medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
					   
					   if(!box.getString("requisitionDate").equals("")){
							medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
							} 
					   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));	
					   medicoLegalDetails.setArrestTime(box.getString("time"));
					   if(box.getString("pDate")!=null && !box.getString("pDate").equals("")){
					   medicoLegalDetails.setArrestDate(HMSUtil.convertStringTypeDateToDateType(box.getString("pDate")));
					   }
					   medicoLegalDetails.setConsent(box.getString("consent"));
					 
				  
					medicoLegalDetails.setIdMark1(box.getString("mark1"));
					medicoLegalDetails.setIdMark2(box.getString("mark2"));
					
					medicoLegalDetails.setHistoryByInjured(box.getString("history"));
					  if(!box.getString("address").equals("")){
						  medicoLegalDetails.setPatientAddress(box.getString("address"));
					        }
					medicoLegalDetails.setRemarks(box.getString("remark"));
					
					medicoLegalDetails.setInvResult(box.getString("invest"));
					  medicoLegalDetails.setOpinion(box.getString("opinion"));
					medicoLegalDetails.setMlcType("Examination by a Specialist Medical Officer/Team of Specialist Medical Officers");
					
					if(box.getInt("empId")!=0){
					MasEmployee doctor = new MasEmployee();
					doctor.setId(box.getInt("empId"));
					medicoLegalDetails.setDoctor(doctor);
					}
					  if(box.getInt("inpationId")!=0){
						   Inpatient inp=new Inpatient();
							  inp.setId(box.getInt("inpationId")); 
						   medicoLegalDetails.setInpatient(inp);
						   }
						   
					
					if(box.getInt("userId")!=0){
						Users users = new Users();
						users.setId(box.getInt("userId"));
						medicoLegalDetails.setLastChgBy(users);
						}
					
						if(!box.getString(CHANGED_DATE).equals("")){
					medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					}
					medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
					
					  
				
			        
			    	hbt.update(wiseMlc);
					hbt.saveOrUpdate(medicoLegalDetails);
					mlcType=medicoLegalDetails.getMlcType();
					medicoLegalDetailsId=medicoLegalDetails.getId();	
					successfullyAdded = true;
					tx.commit();
			}
			else {

				MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
				if(box.getInt("hinId")!=0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				medicoLegalDetails.setHin(patient);
				}
				if(box.getInt("detailId")!=0){
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(box.getInt("detailId"));
					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
					}
				
				
				  medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
				  if(!box.getString("refMLDate").equals("")){
					medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
					}
				   medicoLegalDetails.setCrimeNo(box.getString("crNo"));
				   medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
				   
				   if(!box.getString("requisitionDate").equals("")){
						medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("requisitionDate")));
						} 
				   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));	
				   medicoLegalDetails.setArrestTime(box.getString("time"));
				   if(box.getString("pDate")!=null && !box.getString("pDate").equals("")){
				   medicoLegalDetails.setArrestDate(HMSUtil.convertStringTypeDateToDateType(box.getString("pDate")));
				   }
				   medicoLegalDetails.setConsent(box.getString("consent"));
				 
			  
				medicoLegalDetails.setIdMark1(box.getString("mark1"));
				medicoLegalDetails.setIdMark2(box.getString("mark2"));
				
				medicoLegalDetails.setHistoryByInjured(box.getString("history"));
				  if(!box.getString("address").equals("")){
					  medicoLegalDetails.setPatientAddress(box.getString("address"));
				        }
				medicoLegalDetails.setRemarks(box.getString("remark"));
				
				medicoLegalDetails.setInvResult(box.getString("invest"));
				  medicoLegalDetails.setOpinion(box.getString("opinion"));
				medicoLegalDetails.setMlcType("Examination by a Specialist Medical Officer/Team of Specialist Medical Officers");
				
				if(box.getInt("empId")!=0){
				MasEmployee doctor = new MasEmployee();
				doctor.setId(box.getInt("empId"));
				medicoLegalDetails.setDoctor(doctor);
				}
				  if(box.getInt("inpationId")!=0){
					   Inpatient inp=new Inpatient();
						  inp.setId(box.getInt("inpationId")); 
					   medicoLegalDetails.setInpatient(inp);
					   }
					   
				
				if(box.getInt("userId")!=0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					medicoLegalDetails.setLastChgBy(users);
					}
				
					if(!box.getString(CHANGED_DATE).equals("")){
				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
				
				  

String srNo=box.getString("refMLNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
				if(sequenceNoList.size()>0){
	           TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
				int orderNo = transactionSequence.getTransactionSequenceNumber();
				orderNo = orderNo + 1;
				int id = transactionSequence.getId();

				TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
				transactionSequence2.setTransactionSequenceNumber(orderNo);
				hbt.update(transactionSequence2);
				}else if (sequenceNoList.size() == 0) {
					TransactionSequence tsObj = new TransactionSequence();
					tsObj.setStatus("y");
					tsObj.setTransactionPrefix("SMO");
					tsObj.setTransactionSequenceName(transactionSequenceName);
					tsObj.setTransactionSequenceNumber(1);
					tsObj.setCreatedby("admin");
					tsObj.setStatus("y");
					MasHospital hospital= new MasHospital();
					hospital.setId(box.getInt("hospitalId"));
					tsObj.setHospital(hospital);
					tsObj.setFinanicalYear(yr);
					hbt.save(tsObj);
					
				}
				
				hbt.save(medicoLegalDetails);
				medicoLegalDetailsId=medicoLegalDetails.getId();
				mlcType=medicoLegalDetails.getMlcType();
				
				successfullyAdded = true;
				hbt.update(wiseMlc); 
				 tx.commit();
		
				
			}
			report="need report";
		 }
		 
       }catch (DataAccessException e) {
	e.printStackTrace();
	if(tx!=null){
		tx.rollback();	
	}
       }

map.put("successfullyAdded", successfullyAdded);
map.put("medicoLegalDetailsId", medicoLegalDetailsId);
map.put("mlcType", mlcType);
map.put("message", message);
map.put("report", report);



return map;
}

@Override
public Map<String, Object> addDNAprofilingexaminationFSL(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	PatientWiseMlc patientWiseMlc=null;
	String message ="";
	int medicoLegalDetailsId=0;
	String mlcType="";
	String report="";
	Transaction tx=null;
	String transactionSequenceName = "DNAProfile";
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();

	try {
		tx = session.beginTransaction();
		 if(box.getString("flag").equalsIgnoreCase("submit")){
				
		patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc"))
		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

			PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());
				if(wiseMlc!=null){
						wiseMlc.setStatus("AT");
				}

		
			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
			medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
			  medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
			   if(!box.getString("refMLDate").equals("")  &&  box.getString("refMLDate")!=null){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
				}
			   
			   if(!box.getString("reqDate").equals("")  &&  box.getString("reqDate")!=null){
					medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("reqDate")));
					}
			   medicoLegalDetails.setCollection(box.getString("collection"));
			   medicoLegalDetails.setCrimeNo(box.getString("crNo"));
			   
			   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));	
			   medicoLegalDetails.setArrestTime(box.getString("time"));
			   if(!box.getString("crimeDate").equals("") && box.getString("crimeDate")!=null){
			   medicoLegalDetails.setArrestDate(HMSUtil.convertStringTypeDateToDateType(box.getString("crimeDate")));
			   }
			   medicoLegalDetails.setAccompByName(box.getString("accompaind"));
			   
			   medicoLegalDetails.setConsent(box.getString("consent"));
			 
		  
			medicoLegalDetails.setIdMark1(box.getString("mark1"));
			medicoLegalDetails.setIdMark2(box.getString("mark2"));
			
			//medicoLegalDetails.setHistoryByInjured(box.getString("history"));
	
			medicoLegalDetails.setMaterialObjectsPreserved(box.getString("materilObj"));
			medicoLegalDetails.setMaterialObjectsNotCollected(box.getString("notcollect"));
			
			  medicoLegalDetails.setReason(box.getString("resion"));
			
			medicoLegalDetails.setMlcType("Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc");
			
			if(box.getInt("empId")!=0){
			MasEmployee doctor = new MasEmployee();
			doctor.setId(box.getInt("empId"));
			medicoLegalDetails.setDoctor(doctor);
			}
			
			  if(box.getInt("inpationId")!=0 ){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
				   
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			
			String srNo=box.getString("refMLNo");
			String yr = "";
			if(srNo!=null){ 
					 yr = srNo.substring(4, 8);
					
			}				
			sequenceNoList = session
	 					.createCriteria(TransactionSequence.class)
	 					.add(Restrictions.eq("TransactionSequenceName",
	 							transactionSequenceName))
	 							.createAlias("Hospital", "hosp")
			 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
			 			.add(Restrictions.eq("FinanicalYear", yr))
	 							.list();
			if(sequenceNoList.size()>0){
           TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
			int orderNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = orderNo + 1;
			int id = transactionSequence.getId();

			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
			transactionSequence2.setTransactionSequenceNumber(orderNo);
			hbt.update(transactionSequence2);
			}else if (sequenceNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTransactionPrefix("DNAP");
				tsObj.setTransactionSequenceName(transactionSequenceName);
				tsObj.setTransactionSequenceNumber(1);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				MasHospital hospital= new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				tsObj.setHospital(hospital);
				tsObj.setFinanicalYear(yr);
				hbt.save(tsObj);
				
			}

			hbt.save(medicoLegalDetails);
			successfullyAdded = true;
			hbt.update(wiseMlc); 
			 tx.commit();
			 	
		if(medicoLegalDetails!=null)
			medicoLegalDetailsId = medicoLegalDetails.getId();
		 }
		 else if (box.getString("flag").equalsIgnoreCase("authorization")) {
			 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
			           .add(Restrictions.eq("MlcType","Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc"))
			           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

			PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

			if(wiseMlc!=null){
		            wiseMlc.setStatus("C");
	           }

	
		
			List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
			medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
					.list();
			 
			if(medicoLegalDetailsList.size()>0){
				MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
				System.out.println(box.getInt("mediCoId"));
				System.out.println(box.getInt("hinId"));
				
				medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
				if(box.getInt("hinId")!=0){
					Patient patient = new Patient();
					patient.setId(box.getInt("hinId"));
					medicoLegalDetails.setHin(patient);
					}
					if(box.getInt("detailId")!=0){
						OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
						opdPatientDetails.setId(box.getInt("detailId"));
						medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
						}
					
					  medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
					   if(!box.getString("refMLDate").equals("")  &&  box.getString("refMLDate")!=null){
						medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
						}
					   medicoLegalDetails.setCollection(box.getString("collection"));
					   medicoLegalDetails.setCrimeNo(box.getString("crNo"));
					   
					   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));	
					   medicoLegalDetails.setArrestTime(box.getString("time"));
					   if(!box.getString("crimeDate").equals("") && box.getString("crimeDate")!=null){
					   medicoLegalDetails.setArrestDate(HMSUtil.convertStringTypeDateToDateType(box.getString("crimeDate")));
					   }
					   medicoLegalDetails.setAccompByName(box.getString("accompaind"));
					   
					   medicoLegalDetails.setConsent(box.getString("consent"));
					 
				  
					medicoLegalDetails.setIdMark1(box.getString("mark1"));
					medicoLegalDetails.setIdMark1(box.getString("mark1"));
					
					//medicoLegalDetails.setHistoryByInjured(box.getString("history"));
			
					medicoLegalDetails.setMaterialObjectsPreserved(box.getString("materilObj"));
					medicoLegalDetails.setMaterialObjectsNotCollected(box.getString("notcollect"));
					
					  medicoLegalDetails.setReason(box.getString("resion"));
					
					medicoLegalDetails.setMlcType("Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc");
					
					if(box.getInt("empId")!=0){
					MasEmployee doctor = new MasEmployee();
					doctor.setId(box.getInt("empId"));
					medicoLegalDetails.setDoctor(doctor);
					}
					
					  if(box.getInt("inpationId")!=0 ){
						   Inpatient inp=new Inpatient();
							  inp.setId(box.getInt("inpationId")); 
						   medicoLegalDetails.setInpatient(inp);
						   }
						   
					if(box.getInt("userId")!=0){
						Users users = new Users();
						users.setId(box.getInt("userId"));
						medicoLegalDetails.setLastChgBy(users);
						}
					
						if(!box.getString(CHANGED_DATE).equals("")){
					medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
					}
					medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
					
					
			    	hbt.update(wiseMlc);
								hbt.saveOrUpdate(medicoLegalDetails);
								mlcType=medicoLegalDetails.getMlcType();
								medicoLegalDetailsId=medicoLegalDetails.getId();	
								successfullyAdded = true;
								tx.commit();
		}
		else {

			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				medicoLegalDetails.setHin(patient);
				}
				if(box.getInt("detailId")!=0){
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(box.getInt("detailId"));
					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
					}
				medicoLegalDetails.setSerialNo(box.getString("refMLNo"));
				  medicoLegalDetails.setRequisitionFrom(box.getString("requisitionFrom"));
				   if(!box.getString("refMLDate").equals("")  &&  box.getString("refMLDate")!=null){
					medicoLegalDetails.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
					}
				   medicoLegalDetails.setCollection(box.getString("collection"));
				   medicoLegalDetails.setCrimeNo(box.getString("crNo"));
				   
				   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));	
				   medicoLegalDetails.setArrestTime(box.getString("time"));
				   if(!box.getString("crimeDate").equals("") && box.getString("crimeDate")!=null){
				   medicoLegalDetails.setArrestDate(HMSUtil.convertStringTypeDateToDateType(box.getString("crimeDate")));
				   }
				   medicoLegalDetails.setAccompByName(box.getString("accompaind"));
				   
				   medicoLegalDetails.setConsent(box.getString("consent"));
				 
			  
				medicoLegalDetails.setIdMark1(box.getString("mark1"));
				medicoLegalDetails.setIdMark1(box.getString("mark1"));
				
				//medicoLegalDetails.setHistoryByInjured(box.getString("history"));
		
				medicoLegalDetails.setMaterialObjectsPreserved(box.getString("materilObj"));
				medicoLegalDetails.setMaterialObjectsNotCollected(box.getString("notcollect"));
				
				  medicoLegalDetails.setReason(box.getString("resion"));
				
				medicoLegalDetails.setMlcType("Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc");
				
				if(box.getInt("empId")!=0){
				MasEmployee doctor = new MasEmployee();
				doctor.setId(box.getInt("empId"));
				medicoLegalDetails.setDoctor(doctor);
				}
				
				  if(box.getInt("inpationId")!=0 ){
					   Inpatient inp=new Inpatient();
						  inp.setId(box.getInt("inpationId")); 
					   medicoLegalDetails.setInpatient(inp);
					   }
					   
				if(box.getInt("userId")!=0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					medicoLegalDetails.setLastChgBy(users);
					}
				
					if(!box.getString(CHANGED_DATE).equals("")){
				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
				
			
				
				String srNo=box.getString("refMLNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
				if(sequenceNoList.size()>0){
	           TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
				int orderNo = transactionSequence.getTransactionSequenceNumber();
				orderNo = orderNo + 1;
				int id = transactionSequence.getId();

				TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
				transactionSequence2.setTransactionSequenceNumber(orderNo);
				hbt.update(transactionSequence2);
				}else if (sequenceNoList.size() == 0) {
					TransactionSequence tsObj = new TransactionSequence();
					tsObj.setStatus("y");
					tsObj.setTransactionPrefix("DNAP");
					tsObj.setTransactionSequenceName(transactionSequenceName);
					tsObj.setTransactionSequenceNumber(1);
					tsObj.setCreatedby("admin");
					tsObj.setStatus("y");
					MasHospital hospital= new MasHospital();
					hospital.setId(box.getInt("hospitalId"));
					tsObj.setHospital(hospital);
					tsObj.setFinanicalYear(yr);

					hbt.save(tsObj);
					
				}
			hbt.save(medicoLegalDetails);
			 hbt.update(wiseMlc); 
			 tx.commit();
			 
			successfullyAdded = true;
			medicoLegalDetailsId=medicoLegalDetails.getId();
	        mlcType=medicoLegalDetails.getMlcType();
		}
			report="need report";
	}		
	
       }catch (DataAccessException e) {
	e.printStackTrace();
	if(tx!=null){
		tx.rollback();	
	}
       }

map.put("successfullyAdded", successfullyAdded);
map.put("mlcType", "Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc");
map.put("medicoLegalDetailsId", medicoLegalDetailsId);
map.put("message", message);
map.put("report", report);

return map;
}

@Override
public Map<String, Object> addPreserveDuringPostmortem(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	PatientWiseMlc patientWiseMlc=null;
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String mlcType="";
	Transaction tx=null;
	try {
		tx = session.beginTransaction();
		patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Preserved During Postmortem Examination"))
		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

           PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());
            if(wiseMlc!=null){
           wiseMlc.setStatus("A");
            }
			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			
			  medicoLegalDetails.setPostmortemCertificateNo(box.getString("pmNo"));
			   if(!box.getString("postdate").equals("")){
				medicoLegalDetails.setPostmortemDate(HMSUtil.convertStringTypeDateToDateType(box.getString("postdate")));
				}
			
			   medicoLegalDetails.setCrimeNo(box.getString("crNo"));
			   
			   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));	
			   medicoLegalDetails.setMaterialObjectsPreserved(box.getString("matrial"));
			   
			   
	     	medicoLegalDetails.setMlcType("Preserved During Postmortem Examination");
	     	medicoLegalDetails.setSamplePaking(box.getString("packing"));
	     	medicoLegalDetails.setSealed(box.getString("radio"));
	     	medicoLegalDetails.setHistoryOfIllness(box.getString("clinickHis"));
	    	medicoLegalDetails.setTreatment(box.getString("treatment"));
	    	medicoLegalDetails.setCauseDeath(box.getString("couseDeath"));
	    	medicoLegalDetails.setExaminationRequired(box.getString("Quantitative")+","+box.getString("Qualitative"));
	    	medicoLegalDetails.setPostmortemBrief(box.getString("pomBrief"));
	    	medicoLegalDetails.setImpressionSealUsed(box.getString("impression"));
	    	medicoLegalDetails.setLabels(box.getString("labels"));
	    	  if(box.getInt("inpationId")!=0){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
				   
	    	
			if(box.getInt("empId")!=0){
			MasEmployee doctor = new MasEmployee();
			doctor.setId(box.getInt("empId"));
			medicoLegalDetails.setDoctor(doctor);
			}
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			hbt.save(medicoLegalDetails);
			successfullyAdded = true;
			hbt.update(wiseMlc); 
			 tx.commit();

       }catch (DataAccessException e) {
	e.printStackTrace();
	if(tx!=null){
		tx.rollback();	
	}
       }

map.put("successfullyAdded", successfullyAdded);

map.put("message", message);

return map;
}

@Override
public Map<String, Object> getAllMlcWaitingList(int hospitalId, int empId) {

	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<PatientWiseMlc> patWise = new ArrayList<PatientWiseMlc>();
	Session session = (Session) getSession();
	try{
	
/*
	String[] mlcName={"Examintion of a male accused","POSTMORTEM EXAMINATION","POST MORTEM DETAILED NOTES","EXAMINATION OF A FEMALE VICTIM OF SEXUAL ASSAULT","EXAMINATION OF A VICTIM OF UNNATURAL SEXUAL OFFENCE","EXAMINATION FOR EVIDENCE OF RECENT DELIVERY","ACCIDENT REGISTER-CUM-WOUND CERTIFICATE","Treatment / Discharge Certificate","Certificate Of Drunkness","OPINION OF CAUSE OF DEATH","POSTMORTEM CERTIFICATE","EXAMINATION FOR ESTIMATION OF AGE","Chemical Analysis","Examination Of Victim Alleged Drugged","Examination by a Medical Officer","Examination by a Specialist Medical Officer/Team","DNA Profiling Examination At FSL","Preserved During Postmortem Examination","REFERRING A POSTMORTEM EXAMINATION","REFERRING POSTMORTEM EXAMINATION TO POLICE SURGEON"};
	
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.in("MlcName",mlcName))
			    .add(Restrictions.eq("MlcStatus", "pending"));*/
	
	Criteria crMlcName=session.createCriteria(PatientWiseMlc.class)
					.createAlias("Hospital", "hosp")
					.createAlias("OpdPatientDetail", "opd")
					.createAlias("opd.Employee", "emp")
					.createAlias("opd.ReferredHospital", "opdreferHos",CriteriaSpecification.LEFT_JOIN)
					.add(Restrictions.or(Restrictions.eq("hosp.Id", hospitalId), Restrictions.eq("opdreferHos.Id", hospitalId)))
					.add(Restrictions.eq("emp.Id", empId))
			        .add(Restrictions.or(Restrictions.eq("Status", "y").ignoreCase(), Restrictions.eq("Status", "AT").ignoreCase()));

	//ReferredHospital
	patWise=crMlcName.list();
//	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}

	
	
     map.put("patWise", patWise);
	map.put("mlcList", mlcList);
	return map;

}

@Override
public Map<String, Object> getCAUSE_OF_DEATH(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	Session session = (Session) getSession();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
/*	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
*/	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Accident Register-cum-Wound Certificate").ignoreCase());


	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details);
	return map;
}

@Override
public Map<String, Object> getEstimationofAge(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	int hinId=0;
	String transactionSequenceName = "EstimationofAge";
	String orderNo = "";
	
	Session session = (Session) getSession();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
/*	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
*/	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Examination for estimation of age").ignoreCase());

	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	
	
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();

	Date currentDate = new Date();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
	String dateVal="";
	try {
		dateVal = formatterOut.format(formatterIn.parse(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		/*
	List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
	medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Examination for estimation of age").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
	String srNo="";
	int yr=0;
	for(MedicoLegalDetails m:medicoLegalDetails){
		srNo=m.getSerialNo();
			if(srNo!=null){ 
			yr = Integer.parseInt(srNo.substring(4, 8));
	}
	}	

	int year = Calendar.getInstance().get(Calendar.YEAR);
	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		if(yr!=0 && year==yr){
		int s= sequenceNo+1;
		orderNo = dateVal+"-"+s;
		}else{
			orderNo=dateVal+"-"+1;
		}}else{
		orderNo=dateVal+"-"+1;	
		}*/
	
	int year = Calendar.getInstance().get(Calendar.YEAR);
	sequenceNoList = session.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
						.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
					list();

	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		

		int s= sequenceNo+1;

		orderNo = dateVal+"-"+s;
		
		}else{
		orderNo=dateVal+"-"+1;	
		}
	/*sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	
	
	
	patientAddress=session.createCriteria(PatientAddress.class) .add(Restrictions.eq("Hin.Id", hinId)).list();
	
	
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details); 
 map.put("patientWiseMlcs", patientWiseMlcs);
 map.put("orderNo", orderNo);
 map.put("patientAddress", patientAddress);
 
 
	return map;
}


// Added by Amit Das on 20-04-2016
@Override
public Map<String, Object> getNoObjectionCertificate(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	int hinId=0;
	Session session = (Session) getSession();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
/*	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
*/	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Accident Register-cum-Wound Certificate").ignoreCase());

	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	
	
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();
	
	
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	
	
	

	patientAddress=session.createCriteria(PatientAddress.class) .add(Restrictions.eq("Hin.Id", hinId)).list();
	
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details); 
 map.put("patientWiseMlcs", patientWiseMlcs);
 map.put("patientAddress", patientAddress);
 
 
	return map;
}

@Override
public Map<String, Object> getVictimAllegedDrugged(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	int hinId=0;
	String transactionSequenceName = "VictimAllegedDrugged";
	String orderNo = "";
	
	Session session = (Session) getSession();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
/*	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
*/	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Accident Register-cum-Wound Certificate").ignoreCase());

	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	
	
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();

	Date currentDate = new Date();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
	String dateVal="";
	try {
		dateVal = formatterOut.format(formatterIn.parse(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		/*
	List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
	medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Accident Register-cum-Wound Certificate").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
	String srNo="";
	int yr=0;
	for(MedicoLegalDetails m:medicoLegalDetails){
		srNo=m.getSerialNo();
			if(srNo!=null){ 
			yr = Integer.parseInt(srNo.substring(4, 8));
	}
	}	

	int year = Calendar.getInstance().get(Calendar.YEAR);
	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		if(yr!=0 && year==yr){
		int s= sequenceNo+1;
		orderNo = dateVal+"-"+s;
		}else{
			orderNo=dateVal+"-"+1;
		}}else{
		orderNo=dateVal+"-"+1;	
		}
*/	
	int year = Calendar.getInstance().get(Calendar.YEAR);

	sequenceNoList = session.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
						.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
					list();

	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		

		int s= sequenceNo+1;

		orderNo = dateVal+"-"+s;
		
		}else{
		orderNo=dateVal+"-"+1;	
		}
	/*sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	
	
	
	patientAddress=session.createCriteria(PatientAddress.class) .add(Restrictions.eq("Hin.Id", hinId)).list();
	
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details); map.put("patientWiseMlcs", patientWiseMlcs);
 map.put("orderNo", orderNo);
 map.put("patientAddress", patientAddress);

 
 
	return map;
}

@Override
public Map<String, Object> addReffringPostmortamExam(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	PatientWiseMlc patientWiseMlc=null;
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String mlcType="";
	Transaction tx=null;
	try {
		tx = session.beginTransaction();
		patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Format for referring a postmortem examination to police sugeon through investigating police officer or magistrate"))
		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

           PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());
            if(wiseMlc!=null){
           wiseMlc.setStatus("A");
            }
			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
			
			  medicoLegalDetails.setPostmortemCertificateNo(box.getString("pmNo"));
			   if(!box.getString("pmDate").equals("")){
				medicoLegalDetails.setPostmortemDate(HMSUtil.convertStringTypeDateToDateType(box.getString("pmDate")));
				}
			
			   medicoLegalDetails.setCrimeNo(box.getString("crno"));
			   
			   medicoLegalDetails.setPoliceStation(box.getString("ofPolice"));	
			   medicoLegalDetails.setRequisitionFrom(box.getString("recFrom"));
			   
			   if(box.getInt("inpationId")!=0){
			   Inpatient inp=new Inpatient();
				  inp.setId(box.getInt("inpationId")); 
			   medicoLegalDetails.setInpatient(inp);
			   }
			   
			   medicoLegalDetails.setReceivedTime(box.getString("time"));
			   if(box.getString("recDate")!=null && !box.getString("recDate").equals("")){
			   medicoLegalDetails.setReceivedDate(HMSUtil.convertStringTypeDateToDateType(box.getString("recDate")));
	                       }
			   medicoLegalDetails.setLatterCrimeNo(box.getString("crNOLatter"));
			   if(box.getString("crDate")!=null && !box.getString("crDate").equals("")){
			   medicoLegalDetails.setCrimeDate(HMSUtil.convertStringTypeDateToDateType(box.getString("crDate")));
			   }
			   medicoLegalDetails.setPostmoremTime(box.getString("posTime"));
			   if(box.getString("postDate")!=null && !box.getString("postDate").equals("")){
				   medicoLegalDetails.setExaminationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("postDate")));
				   }
			   medicoLegalDetails.setReason(box.getString("dethResion"));
			   medicoLegalDetails.setOnBody(box.getString("onBody"));
			 
			medicoLegalDetails.setMlcType("Format for referring a postmortem examination to police sugeon through investigating police officer or magistrate");
			
		
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			hbt.save(medicoLegalDetails);
			successfullyAdded = true;
			hbt.update(wiseMlc); 
			 tx.commit();

       }catch (DataAccessException e) {
	e.printStackTrace();
	if(tx!=null){
		tx.rollback();	
	}
       }

map.put("successfullyAdded", successfullyAdded);

map.put("message", message);

return map;
}

@Override
public Map<String, Object> getPreserveDuringPostmortem(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	
	Session session = (Session) getSession();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	
	
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();
	
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details); map.put("patientWiseMlcs", patientWiseMlcs);
 
 
	return map;
}

@Override
public Map<String, Object> getDNAprofilingexaminationFSL(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	int hinId=0;
	String transactionSequenceName = "DNAProfile";
	String orderNo = "";
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	Session session = (Session) getSession();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
/*	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
*/	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
			.add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc").ignoreCase());



	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	
	
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();



Date currentDate = new Date();
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
String date = (String) utilMap.get("currentDate");
SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
String dateVal="";
try {
	dateVal = formatterOut.format(formatterIn.parse(date));
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
/*List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
String srNo="";
int yr=0;
for(MedicoLegalDetails m:medicoLegalDetails){
	srNo=m.getSerialNo();
		if(srNo!=null){ 
		yr = Integer.parseInt(srNo.substring(4, 8));
}
}	

int year = Calendar.getInstance().get(Calendar.YEAR);
sequenceNoList = session
		.createCriteria(TransactionSequence.class)
		.add(Restrictions.eq("TransactionSequenceName",
				transactionSequenceName))
				.createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId"))).
				list();
if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	if(yr!=0 && year==yr){
	int s= sequenceNo+1;
	orderNo = dateVal+"-"+s;
	}else{
		orderNo=dateVal+"-"+1;
	}}else{
	orderNo=dateVal+"-"+1;	
	}
*/int year = Calendar.getInstance().get(Calendar.YEAR);
sequenceNoList = session.createCriteria(TransactionSequence.class)
.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
		.createAlias("Hospital", "hosp")
			.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
			.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
		list();

if(sequenceNoList.size()>0){
TransactionSequence transactionSequence = sequenceNoList.get(0);
int sequenceNo = transactionSequence.getTransactionSequenceNumber();


int s= sequenceNo+1;

orderNo = dateVal+"-"+s;

}else{
orderNo=dateVal+"-"+1;	
}	/*
	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	
	
	
	patientAddress=session.createCriteria(PatientAddress.class) .add(Restrictions.eq("Hin.Id", hinId)).list();
	
	
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details); 
 map.put("patientWiseMlcs", patientWiseMlcs);
 map.put("patientAddress", patientAddress);
map.put("orderNo", orderNo); 
 
	return map;
}

public Map<String, Object> getFormatForReferring(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	
	Session session = (Session) getSession();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	
	
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();
	
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details); map.put("patientWiseMlcs", patientWiseMlcs);
 
 
	return map;
}

@Override
public Map<String, Object> geMedicalOfficerCertificatet(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	int hinId=0;
	String transactionSequenceName = "MedicalOfficerCertificate";
	String orderNo = "";
	String address="";
	Session session = (Session) getSession();
	int pinCode=0;
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
/*	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
	*/
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Examination by a Medical Officer").ignoreCase());
	

	
	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();

	Date currentDate = new Date();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
	String dateVal="";
	try {
		dateVal = formatterOut.format(formatterIn.parse(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	/*List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
	medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Examination by a Medical Officer").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
	String srNo="";
	int yr=0;
	for(MedicoLegalDetails m:medicoLegalDetails){
		srNo=m.getSerialNo();
			if(srNo!=null){ 
			yr = Integer.parseInt(srNo.substring(4, 8));
	}
	}	

	int year = Calendar.getInstance().get(Calendar.YEAR);
	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		if(yr!=0 && year==yr){
		int s= sequenceNo+1;
		orderNo = dateVal+"-"+s;
		}else{
			orderNo=dateVal+"-"+1;
		}}else{
		orderNo=dateVal+"-"+1;	
		}
*/	int year = Calendar.getInstance().get(Calendar.YEAR);
sequenceNoList = session.createCriteria(TransactionSequence.class)
.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
		.createAlias("Hospital", "hosp")
			.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
			.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
		list();

if(sequenceNoList.size()>0){
TransactionSequence transactionSequence = sequenceNoList.get(0);
int sequenceNo = transactionSequence.getTransactionSequenceNumber();


int s= sequenceNo+1;

orderNo = dateVal+"-"+s;

}else{
orderNo=dateVal+"-"+1;	
}/*
	
	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	patientAddress=session.createCriteria(PatientAddress.class)
		    .add(Restrictions.eq("Hin.Id", hinId)).list();
	/*String query = 	
			"select coalesce(mv.village_name, '') || coalesce(md.district_name, '') || coalesce(ms.state_name, '')  || coalesce(lsg_house_no, '') || coalesce(house_no, '') || coalesce(pa.ward_name,'') || coalesce(lsg.lsg_type_name,'') || coalesce(p.post_code_name,'') as address,p.pin_code"
			+ "from patient_address as pa"
			+ "left join mas_village mv on mv.village_id = pa.village "
			+ "left join mas_district md on md.district_id = pa.district"
			+ "left join mas_state ms on ms.state_id = pa.state_id"
			+ "left join mas_lsg lsg on lsg.lsg_id = pa.lsg_name"
			+ "left join mas_post_code p on p.post_code_id = pa.post_office"
			+ "where pa.hin_id="+hinId+ " and pa.address_type_id ="
			+ "CASE WHEN (EXISTS(select  coalesce(mv.village_name, '') || coalesce(md.district_name, '') || coalesce(ms.state_name, '')  || coalesce(lsg_house_no, '') || coalesce(house_no, '') || coalesce(paa.ward_name, '') || coalesce(lsg.lsg_type_name,'') || coalesce(p.post_code_name,'') as address,p.pin_code"
			+ "from patient_address as paa"
			+ "left join mas_village mv on mv.village_id = paa.village"
			+ "left join mas_district md on md.district_id = paa.district"
			+ "left join mas_state ms on ms.state_id = paa.state_id"
			+ "left join mas_lsg lsg on lsg.lsg_id = paa.lsg_name"
			+ "left join mas_post_code p on p.post_code_id = paa.post_office"
			+ "where paa.hin_id="+hinId+ " and paa.address_type_id = 2)) THEN 2"
			+ "WHEN (EXISTS(select   coalesce(mv.village_name, '') || coalesce(md.district_name, '') || coalesce(ms.state_name, '')  || coalesce(lsg_house_no, '') || coalesce(house_no, '') || coalesce(paaa.ward_name, '') || coalesce(lsg.lsg_type_name,'') || coalesce(p.post_code_name,'') as address,p.pin_code"
			+ "from patient_address as paaa"
			+ "left join mas_village mv on mv.village_id = paaa.village"
			+ "left join mas_district md on md.district_id = paaa.district"
			+ "left join mas_state ms on ms.state_id = paaa.state_id"
			+ "left join mas_lsg lsg on lsg.lsg_id = paaa.lsg_name"
			+ "left join mas_post_code p on p.post_code_id = paaa.post_office"
			+ "where paaa.hin_id="+hinId+ " and paaa.address_type_id = 1)) THEN 1"
			+ "ELSE 4 END ";


	patientAddress = session.createSQLQuery(query).list();*/
	
	System.out.println("address"+address);
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details);
 map.put("patientWiseMlcs", patientWiseMlcs);
 map.put("patientAddress", patientAddress);
 map.put("orderNo", orderNo);
 
	return map;
}

@Override
public Map<String, Object> getExaminationbySMOTTmember(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	int hinId=0;
	String transactionSequenceName = "SMOTTmember";
	String orderNo = "";
	
	Session session = (Session) getSession();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
	/*Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
	
	*/
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId"))).add(Restrictions.eq("MlcType", "Examination by a Specialist Medical Officer/Team of Specialist Medical Officers").ignoreCase());
	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	
	
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();

	Date currentDate = new Date();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/mm/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("ddMMyyyy");
	String dateVal="";
	try {
		dateVal = formatterOut.format(formatterIn.parse(date));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		/*
	List<MedicoLegalDetails>  medicoLegalDetails= new ArrayList<MedicoLegalDetails>();
	medicoLegalDetails= session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("MlcType", "Examination by a Specialist Medical Officer/Team of Specialist Medical Officers").ignoreCase()).addOrder(Order.desc("Id")).setMaxResults(1).list();
	String srNo="";
	int yr=0;
	for(MedicoLegalDetails m:medicoLegalDetails){
		srNo=m.getSerialNo();
			if(srNo!=null){ 
			yr = Integer.parseInt(srNo.substring(4, 8));
	}
	}	

	int year = Calendar.getInstance().get(Calendar.YEAR);
	sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
		TransactionSequence transactionSequence = sequenceNoList.get(0);
		int sequenceNo = transactionSequence.getTransactionSequenceNumber();
		if(yr!=0 && year==yr){
		int s= sequenceNo+1;
		orderNo = dateVal+"-"+s;
		}else{
			orderNo=dateVal+"-"+1;
		}}else{
		orderNo=dateVal+"-"+1;	
		}
*/int year = Calendar.getInstance().get(Calendar.YEAR);
sequenceNoList = session.createCriteria(TransactionSequence.class)
.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
		.createAlias("Hospital", "hosp")
			.add(Restrictions.eq("hosp.Id",box.getInt("hospitalId")))
			.add(Restrictions.eq("FinanicalYear",String.valueOf(year))).
		list();

if(sequenceNoList.size()>0){
TransactionSequence transactionSequence = sequenceNoList.get(0);
int sequenceNo = transactionSequence.getTransactionSequenceNumber();


int s= sequenceNo+1;

orderNo = dateVal+"-"+s;

}else{
orderNo=dateVal+"-"+1;	
}	/*sequenceNoList = session
			.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("TransactionSequenceName",
					transactionSequenceName))
					.createAlias("Hospital", "hosp")
		 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
					list();
	if(sequenceNoList.size()>0){
	TransactionSequence transactionSequence = sequenceNoList.get(0);
	int sequenceNo = transactionSequence.getTransactionSequenceNumber();
	orderNo = sequenceNo + 1;
	}else{
		orderNo=1;	
	}*/
	if(patientWiseMlcs.size()>0){
		if(patientWiseMlcs.get(0).getHin()!=null){
			hinId  = (Integer)patientWiseMlcs.get(0).getHin().getId();	
		}else{
			hinId  = (Integer)patientWiseMlcs.get(0).getInpatient().getHin().getId();		
		}
		
	}
	patientAddress=session.createCriteria(PatientAddress.class) .add(Restrictions.eq("Hin.Id", hinId)).list();
	
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details); 
 map.put("patientWiseMlcs", patientWiseMlcs);
 map.put("orderNo", orderNo);
 map.put("patientAddress", patientAddress);
 return map;
}

@Override
public Map<String, Object> getPostExaminToPoliceSurgun(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	
	Session session = (Session) getSession();
	try{
	Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
	Criteria crHis=session.createCriteria(OpdPatientHistory.class)
		    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
	
	Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
		    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
	
	Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
		    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
	
	
	mlcList=cr.list();
	patientHistories=crHis.list();
	details=crMedico.list();
	patientWiseMlcs=crMlc.list();
	
	}catch(Exception e){
		e.printStackTrace();
	}
 map.put("mlcList", mlcList);
 map.put("patientHistories", patientHistories);
 map.put("details", details); map.put("patientWiseMlcs", patientWiseMlcs);
 
 
	return map;
}

@Override
public Map<String, Object> getProformforRecording(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	Session session = (Session) getSession();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	try{
		Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
		Criteria crHis=session.createCriteria(OpdPatientHistory.class)
			    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
		Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
			    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
		Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
		
		patientWiseMlcs=crMlc.list();
		
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
		
	

     map.put("mlcList", mlcList);
       map.put("details", details);
     map.put("patientWiseMlcs", patientWiseMlcs);
	return map;
}

@Override
public Map<String, Object> addProformforRecording(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	PatientWiseMlc patientWiseMlc=null;
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String mlcType="";
	Transaction tx=null;
	try {
		tx = session.beginTransaction();
		patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Proforma for recording dying declaration by a medical practitioner"))
		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

           PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());
            if(wiseMlc!=null){
           wiseMlc.setStatus("A");
            }
			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			
			
			   
			  if(box.getInt("docId")!=0){
				  MasEmployee employee=new MasEmployee();
				  employee.setId(box.getInt("docId"));
				medicoLegalDetails.setDoctor(employee);
				}
			  
			  
	  
			   medicoLegalDetails.setWitnesses1(box.getString("witfirst"));
			   medicoLegalDetails.setWitnesses2(box.getString("witSecond"));
			   medicoLegalDetails.setWitnesses1Address(box.getString("firstAddres"));
			   medicoLegalDetails.setWitnesses2Address(box.getString("secondAddres"));
			   medicoLegalDetails.setWitnesses1Father(box.getString("fistParnt"));
			   medicoLegalDetails.setWitnesses2Father(box.getString("secParent"));
			   
			   medicoLegalDetails.setReceivedTime(box.getString("time"));
			
			   if(box.getString("pDate")!=null && !box.getString("pDate").equals("")){
			   medicoLegalDetails.setAllegedActDate(HMSUtil.convertStringTypeDateToDateType(box.getString("pDate")));
	                       }
		
			   medicoLegalDetails.setPlaceOfAct(box.getString("pDate"));
			 
			medicoLegalDetails.setMlcType("Proforma for recording dying declaration by a medical practitioner");
			
			  if(box.getInt("inpationId")!=0){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
				   
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			hbt.save(medicoLegalDetails);
			successfullyAdded = true;
			hbt.update(wiseMlc); 
			 tx.commit();

       }catch (DataAccessException e) {
	e.printStackTrace();
	if(tx!=null){
		tx.rollback();	
	}
       }

map.put("successfullyAdded", successfullyAdded);

map.put("message", message);

return map;
}


@Override
public Map<String, Object> getUhid(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	session = (Session) getSession();
	String uhin = box.getString("uhin");
	Integer empId = box.getInt("empId");
	Integer hospitalId = box.getInt("hospitalId");
	
	List<PatientWiseMlc> patWise=new ArrayList<PatientWiseMlc>();
	try {
		Criteria criteria=session.createCriteria(PatientWiseMlc.class)
				.createAlias("Hin","id")
				.createAlias("Hospital", "hosp")
				.createAlias("OpdPatientDetail", "opd")
				.createAlias("opd.Employee", "emp")
				.createAlias("opd.ReferredHospital", "opdreferHos",CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.or(Restrictions.eq("hosp.Id", hospitalId), Restrictions.eq("opdreferHos.Id", hospitalId)))
		        .add(Restrictions.or(Restrictions.eq("Status", "y").ignoreCase(), Restrictions.eq("Status", "AT").ignoreCase()))
		        .add(Restrictions.eq("emp.Id", empId))
		        .add(Restrictions.like("id.HinNo", uhin).ignoreCase());
		
		/*Criteria criteria=session.createCriteria(PatientWiseMlc.class)
				.createAlias("Hin","id")
				.createAlias("Hospital", "hosp")
				.createAlias("OpdPatientDetail", "opd")
				.createAlias("opd.ReferredHospital", "opdreferHos")
				.add(Restrictions.or(Restrictions.eq("hosp.Id", hospitalId), Restrictions.eq("opdreferHos.Id", hospitalId)))
				.add(Restrictions.like("id.HinNo", uhin).ignoreCase());*/
				
		patWise=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	map.put("patWise", patWise);
	return map;
}

@Override
public Map<String, Object> submmitNOObjectionCerificate(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	PatientWiseMlc patientWiseMlc=null;
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String mlcType="";
	Transaction tx=null;
	try {
		tx = session.beginTransaction();
		patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Application cum No Objection Certificate"))
		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

           PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());
            if(wiseMlc!=null){
           wiseMlc.setStatus("A");
            }
			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			
			if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
			  medicoLegalDetails.setPostmortemCertificateNo(box.getString("pmNo"));
			   
			  if(!box.getString("fromDate").trim().equals("")){
				medicoLegalDetails.setPostmortemDate(HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")));
				}
			  if(box.getInt("inpationId")!=0){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
				   
			  medicoLegalDetails.setPatientAddress(box.getString("address"));
			   medicoLegalDetails.setCrimeNo(box.getString("crNO"));
			   medicoLegalDetails.setPoliceStation(box.getString("policeStation"));
			   medicoLegalDetails.setReason(box.getString("resion"));
			   medicoLegalDetails.setRelation(box.getString("relation"));
			   
			medicoLegalDetails.setMlcType("Application cum No Objection Certificate");
			
		
			
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			hbt.save(medicoLegalDetails);
			medicoLegalDetailsId=medicoLegalDetails.getId();
            mlcType=medicoLegalDetails.getMlcType();
			successfullyAdded = true;
			hbt.update(wiseMlc); 
			 tx.commit();

       }catch (DataAccessException e) {
	e.printStackTrace();
	if(tx!=null){
		tx.rollback();	
	}
       }

map.put("successfullyAdded", successfullyAdded);
map.put("mlcType", mlcType);
map.put("medicoLegalDetailsId", medicoLegalDetailsId);

map.put("message", message);

return map;
}

@Override
public Map<String, Object> getAuthenticityCertificate(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	List<MedicoLegalDetails> details = new ArrayList<MedicoLegalDetails>();
	Session session = (Session) getSession();
	List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	try{
		Criteria cr=session.createCriteria(OpdPatientDetails.class)
			    .add(Restrictions.eq("Id", box.getInt("requestId")));
		Criteria crHis=session.createCriteria(OpdPatientHistory.class)
			    .add(Restrictions.eq("OpdPatientDetails.Id", box.getInt("requestId")));
		Criteria crMedico=session.createCriteria(MedicoLegalDetails.class)
			    .add(Restrictions.eq("Hin.Id", box.getInt("hinId")));
		Criteria crMlc=session.createCriteria(PatientWiseMlc.class)
			    .add(Restrictions.eq("OpdPatientDetail.Id", box.getInt("requestId")));
		
		patientWiseMlcs=crMlc.list();
		
	
	mlcList=cr.list();
	}catch(Exception e){
		e.printStackTrace();
	}
		
	

     map.put("mlcList", mlcList);
       map.put("details", details);
     map.put("patientWiseMlcs", patientWiseMlcs);
	return map;
}

@Override
public Map<String, Object> addAuthenticityCertificate(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean successfullyAdded = false;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	PatientWiseMlc patientWiseMlc=null;
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String mlcType="";
	Transaction tx=null;
	try {
		tx = session.beginTransaction();
		patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
		           .add(Restrictions.eq("MlcType","Application cum Certificate of Authenticity"))
		           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

           PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());
            if(wiseMlc!=null){
           wiseMlc.setStatus("A");
            }
			MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
			if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
			if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
			
			  if(box.getInt("inpationId")!=0){
				   Inpatient inp=new Inpatient();
					  inp.setId(box.getInt("inpationId")); 
				   medicoLegalDetails.setInpatient(inp);
				   }
				   
			if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			
				if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			
			hbt.save(medicoLegalDetails);
			successfullyAdded = true;
			hbt.update(wiseMlc); 
			 tx.commit();

       }catch (DataAccessException e) {
	e.printStackTrace();
	if(tx!=null){
		tx.rollback();	
	}
       }

map.put("successfullyAdded", successfullyAdded);

map.put("message", message);

return map;
}


@Override
public Map<String, Object> getUhidReport(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	session = (Session) getSession();
	String uhin = box.getString("hinNo");
	String fromDate=box.get("FromDateId");
	String toDate=box.get("ToDateId");
	
	
	//List<Object> medicoLegalDetailsList=new ArrayList<Object>();
	List<MedicoLegalDetails> dateByMedicoLegalDetailsList=new ArrayList<MedicoLegalDetails>();
	Criteria criteria=null;
	try {
		criteria=session.createCriteria(MedicoLegalDetails.class).createAlias("OpdPatientDetail","opd")
			 	.add(Restrictions.eq("opd.Hospital.Id", box.getInt("hospitalId")))
				.createAlias("Hin","id");
		
		if(!StringUtils.isBlank(uhin)) {
			criteria.add(Restrictions.eq("id.HinNo", uhin));
		}
		
		if (!StringUtils.isBlank(toDate) && !StringUtils.isBlank(fromDate)) {
			criteria.add(Restrictions.ge("ExaminationDate", HMSUtil.convertStringTypeDateToDateType(fromDate)));
			criteria.add(Restrictions.le("ExaminationDate",  HMSUtil.convertStringTypeDateToDateType(toDate)));
			map.put("fromDate", fromDate);
			map.put("toDate", toDate);
		}
			
		dateByMedicoLegalDetailsList=criteria.list();
												
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	map.put("dateByMedicoLegalDetailsList", dateByMedicoLegalDetailsList);
	map.put("uhin", uhin);
	
	return map;
}

@Override
public Map<String, Object> getMlcTypeReport(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	session = (Session) getSession();
	String mlcType = box.getString("mlcType");
	String uhin = box.getString("uhin");
	
	List<Object> medicoLegalDetailsNoList=new ArrayList<Object>();
	
	try {
		Criteria criteria=session.createCriteria(MedicoLegalDetails.class)
				.add(Restrictions.like("MlcType",mlcType).ignoreCase())
				.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.groupProperty("SerialNo"))
										.add(Projections
										 .groupProperty("Id"))
										.add(Projections
												.property("SerialNo"))
									.add(Projections
												.property("Id")));
		
								
		medicoLegalDetailsNoList=criteria.list();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	map.put("medicoLegalDetailsNoList", medicoLegalDetailsNoList);
	map.put("mlcType", mlcType);
	map.put("uhin", uhin);
	
	
	return map;
}


@Override
public Map<String, Object> getPMNoReport(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	session = (Session) getSession();
	String uhin = box.getString("uhin");
		
	
	List<Object> medicoLegalDetailsNoList=new ArrayList<Object>();
	
	try {
		Criteria criteria=session.createCriteria(MedicoLegalDetails.class)
				.createAlias("Hin","id")
				.add(Restrictions.eq("id.HinNo", uhin))
				.add(Restrictions.like("MlcType","Register of Postmortem Examinations"))
				.setProjection(
						Projections
						.projectionList()
						.add(Projections
								.groupProperty("SerialNo"))
						.add(Projections
						 .groupProperty("Id"))
						.add(Projections
								.property("SerialNo"))
					.add(Projections
								.property("Id")));
										
								
		medicoLegalDetailsNoList=criteria.list();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	map.put("medicoLegalDetailsNoList", medicoLegalDetailsNoList);
	map.put("uhin", uhin);
	map.put("mlcType","POSTMORTEM CERTIFICATE");
	
	return map;
}

@Override
public List<Integer> getMLCIdList(Map<String, Object> mapForDs) {
	
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	session = (Session) getSession();
	String hinNo = (String) mapForDs.get("hinNo");
	String mlcType = (String) mapForDs.get("mlcType");
	List<Integer> mlcIdList = new ArrayList<Integer>();
	int medicoLegalDetailsId=0;
	System.out.println("medicoLegalDetailsId  "+medicoLegalDetailsId);
	if(null !=mapForDs.get("medicoLegalDetailsId"))
	medicoLegalDetailsId=(Integer) mapForDs.get("medicoLegalDetailsId");
	if(medicoLegalDetailsId>0){
		int count=0;
	MedicoLegalDetails medicoLegalDetails=(MedicoLegalDetails) session.load(MedicoLegalDetails.class, medicoLegalDetailsId);
	if(null !=medicoLegalDetails.getReportPrintCount())
	count=medicoLegalDetails.getReportPrintCount();
	count=count+1;
	medicoLegalDetails.setReportPrintCount(count);
	session.update(medicoLegalDetails);
	session.flush();
	}
	mlcIdList = session.createQuery("select MAX(Id) from MedicoLegalDetails where MlcType ='"+ mlcType+ "' and Hin.HinNo ='"+hinNo+"'").list();
	return mlcIdList;
}

// Added by Kaushal Mishra 05-05-2016
@Override
public Map<String, Object> showMortuaryRegisterJsp(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<PatientWiseMlc> patientDetails=new ArrayList<PatientWiseMlc>();
	List<MortuaryRegisterDetails> mortuaryRegisterList = new ArrayList<MortuaryRegisterDetails>();
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	Session session = (Session) getSession();
	String transactionSequenceName = "MortuaryRegister";
	int opdPatientDetailId = 0;
	int dischargeId = 0;
	String pType="";
	int orderNo = 0;
	String stringOrderNo = "";
	System.out.println("rtequestId--==="+box.getString("requestId"));
	
	if(box.getString("requestId")!=null && !box.getString("requestId").equals("")){
		//opdPatientDetailId=box.getInt("requestId"); //added by govind 27-10-2016
	}
	
	if(box.getString("dischargeId")!=null && !box.getString("dischargeId").equals("")){
		dischargeId=box.getInt("dischargeId");
	}
	
	if(box.getString("opdPatientDetailId")!=null && !box.getString("opdPatientDetailId").equals("")){
		opdPatientDetailId=box.getInt("opdPatientDetailId");
	}
	if(box.getString("pType")!=null && !box.getString("pType").equals("")){
		pType=box.getString("pType");
	}
	System.out.println("opdPatientDetailId=="+opdPatientDetailId);//added by govind 27-10-2016
	try {
		patientDetails=session.createCriteria(PatientWiseMlc.class).createAlias("OpdPatientDetail", "opd").add(Restrictions.eq("opd.Id", opdPatientDetailId)).list();
		if("IP".equalsIgnoreCase(pType)){
			Criteria criteria=session.createCriteria(ExpiryDetails.class)
					.add(Restrictions.eq("Id", dischargeId)); 
			List<ExpiryDetails> discharges=criteria.list();
			map.put("discharge", discharges);
		}else if("OP".equalsIgnoreCase(pType)){
			Criteria criteria=session.createCriteria(OpdPatientDetails.class)
					.add(Restrictions.eq("Id", opdPatientDetailId)); 
			List<OpdPatientDetails> opdPatientDetails=criteria.list();
			map.put("opdPatientDetails", opdPatientDetails);
			System.out.println("opdPatientDetails=="+opdPatientDetails.size());
		}
		sequenceNoList = session
				.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionSequenceName",transactionSequenceName))
						.createAlias("Hospital", "hosp")
							.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).
						list();
				if(sequenceNoList.size()>0){
				TransactionSequence transactionSequence = sequenceNoList.get(0);
				int sequenceNo = transactionSequence.getTransactionSequenceNumber();
				orderNo = sequenceNo + 1;
				stringOrderNo=box.getString("hospitalCode")+"/"+box.getString("financialYearDesc")+"/"+orderNo;
				}else{
					stringOrderNo=box.getString("hospitalCode")+"/"+box.getString("financialYearDesc")+"/"+1;	
				}
		
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println(patientDetails.size());
	
	map.put("patientDetails", patientDetails);
	System.out.println("hinId==in show==="+box.getInt("hinId"));
	mortuaryRegisterList = session.createCriteria(MortuaryRegisterDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId"))).list();
	map.put("mortuaryRegisterList", mortuaryRegisterList);
	map.put("stringOrderNo", stringOrderNo);
	return map;
}

@Override
public Map<String, Object> showMortuaryRegistedDetails(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	
	List<MortuaryRegisterDetails> mortuaryDetails=new ArrayList<MortuaryRegisterDetails>();
	
	try {
		
		mortuaryDetails=session.createCriteria(MortuaryRegisterDetails.class).add(Restrictions.eq("Status", "m")).list();
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("mortuaryDetails"+mortuaryDetails.size());
	
	map.put("mortuaryDetails", mortuaryDetails);
	return map;
}

@Override
public Map<String, Object> showPostmortemRegisteredDetails(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	
	List<MortuaryRegisterDetails> mortuaryDetails=new ArrayList<MortuaryRegisterDetails>();
	
	try {
		
		mortuaryDetails=session.createCriteria(MortuaryRegisterDetails.class).add(Restrictions.eq("Status", "p")).list();
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("mortuaryDetails"+mortuaryDetails.size());
	
	map.put("mortuaryDetails", mortuaryDetails);
	return map;
}

@Override
public List<MortuaryRegisterDetails> getMortuaryRegisterDetailsForReport(Box box) {

	Session session= (Session) getSession();
	List<MortuaryRegisterDetails> mortuaryDetails= new ArrayList<MortuaryRegisterDetails>();
	
	int patientMlcId =box.getInt("patientMlcId");
	int mortuaryRegdDetailId=box.getInt("mortuaryRegdDetailId");
	
	try {
		if(patientMlcId !=0){
			
			mortuaryDetails= session.createCriteria(MortuaryRegisterDetails.class).createAlias("PatientWiseMlc", "pwm").add(Restrictions.eq("pwm.Id", patientMlcId)).list();
		 int abc=mortuaryDetails.get(0).getId();
		 System.out.println("pabc"+abc);
		}else{
			if(mortuaryRegdDetailId !=0){
			
			mortuaryDetails= session.createCriteria(MortuaryRegisterDetails.class).add(Restrictions.eq("Id",mortuaryRegdDetailId)).list();
			int abc=mortuaryDetails.get(0).getId();
			System.out.println("mabc"+abc);
		}}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return mortuaryDetails ;	
}
@Override
public void saveMLCReportCount(Map<String, Object> mapForDs) {
	
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	session = (Session) getSession();
	
	
	int medicoLegalDetailsId=0;
	System.out.println("medicoLegalDetailsId  "+medicoLegalDetailsId);
	medicoLegalDetailsId=(Integer) mapForDs.get("medicoLegalDetailsId");
	if(medicoLegalDetailsId>0){
		int count=0;
	MedicoLegalDetails medicoLegalDetails=(MedicoLegalDetails) session.load(MedicoLegalDetails.class, medicoLegalDetailsId);
	count=medicoLegalDetails.getReportPrintCount();
	count=count+1;
	medicoLegalDetails.setReportPrintCount(count);
	session.update(medicoLegalDetails);
	session.flush();
	}

}

@Override
public Map<String, Object> updateDrunknessCertifikate(Box box) {
	
	Map<String, Object> map = new HashMap<String, Object>();
	boolean saveFlag = false;
	PatientWiseMlc patientWiseMlc=null;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String transactionSequenceName = "Drunkness";
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	List<MlcMaterialObjects> materialObjectsList = new ArrayList<MlcMaterialObjects>();
	String mlcType="";
	String report="";
	Transaction tx=null;
	
	try {
		tx = session.beginTransaction();	
	 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
	           .add(Restrictions.eq("MlcType","Certificate Of Drunkness"))
	           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

       PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

      if(wiseMlc!=null){
         wiseMlc.setStatus("C");
          }
		
		List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
		medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
				.list();
	 if(medicoLegalDetailsList.size()>0){
			MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
					
			if(box.getInt("hinId")!=0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				medicoLegalDetails.setHin(patient);
				}
			
			if(!box.getString("examinDate").equals("")){
				medicoLegalDetails.setRequisitionDate(HMSUtil.dateFormatterToDDMMYYYY(box.getString("examinDate")));
				}
			medicoLegalDetails.setReflexes(box.getString("reflexes"));
	    	 
			if(!box.getString("arrestdate").equals("") && box.getString("arrestdate")!=null){
				   medicoLegalDetails.setArrestDate(HMSUtil.dateFormatterToDDMMYYYY(box.getString("arrestdate")));
				   }
			if(!box.getString("hcpcNo").equals("")){
				medicoLegalDetails.setAdNo(box.getString("hcpcNo"));
			}
			if(!box.getString("serNo").equals("")){
	        	  medicoLegalDetails.setSerialNo(box.getString("serNo"));
	    	}
			if(box.getString("exdate")!=null && !box.getString("exdate").equals("")){
				   medicoLegalDetails.setExaminationDate(HMSUtil.dateFormatterToDDMMYYYY(box.getString("exdate")));
				   }
			
			medicoLegalDetails.setPoliceStation(box.getString("policestation"));  

			 if(box.getInt("inPatientId")!=0){
					Inpatient inp=new Inpatient();
					inp.setId(box.getInt("inPatientId"));
					medicoLegalDetails.setInpatient(inp);	
				        }
           
			  
			   medicoLegalDetails.setConsent(box.getString("consent"));
			   medicoLegalDetails.setPatientAddress(box.getString("address"));
			   medicoLegalDetails.setUnderArrest(box.getString("arrest"));
			   medicoLegalDetails.setRequisitionFrom(box.getString("reqname"));
			   medicoLegalDetails.setArrestTime(box.getString("time"));

			   medicoLegalDetails.setExaminationTime(box.getString("extime"));
			   medicoLegalDetails.setIdMark1(box.getString("marks1"));
			   medicoLegalDetails.setIdMark2(box.getString("marks2"));
			   medicoLegalDetails.setHistoryAlcoholConsumption(box.getString("alco1"));
			   medicoLegalDetails.setHistoryOfIllness(box.getString("alco2"));
			   medicoLegalDetails.setClothing(box.getString("cloth"));
			   medicoLegalDetails.setGeneralDisposition(box.getString("disposition"));
			   medicoLegalDetails.setSpeech(box.getString("speech"));
			   medicoLegalDetails.setConjunctiva(box.getString("conjuntiva"));
			   medicoLegalDetails.setPupils(box.getString("pupils"));
			   medicoLegalDetails.setSelfControl(box.getString("high"));
			   medicoLegalDetails.setMemory(box.getString("memory"));
			   medicoLegalDetails.setOrientation(box.getString("space"));

			   medicoLegalDetails.setReactionTime(box.getString("retime"));
			   medicoLegalDetails.setGait(box.getString("gait"));
			   medicoLegalDetails.setPulse(box.getInt("pulse"));
			medicoLegalDetails.setBp(box.getString("bp"));
			medicoLegalDetails.setFingerNoseTest(box.getString("finger"));
			medicoLegalDetails.setRombergsSign(box.getString("romberg"));
			medicoLegalDetails.setInjuryOnBody(box.getString("injury"));
			   
			medicoLegalDetails.setAlcoholSmell(box.getString("smell"));
			
			medicoLegalDetails.setBreath(box.getString("breath"));
			medicoLegalDetails.setBloodExamination(box.getString("blood"));
			medicoLegalDetails.setUrinated(box.getString("urine"));
			medicoLegalDetails.setOpinion(box.getString("opinion"));
			medicoLegalDetails.setMlcType("Certificate Of Drunkness");
	     
	     	
			  if(box.getInt("detailId")!=0){
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(box.getInt("detailId"));
					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
					}
				if(box.getInt("userId")!=0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					medicoLegalDetails.setLastChgBy(users);
					}
				if(!box.getString(CHANGED_DATE).equals("")){
				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
				
				

	
	    	hbt.update(wiseMlc);
			hbt.saveOrUpdate(medicoLegalDetails);
			mlcType=medicoLegalDetails.getMlcType();
			medicoLegalDetailsId=medicoLegalDetails.getId();	
			saveFlag = true;
			tx.commit();
	}
	else {

		MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();
		if(box.getInt("hinId")!=0){
		Patient patient = new Patient();
		patient.setId(box.getInt("hinId"));
		medicoLegalDetails.setHin(patient);
		}

		if(!box.getString("examinDate").equals("")){
			medicoLegalDetails.setRequisitionDate(HMSUtil.dateFormatterToDDMMYYYY(box.getString("examinDate")));
			}
		
		  if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
		  medicoLegalDetails.setPatientAddress(box.getString("address"));
		medicoLegalDetails.setReflexes(box.getString("reflexes"));
		medicoLegalDetails.setPoliceStation(box.getString("policestation"));  
		if(!box.getString("arrestdate").equals("") && box.getString("arrestdate")!=null){
			   medicoLegalDetails.setArrestDate(HMSUtil.dateFormatterToDDMMYYYY(box.getString("arrestdate")));
			   }
		if(!box.getString("hcpcNo").equals("")){
			medicoLegalDetails.setAdNo(box.getString("hcpcNo"));
		}
		if(!box.getString("serNo").equals("")){
        	  medicoLegalDetails.setSerialNo(box.getString("serNo"));
    	}
		if(box.getString("exdate")!=null && !box.getString("exdate").equals("")){
			   medicoLegalDetails.setExaminationDate(HMSUtil.dateFormatterToDDMMYYYY(box.getString("exdate")));
			   }
		
		

		 if(box.getInt("inPatientId")!=0){
				Inpatient inp=new Inpatient();
				inp.setId(box.getInt("inPatientId"));
				medicoLegalDetails.setInpatient(inp);	
			        }
       
		  
		   medicoLegalDetails.setConsent(box.getString("consent"));
		 
		   medicoLegalDetails.setUnderArrest(box.getString("arrest"));
		   medicoLegalDetails.setRequisitionFrom(box.getString("reqname"));
		   medicoLegalDetails.setArrestTime(box.getString("time"));

		   medicoLegalDetails.setExaminationTime(box.getString("extime"));
		   medicoLegalDetails.setIdMark1(box.getString("marks1"));
		   medicoLegalDetails.setIdMark2(box.getString("marks2"));
		   medicoLegalDetails.setHistoryAlcoholConsumption(box.getString("alco1"));
		   medicoLegalDetails.setHistoryOfIllness(box.getString("alco2"));
		   medicoLegalDetails.setClothing(box.getString("cloth"));
		   medicoLegalDetails.setGeneralDisposition(box.getString("disposition"));
		   medicoLegalDetails.setSpeech(box.getString("speech"));
		   medicoLegalDetails.setConjunctiva(box.getString("conjuntiva"));
		   medicoLegalDetails.setPupils(box.getString("pupils"));
		   medicoLegalDetails.setSelfControl(box.getString("high"));
		   medicoLegalDetails.setMemory(box.getString("memory"));
		   medicoLegalDetails.setOrientation(box.getString("space"));

		   medicoLegalDetails.setReactionTime(box.getString("retime"));
		   medicoLegalDetails.setGait(box.getString("gait"));
		   medicoLegalDetails.setPulse(box.getInt("pulse"));
		medicoLegalDetails.setBp(box.getString("bp"));
		medicoLegalDetails.setFingerNoseTest(box.getString("finger"));
		medicoLegalDetails.setRombergsSign(box.getString("romberg"));
		medicoLegalDetails.setInjuryOnBody(box.getString("injury"));
		   
		medicoLegalDetails.setAlcoholSmell(box.getString("smell"));
		
		medicoLegalDetails.setBreath(box.getString("breath"));
		medicoLegalDetails.setBloodExamination(box.getString("blood"));
		medicoLegalDetails.setUrinated(box.getString("urine"));
		medicoLegalDetails.setOpinion(box.getString("opinion"));
		medicoLegalDetails.setMlcType("Certificate Of Drunkness");
     

       
		if(box.getInt("userId")!=0){
			Users users = new Users();
			users.setId(box.getInt("userId"));
			medicoLegalDetails.setLastChgBy(users);
			}
		if(!box.getString(CHANGED_DATE).equals("")){
		medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
		}
		medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
		
		
		

String srNo=box.getString("serNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
			if(sequenceNoList.size()>0){
           TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
			int orderNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = orderNo + 1;
			int id = transactionSequence.getId();

			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
			transactionSequence2.setTransactionSequenceNumber(orderNo);
			hbt.update(transactionSequence2);
			}else if (sequenceNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
 				tsObj.setTransactionPrefix("DC");
				tsObj.setTransactionSequenceName(transactionSequenceName);
				tsObj.setTransactionSequenceNumber(1);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				MasHospital hospital= new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				tsObj.setHospital(hospital);
				tsObj.setFinanicalYear(yr);

				hbt.save(tsObj);
				
			}
        
		
		hbt.save(medicoLegalDetails);
		

		saveFlag = true;

		medicoLegalDetailsId=medicoLegalDetails.getId();
		mlcType=medicoLegalDetails.getMlcType();

		hbt.update(wiseMlc); 
		tx.commit();
		
	}
	 report = "need report";
	}
	catch (DataAccessException e) {
		e.printStackTrace();
		if(tx==null){
			tx.rollback();
		}
		
	}
	map.put("medicoLegalDetailsId", medicoLegalDetailsId);	
	map.put("saveFlag", saveFlag);
	map.put("mlcType", mlcType);
	map.put("report", report);
	
	return map;
}


@Override
public Map<String, Object> updateTreetmentDischarge(Box box) {
	
	Map<String, Object> map = new HashMap<String, Object>();
	boolean saveFlag = false;
	PatientWiseMlc patientWiseMlc=null;
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Session session= (Session) getSession();
	String message ="";
	int medicoLegalDetailsId=0;
	String transactionSequenceName = "TreatmentDischarge";
	List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
	List<MlcMaterialObjects> materialObjectsList = new ArrayList<MlcMaterialObjects>();
	String mlcType="";
	String report="";
	Transaction tx=null;
	
	try {
		tx = session.beginTransaction();	
	 patientWiseMlc=(PatientWiseMlc) session.createCriteria(PatientWiseMlc.class)
	           .add(Restrictions.eq("MlcType","Treatment / Discharge Certificate"))
	           .add(Restrictions.eq("OpdPatientDetail.id",box.getInt("detailId"))).uniqueResult();

       PatientWiseMlc wiseMlc=(PatientWiseMlc)hbt.load(PatientWiseMlc.class, patientWiseMlc.getId());

      if(wiseMlc!=null){
         wiseMlc.setStatus("C");
          }
		
		List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
		medicoLegalDetailsList = session.createCriteria(MedicoLegalDetails.class).add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
				.list();
	 if(medicoLegalDetailsList.size()>0){
			MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)hbt.load(MedicoLegalDetails.class, box.getInt("mediCoId"));
			
			

			
			if(box.getInt("hinId")!=0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				medicoLegalDetails.setHin(patient);
				}
			
			if(!box.getString("adDate").equals("")){
				medicoLegalDetails.setAdmissionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("adDate")));
				}
			if(!box.getString("disDate").equals("")){
				medicoLegalDetails.setDischargeDate(HMSUtil.convertStringTypeDateToDateType(box.getString("disDate")));
				}
			medicoLegalDetails.setConditionAtDischarge(box.getString("conDis"));
			
	/*		 if(box.getInt("inPatientId")!=0){
					Inpatient inp=new Inpatient();
					inp.setId(box.getInt("inPatientId"));
					medicoLegalDetails.setInpatient(inp);	
				        }*/
			 medicoLegalDetails.setInvResult(box.getString("inresult"));
				

			  if(box.getInt("docName")!=0){
				  MasEmployee employee=new MasEmployee();
				  employee.setId(box.getInt("docName"));
				medicoLegalDetails.setDoctor(employee);
				}
	    	
			  if(box.getInt("detailId")!=0){
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(box.getInt("detailId"));
					medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
					}
			  medicoLegalDetails.setPatientAddress(box.getString("address"));
	    	
			  if(!box.getString("refMLDate").equals("")  &&  box.getString("refMLDate")!=null){
					medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
					}
			  if(!box.getString("refNo").equals("")){
	        	  medicoLegalDetails.setSerialNo(box.getString("refNo"));
	    	}
			  if(!box.getString("treet").equals("")){
	        	  medicoLegalDetails.setTreatment(box.getString("treet"));
	    	}
			  if(!box.getString("conatAdmi").equals("")){
	        	  medicoLegalDetails.setPatientCondition(box.getString("conatAdmi"));
	    	}
			  if(!box.getString("remarks1").equals("")){
	        	  medicoLegalDetails.setRemarks(box.getString("remarks1"));
	    	}
			  if(!box.getString("adForter").equals("")){
				  medicoLegalDetails.setAdviseOnDischarge(box.getString("adForter"));
	    	}
			  if(!box.getString("wocer").equals("")){
				  medicoLegalDetails.setInjuryDetails(box.getString("wocer"));
	    	}
	    	
	    	
			  medicoLegalDetails.setMlcType("TREATMENT / DISCHARGE CERTIFICATE");
			  if(box.getInt("userId")!=0){
					Users users = new Users();
					users.setId(box.getInt("userId"));
					medicoLegalDetails.setLastChgBy(users);
					}
				if(!box.getString(CHANGED_DATE).equals("")){
				medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				}
				medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
				

				 if(box.getInt(ADMISSION_NUMBER)!=0){
						Inpatient inp=new Inpatient();
						inp.setId(box.getInt(ADMISSION_NUMBER));
						medicoLegalDetails.setInpatient(inp);	
					        }
            
			
				

	
	    	hbt.update(wiseMlc);
			hbt.saveOrUpdate(medicoLegalDetails);
			mlcType=medicoLegalDetails.getMlcType();
			medicoLegalDetailsId=medicoLegalDetails.getId();	
			saveFlag = true;
			tx.commit();
	}
	else {

		MedicoLegalDetails medicoLegalDetails = new MedicoLegalDetails();

		
		if(box.getInt("hinId")!=0){
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			medicoLegalDetails.setHin(patient);
			}
		
		if(!box.getString("adDate").equals("")){
			medicoLegalDetails.setAdmissionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("adDate")));
			}
		if(!box.getString("disDate").equals("")){
			medicoLegalDetails.setDischargeDate(HMSUtil.convertStringTypeDateToDateType(box.getString("disDate")));
			}
		medicoLegalDetails.setConditionAtDischarge(box.getString("conDis"));
		/*	 if(box.getInt("inPatientId")!=0){
				Inpatient inp=new Inpatient();
				inp.setId(box.getInt("inPatientId"));
				medicoLegalDetails.setInpatient(inp);	
			        }*/
		 medicoLegalDetails.setInvResult(box.getString("inresult"));
			

		  if(box.getInt("docName")!=0){
			  MasEmployee employee=new MasEmployee();
			  employee.setId(box.getInt("docName"));
			medicoLegalDetails.setDoctor(employee);
			}
    	
		  if(box.getInt("detailId")!=0){
				OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
				opdPatientDetails.setId(box.getInt("detailId"));
				medicoLegalDetails.setOpdPatientDetail(opdPatientDetails);
				}
		  medicoLegalDetails.setPatientAddress(box.getString("address"));
    	
		  if(!box.getString("refMLDate").equals("")  &&  box.getString("refMLDate")!=null){
				medicoLegalDetails.setRefDate(HMSUtil.convertStringTypeDateToDateType(box.getString("refMLDate")));
				}
		  if(!box.getString("refNo").equals("")){
        	  medicoLegalDetails.setSerialNo(box.getString("refNo"));
    	}
		  if(!box.getString("treet").equals("")){
        	  medicoLegalDetails.setTreatment(box.getString("treet"));
    	}
		  if(!box.getString("conatAdmi").equals("")){
        	  medicoLegalDetails.setPatientCondition(box.getString("conatAdmi"));
    	}
		  if(!box.getString("remarks1").equals("")){
        	  medicoLegalDetails.setRemarks(box.getString("remarks1"));
    	}
		  if(!box.getString("adForter").equals("")){
			  medicoLegalDetails.setAdviseOnDischarge(box.getString("adForter"));
    	}
		  if(!box.getString("wocer").equals("")){
			  medicoLegalDetails.setInjuryDetails(box.getString("wocer"));
    	}
    	
    	
		  medicoLegalDetails.setMlcType("TREATMENT / DISCHARGE CERTIFICATE");
		  if(box.getInt("userId")!=0){
				Users users = new Users();
				users.setId(box.getInt("userId"));
				medicoLegalDetails.setLastChgBy(users);
				}
			if(!box.getString(CHANGED_DATE).equals("")){
			medicoLegalDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			}
			medicoLegalDetails.setLastChgTime(box.getString(CHANGED_TIME));
			

			 if(box.getInt(ADMISSION_NUMBER)!=0){
					Inpatient inp=new Inpatient();
					inp.setId(box.getInt(ADMISSION_NUMBER));
					medicoLegalDetails.setInpatient(inp);	
				        }
        
		
		
		

String srNo=box.getString("refNo");
				String yr = "";
				if(srNo!=null){ 
						 yr = srNo.substring(4, 8);
						
				}				
				sequenceNoList = session
		 					.createCriteria(TransactionSequence.class)
		 					.add(Restrictions.eq("TransactionSequenceName",
		 							transactionSequenceName))
		 							.createAlias("Hospital", "hosp")
				 			.add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
				 			.add(Restrictions.eq("FinanicalYear", yr))
		 							.list();
			if(sequenceNoList.size()>0){
           TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList.get(0);
			int orderNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = orderNo + 1;
			int id = transactionSequence.getId();

			TransactionSequence transactionSequence2 = (TransactionSequence) hbt.load(TransactionSequence.class, id);
			transactionSequence2.setTransactionSequenceNumber(orderNo);
			hbt.update(transactionSequence2);
			}else if (sequenceNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
 				tsObj.setTransactionPrefix("TD");
				tsObj.setTransactionSequenceName(transactionSequenceName);
				tsObj.setTransactionSequenceNumber(1);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				MasHospital hospital= new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				tsObj.setHospital(hospital);
				tsObj.setFinanicalYear(yr);
				hbt.save(tsObj);
				
			}
        
		
		hbt.save(medicoLegalDetails);
		

		saveFlag = true;

		medicoLegalDetailsId=medicoLegalDetails.getId();
		mlcType=medicoLegalDetails.getMlcType();

		hbt.update(wiseMlc); 
		tx.commit();
		
	}
	 report="need report";
	}
	catch (DataAccessException e) {
		e.printStackTrace();
		if(tx==null){
			tx.rollback();
		}
		
	}
	map.put("medicoLegalDetailsId", medicoLegalDetailsId);	
	map.put("saveFlag", saveFlag);
	map.put("mlcType", mlcType);
	map.put("report", report);
	
	return map;
}
}