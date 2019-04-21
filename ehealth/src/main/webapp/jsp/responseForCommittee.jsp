<%@page import="jkt.hms.masters.business.MasDiscount"%>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response of discount details for update.
 * @author  Javed
 * Create Date: 22th Jun,2015
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.math.BigDecimal"%>


<%@page import="jkt.hms.masters.business.HrCommitteeDetails"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>

<!-- <script type="text/javascript">
animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('title3', 'fade=0,speed=400,group=pets,hide=1,persist=0,hide=0')
animatedcollapse.addDiv('title4', 'fade=0,speed=400,group=pets,hide=0')
animatedcollapse.addDiv('title5', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title6', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title7', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title8', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.init()
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script> -->

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

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<HrCommitteeDetails>  commiteeDetailsList = new ArrayList<HrCommitteeDetails>();
	if (map.get("commiteeDetailsList") != null) {
		commiteeDetailsList = (List<HrCommitteeDetails> ) map.get("commiteeDetailsList");
	}
	
System.out.println("comm>>>"+commiteeDetailsList.size());

%>

<div id="testDiv">

			<div class="clear"></div>	
 <div class="cmntable">
<%if(commiteeDetailsList.size()>0){ %>


<table id="dinPanGrid" >
			<tr>
			<th></th>
		<th scope="col">Members</th>
		<th scope="col">Designation</th>		
		<th scope="col">Remarks</th>		
		
						

	</tr>
	<%
	  String klass = "even";
	  int  counter1=0;
				String id1 = "";
	 		id1 = "id" + counter1;
	 		counter1++;

	 		if(counter1%2==0){
	 			klass = "even";
	 		}
	 		else
	 		{
	 			klass= "odd";
	 		}

String url="";
  %>

<%int i1=0; 

for(HrCommitteeDetails hcd : commiteeDetailsList){
	i1++;
%>

		<tr>
		<td><input type="checkbox" class="radioCheck" id="chk" name="chk" value="0" /></td>
		<td>
			<%if(hcd.getCommitteeMemberType().equalsIgnoreCase("employee")){ %>
			<input type="hidden"  id="emp_id1"  name="emp_id"  tabindex="1" value="<%=hcd.getEmployee().getId()%>" readonly="readonly"/>
			<%} else{%>
			<input type="hidden"  id="memberId1"  name="memberId"  tabindex="1" value="<%=hcd.getId()%>" readonly="readonly"/>
			<%} %>
			<input type="text"  size="50" value="<%=hcd.getName() %>" id="nameMember1"  name="nameMember"  tabindex="1" />
		</td>
		<td><%if(hcd.getCommitteeMemberType().equalsIgnoreCase("employee")){ %>
		<input type="text"  id="designation1" Value="<%=hcd.getDesignation().getRankName() %>" name="designation"  tabindex="1" validate="Designation,string,no" readonly="readonly"> 
		<%}else{ System.out.println(">>>."+hcd.getDesignationName() );%>
		
		<input type="text"  id="designation1" Value="<%=hcd.getDesignationName() %>" name="designation"  tabindex="1" validate="Designation,string,no" readonly="readonly">
		<%} %>
		
		</td>
		
			
			<td>
				<input type="text" id="remarks" name="remarks<%=i1%>" value="" size="6" MAXLENGTH="5" class="medium3" validate="Remark,String,no" />
			</td>
			
			
		

	</tr>
	
<%}
%>

</table>

		
<input type="hidden" id="counter" value="<%=commiteeDetailsList.size() %>" name="counter" /> 
<%}else{ %>




<table id="dinPanGrid" >
<tr>
<th></th>
<th>Members</th>
<th>Designation</th>
<th>Remarks</th>
</tr>
<tr>
<td><input type="checkbox" class="radioCheck" id="chk" name="chk" value="0" /></td>
<td><input type="text"  size="50" value="" id="nameMember1"  name="nameMember"  tabindex="1" onblur="fillMemberDetails(this.value,1)"/>
<div id="ac2update1" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		
		  new Ajax.Autocompleter('nameMember1','ac2update1','/hms/hrms/training?method=getMemberListForName',{parameters:'requiredField=nameMember'});
		</script>
</td>

<td><input type="text"  id="designation1"  name="designation"  tabindex="1" validate="Designation,string,no" readonly="readonly">
<input type="hidden"  id="emp_id1"  name="emp_id"  tabindex="1"  readonly="readonly">
	<input type="hidden"  id="memberId1"  name="memberId"  tabindex="1" readonly="readonly"/>
</td>
<td><input type="text" name="remarks" id="remarks1" size="30" value="" maxlength="80"/></td>


</tr>
</table>

<input type="hidden" name="counter" id="counter" value="1" />


<%} %>
</div>
	

	</div>

	
	