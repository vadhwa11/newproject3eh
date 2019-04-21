<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * manufacturer.jsp  
 * Purpose of the JSP -  This is for Manufacturer.
 * @author  Dipali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.14
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasState"%>
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
	ArrayList searchManufacturerList = (ArrayList)map.get("searchManufacturerList");
	
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	districtList = (ArrayList)map.get("districtList");
	
	
//	ArrayList gridDistrictList = (ArrayList)map.get("gridDistrictList");
	
	List<MasState> stateList = new ArrayList<MasState>();
	stateList = (ArrayList)map.get("stateList");
	
	
//	ArrayList gridStateList = (ArrayList)map.get("gridStateList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	  }
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %>
<script type="text/javascript">

var districtArrayOne = new Array();
var districtArrayTwo = new Array();
var districtArrayThree = new Array();
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
		
				<script type="text/javascript">
		<%
			int counter2 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
								districtArrayThree[<%=counter2%>] = new Array();
								districtArrayThree[<%=counter2%>][0]=<%=masState.getId()%>;
								districtArrayThree[<%=counter2%>][1] = <%=masDistrict.getId()%>;									
								districtArrayThree[<%=counter2%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter2++;
						}
					}
				}
			}
			
		%>
		</script>
		
		<script type="text/javascript">
		<%
			int counter3 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
								districtArrayTwo[<%=counter3%>] = new Array();
								districtArrayTwo[<%=counter3%>][0]=<%=masState.getId()%>;
								districtArrayTwo[<%=counter3%>][1] = <%=masDistrict.getId()%>;									
								districtArrayTwo[<%=counter3%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter3++;
						}
					}
				}
			}
			
		%>
		</script>
<div class="titleBg">
<h2>Manufacturer Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Manufacturer Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" tabindex=1 class="radiobutMargin" /> 
<label>Manufacturer Name</label> 
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" tabindex=1 class="radiobutMargin" /> 
<input	type="hidden" name="colCode" value="manufacturer_code">
<input	type="hidden" name="colName" value="manufacturer_name">
<input type="text" id="searchField" name="<%=SEARCH_FIELD%>" value="" validate="Manufacturer,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'pharmacy?method=searchManufacturer')" />
<input type="submit" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchManufacturer','checkSearch')" tabindex=1 /> 
<input type="button"	name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_manufacturer_list">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">	
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<% 
  if(searchManufacturerList.size()>0)
   {
   String strForCode = (String)map.get("manufacturerCode");
   String strForCodeDescription = (String)map.get("manufacturerName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
	   
 %> <h4><a href="pharmacy?method=showManufacturerJsp">Show All Records</a></h4> <%
   }
   }
 if(searchManufacturerList.size()==0 && map.get("search") != null)
 {
%> <h4><a href="pharmacy?method=showManufacturerJsp">Show All Records</a></h4> <%
  }
	%> <script type="text/javascript"> 
 formFields = [
 
				  [0, "<%= COMMON_ID%>", "id"], 
				  [1,"<%= CODE%>"], 
				  [2,"<%= SEARCH_NAME %>"],
				  [3,"<%= CONTACT_PERSON %>"], 
				  [4,"<%= CF_DISTRIBUTOR_NAME1%>"],
				  [5,"<%= CF_DISTRIBUTOR_ADDRESS1%>"],
				  [6,"<%= STATE_ID1%>"],
				  [7,"<%= DISTRICT_ID1%>"],
				  [8,"<%= PINCODE1%>"],
				  [9,"<%= MOBILE_NO1%>"],
				  [10,"<%= TIN_NO1%>"],
				  [11,"<%= LICENCE_NO1%>"],
				  [12,"<%= EMAIL_ID1%>"],
				  [13,"<%= URL1%>"],
				  [14,"<%= CF_DISTRIBUTOR_NAME2 %>"],
				  [15,"<%= CF_DISTRIBUTOR_ADDRESS2%>"],
				  [16,"<%= STATE_ID2%>"],
				  [17,"<%= DISTRICT_ID2%>"],
				  [18,"<%= PINCODE2%>"],
				  [19,"<%= MOBILE_NO2%>"],
				  [20,"<%= TIN_NO2%>"],
				  [21,"<%= LICENCE_NO2%>"],
				  [22,"<%= EMAIL_ID2%>"],
				  [23,"<%= URL2%>"],
				  [24,"<%= CF_DISTRIBUTOR_NAME3 %>"],
				  [25,"<%= CF_DISTRIBUTOR_ADDRESS3%>"],
				  [26,"<%= STATE_ID3%>"],
				  [27,"<%= DISTRICT_ID3%>"],
				  [28,"<%= PINCODE3%>"],
				  [29,"<%= MOBILE_NO3%>"],
				  [30,"<%= TIN_NO3%>"],
				  [31,"<%= LICENCE_NO3%>"],
				  [32,"<%= EMAIL_ID3%>"],
				  [33,"<%= URL3%>"],
				  [34,"<%= CHANGED_BY %>"],
				  [35,"<%= CHANGED_DATE %>"],
				  [36,"<%= CHANGED_TIME %>"],
				  [37,"<%=STATUS%>"]];
				  
				  
  statusTd = 37;
 
 </script>
 </div>
