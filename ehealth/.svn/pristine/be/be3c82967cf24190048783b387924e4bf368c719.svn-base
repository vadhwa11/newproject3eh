<%@page import="jkt.hms.masters.business.MasPhReportsParameters"%>
<%@page import="jkt.hms.util.ChildPojoForHmisParameter"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="jkt.hms.masters.business.HmisHospitalReport"%>
<%@ page import="java.util.*" %>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil" %>

<script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>

 <script>
<%Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
</script>

<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<%
Map map = new HashMap();
String hmisId = null;
String hmisParameter = null;
String reportName  = null;
int parameterId = 0;
// added by Amit Das on 26-04-2016
Map<Integer,String> monthMap = new HashMap<Integer,String>();
monthMap.put(1, "Janurary");
monthMap.put(2, "Feburary");
monthMap.put(3, "March");
monthMap.put(4, "April");
monthMap.put(5, "May");
monthMap.put(6, "June");
monthMap.put(7, "July");
monthMap.put(8, "August");
monthMap.put(9, "September");
monthMap.put(10, "October");
monthMap.put(11, "November");
monthMap.put(12, "December");


if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");

List<Object[]> cList =new ArrayList<Object[]>();
if(map.get("countList") != null){
	cList=(List<Object[]> ) map.get("countList");	
}
List<MasPhReportsParameters> hmisParameters = new ArrayList<MasPhReportsParameters>();
if(map.get("hmisParameters") != null){
	hmisParameters=(List<MasPhReportsParameters> ) map.get("hmisParameters");	
}
List<ChildPojoForHmisParameter> hmisParametersList = new ArrayList<ChildPojoForHmisParameter>();
if(map.get("hmisParametersList") != null){
	hmisParametersList=(List<ChildPojoForHmisParameter> ) map.get("hmisParametersList");	
}
List<HmisHospitalReport> list = new ArrayList<HmisHospitalReport>();
if(map.get("list") != null){
	list=(List<HmisHospitalReport> ) map.get("list");	
}

if(map.get("reportName") != null){
	reportName=(String) map.get("reportName");	
}

if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
}


long tt1Count = 0;
long tt2Count = 0;

long hbValueForhighLevel = 0;
long hbValueForlowLevel = 0;
for(Object[] totalCount: cList){
	hbValueForlowLevel	= ((BigInteger)totalCount[29]).longValue();
	hbValueForhighLevel	= ((BigInteger)totalCount[30]).longValue();
	tt1Count	= ((BigInteger)totalCount[31]).longValue();
	tt2Count	= ((BigInteger)totalCount[32]).longValue();
}
//variables to show the stock related data of hmis paramater mapping 
int countOfTotalStock = 0;  
int countOfstockReceived = 0; 
int countOfUnusableStock = 0; 
int countOfStockDistributed = 0;
int countOfBalanceOfPreviousMonth = 0;

%>

<div class="clear"></div>
<div class="titleBg">
<h2>HMIS</h2>
</div>

<form name="hmisreport" method="post">
<div class="Block">
<div id="pageNavPosition"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<label><span>*</span> Month</label>
<select  validate="Month,string,no" name="months" id="months" onchange="submitProtoAjaxWithDivNameMonth('hmisreport','/hms/hms/pubHealth?method=gethmisHospitalbyMonthValue&monthValue='+this.value+'&'+csrfTokenName+'='+csrfTokenValue,'testDivs');">
<option value="0">Select</option>
<% Set<Entry<Integer, String>> entrySet  = monthMap.entrySet();
for(Entry<Integer, String> entry : entrySet){  

if(entry.getKey().equals(Integer.parseInt(month))){%>
<option value="<%=entry.getKey()%>" selected="selected"><%=entry.getValue()%></option>
<%} else { %>
<option value="<%=entry.getKey()%>"><%=entry.getValue()%></option>
<%} } %>
</select>
<label>Year</label>
 <input type="text"	class="date" name="year" value="<%=year%>"	readonly="readonly" /> 

 <div id="testDivs">
<table>
<tr>
	    <th scope="col">Code</th>
		<th scope="col">Parameters</th>	
		<th scope="col">Count</th>
