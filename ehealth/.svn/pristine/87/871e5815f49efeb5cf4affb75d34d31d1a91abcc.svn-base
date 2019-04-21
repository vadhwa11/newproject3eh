<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * state.jsp  
 * Purpose of the JSP -  This is showing State.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>

<%@page import="jkt.hms.masters.business.MasBulkMain"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasSpecialityGroup"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasBulkMain"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		List<MasBulkMain> masGroupList = new ArrayList<MasBulkMain>();
		List<MasBulkMain> mainList = new ArrayList<MasBulkMain>();	
		List<MasSpecialityGroup> gridGroupList = new ArrayList<MasSpecialityGroup>();
		String userName = "";
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("searchGroupList") != null){
			masGroupList = (ArrayList)map.get("searchGroupList");
		}
		
		if(map.get("mainList") != null){
			mainList = (ArrayList)map.get("mainList");
		}
		
		
	    if(map.get("gridGroupList") != null){
	    	gridGroupList = (ArrayList)map.get("gridGroupList");
	           }
	    
	    
	    
	    
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		ex.printStackTrace();
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(map.get("message") != null){
		  String message = (String)map.get("message");
		   %>
		
<h4>
	<span><%=message %></span>
</h4>
<%}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
%>

<div class="titleBg">
	<h2>SMS Group Master</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
	<div id="searcharea">
		<div id="searchbar">
			<form name="search" method="post" action="">
	<label>Group Name </label>
	<select name="groupName" id="groupId" onchange="changeForGroupName(this.value);">
	<option value="">Select</option>
	<%for(MasBulkMain main:mainList){ %>
	<option value="<%=main.getGroupType()%>"><%=main.getGroupName() %></option>
	<%} %>
</select>					
				
	
				
<div id="valDiv" style="display: block;"></div>	
<div id="generalDiv" style="display: block;"></div>		
			
			
		</div>
	</div>
	<div class="clear"></div>
	<input type="button" value=save" onclick="submitForm('search','sms?method=saveGroupDetailsForSMS');" />
		<div class="clear"></div>
			<div class="clear"></div>
</div>
<script>
function changeForGroupName(value){
	//alert("value======>>"+value);
	if(value=='E' && value!='V' && value!='G'){
		submitProtoAjaxWithDivName('search','sms?method=getValForGroup','valDiv');
		//document.getElementById('generalDiv').style.display="none";
	}else if(value=='V' && value!='G' && value!='E'){
		submitProtoAjaxWithDivName('search','sms?method=getValForGroup1','valDiv');		
		//document.getElementById('generalDiv').style.display="none";
	} else if(value=='G' && value!='V' && value!='E'){
		alert("in G");
		submitProtoAjaxWithDivName('search','sms?method=getValForGeneral','generalDiv');
		//document.getElementById('valDiv').style.display="none";
		
	}
}

</script>
<script>
function changeForCheck(inc){
	//alert(""+inc)
	if(document.getElementById('vendorChekId'+inc).checked==true){
		document.getElementById('vendorChekStatId'+inc).value="y";
	}
}
</script>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
