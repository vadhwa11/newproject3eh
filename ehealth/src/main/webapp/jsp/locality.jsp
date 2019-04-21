
<%@page import="jkt.hms.masters.business.PhMasLocality"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasWard> wardList = new ArrayList<MasWard>();
	List<MasLsg> lsgList = new ArrayList<MasLsg>();
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<PhMasLocality> phMasLocalityList = new ArrayList<PhMasLocality>();
	
	if(map.get("wardList")!=null){
		wardList = (List<MasWard>)map.get("wardList");
	}
    if(map.get("lsgList")!=null){
    	lsgList = (List<MasLsg>)map.get("lsgList");
	}
    if(map.get("districtList")!=null){
    	districtList = (List<MasDistrict>)map.get("districtList");
	}
	
	if(map.get("phMasLocalityList")!=null){
		phMasLocalityList = (List<PhMasLocality>)map.get("phMasLocalityList");
	}
	
	List<PhMasLocality> localityNameList = new ArrayList<PhMasLocality>();
	List<MasWard> wardIdList = new ArrayList<MasWard>();
	List<MasLsg> lsgIdList = new ArrayList<MasLsg>();
	if(map.get("localityNameList")!=null){
		localityNameList = (List<PhMasLocality>)map.get("localityNameList");
		System.out.println("localityNameList"+localityNameList.size());
	}
	if(map.get("wardIdList")!=null){
		wardIdList = (List<MasWard>)map.get("wardIdList");
		System.out.println("wardIdList"+wardIdList.size());
	}
	if(map.get("lsgIdList")!=null){
		lsgIdList = (List<MasLsg>)map.get("lsgIdList");
		System.out.println("lsgIdList"+lsgIdList.size());
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int userId =0;
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
	%>
	
<h4><%=message %></h4>
		<%  }
 %>
 <%

if (request.getAttribute("map") != null)
	map = (Map<String,Object>) request.getAttribute("map");
String msg = "";
if(map.get("msg") != null){
	msg = (String)map.get("msg");
}
Set<String> itemsNotAvailable = new HashSet<String>();
//String itemsNotAvailable = "";
if(map.get("itemsNotAvailable") != null){
	itemsNotAvailable = (HashSet<String>)map.get("itemsNotAvailable");
}
String items = "";
for(String s : itemsNotAvailable){
	if(!items.equals("")){
		items +=", "+s;
	}else
		items +=""+s;
}
if(!msg .equals("")){%>
	<h4><span><%=msg %></span></h4>
		<div class="clear"></div>
	<% }
%>
<%
	if(!items.equals("")){
		%>
		<h4><span>Items not available in Ehealth:</span></h4>
		<h4><span><%=items %></span></h4>
	<%}
%>
<div class="titleBg">
<h2>Locality Master</h2>
</div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">

<label>Name </label> 
<input type="text" value="" name="searchField"/>
<input type="hidden" name="colName" value="locality_name">
<input type="hidden" name="<%=SELECTED_RADIO%>"  id="radio1"  value="2"  checked="checked" />
			
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchDepotUnit')" tabindex=1 /> 
<input type="reset" name ="add" id="reset" value ="Generate Report" class="buttonBig" onclick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="r"  tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_locality"> 
</div>	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 </form>
 
<form name="attachFile" method="post" action="" enctype="multipart/form-data">

<div class="Block">
<div class="clear"></div>
<label>Select File</label>
 <input type="file" name="<%=UPLOAD_FILENAME %>" id="uploadFilename">
 <input type="hidden" id="fileName" name="fileName" vale="" />
 
<input name="add" type="button" class="button" value="Import" onClick="jsImport();"/>

