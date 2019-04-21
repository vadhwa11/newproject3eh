
<%@page import="java.math.BigInteger"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="jkt.hms.util.ChildPojoForHmisParameter"%>
<%@page import="jkt.hms.masters.business.HmisDistrictReport"%>
<%@page import="jkt.hms.masters.business.MasPhReportsParameters"%>
<%@ page import="java.util.*" %>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil" %>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"
	id="vbulletin_css" />
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
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<%
Map map = new HashMap();
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


//added by Amit Das on 26-04-2016
List<ChildPojoForHmisParameter> hmisParametersList = new ArrayList<ChildPojoForHmisParameter>();
if(map.get("hmisParametersList") != null){
	hmisParametersList=(List<ChildPojoForHmisParameter> ) map.get("hmisParametersList");	
}


List<MasPhReportsParameters> hmisParameters = new ArrayList<MasPhReportsParameters>();
if(map.get("hmisParameters") != null){
	hmisParameters=(List<MasPhReportsParameters> ) map.get("hmisParameters");	
}
List<HmisDistrictReport> list = new ArrayList<HmisDistrictReport>();
if(map.get("list") != null){
	list=(List<HmisDistrictReport> ) map.get("list");	
}
String propertyName="";
if(map.get("propertyName") != null){
	propertyName=(String) map.get("propertyName");	
}

 
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }
//added by amit das on 27-04-2016
long hbValueForhighLevel = 0;
long hbValueForlowLevel = 0;
for(Object[] totalCount: cList){
	hbValueForlowLevel	= ((BigInteger)totalCount[29]).longValue();
	hbValueForhighLevel	= ((BigInteger)totalCount[30]).longValue();
}

//added by amit das on 26-04-2016
//variables to show the stock related data of hmis paramater mapping 
int countOfTotalStock = 0;  
int countOfstockReceived = 0; 
int countOfUnusableStock = 0; 
int countOfStockDistributed = 0;
int countOfBalanceOfPreviousMonth = 0;


