
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map<String,Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	/* List<MasTemplate> searchTemplateList = new ArrayList<MasTemplate>();
	searchTemplateList= (ArrayList)map.get("searchTemplateList"); */
	
	List<Object[]> searchTemplateList = new ArrayList<Object[]>();
	searchTemplateList= (List<Object[]>)map.get("searchTemplateList");
	
	List<Object[]> hospitalList = new ArrayList<Object[]>();
	if(map.get("hospitalList")!=null){
		hospitalList = (List<Object[]>)map.get("hospitalList");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	String superAdmin = "";
	int userType = 0; /* user type 4 for general user */
	if(session.getAttribute("users") != null){
		 Users user = (Users)session.getAttribute("users");
		 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
		 userType = user.getUserType()!=null?user.getUserType():4;
	}
	System.out.println("userType "+userType);
	List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
	List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
	 if(map.get("mhospitalTypetList")!=null){
		 mhospitalTypetList=(List<MasHospitalType>)map.get("mhospitalTypetList");
		}
	 if(map.get("mdistrictList")!=null){
		 mdistrictList=(List<MasDistrict>)map.get("mdistrictList");
		}
	 
	 if(map.get("message") != null){
		   String message = (String)map.get("message");
		 %>
		 
		 
<h4><span><%=message %></span></h4>
<%}
 %>


<form name="search" method="post" action="">

<div class="titleBg">
<h2>Role Creation</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar"><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" validate="selectedRadio,metachar,no"
	class="radioCheck"/> <label>Role Code:</label> <input
	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" validate="selectedRadio,string,no"/>
<label>Role Name:</label> <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value="" validate="searchField,string,no"
	MAXLENGTH="50" tabindex=1
	onkeypress="return submitenter(this,event,'user?method=searchTemplate')" />

<div class="clear"></div>
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','user?method=searchTemplate','checkSearch')"
	tabindex=1 /></div>
</div>
<div class="clear"></div>
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
  if(searchTemplateList.size()>0)
   {
	  String strForCode = (String)map.get("templateCode");
		String strForCodeDescription = (String)map.get("templateName");
		if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
		{
 %>
<div class="clear"></div>
<a href="user?method=showTemplateMaster">Show All Records</a> <%
		
		  }
	   }
	 if(searchTemplateList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="user?method=showTemplateMaster">Show All Records</a> <%
    }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"],[1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"Institute"],[9,"<%=DEPARTMENT_ID%>"],[5,"<%=STATUS%>"],[6,"<%=HOSPITAL_ID%>"],[7,"district"],[8,"instType"],[4,"institution"]]; 
  statusTd =5;
 </script></div>

<div class="clear"></div>
<form name="template" method="post" action=""><input
	type="hidden" name="<%=JSP_NAME %>" value="masTemplate" validate="jspName,metachar,no"><input
	type="hidden" name="<%= POJO_NAME %>" value="MasTemplate" validate="pName,metachar,no"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TemplateName" validate="tpName,metachar,no"><input
	type="hidden" name="title" value="Template" validate="title,metachar,no"><input
	type="hidden" name="pojoPropertyCode" value="TemplateCode" validate="ppCode,string,no">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label ><span>*</span>Role Code </label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Template Code,string,yes" MAXLENGTH="8" tabindex=1 /> 
	<label><span>*</span>Role Name </label> 
	<input type="text" name="<%=SEARCH_NAME %>" id="<%=SEARCH_NAME %>"
	value="" validate="TemplateName,string,yes" maxlength="30" tabindex="1" />
	
<%-- 		<%	if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin") || userType<3){ %> --%>
	<%-- <label>Institution<span>*</span></label>
	<select name="hospitalId" id="hospitalId" validate="Institution,metachar,yes">
	<option value="0">Select </option>
	<%
		for(Object[] obj : hospitalList){
			if(obj[2].toString().equalsIgnoreCase("y")){
	%>
	
	<option value="<%=obj[0]%>"><%=obj[1].toString().trim() %></option>
	<%}
			}
			%>
	</select> 
	<label>Institution</label>
<!-- 	<div id="insHospital"> -->
<!-- 	<select name="hospitalId" id="hospitalId" > -->
<!-- 	<option value="0">Select </option> -->
<%-- 	<% --%>
<!-- // 		for(Object[] obj : hospitalList){ -->
<!-- // 			if(obj[2].toString().equalsIgnoreCase("y")){ -->
<%-- 	%> --%>
	
<%-- 	<option value="<%=obj[0]%>"><%=obj[1].toString().trim() %></option> --%>
<%-- 	<%} --%>
<!-- // 			} -->
<%-- 			%> --%>
<!-- 	</select> -->
<!-- 	</div> -->
<%	if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin") || userType<3){ %>
<label>District</label>
    <select name="district" id="district" validate="District,int,no" onchange="dropDownChange();" onblur="dropDownChange();" tabindex="1">
             	<option value="0">Select</option>
                 	<%for(MasDistrict md:mdistrictList){ %>
            	 <option value="<%=md.getId() %>"><%=md.getDistrictName()%></option>
   					<%} %>
	</select>
	<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
	<label>Institute Type</label>
 <!--     <select name="instType" id="instType" onchange="populateInst('tempId')" validate="Institute Type,int,no">-->
    <select name="instType" id="instType" onchange="populateHospital();dropDownChange();" validate="Institute Type,int,no" onblur="dropDownChange();" tabindex="1">
             	<option value="0">Select</option>
                 	<%for(MasHospitalType mht : mhospitalTypetList){ %>
            	 <option value="<%=mht.getId() %>"><%=mht.getHospitalTypeName()%></option>
   					<%} %>
	</select>
	<script type="text/javascript">
