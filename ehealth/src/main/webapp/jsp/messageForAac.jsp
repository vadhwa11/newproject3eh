<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<c:choose>
<c:when test="${map['success']==true}">
<h4><span>Data Submitted Successfully !</span></h4>
</c:when>
<c:otherwise>
<h4><span>Error While Submitting Data !</span></h4>
</c:otherwise>
</c:choose>
<input type="button" class="button" value="Back" onclick="getBackPage();"  />
</body>
</html>
<script>
function getBackPage(){
	
	window.location="/hms/hms/ot?method=showPACClearanceList&screenFrom=opClinic";
	
	
}
</script>