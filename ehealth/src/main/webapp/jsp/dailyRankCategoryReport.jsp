
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
  function clearButton(formName)
  {
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=showDailyOPDRankCategoryReportJsp";
  obj.submit();
  }
</script>

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

<script type="text/javascript">
function check(){
var SDate = document.dailyOPDRankCategory.<%= FROM_DATE%>.value;
var EDate = document.dailyOPDRankCategory.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasDepartment> searchMasDepartmentList = new ArrayList<MasDepartment>();
	List<MasRankCategory> searchMasRankList = new ArrayList<MasRankCategory>();
	if(map.get("searchMasDepartmentList")!=null)
		searchMasDepartmentList = (List) map.get("searchMasDepartmentList");
	if(map.get("searchMasRankList")!=null)
		searchMasRankList = (List) map.get("searchMasRankList");
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");

%>

<form name="dailyOPDRankCategory" method="post" action="">

<div class="titleBg">
<h2>Daily OPD Rank Category</h2>
</div>
<div class="clear"></div>

<div class="Block"><label><span>*</span> From Date </label> <input
	type="text" name="<%=FROM_DATE%>" value="" class="date" MAXLENGTH="30"
	validate="Pick a from date,date,yes" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.dailyOPDRankCategory.<%=FROM_DATE%>,true)" />

<label><span>*</span> To Date </label> <input type="text"
	name="<%=TO_DATE%>" value="" class="date" MAXLENGTH="30"
	validate="Pick a to date,date,yes" readonly="readonly" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=currentDate%>',document.dailyOPDRankCategory.<%=TO_DATE%>,true)" />

<div class="clear"></div>

<label><span>*</span> Department</label> <select id="deptId"
	name="<%=DEPARTMENT_ID%>" validate="Department,string,yes">
	<option value="0">Select</option>
	<%
				for (MasDepartment masDepartment :searchMasDepartmentList ) {
				
				%>
	<option value=<%=masDepartment.getId()%>><%=masDepartment.getDepartmentName()%>
	</option>
	<%	
					}
				
					
				%>
</select> <script type="text/javascript">
	
		document.getElementById('deptId').value = '<%=deptId%>';
		
		</script> <label><span>*</span> Rank Name</label> <select name="<%=RANK_ID%>"
	validate="Rank Name,String,yes">
	<option value=0>Select</option>
	<%
				for (MasRankCategory masRank :searchMasRankList ) {
				
				%>
	<option value=<%=masRank.getId()%>><%=masRank.getRankCategoryName()%>
	</option>
	<%	
					}
				
					
				%>
</select>

<div class="clear"></div>
<label>Summary</label> <input type="radio" name="<%=SELECTED_RADIO%>"
	value=1 checked="checked" class="radioCheck" /> <label class="auto">Detail</label><input
	type="radio" name="<%=SELECTED_RADIO %>" value=2 class="radioCheck" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Ok" class="button"
	onClick="submitForm('dailyOPDRankCategory','opd?method=generateDailyOPDRankCategoryReport','check()');"
	accesskey="a" tabindex=1 /> <input type="button" name="clear"
	id="clearbutton" value="Clear" class="button"
	onClick="clearButton('dailyOPDRankCategory');" accesskey="a" tabindex=1 />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>








