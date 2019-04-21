<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>

<%
		Map<String, Object> map = new HashMap<String, Object>();

		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}

%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<form name="employeeFields" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<script type="text/javascript">
		function checkAllForButton(){
			var counter = document.getElementById('counter').value;
			if(document.getElementById('chkStatus').checked){
	   			for(var i=1;i<=counter;i++){
	    			document.getElementById('chkButton'+i).checked = true; 
	  			}
	  		}else{
	   			for(var i=1;i<=counter;i++){
	    			document.getElementById('chkButton'+i).checked =false
	  			}
	  		}
		}  
		function uncheckMainCheckBox(){
			document.getElementById('chkStatus').checked = false;
		}
	</script>
	<div class="titleBg"><h2>Report Headings </h2></div>
	<div class="clear"></div>
	<div class="Block">
	
		<div class="tableHholder" 
			style="width:475px; float:none;
					margin-right:50px;
					height:300px;
					overflow:auto;
					padding-left: 90px;">
			<table cellpadding="0" cellspacing="0" style="width:450px;">
				<thead>
					<tr>
						<th width="15">S.No</th>
						<th><input type="checkbox" name="chkStatus" id="chkStatus" class="radioCheck" onclick="checkAllForButton();"/>Select Heading</th>
						<th>Report Headings</th>
					</tr>
				</thead>
				<tbody id="searchresulttable">
					<%int i=1;%>
					<tr class="<% if(i %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Employee Code
				  			<input type="hidden" id="heading<%=i%>" value="Employee Code" name="heading<%=i%>" />
			  			</td>
			  		</tr>
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Title
				  			<input type="hidden" id="heading<%=i%>" value="Title" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				First Name
				  			<input type="hidden" id="heading<%=i%>" value="First Name" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Middle Name
				  			<input type="hidden" id="heading<%=i%>" value="Middle Name" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Last Name
				  			<input type="hidden" id="heading<%=i%>" value="Last Name" name="heading<%=i%>" />
			  			</td>
					</tr>			  		
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Department
				  			<input type="hidden" id="heading<%=i%>" value="Department" name="heading<%=i%>" />
			  			</td>
					</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Location
				  			<input type="hidden" id="heading<%=i%>" value="Location" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Line Manager
				  			<input type="hidden" id="heading<%=i%>" value="Line Manager" name="heading<%=i%>" />
			  			</td>
					</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Line Manager Emp Code
				  			<input type="hidden" id="heading<%=i%>" value="Line Manager Emp Code" name="heading<%=i%>" />
			  			</td>
					</tr>
					
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Designation
				  			<input type="hidden" id="heading<%=i%>" value="Designation" name="heading<%=i%>" />
			  			</td>
					</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Equivalent Designation
				  			<input type="hidden" id="heading<%=i%>" value="Equivalent Designation" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Gender
				  			<input type="hidden" id="heading<%=i%>" value="Gender" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Date of Birth
				  			<input type="hidden" id="heading<%=i%>" value="Date of Birth" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Passport Number
				  			<input type="hidden" id="heading<%=i%>" value="Passport Number" name="heading<%=i%>" />
			  			</td>
					</tr>
					
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Passport Issue Date
				  			<input type="hidden" id="heading<%=i%>" value="Passport Issue Date" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Passport Expiry Date
				  			<input type="hidden" id="heading<%=i%>" value="Passport Expiry Date" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Passport Issue Place
				  			<input type="hidden" id="heading<%=i%>" value="Passport Issue Place" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Visa Detail
				  			<input type="hidden" id="heading<%=i%>" value="Visa Detail" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Pan No.
				  			<input type="hidden" id="heading<%=i%>" value="Pan No." name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Driving Licence No.
				  			<input type="hidden" id="heading<%=i%>" value="Driving Licence No." name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Marital Status
				  			<input type="hidden" id="heading<%=i%>" value="Marital Status" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Marriage Date
				  			<input type="hidden" id="heading<%=i%>" value="Marriage Date" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Bank Name
				  			<input type="hidden" id="heading<%=i%>" value="Bank Name" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Bank A/C Code
				  			<input type="hidden" id="heading<%=i%>" value="Bank A/C Code" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				A/C Number
				  			<input type="hidden" id="heading<%=i%>" value="A/C Number" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				A/C Head
				  			<input type="hidden" id="heading<%=i%>" value="A/C Head" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Permanent Address
				  			<input type="hidden" id="heading<%=i%>" value="Permanent Address" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Residential Address
				  			<input type="hidden" id="heading<%=i%>" value="Residential Address" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Mobile
				  			<input type="hidden" id="heading<%=i%>" value="Mobile" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Office Phone
				  			<input type="hidden" id="heading<%=i%>" value="Office Phone" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Resi. Phone
				  			<input type="hidden" id="heading<%=i%>" value="Resi. Phone" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Email Id
				  			<input type="hidden" id="heading<%=i%>" value="Email Id" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Qualification Obtained
				  			<input type="hidden" id="heading<%=i%>" value="Qualification Obtained" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Education 1
				  			<input type="hidden" id="heading<%=i%>" value="Education 1" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Institute 1
				  			<input type="hidden" id="heading<%=i%>" value="Institute 1" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Education 2
				  			<input type="hidden" id="heading<%=i%>" value="Education 2" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Institute 2
				  			<input type="hidden" id="heading<%=i%>" value="Institute 2" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Education 3
				  			<input type="hidden" id="heading<%=i%>" value="Education 3" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Institute 3
				  			<input type="hidden" id="heading<%=i%>" value="Institute 3" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Previous Employer
				  			<input type="hidden" id="heading<%=i%>" value="Previous Employer" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Previous Designation
				  			<input type="hidden" id="heading<%=i%>" value="Previous Designation" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Handicap Status
				  			<input type="hidden" id="heading<%=i%>" value="Handicap Status" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Basic Salary
				  			<input type="hidden" id="heading<%=i%>" value="Basic Salary" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				HRA
				  			<input type="hidden" id="heading<%=i%>" value="HRA" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Spl.All
				  			<input type="hidden" id="heading<%=i%>" value="Spl.All" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				P. Pay against Benefits in Kind
				  			<input type="hidden" id="heading<%=i%>" value="P. Pay against Benefits in Kind" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				P.A. against HRA
				  			<input type="hidden" id="heading<%=i%>" value="P.A. against HRA" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Total
				  			<input type="hidden" id="heading<%=i%>" value="Total" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Reim. Conv
				  			<input type="hidden" id="heading<%=i%>" value="Reim. Conv" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Reim. Medical
				  			<input type="hidden" id="heading<%=i%>" value="Reim. Medical" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Reim. LTA
				  			<input type="hidden" id="heading<%=i%>" value="Reim. LTA" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Reim. Meal Voucher
				  			<input type="hidden" id="heading<%=i%>" value="Reim. Meal Voucher" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Reim. Total
				  			<input type="hidden" id="heading<%=i%>" value="Reim. Total" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Total per month
				  			<input type="hidden" id="heading<%=i%>" value="Total per month" name="heading<%=i%>" />
			  			</td>
			  		</tr>

					<tr class="<% if((++i) %2 == 0){%>odd<%}else{%>even<%}%>">
						<td><%=i%></td>
			  			<td><input type="checkbox" id="chkButton<%=i%>" value="<%=i%>" name="chkId<%=i%>" onclick="uncheckMainCheckBox()" /></td>
			  			<td>
			  				Total per annum
				  			<input type="hidden" id="heading<%=i%>" value="Total per annum" name="heading<%=i%>" />
			  			</td>
			  		</tr>
			  		
	 	  		</tbody>
			</table>
		</div>
		<input type="hidden" id="counter" name="counter" value="<%=i%>" />
		<div class="clear"></div>
		<br>
		<div class="tableHholder" 
			style="width:475px; float:none;
					margin-right:50px;
					height:300px;
					overflow:auto;
					padding-left: 90px;">
		<input type="button" name="print" id="print" 
			value="Print" class="button" 
			onClick="submitForm('employeeFields','personnel?method=generateReportForEmployeeInformationExcel');" 
			tabindex=1 />
		</div>		
 	</div>
</form>
