<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response of package details.
 * @author  Om Tripathi
 * Create Date: 5 Dec,2017 
 * Revision Date:      
 * Revision By:  
 * @version 
--%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="jkt.hms.masters.business.MasApplication"%>
<%@ page import="jkt.hms.masters.business.MasTemplate"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasHospitalType"%>
<%@ page import="jkt.hms.masters.business.Users"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<meta charset="utf-8"/>
<%
	String date = "";
	String time = "";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	Map<String,Object> map = new HashMap<String,Object>();
 	int template = 0;
 	if(request.getAttribute("map") != null)
	{
		map = (Map<String,Object>) request.getAttribute("map");
	}
	
	List<Object[]> departmentList = new ArrayList<Object[]>();
	if(map.get("departmentList") != null){
		departmentList = (List<Object[]>)map.get("departmentList");
	}
	List<Object[]> districtList = new ArrayList<Object[]>();
	if(map.get("districtList") != null){
		districtList = (List<Object[]>)map.get("districtList");
	}
	
	List<Object[]> hospitalList = new ArrayList<Object[]>();
	if(map.get("hospitalList")!=null){
		hospitalList = (List<Object[]>)map.get("hospitalList");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	String superAdmin = "";
	int userType = 0; 
	if(session.getAttribute("users") != null){
		 Users user = (Users)session.getAttribute("users");
		 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
		 userType = user.getUserType()!=null?user.getUserType():4;
	}
	
	int hospitalId=0;
	if(map.get("hospitalId")!=null){
		hospitalId= (Integer)map.get("hospitalId");
	}	
	else{
		hospitalId= (Integer)session.getAttribute("hospitalId");
	}

	MasHospital hospital = new MasHospital();
	int districtId = 0,instType=0;
	if(map.get("districtId")!=null){
		districtId = (Integer)map.get("districtId");
	}else if(session.getAttribute("districtId")!=null){
		districtId = (Integer)session.getAttribute("districtId");
	}
	List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
	 if(map.get("mhospitalTypetList")!=null){
		 mhospitalTypetList=(List<MasHospitalType>)map.get("mhospitalTypetList");
		}
	 
		
		if(session.getAttribute("hospitalTypeId")!=null){
			instType = (Integer)session.getAttribute("hospitalTypeId");
		}else{
			if (map.get("instType") != null) {
				instType =(Integer)(map.get("instType"));
			}
		}
		String shortName= "";
		for(Object[] mh:hospitalList){ 
			 if(hospitalId==(Integer)mh[0]){
			 	shortName=(String)mh[2];
			break;
			 }
		 }List<MasHospital> masTablets= new ArrayList<MasHospital>();
		if(map.get("masTablets")!=null){
			masTablets=(List<MasHospital>)map.get("masTablets");
			
		}
		/* if(masHospList.size()>0){
			tabStatus = masTablets.get(0).getTabletStatus();
		} */
%>
<div class="Block">
<form name="searchAssetMaster" method="post">
 
<% 
			if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
		  <h4><%=message%></h4>
<%		   
		  }
%>

<div class="titleBg">
<h2>Tablet Assignment</h2>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<div id="contentHolder">
<%	
if(userType<=1){ 
%>
	
	<label>District</label>
	<select name="<%=DISTRICT_NAME %>" id="districtId"  tabindex="1" onchange="dropDownChange();" onblur="dropDownChange();">
	<%
	
		for(Object[] obj : districtList){
			if(obj[1]!=null){
			if(districtId== Integer.parseInt(obj[0].toString())){				
	%>
	
	<option value="<%=obj[0]%>" selected="selected"><%=obj[1].toString().trim() %></option>
	<%}else{ %>
	<option value="<%=obj[0]%>"><%=obj[1].toString().trim() %></option>
	<%}
		}}
			%>
	</select>
	<%}else{
		%>
			<input type="hidden" name="<%=DISTRICT_NAME %>" id="districtId" value="<%=districtId%>"/>
		<%} %>
		<%if(userType<=2){ %>
		<label>Institute Type</label>

    <select name="<%=INSTITUTE_TYPE %>" id="instType" validate="Institute Type,int,no" onchange="dropDownChange();" onblur="dropDownChange();" tabindex="1">
             	<option value="0">Select</option>
                 	<%for(MasHospitalType mht : mhospitalTypetList){ 
                 	if(instType==mht.getId()){
                 	%>
                <option value="<%=mht.getId() %>" selected="selected"><%=mht.getHospitalTypeName()%></option>
                 	<%}else{ %>
            	 <option value="<%=mht.getId() %>"><%=mht.getHospitalTypeName()%></option>
   					<%} }%>
	</select>
	<%} %>
	<%
