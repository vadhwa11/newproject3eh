<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


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
		}
		
		if(map.get("employeeList") != null){
			employeeListJsp= (List<MasEmployee>)map.get("employeeList");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String message = "";
		if (map.get("visitList") != null) {
			message = (String) map.get("message");
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
<form name="UnservicedDispensing" method="post" action="">
<div class="titleBg">
<h2>Unserviced Dispensing  List</h2> 
<!-- <h2> Dispensing Pending List</h2> -->
</div>
<div class="clear"></div>
<div class="Block" >
<label > From Date</label> 
<input type="text" name="<%= FROM_DATE%>" value="<%=date %>" class="date" MAXLENGTH="30" readonly="readonly" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=FROM_DATE%>',UnservicedDispensing.<%=FROM_DATE%>,true);" />
<label > To Date</label> 
<input type="text"	name="<%= TO_DATE%>" value="<%=date %>" class="date" MAXLENGTH="30"	readonly="readonly" validate="toDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=FROM_DATE%>',document.UnservicedDispensing.<%=TO_DATE%>,true);" />

<label>Department</label> 
<select name="<%=FROM_WARD%>"	>
			<option value="0">Select</option>
 <%
			for (MasDepartment masDepartment :departmentListJsp ) {
				%>
				
				<option value="<%=masDepartment.getId() %>" ><%=masDepartment.getDepartmentName() %></option>
				<%
				}
			%>		
			</select> 
<div class="clear" ></div>

<label > Token No </label> 
<input type="text"	name="<%=TOKEN_NO%>" id="tokenNo" value="" 	maxlength="30" tabindex=1 validate="tokenNo,int,no"/>

<label >UHID </label> 
<input type="text"	name="<%=HIN_NO %>" id="hinNo" value=""   MAXLENGTH="16" tabindex=1 validate="hinnNo,metachar,no"/>

<label >Patient Name </label> 
<input type="text"	name="<%=P_FIRST_NAME %>" id="pFirstName" value="" validate="pFirstName,string,no" MAXLENGTH="128" tabindex=1 />

<div class="clear" ></div>

<label> Mobile No. </label> 
<input type="text"	name="<%=MOBILE %>"  id="mobile" value="" 	validate="Mobile,contact,no"
			MAXLENGTH="12" tabindex=1 />


<label> Doctor </label> 
<select name="<%=DOCTOR_NAME%>" id="doctorName" validate="doctorName,string,no">
			<option value="0">Select</option>
 <%
			for (MasEmployee masEmployee :employeeListJsp ) {
				
				%>
				
				<option value="<%=masEmployee.getId() %>" ><%=masEmployee.getFirstName()%></option>
				<%
				}
			%>		
			</select>  
</div>
 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onClick="submitForm('UnservicedDispensing','stores?method=showUnservicedDispensingJsp');"	accesskey="g" tabindex=1 />
<input type="button" class="buttonBig2" value="Open Token Display"
	onclick="" align="right" /> 
<input type="button" class="buttonBig2" value="Close Token Display"
	align="left" onclick="" /> 
<input type="hidden" size="2" value="fgfg" name="noOfRecords"
	id="noOfRecords" validate="noOfRecords,int,no"/>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="admissionAcceptance" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<script
       type="text/javascript">
       formFields = [
                       [0, "<%= HIN_ID%>", "id"],[1, "slno"], [2,"token"],[3,"hin"],[4,"uhin_id"], [5,"patName"], [6,"Department"],[7,"prescribed_by"],[8,"Date"]];
        statusTd = 7;
       </script>
</div>

<script type="text/javascript" language="javascript">
       data_header = new Array();
       
       data_header[0] = new Array;
       data_header[0][0] = "Sl No."
       data_header[0][1] = "data";
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
       data_header[2][2] = "15%";
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
       
     
       data_arr = new Array();
        <%
           int  counter=0;
               if (visitListJsp != null && visitListJsp.size()> 0) {
                       int loopIndex=1;                 
                for(Object[] visitList : visitListJsp){ 
       %>
                       data_arr[<%= counter%>] = new Array();
                       data_arr[<%= counter%>][0] = "<%= counter+1%>"
                       data_arr[<%= counter%>][1] = "<%=counter+1%>"
    				   data_arr[<%= counter%>][2] = "<%=visitList[7]%>"
                       data_arr[<%= counter%>][3] = "<%=visitList[0]%>"
                       data_arr[<%= counter%>][4] = "<%=visitList[1]%>"
                       data_arr[<%= counter%>][5] ="<%=visitList[3]%>"
                       <%
                       String deptName="-";
                       String empName="-";
                       if(((MasDepartment)visitList[4])!=null && !"".equals(((MasDepartment)visitList[4]).getDepartmentName())){
                    	   deptName=((MasDepartment)visitList[4]).getDepartmentName();
                       }
                       if(((MasEmployee)visitList[5])!=null && !"".equals(((MasEmployee)visitList[5]).getEmployeeName())){
                    	   empName=((MasEmployee)visitList[5]).getEmployeeName();
                       }
                       
                       
                       
                       %> 
                       data_arr[<%= counter%>][6] = "<%=deptName%>"
                       data_arr[<%= counter%>][7] = "<%=empName%>" 
                    	   data_arr[<%= counter%>][8] = "<%=visitList[6]%>"
                       <%counter++;
                       loopIndex++;
            
               
       }}
               %> 
               formName = "UnservicedDispensing"
       
      
       
       start = 0;
       if(data_arr.length < rowsPerPage){
               end = data_arr.length;
               
       }
       else{
               end = rowsPerPage;
       
       }
       
       makeTable(start,end);
       
       
               
       </script>
        <div class="clear"></div>
<div class="paddingTop15"></div>
