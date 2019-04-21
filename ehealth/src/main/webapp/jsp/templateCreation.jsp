<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasApplication"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.Users"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
 	List<MasApplication> moduleList = new ArrayList<MasApplication>();
	if(map.get("moduleList") != null){
		moduleList = (List<MasApplication>)map.get("moduleList");
	}
	
	List<MasTemplate> templateList = new ArrayList<MasTemplate>();
	if(map.get("templateList") != null){
		templateList = (List<MasTemplate>)map.get("templateList");
	}
	List<Object[]> departmentList = new ArrayList<Object[]>();
	if(map.get("departmentList") != null){
		departmentList = (List<Object[]>)map.get("departmentList");
	}
	List<Object[]> districtList = new ArrayList<Object[]>();
	if(map.get("districtList") != null){
		districtList = (List<Object[]>)map.get("districtList");
	}
	List<Object[]> templateModuleList=new ArrayList<Object[]>();
	if(map.get("tempModuleList") != null){
		templateModuleList = (List<Object[]>)map.get("tempModuleList");
	}
	
 	if (request.getAttribute("map") != null) 
	{
		map = (Map<String,Object>) request.getAttribute("map");
		
		
		if (map.get("templateId")!=null)
			template = Integer.parseInt(""+map.get("templateId"));
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
	int userType = 0; /* user type 4 for general user */
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
	System.out.println("hospitalid "+hospitalId);

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
	 
		/* if (map.get("instType") != null) {
			instType =(Integer)(map.get("instType"));
		} */
		
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
		 }
		
	/* 
	if(map.get("shortName")!=null){
		shortName = (String)map.get("shortName");
	} */
%>
<script>
function checkAll(){
 if(document.getElementById("chkStatus").value =="no"){
   document.getElementById("chkStatus").value ="yes"
   for(var i=1;i<=document.getElementById("countVal").value;i++){
    document.getElementById("apChk"+i).checked =true
    }
  }else{
    document.getElementById("chkStatus").value ="no"
   for(var i=1;i<=document.getElementById("countVal").value;i++){
    document.getElementById("apChk"+i).checked =false
    }
  }
  

}

function checkDepAll(){
  
   if(document.getElementById("chkStatus").value =="no"){
   	      document.getElementById("chkStatus").value = "yes"
   	      for(var i=1;i<=document.getElementById("countVal").value;i++){
   		   	document.getElementById("depChk"+i).checked =true
          }
          
          
   }else{
   		document.getElementById("chkStatus").value = "no"	
   		  for(var i=1;i<=document.getElementById("countVal").value;i++){
   		    	document.getElementById("depChk"+i).checked =false
          }
          
   }
   
 }
  </script>
  <script>
 function checkSelect(){

 if(document.getElementById("chkStatus1").value =="no"){
   document.getElementById("chkStatus1").value ="yes"
   for(var i=1;i<=document.getElementById("countVal1").value;i++){
    document.getElementById("chkButton"+i).checked =true
  }
  }else{
 document.getElementById("chkStatus1").value ="no"
   for(var i=1;i<=document.getElementById("countVal1").value;i++){
    document.getElementById("chkButton"+i).checked =false
  }
  }
}
</script>
<script>
function checkOrderNo(val,inc){	
	for(i=1;i<=inc;i++){
	          
		if(inc != i){
				if(document.getElementById('appOrderNo'+i) && document.getElementById('appOrderNo'+i).value==val) {
				alert("Order No. already selected...!")
				document.getElementById('appOrderNo'+inc).value=""
				var e=eval(document.getElementById('appOrderNo'+inc));
				e.focus();
				return false;
			}
		}
	}
	}
  function checkBlankTemplate(){
     	
        var template=document.getElementById('template').value;
       if(template==''){
       
          alert("Please Select the Template Name.")
          return false;
       }
     
       return true;
     }
     
     function checkBlankModule(){
     	
        var parentId=document.getElementById('parentId').value;
       if(parentId==''){
       
          alert("Please Select the Module Name.")
          return false;
       }
     
       return true;
     }
     
      function checkAssignModule(){
      var user = false;
      var app = false;
      var errmsg = "";
  		for(var i = 0; i < document.getElementsByName('appId').length; i++){
			  if(document.getElementsByName('appId')[i].checked == true)
              {
				app = true;
			  }		
  		}
  		if(!app){
  		errmsg = errmsg + "\n Please select Atleast One Application";
  		}
  		if(errmsg != ""){
  		alert(errmsg);
  		return false;
  		}else{
  		return true;
  		}
  		
  		return false;
  
  }
  
  
  function displayApplication(){
				
				document.getElementById('Application').style.display = 'inline';
				document.getElementById('testdiv1').style.display = 'inline';
				document.getElementById('Button-rights').style.display = 'none';
				document.getElementById('indentDiv').style.display = 'none';
				document.getElementById('departmentDiv').style.display = 'none';
				
				
				
 }
 function displayButtonRight(){
				
				document.getElementById('Button-rights').style.display = 'inline';
				document.getElementById('Application').style.display = 'none';
				document.getElementById('testdiv1').style.display = 'none';
				document.getElementById('indentDiv').style.display = 'inline';
				document.getElementById('departmentDiv').style.display = 'none';
				
 }
 function displayDepartment(){
				
				document.getElementById('departmentDiv').style.display = 'inline';
				document.getElementById('Button-rights').style.display = 'none';
				document.getElementById('Application').style.display = 'none';
				document.getElementById('testdiv1').style.display = 'none';
				document.getElementById('indentDiv').style.display = 'none';
				
 }
			
			


