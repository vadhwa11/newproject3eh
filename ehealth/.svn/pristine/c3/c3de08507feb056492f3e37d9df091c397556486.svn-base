
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Treatmentopd"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}
	
	List<Treatmentopd> treatmentopdList = new ArrayList<Treatmentopd>();
	int totalPatient=0;
	if(map.get("treatmentopdList") != null)
	{
		treatmentopdList=(List<Treatmentopd>)map.get("treatmentopdList");
	}




	%>
<%if(treatmentopdList.size()>0){ %>
<div id="gridview" >
<div class="tableForTab">
<table border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<th scope="col">SR No</th>
		<th scope="col">OPD Number</th>
		<th scope="col">Visit Date</th>
		<th scope="col">Item Name</th>
		<th scope="col">Dose-Frequency</th>
		<th scope="col">Days</th>
		<th scope="col">Qty</th>

		
	</tr>
<% 
	int  i=1;
	try{


	Iterator iterator=treatmentopdList.iterator();

	while(iterator.hasNext())
	{
	Treatmentopd treatmentopd= (Treatmentopd) iterator.next();%>

	<tr>
		<td><%=i%></td>
		<td><%=treatmentopd.getOPDNo()%></td>
		<td><%=HMSUtil.changeDateToddMMyyyy(treatmentopd.getTDate())%></td>
		<td><%=treatmentopd.getDrugDescription()%></td>
		<td><%=treatmentopd.getDose()%></td>
		<td><%=treatmentopd.getDays()%></td>
		<td><%=treatmentopd.getQty()%></td>
		
		
	</tr>
	<%   	i++;
		}

   	
	}catch(Exception e){
	e.printStackTrace();

	}
	%>

	
</table>
</div>
</div>

<div class="clear"></div>
<input type="button" class="button" value="Close" onClick="cancelForm();" />
<input type="hidden" name="counter" id="counter" value="<%=i %>" /> 
<%}else{ %>
<form>
<label> No records ! </label>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<%} %>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<script type="text/javascript">
	<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
	//-->

</script>

</script> <script type="text/javascript">
	function cancelForm(){
  	 close();
   	}


</script>