</tr>
<tbody>
  <%
  int  counter=1;
  if(list.size()!=0) {
	  	HmisHospitalReport object = null;
	  	for(ChildPojoForHmisParameter pojoForHmisParameter : hmisParametersList){ 
	  		object = pojoForHmisParameter.getHmisHospitalReport();
	  	%>
	<tr>
		 <%if(object.getParameter().getHmisId()!=null){ 
			 hmisId = object.getParameter().getHmisId();
			 hmisParameter = object.getParameter().getHmisParameter();
			 parameterId = object.getParameter().getId();
		 %> 
		 <td><input type="hidden" name="parameterId<%=counter%>" value="<%=parameterId%>"/> <input type="hidden" name="hmisId<%=counter%>" value="<%=hmisId%>"/><%=hmisId%> </td>
		 
		<%} %>
		 
	    <td><b><input type="hidden" name="hmisParameter<%=counter%>" value="<%=hmisParameter%>"/><%=hmisParameter%></b></td>
	    
	   <% if(hmisId.startsWith("M")){%>
	  		<td></td>
	   <%}else if(hmisId.startsWith("Part")) {%>
	 		<td></td>
		<%} else if(hmisParameter!=null && hmisParameter.equalsIgnoreCase("TT1")){%>  
			<td><input type="text" name="hmisCount<%=counter%>" value="<%=tt1Count%>"></td>  
		<%} else if(hmisParameter!=null && hmisParameter.equalsIgnoreCase("TT2 or Booster")){%>  
			<td><input type="text" name="hmisCount<%=counter%>" value="<%=tt2Count%>"></td>  
		<%}else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")<=2) { %>
			<td></td>
		<%} else{ 
			countOfTotalStock = pojoForHmisParameter.getCountOfTotalStock();
	    	countOfStockDistributed = pojoForHmisParameter.getCountOfStockDistributed();
	    	countOfBalanceOfPreviousMonth = pojoForHmisParameter.getCountOfBalanceOfPreviousMonth();
	    	countOfstockReceived = pojoForHmisParameter.getCountOfstockReceived();
	    	countOfUnusableStock = pojoForHmisParameter.getCountOfUnusableStock();
	        if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='a' ){%>  
		  		<td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfBalanceOfPreviousMonth%>"></td>
		   <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='b' ){%>  
		  		<td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfstockReceived%>"></td>
		   <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='c' ){%>  
		   		<td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfUnusableStock%>"></td>
		   <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='d' ){%>  
		  		<td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfStockDistributed%>"></td>
		   <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='e' ){%>  
		  		<td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfTotalStock%>"></td>  
		   <%} else { %>
	      		<td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=object.getHospitalModify()%>"></td>
		  		<input type="hidden" name="hmis<%=counter%>" value="<%=object.getId()%>" />
	   		<%} }
	  	++counter;
	  } 
  } else { 
	  counter=1;
	  

	 	MasPhReportsParameters object = null;
	  	for(ChildPojoForHmisParameter pojoForHmisParameter : hmisParametersList){ 
	  		object = pojoForHmisParameter.getMasPhReportsParameters();
	  	%>
	<tr>
		 <%if(object.getHmisId()!=null){ 
			 hmisId = object.getHmisId();
			 hmisParameter = object.getHmisParameter();
			 parameterId = object.getId();
		 %> 
		 <td><input type="hidden" name="parameterId<%=counter%>" value="<%=parameterId%>"/> <input type="hidden" name="hmisId<%=counter%>" value="<%=hmisId%>"/><%=hmisId%> </td>
		 
		<%} %>
		 
	    <td><b><input type="hidden" name="hmisParameter<%=counter%>" value="<%=hmisParameter%>"/><%=hmisParameter%></b></td>
	    
	   <% if(hmisId.startsWith("M")){%>
	  		<td></td>
	   <%}else if(hmisId.startsWith("Part")) {%>
	 		<td></td>
		<%} else if(hmisParameter!=null && hmisParameter.equalsIgnoreCase("TT1")){%>  
			<td><input type="text" name="hmisCount<%=counter%>" value="<%=tt1Count%>">
			<input type="hidden" id="ahmisCount<%=counter%>" name="ahmisCount<%=counter%>" value="<%=tt1Count%>"></td>  
		<%} else if(hmisParameter!=null && hmisParameter.equalsIgnoreCase("TT2 or Booster")){%>  
			<td><input type="text" name="hmisCount<%=counter%>" value="<%=tt2Count%>">
			<input type="hidden" id="ahmisCount<%=counter%>" name="ahmisCount<%=counter%>" value="<%=tt2Count%>"></td>  
		<%}else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")<=2) { %>
			<td></td>
		<%} else{ 
			countOfTotalStock = pojoForHmisParameter.getCountOfTotalStock();
	    	countOfStockDistributed = pojoForHmisParameter.getCountOfStockDistributed();
	    	countOfBalanceOfPreviousMonth = pojoForHmisParameter.getCountOfBalanceOfPreviousMonth();
	    	countOfstockReceived = pojoForHmisParameter.getCountOfstockReceived();
	    	countOfUnusableStock = pojoForHmisParameter.getCountOfUnusableStock();
	        if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='a' ){%>  
		  		<td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfBalanceOfPreviousMonth%>"></td>
		   <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='b' ){%>  
		  		<td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfstockReceived%>"></td>
		   <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='c' ){%>  
		   		<td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfUnusableStock%>"></td>
		   <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='d' ){%>  
		  		<td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfStockDistributed%>"></td>
		   <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='e' ){%>  
		  		<td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfTotalStock%>"></td>  
		   <%} else { %>
		   		<td><input type="text" id="hmisCount<%=counter%>" name="hmisCount<%=counter%>">
				<input type="hidden" id="ahmisCount<%=counter%>" name="ahmisCount<%=counter%>"></td>
	   		<%} }
	  	++counter;
	  } %>

	  
	<input type="hidden" id="counter" value="<%=counter%>" /> 
