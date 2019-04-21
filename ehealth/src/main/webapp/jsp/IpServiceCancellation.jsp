<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<Inpatient>ipList=new ArrayList<Inpatient>();
if(map.get("ipList")!=null){
	ipList=(List<Inpatient>)map.get("ipList");
}

%>

<div class="clear"></div>
<div class="titleBg">
<h2>IP Service Cancellation</h2>
</div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%
String name="";
String uHID="";
String adNo="";
String Ward="";
int inpatientId=0;

for(Inpatient ip:ipList){ %>
<%if(ip.getHin()!=null){
   if(ip.getHin().getPFirstName()!=null){
	name=ip.getHin().getPFirstName();
   }
   uHID=ip.getHin().getHinNo();
   adNo=ip.getAdNo();
   if(ip.getDepartment()!=null){
	   Ward=ip.getDepartment().getDepartmentName();
   }
   inpatientId=ip.getId();
}
%>


<%} %>
<label>Patient Name</label>
<label class="value"><%=name %></label>
<label>UHID</label>
<label class="value"><%=uHID %></label>
<input type="hidden" value="<%=uHID %>" id="hinId" name="hinNo" />
<input type="hidden" value="<%=inpatientId %>" id="parentId" name="hinNo" />

<label>Ad No</label>
<label class="value"><%=adNo %></label>
<div class="clear"></div>
<label>Ward</label>
<label class="large"><%=Ward %></label>

</div>


<form name="ipCancelService" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label>Prescription</label>
<input type="radio" name="pat" id="presId" val="presc" onclick="getData(this.value);" />
<label>Investigation</label>
<input type="radio" name="pat" id="invId" val="inv" onclick="getData(this.value);" />
<label>Diet</label>
<input type="radio" name="pat" id="dietId" val="diet" onclick="getData(this.value);" />
<div class="clear"></div>
<label>Procedure</label>
<input type="radio" name="pat" id="procId" val="proc" onclick="getData(this.value);" />
<label>Transfer</label>
<input type="radio" name="pat" id="transId" val="trans" onclick="getData(this.value);" />
<label>Discharge</label>
<input type="radio" name="pat" id="disId" val="dis" onclick="getData(this.value);" />
<div class="clear"></div>
<!-- <label>UHID</label>
<input  type="text" name="hinNo" onblur=""     />
 --><div class="clear"></div>
<div id="serviceDiv"></div>

</div>
<script>
function getData(value){
	//alert(value);
	service=value;
	var hin=document.getElementById('hinId').value;
	//alert(hin);
	if(document.getElementById('presId').checked==true){
		service="presc";
	}else if(document.getElementById('invId').checked==true){
		service="inv";
	}else if(document.getElementById('dietId').checked==true){
		service="diet";
	}else if(document.getElementById('procId').checked==true){
		service="procId";
	}else if(document.getElementById('transId').checked==true){
		service="trans";
	}else if(document.getElementById('disId').checked==true){
		service="dis";
	}
	//alert("service --->>"+service)
	//alert("hinNo ----->>"+value)
	submitProtoAjaxWithDivName('ipCancelService','/hms/hms/ipd?method=getServiceGridIP&hinNo='+hin+'&service='+service,'serviceDiv');
}
function cancelInvData(value,service){
	//alert('service'+service);
	if(confirm("Are you sure to cancel the service!!")){
	submitForm('ipCancelService','/hms/hms/ipd?method=cancelServiceInv&dtId='+value+'&service='+service);
	}
	}
	
	function cancelInvData2(){
		var hin=document.getElementById('parentId').value;
		if(confirm("Are you sure to cancel the service!!")){
			submitForm('ipCancelService','/hms/hms/ipd?method=cancelServiceInv2&parent='+hin);	
		}
	}
	
	function setStatus(i){
		//alert("in method"+i);
		if(document.getElementById('statusId'+i).checked==true){
		document.getElementById('canStatId'+i).value="y";
		}else if(document.getElementById('statusId'+i).checked==false){
			document.getElementById('canStatId'+i).value="n";	
		}
	} 
	
	function setStatusPresc(i){
		if(document.getElementById('PresstatusId'+i).checked==true){
		document.getElementById('canPrescStatId'+i).value="y";
		}else if(document.getElementById('PresstatusId'+i).checked==false){
			document.getElementById('canPrescStatId'+i).value="n";	
		}
	}
	function setStatusDiet(i){
		if(document.getElementById('DietstatusId'+i).checked==true){
			document.getElementById('canDietStatId'+i).value="y";
			}else if(document.getElementById('DietstatusId'+i).checked==false){
				document.getElementById('canDietStatId'+i).value="n";	
			}
	}
	function cancelPresData2(){
		var hin=document.getElementById('parentId').value;
		if(confirm("Are you sure to cancel the service!!")){
			submitForm('ipCancelService','/hms/hms/ipd?method=cancelServicePresc&parent='+hin);	
		}
	}
	function cancelDietData(){
		var hin=document.getElementById('parentId').value;
		if(confirm("Are you sure to cancel the service!!")){
			submitForm('ipCancelService','/hms/hms/ipd?method=cancelServiceDiet&parent='+hin);	
		}
	}
</script>

</form>