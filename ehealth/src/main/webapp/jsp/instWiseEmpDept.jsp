<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * DepartmentTaskMap.jsp  
 * Purpose of the JSP -  This is for Rating Details.
 * @author  Vishal
 * Create Date: 15th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>

<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.HrInstEmpDept"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.*" %>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>

<script>jQuery.noConflict();</script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<HrInstEmpDept>   searchHrInstEmpDeptList = new ArrayList<HrInstEmpDept>();
	List<MasEmployeeDepartment> empDeptList = new ArrayList<MasEmployeeDepartment>();
	List<MasHospital>   instituteList = new ArrayList<MasHospital>();
	List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
	String userName = "";
	int hrInsitEmpDepId=0;
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	

	
	
	 if(map.get("searchHrInstEmpDeptList")!=null){
		 searchHrInstEmpDeptList=(List<HrInstEmpDept>)map.get("searchHrInstEmpDeptList");
		}
		if(map.get("instituteList")!=null){
			instituteList=(List<MasHospital>)map.get("instituteList");
			}

	

	 if(map.get("empDeptList")!=null){
		 empDeptList=(List<MasEmployeeDepartment>)map.get("empDeptList");
		}
	 
	 if(map.get("employeeDepartmentList")!=null){
		 employeeDepartmentList=(List<MasEmployeeDepartment>)map.get("employeeDepartmentList");
	}
	 if(map.get("hrInsitEmpDepId")!=null){
		 hrInsitEmpDepId=(Integer)map.get("hrInsitEmpDepId");
	} 
	 
	 
	 String hospitalName="",shortName="";	 
	 
		int hospitalId=0;
		int districtId = 0,instType=0;
		hospitalId= (Integer)session.getAttribute("hospitalId");
		
		 for(MasHospital mh:instituteList){ 
			 hospitalName=mh.getHospitalName();
			 if(hospitalId==mh.getId()){
			 shortName=mh.getShortName();
			 districtId=mh.getDistrict().getId();
			 instType=mh.getHospitalType().getId();
			 }
		 }
		 
		List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		 if(map.get("mhospitalTypetList")!=null){
			 mhospitalTypetList=(List<MasHospitalType>)map.get("mhospitalTypetList");
			}
		 if(map.get("mdistrictList")!=null){
			 mdistrictList=(List<MasDistrict>)map.get("mdistrictList");
			}
		 
		 
		 int userType=0;
		 if(map.get("userType")!=null){
			 userType=(Integer)map.get("userType");
			}
%>



<div class="titleBg"> 
<h2> Institute Wise Employee Department</h2>
</div>

<div class="clear"></div>

