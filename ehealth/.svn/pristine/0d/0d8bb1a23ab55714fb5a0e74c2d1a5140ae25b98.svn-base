<%@page import="jkt.hrms.masters.business.HrMasBonus"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%
			Map map = new HashMap();
			if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			List<HrMasBonus> bonusList = new ArrayList<HrMasBonus>();
			List<MasGrade> gradeList = new ArrayList<MasGrade>();
			if(map.get("bonusList")!= null){
				bonusList = (List)map.get("bonusList");
			}
			if(map.get("gradeList")!= null){
				gradeList = (List)map.get("gradeList");
			}
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			String userName = "";
			if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
			}
			%>
<% 			
			if(map.get("message") != null){
			String message = (String)map.get("message");
			%>
<h4><span><%=message %></span></h4>
<% 
			}
%>

<%@page import="jkt.hms.masters.business.MasGrade"%>
<script type="text/javascript">
	
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
		
   function selectPaymentFrequency(val){
   	if(val == "Yearly"){
   		document.getElementById('paymentFrequencyId').readOnly = true;
   		document.getElementById('paymentFrequencyId').value="Yearly";
   	}else {
		document.getElementById('paymentFrequencyId').readOnly = false;
   		document.getElementById('paymentFrequencyId').value="";
   	}
  }
  
  function checkFromDate(){
		var fDate = document.bonus.<%= FROM_DATE%>.value;
		var tDate = document.bonus.<%= TO_DATE %>.value;
	
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		if(fromDate > toDate)
		{
			alert("To Date should be greater than From Date.");
			document.bonus.<%= FROM_DATE%>.value = "";
			document.bonus.<%= TO_DATE %>.value = "";
			return false;
		}
		return true;
	}
	
	function validateFieldsForDisplay(){
		var errMsg = "";
		var fixedAmount = document.getElementById('fixedAmountId').value;
		var maxBasic = document.getElementById('maxBasicId').value;
		var bonusRate = document.getElementById('bonusRateId').value;
		
		if(fixedAmount == "" && maxBasic == "" && bonusRate ==  ""  ){
			errMsg += "Please fill either Fixed Amount or Fixed Amount & MaxBasic or either MaxBasic & Basic Rate  .\n";
		}
	
		if(errMsg != ""){
			alert(errMsg);
			return false;
		}
		
		return true;
}

</script>

<div class="titleBg">
<h2>Bonus Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Bonus
Code</label> <input type="radio" name="<%=SELECTED_RADIO %>" value="1"
	checked="checked" class="radioCheck" /> <label>Bonus
Description</label> <input type="radio" name="<%=SELECTED_RADIO %>" value="2"
	class="radioCheck" /> <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value=""
	validate="Bonus Description,string,no" MAXLENGTH="15" tabindex=1
	onkeypress="return submitenter(this,event,'payrollMasters?method=searchBonus')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','payrollMasters?method=searchBonus','checkSearch')"
	tabindex=1 /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
if(bonusList.size()>0)
{
String strForCode = (String)map.get("bonusCode");
String strForCodeDescription = (String)map.get("bonusDescription");
if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
{
%><h4> <a href="payrollMasters?method=showBonusJsp">Show All Records</a></h4> <%
}
}
if(bonusList.size()==0 && map.get("search") != null)
{
%> <h4><a href="payrollMasters?method=showBonusJsp">Show All Records</a></h4> <%
}
%> <script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= PAYMENT_FREQUENCY%>"],[4,"<%= BONUS_RATE%>"],[5,"<%= DUE_DATE%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"],
[10,"<%=FROM_DATE%>"],[11,"<%=TO_DATE%>"],[12,"<%=TAXABLE%>"],[13,"<%=BONUS_TYPE%>"],[14,"<%=FIXED_AMOUNT%>"],[15,"<%=MAX_BASIC%>"] ,[16,"<%=GRADE_ID%>"]];
statusTd = 9;
</script></div>
<div class="clear"></div>
<div class="division"></div>

<form name="bonus" method="post" action="">
<div class="Block"><label><span>*</span> Bonus Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="BonusCode,string,yes" MAXLENGTH="15" tabindex=1 /> <label
	id=biglabel><span>*</span> Bonus Description</label> <input type="text"
	name="<%= SEARCH_NAME %>" value=""
	validate="Bonus Description,string,yes" MAXLENGTH="25" tabindex=1 /> <script>
document.bonus.<%=CODE%>.focus();
</script> <label><span>*</span> From Date</label> <input type="text" id="dobId"
	name="<%=FROM_DATE %>" value="" class="date" readonly="readonly"
	validate="From date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.bonus.<%=FROM_DATE%>,event)" /> <script>
document.bonus.<%=FROM_DATE%>.focus();
</script>
<div class="clear"></div>
<label><span>*</span> To Date</label> <input type="text" id="dobId"
	name="<%=TO_DATE %>" value="" class="date" readonly="readonly"
	validate="To date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.bonus.<%=TO_DATE%>,event)" /> <label>
Taxable</label> <label class="value"><input type="checkbox"
	name="<%= TAXABLE%>" value="" validate="Taxable,string,yes" tabindex=1
	class="radioCheck" /></label> <label><span>*</span> Bonus Type</label> <select
	name="<%=BONUS_TYPE %>" validate="Bonus Type,string,yes"
	onchange="selectPaymentFrequency(this.value);">
	<option value="">Select</option>
	<option value="Yearly">Yearly</option>
	<option value="pro">Pro</option>
