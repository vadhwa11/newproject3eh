<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasIcd>mList = new ArrayList<MasIcd>();
if(map.get("mList") != null){
	mList = (List<MasIcd>)map.get("mList");
}

%>
<%if(mList.size()>0){ %>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="comorbidityGrid">
		<tr>
			<th scope="col">&nbsp;</th>
			<th scope="col">Comorbidity</th>
			<th scope="col">Since:Month</th>
			<th scope="col">Year</th>
			<th scope="col">Remarks</th>
		</tr>
		<%int incr=0; %>
		<%for(int i=0;i<mList.size();i++){
			MasIcd temp=(MasIcd)mList.get(i);
		 %>
			<tr>
			<td><input type="checkbox" class="radioCheck" id="comorbidityRadio<%=incr %>" name="comorbidityRadio<%=incr %>"/></td>	
			<td>
				<input type="text" class="opdgridText textYellow" value="<%=temp.getIcdName() %>[<%=temp.getIcdCode() %>]"  id="comorbidityName<%=incr %>" name="comorbidityName<%=incr %>"  />
				<div id="ac2updateComorbidity<%=incr %>" style="display: none;" class="autocomplete"></div>
				<script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('comorbidityName<%=incr %>','ac2updateComorbidity<%=incr %>','opd?method=getICDList',{parameters:'requiredField=icd'});
				</script>
			</td>
			<td><input type="text" class="opdgridText textYellow" name="comorbidityMonth<%=incr %>" id="comorbidityMonth<%=incr %>"/></td>
			<td><input type="text" class="opdgridText textYellow" name="comorbidityYear<%=incr %>" id="comorbidityYear<%=incr %>"/></td>
			<td><input type="text" class="opdgridText textYellow" name="comorbidityRemark<%=incr %>" id="comorbidityRemark<%=incr %>"/></td>
			</tr>
		<%incr++;} %>
	</table>
<input type="hidden" name="comorbidityCount" value="<%=incr%>" id="comorbidityCount" />
<%}else{ %>
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="comorbidityGrid">
		<tr>
			<th scope="col">&nbsp;</th>
			<th scope="col">Comorbidity</th>
			<th scope="col">Since:Month</th>
			<th scope="col">Year</th>
			<th scope="col">Remarks</th>
		</tr>
		<%int incr=0; %>
		<tr>
			<td><input type="checkbox" class="radioCheck" id="comorbidityRadio<%=incr %>" name="comorbidityRadio<%=incr %>"/></td>	
			<td>
				<input type="text" class="opdgridText"  id="comorbidityName<%=incr %>" name="comorbidityName<%=incr %>"  />
				<div id="ac2updateComorbidity<%=incr %>" style="display: none;" class="autocomplete"></div>
				<script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('comorbidityName<%=incr %>','ac2updateComorbidity<%=incr %>','opd?method=getICDList',{parameters:'requiredField=icd'});
				</script>
			</td>
			<td><input type="text" class="opdgridText textYellow" name="comorbidityMonth<%=incr %>" id="comorbidityMonth<%=incr %>"/></td>
			<td><input type="text" class="opdgridText textYellow" name="comorbidityYear<%=incr %>" id="comorbidityYear<%=incr %>"/></td>
			<td><input type="text" class="opdgridText textYellow" name="comorbidityRemark<%=incr %>" id="comorbidityRemark<%=incr %>"/></td>
			</tr>
	</table>
<input type="hidden" name="comorbidityCount" value="<%=incr%>" id="comorbidityCount" />
<%} %>





