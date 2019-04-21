<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
<%@ page import="java.util.*" %>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/prototype.js"></script>
 
 <script>
<%Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<%
Map map = new HashMap();
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
List<Object[]> phmsList = new ArrayList<Object[]>();
if(map.get("phmsList") != null){
	phmsList=(List<Object[]> ) map.get("phmsList");	
}

List<MasDistrict> districtList = new ArrayList<MasDistrict>();
List<MasTaluk> talukList=new ArrayList<MasTaluk>();
List<MasVillage> villageList = new ArrayList<MasVillage>();
List<MasWard> wardList=new ArrayList<MasWard>();
List<PhMemberSurvey> memberList = new ArrayList<PhMemberSurvey>();

if(map.get("memberList") != null){
	memberList=(List<PhMemberSurvey> ) map.get("memberList");	
}

if(map.get("districtList") != null){
	districtList=(List<MasDistrict> ) map.get("districtList");	
}
if(map.get("talukList") != null){
	talukList=(List<MasTaluk> ) map.get("talukList");	
}
if(map.get("villageList") != null){
	villageList=(List<MasVillage> ) map.get("villageList");	
}
if(map.get("wardList") != null){
	wardList=(List<MasWard> ) map.get("wardList");	
}
List<MasHospital> subcenterList = new ArrayList<MasHospital>();
if(map.get("subcenterList") != null){
	subcenterList=(List<MasHospital> ) map.get("subcenterList");	
}
String MemberId="";
if(map.get("memberId") != null){
	MemberId=(String) map.get("memberId");
}
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }
PhMemberSurvey memberSurvey = new PhMemberSurvey();
if(memberList.size() > 0){
	memberSurvey = memberList.get(0);
}
%>

<div class="titleBg">
<h2>New Transferred Member </h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<form name="detail" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<table>
<tr>
	    <th scope="col">Member Name</th>
		<th scope="col">Guardian Name</th>		
		<th scope="col">Contact No.</th>
		<th scope="col">Root SubCenter/Basic Section </th>
</tr>
<tbody id="tableData">
      
	<% 
	int  counter=0;
	for(Object[] phms:phmsList){
	 %>
	 <tr onclick="submitForm('detail', 'pubHealth?method=showNewTransferMember&memberId=<%=phms[1]%>')">
	<td><%=phms[4]%></td>
    <td><%=phms[40]%></td>
    <td><%=phms[22]%></td>
 <td>
 <%for(MasHospital hospital:subcenterList){ %>
 	<%=hospital.getId()!=null ? hospital.getHospitalName():""%> 
 <%}%>
 </td>
  </tr>
 <%   ++counter;
      }
    %>
  
</tbody>
 </table>

       </form>

<div class="clear"></div>
<div class="Block">
<form name="add" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="clear"></div>

      <label><span>*</span>New District</label>
			<select name="district" id="districtId" validate="district,string,yes" tabindex="22" onChange="populateTaluk(this.value,'talukId')">
			<option value="">Select</option>	
			 <%for(MasDistrict masDistrict : districtList)	{%>
				<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
					<%}%></select>
			
				<label><span>*</span>New Taluk</label>
				<select name="taluk" id="talukId" validate="taluk,string,yes" tabindex="22" onChange="populateVillage(this.value,'villageId')">
				<option value="">Select</option>
				  <% 	for(MasTaluk masTaluk:talukList){ %>
				<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
			<%}%></select>

		 <label><span>*</span>New Village</label>
				<select name="village" id="villageId" validate="village,string,yes" onChange="populateWard(this.value,'wardId')">
				<option value="">Select</option>
				 <% for(MasVillage masVillage:villageList){ %>
				<option value="<%=masVillage.getId()%>"><%=masVillage.getVillageName() %></option>
				<%}%></select>

			 <div class="clear"></div>
			<label><span>*</span>New Ward</label>
			 <select name="ward" id="wardId" validate="ward,string,yes" onchange="populateSub(this.value,'subcenterId')">
				<option value="">Select</option>
				 <% for(MasWard masWard:wardList){ %>
				<option value="<%=masWard.getId()%>"><%=masWard.getWardName() %></option>
				<%}%></select>
				
		<label><span>*</span>New SubCenter</label>
			 <select name="subcenter" id="subcenterId" validate="subcenter,string,yes">
				<option value="">Select</option>
				 <% for(MasHospital hospital:subcenterList){ %>
				<option value="<%=hospital.getId()%>"><%=hospital.getHospitalName() %></option>
				<%}%></select>		
			 
<div class="clear"></div>
 <input type="hidden" name="memberId" id="memberId" value="<%=memberSurvey.getId() %>" /> 

<input id="addbutton" class="button" type="button" value="Add" onclick="submitForm('add','pubHealth?method=addNewTransferMember');" name="Add">

</form>
</div>
<div class="clear"></div>

<script type="text/javascript">
 
function populateTaluk(diistrictId,id){	
	var sel = document.getElementById(id);
	removeAllOptions(sel);
	optionRepMan = new Option("<%="Select"%>" , "0","true");				
	sel.options.add(optionRepMan);
	if(diistrictId !="0"){ 
			<% 
			for(MasTaluk mt:talukList){%>
			var distId='<%=mt.getDistrict().getId() %>';
			if(distId== diistrictId){   
				optionRepMan = new Option("<%=mt.getTalukName()%>" , "<%=mt.getId()%>","true");				
				sel.options.add(optionRepMan);	
				}
			  <%}%>
		}
}

	function populateVillage(taalukId,id){	
		var sel = document.getElementById(id);
		removeAllOptions(sel);
		optionRepMan = new Option("<%="Select"%>" , "0","true");				
		sel.options.add(optionRepMan);	
		if(taalukId !="0"){ 
				<% 
				for(MasVillage mv:villageList){%>
				var talId = '<%=mv.getTaluk().getId() %>';
				if(talId== taalukId){   
					optionRepMan = new Option("<%=mv.getVillageName()%>" , "<%=mv.getId()%>","true");				
					sel.options.add(optionRepMan);	
				 
					}
				  <%}%>
					
			}
	}
	
	
	function populateWard(villageId,id){	
		var sel = document.getElementById(id);
		removeAllOptions(sel);

		optionRepMan = new Option("<%="Select"%>" , "0","true");				
		sel.options.add(optionRepMan);
		if(villageId !="0"){ 
				<% 
				for(MasWard mw:wardList){%>
				var villId = '<%=mw.getVillage().getId() %>';
				if(villId == villageId){   
				 
					optionRepMan = new Option("<%=mw.getWardName()%>" , "<%=mw.getId()%>","true");				
					sel.options.add(optionRepMan);	
				 
					}
					<%}%>
			}
	}	
	
	function populateSub(wardId,id){	
		var sel = document.getElementById(id);
		removeAllOptions(sel);

		optionRepMan = new Option("<%="Select"%>" , "0","true");				
		sel.options.add(optionRepMan);
		if(wardId !="0"){ 
				<% 
				for(MasHospital mh:subcenterList){%>
				var warId = '<%=mh.getId() %>';
				if(warId == wardId){   
				 
					optionRepMan = new Option("<%=mh.getHospitalName()%>" , "<%=mh.getId()%>","true");				
					sel.options.add(optionRepMan);	
				 
					}
					<%}%>
			}
	}

	function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}
	</script>