<%@page import="jkt.hms.masters.business.PrqInsuranceDetails"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
serverdate = '<%=date+"/"+month1+"/"+year1%>'

</script>
<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<PrqInsuranceDetails> prqInsuranceDetails=new ArrayList<PrqInsuranceDetails>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	 if(map.get("prqInsuranceDetails")!=null)
	   {
		 prqInsuranceDetails=(List<PrqInsuranceDetails>)map.get("prqInsuranceDetails");
	   } 
	%>
<div class="titleBg">
<h2>Pending Renewal list</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->

<form name="searchPanel" method="post">
<div class="Block">
<div class="clear"></div>

<label>Due Within Days </label>
<select name="dueDay" value=""	tabindex=1   id="dueDay" validate="DueDay,String,yes" >
<option value="0"> Select</option>
<option value="10"> 10 days</option>
<option value="20"> 20 days</option>
<option value="30"> 30 days</option>

</select>
<div class="clear"></div>
<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('searchPanel', 'procurement?method=showPendingRenewalInsurance')" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<div class="clear"></div>
<h4>Insurance Details</h4>
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
		<th>Sl No.</th>
		<th>Asset Code</th>
		<th>Asset Name</th>
	    <th>Policy no.</th>
	     <th>Date Of Insurance</th>
	      <th>Ins.End Date</th>
	       <th>Ins.Due Date</th>
		</tr>
	</thead>
	<tbody>
	<% 
			int sn=1;
		    if(prqInsuranceDetails.size()>0){
           for(PrqInsuranceDetails obj:prqInsuranceDetails){
        	   System.out.println(obj.getId());
        	    %><form name="itemList<%=sn%>" method="post">
        <%-- 	     <input type="hidden" name="requitionId" value="<%=obj.getId()%>" /> --%>
        	  <tr onclick="submitForm('itemList<%=sn%>', 'procurement?method=showRenewaljsp&requitionId=<%=obj.getId() %>')" style="cursor: pointer;"> 
        	   <td><%=sn%></td>
            
     
         <td><%=obj.getAsset()!=null ? obj.getAsset().getAssetCode():""%></td>
        <td><%=obj.getAsset()!=null ? obj.getAsset().getAssetName():""%></td>
        <td><%=obj.getPolicyNo()%></td> 
        <td><%=HMSUtil.changeDateToddMMyyyy(obj.getInsuranceDate())%></td> 
        <td><%=HMSUtil.changeDateToddMMyyyy(obj.getInsuranceEndDate()) %></td>
         <td><%=HMSUtil.changeDateToddMMyyyy(obj.getInsuranceEndDate()) %></input></td>
        
					</tr>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					
      	</form>
      	<%
		sn++;
           }}%>
	</tbody>

</table>

</div>
 
<div class="paddingTop15"></div>
<div class="clear"></div>
<div id="pagination">
Page <span class="selected">1</span>
</div>

