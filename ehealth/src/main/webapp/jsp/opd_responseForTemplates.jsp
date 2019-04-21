<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
if(map.get("templates") != null)
{
	templateList=(List<OpdTemplate>)map.get("templates");
}
int tempId=0;
if(map.get("tempId") != null)
{
	tempId=(Integer)map.get("tempId");
}
%>
<option value='0'>Select</option>
<%	if(templateList.size() !=0){
		for (OpdTemplate temp :templateList) {
%>				
<option value=<%=temp.getId()%> title="<%=temp.getTemplateName()%>" <%=tempId==temp.getId()?"selected":""%>><%=temp.getTemplateName()%></option>
<%} 
}%>