<div class="clear"></div>
<form name="manufacturer" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasManufacturer">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ManufacturerName">
<input type="hidden" name="<%=JSP_NAME %>" value="manufacturer">
<input type="hidden" name="pojoPropertyCode" value="ManufacturerCode">

<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Manufacturer Code</label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Manufacturer Code,alphanumeric,yes" MAXLENGTH="8" tabindex=1 />
<label><span>*</span> Manufacturer Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Manufacturer Name,alphanumeric,yes" MAXLENGTH="30" tabindex=1 />
			
<label> Contact Person </label> 
<input type="text" name="<%= CONTACT_PERSON %>" value="" validate="Contact Person,alphanumeric,no" MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>
<div class="paddingTop5"></div>

<label style="font-size:11px;">C&F/Local Distributor Name</label>
 <input type="text" name="<%=CF_DISTRIBUTOR_NAME1%>" value="" validate="C & F/Local Distributor Name ,name,no" MAXLENGTH="30" tabindex=1 /> 
 
<label>C&F/Local  Address</label>
 <input type="text" name="<%=CF_DISTRIBUTOR_ADDRESS1%>" value="" validate="C & F/Local Distributor Address1 ,string,no" MAXLENGTH="30" tabindex=1 />
 
  <label>
   State</label> <select name="<%=STATE_ID1%>" validate="State,string,no" onchange="populateDistrictOne(this.value,'manufacturer')" tabindex=1>
	<option value="0">Select</option>
	<%for(MasState masState : stateList){
						%>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%}%>
</select>
 <div class="clear"></div>
 
 <label>City/District</label> <select name="<%=DISTRICT_ID1%>" validate="District,string,no" tabindex=1>
	<option value="0">Select</option>
	<%for(MasDistrict masDistrict : districtList){
				%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%	}%>
</select> 
 
 <label>Pin Code No.</label> 
 <input type="text" name="<%= PINCODE1 %>" validate="Pin Code No ,num,no" value="" MAXLENGTH="8" tabindex=1 />
 
 <label>Mobile No.</label> <input type="text" name="<%= MOBILE_NO1 %>"
	validate="Mobile No ,string,no" value="" MAXLENGTH="10" tabindex=1 />
 <div class="clear"></div>
  <label>Tin No.</label> <input type="text" name="<%= TIN_NO1 %>" validate="Tin No ,int,no" value="" MAXLENGTH="10" tabindex=1 /> 
 
 <label>License No.</label> 
 <input type="text" name="<%= LICENCE_NO1 %>" validate="Licence No ,string,no" value="" MAXLENGTH="10" tabindex=1 />
	
	<label>Email Id</label> <input type="text" name="<%= EMAIL_ID1 %>"
	validate="Email Id ,email,no" value="" MAXLENGTH="30"  tabindex=1 />
	<div class="clear"></div>
	<label>URL</label> <input
	type="text" name="<%= URL1 %>" value="" MAXLENGTH="30"  tabindex=1 />

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>

 <label style="font-size:11px;">C&F/Local Distributor Name</label>
 <input type="text" name="<%=CF_DISTRIBUTOR_NAME2%>" value="" validate="C & F/Local Distributor Name ,name,no" MAXLENGTH="30" tabindex=1 /> 
 
 <label>C&F/Local  Address</label>
  <input type="text" name="<%=CF_DISTRIBUTOR_ADDRESS2%>" value="" validate="C & F/Local Distributor Address2 ,string,no" MAXLENGTH="30" tabindex=1 />
  
 <label> State</label> <select name="<%=STATE_ID2%>" validate="State,string,no" onchange="populateDistrictTwo(this.value,'manufacturer')" tabindex=1>
	<option value="0">Select</option>
	<%for(MasState masState : stateList){
						%>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%}%>
