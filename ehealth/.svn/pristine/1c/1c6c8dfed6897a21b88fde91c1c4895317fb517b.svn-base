<%@page import="jkt.hms.masters.business.PhJphnJhiDetails"%>
<%@page import="jkt.hms.masters.business.PhJphnJhiHeader"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasQuestions"%>
<%@page import="jkt.hms.masters.business.MasQuestionAnswers"%>
<%@page import="jkt.hms.masters.business.PhAtpJphnJhiDetails"%>
<%@page import="jkt.hms.masters.business.PhDayBlock"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
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
</script>
<form name="jphni" method="post" action="">
<%
       Map<String, Object> map = new HashMap<String, Object>();
       if (request.getAttribute("map") != null) {
               map = (Map<String, Object>) request.getAttribute("map");
       }
       Map<String,Object> utilMap = new HashMap<String,Object>();
       utilMap = (Map)HMSUtil.getCurrentDateAndTime();
       String date = (String)utilMap.get("currentDate");
       String time = (String)utilMap.get("currentTime");
       String userName = "";
       if (session.getAttribute("userName") != null) {
               userName = (String) session.getAttribute("userName");
       }
       int empId=0;
       if (session.getAttribute("empId") != null) {
    	   empId = (Integer) session.getAttribute("empId");
   }
       List<MasQuestions> masQuestionsList = new ArrayList<MasQuestions>();
       if(map.get("masQuestionsList") != null){
    	   masQuestionsList = (List<MasQuestions>)map.get("masQuestionsList");
  	 	}
       List<MasQuestionAnswers> masQuestionAnswersList = new ArrayList<MasQuestionAnswers>();
       if(map.get("masQuestionAnswersList") != null){
    	   masQuestionAnswersList = (List<MasQuestionAnswers>)map.get("masQuestionAnswersList");
  	 	}
       
       List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
       if(map.get("masEmployeeList") != null){
    	   masEmployeeList = (List<MasEmployee>)map.get("masEmployeeList");
  	 	}
       List<Object[]> phAtpJphnJhiHeaderList = new ArrayList<Object[]>();
       if(map.get("phAtpJphnJhiHeaderList") != null){
    	   phAtpJphnJhiHeaderList = (List<Object[]>)map.get("phAtpJphnJhiHeaderList");
  	 	}
       List<PhJphnJhiDetails> phJphnJhiDetailsList = new ArrayList<PhJphnJhiDetails>();
       if(map.get("phJphnJhiDetailsList") != null){
    	   phJphnJhiDetailsList = (List<PhJphnJhiDetails>)map.get("phJphnJhiDetailsList");
  	 	}
       int phdr=0;
       for(PhJphnJhiDetails p :phJphnJhiDetailsList)
       {
       phdr=p.getJphnJhiHeader().getAshaWorker().getId();
       }
   
           
String message = "";
       if(map.get("message") != null){
               message = (String)map.get("message");
               %>
<h4><span><%=message %></span></h4>
       <%}
%>

<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<div class="titleBg">
<h2>JPHN JHI</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="Block">


<label><span>*</span> Month</label>
<select  name="month" validate="Month,string,no" name="jphniJhiMonths" >
<%

