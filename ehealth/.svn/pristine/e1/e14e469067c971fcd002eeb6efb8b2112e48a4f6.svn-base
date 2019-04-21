<%--
 * Copyright 2011 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showUserAssinedTemplet.jsp  
 * Purpose of the JSP   This is for Assigned Templet To User 
 * @author  Mukesh Narayan Singh
 * Create Date: 1st Jun,2012 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@page import="jkt.hms.masters.business.UserSpecialityTemplate"%>
<%@page import="org.springframework.security.core.userdetails.User"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasSpecialtyTemplate"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<script lang="javascript" src="/hms/jsp/js/csrfToken.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
		

		
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script src="/hms/jsp/js/jquery1.min.js"></script>
<script src="/hms/jsp/js/jquery.ba-throttle-debounce.min.js"></script>
<script src="/hms/jsp/js/jquery.stickyheader.js"></script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasSpecialtyTemplate> specialityTemplateList = new ArrayList<MasSpecialtyTemplate>();
	List<UserSpecialityTemplate> userSpecialityTemplateList = new ArrayList<UserSpecialityTemplate>();
	List<Users> userList = new ArrayList<Users>();
	
	if(map.get("userList")!=null){
		userList =(List) map.get("userList");
	}
	if(map.get("specialityTemplateList")!=null){
		specialityTemplateList =(List) map.get("specialityTemplateList");
	}
	if(map.get("userSpecialityTemplateList")!=null){
		userSpecialityTemplateList =(List) map.get("userSpecialityTemplateList");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
	}
	
	Box box = HMSUtil.getBox(request);
	int empCatId =  box.getInt("empCatId");
	
	String penNo = box.getString("penNo");
	%>


<form name="showUserAssinedTemplet" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<%
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>

<div class="titleBg"><h2>User Speciality Template</h2>
</div>

<div class="Clear"></div>
<div class="floatRight"><input type="button" name="assignTemplate" value="Assign Speciality Template"	
class="buttonBig"	onClick="submitForm('showUserAssinedTemplet','generalMaster?method=saveUserSpecialityTemplate&'+csrfTokenName+'='+csrfTokenValue);" /></div>
<div class="Clear"></div>
<div id="divEmployee">

<div class="Clear"></div>
<table>
<tr>
</tr>
</table>
<!-- <div class="cmntableHeight"> -->
<div class="userRights">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<thead>
	<tr>
	<%
	
	if(specialityTemplateList.size()>0){
		
		%>
		<th>Name</th>
		<%
		
		for(MasSpecialtyTemplate masTemplate :specialityTemplateList){
			
	%>
	<!-- day+"/"+month+"/"+year -->
	<th><%=masTemplate.getTemplateName()%></th>
	 <%
	}
	}
	
	%> 
	</tr>
	</thead>
	<tbody>
	
	<%
	int counter=0;
	int chgCnt = 0;
	if(userList.size()>0){
		//for(MasEmployee masEmployee:masEmployeeList){
			for (Users user : userList) {
				
				//if (user.getEmployee().getRank().getRankName().equalsIgnoreCase("Doctor")) {
			
			++counter;
			String employeeName="";
			String EmployeeCode = "";
			
			
				if(user.getEmployee()!=null)
				{
					//EmployeeCode = user.getEmployee().getEmployeeCode();
					EmployeeCode = user.getLoginName();
				}
			if(user.getEmployee().getEmployeeName()!=null){
				employeeName = user.getEmployee().getEmployeeName();
			}else{
				employeeName=employeeName+" "+user.getEmployee().getFirstName();
				if(user.getEmployee().getMiddleName()!=null){
					employeeName=employeeName+" "+user.getEmployee().getMiddleName();
				}
				if(user.getEmployee().getLastName()!=null){
					employeeName=employeeName+" "+user.getEmployee().getLastName();
				}
			}
			String toolTip="";
			toolTip=employeeName;
	%>
		<tr>
		<%  
			if(EmployeeCode != null && !EmployeeCode.equals(""))
			{
				%>
					<th><%=employeeName %>  (<%=EmployeeCode %>)
				<%
			}
			else
			{
				%>
					<th><%=employeeName %>
				<%
			}
		%>
			
			<input type="hidden" name="empId<%=counter%>" id="empId<%=counter%>" value="<%=(user.getEmployee()!=null?user.getEmployee().getId():"0")%>" />
			<input type="hidden" name="userId<%=counter%>" id="userId<%=counter%>" value="<%=user.getId()%>" />
			
			</th>
		<%
		int templetCnt=0;
		int preTempletId=0;
		if(specialityTemplateList.size()>0){
			for(MasSpecialtyTemplate masTemplate :specialityTemplateList){
				++templetCnt;
				boolean assignedTemplate=false;
				String assignedTemplateName="";
				assignedTemplateName=masTemplate.getTemplateName();
				preTempletId = masTemplate.getId();
				if(userSpecialityTemplateList.size()>0){
					int templateIdMain=masTemplate.getId();
					
					for(UserSpecialityTemplate userTemplate:userSpecialityTemplateList){
						int templateIdTemp=0;
						
							templateIdTemp=userTemplate.getTemplate().getId();
						
						
						if(userTemplate.getUser().getId().equals(user.getId()) && templateIdTemp==templateIdMain){
							preTempletId=userTemplate.getTemplate().getId();
							assignedTemplate=true;
							break;
						}
					}
				}
				assignedTemplateName=toolTip+" # "+assignedTemplateName+" "; 
		%>
		<td align="center" title="<%=assignedTemplateName%>">
		<%if(assignedTemplate){ %>
		<input type="checkbox" checked="checked" name="templetId<%=templetCnt%>" id="templetId<%=templetCnt%><%=counter%>" value="<%=masTemplate.getId()%>"  onclick="setHiddenTempId(this,<%=templetCnt%><%=counter%>,'<%=masTemplate.getTemplateName() %>',<%=chgCnt %>)"/>
		<input type="hidden" name="templetIdHidden<%=counter%>" id="<%=masTemplate.getTemplateName() %><%=templetCnt%><%=counter%>" value="<%=masTemplate.getId()%>" />
		<%}else{ %>
	
		<input type="checkbox"  name="templetId<%=templetCnt%>" id="templetId<%=templetCnt%><%=counter%>" value="<%=masTemplate.getId()%>" onclick="setHiddenTempId(this,<%=templetCnt%><%=counter%>,'<%=masTemplate.getTemplateName() %>',<%=chgCnt %>)" />
			<input type="hidden" name="templetIdHidden<%=counter%>" id="<%=masTemplate.getTemplateName() %><%=templetCnt%><%=counter%>" value="0" />
	<%} %>
	 	<input type="hidden" name="preTempletId<%=counter%>" id="preTempletId<%=templetCnt%><%=counter%>" value="<%=preTempletId%>" />
		<input type="hidden" name="changeFlag<%=counter%>" id="changeFlag<%=chgCnt %><%=templetCnt%><%=counter%>" value="no" />
	</td>
		<%
		}
		}
		%>			
		</tr>
		
	<%		
		chgCnt++;//}
				}
	}
	%>
	</tbody>

