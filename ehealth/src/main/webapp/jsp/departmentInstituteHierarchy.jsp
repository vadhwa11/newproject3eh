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
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.*" %>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hrms.masters.business.MstrDeptTaskMap"%>
<%@page import="jkt.hrms.masters.business.MstrTask"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.Users"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>	
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%List<MasDepartment> al1 = new ArrayList<MasDepartment>();
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<MasHospital> instituteList = new ArrayList<MasHospital>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasDepartment>   departmentList = new ArrayList<MasDepartment>();
	List<MasInstituteDepartment> instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
	List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
	List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	
	int hospitalId=0;
	hospitalId= (Integer)session.getAttribute("hospitalId");
	
	
	 if(map.get("searchDepartmentList")!=null){
		 departmentList=(List<MasDepartment>)map.get("searchDepartmentList");
		}
		if(map.get("instituteList")!=null){
			instituteList=(List<MasHospital>)map.get("instituteList");
			}
		
		 String shortName="";	 
		 int districtId = 0,instType=0;
			 for(MasHospital mh:instituteList){ 
				 if(hospitalId==mh.getId()){
				 shortName=mh.getShortName();
				 districtId=mh.getDistrict().getId();
				 instType=mh.getHospitalType().getId();
				 }
			 }
	
	 if(map.get("instituteDepartmentList")!=null){
		 instituteDepartmentList=(List<MasInstituteDepartment>)map.get("instituteDepartmentList");
	}
	 if(map.get("mhospitalTypetList")!=null){
		 mhospitalTypetList=(List<MasHospitalType>)map.get("mhospitalTypetList");
		}
	 if(map.get("mdistrictList")!=null){
		 mdistrictList=(List<MasDistrict>)map.get("mdistrictList");
		}
	 int userType=0;
	
		Users users=null;
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			userType=users.getUserType();
		}
%>



<div class="titleBg"> 
<h2>Service Centre Institute Hierarchy</h2>
</div>

<div class="clear"></div>

<form name="task" method="post" action="">
<div class="Block">

<%if(userType<=1){%>
<label>District</label>
<!--     <select name="district" id="district" onchange="populateInst('tempId');populateHospital();" validate="District,int,no"> -->
      <select name="district" id="district" validate="District,int,no" onchange="dropDownChange();">
             	<option value="0">Select</option>
                 	<%for(MasDistrict md:mdistrictList){ 
                 		if(districtId==md.getId()){%>  
                 		 <option value="<%=md.getId() %>" selected="selected"><%=md.getDistrictName()%></option>               		
                 		<%}else{ %>
            	 <option value="<%=md.getId() %>"><%=md.getDistrictName()%></option>
   					<%} }%>
	</select>
   					<%}else{ %>
   					
   					<input type="hidden" name="district" id="district" value="<%=districtId%>"/>
   					<%} %>
	
<%if(userType<=2){%>
	<label>Institute Type</label>
 <!--     <select name="instType" id="instType" onchange="populateHospital()" validate="Institute Type,int,no">-->
 
    <select name="instType" id="instType"  validate="Institute Type,int,no" onchange="dropDownChange();">
              	<option value="0">Select</option>
                 	<%for(MasHospitalType mht : mhospitalTypetList){ 
                 	if(instType==mht.getId()){
                 	%>
                <option value="<%=mht.getId() %>" selected="selected"><%=mht.getHospitalTypeName()%></option>
                 	<%}else{ %>
            	 <option value="<%=mht.getId() %>"><%=mht.getHospitalTypeName()%></option>
   					<%} }%>
	</select>
<%}%>
<div>
<%
if(userType==5){ // For PH admin
	List<Object[]> bsScInstList = new ArrayList<Object[]>();
	
	if(map.get("bsScInstList") != null){
		bsScInstList = (List<Object[]>)map.get("bsScInstList");
	}
%>
<label><span>* </span>Institute</label>
<div id="insHospital">
    <select name="Institute" id="hospitalId" onchange="populateTasks('tempId');abc1(this.value)" validate="Institute,int,yes">

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
	<script type="text/javascript">
function eventCallback(element, entry){
	return entry+"&districtId=" + document.getElementById('district').value+"&instType="+document.getElementById('instType').value;                                                                       
}
</script>

	 <label><span>* </span>Institute</label>
	<input type="text" name="instName" id="Institute" <%if(userType<=2){%> onblur="getHospitalId();" <%}%> value="<%=shortName%>" validate="Institution,string,yes">
				<div id="instDiv" style="display: none;"
												class="autocomplete"></div> 
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('Institute','instDiv','generalMaster?method=getHospitalListForAutoCompleteItem',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>
					<input type="hidden" name="Institute" id="hospitalId" value="<%=hospitalId%>">
					<%} %>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<label class="bgNone"></label>

 <label class="bgNone">Available Service Centre</label>
 <label class="bgNoneAuto" style="margin-left:268px;">To Be Assigned Service Centre</label>
 <div class="clear"></div>

<label class="bgNone"></label>
 <div id="inst">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3" style="margin-top:0;">
    <%for(MasDepartment md : departmentList){ %>
     <option value="<%=md.getId()%>"><%=md.getDepartmentName()%></option>
     <%} %>
</select>
</div>
<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />
<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>
</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3" style="margin-top:0;">
</select>
<div class="clear"></div>
<div class="paddingTop5"></div>
<label class="bgNone"></label>
<input type="button" class="button" name="Assign" value="Save" onclick="abc()" style="margin-left:350px;">  
<div class="clear"></div>
<div class="paddingTop5"></div>
</div>	

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</div>
</form>

<script>
function populateTasks(id)
{
	
	var hosId = document.getElementById("hospitalId").value;
	var sel = document.getElementById(id);
	removeAllOptions(sel);
	var sel1 = document.getElementById('mainGroupId');
	removeAllOptions(sel1);
		
	if(hosId!="All"){
	var size = <%=instituteDepartmentList.size()%>
	var sizeD = <%=departmentList.size()%>
		
			
			<%
			
			
			al1.clear();
			
			%> 
			<% int k=0;
			for(MasInstituteDepartment mid:instituteDepartmentList){%>
		
				if(<%=mid.getInstitute().getId()%> == hosId){<%
				if(mid.getStatus().equalsIgnoreCase("y")){k++;
				if(mid.getDepartment()!=null){//added by govind 20-12-2016
					al1.add(mid.getDepartment());
			%>
			
				optionRepMan = new Option("<%=mid.getDepartment().getDepartmentName()%>" , "<%=mid.getDepartment().getId()%>","true");				
				sel.options.add(optionRepMan);
					
			<%}}
			%>
				}
				<%}%>
			
				
		/* } */
		<%/* } */%>
		
		
		}

}

function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}