if(month.equalsIgnoreCase("08")){ %>
<option value="">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8" selected="selected"> August</option>
<option value="9">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
<%}else if(month.equalsIgnoreCase("09")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  selected="selected">September</option>
<option value="10">October</option>
<option value="11">November</option>
<option value="12">December</option>
<%}else if(month.equalsIgnoreCase("10")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" selected="selected">October</option>
<option value="11">November</option>
<option value="12">December</option>
<%}else if(month.equalsIgnoreCase("11")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" selected="selected">November</option>
<option value="12">December</option>
<%}else if(month.equalsIgnoreCase("12")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" selected="selected">December</option>
<%}else if(month.equalsIgnoreCase("01")){%>
<option value="">Select</option>
<option value="1"  selected="selected">January</option>
<option value="2">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12">December</option>
<%}else if(month.equalsIgnoreCase("02")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" selected="selected">February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" selected="selected">December</option>
<%}else if(month.equalsIgnoreCase("03")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" >February</option>
<option value="3" selected="selected">March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" >December</option>

<%}else if(month.equalsIgnoreCase("04")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" >February</option>
<option value="3" >March</option>
<option value="4" selected="selected">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" >December</option>

<%}else if(month.equalsIgnoreCase("05")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" >February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5" selected="selected">May</option>
<option value="6" >June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" >December</option>

<%}else if(month.equalsIgnoreCase("06")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" >February</option>
<option value="3">March</option>
<option value="4">April</option>
<option value="5" >May</option>
<option value="6" selected="selected">June</option>
<option value="7">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" >December</option>

<%}else if(month.equalsIgnoreCase("07")){%>
<option value="">Select</option>
<option value="1">January</option>
<option value="2" >February</option>
<option value="3" >March</option>
<option value="4">April</option>
<option value="5">May</option>
<option value="6" >June</option>
<option value="7" selected="selected">July</option>
<option value="8"> August</option>
<option value="9"  >September</option>
<option value="10" >October</option>
<option value="11" >November</option>
<option value="12" >December</option>
<%} %>

</select>


<label>JPHI / JHI </label>
<select name="ashaWorker">
<option value="0">Select</option>
   <%
   String name="";
if (phJphnJhiDetailsList.size()>0){
	 for(MasEmployee masEmployee : masEmployeeList){
		 if(phdr==masEmployee.getId()){
			 
			 if(masEmployee.getFirstName()!=null)
    		 {
				 name=masEmployee.getFirstName();
    		 }
    		 if(masEmployee.getMiddleName()!=null)
    		 {
    			 name=name+masEmployee.getMiddleName();
    		 }
    		 if(masEmployee.getLastName()!=null)
    		 {
    			 name=name+masEmployee.getLastName();
    		 }
		%>
		
			<option value="<%=masEmployee.getId() %>" selected="selected"><%=name %></option>
		
	 <%}}
}else{
   if(phAtpJphnJhiHeaderList.size()>0){ 
			       for(Object[] phAtpJphnJhiHeader : phAtpJphnJhiHeaderList){
			    	 if(phAtpJphnJhiHeader[0]!=null)  {
			    		 
			    		 if(phAtpJphnJhiHeader[2]==null)
			    		 {
			    			 phAtpJphnJhiHeader[2]="";
			    		 }
			    		 if(phAtpJphnJhiHeader[3]==null)
			    		 {
			    			 phAtpJphnJhiHeader[3]="";
			    		 }
			    	   %>
	
		<option value="<%=phAtpJphnJhiHeader[0]%>"><%=phAtpJphnJhiHeader[1]%><%=phAtpJphnJhiHeader[2]%><%=phAtpJphnJhiHeader[3]%></option>
		
	<%	}
	}}
		}%>
</select>
</div>
<div class="paddingTop15"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"      id="voucherDetails" class="cmntable">

<%
int i = 1;   
if(masQuestionsList.size()>0){
	
	for(MasQuestions q:masQuestionsList)
	{
	%>
<tr>
<td><input type="hidden" value="<%=q.getId() %>" name="question<%=i%>" /><%=q.getQuestion() %></td>


 <td>
 
 <select name="questionAnswers<%=i%>">
 <option value="">Select</option>
 <%
	for(MasQuestionAnswers qa:masQuestionAnswersList)
	{ 
		if(q.getId()==qa.getQuestion().getId())
		{
	
	%>
	<option value="<%=qa.getId()%>"><%=qa.getAnswers().getAnswersName() %></option>
	<%} }%>
</select></td>

</tr>	
<%i++; }
	}%>
		<input type="hidden" value="<%=i-1%>" name="hiddenValueCharge" id="hiddenValueCharge" />

</table>

<div class="Clear"></div>


 <input type="button" name="add" id="addbutton" value="Submit" class="button" onclick="submitForm('jphni','pubHealth?method=submitJphniJhi')" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
 <div class="Clear"></div>
 
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %> </label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
 <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName %>" />
  <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
   <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
