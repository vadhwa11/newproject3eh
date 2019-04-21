<%@page import="jkt.hms.masters.business.MasPhReportsParameters"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="jkt.hms.util.ChildPojoForHmisParameter"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="jkt.hms.masters.business.HmisDistrictReport"%>
<%@page import="jkt.hms.masters.business.MasHmisParameters"%>
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

//List<PhMemberSurvey> phmsList = new ArrayList<PhMemberSurvey>();
List<Object[]> cList =new ArrayList<Object[]>();
if(map.get("countList") != null){
	cList=(List<Object[]> ) map.get("countList");	
}
List<MasHmisParameters> hmisParameters = new ArrayList<MasHmisParameters>();
if(map.get("hmisParameters") != null){
	hmisParameters=(List<MasHmisParameters> ) map.get("hmisParameters");	
}

// added by Amit Das on 26-04-2016
List<ChildPojoForHmisParameter> hmisParametersList = new ArrayList<ChildPojoForHmisParameter>();
if(map.get("hmisParametersList") != null){
	hmisParametersList=(List<ChildPojoForHmisParameter> ) map.get("hmisParametersList");	
}


List<HmisDistrictReport> list = new ArrayList<HmisDistrictReport>();
if(map.get("list") != null){
	list=(List<HmisDistrictReport> ) map.get("list");	
}
String propertyName="";
if(map.get("propertyName") != null){
	propertyName=(String) map.get("propertyName");	
}

// added by amit das on 06-12-2016
if(map.get("reportName") != null){
	reportName=(String) map.get("reportName");	
}

 
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
}


// added by amit das on 25-08-2016
long tt1Count = 0;
long tt2Count = 0;

//added by amit das on 27-04-2016
long hbValueForhighLevel = 0;
long hbValueForlowLevel = 0;
for(Object[] totalCount: cList){
	hbValueForlowLevel	= ((BigInteger)totalCount[29]).longValue();
	hbValueForhighLevel	= ((BigInteger)totalCount[30]).longValue();
	// added by amit das on 25-08-2016
	tt1Count	= ((BigInteger)totalCount[31]).longValue();
	tt2Count	= ((BigInteger)totalCount[32]).longValue();
}

