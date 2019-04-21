<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.MasWasteContainer"%>
<%@page import="jkt.hms.masters.business.MasWasteCategory"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_DATE "%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_NO "%>
<%@ page import="static jkt.hms.util.RequestConstants.BANK_NAME "%>


<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<MasWasteCategory>wasteCategoryList=new ArrayList<MasWasteCategory>();
	List<MasWasteContainer>wasteContainerList=new ArrayList<MasWasteContainer>();
	if(map.get("wasteCategoryList")!=null){
		wasteCategoryList=(List<MasWasteCategory>)map.get("wasteCategoryList");
	}
	if(map.get("wasteContainerList")!=null){
		wasteContainerList=(List<MasWasteContainer>)map.get("wasteContainerList");
	}
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
	}
	if(message!=null && !message.equals("")){
%>
<script lang="javascript" src="/hms/jsp/js/common.js" type="text/javascript"></script>


<h4><%=message %></h4>
<%} %>
<div class="titleBg">
<h2>Bio Medical Waste Handover</h2>
</div>
<div class="Clear"></div>
<form name="wasteHandOver" method="post">
<div class="Block">
<label>Waste Category</label>
<select name="wasteCategory" id="wasteCategoryId">
<option value="0">Select</option>
<%for(MasWasteCategory category:wasteCategoryList){ %>
<option value="<%=category.getId()%>"><%=category.getWasteCategoryName() %></option>
<%} %>
</select>
<label>Container</label>
<select name="container" id="containerId">
<option value="0">Select</option>
<%for(MasWasteContainer container:wasteContainerList){ %>
<option value="<%=container.getId()%>"><%=container.getWasteContainerName() %></option>
<%} %>
</select>
<label>Colour Coding</label>
<select name="colour" id="colour">
<option value="">Select</option>
<option value="Yellow">Yellow</option>
<option value="Red">Red</option>
<option value="Blue">Blue</option>
<option value="WT">White Translucent</option>
<option value="Black">Black</option>

</select>
<div class="clear"></div>
<label>Quantity</label>
<input type="text" name="qty" value="" />
</div>
<div class="clear"></div>
<div class="clear"></div>
<input type="button" value="Submit" onclick="submitForm('wasteHandOver','/hms/hms/ipd?method=addWasteHandOver')" />
<div class="clear"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>