if(userType==5){ // For PH admin
	List<Object[]> bsScInstList = new ArrayList<Object[]>();
	
	if(map.get("bsScInstList") != null){
		bsScInstList = (List<Object[]>)map.get("bsScInstList");
	}
%>
<label><span>* </span>Institute</label>
<div id="insHospital">
    <select name="hospitalId" id="hospitalId" onchange="submitProtoAjax('assignApplicationForm','/hms/hms/user?method=getTemplateForHospital');" validate="Institute,int,yes">

             	<option value="0">Select</option>
                 	<%for(Object[] mh:bsScInstList){ 
                 	if(hospitalId == (Integer)mh[0]){
                 	%>
                 	 <option value="<%=mh[0] %>" selected="selected"><%=mh[1]%></option>
                 	<%}else{ %>
            	 <option value="<%=mh[0] %>"><%=mh[1]%></option>
   					<%} 
   					}%>
	</select>
	<%}else{ %>
	<script type="text/javascript">
function eventCallback(element, entry){
	return entry+"&districtId=" + document.getElementById('districtId').value+"&instType="+document.getElementById('instType').value;                                                                       
}
</script>
<div id="hospitalDiv">
<% if(userType<3){ %>
	<label>Institution</label>

     <input type="text" name="<%=INSTITUTE_NAME %>" id="Institute"  <%if(userType<=2){%>onblur="getHospitalId();"<%}%> value="<%=shortName%>"  tabindex="1">
				<div id="instDiv" style="display: none;"
												class="autocomplete"></div> 
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('Institute','instDiv','generalMaster?method=getHospitalListForAutoCompleteItem',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>
	<input type="hidden" name="<%=INSTITUTE_NAME %>" id="hospitalId" value="<%=hospitalId %>">
	</div>
	<%}else{ %>
		<input type="hidden" id="hospitalId" name="<%=INSTITUTE_NAME %>" value="<%=session.getAttribute("hospitalId") %>">
	<%} %>
	<%} %>

<label>UTID </label> 
<input type="text" value="" name="<%=UTID%>"/>
<label>IMEI </label> 
<input type="text" value="" name="<%=IMEI%>"/>
																														
<input type="button" name="search" value="Search" class="button" onclick="submitForm('searchAssetMaster','pubHealth?method=tabAssetsMaster&searchs=Y')" tabindex=1 /> 
</div>	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</div>
</form>
 <div id="searchData">
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
   <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"districtNameId"], [2,"instituteTypeId"],[3,"instituteCode"], [4,"instituteNameId"],[5,"imei"],[6,"sim"],[7,"utid"],[8,"mac"]];	
	 statusTd = 8;
	
	</script></div>
	<div class="clear"></div>

<form name="attachFile" method="post" action="" enctype="multipart/form-data">
<div class="Block">
<div class="clear"></div>
<label>Select File</label>
 <input type="file" name="<%=UPLOAD_FILENAME %>" id="uploadFilename">
 <input type="hidden" id="fileName" name="fileName" value="" />
 
<input name="import" type="button" class="button" value="Import" onClick="jsImport();"/>
<input name="import" type="button" class="button" onClick="jsExport();" value="Export"/>

</div>
 </form> 
<div class="clear"></div>
<form name="tabletAssetAdd" method="post" action="" >
<div class="Block">
<div class="clear"></div>
<div id="testDiv">

<label>District Name </label> 
<input type="text" value="" id ="districtNameId" name="<%=DISTRICT_NAME %>" validate="District Name,string,yes" maxlength="60" tabindex=1/>

<label>Institute Type </label> 
<input type="text" value="" id ="instituteTypeId" name="<%=INSTITUTE_TYPE %>" validate="Institute Type,string,yes" maxlength="60" tabindex=1/>

