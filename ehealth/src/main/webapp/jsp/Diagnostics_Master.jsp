<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>template one</title> 
<link href="css/phaseII.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--main content placeholder starts here-->
<div id="contentHolder">
<h6>Charge Code Master</h6>
<div class="Clear"></div>
<div class="header"><label>Chargecode Code </label> <input name=""
	type="radio" value="" class="radio"><label class="NoWidth">Chargecode
Code Name</label> <input name="" type="radio" class="radio" value=""><input
	name="" type="text"><input name="refresh" type="button"
	value="Search" class="cmnButton"><input name="refresh"
	type="button" value="Generate Report" class="cmnButton"></div>
<!--Block One Starts--> <!--Block one Ends-->
<div class="division"></div>


<!--Block Three Starts-->
<div class="colsHolder">

<div class="floatLeft">
<div class="navButtHeader">OPD</div>
<input name="patient fast history" type="button" class="navButtons"
	value="Appointments"><input name="patient fast history3"
	type="button" class="navButtons" value="Investigation Appt."><input
	name="patient fast history23" type="button" class="navButtons"
	value="Patient Allergic Drugs"><input
	name="patient fast history22" type="button" class="navButtons"
	value="Admitted Patient"><input name="patient fast history222"
	type="button" class="navButtons" value="Print Prescription"><input
	name="patient fast history22" type="button" class="navButtons"
	value="Print Investigation"></div>
<div class="tableHholderCmn">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Token No.</th>
		<th scope="col">Visit No.</th>
		<th scope="col">Visit Date</th>
		<th scope="col">Visit Time</th>
		<th scope="col">Service No.</th>
		<th scope="col">Visit Type</th>
		<th scope="col">Service Type</th>
		<th scope="col">Patiet Name</th>
		<th scope="col">Age</th>
		<th scope="col">Sex</th>
		<th scope="col">Diagnosis</th>
	</tr>
	<tr>
		<td>5</td>
		<td>0000234</td>
		<td>01-05-08</td>
		<td>10:30</td>
		<td>235678</td>
		<td>Appoint</td>
		<td>Airforce</td>
		<td>Ram Das</td>
		<td>36</td>
		<td>Male</td>
		<td>Fever</td>
	</tr>
	<tr>
		<td>6</td>
		<td>0000235</td>
		<td>03-05-08</td>
		<td>11:30</td>
		<td>235587</td>
		<td>Direct</td>
		<td>Airforce</td>
		<td>Vishal</td>
		<td>45</td>
		<td>Male</td>
		<td>Malaria</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</div>
<div class="floatRight"><input name="Back" type="button"
	class="cmnButton" value="Back"></div>
</div>



<!--Bottom labels starts-->
<div class="bottom"><label>Total Consulted doctors </label> <label
	class="value">3</label> <label>Total Waiting Patient </label> <label
	class="value">12</label>

<div class="Clear"></div>


</div>
<!--Bottom labels ends--></div>
<!--main content placeholder ends here-->
</body>
</html>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">