<%@page import="java.util.*"%>
<%@page import="jkt.hrms.masters.business.HrNoticeBoardData"%>

<%Map map = new HashMap();
if(request.getAttribute("map")!=null){
	map=(Map)request.getAttribute("map");
}
List<HrNoticeBoardData> noticeToDisplayList  = new ArrayList<HrNoticeBoardData>();
if(map.get("noticeToDisplayList")!=null)
{
	noticeToDisplayList=(List<HrNoticeBoardData>)map.get("noticeToDisplayList");
}
if(noticeToDisplayList!=null && noticeToDisplayList.size()>0)
{%>
<div id="msgToDisplay"><textarea
	style="width: 700px; height: 200px" id="ts" readonly="readonly"
	name="msgToDisplay" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"
	validate="Notice,string,yes">
 <%=noticeToDisplayList.get(0).getNoticeData() %>
</textarea></div>
<%
}%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
