<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * rank.jsp  
 * Purpose of the JSP -  This is for Rank.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.8
--%>
<%@page import="jkt.hms.masters.business.HrCommitteeDetails"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasRank"%>
 <%@page import="jkt.hms.masters.business.HrCommitteeHeader"%> 
 
 <script type="text/javascript" language="javascript"src="/erp/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
 
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>


<script language="javascript">

var $j = jQuery.noConflict();
</script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	 
 	List<HrCommitteeDetails> lglBoardMemberList = new ArrayList<HrCommitteeDetails>();
 	List<HrCommitteeHeader> commteeList = new ArrayList<HrCommitteeHeader>();
	lglBoardMemberList = (ArrayList)map.get("lglBoardMemberList");
	commteeList = (ArrayList)map.get("commiteeList");
	ArrayList searchLglBoardMemberList = (ArrayList)map.get("searchLglBoardMemberList"); 
	ArrayList gridDesignationList = (ArrayList)map.get("gridDesignationList");
	List<MasRank> designationList = new ArrayList<MasRank>();
	designationList = (ArrayList)map.get("designationList");

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	} 
 	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><%=message%></h4>
		<%   
		  }
%>
<div class="titleBg">
<h2>Sub Committee Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<label>Name</label>
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" validate="Name,string,no"   MAXLENGTH="8"   />
<input type="hidden" name="colName" value="name">
<input type="hidden" name="type" value="SCM">
<input type="hidden" name="<%=SELECTED_RADIO  %>"  id="radio1"  value="2"  checked="checked" />

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','training?method=showSubCommitteeJsp','checkSearch')" tabindex=1  />
<%--- Report Button   --%>  
<!-- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','masters?method=generateReportForGeneralLegalMasters');" accesskey="g" tabindex=1/> -->
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_SubCommittee">

</form>

<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" >
<div id="searchtable" ></div>
	 <% 
  if(searchLglBoardMemberList.size()>0)
   {
   String strForCodeDescription = (String)map.get("nameSubCommittee");
   if(strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> 
  <br/>
  
   <h4> <a href="training?method=showSubCommitteeJsp">Show All Records</a></h4>
	<%
			}
		 }
	 if(searchLglBoardMemberList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="training?method=showSubCommitteeJsp">Show All Records</a></h4>

	 <%
     }
	%>  
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"nameMember"],  [2,"address"], [3,"designation"], [4,"remarks"], [5,"<%=CHANGED_BY%>"], [6,"<%=CHANGED_DATE%>"],[7,"<%=CHANGED_TIME%>"],[8,"<%=STATUS%>"] 
			,[9,"<%="committeeId"%>"],[10,"memberRadio"],[11,"otherMember"],[12,"memberRadio"]];
	 statusTd = 8;
	</script>
	</div>
	
  <form name="subCommittee" method="post" action="">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  <input type="hidden" name="<%= POJO_NAME %>" value="LglBoardMember">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value ="NameBoard">
  <input type="hidden" name="title" value ="SubCommittee">
  <input type="hidden" name="<%=JSP_NAME %>" value ="lgl_subCommittee">

<div class="Clear"></div>	

 	<label>Committee <span>*</span> </label>
		<select name="committeeId" id="committeeId" validate="Committee,string,yes" tabindex=1>
			<option value="">Select</option>
			  <% 
				for (HrCommitteeHeader  d : commteeList){
				%>
		    
			  <option value="<%=d.getId ()%>"><%=d.getCommitteeName()%></option>
			  		  
			  <%}%>
			</select>

<label>Employee </label>
<input type="radio" class="inputRadiobutton" name="memberRadio"  id="empRadio1"  value="employee"  checked  tabindex="1" onchange="displaySList('employee');"/>

