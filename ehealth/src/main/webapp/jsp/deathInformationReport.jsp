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
<div class="clear"></div>
<div class="titleBg">
<h2>Death Information Report</h2>
</div>
<form name="fatalDocumentPanchnamaReport" target="_blank" method="post"	action="">
<div class="Block">
<div id="hinDiv">
<label> HIN</label> 
<input type="text"	name="<%=HIN_NO%>" value="" class="textbox_date" MAXLENGTH="30"	validate="HIN,metachar,no"	onchange="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=getAdmissionNoList&flag=admission','testDiv')" />
</div>
<div id="testDiv">
<label> IP No.</label> 
<input type="text"	id="frwSlno" name="<%=AD_NO%>" value="" class="textbox_date" MAXLENGTH="30" validate="adNo,metachar,no"/></div>
<div class="clear"></div>
<label>To</label> 
<input type="text" id="to" name="<%=TO%>" value="" class="textbox_date" MAXLENGTH="30" validate="to,string,no"/> 
<label> Certificate </label> 
<input	type="radio" name="<%=SELECTED_RADIO%>" value="airForce" checked="checked" class="inputRadiobutton" validate="selectedRadio,string,no"/> 
<label>Air Force</label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" value="Army" class="inputRadiobutton" validate="selectedRadio,string,no"/> 
<div class="clear"></div>
<label>Army</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="Navy" class="inputRadiobutton" validate="selectedRadio,string,no"/> 
<label>Navy</label>
<div class="clear"></div>
<label>Info 1</label> 
<input type="text" name="<%=INFO1%>" value="" class="textbox_date" validate="info1,string,no"/> 
<label>Channel 1</label> 
<input type="text"	name="<%=CHANNEL1%>" value="" class="textbox_date" validate="channel,string,no"/> 
<label>Info 2</label> 
<input type="text" name="<%=INFO2%>" value="" class="textbox_date" validate="info2,string,no"/>
<div class="clear"></div>
<label>Channel 2</label> 
<input type="text" name="<%=CHANNEL2%>"	value="" class="textbox_date" validate="channel2,string,no"/> 
<label>Info 3</label> 
<input	type="text" name="<%=INFO3%>" value="" class="textbox_date" validate="info3,string,no"/> 
<label>Channel 3</label> 
<input type="text" name="<%=CHANNEL3%>" value="" class="textbox_date" validate="channel3,string,no"/>
<div class="clear"></div>
<label> Rank </label> 
<input type="text" name="<%=RANK%>" value="" class="textbox_date" validate="rank,string,no"/> 
<label> Name </label> 
<input type="text"	name="<%=NAME%>" value="" class="textbox_date" validate="name,string,no"/> 
<label>Drafter Name </label> 
<input type="text" name="<%=DRAFTER_NAME%>" value="" class="textbox_date" validate="Drafter,string,no"/>
<div class="clear"></div>
<label>NOK</label> 
<select name="nok" validate="nok,string,no">
<option value="INFORMED">INFORMED</option>
<option value="NOT INFORMED">NOT INFORMED</option>
</select>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('fatalDocumentPanchnamaReport','mis?method=showDeathInformation');" />
<input type="reset" name="Reset" value="Cancel" class="button"	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
 