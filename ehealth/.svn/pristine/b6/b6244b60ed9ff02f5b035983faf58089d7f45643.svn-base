<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.RequestConstants"%>



<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 

	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	Box box=null;
	int issueId = 0;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if (map.get("box") != null) {
		box = (Box) map.get("box");
	}
	if(map.get("messageTOBeVisibleToTheUser") !=null){
		messageTOBeVisibleToTheUser=""+map.get("messageTOBeVisibleToTheUser");
	}
	if(map.get("messageType") !=null){
		messageType=""+map.get("messageType");
	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	if(map.get("issueId") !=null){
		issueId=Integer.parseInt(""+map.get("issueId")) ;
	}
	
%>
<div id="contentspace">
<form name="message" method="post"><input name="issueId"
	value="<%=issueId%>" type="hidden" /> <br />
<br />



<%if(!messageTOBeVisibleToTheUser.equals(""))
	{
	if(messageType.equals("success")){
	%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; font-weight: bold; height: 23px;">
<%=messageTOBeVisibleToTheUser %></div>
</div>

<%}%> <%if(messageType.equals("failure")){%>

<div id="errorMsg"
	style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div
	style="margin-right: 0px; /*changed from 3px */ text-align: center; font-weight: bold; height: 23px; background-color: #FFE8E8; float: left; width: 100%; color: red; border: 1px solid red;">
<%=messageTOBeVisibleToTheUser %></div>
</div>
<%}}%> <br />
<input type="hidden" name="<%=RequestConstants.ISSUE_NO %>" id="issueNo"
	value="<%=box.get("issueNo")%>" class="textbox_size20" MAXLENGTH="8" validate="issueNo,metachar,no"/>
<input type="hidden" name="<%= RequestConstants.DEPARTMENT_ID_TEMP%>"
	id="departmentIdTemp" validate='Dispensery Name,int,no'
	value="<%=box.get("departmentIdTemp") %>"> <input type="hidden"
	name="<%= RequestConstants.REFERENCE %>" id="reference"
	value="<%=box.get("reference") %>" class="textbox_size20"
	MAXLENGTH="30" /> <input type="hidden"
	name="<%= RequestConstants.REQUEST_BY%>" id="requestBy"
	validate="Request By,metachar,yes" value="<%=box.get("requestBy")%>">
<input type="hidden" name="<%= RequestConstants.APPROVED_BY%>"
	id="approvedBy" value="<%=box.get("approvedBy") %>"
	validate="Approved By,metachar,Yes"> <input type="hidden"
	name="<%= RequestConstants.ISSUED_BY%>" id="issuedBy"
	validate="Issued By,metachar,no" value="<%=box.get("issuedBy")%>">
<input type="hidden" name="<%= RequestConstants.REQUEST_NO%>"
	id="requestNo" validate="Issued By,metachar,no"
	value="<%=box.get("requestNo")%>"> <input type="button"
	value="Back" class="button" onClick="submitForm('message','<%=url%>');" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
</div>