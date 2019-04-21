<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ListIterator"%>
<%@page import="jkt.hrms.util.LeaveManagementUtil"%>
<%@page import="java.util.ArrayList"%>

<%
    Map<String,Object> map=(Map)request.getAttribute("map");	
	List<HrNoticeBoardData> hrNoticeBoardList =new ArrayList<HrNoticeBoardData>();
	List<HrNoticeBoardData> noticeBoardForEdit =new ArrayList<HrNoticeBoardData>();	
	HrNoticeBoardData noticeBoard = new HrNoticeBoardData();	   
	int noticeId = 0;	
	String message = "";	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}	
	if(map.get("noticeBoardForEdit")!= null){
		noticeBoardForEdit = (List)map.get("noticeBoardForEdit");		
		if(noticeBoardForEdit.size()>0){
			noticeBoard = noticeBoardForEdit.get(0);
			noticeId = noticeBoard.getId();
		}
	}	
	if(map.get("hrNoticeBoardList")!= null){
		hrNoticeBoardList = (List)map.get("hrNoticeBoardList");
	}
	if(map.get("message")!= null){
		message = (String)map.get("message");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveTypeNew"%>
<%@page import="jkt.hrms.masters.business.HrNoticeBoardData"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.StringReader"%>
<%@page import="java.util.Scanner"%>
<script type="text/javascript">
<%
		Calendar calendar=Calendar.getInstance();	
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}		
%>
serverdate = '<%=date+"/"+month+"/"+year%>'
function selectBeforeOperation(){
  flag = true;
  if(document.<%=NOTICE_BOARD_TABLE%>.checkbox.checked != undefined)	
		{
			if(document.<%=NOTICE_BOARD_TABLE%>.checkbox.checked)
			{
				flag = false;					
			}
		}
  else{
	for(i=0;i<document.<%=NOTICE_BOARD_TABLE%>.checkbox.length;i++){
		if(document.<%=NOTICE_BOARD_TABLE%>.checkbox[i].checked)
		  flag=false;
	}
 }
	if(flag){
		alert("Select a record to perform any operation.")
	    return false;
	}
	return true;
}
function fillBoard(field){
  var orGroupId ="";
  //document.getElementById("message").innerHTML="";
   var x=document.getElementById("ts")
	var noticeType=field.value;	
	
	 //----------------------AJAX PART------------Start------
  
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("ts").innerHTML=""
     document.getElementById("ts").innerHTML='<font id="error">Loading...</font>'
      document.getElementById("ts").innerHTML=""
    }else
      if(xmlHttp.readyState==4){
      	 document.getElementById("ts").innerHTML=""
         document.getElementById("ts").innerHTML = xmlHttp.responseText;
      }
    }
     
    xmlHttp.open("GET","/hms/hms/noticeBoard?method=showNotice&noticeType="+noticeType+"&"+csrfTokenName+"="+csrfTokenValue,true);
   
    xmlHttp.send(null);
//----------------------AJAX PART------------End------
}
</script>
<form name="<%=NOTICE_BOARD%>" method="post" action="">
<div class="titleBg">
<h2>Notice Board</h2>
</div>
<div class="clear"></div>
<div class="Block">
<%
		if(message!= null){
	%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<label>Display</label> 
<Select name="noticeType" id="noticeType" onchange="fillBoard(this);">
<option>Select</option>
<option value="m">Message</option>
<option value="n">Notice</option>
<option value="p">Policies</option>
<option value="e">Events</option>
<option value="h">Visiting</option>
<option value="a">Achievements</option>
<option value="o">On Call List</option>
</Select> 
<label>Entry Date</label> 
<input type="text" id="entryDateId"	name="entryDate" class="readOnly" readonly="readonly" maxlength="10" value="<%=currentDate %>" /> <script type="text/javascript">
<% if(noticeBoardForEdit.size()>0){ %> 
document.<%=NOTICE_BOARD%>.entryDate.value='<%=noticeBoard.getEntryDate()%>';
<% } %> 
</script> 
<!-- <label >Display</label>
<input type="checkbox" name="<%=DISPLAY_CHECK %>" value="y"  class="radioCheck" />
<script type="text/javascript">
<% if(noticeBoardForEdit.size()>0 && (noticeBoard.getDisplayOnIndex().equals("y"))){ %> 
document.<%=NOTICE_BOARD%>.<%=DISPLAY_CHECK%>.checked=true;
<% } %> 
</script>
-->
<div class="clear"></div>
<label><span>*</span> Notice</label>
<div id="ts">
<textarea	style="width: 700px; height: 200px; overflow: hidden" cols=44	" rows="12" id="msgToDisplay" maxlength="" name="msgToDisplay"	onmousedown="textCounter(this,this.form.counter,2000);"	onkeypress="wrapText(this);textCounter(this,this.form.counter,2000);"	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	validate="Notice,string,yes">  </textarea>
</div>
<div class="clear"></div>
<script type="text/javascript">
function textCounter( field, countfield, maxlimit ) {
if ( field.value.length > maxlimit )
  {
    field.value = field.value.substring( 0, maxlimit );
    alert( 'Textarea value can only be 2000 characters in length.' );
    return false;
  }
  else
  {
    countfield.value = maxlimit - field.value.length;
  }
}

// Change howMany to reflect the number of Characters to begin a new line
var count = -1;
function wrapText(field) {

var howMany = 100;
//var textLen=field.value.length%100;

f1 = document.<%=NOTICE_BOARD%>.msgToDisplay;
oldLine = f1.value;
newLine = '\n';
count++;
if (count == howMany) {
f1.value = oldLine+newLine;
count = 0;
}
}
</script> 
<label>characters remaining</label>
<input class="small" type="text" name="counter" maxlength="3" readonly="readonly" value="2000" onblur="textCounter(this.form.counter,this,2000);">
<script	type="text/javascript">
		
 			
		</script>
<div class="clear"></div></div>
<%if(noticeBoardForEdit.size()>0){%> 
<input type="button" name="update"	value="Update" class="button"	onclick="submitForm('<%=NOTICE_BOARD%>','noticeBoard?method=updateNotice&noticeId=<%=noticeBoard.getId() %>');" />
<input type="button" name="delete" value="Delete" class="button"	onclick="submitForm('<%=NOTICE_BOARD%>','noticeBoard?method=deleteNotice&noticeId=<%=noticeBoard.getId() %>');" />
<% }else{ %> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="apply" value="Post" class="button"	onclick="submitForm('<%=NOTICE_BOARD%>','noticeBoard?method=addNotice');" />
<%} %> 
<input type="button" name="reset" value="Reset"	class="buttonHighlight"	onclick="location.href='noticeBoard?method=showNoticeBoard'" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label>
<label>Changed Time</label> <label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
