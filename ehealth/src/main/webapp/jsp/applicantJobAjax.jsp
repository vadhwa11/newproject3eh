<%
Map map = new HashMap();
if(request.getAttribute("map") != null)
	map = (Map) request.getAttribute("map");
String jobCode=null;
if(map.get("jobCode")!=null || !(map.get("jobCode").equals(""))){
	jobCode=(String)map.get("jobCode");
}

 %>
<label>Job Code:</label>
<input name="jobCode" type="text" id="jobCode" value="<%=jobCode %>"></input>