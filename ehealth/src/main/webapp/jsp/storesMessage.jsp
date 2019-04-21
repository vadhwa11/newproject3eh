<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.util.RequestConstants"%>



<script type="text/javascript" src="/hms/jsp/js/common.js"></script>



<%
	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String messageTOBeVisibleToTheUser ="";
	String messageType ="success";
	String balanceNo="";
	String balanceNoForPrint="";
	String adjustmentNo="";
	String poNumber="";
	Box box=null;
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	int issueId=0;
	if(map.get("issueId")!=null)
	{
		issueId =(Integer)map.get("issueId");
	}
	if(map.get("adjustmentNo")!=null)
	{
		adjustmentNo =(String)map.get("adjustmentNo");
	}
	if(map.get("poNumber")!=null)
	{
		poNumber =(String)map.get("poNumber");
	}
	if(map.get("balanceNoDisplay")!=null)
	{
		balanceNo =(String)map.get("balanceNoDisplay");
		balanceNoForPrint=balanceNo;
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
	if(url==""){
		url="stores?method=showIssueDispensaryJsp";
	}
	request.setAttribute("box",box);
%>
<script type="text/javascript" language="javascript">
function submitprint(formName,adjustmentNo){

	

		var adj=document.getElementById('adj').value;
		obj = eval('document.'+formName)
	obj.action = "/hms/hms/stores?method=printDepartmentIssue&adjustment="+adj;
	obj.submit();
  }
function submitprintIssue(formName,issueId){
	obj = eval('document.'+formName)
	obj.action = "/hms/hms/stores?method=printDepartmentIssue&issueId="+issueId;
	obj.submit();
  }
function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalPoFormatJsp";
  obj.submit();
}
</script>
<form name="message" method="post">
<div class="clear"></div>
<%
if(balanceNo!=""){
	balanceNo=" And Balance No.  "+balanceNo;
}
if(!messageTOBeVisibleToTheUser.equals(""))
	{
	if(messageType.equals("success")){
	%>
<h4><span><%=messageTOBeVisibleToTheUser %><%=balanceNo%></span></h4>
<%}%> <%if(messageType.equals("failure")){%>


<h4><span><%=messageTOBeVisibleToTheUser %> </span></h4>

<%}}%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%
	if(balanceNoForPrint==""){
	if(issueId>0){
		%>
<input type="button" name="print" type="button" class="button"	value="Print" onClick="submitprintIssue('message',<%=issueId%>);" />
		<%
	}else if(!(poNumber.equals(""))){
	%>
	<input type="button" name="print" type="button" class="button"	value="Print" onClick="showReport('message');" />
	<input type="hidden" name="<%=PO_NO%>" value="<%=poNumber%>"	tabindex=1 MAXLENGTH="50" id="<%=PO_NO%>" validate="poNo,metachar,no"/>			
	<%}else{
		%>
		<input  name="adj"  id="adj" type="hidden" value="<%=adjustmentNo %>" validate="adj,metachar,no"/>
		<input type="button" name="print" class="button"	value="Print" onClick="submitprint('message',<%=adjustmentNo%>);" />		
				<%
			
	}
		%>



<input type="hidden" name="adjustment" value="<%=adjustmentNo %>" validate="adjustment,metachar,no"/>	
	<%
	}
%>
<input type="button" value="Back" class="button"	onClick="submitForm('message','<%=url%>');" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>