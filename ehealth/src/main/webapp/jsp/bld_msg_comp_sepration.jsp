
<%@page import="java.util.Vector"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<%
Map<String, Object> map = new HashMap<String, Object>();
String formName = "";
String hinNo = "";
String orderNo = "";

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
int stockDetailId=0;
if(map.get("stockDtId") != null){
	stockDetailId = (Integer)map.get("stockDtId");
}
Vector<String> blood_bag_no = new Vector<String>();
if(map.get("blood_bag_no") != null){
	blood_bag_no = (Vector<String>)map.get("blood_bag_no");
}
%>
<form name="msgCompSepartion" method="post">
<input type="hidden" name="stockDetailName" value="<%=stockDetailId %>"/>
<div class="clear"></div>
<%

		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		 %>
<h4><span><%=message %></span></h4>
<%} %>
<div class="clear"></div>
<input type="button" name="back" value="Back" class="button"
	onclick="submitForm('msgCompSepartion','/hms/hms/bloodBank?method=showBloodComponentSeparationJsp','checkTargetForNo');" />
<% if(blood_bag_no !=null && blood_bag_no.size()>0){
for(String bloodBag:blood_bag_no){
%>
<input type="button" name="back" value="Print Sticker" class="button"
	onclick="submitForm('msgCompSepartion','/hms/hms/bloodBank?method=printBloodBagSticker&bloodBagNo=<%=bloodBag%>','checkTargetForNo');" />
	<%}}%>
<!--
 <input type="button" value="PendingSampleCollection" class="button" onclick="submitForm('messageLab','/hms/hms/lab?method=showPendingSampleCollectionJsp');" />
 --> <br />
<%
if(formName != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>