<label>Other Members</label>
<input type="radio" class="inputRadiobutton" name="memberRadio" id="memberRadio" value="other"  tabindex="1" onchange="displaySList('Other');"/>
<div class="Clear"></div>
	  	<label > Name<span>*</span> </label>
       <%-- <input type="text" name="<%= SEARCH_NAME %>" value="" validate="Name,metachar,yes"  MAXLENGTH="32" tabindex=1 > --%>
			<%-- <script>
				document.subCommittee.<%=CODE%>.focus();
			</script>  --%> 
			 
			<div id="employeeDiv" style="display: inline"> 
			<input type="text"  size="50" value="" id="nameMember"  name="nameMember"  tabindex="1" onblur="fillMemberDetails(this.value)"/>
		
   <div id="ac2update1" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		function eventCallback(element, entry){
			var empRadio ='';
		   if(document.getElementById('empRadio1').checked){
			   empRadio = document.getElementById('empRadio1').value;
			} 
					return entry + "&employeeId=" + empRadio;
				}
		  new Ajax.Autocompleter('nameMember','ac2update1','/hms/hrms/training?method=getMemberListForName',{parameters:'requiredField=nameMember',callback: eventCallback});
		</script>
			
			</div>
			
			<div id="memberDiv" style="display: none">
			 <input type="text"  size="50" id="otherMember"  name="otherMember"  tabindex="1"></input>
			</div>
			
		<label > Address </label>
		<textarea rows="" cols="" class="textareaMediua" name="address" id="address" maxlength="80"  onkeyup="return ismaxlength(this)" tabindex=1></textarea>
		<input type="hidden" name="hosId" id="hosId" validate="Designation,string,no" tabindex=1>
			
			<label > Designation <span>*</span> </label>
		<input type="text" name="designation" id="designation" validate="Designation,string,yes" tabindex=1>
		<input type="hidden" name="designationId" id="designationId" validate="Designation,string,no" tabindex=1>
			<input type="hidden" name="emp_id" id="emp_id" validate="Designation,string,no" tabindex=1>
				<div class="Clear"></div>
			
		<!-- <label > Date Of Appointment<span>*</span> </label>
		<input type="text" name="dateOfAppointment" id="dateOfAppointment" tabindex="1" value=""  class="calDate"   placeholder="DD/MM/YYYY"   size="7" validate="Date Of Appointment,date,no"  onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'dateOfAppointment');" />
			
		<label > Brief Background </label>
		<textarea rows="" cols="" name="briefBackground" maxlength="80"  onkeyup="return ismaxlength(this)" tabindex=1></textarea>
	
		<label > No. of Share Held </label>
		<input type="text" name="noOfShareHeld" id="noOfShareHeld"  value="" maxlength="4" validate="No of Share Held,int,no"/>
		
				<div class="Clear"></div> -->
		<label> Remarks</label>
		<textarea rows="" cols="" class="textareaMediua" maxlength="100" name="remarks"  onkeyup="chkLength(this,100);"></textarea>	
<div class="Clear"></div>
<div id="edited"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('subCommittee','training?method=addSubCommittee');" accesskey="a" tabindex=1/>
<input type="button" name="edit" id="editbutton" style="display: none" value="Update" class="button" onClick="submitForm('subCommittee','training?method=editSubCommittee');" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" style="display: none" value="Activate" class="button" onClick="submitForm('subCommittee','training?method=deleteSubCommittee&flag='+this.value)" accesskey="d" tabindex=1/>		
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="submitFormForButton('subCommittee','training?method=showSubCommitteeJsp')" accesskey="r"/>	
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
</div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label >Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label >Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />		   			
   </div>	
   </form>
<script type="text/javascript">
data_header = new Array();


data_header[0] = new Array;
data_header[0][0] = "Name"
data_header[0][1] = "data";
data_header[0][2] = "30%";
data_header[0][3] = "nameMember";

data_header[1] = new Array;
data_header[1][0] = "Address"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "address";

data_header[2] = new Array;
data_header[2][0] = "designation"
data_header[2][1] = "hide";
data_header[2][2] = "30%";
data_header[2][3] = "designationId";

data_header[3] = new Array;
data_header[3][0] = "Remarks"
data_header[3][1] = "hide";
data_header[3][2] = "35%";
data_header[3][3] = "remarks";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] =  "<%=CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] ="<%=CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] =  "<%=CHANGED_TIME %>"

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%="STATUS" %>";

data_header[8] = new Array;
data_header[8][0] = "Committee"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%="committeeId" %>";


data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%="memberRadio" %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%="otherMember" %>";


data_header[11] = new Array;
data_header[11][0] = "Member Type"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%="memberRadio" %>";

data_arr = new Array();

