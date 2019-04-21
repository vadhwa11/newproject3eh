<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientDischargeSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>
<%@page import="jkt.hms.masters.business.PhMasOrgCategory"%>
<%@page import="jkt.hms.masters.business.PhVillageSurvey"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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
		String userName = "";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String currentTime = (String)utilMap.get("currentTime");
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		Map<String, Object> map=new HashMap<String, Object>();
		
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
	
		List<Object[]> applockPass = new ArrayList<Object[]>();
		if(map.get("applockPass")!=null){
			applockPass=(List<Object[]>)map.get("applockPass");
		}
		String CurrentDate=date+"/"+month+"/"+year;
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	
function checkData(){
			
			var start= new Date(document.getElementById("fromDate").value.split("/")[2], document.getElementById("fromDate").value.split("/")[1], document.getElementById("fromDate").value.split("/")[0]);
			 var end= new Date(document.getElementById("toDate").value.split("/")[2], document.getElementById("toDate").value.split("/")[1], document.getElementById("toDate").value.split("/")[0]);
			 if(start>=end){
				 alert("Date is Incorrect.");
				 return false;
				 
			 }else{return true;
			 
			 }
		}
			
</script>

<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>App Lock Password</h2>
</div>

<div class="Block">
<div class="clear"></div>
 <label><span>* </span>From Date</label> 
 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=CurrentDate %>" name="fromDate">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"/> 
	<label><span>* </span>To Date</label>
	 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=CurrentDate %>" name="toDate">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"/>

<input type="button" name="Search" id="addbutton"	onclick="if(checkData()){submitForm('search','/hms/hms/pubHealth?method=detailApplockPassword','tDivss');}" value="Search"	class="button" style="margin-left:15px;"  />
<div class="clear"></div>
</div>                                                                         
</form>
<div class="clear"></div>
<form name="memberDetail" method="post"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>IMEI Number & App Lock Password Details</h4>
<div class="clear"></div>
<div class="Block">
<div id="pageNavPosition"></div>
<div class="clear"></div>
 <% if(applockPass.size()>0){
 %>
<table >
<tr>
	    <th scope="col">LOGIN NAME</th>
		<th scope="col">IMEI NUMBER</th>		
		<th scope="col">PHONE APP LOCK PASSWORD</th>
		<th scope="col">DATE</th>
		<th scope="col">STATUS</th>
	</tr>
<tbody id="tableData">
   
	<% 
	int  counter=0;
	for(Object[] alps:applockPass){
		Date d =(Date)alps[3];
	 %>
	  <tr>  
	<td><%=alps[0]%></td>
    <td><%=alps[1]%></td>
    <td><%=alps[2]%></td>
    <td> <%=HMSUtil.convertDateTypeToStringWithoutTime(d)%></td>
    <%if(alps[4]!=null){ %>
    <td><%=alps[4]%></td>
    <%}else{ %>
    <td></td>	
    <%} %>
   
    
  </tr>
 <%   ++counter;
      }
    %>
  
</tbody>
 </table> 
 <%} %>
 </div>
 </form>

 	<%-- <%}else{ %> --%>
 	<div class="clear"></div>
 	<% if(applockPass.size()==0){%>
	<h2>No Records Available.</h2>
	<%} %>
		
<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
</script>  
 <div class="clear"></div>
 <div class="clear"></div>

