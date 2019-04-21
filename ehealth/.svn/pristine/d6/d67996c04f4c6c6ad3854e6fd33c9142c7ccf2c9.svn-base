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
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>


<%@page import="jkt.hms.masters.business.UserTemplate"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<script lang="javascript" src="/hms/jsp/js/csrfToken.js" type="text/javascript"></script>
			
<script src="/hms/jsp/js/jquery1.min.js"></script>
<script src="/hms/jsp/js/jquery.ba-throttle-debounce.min.js"></script>
<script src="/hms/jsp/js/jquery.stickyheader.js"></script>	
<script>var $j = jQuery.noConflict();</script>
<script type="text/javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
		
<%
	Map<String, Object> map = new HashMap<String, Object>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	 List<Object[]> masEmployeeList = new ArrayList<Object[]>();
	List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
	
	if(map.get("masEmployeeList")!=null){
		masEmployeeList =(List) map.get("masEmployeeList");
		
	}
	if(map.get("masTemplateList")!=null){
		masTemplateList =(List) map.get("masTemplateList");
	}
	
	List<UserTemplate> userTemplateList = new ArrayList<UserTemplate>();
	if(map.get("userTemplateList")!=null){
		userTemplateList =(List) map.get("userTemplateList");
	} 
	List<Object[]> districtList = new ArrayList<Object[]>();
	if(map.get("districtList") != null){
		districtList = (List<Object[]>)map.get("districtList");
	}
	List<Object[]> hospitalList = new ArrayList<Object[]>();
	if(map.get("hospitalList")!=null){
		hospitalList = (List<Object[]>)map.get("hospitalList");
	}
	List<Object[]> masEmpCatList = new ArrayList<Object[]>();
	if(map.get("masEmpCatList")!=null){
		masEmpCatList = (List<Object[]>)map.get("masEmpCatList");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
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
	}else if(session.getAttribute("hospitalId")!=null){
		hospitalId= (Integer)session.getAttribute("hospitalId");
	}
	int districtId = 0;
	if(map.get("districtId")!=null){
		districtId = (Integer)map.get("districtId");
	}else if(session.getAttribute("districtId")!=null){
		districtId = (Integer)session.getAttribute("districtId");
	}
	Box box = HMSUtil.getBox(request);
	int empCatId =  box.getInt("empCatId");
	
	String penNo = box.getString("penNo");
	
	List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
	 if(map.get("mhospitalTypetList")!=null){
		 mhospitalTypetList=(List<MasHospitalType>)map.get("mhospitalTypetList");
		}
	 
	 int insType=0;
	 /* if(map.get("insType")!=null){
		 insType = (Integer)map.get("insType");
		} */
		insType =  (Integer)session.getAttribute("hospitalTypeId");
	 System.out.println("insType jsp "+insType+" hospitalId "+hospitalId);
	 
	 String hospitalName="",shortName="";	 
	 for(Object[] obj : hospitalList){
	if(hospitalId== Integer.parseInt(obj[0].toString())){
		shortName=obj[2].toString();
		break;
	}
	 }
		System.out.println("shortName--"+shortName); 
	%>


<%@page import="jkt.hms.masters.business.MasDepartment"%>


<form name="showUserAssinedTemplet" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<%
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>