// added by amit das on 26-04-2016
// variables to show the stock related data of hmis paramater mapping 
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
<select  validate="Month,string,no" name="months" id="months" onchange="submitProtoAjaxWithDivNameMonth('hmisreport','/hms/hms/pubHealth?method=gethmisbyMonthValue&monthValue='+this.value+'&'+csrfTokenName+'='+csrfTokenValue,'testDivs');">
<!-- Changed by Amit Das on 26-04-2016 -->
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

 <% if(!reportName.equalsIgnoreCase("hmis") && !reportName.equalsIgnoreCase("internalReportAnnuallyDistrict") && !reportName.equalsIgnoreCase("internalReportAnnuallyState") && !reportName.equalsIgnoreCase("nvbdcp")) {%>
 <label><span>*</span> District</label>
 <select name="districtName" id="districtName" validate="District,string,yes">
 <!-- <option value="all">All</option> -->
 <option value="">Select</option>
 <option value="ALAPPUZHA">Alappuzha</option>
 <option value="Ernakulam">Ernakulam</option>
 <option value="Idukki">Idukki</option>
 <option value="Kannur">Kannur</option>
 <option value="Kasaragod">Kasaragod</option>
 <option value="Kollam">Kollam</option>
 <option value="Kottayam">Kottayam</option>
 <option value="Kozhikode">Kozhikode</option>
 <option value="Malappuram">Malappuram</option>
 <option value="Palakkad">Palakkad</option>
 <option value="Pathanamthitta">Pathanamthitta</option>
 <option value="THIRUVANANTHAPURAM">Thiruvananthapuram</option>
 <option value="Thrissur">Thrissur</option>
 <option value="Wayanad">Wayyand</option>
 </select>
 <% } %>
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
		
		
		//for(HmisDistrictReport phms:list){  // commented by Amit Das on 26-04-2016
		// added by Amit Das on 26-04-2016
		HmisDistrictReport phms = null;
		for(ChildPojoForHmisParameter pojoForHmisParameter : hmisParametersList){
			phms =	pojoForHmisParameter.getHmisDistrictReport();
		
		 %>
	<tr>
		 
		 <!-- added by amit das on 25-08-2016 -->
		 <%if(phms.getParameter().getHmisId()!=null){ 
			 hmisId = phms.getParameter().getHmisId();
			 hmisParameter = phms.getParameter().getHmisParameter();
			 parameterId = phms.getParameter().getId();
		 %> 
		 <td><input type="hidden" name="parameterId<%=counter%>" value="<%=parameterId%>"/> <input type="hidden" name="hmisId<%=counter%>" value="<%=hmisId%>"/><%=hmisId%> </td>
		 
		<%} %>
		 
	    <td><b><input type="hidden" name="hmisParameter<%=counter%>" value="<%=hmisParameter%>"/><%=hmisParameter%></b></td>
	    
	   <% if(hmisId.startsWith("M")){%>
	   <td></td>
	   <%}else if(hmisId.startsWith("Part")) {%>
	 <td></td>
	   <!-- added by amit das on 25-08-2016 for TT1 and TT2 -->
		  <%} else if(hmisParameter!=null && hmisParameter.equalsIgnoreCase("TT1")){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=tt1Count%>"></td>  
		  <%} else if(hmisParameter!=null && hmisParameter.equalsIgnoreCase("TT2 or Booster")){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=tt2Count%>"></td>  
		<%}else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")<=2) { %>
			 <td></td>
		<%} else{
	      if(propertyName.equalsIgnoreCase("Thiruvananthapuram")){
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
	      <td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getThiruvananthapuramModify()%>"></td>
		  <input type="hidden" name="hmis<%=counter%>" value="<%=phms.getId()%>" />
	     
	   <%} } else if(propertyName.equalsIgnoreCase("ALAPPUZHA")){ %>  
			<td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getAlappuzhaModify()%>"></td>
			     
	   <%} else if(propertyName.equalsIgnoreCase("Ernakulam")){ %>   
			<td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getErnakulamModify()%>"></td>
			     
	   <%} else if(propertyName.equalsIgnoreCase("Idukki")){ %>   
			<td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getIdukkiModify()%>"></td>
				     
	   <%} else if(propertyName.equalsIgnoreCase("Kannur")){ %>
		    <td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getKannurModify()%>"></td>
					     
	   <%} else if(propertyName.equalsIgnoreCase("Kasaragod")){ %>
		    <td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getKasaragodModify()%>"></td>
			     
	   <%} else if(propertyName.equalsIgnoreCase("Kollam")){ %>
		   <td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getKollamModify()%>"></td>
		     
	   <%} else if(propertyName.equalsIgnoreCase("Kottayam")){ %>
		   <td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getKottayamModify()%>"></td>
		     
	   <%} else if(propertyName.equalsIgnoreCase("Kozhikode")){ %>
		   <td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getKozhikodeModify()%>"></td>
		     
	   <%} else if(propertyName.equalsIgnoreCase("Malappuram")){ %>
          <td><input type="text" name="hmisCount<%=counter%>"  id="hmisCount<%=counter%>" value="<%=phms.getMalappuramModify()%>"></td>
		     
	   <%} else if(propertyName.equalsIgnoreCase("Palakkad")){ %>
	      <td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getPalakkadModify()%>"></td>
	 		     
	   <%} else if(propertyName.equalsIgnoreCase("Pathanamthitta")){ %>
          <td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getPathanamthittaModify()%>"></td>
		     
	   <%} else if(propertyName.equalsIgnoreCase("Thrissur")){ %>
	 	  <td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getThrissurModify()%>"></td>
	 			     
	   <%} else if(propertyName.equalsIgnoreCase("Wayanad")){ %>
	 	 <td><input type="text" name="hmisCount<%=counter%>" id="hmisCount<%=counter%>" value="<%=phms.getWayanadModify()%>"></td>
	 				     
	 	<%}  }  %> 
	   
	 <%   ++counter;
	      } 
	    %> 
