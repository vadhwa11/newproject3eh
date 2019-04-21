<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
		String hinNo="";
		String filename="";
	try {
		System.out.println("including testImageUpload page");
		if(request.getParameter("hinNo2")!=null){
			hinNo=request.getParameter("hinNo2");
			System.out.println("including te  "+hinNo);
		}
		String userHome = getServletContext().getRealPath("");
 		String fileSeparator = System.getProperty("file.separator");
 		String uploadURL = userHome+fileSeparator+"uploadedImage"+fileSeparator;
        String filePath = uploadURL+fileSeparator+fileSeparator+hinNo+".jpg";
        filename=hinNo+".jpg";
        System.out.println("uploadURL te  "+uploadURL);
        System.out.println("filePath te  "+filePath);
        String path="";
        path=uploadURL+fileSeparator+hinNo;
        File f = new File(path);
		try {
			if (f.exists()) {
				f.delete();
				f.mkdir();
			}else{
				f.mkdir();
			}
			 InputStream inputStream = request.getInputStream();
				OutputStream out3 = new FileOutputStream(filePath);
				byte[] buf = new byte[1024];
				int len;
				while ((len = inputStream.read(buf)) > 0)
					out3.write(buf, 0, len);
				out3.close();
				inputStream.close(); %>
				 
	<jsp:forward page="/hms/registration?method=addPhotoFile">
	<jsp:param value="<%=hinNo%>" name="hinNo"/>
	<jsp:param value="<%=uploadURL%>" name="uploadURL"/>
	<jsp:param value="<%=filePath%>" name="filePath"/>
	<jsp:param value="<%=filename%>" name="filename"/>
</jsp:forward>	
		<%} catch (Exception e) {
			e.printStackTrace();
		}

	} catch (Exception e) {
	}
%>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
