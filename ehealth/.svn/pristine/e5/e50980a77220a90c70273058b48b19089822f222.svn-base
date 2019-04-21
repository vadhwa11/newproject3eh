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
<table>
<tr>
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
	int  counter=0;
	for(Object[] phms:phmsList){
	 %>
	 <tr>
	<input type="hidden" name="memberId" value="<%=phms[0]%>"/>
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


<div class="Block">

<div class="clear"></div>

			  
	<label><span>*</span>New Taluk</label>
	<select name="taluk" id="taluk"  validate="New Taluk,string,yes" onchange="submitProtoAjaxWithDivNameToShowStatus('detail','/hms/hms/pubHealth?method=getVillageForTransferedMemberList&taluk='+this.value,'tDivs');" >
      <%	if(talukList.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasTaluk tal : talukList) {
					
				  %>
				  <option value="<%=tal.getId ()%>"><%=tal.getTalukName()%></option>
					  <%
				  	 	}
}else{
%>
		<option value="0">No Data</option>					 
	<%			 
}
				   %>

</select>
					
			<div id="tDivs">
			
		 <label><span>*</span>New Village</label>
				<select name="village" id="village" validate="New Village,string,yes">
				<option value="0">Select</option>
			</select>

			 <div class="clear"></div>
			<label><span>*</span>New Ward</label>
			 <select name="ward" id="ward" validate="New Ward,string,yes">
			 <option value="0">Select</option>
			</select>
				
		<label><span>*</span>New Sub Center</label>
			 <select name="subcenter" id="subcenter" validate="New Sub Center,string,yes">
			 <option value="0">Select</option>
			</select>		
			 </div>
<div class="clear"></div>
 <input type="hidden" name="memberId" id="memberId" value="<%=memberSurvey.getId() %>" /> 

<input id="addbutton" class="button" type="button" value="Add" onclick="submitForm('detail','pubHealth?method=addNewTransferMember');" name="Add">
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


<div class="clear"></div>