<form name="task" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<%if(userType<=1){%>
<label>District</label>
    <select name="district" id="district"  onchange="dropDownChange();" validate="District,int,no">
        	<option value="0">Select</option>
                 	<%for(MasDistrict md:mdistrictList){ 
                 		if(districtId==md.getId()){%>  
                 		 <option value="<%=md.getId() %>" selected="selected"><%=md.getDistrictName()%></option>               		
                 		<%}else{ %>
            	 <option value="<%=md.getId() %>"><%=md.getDistrictName()%></option>
   					<%}} %>
	</select>
	<%}else{
		%>
			<input type="hidden" name="district" id="district" value="<%=districtId%>"/>
		<%} %>
		<%if(userType<=2){ %>
	<label>Institute Type</label>
 <!--     <select name="instType" id="instType" onchange="populateInst('tempId')" validate="Institute Type,int,no">-->

    <select name="instType" id="instType"  onchange="dropDownChange();" validate="Institute Type,int,no">
                	<option value="0">Select</option>
                 	<%for(MasHospitalType mht : mhospitalTypetList){ 
                 	if(instType==mht.getId()){
                 	%>
                <option value="<%=mht.getId() %>" selected="selected"><%=mht.getHospitalTypeName()%></option>
                 	<%}else{ %>
            	 <option value="<%=mht.getId() %>"><%=mht.getHospitalTypeName()%></option>
   					<%} }%>
	</select>
<%}else{%>
<input type="hidden" name="instType" id="instType" value="<%=instType%>"/>
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
    <select name="instId" id="instId" onchange="selectHospital(this.value)" validate="Institute,int,yes">

             	<option value="0">Select</option>
                 	<%for(Object[] mh:bsScInstList){ 
                 		if(hospitalId == (Integer)mh[0]){
                 	%>
                 	 <option value="<%=mh[0] %>" selected="selected"><%=mh[1]%></option>
                 	<%}else{ %>
            	 <option value="<%=mh[0] %>"><%=mh[1]%></option>
   					<%} } %>
	</select>
	<%}else{ %>
<label><span>* </span>Institute</label>

<script type="text/javascript">
function eventCallback(element, entry){
//alert("group-=="+document.getElementById('itemGroupId').value);
	return entry+"&districtId=" + document.getElementById('district').value+"&instType="+document.getElementById('instType').value;                                                                       
}
</script>
<input type="text" name="instName" id="Institute" <%if(userType<=2){%> onblur="getHospitalId();"<%}%> value="<%=shortName%>" validate="Institution,string,yes">
				<div id="instDiv" style="display: none;"
												class="autocomplete"></div> 
				<%if(userType<=2){%>
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('Institute','instDiv','generalMaster?method=getHospitalListForAutoCompleteItem',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>
				<%}%>
					<input type="hidden" name="instId" id="hospitalId" value="<%=hospitalId%>">
					<%} %>
<div class="clear"></div>
<div class="paddingTop5"></div>
<label class="bgNone"></label>
<label class="bgNone"> Department</label>
<label class="bgNoneAuto" style="margin-left:268px;">To Be Assigned Employee Department</label>
<div class="clear"></div> 

<label class="bgNone"></label>
<div id="inst">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3" style="margin-top:0;">
    <%for(MasEmployeeDepartment md : empDeptList){ %>
     <option value="<%=md.getId()%>"><%=md.getEmpDeptName()%></option>
     <%} %>
</select>

<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />
<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>
</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3" style="margin-top:0;">
<%if(employeeDepartmentList.size()>0){ %>
       <%for(MasEmployeeDepartment d : employeeDepartmentList){ %>
            	 <option value="<%=d.getId()%>" selected="selected"><%=d.getEmpDeptName()%></option>
   					<%} %>
   					<%} %>
</select>
<div class="clear"></div>
<div class="paddingTop5"></div>
<label class="bgNone"></label>
<%if(employeeDepartmentList.size()>0){ %>

  <input type="hidden" value="<%=hrInsitEmpDepId%>" name="hrInsitEmpDepId"/>
  <input type="button" class="button" style="margin-left:350px;" name="Assign" value="Save" onclick="if(chk()){submitForm('task','/hms/hms/generalMaster?method=saveInstWiseEmpDept&flag=u');}">
  <%}else{ %>
    <input type="hidden" value="0" name="hrInsitEmpDepId"/>
  <input type="button" class="button" style="margin-left:350px;" name="Assign" value="Add Move" onclick="if(chk()){submitForm('task','/hms/hms/generalMaster?method=saveInstWiseEmpDept&flag=s');}">
<% }%> 
</div>
 <div class="clear"></div>
</div>

</div>	
</form>

<script>
function selectHospital(val){
	
	submitProtoAjaxWithDivName('task','/hms/hms/generalMaster?method=fillHospital&Val='+val,'inst');
}	
function removeAllOptions(selectbox)
{
	var i;
	for(i=selectbox.options.length-1;i>=0;i--)
	{
		selectbox.remove(i);
	}
}
function chk() {
	var s = document.getElementById("tempId").value;

	if (s==""){ 
	alert("Please Choose Select List of Employee Department");
	return false;
	}
	return true;
}

function hasOptions(obj) {
	if (obj!=null && obj.options!=null) { return true; }
	return false;
	}
	
function copySelectedOptions() {
	   from =document.getElementById("mainGroupId")
	   to =document.getElementById("tempId")
		var options = new Object();
		if (hasOptions(to)) {
			for (var i=0; i<to.options.length; i++) {
				options[to.options[i].value] = to.options[i].text;
				to.options[i].selected=true;
				}
			}
		if (!hasOptions(from)) { return; }
		for (var i=0; i<from.options.length; i++) {
			var o = from.options[i];
			if (o.selected) {
				if (options[o.value] == null || options[o.value] == "undefined" || options[o.value]!=o.text) {
					if (!hasOptions(to)) { var index = 0; } else { var index=to.options.length; }
					to.options[index] = new Option( o.text, o.value, true, false);
					to.options[index].selected=true;
					}
				}
			}
		if ((arguments.length<3) || (arguments[2]==true)) {
			sortSelect(to);
			}
		from.selectedIndex = -1;
		to.selectedIndex = -1;
		var objTemp = document.getElementById("tempId");
		for (var k=0; k<objTemp.options.length; k++) {
			objTemp.options[k].selected=true;
			}
		}
		
	function removeSelectedOptions() {
	 from =document.getElementById("tempId") 
		if (!hasOptions(from)) { return; }
		if (from.type=="select-one") {
			from.options[from.selectedIndex] = null;
			}
		else {
			for (var i=(from.options.length-1); i>=0; i--) { 
				var o=from.options[i]; 
				if (o.selected) { 
					from.options[i] = null; 
					} 
				}
			}
		from.selectedIndex = -1; 
		} 	
		
		function getHospitalId(){
			var instName=document.getElementById("Institute").value;
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
			  	      selectHospital(id);
			  	       
			        	}
		            	   }
		               }
			        
			 
		        var url='/hms/hms/generalMaster?method=getHospitalId&hospitalName='+instName+"&variable=Y";
			 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

			    xmlHttp.open("GET",url,true);
			    xmlHttp.setRequestHeader("Content-Type", "text/xml");
			    xmlHttp.send(null);

				
			
			
		}
		
		 function dropDownChange(){
			   document.getElementById("hospitalId").value=0;
			   document.getElementById("Institute").value="";
		   }
</script>



 