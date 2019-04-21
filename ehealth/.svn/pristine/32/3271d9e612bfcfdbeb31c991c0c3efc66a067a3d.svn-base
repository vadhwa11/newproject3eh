<%@page import="jkt.hms.masters.business.PhDayBlock"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.masters.business.PhMasLocality"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.*" %>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	List<Object[]> hospitalList = new ArrayList<Object[]>();
	if(map.get("hospitalList")!=null){
		hospitalList = (List<Object[]>)map.get("hospitalList");
	}
	String hospitalName= "";
	String parentInst = "";
	if(session.getAttribute("hospitalName")!=null)
		hospitalName = (String)session.getAttribute("hospitalName");
	
		if(map.get("parentInst")!=null){
			parentInst = (String)map.get("parentInst");
		}	
	
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
%>
<%
String message=null;
if(map.get("message") != null){ %>
	  message = (String)map.get("message");
  out.println(message);
  
<h4>
<span><%= message%></span>
</h4>
	  
	<% }%>   

<div class="titleBg"> 
<h2>PH Mapping</h2>
</div>
<div class="clear"></div>
<form name="phMapping" method="post" action="">
<div class="Block">
<div class="clear"></div>
 <div class="division"></div>

 <label>Health Block <span>*</span> </label>
 <label class="value large"><%=parentInst %></label>
 <label>PHC/CHC<span>*</span> </label>
 <label class="value large"><%=hospitalName %></label> 
   <input type="hidden" name="hospialIdphcCHC" value="<%=hospitalId%>"> 
 <div class="clear"></div>
  <div class="clear"></div>
 <label>Institute Name</label>
 <select name="institute" onchange="displayBsScInDropDown(this.value);">
 <option value="0">Select</option>
 <%
 	for(Object[] obj : hospitalList){
 %>
 
 <option value="<%=obj[0]%>"><%=obj[1]%></option>
 <%} %>
 </select>
 <script>
 function displayBsScInDropDown(hospitalId){
	 var x = document.getElementById("parametersId");
		var option = document.createElement("option");
	 <%
	 	for(Object[] obj : hospitalList){
	 		%>
	 		if(hospitalId == '<%=obj[0]%>'){
	 			if('<%=obj[2]%>' == 1){
	 				x[1].style.display='block';
	 				x[2].style.display='none';
	 				
	 			}else if('<%=obj[2]%>' == 2){
	 				x[1].style.display='none';
	 				x[2].style.display='block';
	 			}
	 			
	 		}
	 	<%}
	 %>
	 x.value="0";
 }
 
 
 </script>
<div class="clear"></div>
 <label>Mapping Parameters </label>
    <select name="parametersId" id="parametersId" onchange="getParameters(this.value)" validate="Parameters,string,yes" style="width:347px;">
             	<option value="0">Select</option>
             	
             	<option value="bs" style="display: none;">Basic Section</option>
             
             	<option value="sc" style="display: none;">Sub Center</option>
             
             	<option value="loc">Locality</option>
             	<option value="par">Parliament</option>
             	<option value="ass">Assembly</option>
             	<!-- <option value="lsgi">LSGI</option> -->
             	<option value="post">Post Office with Pin Code</option>
              <option value="esec">Electrical Section</option>            
              <option value="vill">Village</option> 
              </select>
	<div class="clear"></div>
 <div id="parameterDiv">
<select name="paramId" id="paramId"  multiple="multiple" size="7" class="listBig3">
</select>
<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>
</div>
<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
     
</select>
</div>
<div class="clear"></div>
 <div class="clear"></div>
 <div class="paddingTop15"></div>
<input type="hidden" name="<%=CHANGED_BY%>"	value="<%=userName%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="button"  class="button" name="Submit" value="Submit" onclick="if(chk()){submitForm('phMapping','/hms/hms/pubHealth?method=saveInlocationParameter');}">
<input type="button"  class="button" name="Upadte" value="Remove List" onclick="if(chk()){submitForm('phMapping','/hms/hms/pubHealth?method=updateInlocationParameter');}">

</div>	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>

function removeAllOptions(selectbox)
{
	var i;
	for(i=selectbox.options.length-1;i>=0;i--)
	{
		selectbox.remove(i);
	}
}
function chk() {
	var s = document.getElementById("tempId").value;
	if (s==""){ 
	alert("Please Choose Select List ");
	return false;
	}
	return true;
}

function hasOptions(obj) {
	if (obj!=null && obj.options!=null) { return true; }
	return false;
	}
function copySelectedOptions() {
	   from =document.getElementById("paramId")
	   to =document.getElementById("tempId")
	  
		var options = new Object();
		if (hasOptions(to)) {
			for (var i=0; i<to.options.length; i++) {
				options[to.options[i].value] = to.options[i].text;
				}
			}
		if (!hasOptions(from)) { return; }
		for (var i=0; i<from.options.length; i++) {
			var o = from.options[i];
			if (o.selected) {
				if (options[o.value] == null || options[o.value] == "undefined" || options[o.value]!=o.text) {
					if (!hasOptions(to)) { var index = 0; } else { var index=to.options.length; }
					to.options[index] = new Option( o.text, o.value, true, false);
					
					}
				}
			}
		if ((arguments.length<3) || (arguments[2]==true)) {
			//sortSelect(to);
			}
		from.selectedIndex = -1;
		to.selectedIndex = -1;
		var objTemp = document.getElementById("tempId");
		for (var k=0; k<objTemp.options.length; k++) {
			objTemp.options[k].selected=true
			}
		}
		
		
function removeSelectedOptions() {
	 from =document.getElementById("tempId") 
		if (!hasOptions(from)) { return; }
		if (from.type=="select-one") {
			from.options[from.selectedIndex] = null;
			}
		else {
			for (var i=(from.options.length-1); i>=0; i--) { 
				var o=from.options[i]; 
				if (o.selected) { 
					from.options[i] = null; 
					} 
				}
			}
		from.selectedIndex = -1; 
		} 
		
function saveData(){
	submitForm('task','/hms/hms/pubHealth?method=saveDayBlockAllocation&flag=s')
}
function updateData(){
	submitForm('task','/hms/hms/pubHealth?method=saveDayBlockAllocation&flag=u')
}
function getParameters(val){
	//alert(val)
	var bs='bs';
	var sc='sc';
	var lo='loc';
    var par='par';
    var as='ass';
    var ls='lsgi';
    var po='post';
    var es='esec';
    var vill='vill';
    var taluk='Taluk';
     if(val == lo ){
    	 
    	 submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getlocality','parameterDiv');	 
     }
     else if(val == bs){
     	
     	 //submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getBesicSectionlist','parameterDiv');
     	 submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=populateSubcenterList','parameterDiv');
     }else if(val==vill){
    	 submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getvilageList','parameterDiv');
     }
     else if(val == sc){
    	 
    	 submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getphSubcenterList','parameterDiv');
    	
     }
     
     
     else if(val == par){
    	
     	 submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getDistrictList','parameterDiv'); 
     }
     else if(val == as){
    	
    	 submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getDistrictForAssamblyList','parameterDiv');
     }
     else if(val == ls){
    	
   	 submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getDistrictForLsgList&Val='+val,'parameterDiv');
     }
     else if(val == es){
    	 
    	 submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getDistrictForElectricalSecList&Val='+val,'parameterDiv');
     }
     else if(val == po){
    	
    	 submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getDistrictForPostOfficeList&Val='+val,'parameterDiv');
   }
   
	
}	


</script>



 