function eventCallback(element, entry){
//alert("group-=="+document.getElementById('itemGroupId').value);
var dist=0,ins=0;
if(document.getElementById("district")!=null){
dist= document.getElementById("district").value;
}
if(document.getElementById("instType")!=null){
ins= document.getElementById("instType").value;
}
	return entry+"&districtId=" + dist+"&instType="+ins;                                                                       
}
</script>
	
	<label>Institution</label>
<input type="text" name="instName" id="Institute" onblur="getHospitalId();" tabindex="1">
				<div id="instDiv" style="display: none;"
												class="autocomplete"></div> 
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('Institute','instDiv','generalMaster?method=getHospitalListForAutoCompleteItem',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>
					<input type="hidden" name="hospitalId" id="hospitalId" value="0">
					<input type="hidden"  id="institution" value="">
	<%}else{ %>
		<input type="hidden" id="hospitalId" name="hospitalId" value="<%=session.getAttribute("hospitalId") %>">
	<%} %>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onclick="submitForm('template','user?method=addTemplate');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('template','user?method=editTemplate')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('template','user?method=deleteTemplate&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="button" onclick="resetCheck();"
	accesskey="r" /> <input type="hidden" name="<%=STATUS %>" value="" validate="status,metachar,no"/>
<input type="hidden" name="<%= COMMON_ID%>" value="" validate="commonId,int,no"/>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label class="bodytextB">Changed
Date:</label> <label class="value"><%=date%></label> <label class="bodytextB">Changed
Time:</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName %>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 </form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Role Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Role Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "ShortName"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "institution";


data_header[3] = new Array;
data_header[3][0] = "Institution";
data_header[3][1] = "data";
data_header[3][2] = "5%";
data_header[3][3] = "Institute";

data_header[8] = new Array;
data_header[8][0] = "Department"
data_header[8][1] = "hide";
data_header[8][2] = "50%";
data_header[8][3] = "<%=DEPARTMENT_ID%>";

data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "data";
data_header[4][2] = "5%";
data_header[4][3] = "<%=STATUS %>";

data_header[5] = new Array;
data_header[5][0] = "<%= HOSPITAL_ID %>"
data_header[5][1] = "hide";
data_header[5][2] = "5%";
data_header[5][3] = "<%= HOSPITAL_ID %>";

data_header[6] = new Array;
data_header[6][0] = "district"
data_header[6][1] = "hide";
data_header[6][2] = "5%";
data_header[6][3] = "district";

data_header[7] = new Array;
data_header[7][0] = "instType"
data_header[7][1] = "hide";
data_header[7][2] = "5%";
data_header[7][3] = "instType";


