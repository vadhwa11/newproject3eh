
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<Object[]> itemList = new ArrayList<Object[]>();
	if(map.get("itemList") != null){
		itemList = (List<Object[]>)map.get("itemList");
	}
	Box box = HMSUtil.getBox(request);
	%>




<ul>
<%	
	if(itemList.size() !=0)
	{
		for(Object[] storeItem : itemList)
		{
			if(!box.getString("pvmsNo").equals(""))
			{
				if(box.getString("showId").equals("1"))
				{
%>
					<li style="width: auto;min-width:150px;"><%=storeItem[1]+"["+storeItem[0]+"]"%></li>
<%
				}
				else
				{
%>
				<li style="width: auto;min-width:150px;"><%=storeItem[1]%></li>
<%
				}
			}
			else if(!box.getString("nomenclature").equals(""))
			{ 
%>
				<li style="width: auto;"><%=storeItem[2]+"["+storeItem[1]+"]"%></li>
<%
			}
		}
	}
	else
	{
%>
		<li style="width: auto;">----------No Record Found-------------</li>
<%
	} 
%>
</ul>
