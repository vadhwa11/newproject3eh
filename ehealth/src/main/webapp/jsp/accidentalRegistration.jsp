<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
</head>

<body>
<form name="opdMain" action="" method="post"><input type="hidden" name="userName" value="admin"> 
<div class="titleBg">
<h2>ACCIDENT REGISTER</h2>
</div>
<div class="clear"></div>
<div class="Block">

<label>Serial No</label><input type="text" name="hinNo" value=""> 
<label class="small-medium">Date</label>
<input type="text" id="reviewDate" name="reviewDate" class="dateTextSmall" value="" readonly="readonly">
<img src="/hms/jsp/images/cal.gif" style="margin:5px 2px 0px 0px"	width="16" height="16" border="0" validate="Pick a date"/>
<label class="small-medium">Time</label><input type="text" class="dateTextSmall" value="">

<div class="clear"></div>
<label>Name</label><input type="text" name="hinNo" value="">
<label class="small-medium">Age</label><input type="text" class="dateTextSmall" value="">
<label class="small-medium">Gender</label><select class="midium" tabindex="30" name="tempLatePrescription" id="tempLatePrescription">
	<option value="0">Select</option>	
	<option value="1">Male</option>
	<option value="2">female</option>
</select>
	 
<div class="clear"></div>
<label>Address</label>
<textarea name="comorbidity" class="comorBiditylarge" id="comorbidity" cols="0" rows="0" maxlength="300" ></textarea>
<label>Identification Marks (1)</label>
<textarea name="comorbidity" class="comorBiditylarge" id="comorbidity" cols="0" rows="0" maxlength="300" ></textarea>
    
<div class="clear" style="margin:5px 0px"></div>    
<label>Identification Marks (2)</label>
<textarea name="comorbidity" class="comorBiditylarge" id="comorbidity" cols="0" rows="0" maxlength="300" ></textarea>
<label>Brought(Name & address)</label>
<textarea name="comorbidity" class="comorBiditylarge" id="comorbidity" cols="0" rows="0" maxlength="300" ></textarea>
	 
<div class="clear" style="margin:5px 0px"></div>    
<label>Requisition From</label>
<textarea name="comorbidity" class="comorBiditylarge" id="comorbidity" cols="0" rows="0" maxlength="300" ></textarea>
<label>Cause of Injury</label>
<textarea name="comorbidity" class="comorBiditylarge" id="comorbidity" cols="0" rows="0" maxlength="300" ></textarea>
	 
<div class="clear" style="margin:5px 0px"></div>    
<label>Statement</label>
<textarea name="comorbidity" class="comorBiditylarge" id="comorbidity" cols="0" rows="0" maxlength="300" ></textarea>
<label>Details of Injuries</label>
<textarea name="comorbidity" class="comorBiditylarge" id="comorbidity" cols="0" rows="0" maxlength="300" ></textarea>

<div class="clear" style="margin:5px 0px"></div>    
<label>Physical Examination</label>
<textarea name="comorbidity" class="comorBiditylarge" id="comorbidity" cols="0" rows="0" maxlength="300" ></textarea>
<label>Additional Sheets</label>
<textarea name="comorbidity" class="comorBiditylarge" id="comorbidity" cols="0" rows="0" maxlength="300" ></textarea>
    
<div class="clear" style="margin:5px 0px"></div>
<input type="button" class="buttonBig" id="patient_details" name="patient_details" value="button" onclick="patientDetails();">
<input type="reset" tabindex="1" onclick="resetCheck();" accesskey="r" class="buttonHighlight" value="Reset" id="reset" name="Reset">
     
     
     
    
     
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>



</body>
</html>