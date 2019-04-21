
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="javax.print.attribute.HashAttributeSet"%>
<%@page import="jkt.hms.masters.business.OpdPatientSecondOpinion"%>
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.util.ComaparatorForBaseMasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20">  -->
<SCRIPT language=javascript src="/hms/jsp/js/common.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"	type=text/javascript></SCRIPT>
<SCRIPT>
		<%
	
			Calendar calendar=Calendar.getInstance();
			String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
			String dateCal=String.valueOf(calendar.get(Calendar.DATE));
			int year=calendar.get(calendar.YEAR);
			if(month.length()<2){
				month="0"+month;
			}
			if(dateCal.length()<2){
				dateCal="0"+dateCal;
			}
			
		%>
			serverdate = '<%=dateCal+"/"+month+"/"+year%>'
		</SCRIPT>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		List<Object[]> visitListJsp = new ArrayList<Object[]>();
		List<MasDepartment> departmentListJsp = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeListJsp = new ArrayList<MasEmployee>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		if(map.get("visitList") != null){
			visitListJsp= (List<Object[]>)map.get("visitList");
		}
		
		

		if(map.get("departmentList") != null){
			departmentListJsp= (List<MasDepartment>)map.get("departmentList");
			// Start of Alphabetical Sorting By dept name ---- Added by Amit Das on 17-02-2016
						ComaparatorForBaseMasDepartment comaparatorForBaseMasDepartment = new ComaparatorForBaseMasDepartment();
						Collections.sort(departmentListJsp, comaparatorForBaseMasDepartment);
						// End of Alphabetical Sorting By dept name
		}
		
		if(map.get("employeeList") != null){
			employeeListJsp= (List<MasEmployee>)map.get("employeeList");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String message = "";
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		int deptId=35;
		Map<Integer,Object> doctorMap=new HashMap<Integer,Object>();
		if(map.get("doctorMap") != null){
			doctorMap= (Map<Integer,Object>)map.get("doctorMap");
		}
	%>

<div id="searchresults" tabindex=2>
<div class="cmnTable"  id="searchtable" class="small" tabindex=2>
</div>
</div>

<script type="text/javascript" language="javascript"> 

       data_header = new Array();
       
       data_header[0] = new Array;
       data_header[0][0] = "Sl No."
       //data_header[0][1] = "data";//Commented by Arbin on 21-Jan-2017
	   data_header[0][1] = "hide";
       data_header[0][2] = "15%";
       data_header[0][3] = "slno";
       
       
       
       data_header[1] = new Array;
       data_header[1][0] = "UHID_id"                
       data_header[1][1] = "hide";
       data_header[1][2] = "15%";
       data_header[1][3] = "hin";
       
       data_header[2] = new Array;
       data_header[2][0] = "Token No./Queue No"           
       data_header[2][1] = "data";
       data_header[2][2] = "10%";
       data_header[2][3] = "token"; 
       
     
       
       
       data_header[3] = new Array;
       data_header[3][0] = "UHID"
       data_header[3][1] = "data";
       data_header[3][2] = "15%";
       data_header[3][3] = "uhin_id";
       
       
       data_header[4] = new Array;
       data_header[4][0] = "Patient Name"
       data_header[4][1] = "data";
       data_header[4][2] = "20%";
       data_header[4][3] = "patName";
               
       data_header[5] = new Array;
       data_header[5][0] = "Department"
       data_header[5][1] = "data";
       data_header[5][2] = "30%";
       data_header[5][3] = "Department";
       
       data_header[6] = new Array;
       data_header[6][0] = "Prescribed By"
       data_header[6][1] = "data";
       data_header[6][2] = "30%";
       data_header[6][3] = "prescribed_by";
       
       data_header[7] = new Array;
       data_header[7][0] = "Date"
       data_header[7][1] = "data";
       data_header[7][2] = "30%";
       data_header[7][3] = "Date";
       
       data_header[8] = new Array;
       data_header[8][0] = "Priority"
       data_header[8][1] = "hide";
       data_header[8][2] = "30%";
       data_header[8][3] = "Date"; 
       data_arr = new Array();
        <%System.out.println("visitList in jsp--"+visitListJsp.size());
           int  counter=0;
               if (visitListJsp != null && visitListJsp.size()> 0) {
                       int loopIndex=1; 
                for(Object[] visitList : visitListJsp){    
                                      
       %>
                       data_arr[<%= counter%>] = new Array();
                       data_arr[<%= counter%>][0] = "<%= counter+1%>"
                       data_arr[<%= counter%>][1] = "<%=counter+1%>"
    				   data_arr[<%= counter%>][2] = "<%=visitList[8]%>,<%=visitList[3]%>,<%=((MasDepartment)visitList[5]).getId()%>"
                       data_arr[<%= counter%>][3] = "<%=visitList[1]%>"//for token
                       data_arr[<%= counter%>][4] = "<%=visitList[2]%>"
                       data_arr[<%= counter%>][5] ="<%=visitList[4]%>"
                       
                       <%if((MasDepartment)visitList[5]!=null){%>
                     	 data_arr[<%= counter%>][6] = "<%=((MasDepartment)visitList[5]).getDepartmentName()%>"
                       <%}else{%>
                     	  data_arr[<%= counter%>][6] = "" 
                       <%}%>
                      
                      <%-- <% if((MasEmployee)visitList[6]!=null){//added by govind 25-08-2017%>
                    	  data_arr[<%= counter%>][7] = "<%=((MasEmployee)visitList[6]).getEmployeeName()%>" 
                      <%}else{%>
                    	  data_arr[<%= counter%>][7] = "" 
                      <%}%> --%>
                      
                      <%Integer vId=(Integer)visitList[9];
                      if(doctorMap.get(vId)!=null){ OpdPatientDetails opd=(OpdPatientDetails)doctorMap.get(vId);%>
                	  data_arr[<%= counter%>][7] = "<%=opd.getEmployee().getEmployeeName()%>" 
                  <%}else{%>
                	  data_arr[<%= counter%>][7] = "" 
                  <%}//added by govind 25-08-2017 end%>
                    	   data_arr[<%= counter%>][8] = "<%=HMSUtil.changeDateToddMMyyyy((Date)visitList[7])%>"
                    		   data_arr[<%= counter%>][9] = '<input type="radio" />'
                       <%counter++;
                       loopIndex++;
            
               
       }}
              
               %> 
               formName = "CurrentDispensing"
       
      
       
       start = 0;
       if(data_arr.length < rowsPerPage){
               end = data_arr.length;
               
       }
       else{
               end = rowsPerPage;
       
       }
       
       makeTable(start,end);
</script>
