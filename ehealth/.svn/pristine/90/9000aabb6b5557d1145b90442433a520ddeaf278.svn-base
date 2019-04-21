
<%@page import="jkt.hms.masters.business.MasSpecialityDeptGroupValue"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<script type="text/javascript">
var nameArray= new Array();
</script>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<MasSpecialityDeptGroupValue> valueList = new ArrayList<MasSpecialityDeptGroupValue>();
if(map.get("valueList") != null){
	valueList = (List)map.get("valueList");
}

%>


<%if(valueList.size()>0){ %>
  
  <div id="view">
  <div class="Block">

										<table id="safetyPM">
										<input class="buttonAdd" type="button" onclick="add1()" value="" name="Add" >
										 <input	class="buttonDel" type="button" onclick="removeRow()" value="" name="delete">
											<tr>
											<th></th>
												<th>Values</th>
												<th>Default Value</th>
												<th>Extra Text</th>
									
											</tr>
											<%
											int i=1;
											if(valueList.size()>0){
												 for(MasSpecialityDeptGroupValue value : valueList){
												
												%>
											
											<tr>
												<td><input type='checkbox' name='Item' id='Item<%=i %>'  value="<%=value.getId() %>"/></td>
												<td><input type='text' name='values' id='values' value="<%=value.getValue() %>" /></td>
												<%if(value.getDefaultValue() != null && value.getDefaultValue().equalsIgnoreCase("y")){ %>
												<td><input type="radio" name="defVal" id="defaultValues<%=i %>" value="y" checked="checked" onclick="setDefVal(<%=i %>)"/>
													<input type="hidden" name="defaultValues" id="defVal<%=i %>" value="y" /></td>
												<%}else{ %>
												<td><input type="radio" name="defVal" id="defaultValues<%=i %>" value="y" onclick="setDefVal(<%=i %>)"/>
													<input type="hidden" name="defaultValues" id="defVal<%=i %>" value="" /></td>
												<%} %>
												<%if(value.getExtraText() != null && value.getExtraText().equalsIgnoreCase("y")){ %>
												<td><input type="radio" name="ext" id="extraText" value="y" checked="checked"  onclick="setExtVal(<%=i %>)"/>
												<input type="hidden" name="extraText" id="ext<%=i %>" value="y" /></td>
												<%}else{ %>
													<td><input type="radio" name="ext" id="extraText" value="y"  onclick="setExtVal(<%=i %>)"/>
													<input type="hidden" name="extraText" id="ext<%=i %>" value="" /></td>
													<%} %>
													
												
											</tr>
											<%i++;}} %>
										</table>
								</div>
								</div>
 
<%}else{
	
	
	%>
  <div id="view">
  <div class="Block">
										<input class="buttonAdd" type="button" onclick="add1()" value="" name="Add" >
										 <input	class="buttonDel" type="button" onclick="removeRow()" value="" name="delete">
  	<table id="safetyPM">
											<tr>
											<th></th>
												<th>Values</th>
												<th>Default Value</th>
												<th>Extra Text</th>
									
											</tr>
  <tr>
												<td><input type='checkbox' name='Item' id='Item1' /></td>
												<td><input type='text' name='values' id='values' value="" /></td>
												<td><input type="radio" name="defVal" id="defaultValues1" value="y" onclick="setDefVal(1)"/>
												<input type="hidden" name="defaultValues" id="defVal1" value="y" />
												</td>
												<td><input type="radio" name="ext" id="extraText1" value="y" onclick="setExtVal(1)"/>
												
												<input type="hidden" name="extraText" id="ext1" value="y" />
												</td>
												
											</tr>
										</table>
  </div>
								</div>
  <%} %>
