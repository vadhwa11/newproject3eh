<%@page import="jkt.hms.masters.business.PhAtpJphnJhiHeader"%>
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
<form name="cashVoucher" method="post" action="">
<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
       Map<String,Object> utilMap = new HashMap<String,Object>();
       utilMap = (Map)HMSUtil.getCurrentDateAndTime();
       String date = (String)utilMap.get("currentDate");
       String time = (String)utilMap.get("currentTime");
       String userName = "";
       if (session.getAttribute("userName") != null) {
               userName = (String) session.getAttribute("userName");
       }
  
       List<Object[]> phAtpJphnJhiHeaderList = new ArrayList<Object[]>();
 	  	if(map.get("phAtpJphnJhiHeaderList") != null){
 	  		phAtpJphnJhiHeaderList = (List<Object[]>)map.get("phAtpJphnJhiHeaderList");
	}

       
       
     
String message = "";
       if(map.get("message") != null){
               message = (String)map.get("message");
               %>
<h4><span><%=message %></span></h4>
       <%}
%>

<div class="titleBg">
<h2>ATP JPHN JHI Approval</h2>
</div>
<div class="Block">
<label>JPHN/JHI<span>*</span></label>
<select id="atpHeaderId"  name="atpHeaderId" onchange="submitProtoAjaxWithDivName('cashVoucher','/hms/hms/pubHealth?method=getAtpJphnJhiDetail','testDiv');">
<option value="0">Select</option>			
			   <%if(phAtpJphnJhiHeaderList.size()>0){ 
			       for(Object[] phAtpJphnJhiHeader : phAtpJphnJhiHeaderList){ %>	
		<option value="<%=phAtpJphnJhiHeader[0]%>" ><%=phAtpJphnJhiHeader[1] %></option>		
	<%	
	}
		}%>
</select>
</div>
<div class="clear"></div>
  <div id="testDiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0"      id="voucherDetails" class="cmntable">
    <tr>
   		<th scope="col">Date</th>
		<th scope="col" colspan="4"  align="right">Pending Day Block</th>
		<th scope="col" colspan="4" align="right">Current Day Block</th>
		<th scope="col">Routine Activities</th>
		<th scope="col">Other Activities</th>
		<th scope="col">After Noon Activities</th>
		<th scope="col">Remarks</th>        
		</tr>
		<tr>
		<th></th>
		<th>Day Block</th>
		<th>No. of House</th>
		<th>Locality</th>
		<th>Ward</th>
		<th>Day Block</th>
		<th>No. of House</th>
		<th>Locality</th>
		<th>Ward</th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		</tr>       
       </table> 
</div>
<div class="clear"></div>
 <div class="clear"></div>
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

<div class="clear"></div>
<div class="clear"></div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