</script>

<form name="assignApplicationForm" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="contentHolder">
<% 
			if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
		  <h4><%=message%></h4>
<%		   
		  }
%>
<div class="titleBg">
<h2>Template Assignment</h2>
</div>
<div class="Block">
<%	
//if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin") || ){ 
if(userType<=1){ /* useryType<2 means state admin and jktadmin  */
%>
	
	<label>District</label>
<!-- 	<select name="districtId" id="districtId" onchange="submitProtoAjaxWithDivName('assignApplicationForm','/hms/hms/user?method=getDistrictWiseHospital&formName=assignApplicationForm','hospitalDiv')" tabindex="1"> -->
	<select name="districtId" id="districtId"  tabindex="1" onchange="dropDownChange();" onblur="dropDownChange();">
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
			<input type="hidden" name="districtId" id="districtId" value="<%=districtId%>"/>
		<%} %>
		<%if(userType<=2){ %>
		<label>Institute Type</label>
 <!--      <select name="instType" id="instType" onchange="populateHospital()" validate="Institute Type,int,no">-->
 <div>
    <select name="instType" id="instType" validate="Institute Type,int,no" onchange="dropDownChange();" onblur="dropDownChange();" tabindex="1">
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
//alert("group-=="+document.getElementById('itemGroupId').value);
	return entry+"&districtId=" + document.getElementById('districtId').value+"&instType="+document.getElementById('instType').value;                                                                       
}
</script>
<div id="hospitalDiv">
<% if(userType<3){ %>
	<label>Institution</label>
<!-- 	<select name="hospitalId" id="hospitalId" onchange="submitProtoAjax('assignApplicationForm','/hms/hms/user?method=getTemplateForHospital')" tabindex="1"> -->
<%-- 	<% --%>
<!-- // 		for(Object[] obj : hospitalList){ -->
<!-- // 			if(hospitalId== Integer.parseInt(obj[0].toString())){ -->
<%-- 	%> --%>
	
<%-- 	<option value="<%=obj[0]%>" selected="selected"><%=obj[1].toString().trim() %></option> --%>
<%-- 	<%}else{ %> --%>
<%-- 	<option value="<%=obj[0]%>"><%=obj[1].toString().trim() %></option> --%>
<%-- 	<%} --%>
<!-- // 		} -->
<%-- 			%> --%>
<!-- 	</select> -->

     <input type="text" name="instName" id="Institute"  <%if(userType<=2){%>onblur="getHospitalId();"<%}%> value="<%=shortName%>"  tabindex="1">
				<div id="instDiv" style="display: none;"
												class="autocomplete"></div> 
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('Institute','instDiv','generalMaster?method=getHospitalListForAutoCompleteItem',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>
	<input type="hidden" name="hospitalId" id="hospitalId" value="<%=hospitalId %>">
	</div>
	<%}else{ %>
		<input type="hidden" id="hospitalId" name="hospitalId" value="<%=session.getAttribute("hospitalId") %>">
	<%} %>
	<%} %>
<label>Role Name <span>*</span></label>
<div id="testDiv">
 <select name="<%=TEMPLATE %>" id="<%=TEMPLATE %>" value=""
	maxlength="" 
	onchange="if(checkBlankTemplate()){submitFormForButton('assignApplicationForm','user?method=showTemplateModulesJsp');}"
	tabindex="1" >
	<option value="">Select Template Name</option>
	
	<%
	
				Iterator iter1=templateList.iterator();
				while(iter1.hasNext()){
	    	MasTemplate masTemplate= (MasTemplate) iter1.next();
			int templateId=masTemplate.getId();
			if(userType==1){
				if(masTemplate.getHospital()==null){
					if(template == templateId && template != 0){ 	%>
			<option value="<%=templateId%>" selected="selected"><%=masTemplate.getTemplateName()%></option>
			<% }else{ %>
			<option value="<%=masTemplate.getId()%>"><%=masTemplate.getTemplateName()%></option>
			<% }
				}
				if(masTemplate.getHospital()!=null){//added by govind 21-08-2017
					if(template == templateId && template != 0){ 	%>
			<option value="<%=templateId%>" selected="selected"><%=masTemplate.getTemplateName()%></option>
			<% }else{ %>
			<option value="<%=masTemplate.getId()%>"><%=masTemplate.getTemplateName()%></option>
			<% }
					
				}//added by govind 21-08-2017 end
					
			}else{
			if(masTemplate.getHospital()!=null && masTemplate.getHospital().getId()==hospitalId){
			if(template == templateId && template != 0){ 	%>
	<option value="<%=templateId%>" selected="selected"><%=masTemplate.getTemplateName()%></option>
	<% }else{ %>
	<option value="<%=masTemplate.getId()%>"><%=masTemplate.getTemplateName()%></option>
	<% }
			}
			}   
			}%>
