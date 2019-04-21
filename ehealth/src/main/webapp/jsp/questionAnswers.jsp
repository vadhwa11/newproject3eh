
<%@page import="jkt.hms.masters.business.MasQuestionAnswers"%>
<%@page import="jkt.hms.masters.business.MasAnswers"%>
<%@page import="jkt.hms.masters.business.MasQuestions"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasQuestions> questionsList = new ArrayList<MasQuestions>();
	List<MasAnswers> answersList = new ArrayList<MasAnswers>();
	List<MasQuestionAnswers> questionAnswersList = new ArrayList<MasQuestionAnswers>();
	
	if(map.get("questionsList")!=null){
		questionsList = (List<MasQuestions>)map.get("questionsList");
	}
	if(map.get("answersList")!=null){
		answersList = (List<MasAnswers>)map.get("answersList");
	}
	if(map.get("questionAnswersList")!=null){
		questionAnswersList = (List<MasQuestionAnswers>)map.get("questionAnswersList");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int userId =0;
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
	%>
	
<h4><%=message %></h4>
		<%  }
 %>
 

<div class="titleBg">
<h2>Questions Answers</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<label>Questions </label> 
<select name="questionId" id="questionId" validate="Question,string,no">
<option value="0">Select</option>
<%
	if(questionsList.size()>0){
		for(MasQuestions masQuestions : questionsList){
	%>
	<option value="<%=masQuestions.getId() %>"><%=masQuestions.getQuestion() %></option>
		<%}
	}
%>
</select>
 
<label>Answers </label> 
<select name="answersId" id="answersId" validate="Answers,string,no">
<option value="0">Select</option>
<%
	if(answersList.size()>0){
		for(MasAnswers answers : answersList){
	%>
	<option value="<%=answers.getId() %>"><%=answers.getAnswersName() %></option>
		<%}
	}
%>
</select>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchQuestionAnswers')" tabindex=1 /> 
<input type="reset" name ="add" id="reset" value ="Generate Report" class="buttonBig" onclick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="r"  tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_question_answers" />

</form>
</div>
</div>

<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<% 
	if(map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showQuestionAnswersJsp">Show All Records</a></h4> <%
    }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"questionId"], [2,"answersId"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script>
</div>
	<div class="clear paddingTop15"></div>
<form name="questionAnswers" method="post" action="">
<div class="Block">
<label>Questions <span>*</span> </label> 
<select name="questionId" validate="Questions,string,yes">
<option value="0">Select</option>
<%
	if(questionsList.size()>0){
		for(MasQuestions masQuestions : questionsList){
	%>
	<option value="<%=masQuestions.getId() %>"><%=masQuestions.getQuestion() %></option>
		<%}
	}
%>
</select>
 
<label>Answers <span>*</span> </label> 
<select name="answersId" validate="Answers ,string,yes">
<option value="0">Select</option>
<%
	if(answersList.size()>0){
		for(MasAnswers masAnswers : answersList){
	%>
	<option value="<%=masAnswers.getId() %>"><%=masAnswers.getAnswersName() %></option>
		<%}
	}
%>
</select>
 <script>
				document.questionAnswers.questionId.focus();
			</script> <br />

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button"	onClick="submitForm('questionAnswers','generalMaster?method=addQuestionAnswers');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none"	onClick="submitForm('questionAnswers','generalMaster?method=updateQuestionAnswers')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none"	onClick="submitForm('questionAnswers','generalMaster?method=deleteQuestionAnswers&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="submitFormForButton('search','generalMaster?method=showQuestionAnswersJsp')" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName %></label>

<label>Changed Date:</label>
<label class="value"><%=date %></label>

<label>Changed Time:</label>
<label class="value"><%=time %></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div id="edited"></div>
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Questions"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "questionId"

data_header[1] = new Array;
data_header[1][0] = "Answers"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "answersId";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "0";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";
data_arr = new Array();

<%
          int  counter=0;
         for(MasQuestionAnswers questionAnswers :questionAnswersList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= questionAnswers.getId()%>"
	<%
	for(MasQuestions q : questionsList){
		 if(questionAnswers.getQuestion().getId().equals(q.getId()) && q.getStatus().equals("Y")){ 
			 %>
			data_arr[<%= counter%>][1] = "<%=q.getQuestion()%>"
		<%}else if(questionAnswers.getQuestion().getId().equals(q.getId()) && q.getStatus().equals("N")){%>
			data_arr[<%= counter%>][1] = "<span>*</span>Parent InActivated--<%=q.getQuestion()%>";
			
		<%}
}%>
<%
for(MasAnswers a: answersList){
	 if(questionAnswers.getAnswers().getId().equals(a.getId()) && a.getStatus().equals("Y")){%>
		data_arr[<%= counter%>][2] = "<%=a.getAnswersName()%>"
	<%}else if(questionAnswers.getAnswers().getId().equals(a.getId()) && a.getStatus().equals("N")){%>
		data_arr[<%= counter%>][2] = "<span>*</span>Parent InActivated--<%=a.getAnswersName()%>";
		
	<%}
}%>
data_arr[<%= counter%>][3] = "<%= questionAnswers.getLastChgBy()!=null?(questionAnswers.getLastChgBy().getId()!=null?questionAnswers.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(questionAnswers.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= questionAnswers.getLastChgTime() %>"

<% if(questionAnswers.getStatus().equals("Y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "questionAnswers"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
