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
<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
			
	%>
		serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>
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
	List<PhMasLocality>   phMasLocalityList = new ArrayList<PhMasLocality>();
	List<PhHouseSurvey>   phHouseSurveyList = new ArrayList<PhHouseSurvey>();
	
	 if(map.get("phMasLocalityList")!=null){
		 phMasLocalityList=(List<PhMasLocality>)map.get("phMasLocalityList");
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
<h2>Daily Work Completion</h2>
</div>

<div class="clear"></div>

<form name="task" method="post" action="">
<div class="Block">
<div class="clear"></div>
  
<label>Date</label> <input  id="date" name="date" class="auto" type="text" validate="Date,yes" readonly="readonly" value=""  size="10" onblur="submitProtoAjaxWithDivName('task','/hms/hms/pubHealth?method=datewiseCompletion','testDiv');"/>
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.task.date,event)" src="/hms/jsp/images/cal.gif" />	
  
<div id="testDiv"> 
 
<div class="clear"></div>
<label class="bgNone" style="margin-left:0px;">List of House</label>

<label class="bgNone" style="margin-left:268px;">Completed Houses </label>
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
<div class="clear"></div>
<div class="paddingTop5"></div>
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
	alert("Please Choose Select List");
	return false;
	}
	return true;
}
function hasOptions(obj) {
	if (obj!=null && obj.options!=null) { return true; }
	return false;
	}
function copySelectedOptions() {
	   from =document.getElementById("mainGroupId")
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
			sortSelect(to);
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
function seleclLoc(val){
	submitProtoAjaxWithDivName('task','/hms/hms/pubHealth?method=fillLoc&Val='+val,'loc');
}	
function checkField()
{

  if(date==""){
		
		alert("Date Can't be Balanck.")
		return false;
	}
	else{
		
		return true;
	}
 
}





</script>



 