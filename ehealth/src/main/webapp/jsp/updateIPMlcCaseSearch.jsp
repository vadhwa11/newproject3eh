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
	function checkMLC()
	{
	if(document.getElementById("mlcId")){
		if(document.getElementById("mlcId").value =="" || document.getElementById("mlcId").value ==0){
		  alert("MLC No can not be blank. ")
		  return false
		}else{
			return true
		} 
	}
	return true;
	}
</script>
<div class="titleBg">
<h2>Search Patient For Update IP MLC</h2>
</div>
<form name="search" method="post" action="">
	
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 27 July 2010
 -->	
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<div class="clear"></div>
<h4>Patient Search</h4>
<div class="clear"></div>

<div class="Block"><label> <%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text"
	name="<%=HIN_NO%>" id="hinNo" value="" MAXLENGTH="50"
	onchange="submitProtoAjaxWithDivName('search','adt?method=getAdmissionNoList&flag=mlc','adDiv')" />
<div id="adDiv"><label> <%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <input type="text"
	id="adno" name="<%=AD_NO%>" value="" MAXLENGTH="30"
	validate="<%=prop.getProperty("com.jkt.hms.ipd_no") %>,string,yes"
	onblur="submitProtoAjax('search','adt?method=getMlcNo')" /></div>
<div id="testDiv"><label>MLC No.</label> <input type="text"
	name="<%=MLC_NO %>" value="" MAXLENGTH="30" id="mlcId" /></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="Search" value="Search" class="button"
	onClick="if(checkMLC()){submitForm('search','adt?method=showUpdateMedicoLegalCaseDetails&flag=ipMlc');}" />
<input type="reset" name="Reset" value="Reset" class="buttonHighlight"
	accesskey="r" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>







