<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.CommunicationMessages"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script> <script type="text/javascript"
	src="/hms/jsp/js/pops_global.js"></script> <script
	type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script> <script
	src="/hms/jsp/js/ajax.js" type="text/javascript"></script> <script
	src="/hms/jsp/js/prototype.js" type="text/javascript"></script> <script
	src="/hms/jsp/js/common.js" type="text/javascript"></script> <script
	src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script> <script
	type="text/javascript">

    <!--
        var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
        var IMGDIR_MISC = "images/misc";
        var vb_disable_ajax = parseInt("0", 10);
        // -->

 function changeList(){
	
         
			  if(document.messageCommunicationForm.selectedChrage.checked)				 
				   {
			  		document.messageCommunicationForm.toEmployee.disabled = true;
			  }
			  else{
			   		document.messageCommunicationForm.toEmployee.disabled = false;
			  }
 }
</script>

<form name="messageCommunicationForm" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<%
	Map<String, Object> map = new HashMap<String, Object>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	String lastChangedTime = "";
	List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
	List<CommunicationMessages> msgCommunicationList = new ArrayList<CommunicationMessages>();
	List<CommunicationMessages> communicationMessagesSentList=new ArrayList<CommunicationMessages>();
	
	String userName = "";
	String msgTxt = "";
	CommunicationMessages lastMessageTime = new CommunicationMessages();


	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (request.getParameter("MessageText") != null
			|| request.getParameter("MessageText") != "") {
		msgTxt = request.getParameter("MessageText");
	}

	if (map.get("masEmployeeList") != null) {
		masEmployeeList = (List<MasEmployee>) map
				.get("masEmployeeList");
	}
	if (map.get("message") != null) {
		String message = (String) map.get("message");
		out.println(message);
	}
	if (map.get("communicationMessagesList") != null) {
		msgCommunicationList = (List<CommunicationMessages>) map
				.get("communicationMessagesList");

	}
	if (map.get("communicationMessagesSentList") != null) {
		communicationMessagesSentList = (List<CommunicationMessages>) map
				.get("communicationMessagesSentList");

	}
%>

<h2>Communication With Message Send/Receive</h2>
</div>
<div class="clear"></div>


<div class="Block">

    <label>Send All</label><input type="checkbox" name="selectedChrage" id="selectedChrage" onClick="changeList();"/> 
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	
  <label><span>*</span> To </label> <select
	name="toEmployee" id="toEmployee" size="5" multiple
	 class="list">
	<option value="">--------Message To-------------</option>
	<%
		if (masEmployeeList.size() > 0) {
			for (MasEmployee masEmployee : masEmployeeList) {
	%>

	<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName() + " "
							+ masEmployee.getLastName()%></option>

	<%
		}
		}
	%>
</select> 	
<div class="clear"></div>
<label><span>*</span> Message Text</label> <textarea id="" class="large"
	name="MessageText" id="MessageText" value=""></textarea>
<div class="clear"></div>
<input type="button" name="sss" align="right" class="button"
	value="Submit"
	onclick="submitForm('messageCommunicationForm','hes?method=submitCommunicationMessageJsp');" />
<div class="clear"></div></div>

<div class="cmntableWithHeight">
<table cellspacing="0" cellpadding="0" border="0" align="center"
	colspan="7">
	<tbody>
		<tr>
			<th >Sr.No.</th>
			<th >Message From</th>
			<th >Message From Text</th>
			<th >Date</th>
			<th >Message Received Time</th>
		</tr>
	</tbody>

	<%
		int srNo = 1;
	%>
	<tbody class="scrollContent bodyFormat">

		<%
			if (msgCommunicationList.size() > 0) {
				for (CommunicationMessages msgCommunication : msgCommunicationList) {
		%>
		<tr>
			<!-- <td width="5%">1</td>  -->
			<td width="2%">
			<%
				out.print(srNo++);
			%>
			</td>

			<td width="5%">
			<%
				if (masEmployeeList.size() > 0) {
							for (MasEmployee masEmployeePrint : masEmployeeList) {
								if (msgCommunication.getFromEmployee().getId()
										.equals(masEmployeePrint.getId())) {
			%> <label class="value"><%=masEmployeePrint.getFirstName() + " "
										+ masEmployeePrint.getLastName()%></label>
			<%
				}
							}
						}
			%>
			</td>
			<td width="20%">
				<textarea name="MessageText" id="MessageText"
	cols="200" rows="3" class="large" tabindex="19" readonly="readonly">
	<%=msgCommunication.getMessageText()%>
	</textarea>
				
				</td>
			<td width="5%"><label class="value"><%=currentDate%></td>
			<td width="5%"><label class="value"><%=msgCommunication.getLastChgTime()%>
			</label></td>
			<%
				}
			%>

		</tr>
		<%
			}
		%>
	</tbody>
</table>
</div>
<!-- For Message From -->
<div class="cmntable">
<table cellspacing="0" cellpadding="0" border="0" align="center"
	colspan="7">
	<tbody>
		<tr>
			<th scope="col">Sr.No.</th>
			<th scope="col">Message To</th>
			<th scope="col">Message To Text</th>
			<th scope="col">Date</th>
			<th scope="col">Message Send Time</th>
		</tr>
	</tbody>
	<% int counter=1; %>
	
	<tbody class="scrollContent bodyFormat">
		<%
			if (communicationMessagesSentList.size() > 0) {
				for (CommunicationMessages msgCommunication : communicationMessagesSentList) {
					
		%>
		<tr>
			<!-- <td width="5%">1</td> -->
			<td width="5%">
			<%
				out.print(counter++);
			%>
			</td>


			<%-- <td width="5%"><label class="value"><%=userName %></label></td>--%>
			<td width="5%">
			<%
				if (masEmployeeList.size() > 0) {
							for (MasEmployee masEmployeePrint : masEmployeeList) {
								if (msgCommunication.getToEmployee().getId()
										.equals(masEmployeePrint.getId())) {
			%> <label class="value"><%=masEmployeePrint.getFirstName() + " "
										+ masEmployeePrint.getLastName()%></label>
			<%
				}
							}
						}
			%>
			</td>
				
			<td width="20%">
			 
				<textarea name="MessageText" id="MessageText"
	cols="20" rows="3" class="large"   tabindex="19" readonly="readonly">
	<%=msgCommunication.getMessageText()%>
	</textarea>
				
				
			</td>
			
			
			<td ><label class="value"><%=currentDate%> </label></td> 
			<td width="5%"><label class="value"><%=msgCommunication.getLastChgTime()%></td>
			<%
				}
			%>
			

		</tr>
		<%
			}

		%>
	</tbody>
</table>
</div>
<div class="clear"></div>
<!--Bottom labels starts-->

<div class="bottom"><input type="hidden" name="lastChgBy"
	value="<%=userName%>" /> <input type="hidden" name="lastChgDate"
	value="<%=currentDate%>" /> <input type="hidden" name="lastChgTime"
	value="<%=currentTime%>" /> <label>Changed By</label> <label
	class="value"><%=userName%></label> <label>Changed Date</label> <label
	class="value"><%=currentDate%></label> <label>Changed Time</label> <label
	class="value"><%=currentTime%></label></div>
</form>