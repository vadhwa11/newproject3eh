<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<%
int inPatientId=0;
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
	}
if (map.get("inPatientId") != null) {
	inPatientId = (Integer) map.get("inPatientId");
	}
Box box=(Box)map.get("box")
%>



<%

int hdb = box.getInt("hdb");
String pvms = "";
for (int l = 1; l <= hdb; l++) {
	if(box.getString("pvmsNotreatment"+l)!=null && !box.getString("pvmsNotreatment"+l).equals(""))
	{
	pvms = box.getString("pvmsNotreatment"+l);
	break;
	}
}
if (!pvms.equals("")) {
	
	InpatientPrescriptionHeader inpatientPrescriptionHeader=new InpatientPrescriptionHeader();
	//PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
	inpatientPrescriptionHeader.setHin(p);
	inpatientPrescriptionHeader.setDepartment(md);
	inpatientPrescriptionHeader.setInpatient(inpatient);
	inpatientPrescriptionHeader.setHospital(masHospitalObj);
	inpatientPrescriptionHeader.setStatus("p");
	inpatientPrescriptionHeader.setPrescriptionDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
	inpatientPrescriptionHeader.setPrescriptionTime(consultationTime);
	inpatientPrescriptionHeader.setPrescriptionBy(masEmployee);
	inpatientPrescriptionHeader.setOpdPatientDetail(opdPatientDetails);
	inpatientPrescriptionHeader.setPrescriptionDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("treatmentdate")));
	inpatientPrescriptionHeader.setPrescriptionTime(box.getString("treatmenttime"));
	
	
//	need to be update after discussion
	int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
	inpatientPrescriptionHeader.setPrescriptionNo(String.valueOf(prescriptionNo));
