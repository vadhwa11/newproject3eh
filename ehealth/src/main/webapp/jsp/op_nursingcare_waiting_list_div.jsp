<%@page import="jkt.hms.masters.business.InjAppointmentHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js?n=1"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript">
	<%
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script> 
<%

	
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	int totalPatient=0;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");

	String depName="";
	if(session.getAttribute("deptName")!=null){
		depName=(String)session.getAttribute("deptName");	
	}
	
	
	/* List<PatientPrescriptionHeader>nursingCareWaitingList=new ArrayList<PatientPrescriptionHeader>();
	if(map.get("nursingCareWaitingList") != null){
		nursingCareWaitingList=(List)map.get("nursingCareWaitingList");
	} */
	List<Visit>pendingNursingList=(List<Visit>)map.get("pendingNursingList");
	Map<String,Integer> doctorMap=new HashMap<String, Integer>();
	if(map.get("doctorMap")!=null){
		doctorMap=(Map)map.get("doctorMap");
	}
	List<OpdPatientDetails> opdPatientList=new ArrayList<OpdPatientDetails>();
	if (map.get("opdPatientList") != null) {
		opdPatientList = (List<OpdPatientDetails>) map.get("opdPatientList");
	}
	%>
<div id="searchresults" tabindex=2 >
<div class="Blockdiv1 floatLeft"  id="searchtable" class="small" tabindex=2></div>
</div>

<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	
	data_header[1] = new Array;
	data_header[1][0] = "Token No"
	data_header[1][1] = "data";
	data_header[1][2] = "8%";
	
	data_header[2] = new Array;
	data_header[2][0] = "UHID"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";

	data_header[3] = new Array;
	data_header[3][0] = "OP Date"
	data_header[3][1] = "data";
	data_header[3][2] = "5%";
	
	data_header[4] = new Array;
	data_header[4][0] = "Patient Name"
	data_header[4][1] = "data";
	data_header[4][2] = "5%";

	data_header[5] = new Array;
	data_header[5][0] = "Age"
	data_header[5][1] = "data";
	data_header[5][2] = "6%";

	data_header[6] = new Array;
	data_header[6][0] = "Gender"
	data_header[6][1] = "data";
	data_header[6][2] = "5%";

	data_header[7] = new Array;
	data_header[7][0] = "Doctor Name"
	data_header[7][1] = "data";
	data_header[7][2] = "5%";
	
	data_header[8] = new Array;
// 	data_header[8][0] = "Patient Category"
 	data_header[8][0] = "Department"
	data_header[8][1] = "data";
	data_header[8][2] = "5%";
	
	data_header[9] = new Array;
	data_header[9][0] = "Status"
	data_header[9][1] = "data";
	data_header[9][2] = "5%";
	
	data_header[10] = new Array;
	data_header[10][0] = "Priority"
	data_header[10][1] = "data";
	data_header[10][2] = "5%";
	
	
	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";
	if(pendingNursingList!=null && pendingNursingList.size()>0){
	Iterator iterator=pendingNursingList.iterator();
	
	while(iterator.hasNext())
	{	
		Visit visit=(Visit)iterator.next();
		int injHeaderId=0;
		
		String patientStatus="";
		Patient patientHin=(Patient)visit.getHin();
		String patientCategory="";
		String patientName="";
		String deptName="";
		String age="";
		String priority="";
	
			patientStatus="Pending";
			if(visit.getDepartment()!=null){
				deptName=visit.getDepartment().getDepartmentName();
			}
		if(patientHin.getPatientCategory()!=null){
			 patientCategory=patientHin.getPatientCategory().getPatientCategoryName();
		}
		if(patientHin.getAge()!=null && !patientHin.getAge().equals("")){
			age=patientHin.getAge();
		}
		if(visit.getHin().getPFirstName()!= null){
			patientName=visit.getHin().getPFirstName();
			
			if(visit.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+visit.getHin().getPMiddleName();
			}
			if(visit.getHin().getPLastName()!= null)
			{
			patientName=patientName+" "+visit.getHin().getPLastName();
			}
		
		}else if(visit.getHin().getFullName()!=null){
			patientName = visit.getHin().getFullName();
		}
		String doctorName="";
		
		for(OpdPatientDetails doc:opdPatientList){
			if(visit.getId()==doc.getVisit().getId()){
				doctorName=doc.getEmployee().getFirstName();
			}
		}
		
		/*if(visit.getDoctor()!=null){
			if( !visit.getDoctor().getFirstName().equals(" ")){
				doctorName= visit.getDoctor().getFirstName()+" ";
			}
			if(visit.getDoctor().getMiddleName()!=null && !visit.getDoctor().getMiddleName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getMiddleName()+" ";
			}
			if(visit.getDoctor().getLastName()!=null && !visit.getDoctor().getLastName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getLastName();
			}
			if(doctorName.equals("")){
				if(visit.getDoctor().getEmployeeName()!=null && !visit.getDoctor().getEmployeeName().equals(" ")){
					doctorName=visit.getDoctor().getEmployeeName();
				}	
			}
		}*/
		/* String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate()); */
		String sex="";
		MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		if(masAdministrativeSex!=null && (masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""))
		sex = masAdministrativeSex.getAdministrativeSexName();
		priority=String.valueOf(visit.getPriorityNumber());
		/* Added by Arbind on 26-04-2017 */
		String yearMonth = "";
		if(visit.getHin().getDateOfBirth()!=null){
			Date dob=visit.getHin().getDateOfBirth();
			String ymd=HMSUtil.calculateYearMonthDay(dob);
			String d[]=ymd.split("&");
			int year1=Integer.parseInt(d[0].toString());
			int months1=Integer.parseInt(d[1].toString());
			int days1=Integer.parseInt(d[2].toString());
			yearMonth = year1 != 0 ? d[0] + " Y " : "";
			yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
			yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
		}
		%>
		data_arr[<%= i%>] = new Array();
		data_arr[<%= i%>][0] ="<%=injHeaderId%>"
		data_arr[<%= i%>][2] ="<%=visit.getTokenNo()%>"
		data_arr[<%= i%>][3] ="<%=visit.getHin().getHinNo()%>"
		data_arr[<%= i%>][4] = "<%=HMSUtil.changeDateToddMMyyyy(visit.getVisitDate())%>" 
		data_arr[<%= i%>][5] = "<%=patientName%> " 
		data_arr[<%= i%>][6]="<%=yearMonth%>"
		data_arr[<%= i%>][7] = "<%=sex%>"
		data_arr[<%= i%>][8] = "<%=doctorName%>"
			//data_arr[<%= i%>][9] = "<%=patientCategory%>"
			data_arr[<%= i%>][9] = "<%=deptName%>"
		data_arr[<%= i%>][10] ="<%=patientStatus%>"
		data_arr[<%= i%>][11] ="<%=priority%>"
		data_arr[<%= i%>][12] ="<%=visit.getId()%>"
	<%
		i++;
	}
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	%>

	formName = "op_nursingcare_Waiting_List"

	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	
	makeGridForPatient(start,end);

</script>