<%}else{ %>
 
	<% 
	  counter=1;
	// for(MasHmisParameters phms:hmisParameters){ // commented by amit das on 26-04-2016
		MasPhReportsParameters phms = null;
	 for(ChildPojoForHmisParameter pojoForHmisParameter : hmisParametersList){	
		 phms = pojoForHmisParameter.getMasPhReportsParameters();
		 hmisId = phms.getHmisId();
	 	 hmisParameter = phms.getHmisParameter();
	 	 parameterId = phms.getId();
	 %>
	<tr>
	
<%-- 	<input type="hidden" name="Id<%out.print(counter); %>" id="Id<%out.print(counter); %>"  value="<%=phms.getId()%>"> --%>
	<td> <input type="hidden" name="parameterId<%=counter%>" value="<%=parameterId%>"/> <input type="hidden" name="hmisId<%=counter%>" value="<%=hmisId%>"/><%=hmisId%> </td>
	
	
    <td><b><input type="hidden" name="hmisParameter<%=counter%>" value="<%=hmisParameter%>"/><%=hmisParameter%></b></td>
    
 
  <% if(hmisId.startsWith("M")){%>
   <td></td>
   <%}else if(hmisId.startsWith("Part")) {%>
 <td></td>
 <%}else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")<=2) {
	    	countOfTotalStock = pojoForHmisParameter.getCountOfTotalStock();
	    	countOfStockDistributed = pojoForHmisParameter.getCountOfStockDistributed();
	    	countOfBalanceOfPreviousMonth = pojoForHmisParameter.getCountOfBalanceOfPreviousMonth();
	    	countOfstockReceived = pojoForHmisParameter.getCountOfstockReceived();
	    	countOfUnusableStock = pojoForHmisParameter.getCountOfUnusableStock();
	    %>
		 <td></td>
		  <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='a' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfBalanceOfPreviousMonth%>"></td>
		  <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='b' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfstockReceived%>"></td>
		  <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='c' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfUnusableStock%>"></td>
		  <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='d' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfStockDistributed%>"></td>
		  <%} else if(hmisId.startsWith("16") && StringUtils.countMatches(hmisId, ".")>2 && hmisId.charAt(hmisId.length()-1)=='e' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfTotalStock%>"></td>  
		  
		  
		   <!-- added by amit das on 25-08-2016 for TT1 and TT2 -->
		  <%} else if(hmisParameter!=null && hmisParameter.equalsIgnoreCase("TT1")){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=tt1Count%>"></td>  
		  <%} else if(hmisParameter!=null && hmisParameter.equalsIgnoreCase("TT2 or Booster")){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=tt2Count%>"></td>  
		  
    <%}else{%>
<td><input type="text" id="hmisCount<%=counter%>" name="hmisCount<%=counter%>">
	<input type="hidden" id="ahmisCount<%=counter%>" name="ahmisCount<%=counter%>"></td>
     
   <%}%>
  </tr>
 <%   
 ++counter;
      }
 
      %>
	<input type="hidden" id="counter" value="<%=counter%>" /> 
<script >
<%
for(Object[] totalCount  :cList){
%>
document.getElementById('hmisCount3').value= <%=totalCount[0]%>;
document.getElementById('ahmisCount3').value= <%=totalCount[0]%>;

document.getElementById('hmisCount5').value= <%=totalCount[1]%>;
document.getElementById('ahmisCount5').value= <%=totalCount[1]%>;

document.getElementById('hmisCount6').value= <%=totalCount[2]%>;
document.getElementById('ahmisCount6').value= <%=totalCount[2]%>;

document.getElementById('hmisCount7').value= <%=totalCount[3]%>;
document.getElementById('ahmisCount7').value= <%=totalCount[3]%>;
if(document.getElementById('hmisCount9')!=null){
document.getElementById('hmisCount9').value= <%=totalCount[4]%>;
document.getElementById('ahmisCount9').value= <%=totalCount[4]%>;
}
if(document.getElementById('hmisCount10')!=null){
document.getElementById('hmisCount10').value=<%=totalCount[5]%>;
document.getElementById('ahmisCount10').value=<%=totalCount[5]%>;
}
document.getElementById('hmisCount11').value=<%=totalCount[6]%>;
document.getElementById('ahmisCount11').value=<%=totalCount[6]%>;

document.getElementById('hmisCount12').value=<%=totalCount[7]%>;
document.getElementById('ahmisCount12').value=<%=totalCount[7]%>;

document.getElementById('hmisCount23').value=<%=totalCount[9]%>;
document.getElementById('ahmisCount23').value=<%=totalCount[9]%>;

document.getElementById('hmisCount24').value=<%=totalCount[10]%>;
document.getElementById('ahmisCount24').value=<%=totalCount[10]%>;

document.getElementById('hmisCount25').value=<%=totalCount[11]%>;
document.getElementById('ahmisCount25').value=<%=totalCount[11]%>;

document.getElementById('hmisCount29').value= <%=totalCount[12]%>;
document.getElementById('ahmisCount29').value= <%=totalCount[12]%>;

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
<input name="save" type="button" class="button" value="Save" onclick="submitForm('hmisreport','pubHealth?method=submitHmisReportData&counter='+<%=counter%>+'&'+csrfTokenName+'='+csrfTokenValue);"/>
<%}else{ %>
<input name="save" type="button" class="button" value="Update" onclick="submitForm('hmisreport','pubHealth?method=updateHmisReportData&counter='+<%=counter%>+'&'+csrfTokenName+'='+csrfTokenValue);"/>
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
