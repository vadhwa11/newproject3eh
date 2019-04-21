
<%@page import="jkt.hms.masters.business.StoreReservationJphn"%>
<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.StoreReservationCampGroup"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasEmployee> jphnJphiList = new ArrayList<MasEmployee>();
	List<EmpScMapping> moList = new ArrayList<EmpScMapping>();
	List<EmpScMapping> phnList = new ArrayList<EmpScMapping>();
	List<StoreReservationCampGroup> campGroupList = new ArrayList<StoreReservationCampGroup>();
	List<StoreReservationJphn> jphnList = new ArrayList<StoreReservationJphn>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	int campGroupId = 0;
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("jphnJphiList") != null){
		jphnJphiList = (List)map.get("jphnJphiList");
	}
	if(map.get("moList") != null){
		moList = (List)map.get("moList");
	}
	if(map.get("phnList") != null){
		phnList = (List)map.get("phnList");
	}
	if(map.get("campGroupList") != null){
		campGroupList = (List)map.get("campGroupList");
	}
	if(map.get("jphnList") != null){
		jphnList = (List)map.get("jphnList");
	}
	if(map.get("campGroupId") != null){
		campGroupId = (Integer)map.get("campGroupId");
	}
	
	

	%>
	
<%if(!message.equals("")){%>
<h4><span><%=message %></span></h4>
<%}%> 
<div class="titleBg">
<h2>Camp Group</h2>
</div>
<div class="clear"></div>
<form name="campGroup" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label><span>*</span>Group Name</label>
 <input type="text" name="groupName" validate="Group Name,string,yes" value="" MAXLENGTH="45"  />
 
 <label><span>*</span>MO</label>
<select name="mo" id="moId" validate="MO,string,yes" >
<option value="">Select</option>
<%if(moList.size()>0){
	 for(EmpScMapping mo: moList){
	%>

<option value="<%=mo.getEmployee().getId()%>"><%=mo.getEmployee().getEmployeeName() %></option>
<%}} %>
</select>

<label><span>*</span>PHN</label>
<select name="phn" id="phnId" validate="PHN,string,yes" >
<option value="">Select</option>
<%if(phnList.size()>0){
	 for(EmpScMapping phn: phnList){
	%>

<option value="<%=phn.getEmployee().getId()%>"><%=phn.getEmployee().getEmployeeName() %></option>
<%}} %>


</select>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRowForEmployee();" />
 <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow()" />
<table id="employeeDetails">
<tr>
<th>Select</th>
<th>Employee</th>
</tr>
<%
					int k =1;
					
					%>
<tr>
<td><input type="checkbox" name="srNo<%=k %>" id="srNo" value=""></td>
<td><select name="employeeId<%=k %>" id="employeeId">
<option value="">Select</option>
<%if(jphnJphiList.size()>0){
	for(MasEmployee masEmployee :jphnJphiList){
	%>

<option value="<%=masEmployee.getId()%>"><%=masEmployee.getEmployeeName() %></option>
<%}} %>
</select></td>
</tr>
</table>
<input	type="hidden" name="hdbEmp" id="hdbEmp"	value="<%=k %>"  />



<input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('campGroup','pubHealth?method=submitCampGroup');" />
<input name="button"  type="button"	value="Reset" class="button"	onclick=""; />


<div class="clear"></div>
<script type="text/javascript">
var employeeArray =new Array();
</script>
<%  int j=0;

for(MasEmployee masEmployee:jphnJphiList){
%>
<script>
employeeArray[<%=j%>]= new Array();
employeeArray[<%=j%>][0] = "<%=masEmployee.getId()%>";
employeeArray[<%=j%>][1] = "<%=masEmployee.getEmployeeName()%>";

               </script>
<%j++;} %>
<script type="text/javascript">