<script >
<%
for(Object[] totalCount  :cList){
%>
document.getElementById('hmisCount3').value= '<%=totalCount[0]%>';
document.getElementById('ahmisCount3').value= '<%=totalCount[0]%>';

document.getElementById('hmisCount5').value= '<%=totalCount[1]%>';
document.getElementById('ahmisCount5').value= '<%=totalCount[1]%>';

document.getElementById('hmisCount6').value= '<%=totalCount[2]%>';
document.getElementById('ahmisCount6').value= '<%=totalCount[2]%>';

document.getElementById('hmisCount7').value= '<%=totalCount[3]%>';
document.getElementById('ahmisCount7').value= '<%=totalCount[3]%>';
if(document.getElementById('hmisCount9')!=null){
document.getElementById('hmisCount9').value= '<%=totalCount[4]!=null?totalCount[4]:0%>';
document.getElementById('ahmisCount9').value= '<%=totalCount[4]!=null?totalCount[4]:0%>';
}
if(document.getElementById('hmisCount10')!=null){
document.getElementById('hmisCount10').value= '<%=totalCount[5]!=null?totalCount[5]:0%>';
document.getElementById('ahmisCount10').value= '<%=totalCount[5]!=null?totalCount[5]:0%>'; 
}
document.getElementById('hmisCount11').value= '<%=totalCount[6]%>';
document.getElementById('ahmisCount11').value= '<%=totalCount[6]%>';

document.getElementById('hmisCount12').value= '<%=totalCount[7]%>';
document.getElementById('ahmisCount12').value= '<%=totalCount[7]%>';

document.getElementById('hmisCount23').value= '<%=totalCount[9]%>';
document.getElementById('ahmisCount23').value= '<%=totalCount[9]%>';

document.getElementById('hmisCount24').value= '<%=totalCount[10]%>';
document.getElementById('ahmisCount24').value= '<%=totalCount[10]%>';

document.getElementById('hmisCount25').value= '<%=totalCount[11]%>';
document.getElementById('ahmisCount25').value= '<%=totalCount[11]%>';

document.getElementById('hmisCount29').value= '<%=totalCount[12]%>';
document.getElementById('ahmisCount29').value= '<%=totalCount[12]%>';

document.getElementById('hmisCount42').value= <%=totalCount[13]%>;
document.getElementById('ahmisCount42').value= <%=totalCount[13]%>;

document.getElementById('hmisCount43').value= <%=totalCount[14]%>;
document.getElementById('ahmisCount43').value= <%=totalCount[14]%>;

document.getElementById('hmisCount44').value= <%=totalCount[15]%>;
document.getElementById('ahmisCount44').value= <%=totalCount[15]%>;

document.getElementById('hmisCount50').value= <%=totalCount[16]%>;
document.getElementById('ahmisCount50').value= <%=totalCount[16]%>;

document.getElementById('hmisCount51').value= <%=totalCount[17]%>;
document.getElementById('ahmisCount51').value= <%=totalCount[17]%>;

document.getElementById('hmisCount52').value= <%=totalCount[18]%>;
document.getElementById('ahmisCount52').value= <%=totalCount[18]%>;

document.getElementById('hmisCount54').value= <%=totalCount[19]%>;
document.getElementById('ahmisCount54').value= <%=totalCount[19]%>;

document.getElementById('hmisCount55').value= <%=totalCount[20]%>;
document.getElementById('ahmisCount55').value= <%=totalCount[20]%>;

document.getElementById('hmisCount57').value= <%=totalCount[21]%>;
document.getElementById('ahmisCount57').value= <%=totalCount[21]%>;

document.getElementById('hmisCount58').value= <%=totalCount[22]%>;
document.getElementById('ahmisCount58').value= <%=totalCount[22]%>;

document.getElementById('hmisCount79').value= <%=totalCount[23]%>;
document.getElementById('ahmisCount79').value= <%=totalCount[23]%>;

document.getElementById('hmisCount80').value= <%=totalCount[24]%>;
document.getElementById('ahmisCount80').value= <%=totalCount[24]%>;

document.getElementById('hmisCount81').value= <%=totalCount[25]%>;
document.getElementById('ahmisCount81').value= <%=totalCount[25]%>;

document.getElementById('hmisCount82').value= <%=totalCount[26]%>;
document.getElementById('ahmisCount82').value= <%=totalCount[26]%>;

document.getElementById('hmisCount46').value= <%=totalCount[28]%>;
document.getElementById('ahmisCount46').value= <%=totalCount[28]%>;

<%}%>
</script>
	
