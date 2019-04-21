<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.Tbltimesheet"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hrms.masters.business.TbltimesheetAprl"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script>
var rowId;
<%Calendar calendar=Calendar.getInstance();
 String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
 String curDate=String.valueOf(calendar.get(Calendar.DATE));
 int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
		


</script>

<%
	Map map = new HashMap();
	List tbltimesheetList = new ArrayList();
	List<Tbltimesheet> fwdTbltimesheetList = new ArrayList<Tbltimesheet>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	  List<TbltimesheetAprl> tbltimesheetAprlList = new ArrayList<TbltimesheetAprl>();
	  
	  if(map.get("fwdTbltimesheetList")!=null)
		{
		  fwdTbltimesheetList = (List<Tbltimesheet>)map.get("fwdTbltimesheetList");
			
		}
	  if(map.get("tbltimesheetAprlList")!=null)
		{
		  tbltimesheetAprlList = (List)map.get("tbltimesheetAprlList");
			
		}
	if(map.get("tbltimesheetList")!=null)
	{
		tbltimesheetList = (List)map.get("tbltimesheetList");
		
	}
	MasEmployee emp = new MasEmployee();
	if(map.get("emp")!= null)
	{
		emp =(MasEmployee) map.get("emp");
	}
	%>
<script type="text/javascript">

function selectAll(field,value)
{
	val = document.getElementById("tbSheetSize").value;
	comment = document.getElementsByName('appCom'+0).value;
	//alert(comment);
	for(i=0;i<val;i++)
	{
		//alert("chkAction"+i);
		theInputs = document.getElementsByName('chkAction'+i);
		//alert(document.getElementsByName('chkAction'+i).length);
		for(y=0; y<theInputs.length; y++)
		{
			if(theInputs[y].value===value)
			{
				if(field.checked)
				{
					   	theInputs[y].checked='checked';
					   	//alert('appCom'+y);
					   	document.getElementsByName('appCom'+y).value=comment;
		   		}
		   		if(!field.checked)
				{
					   	theInputs[y].checked='';
		   		}
			}
		}
	}
}

</script>
<form name="approvTimeSheet" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="titleBg">
<h2>Approve Time Sheet</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>


<% 
	if((tbltimesheetList!=null && tbltimesheetList.size() > 0) || (fwdTbltimesheetList !=null && fwdTbltimesheetList.size()>0))
	{
		
%> <label><span>*</span> From Date</label> <input name="<%=FROM_DATE%>"
	id="<%=FROM_DATE%>" type="text" readonly validate='From Date,date,yes'
	value="" class="date" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" id="calFromDate"
	onclick="javascript:setdate('',document.approvTimeSheet.<%=FROM_DATE%>,'event')" />
<label><span>*</span> To Date</label> <input type="text"
	name="<%=TO_DATE%>" id="<%=TO_DATE%>" readonly
	validate='To Date,date,yes' value="" class="date" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	id="calToDate"
	onclick="javascript:setdate('',document.approvTimeSheet.<%=TO_DATE%>,'event')" />

<input type="button" value="Approve All" class="button"
	onclick="submitForm('approvTimeSheet','/hms/hrms/timeSheet?method=approveAll')">

<div class="Block">
<div class="clear"></div>
</div>
<div id="pageNavPosition"></div>
<table id="">
	<tr>
		<th>Resource Name</th>
		<th>Date</th>
		<th>Hrs Worked</th>
		<th>Status</th>
	</tr>
	<tbody id="tableData">
		<%	int i=0;
		
			for( int ilop = 0; ilop<tbltimesheetList.size();ilop++){
				
				Tbltimesheet obj = (Tbltimesheet)tbltimesheetList.get(ilop);
				int count =0;
				if((( obj).getEmpId().getLineManager().getId())==(emp.getId())){
					count++;
				if(i%2==0)
				{
		%>
		<tr class="odd"
			onclick="getTimeSheet('<%=( obj).getEmpId().getFirstName()+" "+( obj).getEmpId().getLastName() %>','<%=( obj).getEmpId().getDepartment().getDepartmentName() %>',<%=( obj).getEmpId().getId() %> , '<%= HMSUtil.convertDateToStringWithoutTime(obj.getEntryDate())%>')">
			<%
		  		}
		  		else
		  		{
		%>
			<tr class="even"
				onclick="getTimeSheet('<%=( obj).getEmpId().getFirstName()+" "+( obj).getEmpId().getLastName() %>','<%=( obj).getEmpId().getDepartment().getDepartmentName() %>',<%=( obj).getEmpId().getId() %> , '<%= HMSUtil.convertDateToStringWithoutTime(obj.getEntryDate())%>')">
				<%
		  		}
				
		%>
				<td><%=( obj).getEmpId().getFirstName()+" "+( obj).getEmpId().getLastName() %></td>

				<td><%=HMSUtil.convertDateToStringWithoutTime(obj.getEntryDate()) %></td>

				<td><%=obj.getHrsWorked() %></td>

				<td><%= obj.getStatus() %></td>
			</tr>

			<%	i++;
			}
			}
			
		   
	int j=0;

for( Tbltimesheet obj: fwdTbltimesheetList){
	
	for(TbltimesheetAprl apvObj : tbltimesheetAprlList)
	{
		if((obj.getId()).equals(apvObj.getTmshtId()) && (apvObj.getApprover().equals(emp.getId())))
		{
		if(j%2==0)
	{
%>
			<tr class="odd"
				onclick="getTimeSheet(<%=obj.getEmpId().getId() %> , '<%= HMSUtil.convertDateToStringWithoutTime(obj.getEntryDate())%>')">
				<%
		}
		else
		{
%>
				<tr class="even"
					onclick="getTimeSheet(<%=obj.getEmpId().getId() %> , '<%= HMSUtil.convertDateToStringWithoutTime(obj.getEntryDate())%>')">
					<%
		}
	
%>
					<td><%=obj.getEmpId().getFirstName()+" "+obj.getEmpId().getLastName() %></td>

					<td><%=HMSUtil.convertDateToStringWithoutTime((Date)obj.getEntryDate()) %></td>

					<td><%=obj.getHrsWorked() %></td>

					<td><%=obj.getStatus() %></td>
				</tr>

				<%	j++;
			}
		}
	}
}else
		{  %>
				<h4>No Record Found</h4>
				<%	}	%>
			
	</tbody>