function removeRow()
{
	var tbl = document.getElementById('employeeDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	     
  	for(i=1;i<=document.getElementsByName('SRNo').length;i++)
	{
		
  		//if (document.getElementsByName('srno')[i].checked == true)
		//{
		  	tbl.deleteRow(i+1);
		//}
	}
}
function addRowForEmployee(){
	  var tbl = document.getElementById('employeeDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdbEmp');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'checkbox';
	  e0.setAttribute("readonly", "readonly");
	  e0.name='srNo'+iteration;
	  //e0.value =iteration
	  e0.id='srNoId'+iteration;
	  e0.size='3'
	  e0.className = 'readOnly';
	 cellRight1.appendChild(e0);

    
    var cellRight2 = row.insertCell(1);
    var e1 = document.createElement('select');
    e1.name='employeeId'+ (iteration);
    e1.id='employeeId'+(iteration);
    e1.options[0] = new Option('Select', '0');
    for(var l = 0;l<employeeArray.length;l++){
            e1.options[l+1] = new Option(employeeArray[l][1],employeeArray[l][0]);
    }
    cellRight2.appendChild(e1);
		 
	 
	  
	}

</script>
</form>

<form name="itemGrid" method="post">
 
<% int currentPage=0;
int noOfPages=0;
if(null !=map.get("currentPage")){
	currentPage=(Integer)map.get("currentPage");
    noOfPages=(Integer)map.get("noOfPages");
}
if(campGroupList.size()>0){ %>
 
 <div class="Block">
 <table>
    <tr>
    	<th>Sl No.</th>
    	<th>Group Name</th>
    	<th>MO</th>
    	<th>PHN</th>
    </tr>

    <% 
	int  counter=0;
	for(StoreReservationCampGroup object:campGroupList){
        	
        counter++;
        String groupName = "-";
        String moName = "-";
        String phnName = "-";
        if(object.getGroupName()!=null){
        	groupName=object.getGroupName();
        }
        if(object.getMo()!=null){
        	if(object.getMo().getEmployeeName()!=null){
        		moName = object.getMo().getEmployeeName();
        	}
        }
        if(object.getPhn()!=null){
        	if(object.getPhn().getEmployeeName()!=null){
        		phnName = object.getPhn().getEmployeeName();
        	}
        }
    %>
  
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<tr onclick="submitForm('itemGrid', 'pubHealth?method=showCampGroupJsp&campGroupId=<%=(Integer)object.getId()%>')" style="cursor: pointer;">
		<td><%= counter%></td>
        <td><%= groupName%></td>
        <td><%= moName%></td>
        <td><%= phnName%></td>
	</tr>
		<% if(jphnList.size() > 0 && campGroupId == (Integer)object.getId()) { %>
			<tr>
    			<th>Sl No.</th>
    			<th>Employee Name</th>
    		</tr>

			<% int count=0;
			for(StoreReservationJphn emp:jphnList){
			count++; 
			String empName = "-";
			if(emp.getEmployee() != null) {
				empName = emp.getEmployee().getEmployeeName();
			}
			%>
    		<tr>
    			<td><%= count%></td>
    			<td><%= empName%></td>
    		</tr>
    	<% } %> 
    		<tr>
    			<th></th>
    			<th></th>
    		</tr>
    	<% } %>

	<%}%>
</table>
    
	<%if(currentPage !=1){%>
		<a href='/hms/hms/pubHealth?method=showCampGroupJsp&page=<%=currentPage-1%>'>Previous</a>
	<%}
	if(noOfPages>=1){%>
		<a href='/hms/hms/pubHealth?method=showCampGroupJsp&page=<%=currentPage%>'><%=currentPage%></a>
	<%}
	if(currentPage <noOfPages){%>
		<a href='/hms/hms/pubHealth?method=showCampGroupJsp&page=<%=currentPage+1%>'>Next</a>
	<%}%>
	<div class="Block">
		<input type="text" id="inPage" tabindex="2"	maxlength="4" style="width:30px;"/>
		<input type="button" value="Go" tabindex="2" onclick="searchParticularPage();"/> 
		<label> No of Pages :  <%=noOfPages%></label>
	</div>
	<%}
	else{%>
		<font size="4" color="red">No Record Found </font>
	<%}%>
	<div class="clear"></div>
    
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
function searchParticularPage(type){
	var curPage=document.getElementById("inPage").value;
	if(!curPage || isNaN(curPage)){
		curPage=1;
	}
	submitForm('itemGrid','/hms/hms/pubHealth?method=showCampGroupJsp&page='+curPage);
};
</script>