<label>Institute Code </label> 
<input type="text" value="" id="instituteCode" name="<%=INSTITUTE_CODE %>" validate="Institute Code,string,yes" onblur="getHospitalName()" maxlength="60" tabindex=1/>
<div id="institutes" style="display: none;"
												class="autocomplete"></div> 
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('instituteCode','institutes','pubHealth?method=getHospitalDetailForAutoComplete',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>

<label>Institute Name </label> 
<input type="text" value="" id ="instituteNameId" name="<%=INSTITUTE_NAME%>" validate="Institute Name,string,yes" maxlength="60" tabindex=1/>

<label>UTID </label> 
<input type="text" value="" id="utidId" name="<%=UTID %>" validate="UTID,string,yes" maxlength="60" tabindex=1/>

<label>MAC </label> 
<input type="text" value=""  id="macId" name="<%=MAC %>" validate="MAC,string,yes" maxlength="60" tabindex=1/>

<label>IMEI  </label> 
<input type="text" id="imeiId" value="" name="<%=IMEI %>" validate="IMEI,string,yes" maxlength="60" tabindex=1/>

<label>SIM  </label> 
<input type="text" id="simId" value="" name="<%=SIM %>" validate="SIM,string,yes" maxlength="60" tabindex=1/>

<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('tabletAssetAdd','pubHealth?method=addTabletAssetsDetails');"	accesskey="a" tabindex=1 />
<input type="hidden" name="edit"	id="editbutton" value="Update"  class="button"	onClick="submitForm('tabletAssetAdd','pubHealth?method=addTabletAssetsDetails')"	accesskey="u" tabindex=1 />
<!-- <input type="hidden" name="Delete"	id="deletebutton" value="Activate"  class="button"	onClick="submitForm('tabletAssetAdd','pubHealth?method=addTabletAssetsDetails&flag='+this.value)"	accesskey="d" tabindex=1 /> -->
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onClick="submitForm('tabletAssetAdd','pubHealth?method=tabAssetsMaster');" accesskey="r" /> 

 <%-- <%=if(tabStatus.equals("A")){ %>
 <input type="button" name="Delete"	id="deletebutton" value="InActivate"  class="button"	onClick="submitForm('tabletAssetAdd','pubHealth?method=addTabletAssetsDetails&flag='+this.value)"	accesskey="d" tabindex=1 />
 <%}else if(tabStatus.equals("I")){ %>
 <input type="button" name="Delete"	id="deletebutton" value="Activate"  class="button"	onClick="submitForm('tabletAssetAdd','pubHealth?method=addTabletAssetsDetails&flag='+this.value)"	accesskey="a" tabindex=1 />
 <%} %> --%>
<!-- <input type="reset" name ="report" id="report" value ="Generate Report" class="buttonBig" onclick="submitForm('search','pubHealth?method=generateReportForTabletMasters');" accesskey="r"  tabindex=1 /> -->
<%-- <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_Tablet">  --%>

<input type="hidden" id="hositalStatus" name="hositalStatus" value="0"/>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date%></label> 

<label>Changed Time</label> <label class="value"><%=time%></label>
 <input type="hidden"	name="<%=CHANGED_BY%>" value="admin" /> 
 <input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
 <input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
 </div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<input type="hidden" name="<%=STATUS %>" value="" validate="status,metachar,no"/> <input
	type="hidden" name="<%= COMMON_ID%>" value="" validate="commonId,int,no"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
</div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "District Name"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "districtNameId"

data_header[1] = new Array;
data_header[1][0] = "Institute Type"
data_header[1][1] = "hide";
data_header[1][2] = "10%";
data_header[1][3] = "instituteTypeId";

data_header[2] = new Array;
data_header[2][0] = "Institute Code"
data_header[2][1] = "data";
data_header[2][2] = "20%";
data_header[2][3] = "instituteCode";

data_header[3] = new Array;
data_header[3][0] = "Institute Name"
data_header[3][1] = "data";
data_header[3][2] = "10";
data_header[3][3] = "instituteNameId"

data_header[4] = new Array;
data_header[4][0] = "IMEI"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "imei";

data_header[5] = new Array;
data_header[5][0] = "SIM"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "sim";

data_header[6] = new Array;
data_header[6][0] = "UTID"
data_header[6][1] = "data";
data_header[6][2] = "15";
data_header[6][3] = "utid"

data_header[7] = new Array;
data_header[7][0] = "MAC"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "mac";




data_arr = new Array();

<%
Iterator itr=masTablets.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasHospital  masTablet = (MasHospital)itr.next(); 
%>
 
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masTablet.getId()%>";
data_arr[<%= counter%>][1] = "<%= masTablet.getDistrict().getDistrictName()%>";
data_arr[<%= counter%>][2] = "<%= masTablet.getHospitalType().getInstituteTypeShortName()%>";
data_arr[<%= counter%>][3] = "<%= masTablet.getHospitalCode()%>";
data_arr[<%= counter%>][4] = "<%= masTablet.getHospitalName()%>";
<%
if( masTablet.getImeiNo()!=null){%>
	data_arr[<%= counter%>][5] = "<%= masTablet.getImeiNo()%>";
<%}else{%>
	data_arr[<%= counter%>][5] = "";
<%}%>

<%if(masTablet.getSimNo()!=null){%>
	data_arr[<%= counter%>][6] = "<%= masTablet.getSimNo()%>";
<%}else{%>
    data_arr[<%= counter%>][6] = "";
<%}%>
<%if(masTablet.getUtid()!=null){ %>
data_arr[<%= counter%>][7] = "<%= masTablet.getUtid()%>";
<%}else{%>
data_arr[<%= counter%>][7] = "";
<%}%>
<%if(masTablet.getMac()!=null){%>
data_arr[<%= counter%>][8] = "<%= masTablet.getMac()%>";
<%}else{%>
data_arr[<%= counter%>][8] = "";
<%}%>


<%
		     counter++;
}
%>
 
