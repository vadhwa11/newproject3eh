<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DgNormalValue"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<%
Map<String,Object> map = new HashMap<String,Object>();
List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
DgResultEntryHeader dgResultEntryHeaderForReport = new DgResultEntryHeader();

Set<DgResultEntryDetail> subSet1 = new HashSet<DgResultEntryDetail>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

if (map.get("resultList") != null) {
	resultList = (List<DgResultEntryHeader>) map.get("resultList");
}

if(resultList.size() > 0 ){
	subSet1 = resultList.get(0).getDgResultEntryDetails();
	dgResultEntryHeaderForReport = resultList.get(0);
}
Set<DgResultEntryDetail> dgResultdetail = new LinkedHashSet<DgResultEntryDetail>();
dgResultdetail = dgResultEntryHeaderForReport.getDgResultEntryDetails();

for(DgResultEntryDetail dgDetail : dgResultdetail){
%>

<div class="titleBg"><h2>Investigation Result</h2></div>
<label>Investigation</label>
<label class="value"><%= dgResultEntryHeaderForReport.getInvestigation().getInvestigationName()%></label>
<div class="clear"></div>

<label>Result</label>
<%
	String s = "";
	if(dgDetail.getResult() != null){
		s = dgDetail.getResult();

	/* String[] str = dgDetail.getResultForDischargeSummary().split(" ");
	for(int i=0;i<str.length;i++){
		if(i>4){
			s = s.concat(" ").concat(str[i]);
		}
	}*/
	}else{
		s = dgDetail.getResult();
	}

%>
<%=dgDetail.getResult() %>
<div class="clear"></div>
<label>Remarks</label> <% if(dgDetail.getRemarks() != null && !dgDetail.getRemarks().equals("")){ %>
<label class="value"><%=dgDetail.getRemarks()%></label> <% } else { %> <label
	class="value">-</label> <% } %>
<div class="clear"></div>

<%}%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		