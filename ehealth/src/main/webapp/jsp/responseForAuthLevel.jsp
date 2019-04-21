
<%@page import="jkt.hms.masters.business.HrInstituteAuthLevelDetails"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.io.IOException"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.HashMap"%>


<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_DATE "%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_NO "%>
<%@ page import="static jkt.hms.util.RequestConstants.BANK_NAME "%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	int val=0;
	if(map.get("val")!=null){
		val=(Integer)map.get("val");
	}
	List<MasEmployee>masEmployeeList=new ArrayList<MasEmployee>();
	if(map.get("masEmployeeList")!=null){
		masEmployeeList=(List<MasEmployee>)map.get("masEmployeeList");
	}
	List<HrInstituteAuthLevelDetails>hrInstituteAuthLevelDetailsList=new ArrayList<HrInstituteAuthLevelDetails>();
	if(map.get("hrInstituteAuthLevelDetailsList")!=null){
		hrInstituteAuthLevelDetailsList=(List<HrInstituteAuthLevelDetails>)map.get("hrInstituteAuthLevelDetailsList");
	}
	int headerId=0;
	for(HrInstituteAuthLevelDetails hiald:hrInstituteAuthLevelDetailsList){
		headerId=hiald.getHrInstituteAuthLevel().getId();
	}
		System.out.println(masEmployeeList.size()+"<<=====================>>"+val);
				%>
				<input type="hidden" readonly="readonly" value="<%=val %>" name="val" />
				<div class="clear"></div>
<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Auth Level </th>
		<th scope="col">DesigNation</th>
		<th scope="col">Employee Name</th>
		<th scope="col">&nbsp;</th>
	</tr>
	<%System.out.println("hrInstituteAuthLevelDetailsList  size  ----->>"+hrInstituteAuthLevelDetailsList.size());
	int j=1;
	if(hrInstituteAuthLevelDetailsList.size()>0){
for(HrInstituteAuthLevelDetails hiald:hrInstituteAuthLevelDetailsList){
	System.out.println("in loop");
		int vrHdId = 0;

				
	%>
		<tr>
			<td>
			<input type="text"  name="slNo" id="slNoId<%=j %>"  value="<%=hiald.getSlNo() %>" />
			</td>
			
			<td><input type="text"  id="DesigNation<%=j  %>"  name="DesigNation" value="<%=hiald.getDesignation()%> "/>
			</td>


			 <td>
			
			<select name="name" id="name<%=j %>" >
			<option value="0">Select</option>
			<%for(MasEmployee me:masEmployeeList){
				if(me.getId()==hiald.getEmployee().getId()){
				%>
			<option value="<%=hiald.getEmployee().getId()%>" selected="selected"><%=hiald.getEmployee().getFirstName()%></option>
			<%}else{%>
			<option value="<%=me.getId()%>" ><%=me.getFirstName()%></option>
			<%}} %>
			</select>
			</td>
			<td><input type="button" value="update" onclick="updateData(<%=hiald.getSlNo() %>,<%=hiald.getId()%>);" /></td>
		</tr>
		<%	j++;}for(int k=j;k<=4;k++){%>
		
		<tr>
			<td>
			<input type="text"  name="slNo" id="slNoId<%=k%>" value="<%=k%>"/>
			</td>
			
			<td><input type="text"  id="DesigNation<%=k  %>" name="DesigNation" value=""/>
			</td>


			 <td>
			
			<select name="name" id="name<%=k %>" >
			<option value="0">Select</option>
			<%for(MasEmployee me:masEmployeeList){
				//if(d.getVoucherHeader().getChequeNo()!=null){
				%>
			<option value="<%=me.getId()%>"><%=me.getFirstName()%></option>
			<%}
				//} %>
			</select>
			
			</td>
						<td><input type="button" value="Insert" onclick="saveData(<%=k %>,<%=headerId %>);" /></td>
			
		</tr>
		
		<%}	}else{
	%>
<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">DesigNation</th>
		<th scope="col">Employee Name</th>
		
	</tr>
	<%
for(int i=1;i<=val;i++){
		int vrHdId = 0;

				//for(FaVoucherDetails voucherDetails : voucherDtList){
				//	if(voucherDetails.getVoucherHeader().getChequeNo()!=null){
				//	vrHdId = voucherDetails.getVoucherHeader().getId();
	%>
		<tr>
			<td>
			<input type="text"  name="slNo" id="slNoId<%=i %>" value="<%=i%>"/>
			</td>
			
			<td><input type="text"  id="DesigNation<%=i  %>" name="DesigNation" value=""/>
			</td>


			 <td>
			
			<select name="name" id="name<%=i %>" >
			<option value="0">Select</option>
			<%for(MasEmployee me:masEmployeeList){
				//if(d.getVoucherHeader().getChequeNo()!=null){
				%>
			<option value="<%=me.getId()%>"><%=me.getFirstName()%></option>
			<%}
				//} %>
			</select>
			
			</td>
		</tr>
		<%	}	//i++;
		//}//}
	%>

</table>

<%} %>
</table>
<div class="clear"></div>	
<%if(hrInstituteAuthLevelDetailsList.size()>0){ %>			
<%}else{ %>		
<input type="button" value="save" onclick="submitForm('showUserAssinedTemplet','user?method=saveAuthLevelDetails');" />
<%} %>	
				
				<div id="valueDiv" >
 <%-- <table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">DesigNation</th>
		<th scope="col">Employee Name</th>
	</tr>
	<%
for(int i=1;i<=val;i++){
		int vrHdId = 0;

				//for(FaVoucherDetails voucherDetails : voucherDtList){
				//	if(voucherDetails.getVoucherHeader().getChequeNo()!=null){
				//	vrHdId = voucherDetails.getVoucherHeader().getId();
	%>
		<tr>
			<td>
			<input type="text"  name="slNo" id="slNoId<%=i %>" value="<%=i%>"/>
			</td>
			
			<td><input type="text"  id="DesigNation<%=i  %>" name="DesigNation" value=""/>
			</td>


			 <td>
			
			<select name="name" id="name<%=i %>" >
			<option value="0">Select</option>
			<%for(MasEmployee me:masEmployeeList){
				//if(d.getVoucherHeader().getChequeNo()!=null){
				%>
			<option value="<%=me.getId()%>"><%=me.getFirstName()%></option>
			<%}
				//} %>
			</select>
			
			</td>
		</tr>
		<%	}	//i++;
		//}//}
	%>

</table> --%></div>