formName = "tabletAssetAdd";

nonEditable = ['<%=CODE%>']; 
start = 0;
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

<script type="text/javascript">
function getHospitalId(){
	var instName=document.getElementById("Institute").value;
	document.getElementById("hositalStatus").value=1;
	if(instName==""){
		document.getElementById("hospitalId").value=<%=hospitalId %>;
	}else{
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
              
	        	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
	        	
	        	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	  	   	    var item = chargeCodes.childNodes[loop];
	  	   	 
	  	        var hospitalName  = item.getElementsByTagName("hospitalName")[0];
	  	        var hosid  = item.getElementsByTagName("hospitalId")[0]; 
	  	        var id= hosid.childNodes[0].nodeValue;			  	      
	  	    document.getElementById("hospitalId").value=id;
	  	     
	  	    submitProtoAjax('assignApplicationForm','/hms/hms/user?method=getTemplateForHospital');
	        	}
        	   }
            }
	 
        var url='/hms/hms/generalMaster?method=getHospitalId&hospitalName='+instName+"&variable=Y";
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; 

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	      }
	
}
</script>
<script type="text/javascript">
function dropDownChange(){
	var dist= document.getElementById("districtId").value;
	var ins= document.getElementById("instType").value;
	if(dist>0 && ins>0){
	    document.getElementById("hospitalId").value=<%=hospitalId %>;
		document.getElementById("Institute").value="";
	}else{
		document.getElementById("Institute").setAttribute('validate','Institution,String,no');
		document.getElementById("hospitalId").value=<%=hospitalId %>;
	}
}

function getHospitalName() { 
	var instituteCode= document.getElementById("instituteCode").value;
	if(instituteCode!=null && instituteCode!=''){
		
	var id;
	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			alert(e)
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			var b = "false";
			var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
			for (loop = 0; loop < items.childNodes.length; loop++) {
				var item = items.childNodes[loop];
				var dupl = item.getElementsByTagName('alreadyIssued1')[0];
				var dupl1 = item.getElementsByTagName('alreadyIssued1')[1];
				b = dupl.childNodes[0].nodeValue;
				b1 = dupl1.childNodes[0].nodeValue;
				 document.getElementById('instituteCode').value=b;
				 document.getElementById('instituteNameId').value=b1;
			}
		}
	}
			var url = "/hms/hms/pubHealth?method=getHospitalDetails&districtId="+ districtId+"&instituteCode="+ instituteCode+"&"+csrfTokenName + "="+ csrfTokenValue;
	
	xmlHttp.open("GET", url, true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);
}
}
</script>

<script>
 function jsImport()
 {
  var fname =document.getElementById('uploadFilename').value;
	if (document.attachFile.<%=UPLOAD_FILENAME%>.value=="")
		{
		alert('Please Select the Excel file to Import!.....');
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
		submitForm('attachFile','pubHealth?method=importAssetsDetails&filename='+filename+'&'+csrfTokenName+'='+csrfTokenValue);
 	
 }
</script>
<script>
 function jsExport()
 {
		submitForm('attachFile','pubHealth?method=downloadTabletDetails&'+csrfTokenName+'='+csrfTokenValue);
 }
 </script>