<%
	if(searchLglBoardMemberList.size() > 0){
Iterator itr=searchLglBoardMemberList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrCommitteeDetails  lgl = (HrCommitteeDetails)itr.next(); 
  %>            

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=lgl.getId()%>"
data_arr[<%= counter%>][1] = "<%= lgl.getName()%>"
	data_arr[<%= counter%>][11] = "<%= lgl.getName()%>"
data_arr[<%= counter%>][2] =  "<%=lgl.getAddress()!=null?lgl.getAddress():""%>"
		
	 <% if(lgl.getCommitteeMemberType().equalsIgnoreCase("employee")){ %> 
<% if(lgl.getDesignation() != null ){%>
data_arr[<%= counter%>][3] =  "<%=lgl.getDesignation().getRankName()%>"
<%}else{%>
data_arr[<%= counter%>][3] = "";
<%}}else if(lgl.getCommitteeMemberType().equalsIgnoreCase("other")){%>
<% if(lgl.getDesignationName() != null ){%>
data_arr[<%= counter%>][3] =  "<%=lgl.getDesignationName()%>"
<%}else{%>
data_arr[<%= counter%>][3] = "";
<%}}%>

data_arr[<%= counter%>][4] = "<%=lgl.getRemarks()!=null?lgl.getRemarks():"0"%>"

data_arr[<%= counter%>][5] = "<%= lgl.getLastChgBy()!=null?(lgl.getLastChgBy().getId()!=null?lgl.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][6] = "<%= lgl.getLastChgDate()!=null?HMSUtil.convertDateToStringWithoutTime(lgl.getLastChgDate()):""%>"
data_arr[<%= counter%>][7] = "<%= lgl.getLastChgTime() %>"

<% if(lgl.getCommittee() != null){ %>
data_arr[<%= counter%>][9] = "<%=lgl.getCommittee().getCommitteeName()%>";
<%}else{%>
data_arr[<%= counter%>][9] = "";
<%}%>

<% if(lgl.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active";
<%}else{%>
data_arr[<%= counter%>]8] = "InActive";
<%}%>

<% if(lgl.getCommitteeMemberType().equalsIgnoreCase("employee")){ %>
data_arr[<%= counter%>][10] = '<input type="radio" class=\\"radioCheck" name="memberRadio" value="employee" id="empRadio" checked  />';

<%}else{%>
data_arr[<%= counter%>][10] = '<input type="radio" class="radioCheck" name="memberRadio" value="other" id="empRadio" checked  />';
<%}%>


data_arr[<%= counter%>][12] = '<%=lgl.getCommitteeMemberType()%>';
 
<%
		     counter++;
}}
%>
 
formName = "subCommittee"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	 
</script>	

<script type="text/javascript">
function displaySList(val){
	//alert(val);

	if(val!="")
	{
	
	if(val=="employee")
	{
		document.getElementById('employeeDiv').style.display = 'inline';
		document.getElementById('memberDiv').style.display = 'none';
				
	}
	if(val=="Other")
	{
		document.getElementById('memberDiv').style.display = 'inline';
		document.getElementById('employeeDiv').style.display = 'none';
				
	}
} 
}
function fillMemberDetails(val)
{
	var abc = document.getElementById('empRadio1').value
	 //alert(abc);
	if(abc == 'employee'){
	if(val!=''){
		var xmlHttp;
		try {
		  // Firefox, Opera 8.0+, Safari
		  xmlHttp=new XMLHttpRequest();
		}catch (e){
		  // Internet Explorer
		  try{
		    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		  }catch (e){
		  	alert(e)
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
		      if(xmlHttp.readyState==4){
		      
		      	obj = document.getElementById('designationId');
				obj.length = 1;
		      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		      	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	    var item = items.childNodes[loop];
			   	   var idMember = item.getElementsByTagName("idMember")[0];	
			   	    var nameMember  = item.getElementsByTagName("nameMember")[0];
			        var designation  = item.getElementsByTagName("designation")[0];
			        var hosid = item.getElementsByTagName("hos")[0];	
			        var hosName = item.getElementsByTagName("hosName")[0];	
			    	if(designation.childNodes[0]!=undefined){
			          	for(innerLoop = 0;innerLoop <designation.childNodes.length;innerLoop++)
			        	{
			        		var dr = designation.childNodes[innerLoop];
				        	var dId  = dr.getElementsByTagName("designationId")[0];
				        	var dName  = dr.getElementsByTagName("dName")[0];
				           	document.getElementById('emp_id').value = idMember.childNodes[0].nodeValue
				           	document.getElementById('hosId').value = hosid.childNodes[0].nodeValue
				        	document.getElementById('address').value = hosName.childNodes[0].nodeValue
				        	//obj.length++;
							//obj.options[obj.length-1].value=dId.childNodes[0].nodeValue;
							document.getElementById('designation').value=dName.childNodes[0].nodeValue;
				           	document.getElementById('designationId').value=dId.childNodes[0].nodeValue;
				        	
			        	}
						}
		      	}
		
		      }
		    }
		  
	        var url='/hms/hrms/training?method=fillMemberForName&nameMember='+val;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
		     
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		}else{
			document.getElementById('nameMember'+inc).value='';
		}
}
}
</script>
	  