
<%@page import="jkt.hms.masters.business.StoreReservationCamp"%>
<%@page import="jkt.hms.masters.business.StoreReservationCampGroup"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
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
	List<StoreReservationCampGroup> campGroupList = new ArrayList<StoreReservationCampGroup>();
	List<StoreReservationCamp> campList = new ArrayList<StoreReservationCamp>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("campGroupList") != null){
		campGroupList = (List)map.get("campGroupList");
	}
	if(map.get("campList") != null){
		campList = (List)map.get("campList");
	}
	

	%>
	
<%if(!message.equals("")){%>
<h4><span><%=message %></span></h4>
<%}%> 
<div class="titleBg">
<h2>Camp</h2>
</div>
<div class="clear"></div>
<form name="camp" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label><span>*</span>Group</label>
 <select name="group" id="groupId" validate="MO,string,yes" >
<option value="">Select</option>
<%if(campGroupList.size()>0){
	 for(StoreReservationCampGroup storeReservationCampGroup: campGroupList){
	%>
<option value="<%=storeReservationCampGroup.getId()%>"><%=storeReservationCampGroup.getGroupName() %></option>
<%}} %>
</select>

</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRowForCamp();" />
 <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow()" />
<table id="campDetails">
<tr>
<th>Select</th>
<th>Camp</th>
<th>Locality</th>
<th>Date</th>
</tr>
<%
					int k =1;
					
					%>
<tr>
<td><input type="checkbox" name="srNo<%=k %>" id="srNo" value=""></td>
<td><input	type="text" name="camp<%=k %>" id="campId"	value=""  /></td>
<td><input	type="text" name="locality<%=k %>" id="localityId"	value=""  /></td>
<td><input	type="text" name="date<%=k %>" id="dateId"	value=""  class="date" readonly="readonly"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date+k%>',document.camp.date<%=k%>,event)" />
</td>
		
</tr>
</table>
<input	type="hidden" name="hdbCamp" id="hdbCamp"	value="<%=k %>"  />



<input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('camp','pubHealth?method=submitCamp');" />
<input name="button"  type="button"	value="Reset" class="button"	onclick=""; />


<div class="clear"></div>

<script type="text/javascript">

function removeRow()
{
	var tbl = document.getElementById('campDetails');
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
function addRowForCamp(){
	  var tbl = document.getElementById('campDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdbCamp');
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
    var e1 = document.createElement('input');
  	e1.type = 'text';
    e1.name='camp'+ (iteration);
    e1.id='campId';
    cellRight2.appendChild(e1);
    
    var cellRight3 = row.insertCell(2);
    var e2 = document.createElement('input');
  	e2.type = 'text';
    e2.name='locality'+ (iteration);
    e2.id='localityId';
    cellRight3.appendChild(e2);
	
     var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.size='20';
	  e3.name='date'+iteration;
	  e3.id='date'+iteration;
	  e3.setAttribute("readonly", "readonly");
	  cellRight4.appendChild(e3);
	  var eImg = document.createElement('img');
		eImg.src = '/hms/jsp/images/cal.gif';
		eImg.className = 'calender';
		eImg.style.display ='inline';
		eImg.onclick = function(event){
						setdate('',document.getElementById('date'+iteration),event) };
		cellRight4.appendChild(eImg);
	 
	  
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
if(campList.size()>0){ %>
 
 <div class="Block">
 <table>
    <tr>
    	<th>Sl No.</th>
    	<th>Camp Name</th>
    	<th>Locality</th>
    	<th>Date</th>
    	<th>Group Name</th>
    </tr>

    <% 
	int  counter=0;
	for(StoreReservationCamp object:campList){
        	
        counter++;
        String campName = "-";
        String locality = "-";
        Date dates = null;
        String groupName = "-";
        if(object.getCampName()!=null){
        	campName=object.getCampName();
        }
        if(object.getLocality()!=null){
        	locality = object.getLocality();
        }
        if(object.getDate()!=null){
        		dates = object.getDate();
        }
        if(object.getGroup()!=null){
        	groupName=object.getGroup().getGroupName();
        }
    %>
  
	<tr>
		<td><%= counter%></td>
        <td><%= campName%></td>
        <td><%= locality%></td>
        <td><%= dates%></td>
        <td><%= groupName%></td>
    <% } %>

</table>
    
	<%if(currentPage !=1){%>
		<a href='/hms/hms/pubHealth?method=showCampJsp&page=<%=currentPage-1%>'>Previous</a>
	<%}
	if(noOfPages>=1){%>
		<a href='/hms/hms/pubHealth?method=showCampJsp&page=<%=currentPage%>'><%=currentPage%></a>
	<%}
	if(currentPage <noOfPages){%>
		<a href='/hms/hms/pubHealth?method=showCampJsp&page=<%=currentPage+1%>'>Next</a>
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
	submitForm('itemGrid','/hms/hms/pubHealth?method=showCampJsp&page='+curPage);
};
</script>