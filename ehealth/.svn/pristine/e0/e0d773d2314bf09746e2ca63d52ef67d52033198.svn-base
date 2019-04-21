<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


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
	function datevalidation(){	
	var fdate = document.getElementById('FromDateId');
	var tdate = document.getElementById('ToDateId');	
	frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
	todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));	
	tempdate = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2) -1 + 7);	
	if(fdate.value != "" && todate.value != ""){
			 if(todate > tempdate){
	  alert("FromDate and ToDate difference should be one week");
	   return false;
	  }
	}else{
	 return false;
	}

	//alert("from date formate:::"+frdate.getMonth());
	//alert("year:::"+frdate.getFullYear());
	//alert("date::::::::"+frdate.getDate());
	//alert("tempdate::::::::"+tempdate);
	return true;	
		
		}
	</script>
<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
				Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
	%>
<div class="titleBg">
<h2>SIL/DIL In LIEU of Message Form</h2>
</div>
<form name="silDilReport" target="_blank" method="post" action="">
<div class="Block">
<label>From Date</label> 
<input type="text"	id="FromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.silDilReport.<%=FROM_DATE%>,event)" />
<label>To Date</label> 
<input type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" validate="toDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.silDilReport.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<label>Rank</label> 
<input type="text" name="rank" value=""	class="textbox_date" MAXLENGTH="30" validate="rank,string,no"/> 
<label>Name</label> 
<input	type="text" name="name" value="" class="textbox_date" MAXLENGTH="30" validate="name,string,no"/>
<div class="clear"></div>
<label> Drafter Name </label> 
<input type="text" name="drafterName" value="" class="textbox_date" MAXLENGTH="30" validate="drafterName,string,no"/> 
<label> To </label> 
<textarea name="to" class="textareaMediua" validate="Kin Address,string,no" id="nokAddr" cols="53"	rows="3" onpaste="return checkOnPaste(this)" oninput="return checkMaxLengthMoz(this)" onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" tabindex="1"></textarea> 
<textarea name="to2" class="textareaMediua" validate="Kin Address,string,no" id="nokAddr" cols="53" rows="3"	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"	tabindex="1"></textarea>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button"	onClick="if(datevalidation()){submitForm('silDilReport','/hms/hms/mis?method=showSilDilReport');}" />
<input type="reset" name="Reset" value="Cancel" class="button"	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>