</select>

 <div class="clear"></div>
 
 <label>City/District</label> <select name="<%=DISTRICT_ID2%>" validate="District,string,no" tabindex=1>
	<option value="0">Select</option>
	<%for(MasDistrict masDistrict : districtList){
				%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%	}%>
</select> 
 
 <label>Pin Code No.</label> 
 <input type="text" name="<%= PINCODE2 %>" validate="Pin Code No ,num,no" value="" MAXLENGTH="8" tabindex=1 />
 
 <label>Mobile No.</label> 
 <input type="text" name="<%= MOBILE_NO2 %>"	validate="Mobile No ,integer,no" value="" MAXLENGTH="10" tabindex=1 />
	
 <div class="clear"></div>
  <label>Tin No.</label> <input type="text" name="<%= TIN_NO2 %>" validate="Tin No2 ,int,no" value="" MAXLENGTH="10" tabindex=1 /> 
 
 <label>License No.</label>
 <input type="text" name="<%= LICENCE_NO2 %>"	validate="Licence No ,string,no" value="" MAXLENGTH="10" tabindex=1 />
	
<label>Email Id</label>
<input type="text" name="<%= EMAIL_ID2 %>"	validate="Email Id ,email,no" value="" MAXLENGTH="30"  tabindex=1 />

	<div class="clear"></div>
	
		<label>URL</label> 
		<input	type="text" name="<%= URL2 %>" value="" MAXLENGTH="30"  tabindex=1 />
<%-- 
<label>Address1</label>
 <input type="text" name="<%= ADDRESS1 %>" value="" validate="Address1 ,string,no" MAXLENGTH="30" tabindex=1 />
  <label>Address2</label>
   <input type="text" name="<%= ADDRESS2 %>" value="" MAXLENGTH="30" tabindex=1 />
   <label>Phone No.</label> <input type="text" name="<%= PHONE_NO %>"
	validate="Phone No ,phone,no" value="" MAXLENGTH="10" tabindex=1 />
<div class="clear"></div>
<label> Fax No.</label> <input type="text" name="<%= FAX_NO %>" value=""
	MAXLENGTH="30" tabindex=1>
    --%>
 
<div class="clear"></div>
<div class="paddingTop5"></div>
 
 <label style="font-size:11px;">C&F/Local Distributor Name</label>
 <input type="text" name="<%=CF_DISTRIBUTOR_NAME3%>" value="" validate="C & F/Local Distributor Name ,name,no" MAXLENGTH="30" tabindex=1 /> 
 
 <label>C&F/Local Address</label>
  <input type="text" name="<%=CF_DISTRIBUTOR_ADDRESS3%>" value="" validate="C & F/Local Distributor Address2 ,string,no" MAXLENGTH="30" tabindex=1 />
  
 <label> State</label> 
 <select name="<%=STATE_ID3%>" validate="State,string,no" onchange="populateDistrictThree(this.value,'manufacturer')" tabindex=1>
	<option value="0">Select</option>
	<%for(MasState masState : stateList){
						%>
	<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
	<%}%>
</select>

 <div class="clear"></div>
 <label>City/District</label>
 <select name="<%=DISTRICT_ID3%>" validate="District,string,no" tabindex=1>
	<option value="0">Select</option>
	<%for(MasDistrict masDistrict : districtList){
				%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
	<%	}%>
</select> 
 
 <label>Pin Code No.</label> 
 <input type="text" name="<%= PINCODE3 %>" validate="Pin Code No ,num,no" value="" MAXLENGTH="8" tabindex=1 />
 
 <label>Mobile No.</label> <input type="text" name="<%= MOBILE_NO3 %>"
	validate="Mobile No ,integer,no" value="" MAXLENGTH="10" tabindex=1 />
 <div class="clear"></div>
  <label>Tin No.</label> <input type="text" name="<%= TIN_NO3 %>" validate="Tin No3 ,int,no" value="" MAXLENGTH="10" tabindex=1 /> 
 
 <label>License No.</label> <input type="text" name="<%= LICENCE_NO3 %>"
	validate="Licence No ,string,no" value="" MAXLENGTH="10" tabindex=1 />
	
	<label>Email Id</label> <input type="text" name="<%= EMAIL_ID3 %>"
	validate="Email Id ,email,no" value="" MAXLENGTH="30"  tabindex=1 />
	<div class="clear"></div>
	<label>URL</label> <input
	type="text" name="<%= URL3 %>" value="" MAXLENGTH="30"  tabindex=1 />
