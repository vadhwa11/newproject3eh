
<%
Map map = new HashMap();
if(request.getAttribute("map") != null)
	map = (Map) request.getAttribute("map");
String departmentCode=null;
if(map.get("departmentCode")!=null || !(map.get("departmentCode").equals(""))){
	departmentCode=(String)map.get("departmentCode");
}

 %>
<label>Department Code:</label>
<input name="departmentCode" type="text" id="departmentCode"
	value="<%=departmentCode %>"></input>