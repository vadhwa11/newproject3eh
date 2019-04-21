<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
	
<script type="text/javascript">
	function checkVisit()
	{
	if(document.getElementById("visitId").value =="" || document.getElementById("visitId").value ==0){
	  alert("Select Visit No ")
	  return false
	}else{
		return true
	} 
	}
</script>
<div class="titleBg">
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 26 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<h2>Search Patient For OP MLC</h2>
</div>
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<h4>Patient Search</h4>
<div class="clear"></div>

<div class="Block">
<div id="hinDiv"><label> <%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text"
	name="<%=HIN_NO%>" value="" class="textbox_date" MAXLENGTH="50"
	onblur="if(this.value!=''){submitProtoAjax('search','registration?method=getVisitNoNew')}"
	validate="<%=prop.getProperty("com.jkt.hms.registration_no") %>,String,yes" /></div>

<label><%=prop.getProperty("com.jkt.hms.opd_no") %></label>
<div id="testDiv"><input type="text" name="visitId"
	value="" MAXLENGTH="6" class="readOnly" readonly="readonly"
	id="visitId" /></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="Search" value="Search" class="button"
	onClick="if(checkVisit()){submitForm('search','adt?method=showMedicoLegalCaseDetailsNew&flag=opMlc');}" />
<input type="reset" name="Reset" value="Reset" class="buttonHighlight"
	accesskey="r" /></form>