%>


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
		
	<%-- 	<input type="hidden" name="Id<%out.print(counter); %>" id="Id<%out.print(counter); %>"  value="<%=phms.getId()%>"> --%>
		<%if(phms.getParameter().getHmisId()==null) {%>
		<input type="hidden" name="parameterId<%=counter%>" value="<%=phms.getParameter().getId()%>"/>
		 <input type="hidden" name="hmisId<%=counter%>" value="<%=phms.getParameter().getHmisId()%>" />
		
		<td></td>
		 <%}else{%> 
		 <td> <input type="hidden" name="hmisId<%=counter%>" value="<%=phms.getParameter().getHmisId()%>"/><%=phms.getParameter().getHmisId()%> </td>
		
		 <%} %>
	    <td><b><input type="hidden" name="hmisParameter<%=counter%>" value="<%=phms.getParameter().getHmisParameter()%>"/><%=phms.getParameter().getHmisParameter()%></b></td>
	    
	   <%if(propertyName.equalsIgnoreCase("Thiruvananthapuram")){
	   if(phms.getParameter().getHmisId().startsWith("M")){%>
	   <td></td>
	   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
	 <td></td>
	 <%}else if(phms.getParameter().getHmisId().startsWith("16") && StringUtils.countMatches(phms.getParameter().getHmisId(), ".")<=2) {
	    	countOfTotalStock = pojoForHmisParameter.getCountOfTotalStock();
	    	countOfStockDistributed = pojoForHmisParameter.getCountOfStockDistributed();
	    	countOfBalanceOfPreviousMonth = pojoForHmisParameter.getCountOfBalanceOfPreviousMonth();
	    	countOfstockReceived = pojoForHmisParameter.getCountOfstockReceived();
	    	countOfUnusableStock = pojoForHmisParameter.getCountOfUnusableStock();
	    %>
		 <td></td>
		  <%} else if(phms.getParameter().getHmisId().startsWith("16") && StringUtils.countMatches(phms.getParameter().getHmisId(), ".")>2 && phms.getParameter().getHmisId().charAt(phms.getParameter().getHmisId().length()-1)=='a' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfBalanceOfPreviousMonth%>"></td>
		  <%} else if(phms.getParameter().getHmisId().startsWith("16") && StringUtils.countMatches(phms.getParameter().getHmisId(), ".")>2 && phms.getParameter().getHmisId().charAt(phms.getParameter().getHmisId().length()-1)=='b' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfstockReceived%>"></td>
		  <%} else if(phms.getParameter().getHmisId().startsWith("16") && StringUtils.countMatches(phms.getParameter().getHmisId(), ".")>2 && phms.getParameter().getHmisId().charAt(phms.getParameter().getHmisId().length()-1)=='c' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfUnusableStock%>"></td>
		  <%} else if(phms.getParameter().getHmisId().startsWith("16") && StringUtils.countMatches(phms.getParameter().getHmisId(), ".")>2 && phms.getParameter().getHmisId().charAt(phms.getParameter().getHmisId().length()-1)=='d' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfStockDistributed%>"></td>
		  <%} else if(phms.getParameter().getHmisId().startsWith("16") && StringUtils.countMatches(phms.getParameter().getHmisId(), ".")>2 && phms.getParameter().getHmisId().charAt(phms.getParameter().getHmisId().length()-1)=='e' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfTotalStock%>"></td>  
	    <%}else if(counter==17){ %>
	    
	<td><input type="text" name="hmisCount<%=counter%>" value="<%=hbValueForlowLevel%>"></td>
	 <input type="hidden" name="hmis<%=counter%>" value="<%=phms.getId()%>" />
	 <%}   else if(counter==18){ %>
	    
	<td><input type="text" name="hmisCount<%=counter%>" value="<%=hbValueForhighLevel%>"></td>
	 <input type="hidden" name="hmis<%=counter%>" value="<%=phms.getId()%>" />
	    
	    <%  } else{%>
	    
	    
	<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getThiruvananthapuramModify()%>"></td>
	 <input type="hidden" name="hmis<%=counter%>" value="<%=phms.getId()%>" />
	     
	   <%}}else if(propertyName.equalsIgnoreCase("ALAPPUZHA")){
		   if(phms.getParameter().getHmisId().startsWith("M")){%>
		   <td></td>
		   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
		 <td></td>
		    <%}else{%>
		    
		<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getAlappuzhaModify()%>"></td>
			     
		   <%}}else if(propertyName.equalsIgnoreCase("Ernakulam")){
			   if(phms.getParameter().getHmisId().startsWith("M")){%>
			   <td></td>
			   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
			 <td></td>
			    <%}else{%>
			    
			<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getErnakulamModify()%>"></td>
			     
			   <%}}else if(propertyName.equalsIgnoreCase("Idukki")){
				   if(phms.getParameter().getHmisId().startsWith("M")){%>
				   <td></td>
				   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
				 <td></td>
				    <%}else{%>
				    
				<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getIdukkiModify()%>"></td>
				     
				   <%}}else if(propertyName.equalsIgnoreCase("Kannur")){
					   if(phms.getParameter().getHmisId().startsWith("M")){%>
					   <td></td>
					   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
					 <td></td>
					    <%}else{%>
					<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getKannurModify()%>"></td>
					     
		 <%}}  else if(propertyName.equalsIgnoreCase("Kasaragod")){
			   if(phms.getParameter().getHmisId().startsWith("M")){%>
			   <td></td>
			   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
			 <td></td>
			    <%}else{%>
			    
			<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getKasaragodModify()%>"></td>
			     
	 <%}}   else if(propertyName.equalsIgnoreCase("Kollam")){
		   if(phms.getParameter().getHmisId().startsWith("M")){%>
		   <td></td>
		   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
		 <td></td>
		    <%}else{%>
		    
		<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getKollamModify()%>"></td>
		     
		   <%}} 
	   
	 else if(propertyName.equalsIgnoreCase("Kottayam")){
		   if(phms.getParameter().getHmisId().startsWith("M")){%>
		   <td></td>
		   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
		 <td></td>
		    <%}else{%>
		    
		<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getKottayamModify()%>"></td>
		     
		   <%}} 
	   
	   else if(propertyName.equalsIgnoreCase("Kozhikode")){
		   if(phms.getParameter().getHmisId().startsWith("M")){%>
		   <td></td>
		   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
		 <td></td>
		    <%}else{%>
		    
		<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getKozhikodeModify()%>"></td>
		     
		   <%}}  
	  else if(propertyName.equalsIgnoreCase("Malappuram")){
          if(phms.getParameter().getHmisId().startsWith("M")){%>
		   <td></td>
		   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
		 <td></td>
		    <%}else{%>
		    
		<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getMalappuramModify()%>"></td>
		     
		   <%}}  else if(propertyName.equalsIgnoreCase("Palakkad")){
	            if(phms.getParameter().getHmisId().startsWith("M")){%>
	 		   <td></td>
	 		   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
	 		 <td></td>
	 		    <%}else{%>
	 		    
	 		<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getPalakkadModify()%>"></td>
	 		     
	 		   <%}}   else if(propertyName.equalsIgnoreCase("Pathanamthitta")){
          if(phms.getParameter().getHmisId().startsWith("M")){%>
		   <td></td>
		   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
		 <td></td>
		    <%}else{%>
		    
		<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getPathanamthittaModify()%>"></td>
		     
		   <%}}
	 		  else if(propertyName.equalsIgnoreCase("Thrissur")){
	 	            if(phms.getParameter().getHmisId().startsWith("M")){%>
	 			   <td></td>
	 			   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
	 			 <td></td>
	 			    <%}else{%>
	 			    
	 			<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getThrissurModify()%>"></td>
	 			     
	 			   <%}}  else if(propertyName.equalsIgnoreCase("Wayanad")){
	 		            if(phms.getParameter().getHmisId().startsWith("M")){%>
	 				   <td></td>
	 				   <%}else if(phms.getParameter().getHmisId().startsWith("Part")) {%>
	 				 <td></td>
	 				    <%}else{%>
	 				    
	 				<td><input type="text" name="hmisCount<%=counter%>" value="<%=phms.getWayanadModify()%>"></td>
	 				     
	 				   <%}}  %> 
	   
	 <%   ++counter;
	      }
	    %> 
	  


