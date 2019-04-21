<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * subCharge.jsp
 * Purpose of the JSP -  This is for Sub Charge.
 * @author  Dipali
 * @author  vishal
 * Create Date: 08th April,2009
 * Revision Date:
 * Revision By:
 * @version 1.16
--%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@ page import="jkt.hms.masters.business.MasMainChargecode"%>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	} 	 
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
<%}
%>

<div class="titleBg">
<h2>Change Pacs Password</h2>
</div>

<form name="changePacsPassword" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label><span>*</span>User Name</label> 
<input type="text" name="userName"  validate="User Name,string,yes" class="textbox_size20"  tabindex=1 /> 

<label><span>*</span>Password</label>
<input type="text" name="ehealthPassword"  validate="Password,string,yes" class="textbox_size20"  tabindex=1/> 

<label class="bodytextB_blue"><span>*</span>PACS New Password </label> 
 <input type="text" name="pacsNewPassword" validate="PACS New Password ,string,yes" class="textbox_size20"   tabindex=1/> 
 
<div class="clear"></div> 
<label><span>*</span>PACS Confirm Password</label>
 <input type="text" name="pacsConfirmPassword" validate="PACS New Confirm,string,yes" class="textbox_size20"  tabindex=1/> 

<div class="clear"></div>
<div id="edited"></div>
<div class="clear"></div>
<input type="button" name="Submit" id="addbutton" value="Submit" class="button" onClick="submitForm('changePacsPassword','user?method=changePasswordInPacs');" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
</div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div></form>
	
	
	
	
	