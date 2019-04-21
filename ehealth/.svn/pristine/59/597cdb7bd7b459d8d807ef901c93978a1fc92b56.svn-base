
<%@page import="jkt.hms.masters.business.LocationParameterMapping"%>
<%@page import="jkt.hms.masters.business.PhDayBlockDetail"%>
<%@page import="jkt.hms.masters.business.PhDayBlock"%>
<%@page import="jkt.hms.masters.business.PhMasLocality"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>

<script>
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
	serverdate = '<%=date1+"/"+month+"/"+year%>';
	</script>
<div id="testDiv">
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.masters.business.PhMasLocality"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>	

<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript">

		
</script>

<%	
		String hospitalName="";
		Map map = new HashMap();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
	  	List<PhHouseSurvey> al1 = new ArrayList<PhHouseSurvey>();
		List<LocationParameterMapping>   phMasLocalityList = new ArrayList<LocationParameterMapping>();
		List<PhHouseSurvey>   phHouseSurveyList = new ArrayList<PhHouseSurvey>();
		List<PhDayBlock>   phDayBlockList = new ArrayList<PhDayBlock>();
		
		
		if(map.get("phMasLocalityList")!=null){
			 phMasLocalityList=(List<LocationParameterMapping>)map.get("phMasLocalityList");
			 System.out.println(phMasLocalityList.size() +"in Java controller<>><><><><><>");
			 
			}
		 
			if(map.get("phHouseSurveyList")!=null){
				 phHouseSurveyList=(List<PhHouseSurvey>)map.get("phHouseSurveyList");
			}
			
			if(map.get("phDayBlockList")!=null){
				phDayBlockList=(List<PhDayBlock>)map.get("phDayBlockList");
			}
			List<PhDayBlockDetail> phDayBlockDetailList = new ArrayList<PhDayBlockDetail>();
			if(map.get("phDayBlockDetailList")!=null){
				phDayBlockDetailList=(List<PhDayBlockDetail>)map.get("phDayBlockDetailList");
			}	
    		if(phDayBlockList.size()>0)
    		{
    			//for(PhDayBlock phDayBlock: phDayBlockList){
    				
    				
    			%>

	
 	<label>Locality </label>
    <select name="locality" id="locality" onchange="seleclLoc(this.value);" validate="locality,string,yes">
             	<option value="0">Select</option>
                  <%for(LocationParameterMapping md : phMasLocalityList){
                    if(md.getLocality()!=null){    
                	  %>
            	 <option value="<%=md.getLocality().getId()%>"><%=md.getLocality().getLocalityName()%></option>
   					<%}
                  }
   					%>
	</select>
	 
  <div class="clear"></div>
  <labelWithoutBox> </labelWithoutBox>
  <labelWithoutBox class="auto">List of Houses in selected Locality</labelWithoutBox>
<labelWithoutBox> </labelWithoutBox>
<labelWithoutBox> </labelWithoutBox>
 <labelWithoutBox class="auto">List of Houses in selected  Day Block </labelWithoutBox>
 <div class="clear"></div>
<labelWithoutBox> </labelWithoutBox>
 

 <div id="loc">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3">
</select>
 </div>

<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
                   <%for(PhDayBlockDetail d : phDayBlockDetailList){ %>
            	 <option value="<%=d.getSurvey().getId()%>" selected="selected"><%=d.getSurvey().getHouseHoldId()%>(<%=d.getSurvey().getAddress()%>,<%=d.getSurvey().getLsgHouseNo()%>)</option>
   					<%} %>
    		
</select>

<div class="clear"></div>
<div class="clear"></div>
 </div>

  <labelWithoutBox> </labelWithoutBox>
            <labelWithoutBox> </labelWithoutBox>
            <labelWithoutBox> </labelWithoutBox>
<input type="hidden" value="u" name="flag" />
 <input type="button" class="button" name="Submit" value="Update" onclick="submitForm('task','/hms/hms/pubHealth?method=saveDayBlockAllocation');">
 <div class="clear"></div>
  <labelWithoutBox> </labelWithoutBox>
            <labelWithoutBox> </labelWithoutBox>
            <labelWithoutBox> </labelWithoutBox>
<input type="button" class="button" name="Reset" value="Reset" onclick="submitForm('task','/hms/hms/pubHealth?method=showDayBlockAllocationJsp')">

<%}
    			//}
    		else{%>

 
 	<label>Locality </label>
    <select name="locality" id="locality" onchange="seleclLoc(this.value)" validate="locality,string,yes">
             	<option value="0">Select</option>
                  <%for(LocationParameterMapping md : phMasLocalityList){ 
                        if(md.getLocality()!=null){                  
                  %>
            	 <option value="<%=md.getLocality().getId()%>"><%=md.getLocality().getLocalityName()%></option>
   					<%}
                  }
                        %>
	</select>
 
 
  <div class="clear"></div>

  <labelWithoutBox> </labelWithoutBox>
 <labelWithoutBox class="auto">List of Houses in selected Locality</labelWithoutBox>
<labelWithoutBox> </labelWithoutBox>
<labelWithoutBox> </labelWithoutBox>
 <labelWithoutBox class="auto">List of Houses in selected  Day Block </labelWithoutBox>
 <div class="clear"></div>
<labelWithoutBox> </labelWithoutBox>

<input type="hidden" value="s" name="flag" />

 <div id="loc">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3">



</select>
</div>

<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
     
</select>

 <div class="clear"></div>
  <labelWithoutBox> </labelWithoutBox>
            <labelWithoutBox> </labelWithoutBox>
            <labelWithoutBox> </labelWithoutBox>
<input type="button" class="button" name="Submit" value="Submit" onclick="if(chk()){submitForm('task','/hms/hms/pubHealth?method=saveDayBlockAllocation&flag=s');}">
 <div class="clear"></div>
  <labelWithoutBox> </labelWithoutBox>
            <labelWithoutBox> </labelWithoutBox>
            <labelWithoutBox> </labelWithoutBox>
<input type="button" class="button" name="Reset" value="Reset" onclick="submitForm('task','/hms/hms/pubHealth?method=showDayBlockAllocationJsp')">  
 </div>
<%} %>





</div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
