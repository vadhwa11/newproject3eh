<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(map.get("message") != null){
		
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %>

<div class="titleBg">
<h2>Asset Category</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Asset Code</label>
<input type="radio" name="<%=SELECTED_RADIO%>" value="1" checked="checked" class="radioCheck" tabindex=1 />
<label>Asset Name</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" checked="checked" class="radioCheck" />
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Asset Code,string,no"	MAXLENGTH="8" tabindex=1	 />
<input type="button" name="search" value="Search" class="button"	onclick=""	tabindex=1 />
</form>
</div>
</div>
</div>	
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Asset Code</th>
			<th width="10%">Asset Name</th>
			<th width="10%">Status</th>
	
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
			<label></label>
			</td>
			<td>
			<label></label>
			</td>
			<td>
			<label></label>
			</td>
	</tr>
	</tbody>
	</table>
	</div>		
<div class="clear"></div>
<form name="employeeCategory" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label><span>*</span> Asset  Code </label>
<input id="codeId" type="text" name="assetCode" value="" validate="Asset Code,string,yes" class="textbox_size20" MAXLENGTH="8"  tabindex=1/>

<label><span>*</span> Asset  Name </label>
<input type="text" name="assetName" value="" validate="Asset Name,string,yes" class="textbox_size20" MAXLENGTH="30"  tabindex=1/>

<label>Asset Category</label>
<select name="assetCategory">
<option value="0">Select</option>
</select>
<div class="clear"></div>
<label><span>*</span> Depriciation % </label>
<input type="text" name="depriciation" value="" validate="Depriciation,string,yes" class="textbox_size20" MAXLENGTH="30"  tabindex=1/>
<label><span>*</span> Asset Description </label>
<textarea rows="" cols="" name ="assetDescription" class="textareaMediua"></textarea>
<label> Deactivate Reason </label>
<select name="deactivateReason">
<option value="0">Select</option>
</select>
<div class="clear"></div>
<label><span>*</span> Remarks </label>
<textarea rows="" cols="" name ="remarks" class="comorBiditylarge" style="width:357px;"></textarea>
<div class="clear"></div>
<div id="edited"></div>
<div class="paddingTop5"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button"  onClick=""	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" />
</div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
</div>
</form>
<div class="clear"></div>
