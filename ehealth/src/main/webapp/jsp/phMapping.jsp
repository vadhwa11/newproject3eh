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
	
	List<MasHospital> cscList = new ArrayList<MasHospital>();
	
	 if(map.get("cscList")!=null){
		 cscList=(List<MasHospital>)map.get("cscList");
		}
	 int hospitalTypeId=0;
	 if(map.get("hospitalTypeId")!=null){
		 hospitalTypeId=(Integer)map.get("hospitalTypeId");
	 }
	 String healthBlock="";
	 String phcCHC="";
	 if(map.get("phcCHC")!=null){
		 phcCHC=(String)map.get("phcCHC");
	 }
	 if(map.get("healthBlock")!=null){
		 healthBlock=(String)map.get("healthBlock");
	 }
	// System.out.println("hospitalTypeId========>>>>"+hospitalTypeId);
	 
	 int hospitalIdHB=0;
	 int healthBlockId=0;
	 if(map.get("healthBlockId")!=null){
		 healthBlockId=(Integer)map.get("healthBlockId");
	 }
	 if(map.get("hospitalIdHB")!=null){
		 hospitalIdHB=(Integer)map.get("hospitalIdHB");
	 }
	 String labelName="";
		String hospitalName="";
		 if(map.get("labelName")!=null){
			 labelName=(String)map.get("labelName");
		 }
		 if(map.get("hospitalName")!=null){
			 hospitalName=(String)map.get("hospitalName");
		 }
		 
int subCenterIdd=0;
if(map.get("subCenterIdd")!=null){
	subCenterIdd=(Integer)map.get("subCenterIdd");


}
	
int hospialIdphcCHC=0;
if(map.get("hospialIdphcCHC")!=null){
	hospialIdphcCHC=(Integer)map.get("hospialIdphcCHC");
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
<%-- 
 <label>Health Block <span>*</span> </label>
 <select name="chcId"  id="chcId" validate="CHC,string,yes"	onchange="submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getPhcList','testDiv');">
 <option value="0">Select</option>
 <%
 if(cscList.size()>0){
 for(MasHospital communityHealthCenter : cscList){ %>
 <option value="<%=communityHealthCenter.getId()%>"><%=communityHealthCenter.getHospitalName()%></option>
 <%}} %>
 </select>
 
  <div id="testDiv">
 	<label>PHC/CHC <span>*</span> </label>
    <select name="phcId" id="phcId"  validate="PHC,string,yes">
             	<option value="0">Select</option>                  
	</select> 
  </div>
 <div class="clear"></div>
  <label>Sub Center </label> <input id="subceneterRadioId" name="subceneterRadioId" type="radio"  value="Yes" class="inputRadiobutton" onclick="submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getSubCenterList','subCenterDiv');"/>
  <label>Basic Section </label> <input id="subceneterRadioId" name="subceneterRadioId" type="radio" value="No" class="inputRadiobutton"  onclick="submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getbasicSectionList','subCenterDiv');"/>
 --%>
 <label>Health Block <span>*</span> </label>
 <label class="value large"><%=healthBlock %></label>
 <label>PHC/CHC<span>*</span> </label>
 <label class="value large"><%=phcCHC %></label> 
  <div class="clear"></div>
 <label><%=labelName %></label>
 <label class="value large"><%=hospitalName %></label>
 <input type="hidden" name="villSubcenterId" value="<%=subCenterIdd%>">
  <input type="hidden" name="hospitalIdHB" value="<%=hospitalIdHB%>"> 
  <input type="hidden" name="hospialIdphcCHC" value="<%=hospialIdphcCHC%>"> 
  
 <!--  <label>Sub Center </label> <input id="subceneterRadioId" name="subceneterRadioId" type="radio"  value="Yes" class="inputRadiobutton" onclick="submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getSubCenterList','subCenterDiv');"/>
  <label>Basic Section </label> <input id="subceneterRadioId" name="subceneterRadioId" type="radio" value="No" class="inputRadiobutton"  onclick="submitProtoAjaxWithDivName('phMapping','/hms/hms/pubHealth?method=getbasicSectionList','subCenterDiv');"/>
  
 <div class="clear"></div>
  <div id="subCenterDiv">
  <label>Select Sub Center</label>
    <select name="subcenterId" id="subcenterId" class="large" onchange="seleclLoc(this.value)" validate="locality,string,yes">
             	<option value="0">Select</option>                
	</select>
 <div class="clear"></div>
 </div> -->
<div class="clear"></div>
 <label>Mapping Parameters </label>
    <select name="parametersId" id="parametersId" onchange="getParameters(this.value)" validate="Parameters,string,yes" style="width:334px;">
             	<option value="0">Select</option>
             	<%if(hospitalTypeId==1){ %>
             	<option value="bs">Basic Section</option>
             	<%}else if(hospitalTypeId==2){ %>
             	<option value="sc">Sub Center</option>
             	<%} %>
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
<div class="paddingTop5"></div>
<input type="hidden" name="<%=CHANGED_BY%>"	value="<%=userName%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="button" style="margin-left:286px;"  class="button" name="Submit" value="Submit" onclick="if(chk()){submitForm('phMapping','/hms/hms/pubHealth?method=saveInlocationParameter');}">
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



 