</table>
	<input type="hidden" name="counter" id="counter" value="<%=counter%>" />
	<input type="hidden" name="templetCnt" id="templetCnt" value="<%=specialityTemplateList.size()%>" />

</div>
</div>


</form>

<script>
function setHiddenTempId(obj,cnt,fieldName,chgCnt){
	if(obj.checked){
		
		document.getElementById(fieldName+cnt).value=obj.value;
	}else{
		document.getElementById(fieldName+cnt).value=0;
		}
	document.getElementById('changeFlag'+chgCnt+cnt).value='yes';
}

function searchEmp(){
	var hId = document.getElementById('hospitalId').value;
	var val = document.getElementById('penNo').value;
	submitForm('showUserAssinedTemplet','/hms/hms/user?method=searchEmployeeForUserRights');
}

//added by govind 25-12-2016
function populateHospital(){
    var districtId =document.getElementById('districtId').value; 
	var hospitalTypeId=document.getElementById('instType').value; 
	
	//alert("districtId "+districtId+" hospitalTypeId "+hospitalTypeId);
	   
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
	     obj =document.getElementById("hospitalId");
	     removeAllOptions(obj);
	     obj.length = 1;
	      xmlHttp.onreadystatechange=function()
	      {
	      	
	        if(xmlHttp.readyState==4){
              //  if(xmlHttp.responseXML.getElementsByTagName('items')[0]!=null){
	        	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
	        	
	        	
	        	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	  	   	    var item = chargeCodes.childNodes[loop];
	  	   	 
	  	   	 
	  	        var hospitalName  = item.getElementsByTagName("hospitalName")[0];
	  	        var hosid  = item.getElementsByTagName("hospitalId")[0];
	  	       
	  	        
	  	        obj.length++;
	  	        
	  	       
	  	        obj.options[obj.length-1].text= hospitalName.childNodes[0].nodeValue
	  				obj.options[obj.length-1].value= hosid.childNodes[0].nodeValue
	  	       
	  	       
	        	}
//                }else{
//             	   optionRepMan = new Option("Select" , "0","true");
//    				   obj.options.add(optionRepMan);
//                }
            	   }
               }
	        
	 
	    var url='/hms/hms/pubHealth?method=fillDataForDistrictHospitalType&districtId='+districtId+'&hospitalTypeId=' + hospitalTypeId;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

		
	
	
}

function removeAllOptions(selectbox)
{
	var i;
	for(i=selectbox.options.length-1;i>=0;i--)
	{
		selectbox.remove(i);
	}
}

//added by govind 25-12-2016 end

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