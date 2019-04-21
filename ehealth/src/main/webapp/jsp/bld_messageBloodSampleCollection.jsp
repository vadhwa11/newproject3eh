<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 
	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String url1="";
	String bagNo="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	if(map.get("url") !=null){
		url=""+map.get("url");
	}
	if(map.get("url1") !=null){
		url1=""+map.get("url1");
	}
	int donorSequenceId=0;
	int donorSampleCollectionId=0;
	
	if(map.get("donorSequenceId") !=null){
		donorSequenceId=(Integer)map.get("donorSequenceId");
	}
	if(map.get("donorSampleCollectionId") !=null){
		donorSampleCollectionId=(Integer)map.get("donorSampleCollectionId");
	}
	if(null !=map.get("bagNo")){
		bagNo=(String)map.get("bagNo");
	}
%>

<%	String message ="";
	if (map.get("messageTOBeVisibleToTheUser") != null) {
	             message = (String) map.get("messageTOBeVisibleToTheUser");
	      }
	if(!message.equalsIgnoreCase("")){
	%>
<h4><span><%=message %></span></h4>
<%} %>
<form name="message" method="post">
<div class="clear"></div>
<div class="Height10"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="donorSequenceId" value="<%=donorSequenceId%>"/>
<input type="hidden" name="donorSampleCollectionId" value="<%=donorSampleCollectionId%>"/>
<input type="hidden" name="bagNo" value="<%=bagNo%>"/>


<input type="button" value="Back" class="button"
	onClick="submitForm('message','<%=url%>');" /> 
	
	<input type="button" class="buttonBig2"
	value=" Blood Sample Collection " class="buttonBig"
	onClick="submitForm('message','<%=url1%>');" />
	
	
	<input type="button"
	class="buttonBig2" name="Print Barcode" id="reset" value="Print Barcode"
	onclick="submitForm('message','/hms/hms/bloodBank?method=printBarcode');" accesskey="r"
	tabindex=1 />
	
	<input type="button"
	class="buttonBig2" name="Print Declaration Form" id="reset" value="Print Declaration Form"
	onclick="submitForm('message','/hms/hms/bloodBank?method=printFormAfterBooldCollection');" accesskey="r"
	tabindex=1 />
	
	<input type="button"
	class="buttonBig2" name="Upload Declaration Form" id="reset" value="Upload Declaration Form"
	 accesskey="r"
	tabindex=1 />
	
	
	
	</form>
