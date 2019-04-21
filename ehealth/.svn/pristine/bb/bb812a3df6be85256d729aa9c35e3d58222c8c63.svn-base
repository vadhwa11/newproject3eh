<!-- Demonstration -->

<SCRIPT LANGUAGE="JavaScript" >



function addChar(input, character) { 
if(input.value == null || input.value == "0") 
	input.value = character ;
else
	 input.value += character; 
} 

function cos(form) { 
form.display.value = Math.cos(form.display.value);
} 

function sin(form) { 
form.display.value = Math.sin(form.display.value);
} 
function tan(form) { 
form.display.value = Math.tan(form.display.value);
} 

function sqrt(form) { 
form.display.value = Math.sqrt(form.display.value);
} 

function ln(form) { 
form.display.value = Math.log(form.display.value);
} 

function exp(form) { 
form.display.value = Math.exp(form.display.value);
} 

function sqrt(form) {
form.display.value = Math.sqrt(form.display.value);
}

function deleteChar(input) { 
input.value = input.value.substring(0,input.value.length - 1) 
} 

function changeSign(input) {
if(input.value.substring(0, 1) == "-") 
	input.value = input.value.substring(1, input.value.length) 
else 
	input.value = "-" +input.value 
} 

function compute(form) { 
form.display.value = eval(form.display.value)
} 

function square(form) { 
form.display.value = eval(form.display.value) * eval(form.display.value)
} 

function checkNum(str) { 
for (var i = 0; i < str.length; i++) { 
 var ch = str.substring(i, i+1) 
 if (ch < "0" || ch > "9") {
  if (ch != "/" && ch != "*" && ch != "+" && ch != "-" && ch != "." && ch != "(" && ch!= ")") {
	alert("invalid entry!") ;
	return false; 
 } 
 } 
 } 
 return true 
 }


function submitenter(e,str,form)
{
	
	var keycode;
	if (window.event)
		 keycode = window.event.keyCode;
	else if (e) 
		keycode = e.which;
	else return true;
	
	if (keycode == 13)
	   {
	   if (checkNum(str))
		{ compute(form);
		 }
		 return false;
		
	   }
	 
}

</SCRIPT>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<form name="calculator">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="calculator"><input type="text" name="display" value="" size="25" onkeypress="return submitenter(event,this.form.display.value,this.form);"/>
<script type="text/javascript">
document.calculator.display.focus();
</script>
<div class="clear"></div>
<input type="button" class="buttonSpl" value="exp"
	onClick="if (checkNum(this.form.display.value)){ exp(this.form) }" />
<input type="button" class="button" value="7"
	onClick="addChar(this.form.display, '7')" /> <input type="button"
	class="button" value="8" onClick="addChar(this.form.display, '8')" />
<input type="button" class="button" value="9"
	onClick="addChar(this.form.display, '9')" /> <input type="button"
	class="buttonSpl" value="/" onClick="addChar(this.form.display, '/')" />
<div class="clear"></div>
<input type="button" class="buttonSpl" value="ln"
	onClick="if (checkNum(this.form.display.value))
{ ln(this.form) }" />
<input type="button" class="button" value="4"
	onClick="addChar(this.form.display, '4')" /> <input type="button"
	class="button" value="5" onClick="addChar(this.form.display, '5')" />
<input type="button" class="button" value="6"
	onClick="addChar(this.form.display, '6')" /> <input type="button"
	class="buttonSpl" value="*" onClick="addChar(this.form.display, '*')" />
<div class="clear"></div>
<input type="button" class="buttonSpl" value="sqrt  "
	onClick="if (checkNum(this.form.display.value))
{ sqrt(this.form) }" />
<input type="button" class="button" value="1"
	onClick="addChar(this.form.display, '1')" /> <input type="button"
	class="button" value="2" onClick="addChar(this.form.display, '2')" />
<input type="button" class="button" value="3"
	onClick="addChar(this.form.display, '3')" /> <input type="button"
	class="buttonSpl" value="-" onClick="addChar(this.form.display, '-')" />
<div class="clear"></div>
<input type="button" class="buttonSpl" value="sq"
	onClick="if (checkNum(this.form.display.value))
{ square(this.form) }" />
<input type="button" class="button" value="0"
	onClick="addChar(this.form.display, '0')" /> <input type="button"
	class="button" value="." onClick="addChar(this.form.display, '.')" />
<input type="button" class="buttonSpl" value="+/-"
	onClick="changeSign(this.form.display)" /> <input type="button"
	class="buttonSpl" value="+" onClick="addChar(this.form.display, '+')" />
<div class="clear"></div>
<input type="button" class="buttonSpl" value="("
	onClick="addChar(this.form.display, '(')" /> <input type="button"
	class="buttonSpl" value="cos"
	onClick="if (checkNum(this.form.display.value))
{ cos(this.form) }" />
<input type="button" class="buttonSpl" value="sin"
	onClick="if (checkNum(this.form.display.value))
{ sin(this.form) }" />
<input type="button" class="buttonSpl" value="tan"
	onClick="if (checkNum(this.form.display.value))
{ tan(this.form) }" />
<input type="button" class="buttonSpl" value=")"
	onClick="addChar(this.form.display, ')')" />
<div class="clear"></div>
<input type="button" class="buttonSpl" value="Clear"
	onClick="this.form.display.value = 0 " /> <input type="button"
	class="buttonSpl2" value="Back Space"
	onClick="deleteChar(this.form.display)" /> <input type="button"
	class="buttonSpl" value="Enter" name="enter"
	onClick="if (checkNum(this.form.display.value))
{ compute(this.form) }" />
</div>
</FORM>