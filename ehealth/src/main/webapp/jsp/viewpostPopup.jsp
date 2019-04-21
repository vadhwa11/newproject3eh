<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.HrTransferApplicationM"%>
<%@page import="jkt.hms.masters.business.HrTransferApplicationT"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasHospital> masHospital = new ArrayList<MasHospital>();
				List<MasRank> masRank = new ArrayList<MasRank>();
				List<Object[]> availPostList = new ArrayList<Object[]>();
				List<HrTransferApplicationT> hrTransferApplicationTList = new ArrayList<HrTransferApplicationT>();
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("masHospital")!= null){
					masHospital = (List<MasHospital>)map.get("masHospital");
				}
				if(map.get("masRank")!= null){
					masRank = (List<MasRank>)map.get("masRank");
				}
				if(map.get("hrTransferApplicationTList")!= null){
					hrTransferApplicationTList = (List<HrTransferApplicationT>)map.get("hrTransferApplicationTList");
				}
				if(map.get("rankListFromEmp")!= null){
					availPostList = (List<Object[]>)map.get("rankListFromEmp");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
			int travelRequestId = 0;	
			int employeeId = 0;
			String refNo = "";
			Date fromDate = new Date();
			Date toDate = new Date();
			int travelTypeId  = 0;
			String tripName = "";
			String empName = "";
			String rankName = "";
		
			int ticketAttachId = 0;
			
		%>
				
	
<%-- <%@page import="jkt.erp.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.erp.hrms.masters.business.TempTickattach"%> --%>
<form name="viewBookingDetail1" method="post" action="" enctype="multipart/form-data">
<div class="titleBg"> <h2>Transfer Priority </h2></div>
<div class="clear"></div>

<div class="clear"></div>
<table id="searchresulttable" class="small">
<tr>
<th>Centre Name</th>
<th>Available post</th>
</tr>
<%
System.out.print(" hosp rankId>>  "+availPostList.size());
	int i = 0;
	if(availPostList.size()>0){
		for(Object[] availPost : availPostList){
			System.out.print(availPost.length);
			 int rankId=Integer.parseInt(""+availPost[1]);
			 int hosp=Integer.parseInt(""+availPost[2]);
				System.out.print(" hosp 1 rankId  "+rankId);
				System.out.print(hosp+" hosp rankId  "+rankId);
%>
<tr>
<%

for(MasHospital mh : masHospital)
if(mh.getId() == hosp){ 
	int post=Integer.parseInt(""+availPost[0]);
%>
<td><%=mh.getHospitalName()%>
</td>
<td><%=post %>
<input type="hidden" id="travelRequestId" name="<%=TRAVEL_REQUEST_ID%>" value="<%=travelRequestId %>" /> 
<input type="hidden"  name="<%=EMPLOYEE_ID%>" value="<%=employeeId %>" /> </td>
</tr>
<%i++;
	}}}
%>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">

<input name="add" type="button" class="button" value="Close" onClick="window.close();"/>
 <!--   <input type="button" name="add" id="addbutton" value="Back" class="button" onClick="backProjectSetting();" accesskey="a" tabindex=1 />-->
<div class="clear"></div>


<script type="text/javascript">

	</script>

<div class="clear"></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
