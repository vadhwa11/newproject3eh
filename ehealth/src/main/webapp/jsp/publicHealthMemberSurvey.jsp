
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
<%@page import="jkt.hms.masters.business.PhFamilySurvey"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
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
		List<Object[]> memberSurveys = new ArrayList<Object[]>();
		if(map.get("memberSurveys")!=null){
			memberSurveys=(List<Object[]>)map.get("memberSurveys");
		}
		List<MasAdministrativeSex> sex=new ArrayList<MasAdministrativeSex>();
		if(map.get("sex")!=null){
			sex=(List<MasAdministrativeSex>)map.get("sex");
		}
		
		String CurrentDate=date+"/"+month+"/"+year;
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		
	function checkData(){
// 		 if(start<=end){
				 return true;
// 			 }else{alert("Date is Incorrect.");return false;}
		}
</script>

<%-- <form name="search" action="" method="post">
<%  String message="";
	if(map.get("msg")!=null){
		message=(String)map.get("msg");
		out.print(message);
	} 
	%>
<div class="titleBg">
<h2>Member Survey</h2>
</div>
<div class="clear"></div>
<div class="Block">
     <label>Name</label> <input type="text"	name="name" value="" MAXLENGTH="30" id="name" />
	<label>Gender</label> 
 <select name="sexId" id="sexId" validate="Sex,metachar,no">
 <option value="">Select</option>
<%for(MasAdministrativeSex masSex:sex) 
{
%>
<option value="<%=masSex.getId() %>"><%=masSex.getAdministrativeSexName() %></option>

<%} %>
</select>   
	 <label>Family Name</label> <input type="text"	name="familyName" value="" MAXLENGTH="30" id="familyName" />
    <div class="clear"></div>
	<label>Ration Card</label>
	 <input type="text"	name="rationCard" value="" MAXLENGTH="30" id="rationCard" />
	 <label>Contact</label>
	 <input type="hidden" name="requestId" value="" value="<%=memberSurveys.size()>0 ? memberSurveys.get(0).getFamilyId():"" %>" />
	 <input type="text"	name="contact" value="" MAXLENGTH="30" id="contact" />
<div class="clear"></div>
</div>
<input type="button" name="Search" id="addbutton"	onclick="if(checkData()){submitForm('search','pubHealth?method=phMemberSurvey');}"	value="Search" class="button"  />


	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form> --%>
<div class="clear"></div>
<h4>Member Details</h4>
<div class="clear"></div>
<div class="Block">
<div id="pageNavPosition"></div>
<%if(memberSurveys.size()>0){ %>
<table>
	<tr><th>S.No</th> <th>Name</th> <th>Age</th> <th>Gender</th><th>Contact No</th><th>Family Name</th><th>Ration Card No</th></tr>
<tbody id="tableData">
 <% 
		 int  counter=0; 
 		for(Object[] phMemb:memberSurveys){ 
	%> 
    <form name="phHouseSurveys<%= counter+1%>" method="post">
   <input type="hidden" name="requestId" value="<%= phMemb[6]%>" />
   <%-- <tr onclick="submitForm('phHouseSurveys<%= counter+1%>', 'pubHealth?method=')"> --%><tr><td><%= counter+1%></td>
		   
	         <td><%= phMemb[0] != null ? phMemb[0] : ""%></td>
		    <td><%= phMemb[1] != null ? phMemb[1] : ""%></td>
		    <td><%=  phMemb[2] != null ? phMemb[2] : ""%></td>
		    <td><%=  phMemb[3] != null ? phMemb[3] : ""%></td>
		    <td><%= phMemb[4] != null ? phMemb[4] : ""%></td>
		    <td><%= phMemb[5] != null ? phMemb[5] : ""%></td>
		   <%--   <td><%= phMemb[6]%></td> --%>
	
		    </tr>
		   
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		   
		    </form>

<%		++counter;
				} 
 	%>  
 	 </tbody>
 		</table>
	<%}else{ %>
	No Records Available.
	<%} %>
	
	  <script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		</script>
	
	
	</div>
   <div class="clear"></div>
   <input type="button" name="Search" id="addbutton"	onclick="javascript:history.back(-1)"	value="Back" class="button"  />
   
 <div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
<!--Block Two Ends-->
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>