<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.DgUom"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	List<DgMasInvestigation> dgMasList = new ArrayList<DgMasInvestigation>();
	if(map.get("dgMasInvestigation") != null)
	{
		dgMasList = (List<DgMasInvestigation>)map.get("dgMasInvestigation");
	}

	String message="";
	if(map.get("messageTOBeVisibleToTheUser")!=null)
	{
		message=(String)map.get("messageTOBeVisibleToTheUser");
	}
	//added by govind 16-08-2017 
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("labParameter.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	//String parName = properties.getProperty("parameterEM360");
	String machName = properties.getProperty("LabMachineName");
	String par[]=machName.split(",");
	List<String> machineList=new ArrayList<String>();
	for(int i=0;i<par.length;i++){
		machineList.add(par[i]);
	}
	Collections.sort(machineList);
	//added by govind 16-08-2017 end
%>
	<script type="text/javascript">
 function checkSelectValue()
 {
		if(document.getElementById("machineName").value=="")
         {
             alert("Please Select Machine Name.");
             return false;
         }
		if(document.getElementById("parameterName0").value=="")
        {
            alert("Please Select Analyzer Parameter Name .");
            return false;
        }
		 if(document.getElementById("investigationType0").value=="")
         {
            alert("Please Select Investigation Name.");
            return false;
         }

	    /* for(var i=0;i<4;i++)
         {
           if(document.getElementById("investigationType"+i).value=="")
           {
              alert("Please Select Investigation Name...");
              return false;
              break;
           }
         }*/
       return true;
	}

	</script>
<div class="titleBg">
<h2>Master For Analyzer</h2>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<h2><font id="error" style="padding:0;"><%=message %></font></h2>
<div class="clear"></div>

<form name="machineParameter" method="post" action="">
<div class="Block">

<label> Machine Name </label>
<select id="machineName" name="<%=MACHINE_NAME%>"  validate="machineName,string,no"  onchange="dispayParamList(this.value);"  tabindex=1>
			<option value="">Select</option>
	     <%if(machineList.size()>0){
	     for(String machineName:machineList){ %>
	      <option value=<%=machineName %>><%=machineName %></option>
	      <%}}%>
<!-- 			<option value="EM360" >EM360</option> -->
		 	<!-- <option value="KX-21" >KX-21</option>
			<option value="xpandPlus" >XpandPlus</option>
			<option value="XL300">XL300</option>
			<option value="xpandPlus,XL300">xpandPlus,XL300</option> -->
			</select></div>
<div class="clear"></div>
<!-- <div id="testDiv"></div> -->
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%--
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="if(checkSelectValue()){ submitForm('machineParameter','lab?method=addTestParameter') }" accesskey="u" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" accesskey="r" onclick="resetCheck();" tabindex=1 /> --%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script>
function dispayParamList(mname){
	//alert("mname--->"+mname)
	
submitProtoAjaxWithDivName('machineParameter','/hms/hms/lab?method=showinvestigationForLabIntegeration','testDiv');
}
</script>




<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
  <div id="testDiv"></div>
