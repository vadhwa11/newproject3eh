<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * empaneled.jsp  
 * Purpose of the JSP -  This is for Empaneled.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 15th April,2009 
 * Revision Date:      
 * Revision By:  
 * @empaneled 1.4
--%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmpaneledHospital"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmpaneled"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchEmpaneledList = (ArrayList)map.get("searchEmpaneledList");
	
	
	List<MasHospital> masHospitalList = new ArrayList<MasHospital>();

if(map.get("masHospitalList") != null){
	masHospitalList = (List<MasHospital>)map.get("masHospitalList") ;
	}
	
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	districtList = (ArrayList)map.get("districtList");
	
	
	ArrayList gridDistrictList = (ArrayList)map.get("gridDistrictList");
	
	List<MasState> stateList = new ArrayList<MasState>();
	stateList = (ArrayList)map.get("stateList");
	
	List<MasDepartment> masDepartments = new ArrayList<MasDepartment>();
	masDepartments = (ArrayList)map.get("masDepartments");
	
	
	ArrayList gridStateList = (ArrayList)map.get("gridStateList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	 if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
}
%>

<script type="text/javascript">

var districtArrayOne = new Array();
		<%
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
								districtArrayOne[<%=counter1%>] = new Array();
									districtArrayOne[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArrayOne[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArrayOne[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
		</script>
<div class="titleBg">
<h2>Empaneled Master</h2>
</div>

<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Empaneled Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Empaneled Name</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 
<input type="hidden" name="colCode" value="empaneled_code">
<input type="hidden" name="colName" value="empaneled_name">
 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Empaneled Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'pharmacy?method=searchEmpaneled')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','pharmacy?method=searchEmpaneled','checkSearch')"	tabindex=1 />
<input type="hidden" name="Report" value="Generate Report " class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_apk_empaneled">
</form>
</div>
</div> 
<div class="clear"></div>
</div>
 
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<% 
  if(searchEmpaneledList.size()>0)
   {
   String strForCode = (String)map.get("empaneledCode");
   String strForCodeDescription = (String)map.get("empaneledName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> <h4> <a href="pharmacy?method=showEmpaneledJsp">Show All Records</a></h4>
<%
   }
   }
		 if(searchEmpaneledList.size()==0 && map.get("search") != null)
		 {
		%> <h4><a href="pharmacy?method=showEmpaneledJsp">Show All Records</a></h4>

<%
		 }
		%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],
     [3,"<%= CONTACT_PERSON %>"], 
	  [4,"<%= ADDRESS%>"],
	  [5,"<%= STATE_ID1%>"],
	  [6,"<%= DISTRICT_ID1%>"],
	  [7,"<%= PINCODE1%>"],
	  [8,"<%= MOBILE_NO1%>"],
	  [9,"<%= TIN_NO1%>"],
	  [10,"<%= LICENCE_NO1%>"],
	  [11,"<%= EMAIL_ID1%>"],
	  [12,"cpMobileNo"],
	  [13,"<%= CHANGED_BY %>"],
	  [14,"<%= CHANGED_DATE %>"],
	  [15,"<%= CHANGED_TIME %>"],
	  [16,"<%=STATUS%>"] ,
	  [17,"hospitalId"],
	  [18,"<%=LOGIN_NAME  %>"],
	  [19,"<%=PASSWORD %>"]
   	  [20,"departmentId"]	
	  ];
  statusTd = 16;
 </script></div>

<form name="empaneled" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasEmpaneled">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"	value="EmpaneledName"> 
<input type="hidden"	name="empaneled" value="Empaneled"> 
<input type="hidden"	name="<%=JSP_NAME %>" value="empaneled"> 
<input	type="hidden" name="pojoPropertyCode" value="EmpaneledCode">

<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Empaneled Code</label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" 	validate="Empaneled Code,string,yes" class="textbox_size20"	MAXLENGTH="8" tabindex=1/> 
<label><span>*</span> Empaneled Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" value=""	validate="Empaneled Name,string,yes" class="textbox_size20"	MAXLENGTH="30"  tabindex=1	onkeypress="return submitenter(this,event,'pharmacy?method=addEmpaneled')"/>
<script>
    	document.empaneled.<%=CODE%>.focus();
