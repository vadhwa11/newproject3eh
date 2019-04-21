<%@page import="jkt.hms.masters.business.LocationParameterMapping"%>
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
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	
	List<PhHouseSurvey> al1 = new ArrayList<PhHouseSurvey>();
	List<LocationParameterMapping>   phMasLocalityList = new ArrayList<LocationParameterMapping>();
	List<PhHouseSurvey>   phHouseSurveyList = new ArrayList<PhHouseSurvey>();
	
	 if(map.get("phMasLocalityList")!=null){
		 phMasLocalityList=(List<LocationParameterMapping>)map.get("phMasLocalityList");
		}
	 
		if(map.get("phHouseSurveyList")!=null){
			 phHouseSurveyList=(List<PhHouseSurvey>)map.get("phHouseSurveyList");
		}
		List<PhDayBlock>   phDayBlockList = new ArrayList<PhDayBlock>();
		if(map.get("phDayBlockList")!=null){
			phDayBlockList=(List<PhDayBlock>)map.get("phDayBlockList");
		}

%>

<div class="titleBg"> 
<h2>Day Block Allocation</h2>
</div>
<div class="clear"></div>
<form name="task" method="post" action="">
<div class="Block">
<div class="clear"></div>
 <div class="division"></div>

 <label><span>*</span>Day Block  </label>
 <select name="day"  id="day" validate="Day,string,yes" onchange="selectWard(this.value);">
 <option value="0">Select</option>
 <%for(int i=1;i<=40;++i){ %>
 <option value="<%=i%>"><%=i%></option>
 <%} %>
 </select>
 <div id="wardDiv">
 	<label>Ward </label>
    <select name="ward" id="ward" validate="locality,string,yes"  onchange="submitProtoAjaxWithDivName('task','/hms/hms/pubHealth?method=getDayBlockId','testDiv');">
             <option value="0">Select</option>
	</select>
	
  <div id="testDiv">
 	<%-- <label> <span>*</span>Locality </label>
    <select name="locality" id="locality" onchange="seleclLoc(this.value)" validate="locality,string,yes">
             	<option value="0">Select</option>
                  <%for(LocationParameterMapping md : phMasLocalityList){ 
                      if(md.getLocality()!=null){%>
            	 <option value="<%=md.getLocality().getId() %>"><%=md.getLocality().getLocalityName()%></option>
   					<%} }%>
	</select> --%>

	<label>Locality </label>
    <select name="locality" id="locality" onchange="seleclLoc(this.value)" validate="locality,string,yes">
             <option value="0">Select</option>
	</select>
<div class="clear"></div>

<label class="bgNoneAuto mrgNone">List of Houses in selected Locality</label>
<label class="bgNoneAuto mrgNone" style="margin-left:236px;">List of Houses in selected  Day Block </label>

<div class="clear"></div>
<div id="loc">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3" style="margin-top:0px;">
</select>
</div>

<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />
<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>
</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3" style="margin-top:0px;">     
</select>
<div class="clear"></div>
<div class="paddingTop5"></div>

<input type="button" class="button" style="margin-left:306px;" name="Submit" value="Submit" onclick="if(chk()){submitForm('task','/hms/hms/pubHealth?method=saveDayBlockAllocation&flag=s');}">
<input type="button" class="button" name="Reset" value="Reset" onclick="submitFormForButton('task','/hms/hms/pubHealth?method=showDayBlockAllocationJsp')">  
 </div>
 </div>
 <div class="clear"></div>
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
	alert("Please Choose Select List of Day Book");
	return false;
	}
	return true;
}

function hasOptions(obj) {
	if (obj!=null && obj.options!=null) { return true; }
	return false;
	}
function copySelectedOptions() {
	  var from =document.getElementById("mainGroupId");
	  var to =document.getElementById("tempId");
	  var index = 0;
		var options = new Object();
		 if (hasOptions(to)) {
			for (var i=0; i<to.options.length; i++) {
				options[to.options[i].value] = to.options[i].text;
				to.options[i].selected=true;
				}
			} 
		if (!hasOptions(from)) { return; }
		
		
		
		for (var i=0; i<from.options.length; i++) {
			var o = from.options[i];
			if (o.selected) {
				if (options[o.value] == null || options[o.value] == "undefined" || options[o.value]!=o.text) {
					if (!hasOptions(to)) { index = 0; } 
					else { index=to.options.length; }
					to.options[index] = new Option( o.text, o.value, true, false);
					to.options[index].selected=true;
					}
				}
			}
		
	/* //	from.selectedIndex = -1;
	//	to.selectedIndex = -1;
		var objTemp = document.getElementById("tempId");
		for (var k=0; k<objTemp.options.length; k++) {
			objTemp.options[k].selected=true;
		} */ 
		
		var size = from.options.length;
		for (var i=(size-1); i>-1; i--) {
			var o = from.options[i];
			if (o.selected) {
				 from.remove(i);
			}
		}
		
		if ((to.options.length<3) || (to.options[2]==true)) {
			sortDropdownList(to);
		} 
		}
		
		
function removeSelectedOptions() {
	 from =document.getElementById("tempId");
	 to =document.getElementById("mainGroupId");
	 var options = new Object();
	 var index=0;
		if (!hasOptions(from)) { return; }
		if (from.type=="select-one") {
			from.options[from.selectedIndex] = null;
			}
		else {
			for (var i=0; i<from.options.length; i++) {
				var o = from.options[i];
				if (o.selected) {
					if (options[o.value] == null || options[o.value] == "undefined" || options[o.value]!=o.text) {
						if (!hasOptions(to)) { index = 0; } else { index=to.options.length; }
						to.options[index] = new Option( o.text, o.value, true, false);
						to.options[index].selected=true;
						}
					}
				sortDropdownList(to);
				}
			
			var size = from.options.length;
			for (var i=(size-1); i>-1; i--) {
				var o = from.options[i];
				if (o.selected) {
					 from.remove(i);
				}
			}
			}
		} 
function sortDropdownList(ddl){
    var options = [].slice.apply(ddl.options, [0]);
    ddl.innerHTML = "";
    var sorted = options.sort(function(a,b){     
       return +(a.innerText) - +(b.innerText);
    });

    for(var i = 0; i < sorted.length; i++){
      ddl.options.add(sorted[i]);
    }  
}		
function saveData(){
	submitForm('task','/hms/hms/pubHealth?method=saveDayBlockAllocation&flag=s')
}
function updateData(){
	submitForm('task','/hms/hms/pubHealth?method=saveDayBlockAllocation&flag=u')
}
function seleclLoc(val){
	submitProtoAjaxWithDivName('task','/hms/hms/pubHealth?method=fillLoc&Val='+val,'loc');
}	
function selectWard(val){
	submitProtoAjaxWithDivName('task','/hms/hms/pubHealth?method=fillWard&ward='+val,'wardDiv');
}	

</script>

<style>
.mrgNone{margin:0px;}
</style>




 