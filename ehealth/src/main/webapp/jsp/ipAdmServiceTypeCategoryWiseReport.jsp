<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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

<%
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	String time = (String) utilMap.get("currentTime");
		 	
		 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
			List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
			
		 	if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>) map.get("departmentList");
			}
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");
	%>


<div class="titleBg">
<h2>Ip Admission Service Type Category Wise</h2>
</div>
<div class="clear"></div>
<form name="ipAdmServiceTypeCategory" target="_blank" method="post"
	action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="Block"><label>Date</label> <input type="text"
	id="fromDateId" name="<%=DATE %>" value="<%=currenDate %>"
	readonly="readonly" MAXLENGTH="30" class="date" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('<%=currenDate %>',document.ipAdmServiceTypeCategory.<%=DATE%>,event)" />

<label><span>*</span> Ward</label> <select id="departmentd"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
								if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%			}
						}
					%>
</select> <label>SIL/DIL</label> <input type="checkbox" name=<%=SILORDIL%>
	value="y" class="radioCheck" />
<div class="clear"></div>
</div>
<input type="button" name="OK" value="OK" class="button"
	onClick="submitForm('ipAdmServiceTypeCategory','adt?method=showIpAdmissionServiceTypeCategoryReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></form>






