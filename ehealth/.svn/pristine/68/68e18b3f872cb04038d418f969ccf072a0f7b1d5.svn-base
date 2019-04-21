<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}	
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	  Map<String,Object> map = new HashMap<String,Object>();

	  if (request.getAttribute("map") != null) {
	  	map = (Map<String,Object>) request.getAttribute("map");
	  }
	  String message = "";
	  if(map.get("message") != null){
	  	message = (String)map.get("message");
  	  }
%>

<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
%>
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>IP Patient Enquiry</h2>
</div>
<div class="clear"></div>
</form>

<%
	String includedJsp ="";
	if(map.get("includedJsp") != null){
		includedJsp = (String)map.get("includedJsp");
	}
	
	if(!includedJsp.equals(""))
	{
%>
		<jsp:include page="<%=includedJsp%>" flush="true" />
<%	
	}
%>