</table>

<div class="paddingTop15"></div>
<div id="processDiv" style="display: none;"><input type="text"
	id="dateSelected" /><label style="width: 200px;" id="selectedEmpName"></label><label
	style="width: 350px;" id="selectedEmpDept"></label> <input
	type="button" value="Process" align="right" class="button"
	onclick="processTS(<%= tbltimesheetList.size() %>);">

<div class="division"></div>

<div id="timeSheetDiv"></div>
<div class="clear"></div>
<div class="paddingTop40"></div></div></div>
</form>

<script>
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
</script>

<script type="text/javascript">
function getTimeSheet(empName,empDept,eid,dat)
{
document.getElementById("processDiv").style.display="block";
document.getElementById("dateSelected").value=dat;
document.getElementById("selectedEmpName").innerHTML=empName;
document.getElementById("selectedEmpDept").innerHTML=empDept;

 var orGroupId ="";
   var x=document.getElementById("timeSheetDiv")
	
	 //----------------------AJAX PART------------Start------
  
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("timeSheetDiv").innerHTML='<font id="error">Loading...</font>'
      document.getElementById("timeSheetDiv").innerHTML=""
    }else
      if(xmlHttp.readyState==4){
         document.getElementById("timeSheetDiv").innerHTML = xmlHttp.responseText;
      }
    }
  //  url ="/hms/hrms/timeSheet?method=loadTimeSheet&rowId="+eid+"&date="+dat;
 //   alert(url);
    xmlHttp.open("GET","/hms/hrms/timeSheet?method=loadTimeSheet&rowId="+eid+"&date="+dat+"&"+csrfTokenName+"="+csrfTokenValue,true);
  
    xmlHttp.send(null)
    }


</script>

<script>
var rowid;
function setRowId(val)
{
//alert("l");
rowid= val;
} 

function processTS(len)
{
	document.getElementById("<%=FROM_DATE%>").setAttribute("validate","");
	document.getElementById("<%=TO_DATE%>").setAttribute("validate","");
	var i=0;
	url ="/hms/hrms/timeSheet?method=setTimeSheetStatus&len="+len;
	submitForm('approvTimeSheet',url);	  
	document.getElementById("<%=FROM_DATE%>").setAttribute("validate","From Date,string,yes");
	document.getElementById("<%=TO_DATE%>").setAttribute("validate","To Date,string,yes");
	
}
</script>


