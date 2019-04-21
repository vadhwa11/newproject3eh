<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<Object> POQtyList = new ArrayList<Object>();
	List<Object> masStoreSupplierList = new ArrayList<Object>();
	int pageNo = 0;
	Integer deptId=0;
	String userName = "";
	boolean accessFlag=false;
	
	if(map.get("accessFlag")!=null)
	{
		accessFlag = (Boolean)map.get("accessFlag");
	}
	
	if(map.get("POQtyList") != null)
	{
		POQtyList = (List<Object>)map.get("POQtyList");
	}
	
	if(map.get("masStoreSupplierList") != null)
	{
		masStoreSupplierList = (List<Object>)map.get("masStoreSupplierList");
	}
		
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
	
	if(map.get("message") != null)
	{
		String message = (String)map.get("message");
%>
   		
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%><h4><span><%=message %></span></h4>
<% 
	}
if(POQtyList.size()>0){	
	if(accessFlag)
	{

%>

<%
    int counter=0;
	int SlNo = 1;
%>

<div class="txtleft">
<table>
	<tr>
		<th>S.L.No.</th>
		<th>Item Name</th>
		<th>CO. Reorder Level</th>
		<th>Required Reorder Level</th>		
	</tr>

<%
		Iterator iterator = POQtyList.iterator();
        while(iterator.hasNext())
        {
        	Object[] object = (Object[]) iterator.next();
        	int mainItemId=0;
        	mainItemId=(Integer)object[0];
%>
			<tr>
			<td><%=SlNo%><input type="hidden" name="itemID<%=SlNo%>" id="itemID<%=SlNo%>" value="<%=object[0]%>" /></td>
<%
			if(object[1] != null)
			{
				StringBuffer output_str = new StringBuffer();
				StringTokenizer s = new StringTokenizer(object[1].toString(),"\"");

				while (s.hasMoreTokens())
				{
					output_str.append(s.nextToken());
					if (s.hasMoreTokens())
					{
						output_str.append("\\");
						output_str.append("\"");
					}
				}
%>
				<td><%=output_str.toString()%><input type="hidden" name="itemName<%=SlNo%>" id="itemName<%=SlNo%>" value="<%=output_str.toString()%>" /></td>
<%	
			}
%>
			
			<td><%=object[3]%><input type="hidden" name="rol<%=SlNo%>" id="rol<%=SlNo%>" value="<%=object[3]%>" /></td>
			<td><%=object[7]%><input type="hidden" name="reqQty<%=SlNo%>" id="reqQty<%=SlNo%>" value="<%=object[7]%>" /></td>
			<input type="hidden" name="saleTaxId<%=SlNo%>" id="saleTaxId<%=SlNo%>" value="<%=object[9]%>" />
			<input type="hidden" name="costPrice<%=SlNo%>" id="costPrice<%=SlNo%>" value="<%=object[8]%>" />
			<input type="hidden" name="manufacID<%=SlNo%>" id="manufacID<%=SlNo%>" value="<%=object[10]%>" />
			
			</tr>
<%
			SlNo++;
			counter++;
        }
%>
</table>
</div>
<input type="hidden" name="counter" id="counter" value="<%=counter%>"></input>

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="clear"></div>

<input type="button" name="GenPO" id="generatePObutton" value="Generate ROL" class="buttonBig"
onclick="submitForm('ROLGenerationList','purchaseOrder?method=submitReorderLevel')" accesskey="a" tabindex=1 />

<input type="button" name="search" id="search" value="Search" class="button" style="display: none"
onclick="" accesskey="a" tabindex=1 />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By:</label>
<label class="value"><%=userName%></label>
<label>Changed Date:</label> <label class="value"><%=date%></label>
<label>Changed Time:</label> <label	class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>

<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>

<%
	}
	else
	{
%>
		<h2>Reorder Level</h2>
		<div class="clear"></div>
		<h3>Access Denied</h3>
<%
	}
}else{
%>
<Font face="arial" color="red" size="3">No Records Found.</Font>
<%} %>