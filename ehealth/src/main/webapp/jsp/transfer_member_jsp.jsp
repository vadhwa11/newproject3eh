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
 <script type="text/javascript">
		function selectedData(){
		
			var count=document.getElementById("counter").value;
			var selectName=0;
			for(var i=1;i<count;i++){
				if(document.getElementById("phms"+i).checked)
					selectName=selectName+1
			}
			if(selectName==0){alert("You have not Selected Any Details.");return false;}
				return true;
		}
		</script>
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

//List<PhMemberSurvey> phmsList = new ArrayList<PhMemberSurvey>();
List<Object[]> phmsList = new ArrayList<Object[]>();
if(map.get("phmsList") != null){
	phmsList=(List<Object[]> ) map.get("phmsList");	
}
List<MasHospital> subcenterList = new ArrayList<MasHospital>();
if(map.get("subcenterList") != null){
	subcenterList=(List<MasHospital> ) map.get("subcenterList");	
}
List<MasDistrict> districtList = new ArrayList<MasDistrict>();
List<MasTaluk> talukList=new ArrayList<MasTaluk>();
List<MasVillage> villageList = new ArrayList<MasVillage>();
List<MasWard> wardList=new ArrayList<MasWard>();
 
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
 
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }
%>

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%  String message="";
	if(map.get("msg")!=null){
		message=(String)map.get("msg");
		out.print(message);
	} 
	%>
<div class="titleBg">
<h2>Transferred Member </h2>
</div>
<div class="Block">

      <label>District</label>
			<select name="district" id="districtId" tabindex=1 onChange="populateTaluk(this.value,'talukId')">
			<option value="">Select</option>	
			 <%for(MasDistrict masDistrict : districtList)	{%>
				<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
					<%}%></select>
			
				<label>Taluk</label>
				<select name="taluk" id="talukId" tabindex=1 onChange="populateVillage(this.value,'villageId')">
				<option value="">Select</option>
				  <% 	for(MasTaluk masTaluk:talukList){ %>
				<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
			<%}%></select>

		 <label>Village</label>
				<select name="village" id="villageId" onChange="populateWard(this.value,'wardId')">
				<option value="">Select</option>
				 <% for(MasVillage masVillage:villageList){ %>
				<option value="<%=masVillage.getId()%>"><%=masVillage.getVillageName() %></option>
				<%}%></select>

			 <div class="clear"></div>
			<label>Ward</label>
			 <select name="wardId" id="wardId">
				<option value="">Select</option>
				 <% for(MasWard masWard:wardList){ %>
				<option value="<%=masWard.getId()%>"><%=masWard.getWardName() %></option>
				<%}%></select>

<input id="addbutton" class="button" type="button" value="Search" onclick="submitForm('search','pubHealth?method=detailTransferMember');" name="Search">
<div class="clear"></div>
</div>
</form>
<div class="clear"></div>
<form name="memberDetail" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>Member List</h4>
<div class="clear"></div>
<div class="Block">
<div id="pageNavPosition"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<%-- <% if(phmsList.size()>0){%> --%>
<table>
<tr>
		<th scope="col">CheckBox</th>
	    <th scope="col">Name</th>
	    <th scope="col">Gender</th>
	    <th scope="col">Age</th>
		<th scope="col">Guardian Name</th>
		<th scope="col">UHID</th>		
		<th scope="col">Contact No.</th>
		<th scope="col">Transfer From</th>
		<th scope="col">PHC/Sub-center</th>
		
</tr>
<tbody id="tableData">
      
	<% 
	int  counter=1;
	for(Object[] phms:phmsList){
	 %>
	<tr>
	<td><input type="checkbox"  id="phms<%=counter %>" name="phms<%=counter%>" value="<%=phms[0]%>" /></td>
	<td>
	<%if(phms[1]!=null){%>
	<%=phms[1]%>
	<%} %>
	</td>
    <td>
    <%if(phms[2]!=null){%>
	<%=phms[2]%>
	<%} %></td>
    <td>	<%if(phms[3]!=null){%>
	<%=phms[3]%>
	<%} %></td>
    <td>	<%if(phms[4]!=null){%>
	<%=phms[4]%>
	<%} %></td>
    <td>	<%if(phms[5]!=null){%>
	<%=phms[5]%>
	<%} %></td>
    <td>	<%if(phms[6]!=null){%>
	<%=phms[6]%>
	<%} %></td>
    <td>	<%if(phms[7]!=null){%>
	<%=phms[7]%>
	<%} %></td>
	<td>	<%if(phms[8]!=null){%>
	<%=phms[8]%>
	<%} %></td>
	
    

  </tr>
 <%   ++counter;
      }
    %>
  
</tbody>
 </table>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=counter %>" />
<input class="button" type="button" name="Add" onclick="if(selectedData()){submitForm('memberDetail','pubHealth?method=addNewTransferMember');}" value="Add" tabindex="2">
 </div>
 </form>
 	<%-- <%}else{ %> --%>
 	<div class="clear"></div>
 	<% if(phmsList.size()==0){%>
	<h2>No Records Available.</h2>
	<%} %>
	
	
  	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		</script>  
	 
 <div class="clear"></div>
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
		//	alert(villageId);
			optionRepMan = new Option("<%="Select"%>" , "0","true");				
			sel.options.add(optionRepMan);
			if(villageId !="0"){ 
					<% 
					for(MasWard mw:wardList){%>
					var villId = '<%=mw.getVillage() != null ? mw.getVillage().getId() : "" %>';
					if(villId == villageId){   
					 
						optionRepMan = new Option("<%=mw.getWardName()%>" , "<%=mw.getId()%>","true");				
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
	
	