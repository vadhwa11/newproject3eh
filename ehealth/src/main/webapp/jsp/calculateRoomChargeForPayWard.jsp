<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    Map<String, Object> map = new HashMap<String, Object>();
    BigDecimal charge=new BigDecimal(0.00);
    if(request.getAttribute("map")!=null)
    {
    	map=(Map<String, Object>)request.getAttribute("map");
    }
    if(map.get("ChargeAmt")!=null)
    {
    	charge=(BigDecimal)map.get("ChargeAmt");
    }   
    %>
    
    <script type="text/javascript">
    document.getElementById("roomChargeId").value='<%=charge%>';
     if(document.getElementById("numOfDaysId").value!='' && document.getElementById("numOfDaysId").value!=null)
    	{
    	if(!isNaN(document.getElementById("numOfDaysId").value))
    		{
    		document.getElementById("amtt").value=parseInt(document.getElementById("numOfDaysId").value)*parseFloat( document.getElementById("roomChargeId").value);
    		}
    	} 
     else
    	 {
 		document.getElementById("amtt").value='0.00';

    	 }
    </script>