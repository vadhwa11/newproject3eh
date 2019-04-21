<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HesEquipmentBreakdownEntry"%>

<%
	Map map = new HashMap(); 
    String entryNo="";
    String actionId="";
    String repairId="";
    String serviceById="";
    String entryNoEmergeny="";
	
		 if(request.getAttribute("map") != null)
		 {
			map = (Map) request.getAttribute("map");
		 }
	
		 	 if (map.get("num")!=null)
			 entryNoEmergeny = (String)map.get("num").toString();
  	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	List<HesEquipmentBreakdownEntry> searchCountryList = new ArrayList<HesEquipmentBreakdownEntry>();
	
	if(map.get("searchCountryList")!=null){
		searchCountryList =(List) map.get("searchCountryList");
	}
	HesEquipmentBreakdownEntry hesEntry=(HesEquipmentBreakdownEntry)searchCountryList.get(0);
		
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String currentTime = (String)utilMap.get("currentTime");
	
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
%>



<%@page import="jkt.hms.util.RequestConstants"%><div class="titleBg">
<h2>Emergency Call Entry for Equipment Breakdown</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="searchByDepartment" method="post" action="">
<label>Department Name:</label>
<input type="text" id="searchField" name="<%= RequestConstants.DEPARTMENT_ID%>"  validate="Department Name,string,no" MAXLENGTH="50" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('searchByDepartment','hes?method=searchEmergencyEquipmentBreakdown','checkSearch')" tabindex=1 />
<%--- Report Button   --%>
<%--- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> --%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
		if(searchCountryList != null)
		{
			if(searchCountryList.size()>0)
		 	{
				String strForCodeDescription = (String)map.get("departmentName");
				
				
				if(strForCodeDescription!= null && strForCodeDescription!= "")
				{
%>
				 	<a href="hes?method=showEmergencyEquipmentBreakdownCallEntry">Show All Records</a> <%
				}
		 	}

	 		
		}
%>

<script type="text/javascript">
 formFields = [
			[0, "<%= COMMON_ID%>", "equipmentBreakdownId"],[1,"<%= CODE %>"],[2,"<%= SEARCH_NAME %>"], [3,"<%= Enter_Date%>"],[4,"<%= Nature_Of_Breakdown%>"],[5,"<%= Date_Of_Breakdown%>"],
			[6,"<%= Time_Of_Breakdown%>"],[7,"<%= Call_Submitted_To%>"],[8,"<%= Call_Submitted_By%>"],[9,"<%= Remarks%>"],[10,"<%= CHANGED_BY%>"],
			[11,"<%= CHANGED_DATE %>"],[12,"<%= CHANGED_TIME %>"],[13,"<%=DEPARTMENT_ID  %>"],[14,"<%=STATUS%>"] ];   
	 statusTd = 14;
</script>
</div>

<form name="equipmentBreakdown" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="HesEquipmentBreakdownEntry"/>
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="Department"/>
<input type="hidden" name="title" value="Department"/>
<input type="hidden" name="<%=JSP_NAME %>" value="hesEquipmentBreakdown"/>

<input type="hidden" name="equipmentBreakdownId" id="equipmentBreakdownId"  value="<%=hesEntry.getId() %>" />
<div class="paddingTop15"></div>
<div class="Block">


<label><span>*</span>Entry No.</label>
<%---<input type="text" id="entryNo" name="entryNo" class="textbox_size20" MAXLENGTH="30"  tabindex=1 readonly="readonly" />--%>
 <input type="text" id="fId" name="<%= CODE%>" value=""  class="textbox_size20" MAXLENGTH="30"  tabindex=1 readonly="readonly">