</script>

<label>
   Department</label> <select  id= "departmentId" name="departmentId" validate="Department,string,no"  tabindex=1>
	<option value="0">Select</option>
	<%for(MasDepartment masDepartment : masDepartments){%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%}%>
</select>
 <div class="clear"></div>
<label> Contact Person </label> 
<input type="text" name="<%= CONTACT_PERSON %>" value="" validate="Contact Person,alphanumeric,no" MAXLENGTH="30" tabindex=1 />

<label>Address</label>
 <input type="text" name="<%=ADDRESS%>" value="" validate="Address,metachar,no" MAXLENGTH="30" tabindex=1 /> 
 
  <label>
   State</label> <select  id= "stateId" name="<%=STATE_ID1%>" validate="State,string,no" onchange="populateDistrictOne(this.value,'empaneled')" tabindex=1>
	<option value="0">Select</option>
	<%for(MasState masState : stateList){
						%>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%}%>
</select>

 <div class="clear"></div>
  <label>City/District</label> <select id="dId" name="<%=DISTRICT_ID1%>" validate="District,string,no" tabindex=1 onblur="checkCity();">
	<option value="0">Select</option>
	<%for(MasDistrict masDistrict : districtList){
				%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%	}%>
</select> 
 
 <label>Pin Code No.</label> 
 <input type="text" name="<%= PINCODE1 %>" validate="Pin Code No ,num,no" value="" MAXLENGTH="8" tabindex=1 />
 
 <label>Mobile No.</label> <input type="text" name="<%= MOBILE_NO1 %>" 	validate="Mobile No ,int,no" value="" MAXLENGTH="10" tabindex=1 />
 
 <div class="clear"></div>
 <label>Tin No.</label> <input type="text" name="<%= TIN_NO1 %>" validate="Tin No ,int,no" value="" MAXLENGTH="10" tabindex=1 /> 
 
 <label>License No.</label> 
 <input type="text" name="<%= LICENCE_NO1 %>" validate="Licence No ,string,no" value="" MAXLENGTH="10" tabindex=1 />
	
<label>Email Id</label> 
<input type="text" name="<%= EMAIL_ID1 %>"	validate="Email Id ,email,no" value="" MAXLENGTH="30"  tabindex=1 />

<div class="clear"></div>

<label>CP Mobile No.</label>
<input type="text" name="cpMobileNo" validate="CP Mobile No ,int,no" value="" MAXLENGTH="10" tabindex=1 />
	
	
	<label>Standard Availability</label> 

<select name="hospitalId"	id="hospitalId" tabindex=1 multiple="multiple" class="multiple1" size="5" style="width:360px;" >
	<%
		for (MasHospital masHospital : masHospitalList) {
	%>
	<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>
	<%
		}
	%> 	
</select>
<div class="clear"></div>
<label>Login Name<span>*</span></label> 
<input id="loginNameId" type="text" name="<%= LOGIN_NAME%>" value="" 	validate="Login Name,string,yes" MAXLENGTH="12" tabindex=1 /> 
				
