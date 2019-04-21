<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
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
		
		int tokenNo = 0;
		String hinNo = "";
		String patName = "";
		String mobileNo = "";
		int doctorId = 0;
		int deptId2=0;
		int phramacyDeptId = 0;
		
		if(map.get("tokenNo")!=null){
			tokenNo=Integer.parseInt(map.get("tokenNo").toString());
		}
		if(map.get("hinNo")!=null){
			hinNo=map.get("hinNo").toString();
		}
		if(map.get("patName")!=null){
			patName=map.get("patName").toString();
		}
		if(map.get("mobileNo")!=null){
			mobileNo=map.get("mobileNo").toString();
		}
		if(map.get("deptId")!=null){
			deptId2=Integer.parseInt(map.get("deptId").toString());
		}
		if(map.get("doctorId")!=null){
			doctorId=Integer.parseInt(map.get("doctorId").toString());
		}
		if(map.get("phramacyDeptId")!=null){
			phramacyDeptId=Integer.parseInt(map.get("phramacyDeptId").toString());
		}
		Map<Integer,Object> doctorMap=new HashMap<Integer,Object>();
		if(map.get("doctorMap") != null){
			doctorMap= (Map<Integer,Object>)map.get("doctorMap");
		}
	%>

<script type="text/javascript">
function check(){
var SDate = document.report.<%= FROM_DATE%>.value;
var EDate = document.report.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	if(!message.equals("")){
%>
<h4><span><%=message %></span></h4>
<%} %> 

<form name="CurrentDispensing" method="post" action="">
<div class="titleBg">
<!-- <h2>Unserviced Dispensing List</h2> --> 
<h2>Dispensing Pending List</h2>

</div>
<div class="clear"></div>
<div class="Block" >  

<label>Department</label>
<select name="<%=FROM_WARD%>" id="<%=FROM_WARD%>"	validate="Department,metachar,no">
			<option value="0">Select</option>
 <%
			for (MasDepartment masDepartment :departmentListJsp ) {
				%>
				<%if(masDepartment.getId()==deptId2){ %>
				<option value="<%=masDepartment.getId() %>" selected="selected" ><%=masDepartment.getDepartmentName() %></option>
				<%}%>
				<option value="<%=masDepartment.getId() %>" ><%=masDepartment.getDepartmentName() %></option>
				<%
				}
			%>		
			</select> 
			
			
			<label >UHID </label> 
<input type="text"	name="<%=HIN_NO %>" id="hinNo" MAXLENGTH="16" tabindex=1 validate="Hin No,metachar,no" value="<%=hinNo%>"/>


<label >Patient Name </label> 
<input type="text"	name="<%=P_FIRST_NAME %>" id="pFirstName"  tabindex=1 validate="Patient Name,string,no" value="<%=patName%>"/>

<div class="clear" ></div>

<label > Token No </label> 
<input type="text"	name="<%=TOKEN_NO%>" id="tokenNo"  tabindex=1 validate="Patient Name,string,no" value="<%=tokenNo>0?tokenNo:""%>"/> 
<label> Mobile No. </label> 
<input type="text"	name="<%=MOBILE_NO%>"  id="mobile"  tabindex=1  validate="Mobile,contact,no" value="<%=mobileNo%>"/>

<label> Doctor </label> 
<select name="<%=DOCTOR_NAME%>" id="doctorName" validate="Doctor,string,no">
			<option value="0">Select</option>
 <%
			for (MasEmployee masEmployee :employeeListJsp ) {
				
				%>
				<%if(masEmployee.getId()==doctorId){ %>
				<option value="<%=masEmployee.getId() %>" selected="selected" ><%=masEmployee.getFirstName() %></option>
				<%}%>
				<option value="<%=masEmployee.getId() %>" ><%=masEmployee.getFirstName()%></option>
				<%
				}
			%>		
			</select>  
</div>
 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onClick="submitForm('CurrentDispensing','billing?method=showPharmacySalesViewJsp');"	accesskey="g" tabindex=1 />
<input type="button" name="openButton" value="Open Token Display"	class="buttonBig2" onclick="openTokenDisplay(<%=deptId%>)"/>
<input type="button" name="closeButton" value="Close Token Display" onclick="closeTokenDisplay()" class="buttonBig2" /> 
<input type="button" name="search" value="Direct Dispensing(Last Pres. Based)" class="buttonBig3" onClick="submitForm('CurrentDispensing','stores?method=directDispensing');"	accesskey="g" tabindex=1 />

<input type="button" name="search" value="Direct Dispensing(Paper Based)" class="buttonBig4" onClick="submitForm('CurrentDispensing','stores?method=dirDispLastPresBased');"	accesskey="g" tabindex=1 />

<input type="button" name="token display" value="Token Display" class="button" accesskey="g" onclick="tokenDisplay(<%=deptId%>)" tabindex=1 />

<input type="hidden" size="2" value="fgfg" name="noOfRecords"
	id="noOfRecords" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="test" class="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
</div>
<form name="admissionAcceptance" method="post" action="">
<script
       type="text/javascript">
       formFields = [
                       [0, "<%= HIN_ID%>", "id"],[1, "slno"], [2,"token"],[3,"hin"],[4,"uhin_id"], [5,"patName"], [6,"Department"],[7,"prescribed_by"],[8,"Date"]];
        statusTd = 7;
       </script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">       
</form>
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
       
       function openTokenDisplay(deptId)
	   	{
	   	 var url="/hms/hms/opd?method=showPopupTokenJsp&deptId="+deptId;
	   	 //newwindow=window.open(url,'Token_Number','_blank',"left=100,top=100,height=700,width=850,location=0,toolbar=0,menubar=0,status=no,scrollbars=no,resizable=no");
	   	 //newwindow=window.open(url,"","status=no,scrollbars=no,resizable=yes,height = 600, width = 800,fullscreen=yes");
	   	 newwindow=window.open(url,"","status=no,scrollbars=no,resizable=yes,"+'height=' + screen.height + ',width=' + screen.width+"+fullscreen=yes");
	   	 newwindow.moveTo(1024,0);
	   	}
       function tokenDisplay(deptId)
	   	{
	   	 var url="/hms/hms/opd?method=showPopupToken&deptId="+deptId;	   	 
	   	 newwindow=window.open(url,"","status=no,scrollbars=no,resizable=yes,"+'height=' + screen.height + ',width=' + screen.width+"+fullscreen=yes");
	   	 
	   	 newwindow.moveTo(1024,0);
	   	}

   	function closeTokenDisplay(){
   		if(false == newwindow.closed)
   		{
   			newwindow.close();
   		}
   		else
   		{
   		alert('Window already closed!');
   		}
   	}
   	
	callPendingList();
	function callPendingList(){
		  var fromWard=document.getElementById("fromWard").value;
		    var hinNo=document.getElementById("hinNo").value;
		    var pFirstName=document.getElementById("pFirstName").value;
			var tokenNo=document.getElementById("tokenNo").value;
		    var mobilNo=document.getElementById("mobile").value;
		    var doctorName=document.getElementById("doctorName").value;
	   // alert("tokenNo "+tokenNo+" pName "+pName+" hinNo "+hinNo);
	submitProtoAjaxWithDivName('CurrentDispensing','/hms/hms/billing?method=getPharmacyDispencingListRefresh&fromWard='+fromWard+'&hinNo='+hinNo+'&pFirstName='+pFirstName+'&tokenNo='+tokenNo+'&mobilNo='+mobilNo+'&doctorName='+doctorName,'test');
		setTimeout(callPendingList, 30000);
	}
               
       </script>

<div class="clear"></div>
<div class="paddingTop15"></div>