<%	}
 %>
  
</tbody>
 </table>
 
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<%if(list.size()==0) {%> 
<input name="save" type="button" class="button" value="Save" onclick="submitForm('hmisreport','pubHealth?method=submitHmisHospitalReportData&counter='+<%=counter%>+'&'+csrfTokenName+'='+csrfTokenValue);"/>
<%}else{ %>
<input name="save" type="button" class="button" value="Update" onclick="submitForm('hmisreport','pubHealth?method=updateHmisHospitalReportData&counter='+<%=counter%>+'&'+csrfTokenName+'='+csrfTokenValue);"/>
<% }%>
 
</div>
 
</div>
 
 
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 <input type="hidden" name="reportName" value="<%=reportName%>" >
 
</form>

 
 	<%-- <div class="clear"></div>
 	<% if(hmisParameters.size()==0){%>
	<h2>No Records Available.</h2>
	<%} %>
	 --%>
 <script language="javascript">   
 //added by amit das on 27-04-2016
 window.onload = function () {
 	document.getElementById('hmisCount17').value= <%=hbValueForlowLevel%>;
 	if(document.getElementById('ahmisCount17'))
 	document.getElementById('ahmisCount17').value= <%=hbValueForlowLevel%>;
 	
 	document.getElementById('hmisCount18').value= <%=hbValueForhighLevel%>;
 	
 	if(document.getElementById('ahmisCount18'))
 	document.getElementById('ahmisCount18').value= <%=hbValueForhighLevel%>;
 }
 
 function monthValue(){
   var month=document.getElementById('months').value;
  
};

  
function submitProtoAjaxWithDivNameMonth(formName,action,divName){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
   	obj.action = action;
//alert("action"+action);
   	 var url=action+"&"+getNameAndDataOneData(formName);
//alert("url"+url);
   	 new Ajax.Updater(divName,url,
	   {asynchronous:true, evalScripts:true });
   	return true;
    };
	
  
    function getNameAndDataOneData(formName) {
     var month=document.getElementById('months');
          var str="";
       inputs = eval('document.'+formName+'.elements');
           	str=str+month.name+"="+month.value
    //   	alert(str.length);
       return str;
    }; 
     
    function checkMonth()
	{
	var currentMonth= <%=Integer.parseInt(month)%>;
	var selectedMonth= document.getElementById('months').value;
	if(selectedMonth>currentMonth)
	{
	alert("You can't get the value of Next upcoming month");
	return false;
	
	}
	return true;
	}
	</script>