<label>Password<span>*</span>  </label> 
<input id="pwd" name=<%=PASSWORD%> type="password" maxlength="15" tabindex="1" validate="Password,metachar,yes" />
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('empaneled','pharmacy?method=addEmpaneled');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button"	onClick="submitForm('empaneled','pharmacy?method=editEmpaneled')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('empaneled','pharmacy?method=deleteEmpaneled&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> 
<input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Empaneled Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Empaneled Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Contact Person"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=CONTACT_PERSON %>";

data_header[3] = new Array;
data_header[3][0] = "Address"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%=ADDRESS%>"


data_header[4] = new Array;
data_header[4][0] = "State"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%=STATE_ID1%>"

data_header[5] = new Array;
data_header[5][0] = "City"
data_header[5][1] = "data";
data_header[5][2] = 0;
data_header[5][3] = "<%=DISTRICT_ID1%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=PINCODE1%>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=MOBILE_NO1%>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=TIN_NO1%>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=LICENCE_NO1%>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=EMAIL_ID1%>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "cpMobileNo"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=CHANGED_BY %>"

data_header[13] = new Array;
data_header[13][0] = "Admin"
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%=CHANGED_DATE %>"

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "<%=CHANGED_TIME %>"

data_header[15] = new Array;
data_header[15][0] = "Status"
data_header[15][1] = "data";
data_header[15][2] = "15%";
data_header[15][3] = "<%=STATUS %>"


	data_header[16] = new Array;
data_header[16][0] = "Institute"
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "hospitalId";


data_header[17] = new Array;
data_header[17][0] = "Login Name"
data_header[17][1] = "data";
data_header[17][2] = "25%";
data_header[17][3] = "<%= LOGIN_NAME%>"

data_header[18] = new Array;
data_header[18][0] = "Password"
data_header[18][1] = "hide";
data_header[18][2] = "25%";
data_header[18][3] = "<%= PASSWORD %>"

data_header[19] = new Array;
data_header[19][0] = "Department"
data_header[19][1] = "data";
data_header[19][2] = "25%";
data_header[19][3] = "departmentId"
	
data_arr = new Array();
<%
Iterator itr=searchEmpaneledList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasEmpaneled  masEmpaneled = (MasEmpaneled)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masEmpaneled.getId()%>
data_arr[<%= counter%>][1] = "<%=masEmpaneled.getEmpaneledCode()%>"
data_arr[<%= counter%>][2] = "<%= masEmpaneled.getEmpaneledName()%>"
data_arr[<%= counter%>][3] = "<%= masEmpaneled.getContactPerson()%>"
data_arr[<%= counter%>][4] = "<%= masEmpaneled.getAddress()%>"



	<%
	System.out.println("gridStateList------------"+gridStateList.size());
			Iterator itrGridStateList1=gridStateList.iterator();
			 while(itrGridStateList1.hasNext())
	            {
				 try
				 {
	             MasState stateGrid1 = (MasState)itrGridStateList1.next(); 
				 if(masEmpaneled.getState()!=null)
				 {
					 if(masEmpaneled.getState().getId().equals(stateGrid1.getId()) && stateGrid1.getStatus().equalsIgnoreCase("Y"))
					 {
		%>
						data_arr[<%= counter%>][5] = "<%=stateGrid1.getStateName()%>"
		<%
					  }
				 }
	             else if(masEmpaneled.getState()!=null && stateGrid1.getId()!=null && stateGrid1.getStatus()!=null && masEmpaneled.getState().getId().equals(stateGrid1.getId()) && stateGrid1.getStatus().equalsIgnoreCase("N"))
	             {
		%>
					data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=stateGrid1.getStateName()%>";
		<%
				 }
	            }
				catch(Exception e){e.printStackTrace();}}%>
				
				<%	Iterator itrGridDistrictList1=gridDistrictList.iterator();
				 while(itrGridDistrictList1.hasNext())
		            {try{
		             MasDistrict  districtGrid1 = (MasDistrict)itrGridDistrictList1.next(); 
		             if(masEmpaneled.getCity()!=null){
			             if(masEmpaneled.getCity().getId().equals(districtGrid1.getId()) && districtGrid1.getStatus().equals("Y")){
				             %>
							data_arr[<%= counter%>][6] = "<%=districtGrid1.getDistrictName()%>"
					<%		}
			             }else if(masEmpaneled.getCity().getId().equals(districtGrid1.getId()) && districtGrid1.getStatus().equals("N")){%>
						data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=districtGrid1.getDistrictName()%>";
						
					<%}
		            }catch(Exception e){}}%>
		            
		<%if(masEmpaneled.getPinCode() != null){%>
		data_arr[<%= counter%>][7] = "<%= masEmpaneled.getPinCode()%>"
		<%}else{%>
		data_arr[<%= counter%>][7] = ""
		<%}%>
		
		<%if(masEmpaneled.getMobileno() != null){%>
		data_arr[<%= counter%>][8] = "<%= masEmpaneled.getMobileno()%>"
		<%}else{%>
		data_arr[<%= counter%>][8] = ""
		<%}%>
		
		<%if(masEmpaneled.getTinNo()!= null){%>
		data_arr[<%= counter%>][9] = "<%=masEmpaneled.getTinNo()%>"
		<%}else{%>
		data_arr[<%= counter%>][9] = ""
		<%}%>
		
		<%if(masEmpaneled.getLicenceNo() != null){%>
		data_arr[<%= counter%>][10] = "<%=masEmpaneled.getLicenceNo()%>"
		<%}else{%>
		data_arr[<%= counter%>][10] = ""
		<%}%>
		
		<%if(masEmpaneled.getEmailId() != null){%>
		data_arr[<%= counter%>][11] = "<%=masEmpaneled.getEmailId()%>"
		<%}else{%>
		data_arr[<%= counter%>][11] = ""
		<%}%>
		
		<%if(masEmpaneled.getCpMobileNo() != null){%>
		data_arr[<%= counter%>][12] = "<%= masEmpaneled.getCpMobileNo()%>"
		<%}else{%>
		data_arr[<%= counter%>][12] = ""
		<%}%>

data_arr[<%= counter%>][13] = "<%= masEmpaneled.getLastChgBy()!=null?(masEmpaneled.getLastChgBy().getId()!=null?masEmpaneled.getLastChgBy().getId():"0" ):"0"%>"
	 
data_arr[<%= counter%>][14] = "<%=masEmpaneled.getLastChgDate()!=null?HMSUtil.convertDateToStringWithoutTime(masEmpaneled.getLastChgDate()):date%>"
data_arr[<%= counter%>][15] = "<%= masEmpaneled.getLastChgTime() %>"

<% if(masEmpaneled.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][16] = "Active"
<%}else{%>
data_arr[<%= counter%>][16] = "InActive"
<%}%>

