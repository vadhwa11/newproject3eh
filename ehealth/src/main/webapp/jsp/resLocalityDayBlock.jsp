
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasWard> phMasWardList= new ArrayList<MasWard>();
if(map.get("phMasWardList") != null){
	phMasWardList = (List)map.get("phMasWardList");
	
}


System.out.println(phMasWardList.size()+"-----jsp------------");

%>
<div id="wardDiv">
 	<label>Ward </label>
    <select name="ward" id="ward" validate="ward,string,yes"  onchange="submitProtoAjaxWithDivName('task','/hms/hms/pubHealth?method=getDayBlockId','testDiv');">
             <option value="0">Select</option>
             <%for(MasWard md : phMasWardList){ %>
            	 <option value="<%=md.getId() %>"><%=md.getWardName()%></option>
   			<%} %>
	</select>
 	
 	<div id="testDiv">
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
 
 <style>
.mrgNone{margin:0px;}
</style>
 