//	String sqlItemId="";
//	List<Integer> itemIdList = new ArrayList<Integer>();
	hbt.save(inpatientPrescriptionHeader);
	for (int i = 1; i <= hdb; i++) {
		/*if(! box.getString("pvmsNo"+i).equals("")){
			String pvmsNo = box.getString("pvmsNo"+i);
			List<Integer> itemList = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", pvmsNo)).setProjection(Projections.property("Id")).list();
			int itemId = itemList.get(0);
			if(sqlItemId.equals("")){
				sqlItemId=""+itemId;
			}else{
				sqlItemId +=" , "+itemId;
			}
			itemIdList.add(itemId);
		}else{
			itemIdList.add(0);
		}*/
//		if(!box.getString("nomenclaturetreatment"+i).equals("")){
		
		
//		if(sqlItemId.equals("")){
//			sqlItemId=""+itemId;
//		}else{
//			sqlItemId +=" , "+itemId;
//		}
//		itemIdList.add(itemId);
//		}else{
//			itemIdList.add(0);
//		}
		

		
		if(box.getString("nomenclaturetreatment"+i)!=null && !box.getString("nomenclaturetreatment"+i).equals("")){
			
			InpatientPrescriptionDetails inpatientPrescriptionDetails=new InpatientPrescriptionDetails();
			//PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
			MasStoreItem masStoreItem = new MasStoreItem();
			
			int index1 = box.getString("nomenclaturetreatment"+i).lastIndexOf("(");
			 int index2 = box.getString("nomenclaturetreatment"+i).lastIndexOf(")");
			
			 index1++;
			int itemId =Integer.parseInt(box.getString("nomenclaturetreatment"+i).substring(index1, index2));
			masStoreItem.setId(itemId);
//			masStoreItem.setId(itemIdList.get(i-1));
			inpatientPrescriptionDetails.setItem(masStoreItem);
			MasFrequency masFrequency = new MasFrequency();
			masFrequency.setId(box.getInt("frequencytreatment"+i));
			inpatientPrescriptionDetails.setFrequency(masFrequency);
			inpatientPrescriptionDetails.setDosage(box.getFloat("dosagetreatment"+i));
			inpatientPrescriptionDetails.setSplInstruction(box.getString("spslinstructiontreatment"+i));
			inpatientPrescriptionDetails.setNoOfDays(box.getInt("noOfDaystreatment"+i));
			inpatientPrescriptionDetails.setType("IP");
			
			if(box.getString("instructiontreatment"+i)!=null && !box.getString("instructiontreatment"+i).equals("") && box.getInt("instructiontreatment"+i)!=0)
			{
			OpdInstructionTreatment instructionTreatment=new OpdInstructionTreatment();
			instructionTreatment.setId(box.getInt("instructiontreatment"+i));
			inpatientPrescriptionDetails.setInsrtuction(instructionTreatment);
			}
			
			if(box.getString("routetreatment"+i)!=null && !box.getString("routetreatment"+i).equals("")  && box.getInt("routetreatment"+i)!=0)
			{
			RouteOfAdministration routeOfAdministration=new RouteOfAdministration();
			routeOfAdministration.setId(box.getInt("routetreatment"+i));
			inpatientPrescriptionDetails.setRoute(routeOfAdministration);
			}
			
			inpatientPrescriptionDetails.setTotal(box.getFloat("totaltreatment"+i));
			inpatientPrescriptionDetails.setStopMedicine("n");
			
//			patientPrescriptionDetails.setGivenQty(0);
			inpatientPrescriptionDetails.setPrescription(inpatientPrescriptionHeader);
//			patientPrescriptionDetails.setDetailStatus("a");
			
			/*List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
			storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id="+itemIdList.get(i-1)+" and ic.Id="+item_category_id);
			if(storeItemList.size() > 0){
				patientPrescriptionDetails.setInjectionStatus("p");
			}else{
				patientPrescriptionDetails.setInjectionStatus("n");
			}*/

			hbt.save(inpatientPrescriptionDetails);
		}
		/**
		 * This Code is use for Injection Appointment
		 * Code By Ritu Sahu
		 * Date 07 Nov 2011
		 */

		/*	if(storeItemList.size()>0){
			List<InjAppointmentHeader> injectionRegisterList=new ArrayList<InjAppointmentHeader>();
			injectionRegisterList=hbt.find("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id="+visitId);
			InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();

			  if(injectionRegisterList.size()>0) means , Data is already available In InjectionRegister table  

			if(injectionRegisterList.size()>0){
				for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
					injectionAppointment.setId(injectionRegisterTemp.getId());
				}
			}else{
				injectionAppointment.setAppointmentDate(new Date());
				Patient patientInj = new Patient();
				patientInj.setId(hinId);
				injectionAppointment.setHin(patientInj);
				Visit visitInj = new Visit();
				visitInj.setId(visitId);
				injectionAppointment.setVisit(visitInj);
				MasHospital masHospitalInj = new MasHospital();
				masHospitalInj.setId(hospitalId);
				injectionAppointment.setHospital(masHospitalInj);

				injectionAppointment.setStatus("p");
				injectionAppointment.setLastChgTime(time);
				Users user = new Users();
				user.setId(userId);
				injectionAppointment.setLastChgBy(user);
				injectionAppointment.setLastChgDate(date);
				injectionAppointment.setPrescription(patientPrescriptionHeader);
				hbt.save(injectionAppointment);
			}
			int freqCount=0;
			if(frequencyList.get(i) > 10){
				freqCount = 1;  if frequency is greater than 10 then only one entry will go in Injection Appointment table
			}else{
				freqCount = frequencyList.get(i);
			}
			if(freqCount > 0){	
				for (int j = 1; j <= freqCount; j++) {
					InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
					injAppointmentDetails.setAppointmentTime(time);
					injAppointmentDetails.setDose(dosageList.get(i));
					MasFrequency frequency = new MasFrequency();
					frequency.setId(frequencyList.get(i));
					injAppointmentDetails.setFrequency(frequency);
					injAppointmentDetails.setRoute(routeList.get(i));
					MasStoreItem item = new MasStoreItem();
					item.setId(itemIdList.get(i));
					injAppointmentDetails.setItem(item);
					injAppointmentDetails.setInjAppointmentHeader(injectionAppointment);
					injAppointmentDetails.setNoOfDays(noOfDaysList.get(i));
					injAppointmentDetails.setPatientPrescriptionDetails(patientPrescriptionDetails);
					injAppointmentDetails.setStatus("p");
					hbt.save(injAppointmentDetails);
				}
			}
		}*/
		/**
		 * END Of COde
		 * This Code is use for Injection
		 * Code By Ritu Sahu
		 * Date 07 Nov 2011
		 */
	
		
		
//	}
	}
	/*List<MasStoreItem> masItemList=new ArrayList<MasStoreItem>();
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
	.getResource("adt.properties");
	int item_category_id=0;
	try {
		properties.load(resourcePath.openStream());

		String item_category_code = properties.getProperty("item_category_id");
		item_category_id=Integer.parseInt(item_category_code);
	} catch (Exception e) {
		e.printStackTrace();
	}

	masItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in ("+sqlItemId+") and ic.Id="+item_category_id);

	if(masItemList.size()>0){
		patientPrescriptionHeader.setInjectionStatus("p");
	}else{
		patientPrescriptionHeader.setInjectionStatus("n");
	}*/

	/** End Of Code This block is use for Check Injection in Prescription List
	 */ 

	
}


%>