function confirmSubmit()
{
 var x = confirm('Are you sure , you want to assign selected companies to selected record ?');
 if(x)
 {
 submitForm('masters','mastersManagementController?method=assignMasters');
 }
 else
 {
 	return false;
 }
}

function hasOptions(obj) {
	if (obj!=null && obj.options!=null) { return true; }
	return false;
	}
function abc(){
	//var v=document.getElementById("mainGroupId").value;
	//alert(v)
	//submitForm('task','/hms/hms/systemRelatedMaster?method=saveDepartmentForInstitute&tempId='+v)
	submitForm('task','/hms/hms/systemRelatedMaster?method=saveDepartmentForInstitute')
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
		
		
function populateInst(id)
{
	var hosType=document.getElementById("instType").value; 
	var dist=document.getElementById("district").value;
	//alert(hosType+" "+dist)
	var sel = document.getElementById("Institute");
	removeAllOptions(sel);
		
	if(hosType!="0" && dist==0){
	var size = <%=instituteList.size()%>
	
			
			<%
			for(MasHospital mid:instituteList){%>
		
				if(<%=mid.getHospitalType().getId()%> == hosType){<%
				if(mid.getStatus().equals("y")){
			%>
				optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
				sel.options.add(optionRepMan);
					
			<%}
			%>
				}
				<%}%>
				optionRepMan = new Option("Select" , "0","true");
				sel.options.add(optionRepMan);
			
		}
	
	if(dist!="0" && hosType =="0"){
		var size = <%=instituteList.size()%>
	

				<%
				for(MasHospital mid:instituteList){%>
					<%if(mid.getDistrict()!=null){%>
					if(<%=mid.getDistrict().getId()%> == dist){<%
							if(mid.getStatus().equals("y")){
						%>
							optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
							sel.options.add(optionRepMan);
								
						<%}
						%>
						}
					<%}%>
					
					<%}%>
					optionRepMan = new Option("Select" , "0","true");
					sel.options.add(optionRepMan);
			}
	
	if(dist!="0" && hosType !="0"){
		var size = <%=instituteList.size()%>

				
				<%
				for(MasHospital mid:instituteList){%>
				<%if(mid.getDistrict()!=null){%>
						if(<%=mid.getDistrict().getId()%> == dist && <%=mid.getHospitalType().getId()%> == hosType){<%
							if(mid.getStatus().equals("y")){
						%>
							optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
							sel.options.add(optionRepMan);
								
						<%}
						%>
							}
				<%}%>
					<%}%>
					optionRepMan = new Option("Select" , "0","true");
					sel.options.add(optionRepMan);
			}
		
}

	function abc1(val){
		//alert("----"+val);
		/* submitProtoAjaxWithDivName('otBooking','/hms/hms/ot?method=fillStoreItem&rowVal=1','nomenclaturetd1'); */
		submitProtoAjaxWithDivName('task','/hms/hms/systemRelatedMaster?method=fillInst&Val='+val,'inst');
	}	
	//added by govind 20-12-2016
	function populateHospital(){
		var districtId=document.getElementById("district").value;
	    var instType=document.getElementById("instType").value;
		//alert("districtId "+districtId+" instType "+instType);
		submitProtoAjaxWithDivName('task','/hms/hms/systemRelatedMaster?method=fillInstHospital&districtId='+districtId+'&instType='+instType,'insHospital');
	}//added by govind 20-12-2016 end	
	
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
		  	populateTasks('tempId');
		  	abc1(id);
		        	}
	            	   }
	               }
		        
		 
	        var url='/hms/hms/generalMaster?method=getHospitalId&hospitalName='+instName+"&variable=Y";
		 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);

			
		
		
	}
	
	window.onload= callOnloadFunct;
	
function callOnloadFunct(){
	var hosId = document.getElementById("hospitalId").value;
	populateTasks('tempId');
  	abc1(hosId);
   }
   
   function dropDownChange(){
	   document.getElementById("hospitalId").value=0;
	   document.getElementById("Institute").value="";
   }
</script>



 