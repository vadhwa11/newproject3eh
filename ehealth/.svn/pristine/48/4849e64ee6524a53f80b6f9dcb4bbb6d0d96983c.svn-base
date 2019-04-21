<%@page import="jkt.hms.masters.business.PhDayBlockDetail"%>
<%@page import="jkt.hms.masters.business.PhAtpJphnJhiDetails"%>
<%@page import="jkt.hms.masters.business.PhAtpJphnJhiHeader"%>
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
	
	
	List<PhAtpJphnJhiDetails> phAtpJphnJhiDetails= new ArrayList<PhAtpJphnJhiDetails>();

	 if(map.get("phAtpJphnJhiDetails")!=null){
		 phAtpJphnJhiDetails=(List<PhAtpJphnJhiDetails>)map.get("phAtpJphnJhiDetails");
		}
	 List<PhAtpJphnJhiDetails> phAtpJphnJhiDetList = new ArrayList<PhAtpJphnJhiDetails>();
	 if(map.get("phAtpJphnJhiDetList")!=null){
		 phAtpJphnJhiDetList=(List<PhAtpJphnJhiDetails>)map.get("phAtpJphnJhiDetList");
		}
%>

<div class="clear"></div>

<form name="task" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<div class="clear"></div>

<div id="testDiv">
<label >House NO</label>
 
<label>Locality </label>
 <%-- <%if(phAtpJphnJhiDetails.size()>0){ %>
             <%
    
    for(PhAtpJphnJhiDetails md : phAtpJphnJhiDetails){
    	 PhDayBlock ds=(PhDayBlock)md.getDayBlock();
    	 Set<PhDayBlockDetail> dtail=(Set<PhDayBlockDetail>)ds.getPhDayBlockDetails();
    	 for(PhDayBlockDetail vf:dtail) {%>
			
 <label>  <%=vf.getLocality().getLocalityName()%></label>		
			
    	
	         <%
	         }}
    
            }%> --%>

<label>Houses Completed</label>
<div class="clear"></div>

<div id="loc">
  <%int i = 1;%>  
     
<select name="mainGroupId<%= i %>" id="mainGroupId"  multiple="multiple" size="7" class="listBig3" style="margin-top:0px;">
            <%if(phAtpJphnJhiDetails.size()>0){ %>
             <%
    
    for(PhAtpJphnJhiDetails md : phAtpJphnJhiDetails){
    	 PhDayBlock ds=(PhDayBlock)md.getDayBlock();
    	 Set<PhDayBlockDetail> dtail=(Set<PhDayBlockDetail>)ds.getPhDayBlockDetails();
    	 for(PhDayBlockDetail vf:dtail) {%>
		 <option value="<%=md.getId()%>"><%=vf.getSurvey().getHouseHoldId()%></option>		
	         <%
	         }}
            }%>
</select>

<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />
<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>
</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3" style="margin-top:0px;">
   <%if(phAtpJphnJhiDetList.size()>0){ %>
             <%
    
    for(PhAtpJphnJhiDetails md : phAtpJphnJhiDetList){
    	 PhDayBlock ds=(PhDayBlock)md.getDayBlock();
    	 Set<PhDayBlockDetail> dtail=(Set<PhDayBlockDetail>)ds.getPhDayBlockDetails();
    	 for(PhDayBlockDetail vf:dtail) {%>
		 <option value="<%=md.getId()%>"><%=vf.getSurvey().getHouseHoldId()%></option>		
	         <%
	         }}
            }%>
</select>
<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="button" class="button" style="margin-left:306px;" name="Submit" value="Submit" onclick="if(chk()){submitForm('task','/hms/hms/pubHealth?method=saveDailyWork');}">
<input type="button" class="button" name="Reset" value="Reset" onclick="submitFormForButton('task','/hms/hms/pubHealth?method=showDayBlockAllocationJsp')">  

 </div>
 <div class="clear"></div>
 <div class="paddingTop5"></div>
</div>
</div>	
</form>