</select>
<div class="clear"></div>
<label><span>*</span> Payment Frequency</label> <select
	id="paymentFrequencyId" name="<%=PAYMENT_FREQUENCY %>"
	validate="Payment Frequency,string,yes">
	<option value="0">Select</option>
	<option value="Yearly">Yearly</option>
	<option value="Weekly">Weekly</option>
	<option value="Monthly">Monthly</option>
</select> <label><span>*</span> Due Date</label> <input type="text"
	name="<%=DUE_DATE %>" value="" class="date" readonly="readonly"
	validate="Due date ,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.bonus.<%=DUE_DATE%>,event)" />

<div class="clear"></div>
</div>
<div class="clear"></div>

<h4>Maximum Basic For Fixed Amount</h4>
<div class="clear"></div>
<div class="Block"><label> Fixed Amount</label> <input
	id="fixedAmountId" type="text" name="<%= FIXED_AMOUNT%>" value=""
	validate="Fixed Amount,float,no" MAXLENGTH="9" tabindex=1 /> <label>
Max Basic</label> <input id="maxBasicId" type="text" name="<%= MAX_BASIC%>"
	value="" validate="Max Basic,float,no" MAXLENGTH="9" tabindex=1 /> <label>
Grade</label> <select name="<%=GRADE_ID %>" validate="Grade Code,string,no">
	<option value="0">Select</option>
	<%
	for(MasGrade masGrade :gradeList){
%>
	<option value="<%=masGrade.getId() %>"><%=masGrade.getGradeName()%></option>
	<%
	}
%>
</select>
<div class="clear"></div>
<label> Bonus% Rate</label> <input id="bonusRateId" type="text"
	name="<%= BONUS_RATE%>" value="" validate="Bonus% Rate,float,no"
	MAXLENGTH="5" tabindex=1 />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('bonus','payrollMasters?method=saveBonus','checkFromDate','validateFieldsForDisplay');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('bonus','payrollMasters?method=editBonus','checkFromDate')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('bonus','payrollMasters?method=deleteBonus&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label>
 <label class="value"><%=date%></label> 
 <label>Changed Time</label> 
 <label class="value"><%=time%></label> 
 <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
  <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
  <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> 
  </div>

<input type="hidden" name="<%=STATUS %>" value="" />
 <input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Bonus Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Description"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "P.Frequency"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%= PAYMENT_FREQUENCY %>"

data_header[3] = new Array;
data_header[3][0] = "Bonus%Rate"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= BONUS_RATE %>"

data_header[4] = new Array;
data_header[4][0] = "Due Date"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= DUE_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%= FROM_DATE%>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%= TO_DATE%>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%= TAXABLE%>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=BONUS_TYPE%>";


data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "<%= FIXED_AMOUNT%>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%= MAX_BASIC%>";

data_header[15] = new Array;
data_header[15][0] = "Grade"
data_header[15][1] = "data";
data_header[15][2] = 0;
data_header[15][3] = "<%= GRADE_ID%>";

data_arr = new Array();

<%


Iterator itr=bonusList.iterator();
int  counter=0;
while(itr.hasNext())
{


HrMasBonus hrMasBonus= (HrMasBonus)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasBonus.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasBonus.getBonusCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasBonus.getDescription()%>"
data_arr[<%= counter%>][3] = "<%= hrMasBonus.getPaymentFrequency()%>"
<%
	if(hrMasBonus.getBonusRate() != null && !(hrMasBonus.getBonusRate().equals(""))){
%>
data_arr[<%= counter%>][4] = "<%= hrMasBonus.getBonusRate()%>"
<%
	}else{
%>
data_arr[<%= counter%>][4] = ""
<%
	}
%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasBonus.getDueDate())%>"
data_arr[<%= counter%>][6] = "<%= hrMasBonus.getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasBonus.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= hrMasBonus.getLastChgTime() %>"



<% 

if(hrMasBonus.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
data_arr[<%= counter%>][10] = "<%=HMSUtil.convertDateToStringWithoutTime(hrMasBonus.getFromDate()) %>"
data_arr[<%= counter%>][11] = "<%=HMSUtil.convertDateToStringWithoutTime(hrMasBonus.getToDate()) %>"
data_arr[<%= counter%>][12] = "<%= hrMasBonus.getTaxable() %>"
data_arr[<%= counter%>][13] = "<%= hrMasBonus.getBonusType() %>"
<%
	if(hrMasBonus.getFixedAmount() != null && !(hrMasBonus.getFixedAmount().equals(""))){
%>
data_arr[<%= counter%>][14] = "<%=hrMasBonus.getFixedAmount()%>"
<%
	}else{
%>
data_arr[<%= counter%>][14] = ""
<%
	}
%>
<%
	if(hrMasBonus.getMaxBasic() != null && !(hrMasBonus.getMaxBasic().equals(""))){
%>
data_arr[<%= counter%>][15] = "<%= hrMasBonus.getMaxBasic()%>"
<%
	}else{
%>
data_arr[<%= counter%>][15] = ""
<%
	}
%>
<%	
			if(hrMasBonus.getGrade() != null){
				for(MasGrade masGrade :gradeList){
					if( hrMasBonus.getGrade().getId() == masGrade.getId()){

%>
data_arr[<%= counter%>][16] = "<%=masGrade.getGradeName()%>";
<%
		}
%>

<%			
		 
		}
	  }else{
%>

data_arr[<%= counter%>][16] = "";

<%}
counter++;
}
%>

formName = "bonus"


start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