<a href="/hms/hms/generalMaster?method=downloadLocality&+csrfTokenName+'='+csrfTokenValue"> Export File</a>
 </div>
 </form> 
 
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
   <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"localityName"], [2,"wardId"],[3,"lsgId"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"],[8,"disId"],[9,"lsgHideId"],[10,"districtId"]];
	 statusTd = 7;
	</script></div>
	<div class="clear"></div>
<form name="depotUnit" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label>Locality  Name </label> 
<input type="text" value="" name="localityName" validate="Locality Name,string,yes" maxlength="60" tabindex=1/>

<label>District <span>*</span> </label> 
<select name="districtId" validate="District,string,no" onchange="populateLsgByDistrictId(this.value)" id="districtId" tabindex=1>
<option value="0">Select</option>
<%
if(districtList.size()>0){
	for(MasDistrict masdistrict : districtList){
%>
<option value="<%=masdistrict.getId() %>"><%=masdistrict.getDistrictName() %></option>
	<%}
}	
%>
</select>
<label>Lsg <span>*</span> </label> 
<select name="lsgId" validate="Lsg,string,yes" id="lsgId" onchange="populateWardByLsgId(this.value)" tabindex=1>
<option value="0">Select</option>
</select>
<div class="clear"></div>
<label>Ward <span>*</span> </label> 
<select name="wardId" validate="Ward,string,yes" id="wardId" tabindex=1>
<option value="0">Select</option>
</select> 

<div class="clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button"	onClick="submitForm('depotUnit','generalMaster?method=addLocality');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none"	onClick="submitForm('depotUnit','generalMaster?method=updateLocality')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none"	onClick="submitForm('depotUnit','generalMaster?method=deleteLocality&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="submitFormForButton('depotUnit','generalMaster?method=showLocalityJsp')" accesskey="r" />



<input type="hidden" name="<%=STATUS %>" value="" /> 
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName %></label>

<label>Changed Date:</label>
<label class="value"><%=date %></label>

<label>Changed Time:</label>
<label class="value"><%=time %></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div id="edited"></div>
</form>
<script type="text/javascript">
data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = "Locality Name"
	data_header[0][1] = "data";
	data_header[0][2] = "10%";
	data_header[0][3] = "localityName"


data_header[1] = new Array;
data_header[1][0] = "Ward"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "wardId";
//govind code 12-7-2106
data_header[2] = new Array;
data_header[2][0] = "Lsg"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "lsgId";

//govind end

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "0";
data_header[5][3] = "<%= CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";


data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "0";
data_header[7][3] = "disId";



data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "0";
data_header[8][3] = "lsgHideId";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "0";
data_header[9][3] = "districtId";
data_arr = new Array();

<%
          int  counter=0;
         for(PhMasLocality phMasLocality :phMasLocalityList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= phMasLocality.getId()%>"

		data_arr[<%= counter%>][1] = "<%= phMasLocality.getLocalityName()%>"


<%if(phMasLocality.getWard() != null && phMasLocality.getWard().getStatus()!=null && phMasLocality.getWard().getStatus().equals("Y")) { %>
	data_arr[<%= counter%>][2] = "<%=phMasLocality.getWard().getWardName()%>";
<% } else if(phMasLocality.getWard() != null && phMasLocality.getWard().getStatus()!=null && phMasLocality.getWard().getStatus().equals("N")) { %>
	data_arr[<%= counter%>][2] = "<span>*</span>Parent InActivated--<%=phMasLocality.getWard().getWardName()%>";
<% } else { %>
	data_arr[<%= counter%>][2] = "-";
<% } %>

<%if(phMasLocality.getLsg() != null  && phMasLocality.getWard().getStatus()!=null && phMasLocality.getLsg().getStatus().equals("Y")) { %>
	data_arr[<%= counter%>][3] = "<%=phMasLocality.getLsg().getLsgTypeName().trim()%>";
	data_arr[<%= counter%>][8] = "<%=phMasLocality.getLsg().getDistrict().getId()%>";
	data_arr[<%= counter%>][9] = "<%=phMasLocality.getLsg().getId()%>";
	data_arr[<%= counter%>][10] = "<%=phMasLocality.getLsg().getDistrict().getDistrictName().trim()%>";
	
<% } else if(phMasLocality.getLsg() != null && phMasLocality.getWard().getStatus()!=null && phMasLocality.getLsg().getStatus().equals("N")) { %>
	data_arr[<%= counter%>][3] = "<span>*</span>Parent InActivated--<%=phMasLocality.getLsg().getLsgTypeName().trim()%>";
	data_arr[<%= counter%>][8] = "<%=phMasLocality.getLsg().getDistrict().getId()%>";
	data_arr[<%= counter%>][9] = "<%=phMasLocality.getLsg().getId()%>";
	data_arr[<%= counter%>][10] = "<%=phMasLocality.getLsg().getDistrict().getDistrictName().trim()%>";
<% } else { %>
	data_arr[<%= counter%>][3] = "-";
	data_arr[<%= counter%>][8] = "0";
	data_arr[<%= counter%>][9] = "0";
	data_arr[<%= counter%>][10] = "";
<% } %>

data_arr[<%= counter%>][4] = "<%= phMasLocality.getLastChgBy()!=null?(phMasLocality.getLastChgBy().getId()!=null?phMasLocality.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(phMasLocality.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= phMasLocality.getLastChgTime() %>"

<% if(phMasLocality.getStatus().equals("Y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive";
<%}%>
<%
		     counter++;
}
%>
formName = "depotUnit"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<script type="text/javascript" src="/hms/jsp/js/ward.js"></script>

 <script>
 function jsImport()
 {
	 var fname =document.getElementById('uploadFilename').value;
	if (document.attachFile.<%=UPLOAD_FILENAME%>.value=="")
		{
		alert('Pl. Select the Excel file to Import!.....');
		return;
		}
		var fname = document.attachFile.<%=UPLOAD_FILENAME%>.value;
		var st = fname.length;
		st = st-3;
		if (fname.substring(st)!="xls")
		{
		alert('Only Excel files are Allowed.');
		return;
		}
		document.attachFile.encoding="multipart/form-data";
		var ind = fname.lastIndexOf("\\");
		var filename = fname.substring(ind+1);
		submitForm('attachFile','generalMaster?method=importLocality&filename='+filename+'&'+csrfTokenName+'='+csrfTokenValue);

 	
 }
 </script>