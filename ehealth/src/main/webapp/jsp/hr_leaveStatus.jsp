<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<script>
	
</script>

<form name="<%=LEAVE_STATUS%>" method="post" action="">
<div class="titleBg">
<h2>Types of leave status</h2>
</div>
<div class="Block">
<h4><a href="/hms/hrms/leave?method=showWaitingLeavesEncashment">Waiting for Encashment Approval</a></h4>
<div class="clear"></div>

<h4><a href="/hms/hrms/leave?method=showWaitingLeaves">Waiting for Approval</a></h4>
<div class="clear"></div>

<h4><a href="/hms/hrms/leave?method=showApprovedLeaves">Approved</a></h4>
<div class="clear"></div>

<h4><a href="/hms/hrms/leave?method=showDisapprovedLeaves">Disapproved</a></h4>
<div class="clear"></div>
</div>

<!-- Comment by Aanand -->
<!-- <div class="Block"><a
	href="/hms/hrms/leave?method=showWaitingLeavesEncashment">
<h4>Waiting for Encashment Approval</h4>
</a>
<div class="clear"></div>

<a href="/hms/hrms/leave?method=showWaitingLeaves">
<h4>Waiting for Approval</h4>
</a>
<div class="clear"></div>

<a href="/hms/hrms/leave?method=showApprovedLeaves">
<h4>Approved</h4>
</a>
<div class="clear"></div>

<a href="/hms/hrms/leave?method=showDisapprovedLeaves">
<h4>Disapproved</h4>
</a>
<div class="clear"></div>
</div> -->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