<% 
Set<MasEmpaneledHospital> masEmpaneledHospitalSet = new HashSet<MasEmpaneledHospital>();
if(masEmpaneled.getMasEmpaneledHospitals() != null){
	masEmpaneledHospitalSet  =masEmpaneled.getMasEmpaneledHospitals();
}
String tempValue = "";
if(masEmpaneledHospitalSet.size()>0){
	for(MasEmpaneledHospital masEmpaneledHospital :masEmpaneledHospitalSet){
		if(!tempValue.equals("")){
			tempValue += ","+masEmpaneledHospital.getHospital().getId();
	}else{
		tempValue += masEmpaneledHospital.getHospital().getId();
	}
}
%>


data_arr[<%= counter%>][17] = "<%=tempValue%>"
	 
	data_arr[<%= counter%>][18] = "<%= masEmpaneled.getLoginName()!=null?masEmpaneled.getLoginName():""%>"
	data_arr[<%= counter%>][19] = "<%= masEmpaneled.getPassword()!=null?masEmpaneled.getPassword():""%>"
	data_arr[<%= counter%>][20] = "<%= masEmpaneled.getDepartment()!=null?masEmpaneled.getDepartment().getDepartmentName():""%>"
	<%}


		     counter++;
}
%>
 
formName = "empaneled"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>

<script>
function checkCity()
{
	if(document.getElementById("dId").value!=0)
	{
	if(document.getElementById("stateId").value==0)
		{
		alert("Please Select State");
		document.getElementById("dId").value=0;
		return false;
		}
	}
	return true;
}
function populateDistrictOne(val,formName){
	obj = eval('document.'+formName+'.<%=DISTRICT_ID1%>');
	obj.length = 1;
	for(i=0;i<districtArrayOne.length;i++){
		if(districtArrayOne[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=districtArrayOne[i][1];
			obj.options[obj.length-1].text=districtArrayOne[i][2];
		}
	}
}
</script>
