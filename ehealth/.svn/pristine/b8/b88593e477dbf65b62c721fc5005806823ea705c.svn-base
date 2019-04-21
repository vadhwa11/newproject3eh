<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%	List<MasState> stateList = new ArrayList<MasState>();
	Map map = (Map) request.getAttribute("map");
				List<MasDistrict> districtList = new ArrayList<MasDistrict>();
				if (map.get("stateList") != null) {
					stateList = (List) map.get("stateList");
				}
				
				if (map.get("districtList") != null) {
					districtList = (List) map.get("districtList");
				}
			
			%>


<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasCountry"%><label><span>* </span>Country</label>

<select name="<%= COUNTRY %>" validate="Country,int,yes" tabindex=1
	onchange="getStateList(this.value);"
	onkeyUp="getStateList(this.value);">
	<option value="0">Select</option>
	<%
				for (MasCountry masCountry : countryList) {
			%>

	<option value="<%=masCountry.getId ()%>"><%=masCountry.getCountryName()%></option>

	<%
				}
			%>
</select>

<label><span>* </span>State</label>
<select id="stateId" name="<%= STATE %>" validate="State,int,yes"
	onchange="getCityList(this.value);" onkeyUp="getCityList(this.value);"
	tabindex=1>
	<option value="0">Select</option>
	<%
					for (MasState masState : stateList) {
				%>

	<option value="<%=masState.getId ()%>"><%=masState.getStateName()%></option>

	<%
					}
				%>
</select>

<label><span>* </span>City</label>


<select id="cityId" name="<%= DISTRICT %>" validate="City,int,yes"
	tabindex=1 onchange="otherCity();">
	<option value="0">Select</option>
	<%
					for (MasDistrict masDistrict : districtList) {
				%>

	<option value="<%=masDistrict.getId ()%>"><%=masDistrict.getDistrictName()%></option>

	<%
					}
				%>
</select>


<div id="<%=OTHERCITY %>" style="display: none;"><input
	type="text" name="<%=OTHERCITY %>" value="<%=otherCity %>"
	maxlength="45" /></div>



<script>
<%if(otherCity!=null &&otherCity.length()!=0){%>

document.getElementById('<%=OTHERCITY%>').style.display = 'block';
<%}%>
function getStateList(idvalue){
		var sel1 = document.getElementById("stateId");
		var sel2 = document.getElementById("cityId");
		
		removeAllOptions(sel1);
		removeAllOptions(sel2);
		sel2.options.add(new Option('Select', '0'));
	
		var sel = document.getElementById("stateId");
		sel.options.add(new Option('Select', '0'));
	<%
		for (MasState masState : stateList) {
	%>
		
		if(idvalue ==<%=masState.getCountry().getId()%>){
			sel.options.add(new Option('<%=masState.getStateName()%>' , '<%=masState.getId()%>'));
	}

	<%
		}
	%>
	}
	
	
	function getCityList(idvalue){
		var sel1 = document.getElementById("cityId");
		removeAllOptions(sel1);
		var sel = document.getElementById("cityId");
		sel.options.add(new Option('Select', '0'));
	<%
		for (MasDistrict masDistrict : districtList) {
	%>
		
		if(idvalue ==<%=masDistrict.getState().getId()%>){
			sel.options.add(new Option('<%=masDistrict.getDistrictName()%>' , '<%=masDistrict.getId()%>'));
	}
		
	<%
		}
	%>
	sel.options.add(new Option('Other', '-1'));
	}

	function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}

function otherCity(){
	if(document.getElementById('cityId').value == -1){
	document.getElementById('<%=OTHERCITY%>').style.display = 'block';
	}
	else
	{
	document.getElementById('<%=OTHERCITY%>').style.display = 'none';
	}
}

</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
