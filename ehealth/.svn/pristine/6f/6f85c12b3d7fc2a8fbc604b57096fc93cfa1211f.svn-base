<%@page import="java.net.URLEncoder"%>
<%@page import="java.security.SecureRandom"%>

<%-- <meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" /> --%>

<frameset>
<%
if (response.containsHeader("SET-COOKIE")) {  
    String path = request.getContextPath();  
    String sessionid = request.getSession().getId();
    String se="";
    if(request.isSecure()){
    	se= "; Secure"; 
    }
    response.setHeader("SET-COOKIE", "JSESSIONID=" + sessionid  + "; Path=/ "+se+"; HttpOnly");  
}  

 /* SecureRandom random = new SecureRandom();
byte bytes[] = new byte[100]; // 128 bits are converted to 16 bytes;
random.nextBytes(bytes);
String csrf=""+random.nextInt();
session.setAttribute("csrfURL", csrf);  */
String url = "";
/* String test="";
try{
	test=URLEncoder.encode(csrf, "UTF-8");
}catch(Exception e){e.printStackTrace();} */

// url = request.getContextPath()+"/jsp/login.jsp?secure="+csrf;
url = request.getContextPath()+"/jsp/framesetpopup.jsp";
//url = "/hms/hms/login?method=showLoginJsp&secure="+csrf;
//System.out.println(test+"====="+url);

%>
  <frame src="<%=url %>" />
</frameset> 
 
<%--  <%

if (response.containsHeader("SET-COOKIE")) {  
    String path = request.getContextPath();  
    String sessionid = request.getSession().getId();
    String se="";
    if(request.isSecure()){
    	se= "; Secure"; 
    }
    response.setHeader("SET-COOKIE", "JSESSIONID=" + sessionid  + "; Path=/ "+se+"; HttpOnly");  
}  
SecureRandom random = new SecureRandom();
byte bytes[] = new byte[20]; // 128 bits are converted to 16 bytes;
random.nextBytes(bytes);
String csrf=""+random.nextInt();
session.setAttribute("csrfURL", csrf);
String url = "";

url = request.getContextPath()+"/jsp/login.jsp?seq="+csrf;

%>
 
 <% response.sendRedirect(url);%> --%>
 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