<%}else{ %>
 
	<% 
	  counter=1;
	// for(MasPhReportsParameters phms:hmisParameters){ // commented by amit das on 26-04-2016
			MasPhReportsParameters phms = null;
		 for(ChildPojoForHmisParameter pojoForHmisParameter : hmisParametersList){	
			 phms = pojoForHmisParameter.getMasPhReportsParameters();
	 %>
	<tr>
	
<%-- 	<input type="hidden" name="Id<%out.print(counter); %>" id="Id<%out.print(counter); %>"  value="<%=phms.getId()%>"> --%>
	<%if(phms.getHmisId()==null) {%>
	<input type="hidden" name="parameterId<%=counter%>" value="<%=phms.getId()%>"/>
	 <input type="hidden" name="hmisId<%=counter%>" value="<%=phms.getHmisId()%>" />
	<td></td>
	 <%}else{%> 
	 <td><input type="hidden" name="parameterId<%=counter%>" value="<%=phms.getId()%>"/> <input type="hidden" name="hmisId<%=counter%>" value="<%=phms.getHmisId()%>"/><%=phms.getHmisId()%> </td>
	
	 <%} %>
    <td><b><input type="hidden" name="hmisParameter<%=counter%>" value="<%=phms.getHmisParameter()%>"/><%=phms.getHmisParameter()%></b></td>
    
 
  <% if(phms.getHmisId().startsWith("M")){%>
   <td></td>
   <%}else if(phms.getHmisId().startsWith("Part")) {%>
 <td></td>
 <%}else if(phms.getHmisId().startsWith("16") && StringUtils.countMatches(phms.getHmisId(), ".")<=2) {
	    	countOfTotalStock = pojoForHmisParameter.getCountOfTotalStock();
	    	countOfStockDistributed = pojoForHmisParameter.getCountOfStockDistributed();
	    	countOfBalanceOfPreviousMonth = pojoForHmisParameter.getCountOfBalanceOfPreviousMonth();
	    	countOfstockReceived = pojoForHmisParameter.getCountOfstockReceived();
	    	countOfUnusableStock = pojoForHmisParameter.getCountOfUnusableStock();
	    %>
		 <td></td>
		  <%} else if(phms.getHmisId().startsWith("16") && StringUtils.countMatches(phms.getHmisId(), ".")>2 && phms.getHmisId().charAt(phms.getHmisId().length()-1)=='a' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfBalanceOfPreviousMonth%>"></td>
		  <%} else if(phms.getHmisId().startsWith("16") && StringUtils.countMatches(phms.getHmisId(), ".")>2 && phms.getHmisId().charAt(phms.getHmisId().length()-1)=='b' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfstockReceived%>"></td>
		  <%} else if(phms.getHmisId().startsWith("16") && StringUtils.countMatches(phms.getHmisId(), ".")>2 && phms.getHmisId().charAt(phms.getHmisId().length()-1)=='c' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfUnusableStock%>"></td>
		  <%} else if(phms.getHmisId().startsWith("16") && StringUtils.countMatches(phms.getHmisId(), ".")>2 && phms.getHmisId().charAt(phms.getHmisId().length()-1)=='d' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfStockDistributed%>"></td>
		  <%} else if(phms.getHmisId().startsWith("16") && StringUtils.countMatches(phms.getHmisId(), ".")>2 && phms.getHmisId().charAt(phms.getHmisId().length()-1)=='e' ){%>  
		  <td><input type="text" name="hmisCount<%=counter%>" value="<%=countOfTotalStock%>"></td>  
   <%} else if(counter==17){ %>
	    
	<td><input type="text" name="hmisCount<%=counter%>" value="<%=hbValueForlowLevel%>">
	<input type="hidden" id="ahmisCount<%=counter%>" name="ahmisCount<%=counter%>">
	</td>
	 <%}   else if(counter==18){ %>
	    
	<td><input type="text" name="hmisCount<%=counter%>" value="<%=hbValueForhighLevel%>">
	 <input type="hidden" id="ahmisCount<%=counter%>" name="ahmisCount<%=counter%>">
	    </td>
	    <%  } else{%>
<td><input type="text" id="hmisCount<%=counter%>" name="hmisCount<%=counter%>"><input type="hidden" id="ahmisCount<%=counter%>" name="ahmisCount<%=counter%>"></td>
     
   <%}%>
  </tr>
 <%   ++counter;
      } %>
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

document.getElementById('hmisCount9').value= <%=totalCount[4]%>;
document.getElementById('ahmisCount9').value= <%=totalCount[4]%>;

document.getElementById('hmisCount10').value=<%=totalCount[5]%>;
document.getElementById('ahmisCount10').value=<%=totalCount[5]%>;

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
 <%}
 %>
  
</tbody >
 </table>
 <div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>


<%if(list.size()==0) {%> 
<input name="save" type="button" class="button" value="Save" onclick="submitForm('hmisreport','pubHealth?method=submitHmisReportData&counter='+<%=counter%>);"/>
<%}else{ %>
<input name="save" type="button" class="button" value="Update" onclick="submitForm('hmisreport','pubHealth?method=updateHmisReportData&counter='+<%=counter%>);"/>
<% }%>
 
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
