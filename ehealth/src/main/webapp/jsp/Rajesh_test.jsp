<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<form name="test1" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="submit"
	value="submit"
	onclick="test('/hms/hms/sysParam?method=showDefaultSysParamJsp');"><script
	type="text/javascript">
function test(url){
alert("SDFSDF")
document.test1.action = url;
document.test1.submit();

}

</script></form>

</body>
</html>