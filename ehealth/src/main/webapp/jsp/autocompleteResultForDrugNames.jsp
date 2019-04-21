<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null)
	{
		map = (Map<String,Object>) request.getAttribute("map");
	}
	
	List cssdItemMasterList = new ArrayList();
	
	if(map.get("cssdItemMasterList") != null)
	{
		cssdItemMasterList = (List)map.get("cssdItemMasterList");
	}
%>

<ul>
<%		if(cssdItemMasterList.size() != 0)
		{
			for (Iterator iterator = cssdItemMasterList.iterator(); iterator.hasNext();) 
			{
				Object[] object = (Object[]) iterator.next();
		    	Integer instrumentCode  = (Integer)object[0];
		    	String instrumentName = (String)object[1];
%>
				<li style="width: auto;"><%=instrumentName%>
				<input  type="hidden" name="<%=ITEM_ID%>" value="<%=instrumentCode %>"/>
				</li>
<%
			}
		}
		else
		{
%>
				<li>----------No Items found-------------</li>
<%
		}
%>
</ul>