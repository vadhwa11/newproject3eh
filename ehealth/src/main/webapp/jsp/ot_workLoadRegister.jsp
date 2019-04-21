
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

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

<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
%>
<form name="workLoadRegister" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Work Load Register</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label><span>*</span>Year:</label> <select id="postYear" name="postYear"
	validate="Year,String,yes">
	<option value="">Select</option>
	<option value="<%=year-1 %>"><%=year-1 %></option>
	<option value="<%=year %>"><%=year %></option>
	<option value="<%=year+1 %>"><%=year+1 %></option>
</select>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="add" value="Ok" class="button"
	onClick="submitForm('workLoadRegister','ot?method=generateWorkLoadRegisterReport');"
	accesskey="a" tabindex=1 /> <input type="reset" name="clear"
	value="Clear" class="button" accesskey="a" tabindex=1 />
	</div>
	</form>