<label><span>*</span> Equipment Name</label>
<input type="text" id="fname"  name="<%= SEARCH_NAME %>" class="textbox_size20" MAXLENGTH="50"  tabindex=1 readonly="readonly" />
<label><span>*</span> Date</label>
<input type="text" id="fdate"  name="<%= Enter_Date %>" class="textbox_size20" MAXLENGTH="50"  tabindex=1 readonly="readonly" />
<label><span>*</span> Nature Of Breakdown</label>
<input type="text" id="fnbreakdown"  name="<%= Nature_Of_Breakdown %>" class="textbox_size20" MAXLENGTH="50"  tabindex=1 readonly="readonly" />
<label><span>*</span> Date Of Breakdown</label>
<input type="text" id="fdateofbreak"  name="<%= Date_Of_Breakdown %>" class="textbox_size20" MAXLENGTH="50"  tabindex=1 readonly="readonly" />
<label><span>*</span> Time Of Breakdown</label>
<input type="text" id="ftimeofbreak"  name="<%= Time_Of_Breakdown %>" class="textbox_size20" MAXLENGTH="50"  tabindex=1 readonly="readonly" />
<label><span>*</span> Call Submitted To</label>
<input type="text" id="fsubmitTo"  name="<%= Call_Submitted_To %>" class="textbox_size20" MAXLENGTH="50"  tabindex=1 readonly="readonly" />
<label><span>*</span> Call Submitted By</label>
<input type="text" id="fsubmitBy"  name="<%= Call_Submitted_By %>" class="textbox_size20" MAXLENGTH="50"  tabindex=1 readonly="readonly" />
<label><span>*</span> Remarks</label>
<textarea id="fremarks"  name="<%= Remarks %>" class="textbox_size20" MAXLENGTH="50" tabindex=1 readonly="readonly"><%=Remarks %></textarea>

<div class="clear"></div>
<label><span>*</span>Entry No.</label>
<input type="text" id="entryNoEmergeny" name="entryNoEmergeny" value="<%=entryNoEmergeny %>"  class="textbox_size20" MAXLENGTH="30"  tabindex=1 readonly="readonly" />
<label><span>*</span>Action Taken:</label>
<input type="text" id="actionTaken" rows="8" name="actionTaken"  validate="Action Taken,string,yes"> </input>
<label><span>*</span>Nature of Repairs Carried Out:</label>
<input type="text" id="repair" rows="8" name="repair"  validate="Nature of Repairs,string,yes" > </input>
<div class="clear"></div>
<label><span>*</span>Time of Complete Breakdown:</label>
<input type="text" name="<%=DELIVERY_TIME%>" value="<%=currentTime %>"  validate="Call Time,deliveryTime,yes"
	MAXLENGTH="15" /> 
<label><span>*</span>Serviced By:</label>
<select name="servicedBy" id="servicedBy" validate="Serviced By,String,yes">
<option value="0">--Select Serviced By--</option>
<option value="1">Company Service Engineer</option>
<option value="2">Biomedical Engineer</option>
<option value="3">Vbch</option>
</select>
</div>
<div class="clear"> </div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('equipmentBreakdown','hes?method=addEquipmentBreakdownEntry');" accesskey="a" tabindex=1 />  
<!--<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onclick="submitForm('equipmentBreakdown','hes?method=deleteEmergencyEquipmentBreakdown')" accesskey="u" tabindex=1 /> -->
<!--<input type="button" name="Delete" id="deletebutton" value="Completed" class="button" style="display: none" onclick="submitForm('equipmentBreakdown','hes?method=deleteEmergencyEquipmentBreakdown&flag='+this.value)" accesskey="d" tabindex=1 />
-->
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 

</div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Entry No"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>";

data_header[1] = new Array;
data_header[1][0] = "Equipment Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Date"
data_header[2][1] = "hide";
data_header[2][2] = "25%";
data_header[2][3] = "<%= Enter_Date %>";

data_header[3] = new Array;
data_header[3][0] = "Nature Of Breakdown"
data_header[3][1] = "hide";
data_header[3][2] = "50%";
data_header[3][3] = "<%=Nature_Of_Breakdown   %>";

data_header[4] = new Array;
data_header[4][0] = "Date Of Breakdown"
data_header[4][1] = "hide";
data_header[4][2] = "25%";
data_header[4][3] = "<%=Date_Of_Breakdown %>";

data_header[5] = new Array;
data_header[5][0] = "Time Of Breakdown"
data_header[5][1] = "hide";
data_header[5][2] = "25%";
data_header[5][3] = "<%=Time_Of_Breakdown   %>";

data_header[6] = new Array;
data_header[6][0] = "Call Submitted To"
data_header[6][1] = "hide";
data_header[6][2] = "50%";
data_header[6][3] = "<%=Call_Submitted_To %>";

data_header[7] = new Array;
data_header[7][0] = "Call Submitted By"
data_header[7][1] = "hide";
data_header[7][2] = "100%";
data_header[7][3] = "<%=Call_Submitted_By  %>";

data_header[8] = new Array;
data_header[8][0] = "Remarks"
data_header[8][1] = "hide";
data_header[8][2] = "100%";
data_header[8][3] = "<%=Remarks  %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=CHANGED_BY  %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=CHANGED_DATE  %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=CHANGED_TIME %>";

