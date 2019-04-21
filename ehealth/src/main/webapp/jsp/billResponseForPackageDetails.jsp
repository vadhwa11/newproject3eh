<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BlPackageHeader"%>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response of package details.
 * @author  Ritu
 * Create Date: 23 July,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>();
	
	if (map.get("packageList") != null) {
		packageList = (List) map.get("packageList");
	}
	BlPackageHeader packageHeader = packageList.get(0);
	
%>
<h4>Package Details</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label class="auto">Total Value of
Package:</label> <%
	if(packageHeader.getTotalValueOfPackage() !=null){
%> <label class="value"><%=packageHeader.getTotalValueOfPackage() %></label>
<%}else{
%> <label class="value"></label> <%} %> <label class="auto">Disc.
Value of Package:</label> <%if(packageHeader.getDiscountedValueOfPackage() != null){%>
<label class="value"><%=packageHeader.getDiscountedValueOfPackage() %></label>
<%}else{
%> <label class="value"></label> <%} %> <label class="auto">Total
Value of Services:</label> <%if(packageHeader.getTotalValueOfServices() != null){%>
<label class="value"><%=packageHeader.getTotalValueOfServices() %></label>
<%}else{
%> <label class="value"></label> <%} %>
<div class="clear"></div>

<label class="auto">Disc. Value of Services:</label> <%if(packageHeader.getDiscountedValueOfServices() != null){%>
<label class="value"><%=packageHeader.getDiscountedValueOfServices() %></label>
<%}else{
%> <label class="value"></label> <%} %> <label class="auto">Total
Value of Medicines:</label> <%if(packageHeader.getTotalValueOfMedicines() != null){%>
<label class="value"><%=packageHeader.getTotalValueOfMedicines() %></label>
<%}else{
%> <label class="value"></label> <%} %> <label class="auto">Disc.
Value of Medicines:</label> <%if(packageHeader.getDiscountedValueOfMedicines() != null){%>
<label class="value"><%=packageHeader.getDiscountedValueOfMedicines() %></label>
<%}else{
%> <label class="value"></label> <%} %>
<div class="clear"></div>

<label class="auto">Package Discount/Tariff:</label> <%
	BigDecimal pkgDisTrf = new BigDecimal(0);
	
	if(packageHeader.getPackageDiscountTariffAmt() != null){
		pkgDisTrf  = packageHeader.getPackageDiscountTariffAmt();
	}
	
%> <label class="value"><%=pkgDisTrf%></label> <label class="auto">Distributed
Discount/Tariff:</label> <%
	BigDecimal dtdPkgDis = new BigDecimal(0);
	BigDecimal dtdPkgTrf = new BigDecimal(0);
	
	if(packageHeader.getDistributedPkgDiscount() != null){
		dtdPkgDis  = packageHeader.getDistributedPkgDiscount();
	}
	
	if(packageHeader.getDistributedPkgTariff() != null){
		dtdPkgTrf = packageHeader.getDistributedPkgTariff();
	}
%> <label class="value"><%=dtdPkgDis.subtract(dtdPkgTrf)%></label>

<div class="clear"></div>
</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
