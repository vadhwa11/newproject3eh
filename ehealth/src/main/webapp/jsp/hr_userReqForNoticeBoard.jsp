
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%
Map map = new HashMap();
int pendingListSize=0;
int onHoldListSize=0;
int rejectedListSize=0;
int receivedApprovalListSize=0;


int ReqPendingListSize=0;
int ReqOnHoldListSize=0;
int ReqRejectedListSize=0;
int ReqReceivedApprovalListSize=0;
String url="";
if(request.getAttribute("map")!= null)
{
	map= (Map)request.getAttribute("map");
	if(map.get("pendingListSize")!=null){
	pendingListSize=(Integer)map.get("pendingListSize");
	}
	if(map.get("onHoldListSize")!=null){
	onHoldListSize=(Integer)map.get("onHoldListSize");
	}
	if(map.get("rejectedListSize")!=null){
	rejectedListSize=(Integer)map.get("rejectedListSize");
	}
	if(map.get("receivedApprovalListSize")!=null){
	receivedApprovalListSize=(Integer)map.get("receivedApprovalListSize");
	}
	
	if(map.get("ReqPendingListSize")!=null){
		ReqPendingListSize=(Integer)map.get("ReqPendingListSize");
		}
		if(map.get("ReqOnHoldListSize")!=null){
			ReqOnHoldListSize=(Integer)map.get("ReqOnHoldListSize");
		}
		if(map.get("ReqRejectedListSize")!=null){
			ReqRejectedListSize=(Integer)map.get("ReqRejectedListSize");
		}
		if(map.get("ReqReceivedApprovalListSize")!=null){
			ReqReceivedApprovalListSize=(Integer)map.get("ReqReceivedApprovalListSize");
		}
		
		if(map.get("url")!=null)
		{
			 url = (String)map.get("url");
		}
	
	
}
%>

<div id="country2">
<div class="clear"></div>
<label style="width: 28px;"></label> <label class="link" name="Action"><a
	href="<%=url%>">Take Action </a></label>

<div class="clear"></div>
<label>Action Pending</label> <label class="value"><%=ReqPendingListSize %></label>

<label>Requests Pending</label> <label class="value"><%=pendingListSize %></label>

<div class="clear"></div>
<label>Action On Hold</label> <label class="value"><%=ReqOnHoldListSize %></label>

<label>Requests On Hold</label> <label class="value"><%=onHoldListSize %></label>

<div class="clear"></div>
<label>Action Rejected</label> <label class="value"><%=ReqRejectedListSize %></label>

<label>Requests Rejected</label> <label class="value"><%=rejectedListSize %></label>

<div class="clear"></div>
<label>Action Approved</label> <label class="value"><%=ReqReceivedApprovalListSize %></label>

<label>Requests Approved</label> <label class="value"><%=receivedApprovalListSize %></label>


<div class="clear"></div>

</div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