data_header[12] = new Array;
data_header[12][0] = "Department Name"
data_header[12][1] = "data";
data_header[12][2] = 0;
data_header[12][3] = "<%=DEPARTMENT_ID  %>";


data_header[13] = new Array;
data_header[13][0] = "Status"
data_header[13][1] = "data";
data_header[13][2] = "15%";
data_header[13][3] = "<%=STATUS %>";

data_arr = new Array();

<%
		if(searchCountryList != null || ! searchCountryList.equals(""))
		{	
			//Iterator itr=searchCountryList.iterator();
			for(HesEquipmentBreakdownEntry hesEquipmentBreakdownObj: searchCountryList)
			{	
        	int  counter=0;        	
        	//while(itr.hasNext())
        	//{   
        		
             //	Object[] obj=(Object[])itr.next();
        		//HesEquipmentBreakdownEntry  hesEquipmentBreakdownObj = (HesEquipmentBreakdownEntry)obj[0]; 
        	   //HesEquipmentBreakdownEntry  hesEquipmentBreakdownObj = new HesEquipmentBreakdownEntry();
        		
%>
			data_arr[<%= counter%>] = new Array();

			data_arr[<%= counter%>][0] = <%= hesEquipmentBreakdownObj.getId()%> 			
			data_arr[<%= counter%>][1] = "<%= hesEquipmentBreakdownObj.getEntryNo() %>"

				<%
				String equpmentName="";
				if( hesEquipmentBreakdownObj.getEquipmentMaster() != null ){
					equpmentName= hesEquipmentBreakdownObj.getEquipmentMaster().getEquipmentName();
				}
					%>
			data_arr[<%= counter%>][2] = "<%=equpmentName%>"
			data_arr[<%= counter%>][3] = "<%= hesEquipmentBreakdownObj.getDate() %>"
			data_arr[<%= counter%>][4] = "<%= hesEquipmentBreakdownObj.getNatureOfBreakdown() %>"
			data_arr[<%= counter%>][5] = "<%= hesEquipmentBreakdownObj.getDateOfBreakdown() %>"
			data_arr[<%= counter%>][6] = "<%= hesEquipmentBreakdownObj.getTimeOfBreakdown()%>"
            <%
               String employeeTo="";
			   if(hesEquipmentBreakdownObj.getEmployeeTo()!=null){
			   employeeTo = hesEquipmentBreakdownObj.getEmployeeTo().getFirstName()+" "+  hesEquipmentBreakdownObj.getEmployeeTo().getLastName();
			   }
            %>
				
			data_arr[<%= counter%>][7] = "<%=employeeTo %>"
				   <%
					   String employeeFrom = "";
					  	if(hesEquipmentBreakdownObj.getEmployeeFrom()!=null){
						  employeeFrom = hesEquipmentBreakdownObj.getEmployeeFrom().getFirstName()+" "+hesEquipmentBreakdownObj.getEmployeeFrom().getLastName();
					  }
					%>
					
			data_arr[<%= counter%>][8] = "<%=employeeFrom %>"
			data_arr[<%= counter%>][9] = "<%= hesEquipmentBreakdownObj.getRemarks() %>"	
			
             <%
                String lastchangeBy = "";
				if(hesEquipmentBreakdownObj !=null){
				lastchangeBy=hesEquipmentBreakdownObj.getLastChgBy();	
			    }
             %>
             data_arr[<%= counter%>][10] = "<%=lastchangeBy %>"	
                 <%
                   String lastChgDate = "";
                   if(hesEquipmentBreakdownObj.getLastChgDate()!=null){
                	   lastChgDate = HMSUtil.convertDateToStringWithoutTime(hesEquipmentBreakdownObj.getLastChgDate());
                   }
                 %>
			data_arr[<%= counter%>][11] = "<%=lastChgDate  %>"
			data_arr[<%= counter%>][12] = "<%= hesEquipmentBreakdownObj.getLastChgTime() %>"

				<%
				  String departmentName = "";
			      if(hesEquipmentBreakdownObj.getDepartment()!=null){
			    	  departmentName = hesEquipmentBreakdownObj.getDepartment().getDepartmentName();
			      }
				%>
			data_arr[<%= counter%>][13] = "<%=departmentName%>"
<%
				if(hesEquipmentBreakdownObj.getStatus().equals("y"))
				{%>
						data_arr[<%= counter%>][14] = "Active"
				<%}
				else{%>
				        data_arr[<%= counter%>][14] = "InActive"
				<%}
%>
				
		     <%counter++;
        	}
		}
%>

formName = "equipmentBreakdown"
nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
