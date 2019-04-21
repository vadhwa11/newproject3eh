<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningDetail"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningHeader"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<BloodSampleScreeningHeader> screeningList = new ArrayList<BloodSampleScreeningHeader>();

List<DgMasInvestigation> investionList = new ArrayList<DgMasInvestigation>();
List<BloodSampleScreeningDetail> screenDetailList = new ArrayList<BloodSampleScreeningDetail>();

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}

if(map.get("screeningList") != null)
{
	screeningList=(List<BloodSampleScreeningHeader>)map.get("screeningList");
}
if(map.get("screenDetailList") != null)
{
	screenDetailList=(List<BloodSampleScreeningDetail>)map.get("screenDetailList");
}
String BagNum="";
String TubNum="";
String Quantity="";
  if(null !=screeningList && screeningList.size()>0){
	  for(BloodSampleScreeningHeader bsh:screeningList){
		  BagNum=bsh.getSampleCollection().getBagNumber();
		  TubNum=bsh.getSampleCollection().getTubeNumber();
		 // Quantity=bsh.getSampleCollection().getQuantityCollected();
	  }
  }

%>
<form action="" name="resultEntryForm">
<div id="Block">
<label> Bag Number</label>
<input type="text"  id="bagNumId" name="bagNum" value="<%=BagNum %>" tabindex="1"  MAXLENGTH="20";" />

<label> Tube Number</label>
<input type="text"  id="tubNumId" name="tubeNum" value="<%=TubNum %>" tabindex="1"  MAXLENGTH="20";" />

<label> Quantity</label>
<input type="text"  id="quantityId" name="quantity" value="<%=Quantity %>" tabindex="1"  MAXLENGTH="20";" />

<div class="clear"></div>

</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>