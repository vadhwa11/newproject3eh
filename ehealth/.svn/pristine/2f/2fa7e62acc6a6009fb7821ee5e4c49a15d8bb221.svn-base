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
<form name="observation" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
       List<PhDayBlock> dayBlockList = new ArrayList<PhDayBlock>();
       if(map.get("phDayBlockList") != null){
   		dayBlockList = (List<PhDayBlock>)map.get("phDayBlockList");
  	 	}
       
       List<Object[]> phAtpJphnJhiDetailsList = new ArrayList<Object[]>();
       if(map.get("phAtpJphnJhiDetailsList") != null){
    	   phAtpJphnJhiDetailsList = (List<Object[]>)map.get("phAtpJphnJhiDetailsList");
  	 	}
     
String message = "";
       if(map.get("message") != null){
               message = (String)map.get("message");
               %>
<h4><span><%=message %></span></h4>
       <%}
%>
<div class="titleBg">
<h2>ATP JPHN JHI</h2>
</div>
<div class="Block">
<label>Consicutive</label> 
<input type="radio" name="HOCL" value="c" class="inputRadiobutton"/>
<label>Concurrent</label> 
<input type="radio" name="HOCL" value="cv" class="inputRadiobutton" />

<div class="clear"></div>
<label><span>*</span> Month</label>
<select  validate="Month,string,no" name="atpJphniJhiMonths" onblur="submitProtoAjaxWithDivNameForVillageSurvey('observation','/hms/hms/pubHealth?method=getMonthsAndVisit&monthValue='+this.value,'testDivs');">
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

  <div id="testDivs">
 <label>Name</label>
  <select>
  <option value="0">Select</option>
  </select>

</div>
<div class="clear"></div>
</div>
</form>
