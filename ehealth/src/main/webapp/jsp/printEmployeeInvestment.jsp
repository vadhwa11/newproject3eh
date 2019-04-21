<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import = "static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>



<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link  rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<div class="Block">
<form name="EmployeeInvestment" method="post" action="">

<%Map<String,Object> map =new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map) request.getAttribute("map");
}
List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
List<HrMasFinancialYear> hrMasFinancialYearList = new ArrayList<HrMasFinancialYear>();

if(map.get("employeeList")!=null){
	employeeList=(List<MasEmployee>)map.get("employeeList");
}

if(map.get("hrMasFinancialYearList")!=null){
	hrMasFinancialYearList=(List<HrMasFinancialYear>)map.get("hrMasFinancialYearList");
}

%><div class="titleBg">
<h2>Employee Investment Proof Report</h2></div>
        
         <div class="clear"></div>
    	 <label>Employee</label>
    	<select name="empcode" id="empcode">
    	<option value="0">All</option>
    	<%
			for(MasEmployee masEmployee:employeeList)
			{				
				String fname=masEmployee.getFirstName();
				String lname= masEmployee.getLastName();
				String mname= masEmployee.getMiddleName();
				if(fname==null)
				{
					fname="";
				}
				if(lname==null)
				{
					lname="";
				}
				if(mname==null)
				{
					mname="";
				}
		%>
		<option value="<%= masEmployee.getId() %>"><%=fname%> <%=mname %> <%=lname %>---<%=masEmployee.getEmployeeCode()%></option>
		
		<%} %>
    	</select>
    	
    	
    	<label>Financial Year</label>
    	<select name="invYear" id="invYear" validate="Financial Year,integer,no">
    	<option value="">Select</option>
    	<%
			for(HrMasFinancialYear hrMasFinancialYear:hrMasFinancialYearList) 
			{				
		%>
		<option value="<%= hrMasFinancialYear.getId() %>"><%=hrMasFinancialYear.getFinancialYear() %></option>
		
		<%} %>
    	</select>
    	<div class="clear"></div>
    	<div class="clear"></div>
    	<input type="button" class="button" value="View" name="print" onclick="submitForm('EmployeeInvestment','/hms/hrms/report?method=printEmployeeInvestmentProof');"/>
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>