<%-- 
<label>Address1</label>
 <input type="text" name="<%= ADDRESS1 %>" value="" validate="Address1 ,string,no" MAXLENGTH="30" tabindex=1 />
  <label>Address2</label>
   <input type="text" name="<%= ADDRESS2 %>" value="" MAXLENGTH="30" tabindex=1 />
   <label>Phone No.</label> <input type="text" name="<%= PHONE_NO %>"
	validate="Phone No ,phone,no" value="" MAXLENGTH="10" tabindex=1 />
<div class="clear"></div>
<label> Fax No.</label> <input type="text" name="<%= FAX_NO %>" value=""
	MAXLENGTH="30" tabindex=1>
    --%>
 <div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('manufacturer','pharmacy?method=addManufacturer');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none" class="button"
	onClick="submitForm('manufacturer','pharmacy?method=editManufacturer')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button" style="display: none"
	onClick="submitForm('manufacturer','pharmacy?method=deleteManufacturer&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	value="Reset" class="buttonHighlight" accesskey="r"
	onclick="clearRecords(this)" tabindex=1 /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
</div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Manufacturer Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Manufacturer Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%=CONTACT_PERSON %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CF_DISTRIBUTOR_NAME1%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CF_DISTRIBUTOR_ADDRESS1%>"

data_header[5] = new Array;
data_header[5][0] = "State"
data_header[5][1] = "data";
data_header[5][2] = 0;
data_header[5][3] = "<%=STATE_ID1%>"

data_header[6] = new Array;
data_header[6][0] = "District"
data_header[6][1] = "data";
data_header[6][2] = 0;
data_header[6][3] = "<%=DISTRICT_ID1%>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=PINCODE1%>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=MOBILE_NO1%>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=TIN_NO1%>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=LICENCE_NO1%>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=EMAIL_ID1%>"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=URL1 %>"

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%=CF_DISTRIBUTOR_NAME2%>"

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%=CF_DISTRIBUTOR_ADDRESS2%>"


data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "<%=STATE_ID2%>"


data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = 0;
data_header[16][3] = "<%=DISTRICT_ID2%>"


data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = 0;
data_header[17][3] = "<%=PINCODE2%>"


data_header[18] = new Array;
data_header[18][0] = "Admin"
data_header[18][1] = "hide";
data_header[18][2] = 0;
data_header[18][3] = "<%=MOBILE_NO2%>"

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = 0;
data_header[19][3] = "<%=TIN_NO2%>"

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = 0;
data_header[20][3] = "<%=LICENCE_NO2 %>"

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = "15%";
data_header[21][3] = "<%=EMAIL_ID2 %>";

data_header[22] = new Array;
data_header[22][0] = "Status"
data_header[22][1] = "hide";
data_header[22][2] = "15%";
data_header[22][3] = "<%=URL2 %>";

data_header[23] = new Array;
data_header[23][0] = "Status"
data_header[23][1] = "hide";
data_header[23][2] = "15%";
data_header[23][3] = "<%=CF_DISTRIBUTOR_NAME3%>";

data_header[24] = new Array;
data_header[24][0] = "Status"
data_header[24][1] = "hide";
data_header[24][2] = "15%";
data_header[24][3] = "<%=CF_DISTRIBUTOR_ADDRESS3 %>";

data_header[25] = new Array;
data_header[25][0] = "Status"
data_header[25][1] = "hide";
data_header[25][2] = "15%";
data_header[25][3] = "<%=STATE_ID3 %>";

data_header[26] = new Array;
data_header[26][0] = "Status"
data_header[26][1] = "hide";
data_header[26][2] = "15%";
data_header[26][3] = "<%=DISTRICT_ID3 %>";

data_header[27] = new Array;
data_header[27][0] = "Status"
data_header[27][1] = "hide";
data_header[27][2] = "15%";
data_header[27][3] = "<%=PINCODE3 %>";

