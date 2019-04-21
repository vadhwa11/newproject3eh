<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>	
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
	function checkAdNo()
	{
	if(document.getElementById("hinNo").value =="" || document.getElementById("hinNo").value ==0){
	  alert("Please fill <%=prop.getProperty("com.jkt.hms.registration_no") %> ");
	  return false
	}else{
		return true
	}
	if(document.getElementById("adNo").value =="" || document.getElementById("adNo").value ==0){
	  alert("Select <%=prop.getProperty("com.jkt.hms.ipd_no") %> ");
	  return false
	}else{
		return true
	} 
	}
</script>
<div class="titleBg">
<h2>Search Patient For IP MLC</h2>
</div>
<div class="clear"></div>
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


<h4>Patient Search</h4>
<div class="clear"></div>
<div class="Block"><!--  
			<label class="bodytextB">Service No.:</label>
			<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value="" class="textbox_date" MAXLENGTH="20" onblur="getHinNo('search','adt?method=getAdmissionNoList&flag=hin')"/>		
		-->
<div id="hinDiv"><label>
 <%=prop.getProperty("com.jkt.hms.registration_no") %></label>
  <!--  <input type="text"	name="<%=HIN_NO%>" id="hinNo" value="" MAXLENGTH="50"	onchange="submitProtoAjax('search','adt?method=getAdmissionNoList&flag=admission')" />
  -->
  <input type="text"	name="<%=HIN_NO%>" id="hinNo" value="" MAXLENGTH="50"	onchange="submitProtoAjax('search','adt?method=getIPNO')" />
</div>

<div id="testDiv"><label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> 
<input type="text"	id="frwSlno" name="inpId" value="" MAXLENGTH="30"	validate="<%=prop.getProperty("com.jkt.hms.ipd_no") %>,string,yes" /></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="Search" value="Search" class="button"
	onClick="if(checkAdNo()){submitForm('search','adt?method=showMedicoLegalCaseDetailsNew&flag=ipMlc');}" />
<input type="reset" name="Reset" value="Reset" class="buttonHighlight"
	accesskey="r" /></form>






