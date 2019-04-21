
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	List<MasDistrict> district = new ArrayList<MasDistrict>();
	if(map.get("masDistrict") !=null){
		district=(List<MasDistrict>)map.get("masDistrict");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
%>

<div class="titleBg">
<h2>Blood Smear Report</h2>
</div>
<form name="birth" method="post" action="">
<div class="clear"></div>
<div class="Block">
<input type="hidden" name="currentDate"  value="<%= currentDate%>">

<%if(map.get("instituteTypeShortName") != null && (map.get("instituteTypeShortName").toString().equalsIgnoreCase("Admn") || map.get("instituteTypeShortName").toString().equalsIgnoreCase("DH"))) {%>
<label>District</label><select name="district" id="district" onchange="enableRadio();"  >
<%	if(district.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasDistrict dis : district) {
					
				  %>
	  <option value="<%=dis.getId ()%>"><%=dis.getDistrictName()%></option>
				  <%
		}}
				   %>
</select>
<% } %>
<div id="divEnchashment" style="display: none;">
<label>CHC</label><input type="radio" name="center" class="inputRadiobutton" id="center" value="chc" onclick="submitProtoAjaxWithDivName('birth','/hms/hms/pubHealth?method=getBirthchclist&district='+this.value,'tDiv');">
<label>PHC</label><input type="radio" name="center" class="inputRadiobutton" id="center" value="phc" onclick="submitProtoAjaxWithDivName('birth','/hms/hms/pubHealth?method=getBirthchclist&district='+this.value,'tDiv');">
</div>

<div class="clear"></div>
 <div id="tDiv">
	<%if(map.get("instituteTypeShortName") != null && map.get("instituteTypeShortName").toString().equalsIgnoreCase("CHC")) {%>
		<label>CHC </label>
    	<select name="chcphc" id="chcphc" onblur="submitProtoAjaxWithDivName('birth','/hms/hms/pubHealth?method=getBirthBasicCenterListchcphc&chcphc='+this.value,'testDiv');">
			<option value="0">Select</option>
			<option value=<%=map.get("hospitalId") %>><%=map.get("hospitalName") %></option>
		</select>
		
		<div id="testDiv">
			<label>Basic-Section / Sub-center </label>
    		<select name="base" id="base" class=""  validate="">
       	      	<option value="0">Select</option>
			</select>
		</div>
		<div class="clear"></div>
	<% } %>
	<%if(map.get("instituteTypeShortName") != null && map.get("instituteTypeShortName").toString().startsWith("PHC")) {%>
		<label>PHC </label>
		<select name="chcphc" id="chcphc" onblur="submitProtoAjaxWithDivName('birth','/hms/hms/pubHealth?method=getBirthBasicCenterListchcphc&chcphc='+this.value,'testDiv');">
			<option value="0">Select</option>
			<option value=<%=map.get("hospitalId") %>><%=map.get("hospitalName") %></option>
		</select>
		
		<div id="testDiv">
			<label>Basic-Section / Sub-center </label>
 			<select name="base" id="base" class=""  validate="">
             	<option value="0">Select</option>
			</select>
		</div>
		<div class="clear"></div>
	<% } %>
	
	<%if(map.get("instituteTypeShortName") != null && (map.get("instituteTypeShortName").toString().equalsIgnoreCase("BS") || map.get("instituteTypeShortName").toString().equalsIgnoreCase("FWC"))) {%>
		<label>Basic-Section / Sub-center </label>
		<select name="base" id="" class=""  validate="">
			<option value=<%=map.get("hospitalId") %>><%=map.get("hospitalName") %></option>
		</select>
	<% } %>
</div>

<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate Report" class="buttonBig"
	onClick="submitForm('birth','pubHealth?method=generateBloodSmearReport');" accesskey="a" tabindex=1 />

<script type="text/javascript">
	
	function enableRadio(){
    
		var x=document.getElementById("district").value;
		if(x > 0 ){
			document.getElementById("divEnchashment").style.display ='block';
		} else {
			document.getElementById("divEnchashment").style.display ='none';	
		}
	}	
</script>	
</div>
	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