data_header[28] = new Array;
data_header[28][0] = "Status"
data_header[28][1] = "hide";
data_header[28][2] = "15%";
data_header[28][3] = "<%=MOBILE_NO3 %>";

data_header[29] = new Array;
data_header[29][0] = "Status"
data_header[29][1] = "hide";
data_header[29][2] = "15%";
data_header[29][3] = "<%=TIN_NO3 %>";

data_header[30] = new Array;
data_header[30][0] = "Status"
data_header[30][1] = "hide";
data_header[30][2] = "15%";
data_header[30][3] = "<%=LICENCE_NO3 %>";

data_header[31] = new Array;
data_header[31][0] = "Status"
data_header[31][1] = "hide";
data_header[31][2] = "15%";
data_header[31][3] = "<%=EMAIL_ID3 %>";

data_header[32] = new Array;
data_header[32][0] = "Status"
data_header[32][1] = "hide";
data_header[32][2] = "15%";
data_header[32][3] = "<%=URL3 %>";

data_header[33] = new Array;
data_header[33][0] = "Admin"
data_header[33][1] = "hide";
data_header[33][2] = 0;
data_header[33][3] = "<%=CHANGED_BY%>"

data_header[34] = new Array;
data_header[34][0] = ""
data_header[34][1] = "hide";
data_header[34][2] = 0;
data_header[34][3] = "<%= CHANGED_DATE%>"

data_header[35] = new Array;
data_header[35][0] = ""
data_header[35][1] = "hide";
data_header[35][2] = 0;
data_header[35][3] = "<%= CHANGED_TIME %>"

data_header[36] = new Array;
data_header[36][0] = "Status"
data_header[36][1] = "data";
data_header[36][2] = "15%";
data_header[36][3] = "<%=STATUS %>";



data_arr = new Array();
<%
Iterator itr=searchManufacturerList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasManufacturer  masManufacturer = (MasManufacturer)itr.next();       
String manufacturerCode="";
if(masManufacturer.getManufacturerCode()!=null){
	manufacturerCode=masManufacturer.getManufacturerCode();
}
String manufacturerName="";
if(masManufacturer.getManufacturerName()!=null){
	manufacturerName=masManufacturer.getManufacturerName();
}

String contactPerson="";
if(masManufacturer.getContactPerson()!=null){
	contactPerson=masManufacturer.getContactPerson();
}
String cfLocalDistributorName="";
if(masManufacturer.getCfLocalDistributorName()!=null){
	cfLocalDistributorName=masManufacturer.getCfLocalDistributorName();
}

String cfLocalDistributorAddress1="";
if(masManufacturer.getCfLocalDistributorAddress1()!=null){
	cfLocalDistributorAddress1=masManufacturer.getCfLocalDistributorAddress1();
}
String cfLocalDistributorAddress2="";
if(masManufacturer.getCfLocalDistributorAddress2()!=null){
	cfLocalDistributorAddress2=masManufacturer.getCfLocalDistributorAddress2();
}


String address1="";
if(masManufacturer.getAddress1()!=null){
	address1=masManufacturer.getAddress1();
}
String address2="";
if(masManufacturer.getAddress2()!=null){
	address2=masManufacturer.getAddress2();
}


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masManufacturer.getId()%>
data_arr[<%= counter%>][1] = "<%=manufacturerCode%>"
data_arr[<%= counter%>][2] = "<%=manufacturerName%>"
data_arr[<%= counter%>][3] = "<%= contactPerson%>"
data_arr[<%= counter%>][4] = "<%= cfLocalDistributorName%>"
data_arr[<%= counter%>][5] = "<%= cfLocalDistributorAddress1%>"