<div class="titleBg"><h2>User Rights</h2>
</div>
<div class="Block">
<div class="clear"></div>
<%	
//if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin") || ){ 
if(userType<=1){ /* useryType<2 is state admin and jktadmin  */
%>
	
	<label>District</label>
<!-- 	<select name="districtId" id="districtId" onchange="populateHospital();" tabindex="1"> -->
	<select name="districtId" id="districtId" tabindex="1" onchange="dropDownChange();" onblur="dropDownChange();" tabindex="1">
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
<%}else{ %>
	
	<input type="hidden" name="district" id="districtId" value="<%=districtId%>"/>
	<%} %>	
	
	<%if(userType<=2){ %>
		<!-- added by govind 25-02-2017  -->
	<label>Institute Type</label>
<!-- 	    <select name="instType" id="instType" onchange="populateHospital();" validate="Institute Type,int,no"> -->
	    	    <select name="instType" id="instType"  validate="Institute Type,int,no" onchange="dropDownChange();" onblur="dropDownChange();" tabindex="1">
             	<option value="0">Select</option>
                 	<%for(MasHospitalType mht : mhospitalTypetList){ %>
                 	<%if(insType==mht.getId()){ %>
            	 <option value="<%=mht.getId() %>" selected="selected"><%=mht.getHospitalTypeName()%></option>
   					<%}else{ %>
   					<option value="<%=mht.getId() %>"><%=mht.getHospitalTypeName()%></option>
   						<%} }%>
	</select>
	<!-- added by govind 25-02-2017  end-->
	<%} 
	
	
	if(userType==5){ // For PH admin
	List<Object[]> bsScInstList = new ArrayList<Object[]>();
	
	if(map.get("bsScInstList") != null){
		bsScInstList = (List<Object[]>)map.get("bsScInstList");
	}
%>

<label><span>* </span>Institute</label>
<div id="insHospital">
    <select name="hospitalId" id="hospitalId" validate="Institute,int,yes">

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

<%if(userType<3){ %>

	<label>Institution</label>


	<input type="text" name="instName" id="Institute" <%if(userType<=2){%>onblur="getHospitalId();"<%}%> value="<%=shortName%>" validate="Institution,string,yes" tabindex="1">
				<div id="instDiv" style="display: none;"
												class="autocomplete"></div> 
							<script type="text/javascript" language="javascript">
							  new Ajax.Autocompleter('Institute','instDiv','generalMaster?method=getHospitalListForAutoCompleteItem',{minChars:3,parameters:'requiredField=instName',callback: eventCallback});
					</script>					
			
					<input type="hidden" name="hospitalId" id="hospitalId" value="<%=hospitalId%>">
	<%}else{ %>
		<input type="hidden" id="hospitalId" name="hospitalId" value="<%=session.getAttribute("hospitalId") %>">
	<%} %>
	<%} %>
	</div>
<label>Employee Category</label>
<select name="empCatId" id="empCatId"  tabindex="1">
	<option value="0">Select</option>
	<%
		for(Object[] obj : masEmpCatList){
			if(empCatId== Integer.parseInt(obj[0].toString())){
	%>
	
	<option value="<%=obj[0]%>" selected="selected"><%=obj[1].toString().trim() %></option>
	<%}else{ %>
	<option value="<%=obj[0]%>"><%=obj[1].toString().trim() %></option>
	<%}
		}
			%>
			
</select>
			
<label>PEN No.</label>
<input type="text" id="penNo" name="penNo" value="<%=penNo %>" maxlength="10">

<input type="button" name="search" value="search" onclick="searchEmp(this.value)">

<div class="Clear"></div>
<div class="floatRight"><input type="button" name="assignTemplate" value="Assign Rights"	
class="buttonBig"	onClick="submitForm('showUserAssinedTemplet','user?method=saveUserAssignedTemplet&'+csrfTokenName+'='+csrfTokenValue);" /></div>
<div class="Clear"></div>
<div id="divEmployee">

<div class="Clear"></div>

<div class="userRights">
<div id="testDiv" style="overflow-y:scroll; overflow-x:visible;height:500px;">

<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<thead>
	<tr>
	<%
	
	if(masTemplateList.size()>0){
		
		%>
		<th>Name</th>
		<%
		for(MasTemplate masTemplate :masTemplateList){
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
	if(masEmployeeList.size()>0){
		//for(MasEmployee masEmployee:masEmployeeList){
			for (Iterator iterator = masEmployeeList.iterator(); iterator.hasNext();) {
				
				Users user = (Users) iterator.next();
				 int userTypeDb = 4;
	        	  if(userType>0){
					if (user.getUserType() != null) {
						userTypeDb = user.getUserType();
					}
				}
				if (userTypeDb != 0) {
			
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
		if(masTemplateList.size()>0){
			for(MasTemplate masTemplate :masTemplateList){
				++templetCnt;
				boolean assignedTemplate=false;
				String assignedTemplateName="";
				assignedTemplateName=masTemplate.getTemplateName();
				int preTempletId=0;
				if(userTemplateList.size()>0){
					int templateIdMain=masTemplate.getId();
					
					for(UserTemplate userTemplate:userTemplateList){
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
		chgCnt++;}}
	}
	%>
	</tbody>

</table>
	<input type="hidden" name="counter" id="counter" value="<%=counter%>" />
	<input type="hidden" name="templetCnt" id="templetCnt" value="<%=masTemplateList.size()%>" />
</div>
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
