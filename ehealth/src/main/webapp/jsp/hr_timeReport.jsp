<%@page import="java.util.*"%>
<%@ page import = "static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>



<%
			Map<String,Object> map =new HashMap<String,Object>();
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
<form name="timeReport" method="post" action="">
	<div class="titleBg">
	<h2>Time  Report</h2></div>
	<div class="Block">
    <div class="clear"></div>
    
    	

    	<label><span>*</span> Type</label>
     	<select name="billable"  validate="Billable Type,string,yes">
    	<option value="all">All</option>
    	<option value="y">Billable</option>
    	<option value="n">Non-Billable</option>
        </select>

    	<div class="clear"></div>
      
      	
    	 <div class="clear"></div>
    	 
    	<input type="button" class="button" value="print" name="print" onclick="submitForm('timeReport','/hms/hrms/report?method=printTimeReport');"/>
    	</div>
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
    	