<%
		Iterator itrGridStateList1=stateList.iterator();
		 while(itrGridStateList1.hasNext())
            {
			 try
			 {
             MasState stateGrid1 = (MasState)itrGridStateList1.next(); 
			 if(masManufacturer.getState()!=null)
			 {
				 if(masManufacturer.getState().getId().equals(stateGrid1.getId()) && stateGrid1.getStatus().equalsIgnoreCase("Y"))
				 {
	%>
					data_arr[<%= counter%>][6] = "<%=stateGrid1.getStateName()%>"
	<%
				  }
			 }
             else if(masManufacturer.getState()!=null && stateGrid1.getId()!=null && stateGrid1.getStatus()!=null && masManufacturer.getState().getId().equals(stateGrid1.getId()) && stateGrid1.getStatus().equalsIgnoreCase("N"))
             {
	%>
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=stateGrid1.getStateName()%>";
	<%
			 }
            }
			catch(Exception e){e.printStackTrace();}}%>
			
			<%	Iterator itrGridDistrictList1=districtList.iterator();
			 while(itrGridDistrictList1.hasNext())
	            {try{
	             MasDistrict  districtGrid1 = (MasDistrict)itrGridDistrictList1.next(); 
	             if(masManufacturer.getCity()!=null){
		             if(masManufacturer.getCity().getId().equals(districtGrid1.getId()) && districtGrid1.getStatus().equalsIgnoreCase("Y")){
			             %>
						data_arr[<%= counter%>][7] = "<%=districtGrid1.getDistrictName()%>"
				<%		}
		             }else if(masManufacturer.getCity().getId().equals(districtGrid1.getId()) && districtGrid1.getStatus().equalsIgnoreCase("N")){%>
					data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=districtGrid1.getDistrictName()%>";
					
				<%}
	            }catch(Exception e){}}%>
	            
	<%if(masManufacturer.getPinCode() != null){%>
	data_arr[<%= counter%>][8] = "<%= masManufacturer.getPinCode()%>"
	<%}else{%>
	data_arr[<%= counter%>][8] = ""
	<%}%>
	
	<%if(masManufacturer.getMobileno() != null){%>
	data_arr[<%= counter%>][9] = "<%= masManufacturer.getMobileno()%>"
	<%}else{%>
	data_arr[<%= counter%>][9] = ""
	<%}%>
	
	<%if(masManufacturer.getTinNo1()!= null){%>
	data_arr[<%= counter%>][10] = "<%=masManufacturer.getTinNo1()%>"
	<%}else{%>
	data_arr[<%= counter%>][10] = ""
	<%}%>
	
	<%if(masManufacturer.getLicenceNo() != null){%>
	data_arr[<%= counter%>][11] = "<%=masManufacturer.getLicenceNo()%>"
	<%}else{%>
	data_arr[<%= counter%>][11] = ""
	<%}%>
	
	<%if(masManufacturer.getEmailId() != null){%>
	data_arr[<%= counter%>][12] = "<%=masManufacturer.getEmailId()%>"
	<%}else{%>
	data_arr[<%= counter%>][12] = ""
	<%}%>
	
	<%if(masManufacturer.getUrl() != null){%>
	data_arr[<%= counter%>][13] = "<%=masManufacturer.getUrl()%>"
	<%}else{%>
	data_arr[<%= counter%>][13] = ""
	<%}%>
	
	<%if(masManufacturer.getCfLocalDistributorName2() != null){%>
	data_arr[<%= counter%>][14] = "<%=masManufacturer.getCfLocalDistributorName2()%>"
	<%}else{%>
	data_arr[<%= counter%>][14] = ""
	<%}%>
	
	<%if(masManufacturer.getCfLocalDistributorAddress2() != null){%>
	data_arr[<%= counter%>][15] = "<%=masManufacturer.getCfLocalDistributorAddress2() %>"
	<%}else{%>
	data_arr[<%= counter%>][15] = ""
	<%}%>
	
	<%
	Iterator itrGridStateList2=stateList.iterator();
	 while(itrGridStateList2.hasNext())
        {
		 try
		 {
         MasState stateGrid2 = (MasState)itrGridStateList2.next(); 
		 if(masManufacturer.getState2()!=null)
		 {
			 if(masManufacturer.getState2().getId().equals(stateGrid2.getId()) && stateGrid2.getStatus().equalsIgnoreCase("Y"))
			 {
%>
				data_arr[<%= counter%>][16] = "<%=stateGrid2.getStateName()%>"
<%
			  }
		 }
         else if(masManufacturer.getState2()!=null && stateGrid2.getId()!=null && stateGrid2.getStatus()!=null && masManufacturer.getState2().getId().equals(stateGrid2.getId()) && stateGrid2.getStatus().equalsIgnoreCase("N"))
         {
%>
			data_arr[<%= counter%>][16] = "<font id='error'>*</font>Parent InActivated--<%=stateGrid2.getStateName()%>";
<%
		 }
        }
		catch(Exception e){e.printStackTrace();}}%>
		
		<%	Iterator itrGridDistrictList2=districtList.iterator();
		 while(itrGridDistrictList2.hasNext())
           {try{
            MasDistrict  districtGrid2 = (MasDistrict)itrGridDistrictList2.next(); 
            if(masManufacturer.getDistrict2()!=null){
	             if(masManufacturer.getDistrict2().getId().equals(districtGrid2.getId()) && districtGrid2.getStatus().equalsIgnoreCase("Y")){
		             %>
					data_arr[<%= counter%>][18] = "<%=districtGrid2.getDistrictName()%>"
			<%		}
	             }else if(masManufacturer.getDistrict2().getId().equals(districtGrid2.getId()) && districtGrid2.getStatus().equalsIgnoreCase("N")){%>
				data_arr[<%= counter%>][18] = "<font id='error'>*</font>Parent InActivated--<%=districtGrid2.getDistrictName()%>";
				
			<%}
           }catch(Exception e){}}%>
           
            
            
            <%if(masManufacturer.getPinCode2()!= null){%>
        	data_arr[<%= counter%>][18] = "<%= masManufacturer.getPinCode2()%>"
        	<%}else{%>
        	data_arr[<%= counter%>][18] = ""
        	<%}%>
        	
        	<%if(masManufacturer.getMobileno2() != null){%>
        	data_arr[<%= counter%>][19] = "<%= masManufacturer.getMobileno2()%>"
        	<%}else{%>
        	data_arr[<%= counter%>][19] = ""
        	<%}%>
        	
        	<%if(masManufacturer.getTinNo2()!= null){%>
        	data_arr[<%= counter%>][20] = "<%=masManufacturer.getTinNo2()%>"
        	<%}else{%>
        	data_arr[<%= counter%>][20] = ""
        	<%}%>
        	
        	<%if(masManufacturer.getLicenceNo2() != null){%>
        	data_arr[<%= counter%>][21] = "<%=masManufacturer.getLicenceNo2()%>"
        	<%}else{%>
        	data_arr[<%= counter%>][21] = ""
        	<%}%>
        	
        	<%if(masManufacturer.getEmailId2() != null){%>
        	data_arr[<%= counter%>][22] = "<%=masManufacturer.getEmailId2()%>"
        	<%}else{%>
        	data_arr[<%= counter%>][22] = ""
        	<%}%>
        	
        	<%if(masManufacturer.getUrl2() != null){%>
        	data_arr[<%= counter%>][23] = "<%=masManufacturer.getUrl2()%>"
        	<%}else{%>
        	data_arr[<%= counter%>][23] = ""
        	<%}%>
        	
        	<%if(masManufacturer.getCfLocalDistributorName3() != null){%>
        	data_arr[<%= counter%>][24] = "<%=masManufacturer.getCfLocalDistributorName3()%>"
        	<%}else{%>
        	data_arr[<%= counter%>][24] = ""
        	<%}%>
        	
        	<%if(masManufacturer.getCfLocalDistributorAddress3() != null){%>
        	data_arr[<%= counter%>][25] = "<%=masManufacturer.getCfLocalDistributorAddress3()%>"
        	<%}else{%>
        	data_arr[<%= counter%>][25] = ""
        	<%}%>
        	
        	
        	<%
        	Iterator itrGridStateList3=stateList.iterator();
        	 while(itrGridStateList3.hasNext())
                {
        		 try
        		 {
                 MasState stateGrid3 = (MasState)itrGridStateList3.next(); 
        		 if(masManufacturer.getState3()!=null)
        		 {
        			 if(masManufacturer.getState3().getId().equals(stateGrid3.getId()) && stateGrid3.getStatus().equalsIgnoreCase("Y"))
        			 {
        %>
        				data_arr[<%= counter%>][26] = "<%=stateGrid3.getStateName()%>"
        <%
        			  }
        		 }
                 else if(masManufacturer.getState3()!=null && stateGrid3.getId()!=null && stateGrid3.getStatus()!=null && masManufacturer.getState3().getId().equals(stateGrid3.getId()) && stateGrid3.getStatus().equalsIgnoreCase("N"))
                 {
        %>
        			data_arr[<%= counter%>][26] = "<font id='error'>*</font>Parent InActivated--<%=stateGrid3.getStateName()%>";
        <%
        		 }
                }
        		catch(Exception e){e.printStackTrace();}}%>
        		
        		<%	Iterator itrGridDistrictList3=districtList.iterator();
        		 while(itrGridDistrictList3.hasNext())
                    {try{
                     MasDistrict  districtGrid3 = (MasDistrict)itrGridDistrictList3.next(); 
                     if(masManufacturer.getDistrict3()!=null){
        	             if(masManufacturer.getDistrict3().getId().equals(districtGrid3.getId()) && districtGrid3.getStatus().equalsIgnoreCase("Y")){
        		             %>
        					data_arr[<%= counter%>][27] = "<%=districtGrid3.getDistrictName()%>"
        			<%		}
        	             }else if(masManufacturer.getDistrict3().getId().equals(districtGrid3.getId()) && districtGrid3.getStatus().equalsIgnoreCase("N")){%>
        				data_arr[<%= counter%>][27] = "<font id='error'>*</font>Parent InActivated--<%=districtGrid3.getDistrictName()%>";
        				
        			<%}
                    }catch(Exception e){}}%>
                    
                    
                    <%if(masManufacturer.getPinCode3() != null){%>
                	data_arr[<%= counter%>][28] = "<%= masManufacturer.getPinCode3()%>"
                	<%}else{%>
                	data_arr[<%= counter%>][28] = ""
                	<%}%>
                	
                	<%if(masManufacturer.getMobileno3() != null){%>
                	data_arr[<%= counter%>][29] = "<%= masManufacturer.getMobileno3()%>"
                	<%}else{%>
                	data_arr[<%= counter%>][29] = ""
                	<%}%>
                	
                	<%if(masManufacturer.getTinNo3()!= null){%>
                	data_arr[<%= counter%>][30] = "<%=masManufacturer.getTinNo3()%>"
                	<%}else{%>
                	data_arr[<%= counter%>][30] = ""
                	<%}%>
                	
                	<%if(masManufacturer.getLicenceNo3() != null){%>
                	data_arr[<%= counter%>][31] = "<%=masManufacturer.getLicenceNo3()%>"
                	<%}else{%>
                	data_arr[<%= counter%>][31] = ""
                	<%}%>
                	
                	<%if(masManufacturer.getEmailId3() != null){%>
                	data_arr[<%= counter%>][32] = "<%=masManufacturer.getEmailId3()%>"
                	<%}else{%>
                	data_arr[<%= counter%>][32] = ""
                	<%}%>
                	
                	<%if(masManufacturer.getUrl3() != null){%>
                	data_arr[<%= counter%>][33] = "<%=masManufacturer.getUrl3()%>"
                	<%}else{%>
                	data_arr[<%= counter%>][33] = ""
                	<%}%>
                	
                	data_arr[<%= counter%>][34] = "<%= masManufacturer.getLastChgBy()!=null?(masManufacturer.getLastChgBy().getId()!=null?masManufacturer.getLastChgBy().getId():"0" ):"0"%>"
                	data_arr[<%= counter%>][35] = "<%= HMSUtil.convertDateToStringWithoutTime(masManufacturer.getLastChgDate()) %>"
                	data_arr[<%= counter%>][36] = "<%= masManufacturer.getLastChgTime() %>"
                	<% if(masManufacturer.getStatus().equalsIgnoreCase("y")){ %>
                	
                	data_arr[<%= counter%>][37] = "Active"
                	<%}else{%>
                	data_arr[<%= counter%>][37] = "InActive"
                	<%}%>
	
            
<%
       counter++;
}
%>
 
formName = "manufacturer"

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

function populateDistrictTwo(val,formName){
	obj = eval('document.'+formName+'.<%=DISTRICT_ID2%>');
	obj.length = 1;
	for(i=0;i<districtArrayTwo.length;i++){
		if(districtArrayTwo[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=districtArrayTwo[i][1];
			obj.options[obj.length-1].text=districtArrayTwo[i][2];
		}
	}
}
function populateDistrictThree(val,formName){
	obj = eval('document.'+formName+'.<%=DISTRICT_ID3%>');
	obj.length = 1;
	for(i=0;i<districtArrayThree.length;i++){
		if(districtArrayThree[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=districtArrayThree[i][1];
			obj.options[obj.length-1].text=districtArrayThree[i][2];
		}
	}
}
</script>