</select>
</div>
<!-- <input type="button" name="application"   value="Application" tabindex="1" class="buttonBig" onClick="displayApplication();" /> -->
<!--<input type="button" name="button-right"  value="Buttons Right" tabindex="1" class="buttonBig" onClick="displayButtonRight();" />
<input type="button" name="Department"    value="Department" tabindex="1" class="buttonBig" onClick="if(checkBlankTemplate()){submitProtoAjaxWithDivName('assignApplicationForm','user?method=getDepartmentListForTemplate','departmentDiv');displayDepartment();}" />-->

<div id="Application" >
<label>Module Name <span>*</span></label>
<select name="parentId" id="parentId" class="large2"	onchange="if(checkBlankTemplate()){submitProtoAjaxWithDivName('assignApplicationForm','user?method=getApplicationListForTemplate','testdiv1');}" tabindex="1">
	<option value="">Select Application Name</option>
	<!-- to display application list -->
	<%
				Iterator iter=moduleList.iterator();
				while(iter.hasNext()){
	    	MasApplication masApp= (MasApplication) iter.next();
			String parentId=masApp.getId();
			%>
	<option value="<%=parentId%>"><%=masApp.getName()%></option>
	<% 			
				}
			%>
</select> 
</div>

<div class="Clear"></div>
<div id="Button-rights" style="display: none;">
<%--<label>Button Rights For The Form:</label>
<select name="formName" id="formName" class="large2" onchange="if(checkBlankTemplate()){submitProtoAjaxforIndent('assignApplicationForm','user?method=getButtonListForForm','indentDiv');}">>
	<option value="0">Select</option>

	<%
	
	Iterator iter3=formList.iterator();
	
	while(iter3.hasNext()){
    	String formName= (String) iter3.next();
    	
			%>
	<option value="<%=formName%>"><%=formName%></option>


	<% 			
				}
			%>

</select>
--%></div>

<label>Service Centre <span>*</span></label>
<select name="departmentId" id="departmentId" class="multiple" multiple="multiple" tabindex="1" validate="Service Centre,metachar,yes">
	<%
	    	for(Object[] dept : departmentList){
			%>
	<option value="<%=dept[0]%>"><%=dept[1]%></option>
	<% 			
				}
			%>
</select> 

<% if(template != 0){ %>
<div class="Clear"></div>
<div class="cmntable">
<table cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="15">Sl No.</th>
			<th>Assigned Modules</th>
		</tr>
	</thead>
	<tbody id="searchresulttable">
		<%	int i=0;
	   for(Object[] templateModules : templateModuleList){
		   ++i;
		   %>
		<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
			<td><%=i%></td>
			<td><%=templateModules[2]%></td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<div class="clear"></div>
<% } %>

<div class="clear"></div>
<div id="testdiv1"></div>
</div>
</div>

<input type="hidden" id="hositalStatus" name="hositalStatus" value="0"/>
</form>

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
              //  if(xmlHttp.responseXML.getElementsByTagName('items')[0]!=null){
	        	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
	        	
	        	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	  	   	    var item = chargeCodes.childNodes[loop];
	  	   	 
	  	   	 
	  	        var hospitalName  = item.getElementsByTagName("hospitalName")[0];
	  	        var hosid  = item.getElementsByTagName("hospitalId")[0]; 
	  	        var id= hosid.childNodes[0].nodeValue;			  	      
	  	    document.getElementById("hospitalId").value=id;
	  	     // selectHospital(id);
	  	    submitProtoAjax('assignApplicationForm','/hms/hms/user?method=getTemplateForHospital');
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
function dropDownChange(){
	var dist= document.getElementById("districtId").value;
	var ins= document.getElementById("instType").value;
	if(dist>0 && ins>0){
	    document.getElementById("hospitalId").value=<%=hospitalId %>;
		document.getElementById("Institute").value="";
		//document.getElementById("Institute").setAttribute('validate','Institution,String,yes');
	}else{
		document.getElementById("Institute").setAttribute('validate','Institution,String,no');
		document.getElementById("hospitalId").value=<%=hospitalId %>;
	}
	 
}

</script>
