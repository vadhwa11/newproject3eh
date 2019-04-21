<%@page import="jkt.hms.masters.business.MasHospitalwiseChargecode"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasHospitalwiseChargecode> masHospitalwiseChargecodeList = new ArrayList<MasHospitalwiseChargecode>();

if(request.getAttribute("map")!=null)
{
	map=(Map<String, Object>)request.getAttribute("map");
}
if(map.get("masHospitalwiseChargecodeList")!=null)
{
	masHospitalwiseChargecodeList=(List<MasHospitalwiseChargecode>)map.get("masHospitalwiseChargecodeList");
}
%>
<!-- Added by Arbind on 27-06-2017 -->
<script type="text/javascript">
var assignedChargeArray= null;
assignedChargeArray = new Array();
<%
int i=0;
for(MasHospitalwiseChargecode chargeCode:masHospitalwiseChargecodeList)
{
%>
assignedChargeArray[<%=i%>]= new Array();
assignedChargeArray[<%=i%>][0] = "<%=chargeCode.getChargeCode().getId()%>";
<%
i++;
} %>
var e = document.getElementById('subChargeName');
	val = e.options[e.selectedIndex].value;
	flag = false;
	var obj=document.getElementById('mainGroupId');
	obj.options.length=0;
	var k=0;
	for(var i=1;i<=chargeArray.length;i++)
	{
		if(chargeArray[i-1][2]==val) {
			for(var j=1;j<=assignedChargeArray.length;j++) {
				if(chargeArray[i-1][0] == assignedChargeArray[j-1][0]) {
					flag = true;
				}
			}
			if(flag == false) {
				obj.options[k] = new Option(chargeArray[i-1][1],chargeArray[i-1][0]);
				k++;
			}
			flag = false;
		}
	}
</script>
<%
List<Integer> itemList=new ArrayList<Integer>(); 
if (masHospitalwiseChargecodeList.size() > 0) {
	 for(MasHospitalwiseChargecode chargecode:masHospitalwiseChargecodeList)
		  if(!itemList.contains(chargecode.getChargeCode().getId()))
		{
			itemList.add(chargecode.getChargeCode().getId()); 
 %>
     <option value="<%=chargecode.getChargeCode().getId()%>" selected="selected"><%=chargecode.getChargeCode().getChargeCodeName()+"["+chargecode.getChargeCode().getChargeCodeCode()+"]"%></option>
 <% }}%>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
