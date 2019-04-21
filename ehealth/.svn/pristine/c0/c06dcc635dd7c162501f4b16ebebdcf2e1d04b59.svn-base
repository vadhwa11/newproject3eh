<%@page import="jkt.hms.masters.business.UserHospital"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
</head>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	//List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	List<UserHospital> hospitalList = new ArrayList<UserHospital>();
	//	List<MasBranch> branchList = new ArrayList<MasBranch>();
//	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	/* if(map.get("branchList")!= null){
		branchList = (List)map.get("branchList");
	}
	if(map.get("departmentList")!= null){
		departmentList = (List)map.get("departmentList");
	} */
	if(map.get("error") != null){
		String error = (String)map.get("error");
%>
<%=error%>
<%		
	}else if(map.get("hospitalList") != null){
		deptList=(List<MasDepartment>)map.get("deptList");
%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.UserDepartment"%>
<%@page import="jkt.hms.masters.business.MasBranch"%>
<label class="login">Institution <span>*</span></label>
<select id="hospital" name="<%=RequestConstants.HOSPITAL %>" validate="Institution,metachar,no">
	<option value="0">Select</option>
	<%   
	hospitalList = (List<UserHospital>)map.get("hospitalList");
			MasHospital hospitalObj = new MasHospital();
			
   			for(UserHospital uHospital : hospitalList){
   				int cnt=1;
   %>
	<%if(cnt==1 && null !=uHospital.getHospital()){  System.out.print("fdf "+uHospital.getHospital().getId());%>
	<option value="<%=uHospital.getHospital().getId()%>" selected="selected"><%=uHospital.getHospital().getHospitalName()%></option>
	<%}else{ %>
	<option value="<%=uHospital.getHospital().getId()%>"><%=uHospital.getHospital().getHospitalName()%></option>
	<% }%>
	<%	
cnt++;}
%>
</select>
<script>
	
	document.getElementById('hospital').focus();
	</script>


<label class="login">Service Centre <span>*</span></label>
<select id="department" name="<%=RequestConstants.DEPARTMENT_ID %>" validate="Service Centre,metachar,no"  />
	
	<option value="0">Select</option>
	<%    
			deptList = (List<MasDepartment>)map.get("deptList");
			//UserDepartment deptObj = new UserDepartment();
   			for(MasDepartment  deptobj:deptList) {System.out.print("department "+deptobj.getId());
   				//deptObj = (UserDepartment)iterator.next();
   			
 if(deptList.size()==1){  %>
	<option value="<%=deptobj.getId()%>"
		selected="selected"><%=deptobj.getDepartmentName()%></option>
	<%}else{ %>
	<option value="<%=deptobj.getId()%>"><%=deptobj.getDepartmentName()%></option>
	<%	}
	}
	%>
</select>

<%
		}%>
<div class="clear"></div>		
<div id="testDiv" >
</div>
 