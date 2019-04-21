<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>


<%@page import="jkt.hrms.masters.business.MstrTherapeutic"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="org.apache.tools.ant.Project"%>


<form name="projectResourceTime" method="post" action="">

<%
			Map<String,Object> map =new HashMap<String,Object>();
			List<MstrTherapeutic>  therapeuticList = new ArrayList<MstrTherapeutic>();
			List<MstrProject> projectList = new ArrayList<MstrProject>();
			
			if(request.getAttribute("map")!=null){
				map=(Map) request.getAttribute("map");
			}
			if(map.get("projectList")!=null){
				projectList=(List<MstrProject>)map.get("projectList");
			}
			
%>
<script type="text/javascript">
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
<div class="titleBg">
<h2>Project Resource Time</h2></div>

    <div class="clear"></div>
	<div class="Block">
    
    	<div class="clear"></div>
	
    
    	<label><span>*</span> Project</label>
    	
     	<select name="projectId"  validate="Project,string,yes">
    	<option value="0">Select</option>
    	<%for(MstrProject mstrProject : projectList) { %>
			<option value="<%=mstrProject.getId()%>"><%=mstrProject.getPrjName()%></option>
		<%} %>
        </select>

    	<label><span>*</span> Type</label>
     	<select name="billable"  validate="Billable Type,string,yes">
    	<option value="">Select</option>
    	<option value="y">Billable</option>
    	<option value="n">Non-Billable</option>
        </select>

    	<div class="clear"></div>
      
      	<label><span>*</span> From Date</label>
    	<input name="<%=FROM_DATE%>" id="fromDateForApply" type="text" readonly validate='From Date,date,yes' value="" class="date" />
   		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="calFromDate" 
   			onclick="javascript:setdate('',document.projectResourceTime.<%=FROM_DATE%>,event)"  />
    	
		<label><span>*</span> To Date</label>
   		<input type="text" name="<%=TO_DATE%>" id="toDateForApply"  readonly   validate='To Date,date,yes'  
   			value=""  class="date" />
    	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="calToDate"
    		onclick="javascript:setdate('',document.projectResourceTime.<%=TO_DATE%>,event)" />
    	
    	 <div class="clear"></div>
    	 </div>
    	<div class="clear"></div>
    	<input type="button" class="button" value="print" name="print" onclick="submitForm('projectResourceTime','/hms/hrms/report?method=printProjectResourceCost');"/>
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
    	