data_arr = new Array();
<%
// Iterator<MasTemplate> itr=searchTemplateList.iterator();
Iterator<Object[]> itr=searchTemplateList.iterator();
Object[] objectsArray = null;
MasHospital masHospital = null;
MasDepartment masDepartment = null;
          int  counter=0;
          while(itr.hasNext())
           {            
        	  // MasTemplate  masTemplate = (MasTemplate)itr.next();
        	 	 objectsArray = (Object[])itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%-- <%= masTemplate.getId()%> --%>   <%=(Integer)objectsArray[0]%>
data_arr[<%= counter%>][1] = <%-- "<%=masTemplate.getTemplateCode()%>" --%>  "<%=(String)objectsArray[1]%>"
data_arr[<%= counter%>][2] = <%-- "<%=masTemplate.getTemplateName()%>" --%>   "<%=(String)objectsArray[2]%>"

	<%
	
	for(Object[] obj : hospitalList){
         // if(masTemplate.getHospital() !=null){
         if(objectsArray[3]!=null){
        	 masHospital = 	(MasHospital)objectsArray[3];	 
		 if(masHospital.getId().equals(obj[0]) && obj[2].toString().equalsIgnoreCase("y")){ %>
			data_arr[<%= counter%>][3] = "<%=obj[3].toString().trim()%>";
				data_arr[<%= counter%>][4] = "<%=obj[1].toString().trim()%>";
				data_arr[<%= counter%>][6] = "<%=obj[0].toString().trim()%>";
		<%}else if(masHospital.getId().equals(obj[0]) && obj[2].toString().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=obj[1].toString().trim()%>";
			
		<%} 
		 if(masHospital.getId().equals(obj[0]) && obj[2].toString().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][7] = "<%=(masHospital.getDistrict()!=null)?masHospital.getDistrict().getId():0%>";
			data_arr[<%= counter%>][8] = "<%=(masHospital.getHospitalType()!=null)?masHospital.getHospitalType().getId():0%>";
		<%}}else{%>
		data_arr[<%= counter%>][3] = "";
		
		data_arr[<%= counter%>][4] ="";
		data_arr[<%= counter%>][6] = "";
	
		data_arr[<%= counter%>][7] ="";
			data_arr[<%= counter%>][8] ="";
		
<%}
    masDepartment = (MasDepartment)objectsArray[4];     
         
}%>
        
<%-- data_arr[<%= counter%>][3] = "<%=masTemplate.getHospital().getHospitalName()%>" --%>

data_arr[<%= counter %>][9] = "<%=(masDepartment!=null) ? masDepartment.getDepartmentName():""%>";
<% if(objectsArray[5]!=null && ((String)objectsArray[5]).equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][5] = "Active";
<%}else{%>
data_arr[<%= counter%>][5] = "InActive";
<%}%>


<%
		     counter++;
}
%>
 
formName = "template";

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  


//added by govind 27-12-2016
function populateHospital(){
	var districtId=document.getElementById("district").value;
    var instType=document.getElementById("instType").value;
	//alert("districtId "+districtId+" instType "+instType);
    var parameter="name='hospitalId' id='hospitalId'";
	//alert("districtId "+districtId+" instType "+instType);
	submitProtoAjaxWithDivName('template','/hms/hms/personnel?method=fillInstHospital&districtId='+districtId+'&instType='+instType+'&parameter='+parameter,'insHospital');
	
}//added by govind 27-12-2016 end

function getHospitalId(){
	var instName=document.getElementById("Institute").value;
	if(instName==""){
		document.getElementById("hospitalId").value=0;
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
              //  if(xmlHttp.responseXML.getElementsByTagName('items')[0]!=null){
	        	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
	        	
	        	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	  	   	    var item = chargeCodes.childNodes[loop];
	  	   	 
	  	   	 
	  	        var hospitalName  = item.getElementsByTagName("hospitalName")[0];
	  	        var hosid  = item.getElementsByTagName("hospitalId")[0]; 
	  	        var id= hosid.childNodes[0].nodeValue;			  	      
	  	    document.getElementById("hospitalId").value=id;
	  	       
	        	}
            	   }
               }
	        
	 
		var url='/hms/hms/generalMaster?method=getHospitalId&hospitalName='+instName+"&variable=Y";
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

		
	      }
	
}

window.onload=setDisable;
	      
/* function setDisable(){
	var userType=<%=userType%>;
	if(userType>2){
		var dist= document.getElementById("district").value;
		var ins= document.getElementById("instType").value;
		if(dist==0 || ins==0){
			document.getElementById("Institute").disabled = true;
		 }else{
			 document.getElementById("Institute").disabled = false; 
		 }
	}      
} */

function dropDownChange(){
	var dist= document.getElementById("district").value;
	var ins= document.getElementById("instType").value;
	if(dist>0 && ins>0){
	    document.getElementById("hospitalId").value=0;
		document.getElementById("Institute").value="";
		//document.getElementById("Institute").setAttribute('validate','Institution,String,yes');
	}else{
		document.getElementById("Institute").setAttribute('validate','Institution,String,no');
		document.getElementById("hospitalId").value=0;
	}
	 
}

</script>