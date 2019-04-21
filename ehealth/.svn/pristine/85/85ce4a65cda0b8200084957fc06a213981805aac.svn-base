package jkt.hms.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import jkt.hms.masters.business.IpWardConsumptionDetails;
import jkt.hms.masters.business.IpdCareDetails;
import jkt.hms.masters.business.IpdVitalcareDetails;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleHtmlReportConfiguration;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;

@SuppressWarnings("deprecation")
public class HMSUtil extends ServletRequestUtils {
	public static final Logger LOGGER = Logger.getLogger(HMSUtil.class);

	public static Map<String, Object> getKeyValuesFromURL(String urlPath) {
		Map<String, Object> valueMap = new HashMap<String, Object>();
		String[] keyValueArray = urlPath.split("&");
		for (int i = 1; i < keyValueArray.length; i++) {
			int indexOfEqualSign = keyValueArray[i].indexOf("=");
			String keyName = keyValueArray[i].substring(0, indexOfEqualSign);
			String keyValue = keyValueArray[i].substring(indexOfEqualSign + 1,
					keyValueArray[i].length());
			valueMap.put(keyName, keyValue);
		}
		return valueMap;
	}

	public static Map<String, Object> getCurrentTimeHHMM() {

		Map<String, Object> map = new HashMap<String, Object>();
		String currentDate = "";
		String currentTime = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		StringTokenizer s = new StringTokenizer(datetime, " ");
		while (s.hasMoreTokens()) {
			currentDate = s.nextToken();
			currentTime = s.nextToken();
		}

		String currentDateYYYYMMDD="";
		String splitDate[]=currentDate.split("/");
		currentDateYYYYMMDD=splitDate[2]+"-"+splitDate[1]+"-"+splitDate[0];

		map.put("currentDateYYYYMMDD", currentDateYYYYMMDD);
		map.put("currentDate", currentDate);
		map.put("currentTime", currentTime);
		return map;
	}
	
	
	public static Map<String, Object> getCurrentDateAndTime() {

		Map<String, Object> map = new HashMap<String, Object>();
		String currentDate = "";
		String currentTime = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		StringTokenizer s = new StringTokenizer(datetime, " ");
		while (s.hasMoreTokens()) {
			currentDate = s.nextToken();
			currentTime = s.nextToken();
		}

		String currentDateYYYYMMDD="";
		String splitDate[]=currentDate.split("/");
		currentDateYYYYMMDD=splitDate[2]+"-"+splitDate[1]+"-"+splitDate[0];

		map.put("currentDateYYYYMMDD", currentDateYYYYMMDD);
		map.put("currentDate", currentDate);
		map.put("currentTime", currentTime);
		return map;
	}
	
	public static List<Object> uploadFileMaintenance(MultipartFormDataRequest mrequest, String uploadURL,String whiteList,Long fileSizeLimit,String fileNameToBeAssigned)
    {
        
            List fileUploadedList = new ArrayList();
            boolean fileUploaded = false;
            try {
          
            UploadBean upBean = new UploadBean();
          
            upBean.setFolderstore(uploadURL);
            
            upBean.setOverwrite(true);
            upBean.setWhitelist(whiteList);
            upBean.setFilesizelimit(fileSizeLimit);
           
            Hashtable files = mrequest.getFiles();
            
           // UploadFile file = (UploadFile) files.get(RequestConstants.UPLOAD);
             UploadFile file = (UploadFile) files.get("upload_filename");
        
            String fileName = file.getFileName();

             Long fileSize = file.getFileSize();
             //System.out.println(file+"file11>>"+fileName+"   "+fileSize);
            if (fileName != null && fileSize > 0 && fileSize <= RequestConstants.MAX_FILE_SIZE )
            {//System.out.println(file+"file222>>"+fileName+"   "+fileSize);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String date = sdf.format(new Date());
                int length = fileName.length();
                int index = fileName.indexOf(".");
                String ext = fileName.substring(index, length);
               // file.setFileName(fileNameToBeAssigned+"_"+date+ext);
               // file.setFileName(fileNameToBeAssigned+"_"+date);
                System.out.println(upBean.SQLUPLOADID);
                upBean.store(mrequest, "upload_filename");
                fileUploaded = true;
                fileUploadedList.add(fileUploaded);
                if(fileUploaded)
                {
                    fileUploadedList.add(fileName);
                    fileUploadedList.add(file.getFileName());
                }
            
            }
          } catch (UploadException e)
          {
              e.printStackTrace();
          }catch(IOException e)
          {
              e.printStackTrace();
          }
          return fileUploadedList;
    }
	
	public static Map<String, Object> getCurrentDateAndTimeDBFormat()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String currentDate = "";
		String modifiedDate = "";

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		currentDate = dateFormat.format(cal.getTime());

		Calendar cal1 = Calendar.getInstance();
		cal1 = Calendar.getInstance();
		cal1.add(Calendar.MONTH, -12);
		modifiedDate = dateFormat.format(cal1.getTime());
		map.put("currentDate", currentDate);
		map.put("modifiedDate", modifiedDate);
        
		return map;
	}

	// method added By Shailesh For Fecthing the values from the properties file
	// the devloper have to pass properties file name and key
	public static String getValuesFromPropertiesFile(String propertiesFileName,
			String key) {
		Properties properties = new Properties();
		String value = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource(propertiesFileName);
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			value = properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();

		}

		// -value- "+value);
		return value;

	}

	public static String convertDateToStringWithoutTime(Date date) {
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer dateOnly = new StringBuffer();
		dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(dateOfMonth);
		dateOnly.append("/");
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(month);
		dateOnly.append("/");
		year = calendar.get(Calendar.YEAR);
		dateOnly.append(year);
		// .append("
		// ").append(calendar.get(Calendar.HOUR_OF_DAY)).append(":").append(calendar.get(Calendar.MINUTE)).append(":").append(calendar.get(Calendar.SECOND));
		return dateOnly.toString();
	}
	public static String convertDateToStringOnlyTime(Date date) {
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer dateOnly = new StringBuffer();
		dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
/*		if (dateOfMonth < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(dateOfMonth);
		dateOnly.append("/");
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(month);
		dateOnly.append("/");
		year = calendar.get(Calendar.YEAR);
		dateOnly.append(year);
*/		// .append("
		// ").append(calendar.get(Calendar.HOUR_OF_DAY)).append(":").append(calendar.get(Calendar.MINUTE)).append(":").append(calendar.get(Calendar.SECOND));
		dateOnly.append(calendar.get(Calendar.HOUR_OF_DAY)).append(":").append(calendar.get(Calendar.MINUTE)).append(":").append(calendar.get(Calendar.SECOND));
		//
		return dateOnly.toString();
	}
	public static Date dateFormatterDDMMYYYY(String stringDate) {
		SimpleDateFormat dateFormatterDDMMYYYY = new SimpleDateFormat(
				"dd/MM/yyyy");
		try {
			return (dateFormatterDDMMYYYY.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Date dateFormatterToDDMMYYYY(String stringDate) {
		SimpleDateFormat dateFormatterDDMMYYYY = new SimpleDateFormat(
				"dd-MM-yyyy");
		try {
			return (dateFormatterDDMMYYYY.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isNotNull(String value) {
		boolean isNotNull;
		if (null != value && !value.trim().equals(""))
			isNotNull = true;
		else
			isNotNull = false;
		return isNotNull;
	}
	
	public static Date convertStringTypeDateToDateType(String date) {
		Date orderDateTime = null;

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		if (date != null) {
			try {
				orderDateTime = df.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return orderDateTime;
	}
	public static Date convertStringyyyyMMddTypeToDateType(String date) {
		Date orderDateTime = null;

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (date != null) {
			try {
				orderDateTime = df.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return orderDateTime;
	}
	

	@SuppressWarnings("deprecation")
	public static Object getParameterOrAttribute(HttpServletRequest request,
			String name, String type) {
		if (type.equals("String")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				try {
					return getStringParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		if (type.equals("Int")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				try {
					return getIntParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		if (type.equals("Float")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				try {
					return getFloatParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		if (type.equals("Long")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				try {
					return getLongParameter(request, name);
				} catch (ServletRequestBindingException e) {
				}
			}
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public static Object getParameterOrAttribute(HttpServletRequest request,
			String name, String type, String defaultValue) {
		if (type.equals("String")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				return getStringParameter(request, name, defaultValue);
			}
		}
		if (type.equals("Int")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				return getIntParameter(request, name,
						Integer.parseInt(defaultValue));
			}
		}
		if (type.equals("Float")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				return getFloatParameter(request, name,
						Float.parseFloat(defaultValue));
			}
		}
		if (type.equals("Long")) {
			if (request.getParameter(name) == null) {
				return request.getAttribute(name);
			} else {
				return getLongParameter(request, name,
						Long.parseLong(defaultValue));
			}
		}
		return null;
	}

	public static String getDateFormat(Date date, String format) {
		SimpleDateFormat sdf;
		Date time = date;
		sdf = new SimpleDateFormat(format);
		String strDate = sdf.format(time);

		return strDate;
	}
	public static Date addDaysToDate(String date, int daysToAdd) throws Exception {
		Date todayDate = new Date();
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = sdf.format(todayDate);
		Date parsedDate = sdf.parse(date);
		Calendar now = Calendar.getInstance();
		now.setTime(parsedDate);
		now.add(Calendar.DAY_OF_MONTH, daysToAdd);
		return now.getTime();
		}
	
	public static Date addDaysToDate(Date date, int daysToAdd) throws Exception {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.DAY_OF_MONTH, daysToAdd);
		return now.getTime();
		}
	
	public static String changeDateToddMMyyyy(Date dbDate) {
		String strDate = dbDate.toString();
		String strNewDate = "", year = "", dt = "", month = "";
		year = strDate.substring(0, 4);
		month = strDate.substring(5, 7);
		dt = strDate.substring(8, 10);
		strNewDate = (dt + "/" + month + "/" + year);
		return strNewDate;
	}

	/**
	 * This is for calculate age for registation screen..
	 */

	public static String calculateAge(Date birthDate) {
		// get todays date
		Calendar now = Calendar.getInstance();
		// get a calendar representing their birth date

		Calendar cal = Calendar.getInstance();
		cal.setTime(birthDate);

		// calculate age as the difference in years.
		@SuppressWarnings("unused")
		int calculatedDays, calculatedMonth, calculatedYear;
		int currentDays = now.get(Calendar.DATE);
		int birthDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH);
		int birthMonth = cal.get(Calendar.MONTH);
		int currentYear = now.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);

		if (currentDays < birthDays) {
			currentDays = currentDays + 30;
			calculatedDays = currentDays - birthDays;
			currentMonth = currentMonth - 1;
		} else {
			calculatedDays = currentDays - birthDays;
		}

		if (currentMonth < birthMonth) {
			currentMonth = currentMonth + 12;
			calculatedMonth = currentMonth - birthMonth;
			currentYear = currentYear - 1;
		} else {
			calculatedMonth = currentMonth - birthMonth;
		}

		int age = currentYear - birthYear;
		String patientAge = "";

		if (age == 0 && calculatedMonth != 0 && calculatedDays != 0) {
			patientAge = calculatedMonth + " Months ";
		} else if (age == 0 && calculatedMonth == 0 && calculatedDays != 0) {
			patientAge = calculatedDays + "  Days";
		} else if (age == 0 && calculatedMonth == 0 && calculatedDays == 0) {
			patientAge = "1 Days";
		} else {
			patientAge = age + " Years ";
		}
		return patientAge;
	}

	public static int calculateAgeByDOB(Date birthDate) {
		// get todays date
		Calendar now = Calendar.getInstance();
		// get a calendar representing their birth date

		Calendar cal = Calendar.getInstance();
		cal.setTime(birthDate);

		// calculate age as the difference in years.
		@SuppressWarnings("unused")
		int calculatedDays, calculatedMonth, calculatedYear;
		int currentDays = now.get(Calendar.DATE);
		int birthDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH);
		int birthMonth = cal.get(Calendar.MONTH);
		int currentYear = now.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);

		if (currentDays < birthDays) {
			currentDays = currentDays + 30;
			calculatedDays = currentDays - birthDays;
			currentMonth = currentMonth - 1;
		} else {
			calculatedDays = currentDays - birthDays;
		}

		if (currentMonth < birthMonth) {
			currentMonth = currentMonth + 12;
			calculatedMonth = currentMonth - birthMonth;
			currentYear = currentYear - 1;
		} else {
			calculatedMonth = currentMonth - birthMonth;
		}

		int age = currentYear - birthYear;
		int patientAge =0;

		if (age == 0 && calculatedMonth != 0 && calculatedDays != 0) {
			patientAge = calculatedMonth ;
		} else if (age == 0 && calculatedMonth == 0 && calculatedDays != 0) {
			patientAge = calculatedDays ;
		} else if (age == 0 && calculatedMonth == 0 && calculatedDays == 0) {
			patientAge = 1 ;
		} else {
			patientAge = age;
		}
		return patientAge;
	}

	/**
	 * Method Name : generateReport(String jasper_filename, Map parameters,
	 * Connection conn, HttpServletResponse response, ServletContext context)
	 * getCompiledReport(ServletContext context, String jasper_filename)
	 * Description : getCompiledReport() is a public static method used to
	 * compile the Jasper Report generateReport() is public static method used
	 * to call the compiled Jasper Report from Java Application.
	 *
	 * @author Name: Othivadivel K R Create Date: 20.02.2008 Revision Date:
	 *         Revision By:
	 * @version 1.0
	 * @see
	 */

	@SuppressWarnings("unchecked")
	public static void generateReport(String jasper_filename, Map parameters,
			Connection conn, HttpServletResponse response,
			ServletContext context) {
		byte bytes[] = null;
		try {
			
		/*	System.out.println("compiler path is == "+getCompiledReport(context, jasper_filename));
			Set<String> keySet=parameters.keySet();
			for (String key : keySet) {
				System.out.println(key + "/" + parameters.get(key));
			}
			
			System.out.println("connection is == "+conn.toString());
			
			*/
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(context, jasper_filename), parameters,
					conn);
			if(!conn.isClosed())
				conn.close();
		      
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setHeader("Content-Disposition", "attachment; filename="
				+ jasper_filename + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();

			    
	            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void generateReportWithDisplayName(String jasper_filename, String displayName,Map parameters,
			Connection conn, HttpServletResponse response,
			ServletContext context) {
		byte bytes[] = null;
		try {
			
		/*	System.out.println("compiler path is == "+getCompiledReport(context, jasper_filename));
			Set<String> keySet=parameters.keySet();
			for (String key : keySet) {
				System.out.println(key + "/" + parameters.get(key));
			}
			
			System.out.println("connection is == "+conn.toString());
			
			*/
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(context, jasper_filename), parameters,
					conn);
			if(!conn.isClosed())
				conn.close();
		      
		} catch (JRException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setHeader("Content-Disposition", "attachment; filename="
				+ displayName + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();

			    
	            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void generateReportForDirectPrint(String jasper_filename, Map parameters,
			Connection conn, HttpServletResponse response,
			ServletContext context, String path) {
		byte bytes[] = null;
		try {
			
		/*	System.out.println("compiler path is == "+getCompiledReport(context, jasper_filename));
			Set<String> keySet=parameters.keySet();
			for (String key : keySet) {
				System.out.println(key + "/" + parameters.get(key));
			}
			
			System.out.println("connection is == "+conn.toString());
			
			*/
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(context, jasper_filename), parameters,
					conn);
	
			FileUtils.writeByteArrayToFile(new File(path+"/"+jasper_filename+".pdf"), bytes);
		   	if(!conn.isClosed())
				conn.close();   
		} catch (JRException e) {
			e.printStackTrace();
		}catch ( IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static void generateReportToSaveFile(String jasper_filename, Map parameters,
			Connection conn, HttpServletResponse response,
			ServletContext context,Map data) {
		byte bytes[] = null;
		String hin_no ="hin";
		try { 
			if(data.get(RequestConstants.HIN_NO)!=null){
				 hin_no=data.get(RequestConstants.HIN_NO).toString();
			} 
			
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(context, jasper_filename), parameters,
					conn);
			String printFileName = JasperFillManager.fillReportToFile(context.getRealPath("/Reports/" + jasper_filename + ".jasper"),
			            parameters, conn);
			 JasperExportManager.exportReportToHtmlFile(printFileName,
					 context.getRealPath("/uploadedImage/"+hin_no+".html"));
			 if(!conn.isClosed())
					conn.close();
		} catch (JRException e) {
			e.printStackTrace();
		} 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static JasperReport getCompiledReport(ServletContext context,String fileName)
					throws JRException {
		File reportFile = new File(context.getRealPath("/Reports/" + fileName + ".jasper"));
		System.out.println("jasper report file is == "+reportFile);
		JasperReport jasperReport =null;
		try {
			jasperReport = (JasperReport) JRLoader.loadObject(reportFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jasperReport;
	}

	/**
	 * This Method is for calculate patient age
	 */
	public static String calculateAgeForADT(String ageAtRegTimeAct,
			Date dateForCalculation) {
		String ageAtRegTime="0 Years";
		if(ageAtRegTimeAct!=null && !"".equalsIgnoreCase(ageAtRegTimeAct.trim())){
			ageAtRegTime=ageAtRegTimeAct;
		}
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateForCalculation);

		int calculatedDays, calculatedMonth, calculatedYear;

		int currentDays = now.get(Calendar.DATE);
		int regDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH) + 1;
		int regMonth = cal.get(Calendar.MONTH) + 1;
		int currentYear = now.get(Calendar.YEAR);
		int regYear = cal.get(Calendar.YEAR);

		String patientAge = "";

		if (currentDays < regDays) {
			currentDays = currentDays + 30;
			calculatedDays = currentDays - regDays;
			currentMonth = currentMonth - 1;
		} else {
			calculatedDays = currentDays - regDays;
		}

		if (currentMonth < regMonth) {
			currentMonth = currentMonth + 12;
			calculatedMonth = currentMonth - regMonth;
			currentYear = currentYear - 1;
		} else {
			calculatedMonth = currentMonth - regMonth;
		}

		calculatedYear = currentYear - regYear;
		String oldAge;
		if(ageAtRegTime!=null && ageAtRegTime.trim().indexOf(" ")!=-1){
			oldAge = ageAtRegTime.substring(0, (ageAtRegTime.trim()).indexOf(" "));
		}else{
			oldAge=ageAtRegTime;
		}
		// Added by Priyanka for EHA
		StringTokenizer strAge = new StringTokenizer(oldAge, ".");
		if (strAge.countTokens() == 0) {
			oldAge = ageAtRegTime.substring(0,
					(ageAtRegTime.trim()).indexOf(" "));
		} else {
			oldAge = strAge.nextToken();
		}

		// End
		String ageUnit = ageAtRegTime.substring((ageAtRegTime.trim())
				.lastIndexOf(" ") + 1);
		int currentAge = Integer.parseInt(oldAge.trim());
		int newAgeYear = 0;
		if ((ageUnit.trim()).equals("Years")) {
			newAgeYear = currentAge + calculatedYear;
			patientAge = newAgeYear + " Years ";
		} else if ((ageUnit.trim()).equals("Months")) {
			if (calculatedYear > 0) {
				newAgeYear = calculatedYear;
				patientAge = newAgeYear + " Years ";
			} else {
				newAgeYear = currentAge + calculatedMonth;
				patientAge = newAgeYear + " Months ";
			}

		} else if ((ageUnit.trim()).equals("Days")) {
			if (calculatedYear > 0) {
				newAgeYear = calculatedYear;
				patientAge = newAgeYear + " Years ";
			} else if (calculatedMonth > 0) {
				newAgeYear = calculatedMonth;
				patientAge = newAgeYear + " Months ";
			} else {
				newAgeYear = currentAge + calculatedDays;
				patientAge = newAgeYear + " Days ";
			}
		}

		return patientAge;
	}
public static int getCurrentAgeByDoB(Date dateOfBirth) {
	// get todays date
	Calendar now = Calendar.getInstance();
	// get a calendar representing their birth date

	Calendar cal = Calendar.getInstance();
	cal.setTime(dateOfBirth);

	// calculate age as the difference in years.
	@SuppressWarnings("unused")
	int calculatedDays, calculatedMonth, calculatedYear;
	int currentDays = now.get(Calendar.DATE);
	int birthDays = cal.get(Calendar.DATE);
	int currentMonth = now.get(Calendar.MONTH);
	int birthMonth = cal.get(Calendar.MONTH);
	int currentYear = now.get(Calendar.YEAR);
	int birthYear = cal.get(Calendar.YEAR);

	// if(currentDays<birthDays)
	// {
	// currentDays=currentDays+30;
	// calculatedDays=currentDays-birthDays;
	// currentMonth=currentMonth-1;
	// }
	// else{
	// calculatedDays=currentDays-birthDays;
	// }
	//
	// if(currentMonth<birthMonth)
	// {
	// currentMonth=currentMonth+12;
	// calculatedMonth=currentMonth-birthMonth;
	// currentYear=currentYear-1;
	// }
	// else{
	// calculatedMonth=currentMonth-birthMonth;
	// }

	calculatedMonth = currentMonth - birthMonth;
	if (calculatedMonth == 1) {
		calculatedDays = currentDays + (31 - birthDays);
	} else {
		calculatedDays = currentDays - birthDays;
	}

	calculatedYear = currentYear - birthYear;
	int age = calculatedYear;
	String period = "";

	if (calculatedYear == 0 && calculatedMonth != 0
			&& calculatedDays != 0) {
		if (calculatedMonth == 1 && calculatedDays < 30) {
			age = calculatedDays;
			period = "Days";
		} else {
			age = calculatedMonth;
			period = "Months";
		}

	} else if (age == 0 && calculatedMonth == 0 && calculatedDays != 0) {
		age = calculatedDays;
		period = "Days";
	} else if (age == 0 && calculatedMonth == 0 && calculatedDays == 0) {
		age = 0;
		period = "Days";
	} else {

		period = "Years";
	}


	return age;
}
	/**
	 * This Method is for calculate patient age
	 */
	public static String calculateAgeForADT2(String ageAtRegTime,
			Date dateForCalculation) {
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateForCalculation);

		int calculatedDays, calculatedMonth, calculatedYear;

		int currentDays = now.get(Calendar.DATE);
		int regDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH) + 1;
		int regMonth = cal.get(Calendar.MONTH) + 1;
		int currentYear = now.get(Calendar.YEAR);
		int regYear = cal.get(Calendar.YEAR);

		String patientAge = "0";

		if (currentDays < regDays) {
			currentDays = currentDays + 30;
			calculatedDays = currentDays - regDays;
			currentMonth = currentMonth - 1;
		} else {
			calculatedDays = currentDays - regDays;
		}

		if (currentMonth < regMonth) {
			currentMonth = currentMonth + 12;
			calculatedMonth = currentMonth - regMonth;
			currentYear = currentYear - 1;
		} else {
			calculatedMonth = currentMonth - regMonth;
		}

		calculatedYear = currentYear - regYear;

		String oldAge = ageAtRegTime.substring(0,
				(ageAtRegTime.trim()).indexOf(" "));
	
		// Added by Priyanka for EHA
		StringTokenizer strAge = new StringTokenizer(oldAge, ".");
		if (strAge.countTokens() == 0) {
			oldAge = ageAtRegTime.substring(0,
					(ageAtRegTime.trim()).indexOf(" "));
		} else {
			oldAge = strAge.nextToken();
		}
		// End
		String ageUnit = ageAtRegTime.substring((ageAtRegTime.trim())
				.lastIndexOf(" ") + 1);
		int currentAge = Integer.parseInt(oldAge.trim());
		int newAgeYear = 0;
		if ((ageUnit.trim()).equals("Years")) {
			newAgeYear = currentAge + calculatedYear;
			patientAge = newAgeYear + "";
		} else if ((ageUnit.trim()).equals("Months")) {
			if (calculatedYear > 0) {
				newAgeYear = calculatedYear;
				patientAge = newAgeYear + "";
			}

		} else if ((ageUnit.trim()).equals("Days")) {
			if (calculatedYear > 0) {
				newAgeYear = calculatedYear;
				patientAge = newAgeYear + "";
			}
		}
		return patientAge;
	}

	/**
	 * Method Name : getBox(HttpServletRequest request) Description : Make Box
	 * object with request parameter values
	 *
	 * @author Name: Othivadivel K R Create Date: 17.03.2008 Revision Date:
	 *         Revision By:
	 * @param request
	 *            - HttpServletRequest
	 * @return box
	 * @version 1.0
	 * @see
	 */
	public static Box getBox(HttpServletRequest request) {
		Box box = new Box("requestbox");
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			box.put(key, request.getParameterValues(key));
		}

		return box;
	}

	
	public static Box getBox(MultipartFormDataRequest request) {
		Box box = new Box("requestbox");

		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			box.put(key, request.getParameterValues(key));
		}

		return box;
	}
	

	public static String isSelected(Object option_val, Object select_val) {
		if (option_val == null || select_val == null) {
			return "";
		}
		return (option_val).equals(select_val) ? "SELECTED" : "";
	}

	/*
	 * public static List<Object> uploadFile(MultipartFormDataRequest mrequest,
	 * String uploadURL,String whiteList,String fileNameToBeAssigned ) {
	 *
	 * List fileUploadedList = new ArrayList(); boolean fileUploaded = false;
	 * try {
	 *
	 * UploadBean upBean = new UploadBean();
	 *
	 * upBean.setFolderstore(uploadURL); upBean.setOverwrite(true);
	 * upBean.setWhitelist(whiteList); //upBean.setFilesizelimit(fileSizeLimit);
	 * Hashtable files = mrequest.getFiles();
	 *
	 * UploadFile file = (UploadFile)
	 * files.get(RequestConstants.UPLOAD_FILENAME); String fileName =
	 * file.getFileName();
	 *
	 * Long fileSize = file.getFileSize();
	 *
	 * if (fileName != null && fileSize > 0 ) //&& fileSize <= 2097152 ) {
	 * //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	 * //String date = sdf.format(new Date()); int length = fileName.length();
	 * int index = fileName.indexOf("."); String ext = fileName.substring(index,
	 * length); file.setFileName(fileNameToBeAssigned); upBean.store(mrequest,
	 * RequestConstants.UPLOAD_FILENAME); fileUploaded = true;
	 * fileUploadedList.add(fileUploaded); if(fileUploaded) {
	 * fileUploadedList.add(fileName); fileUploadedList.add(file.getFileName());
	 * } } } catch (UploadException e) { e.printStackTrace(); }catch(IOException
	 * e) { e.printStackTrace(); } return fileUploadedList; }
	 */
	
	
	//HRMS util methods
	public static List<Object> uploadFile1(MultipartFormDataRequest mrequest, String uploadURL,String whiteList,Long fileSizeLimit,String fileNameToBeAssigned)
	    {
			
			    List fileUploadedList = new ArrayList();
	            boolean fileUploaded = false;
				try {
	          
				UploadBean upBean = new UploadBean();
	          
	            upBean.setFolderstore(uploadURL);
				
	            upBean.setOverwrite(true);
	            upBean.setWhitelist(whiteList);
	            upBean.setFilesizelimit(fileSizeLimit);
	           
	            Hashtable files = mrequest.getFiles();
	            
	           // UploadFile file = (UploadFile) files.get(RequestConstants.UPLOAD);
	             UploadFile file = (UploadFile) files.get("upload_filename");
	        
	            String fileName = file.getFileName();

				 Long fileSize = file.getFileSize();
			     //System.out.println(file+"file11>>"+fileName+"   "+fileSize);
	            if (fileName != null && fileSize > 0 && fileSize <= RequestConstants.MAX_FILE_SIZE )
	            {//System.out.println(file+"file222>>"+fileName+"   "+fileSize);
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	                String date = sdf.format(new Date());
	                int length = fileName.length();
	                int index = fileName.indexOf(".");
	                String ext = fileName.substring(index, length);
	               // file.setFileName(fileNameToBeAssigned+"_"+date+ext);
	               // file.setFileName(fileNameToBeAssigned+"_"+date);
					System.out.println(upBean.SQLUPLOADID);
	                upBean.store(mrequest, "upload_filename");
	                fileUploaded = true;
	                fileUploadedList.add(fileUploaded);
	                if(fileUploaded)
	                {
	                    fileUploadedList.add(fileName);
	                    fileUploadedList.add(file.getFileName());
	                }
	            
	            }
	          } catch (UploadException e) 
	          {
	              e.printStackTrace();
	          }catch(IOException e)
	          {
	              e.printStackTrace();
	          }
	          return fileUploadedList;
	    }
	
	
	public static List<Object> uploadFile(MultipartFormDataRequest mrequest,
			String uploadURL, String whiteList, String fileNameToBeAssigned) {

		List fileUploadedList = new ArrayList();
		boolean fileUploaded = false;
		try {

			UploadBean upBean = new UploadBean();

			upBean.setFolderstore(uploadURL);
			upBean.setOverwrite(true);
			upBean.setWhitelist(whiteList);

			// upBean.setFilesizelimit(fileSizeLimit);
			Hashtable files = mrequest.getFiles();
			UploadFile file = (UploadFile) files
					.get(RequestConstants.UPLOAD_FILENAME);
			String fileName = file.getFileName();

			Long fileSize = file.getFileSize();

			if (fileName != null && fileSize > 0) // && fileSize <= 2097152 )
			{
				// SimpleDateFormat sdf = new
				// SimpleDateFormat("yyyyMMdd_HHmmss");
				// String date = sdf.format(new Date());
				int length = fileName.length();
				int index = fileName.indexOf(".");
				String ext = fileName.substring(index, length);
				file.setFileName(fileNameToBeAssigned.trim());
				upBean.store(mrequest, "upload_filename");
				fileUploaded = true;
				fileUploadedList.add(fileUploaded);
				if (fileUploaded) {
					fileUploadedList.add(fileName);
					fileUploadedList.add(file.getFileName());
				}
			}
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileUploadedList;
	}

	/**
	 * made by Priyanka Garg method is overloaded for uploading multiple files.
	 */
	public static List<Object> uploadFile(MultipartFormDataRequest mrequest,
			String uploadURL, String whiteList, String fileNameToBeAssigned,
			int i) {

		List fileUploadedList = new ArrayList();
		boolean fileUploaded = false;
		try {

			UploadBean upBean = new UploadBean();

			upBean.setFolderstore(uploadURL);
			upBean.setOverwrite(true);
			upBean.setWhitelist(whiteList);
			// upBean.setFilesizelimit(fileSizeLimit);
			Hashtable files = mrequest.getFiles();
			UploadFile file = (UploadFile) files
					.get(RequestConstants.UPLOAD_FILENAME + i);
			String fileName = file.getFileName();

			Long fileSize = file.getFileSize();

			if (fileName != null && fileSize > 0) // && fileSize <= 2097152 )
			{
				// SimpleDateFormat sdf = new
				// SimpleDateFormat("yyyyMMdd_HHmmss");
				// String date = sdf.format(new Date());
				int length = fileName.length();
				int index = fileName.indexOf(".");
				String ext = fileName.substring(index, length);
				file.setFileName(fileNameToBeAssigned);
				upBean.store(mrequest, RequestConstants.UPLOAD_FILENAME + i);
				fileUploaded = true;
				fileUploadedList.add(fileUploaded);
				if (fileUploaded) {
					fileUploadedList.add(fileName);
					fileUploadedList.add(file.getFileName());
				}
			}
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileUploadedList;
	}

	public static String getContent(String filePath) {
		File file = new File(filePath);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		StringBuffer content = new StringBuffer();
		try {
			fis = new FileInputStream(file);

			// Here BufferedInputStream is added for fast reading.
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			// dis.available() returns 0 if the file does not have more lines.
			while (dis.available() != 0) {

				// this statement reads the line from the file and print it to
				// the console.
				content.append(dis.readLine());

			}

			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	public static String getTextFromFile(String filePath) {
		// Opens a text file and returns the text from it.
		StringBuffer contents = new StringBuffer();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = null;
			while ((line = reader.readLine()) != null) {
				contents.append(line);
			}
		} catch (FileNotFoundException ex1) {
			 ex1.printStackTrace();
		} catch (IOException ex2) {
			 ex2.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException ex3) {
				 ex3.printStackTrace();
			}
		}

		return contents.toString();
	}

	// recruitment util methods
	public static List<Object> uploadFile(MultipartFormDataRequest mrequest,
			String uploadURL, String whiteList, Long fileSizeLimit,
			String fileNameToBeAssigned) {

		List fileUploadedList = new ArrayList();
		boolean fileUploaded = false;
		try {

			UploadBean upBean = new UploadBean();

			upBean.setFolderstore(uploadURL);

			/*
			 * try { //upBean.setDatabasestore(connection); Properties props =
			 * new Properties(); props.put("user","hms_eha");
			 * props.put("password","hms_eha");
			 * upBean.setDatabasestore("com.mysql.jdbc.Driver",
			 * "jdbc:mysql://192.168.203.61:3306/hms_eha", props); } catch
			 * (Exception e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
			upBean.setOverwrite(true);
			upBean.setWhitelist(whiteList);
			upBean.setFilesizelimit(fileSizeLimit);

			Hashtable files = mrequest.getFiles();

			UploadFile file = (UploadFile) files.get(RequestConstants.UPLOAD);
			String fileName = file.getFileName();

			Long fileSize = file.getFileSize();

			if (fileName != null && fileSize > 0
					&& fileSize <= RequestConstants.MAX_FILE_SIZE) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
				String date = sdf.format(new Date());
				int length = fileName.length();
				int index = fileName.indexOf(".");
				String ext = fileName.substring(index, length);
				file.setFileName(fileNameToBeAssigned + "_" + date + ext);
				// file.setFileName(fileNameToBeAssigned+"_"+date);

				upBean.store(mrequest, "upload");
				fileUploaded = true;
				fileUploadedList.add(fileUploaded);
				if (fileUploaded) {
					fileUploadedList.add(fileName);
					fileUploadedList.add(file.getFileName());
				}

			}
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileUploadedList;
	}

	public static String encryptPassword(String password) {

		MessageDigest md = null;
		byte[] msg = null;
		try {
			md = MessageDigest.getInstance("MD5");
			msg = password.getBytes("UTF8");

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		md.update(msg);
		byte[] aMessageDigest = md.digest();
		String encrpyptedPassword = new sun.misc.BASE64Encoder()
				.encode(aMessageDigest);
		return encrpyptedPassword;
	}

	public static boolean validatePassword(String passwordFromDB,
			String passwordFromRequest) {

		byte[] bMessageDigest = null;
		byte[] byteArrayFromDatabase = null;
		byte[] byteArrayFromRequest = null;
		MessageDigest md = null;
		boolean bool = false;
		try {
			md = MessageDigest.getInstance("MD5");
			bMessageDigest = passwordFromRequest.getBytes("UTF8");
			md.update(bMessageDigest);
			byteArrayFromRequest = md.digest();
			byteArrayFromDatabase = new sun.misc.BASE64Decoder()
					.decodeBuffer(passwordFromDB);
			bool = MessageDigest.isEqual(byteArrayFromRequest,
					byteArrayFromDatabase);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return bool;
	}

	public static List<Object> uploadAttendanceFile(
			MultipartFormDataRequest mrequest, String uploadURL,
			String whiteList, Long fileSizeLimit, String fileNameToBeAssigned) {

		List fileUploadedList = new ArrayList();
		boolean fileUploaded = false;
		try {

			UploadBean upBean = new UploadBean();

			upBean.setFolderstore(uploadURL);

			/*
			 * try { //upBean.setDatabasestore(connection); Properties props =
			 * new Properties(); props.put("user","hms_eha");
			 * props.put("password","hms_eha");
			 * upBean.setDatabasestore("com.mysql.jdbc.Driver",
			 * "jdbc:mysql://192.168.203.61:3306/hms_eha", props); } catch
			 * (Exception e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
			upBean.setOverwrite(true);
			upBean.setWhitelist(whiteList);
			upBean.setFilesizelimit(fileSizeLimit);

			Hashtable files = mrequest.getFiles();

			UploadFile file = (UploadFile) files.get(RequestConstants.UPLOAD);
			String fileName = file.getFileName();

			Long fileSize = file.getFileSize();

			if (fileName != null && fileSize > 0
					&& fileSize <= RequestConstants.MAX_FILE_SIZE) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
				String date = sdf.format(new Date());
				int length = fileName.length();
				int index = fileName.indexOf(".");
				String ext = fileName.substring(index, length);
				file.setFileName(fileNameToBeAssigned + ext);
				// file.setFileName(fileNameToBeAssigned+"_"+date);
				upBean.store(mrequest, "upload");
				fileUploaded = true;
				fileUploadedList.add(fileUploaded);
				if (fileUploaded) {
					fileUploadedList.add(fileName);
					fileUploadedList.add(file.getFileName());
				}

			}
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileUploadedList;
	}

	public static Date getCurrentDateAndTimeObject() {
		Date currentDateAndTime = new Date();
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormatter = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm:ss");
		try {
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			int month = calendar.get(Calendar.MONTH) + 1;
			int year = calendar.get(Calendar.YEAR);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			currentDateAndTime = dateFormatter.parse(day + "/" + month + "/"
					+ year + " " + hour + ":" + minute + ":" + second);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return currentDateAndTime;
	}

	public static String convertDateToStringTypeDate(Date date) {
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer dateOnly = new StringBuffer();
		dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(dateOfMonth);
		dateOnly.append("/");
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(month);
		dateOnly.append("/");
		year = calendar.get(Calendar.YEAR);

		dateOnly.append(year).append(" ")
				.append(calendar.get(Calendar.HOUR_OF_DAY)).append(":")
				.append(calendar.get(Calendar.MINUTE)).append(":")
				.append(calendar.get(Calendar.SECOND));
		return dateOnly.toString();
	}
	public static String convertDateToStringTypeDateOnly(Date date) {
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer dateOnly = new StringBuffer();
		dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(dateOfMonth);
		dateOnly.append("/");
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(month);
		dateOnly.append("/");
		year = calendar.get(Calendar.YEAR);

		dateOnly.append(year).append(" ");
		/*.append(calendar.get(Calendar.HOUR_OF_DAY)).append(":")
		  .append(calendar.get(Calendar.MINUTE)).append(":")
	   	  .append(calendar.get(Calendar.SECOND));*/
		return dateOnly.toString();
	}
	public static Map<String, Object> calculateHourDiffForAttendance(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		String inTime = "";
		String outTime = "";
		String inDate = "";
		String outDate = "";
		String fullday = "";
		String manualOverTime = "";

		if (parameterMap.get("inDate") != null) {
			inDate = (String) parameterMap.get("inDate");
		}
		if (parameterMap.get("outDate") != null) {

			outDate = (String) parameterMap.get("outDate");

		}
		if (parameterMap.get("outTime") != null) {
			outTime = (String) parameterMap.get("outTime");
		}
		if (parameterMap.get("inTime") != null) {
			inTime = (String) parameterMap.get("inTime");
		}



		String splitDate[] = inDate.split("/");
		inDate = splitDate[0] + "" + splitDate[1] + "" + splitDate[2];
		int indate1 = Integer.parseInt(inDate.substring(0, 2));
		int inmonth = Integer.parseInt(inDate.substring(2, 4));
		int inYear = Integer.parseInt(inDate.substring(4, 8));
		;
		int outdate1 = 0;
		int outmonth = 0;
		int outYear = 0;
		if (!outDate.equals("")) {
			String splitDate1[] = outDate.split("/");
			outDate = splitDate1[0] + "" + splitDate1[1] + "" + splitDate1[2];
			outdate1 = Integer.parseInt(outDate.substring(0, 2));
			outmonth = Integer.parseInt(outDate.substring(2, 4));
			outYear = Integer.parseInt(outDate.substring(4, 8));
		}

		int inHours = 0;
		int inMin = 0;
		int inSec = 0;

		String splitInTime[] = inTime.split(":");


		if (splitInTime.length == 3) {
			if (!splitInTime[0].equals("")) {
				inHours = Integer.parseInt(splitInTime[0]);
			}
			if (!splitInTime[1].equals("")) {
				inMin = Integer.parseInt(splitInTime[1]);
			}
			if (!splitInTime[2].equals("")) {
				inSec = Integer.parseInt(splitInTime[2]);
			}
		} else if (splitInTime.length == 2) {
			if (!splitInTime[0].equals("")) {
				inHours = Integer.parseInt(splitInTime[0]);
			}
			if (!splitInTime[1].equals("")) {
				inMin = Integer.parseInt(splitInTime[1]);
			}
		}

		int outHours = 0;
		int outMin = 0;
		int outSec = 0;

		String splitOutTime[] = outTime.split(":");
		if (splitOutTime.length == 3) {
			if (!splitOutTime[0].equals("")) {
				outHours = Integer.parseInt(splitOutTime[0]);
			}
			if (!splitOutTime[1].equals("")) {
				outMin = Integer.parseInt(splitOutTime[1]);
			}
			if (!splitOutTime[2].equals("")) {
				outSec = Integer.parseInt(splitOutTime[2]);
			}
		} else if (splitOutTime.length == 2) {
			if (!splitOutTime[0].equals("")) {
				outHours = Integer.parseInt(splitOutTime[0]);
			}
			if (!splitOutTime[1].equals("")) {
				outMin = Integer.parseInt(splitOutTime[1]);
			}
		}

		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.set(inYear, inmonth, indate1, inHours, inMin, inSec);
		calendar2.set(outYear, outmonth, outdate1, outHours, outMin, outSec);
		// milliseconds1 = InTime-----------------
		Long milliseconds1 = calendar1.getTimeInMillis();
		// milliseconds2 = OutTime-----------------
		Long milliseconds2 = calendar2.getTimeInMillis();

		Long diff = milliseconds2 - milliseconds1;

		Long diffSeconds = diff / 1000;
		Long diffMinutes = diff / (60 * 1000);
		Long diffHours = diff / (60 * 60 * 1000);
		Long remainingMin = (diffMinutes) - (diffHours * 60);
		String totalTimeDiff = diffHours + "." + remainingMin;

		map.put("totalTimeDiff", totalTimeDiff);

		return map;
	}

	public static Map<String, Object> calculateTimeDiffForAttendance(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		String inTime = "";
		String outTime = "";
		String inDate = "";
		String outDate = "";
		String fullday = "";
		String manualOverTime = "";

		if (parameterMap.get("inDate") != null) {
			inDate = (String) parameterMap.get("inDate");
		}
		if (parameterMap.get("outDate") != null) {

			outDate = (String) parameterMap.get("outDate");

		}
		if (parameterMap.get("outTime") != null) {
			outTime = (String) parameterMap.get("outTime");
		}
		if (parameterMap.get("inTime") != null) {
			inTime = (String) parameterMap.get("inTime");
		}
		if (parameterMap.get("fullday") != null) {
			fullday = (String) parameterMap.get("fullday");
		}
		if (parameterMap.get("manualOverTime") != null) {
			manualOverTime = (String) parameterMap.get("manualOverTime");
		}

		String splitDate[] = inDate.split("/");
		inDate = splitDate[0] + "" + splitDate[1] + "" + splitDate[2];
		int indate1 = Integer.parseInt(inDate.substring(0, 2));
		int inmonth = Integer.parseInt(inDate.substring(2, 4));
		int inYear = Integer.parseInt(inDate.substring(4, 8));
		;
		int outdate1 = 0;
		int outmonth = 0;
		int outYear = 0;
		if (!outDate.equals("")) {
			String splitDate1[] = outDate.split("/");
			outDate = splitDate1[0] + "" + splitDate1[1] + "" + splitDate1[2];
			outdate1 = Integer.parseInt(outDate.substring(0, 2));
			outmonth = Integer.parseInt(outDate.substring(2, 4));
			outYear = Integer.parseInt(outDate.substring(4, 8));
		}

		int inHours = 0;
		int inMin = 0;
		int inSec = 0;

		String splitInTime[] = inTime.split(":");


		if (splitInTime.length == 3) {
			if (!splitInTime[0].equals("")) {
				inHours = Integer.parseInt(splitInTime[0]);
			}
			if (!splitInTime[1].equals("")) {
				inMin = Integer.parseInt(splitInTime[1]);
			}
			if (!splitInTime[2].equals("")) {
				inSec = Integer.parseInt(splitInTime[2]);
			}
		} else if (splitInTime.length == 2) {
			if (!splitInTime[0].equals("")) {
				inHours = Integer.parseInt(splitInTime[0]);
			}
			if (!splitInTime[1].equals("")) {
				inMin = Integer.parseInt(splitInTime[1]);
			}
		}

		int outHours = 0;
		int outMin = 0;
		int outSec = 0;

		String splitOutTime[] = outTime.split(":");
		if (splitOutTime.length == 3) {
			if (!splitOutTime[0].equals("")) {
				outHours = Integer.parseInt(splitOutTime[0]);
			}
			if (!splitOutTime[1].equals("")) {
				outMin = Integer.parseInt(splitOutTime[1]);
			}
			if (!splitOutTime[2].equals("")) {
				outSec = Integer.parseInt(splitOutTime[2]);
			}
		} else if (splitOutTime.length == 2) {
			if (!splitOutTime[0].equals("")) {
				outHours = Integer.parseInt(splitOutTime[0]);
			}
			if (!splitOutTime[1].equals("")) {
				outMin = Integer.parseInt(splitOutTime[1]);
			}
		}

		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.set(inYear, inmonth, indate1, inHours, inMin, inSec);
		calendar2.set(outYear, outmonth, outdate1, outHours, outMin, outSec);
		// milliseconds1 = InTime-----------------
		Long milliseconds1 = calendar1.getTimeInMillis();
		// milliseconds2 = OutTime-----------------
		Long milliseconds2 = calendar2.getTimeInMillis();

		Long diff = milliseconds2 - milliseconds1;

		Long diffSeconds = diff / 1000;
		Long diffMinutes = diff / (60 * 1000);
		Long diffHours = diff / (60 * 60 * 1000);
		Long remainingMin = (diffMinutes) - (diffHours * 60);
		String totalTimeDiff = diffHours + "." + remainingMin;

		// calculate overtime.
		StringTokenizer str1 = new StringTokenizer(totalTimeDiff, ".");
		String totalHours = (String) str1.nextElement();
		String totalMin = (String) str1.nextElement();
		Calendar calendar3 = Calendar.getInstance();
		calendar3.set(Calendar.HOUR, Integer.parseInt(totalHours));
		calendar3.set(Calendar.MINUTE, Integer.parseInt(totalMin));
		// milliseconds3 = totalTimeDiff
		Long milliseconds3 = calendar3.getTimeInMillis();

		StringTokenizer str2 = new StringTokenizer(manualOverTime, ".");
		String manualOverTimeHours = (String) str2.nextElement();
		String manualOverTimeMin = "";
		if (str2.hasMoreElements()) {
			manualOverTimeMin = (String) str2.nextElement();
		}

		Calendar calendar4 = Calendar.getInstance();
		calendar4.set(Calendar.HOUR, Integer.parseInt(manualOverTimeHours));
		if (!manualOverTimeMin.equals("")) {
			calendar4.set(Calendar.MINUTE, Integer.parseInt(manualOverTimeMin));
		}
		// milliseconds4 = manualOverTime = 9hrs
		Long milliseconds4 = calendar4.getTimeInMillis();

		Long ot = milliseconds3 - milliseconds4;
		Long otMin = ot / (1000 * 60);
		Long otHours = ot / (60 * 60 * 1000);
		Long remainingOtMin = (otMin - (otHours * 60));

		StringTokenizer str3 = new StringTokenizer(fullday, ".");
		String fulldayTimeHours = (String) str3.nextElement();
		String fulldayTimeMin = "";
		if (str3.hasMoreElements()) {
			fulldayTimeMin = (String) str3.nextElement();
		}
		Calendar calendar5 = Calendar.getInstance();
		calendar5.set(Calendar.HOUR, Integer.parseInt(fulldayTimeHours));
		if (!fulldayTimeMin.equals("")) {
			calendar5.set(Calendar.MINUTE, Integer.parseInt(fulldayTimeMin));
		}
		// milliseconds5 = fullday = 8hrs
		Long milliseconds5 = calendar5.getTimeInMillis();

		Long ut = milliseconds5 - milliseconds3;
		Long utMin = ut / (1000 * 60);
		Long utHours = ut / (1000 * 60 * 60);
		Long remainingUtMin = utMin - (utHours * 60);

		String totalOverTime = "";
		String totalUt = "";
		// String totalUt = utHours+"."+remainingUtMin+"hours";
		if (milliseconds3 >= milliseconds4) {
			totalOverTime = otHours + "." + remainingOtMin + "hrs";
			totalUt = "";

		} else if (milliseconds3 <= milliseconds5) {
			totalUt = utHours + "." + remainingUtMin + "hrs";
			totalOverTime = "";
		}

		map.put("totalOverTime", totalOverTime);
		map.put("totalUt", totalUt);
		return map;
	}

	public static String convertMonth(int month) {
		String pMonth = "";
		if (month == 1) {
			pMonth = "January";
		} else if (month == 2) {
			pMonth = "February";
		} else if (month == 3) {
			pMonth = "March";
		} else if (month == 4) {
			pMonth = "April";
		} else if (month == 5) {
			pMonth = "May";
		} else if (month == 6) {
			pMonth = "June";
		} else if (month == 7) {
			pMonth = "July";
		} else if (month == 8) {
			pMonth = "August";
		} else if (month == 9) {
			pMonth = "September";
		} else if (month == 10) {
			pMonth = "October";
		} else if (month == 11) {
			pMonth = "November";
		} else if (month == 12) {
			pMonth = "December";
		}

		return pMonth;
	}

	public static Date dateFormatterddmmyy(String stringDate) {
		SimpleDateFormat dateFormatterDDMMYYYY = new SimpleDateFormat(
				"dd-MM-yyyy");
		try {
			return (dateFormatterDDMMYYYY.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String convertDateTypeToStringWithoutTime(Date date) {
		int dateOfMonth, month, year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer dateOnly = new StringBuffer();
		dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(dateOfMonth);
		dateOnly.append("-");
		month = calendar.get(Calendar.MONTH) + 1;
		if (month < 10) {
			dateOnly.append("0");
		}
		dateOnly.append(month);
		dateOnly.append("-");
		year = calendar.get(Calendar.YEAR);
		dateOnly.append(year);
		// .append("
		// ").append(calendar.get(Calendar.HOUR_OF_DAY)).append(":").append(calendar.get(Calendar.MINUTE)).append(":").append(calendar.get(Calendar.SECOND));
		return dateOnly.toString();
	}

	public static String calculateAgeForVisit(String ageAtRegTime,
			Date dateForCalculation) {
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateForCalculation);

		int calculatedDays, calculatedMonth, calculatedYear;

		int currentDays = now.get(Calendar.DATE);
		int regDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH) + 1;
		int regMonth = cal.get(Calendar.MONTH) + 1;
		int currentYear = now.get(Calendar.YEAR);
		int regYear = cal.get(Calendar.YEAR);

		String patientAge = "";

		if (currentDays < regDays) {
			currentDays = currentDays + 30;
			calculatedDays = currentDays - regDays;
			currentMonth = currentMonth - 1;
		} else {
			calculatedDays = currentDays - regDays;
		}

		if (currentMonth < regMonth) {
			currentMonth = currentMonth + 12;
			calculatedMonth = currentMonth - regMonth;
			currentYear = currentYear - 1;
		} else {
			calculatedMonth = currentMonth - regMonth;
		}

		calculatedYear = currentYear - regYear;
		String oldAge;
		oldAge = ageAtRegTime.substring(0, (ageAtRegTime.trim()).indexOf(" "));
		// Added by Priyanka for EHA
		StringTokenizer strAge = new StringTokenizer(oldAge, ".");
		if (strAge.countTokens() == 0) {
			oldAge = ageAtRegTime.substring(0,
					(ageAtRegTime.trim()).indexOf(" "));
		} else {
			oldAge = strAge.nextToken();
		}
		// End
		String ageUnit = ageAtRegTime.substring((ageAtRegTime.trim())
				.lastIndexOf(" ") + 1);
		int currentAge = Integer.parseInt(oldAge.trim());
		int newAgeYear = 0;
		if ((ageUnit.trim()).equals("Years")) {
			newAgeYear = currentAge + calculatedYear;
			patientAge = newAgeYear + " Years ";
		} else if ((ageUnit.trim()).equals("Months")) {
			if (calculatedYear > 0) {
				newAgeYear = calculatedYear;
				patientAge = newAgeYear + " Years ";
			} else {
				newAgeYear = currentAge + calculatedMonth;
				patientAge = newAgeYear + " Months ";
			}

		} else if ((ageUnit.trim()).equals("Days")) {
			if (calculatedYear > 0) {
				newAgeYear = calculatedYear;
				patientAge = newAgeYear + " Years ";
			} else if (calculatedMonth > 0) {
				newAgeYear = calculatedMonth;
				patientAge = newAgeYear + " Months ";
			} else {
				newAgeYear = currentAge + calculatedDays;
				patientAge = newAgeYear + " Days ";
			}
		}
		return patientAge;
	}
	/**
	 * return Diffrence calculated Date
	 * @author Mukesh.narayan
	 * @param diffrence Days for Next Date
	 * @return Next Date
	 * @Date 09 July 2010
	 */
	public static String getNextDate(int diffDays) {
		String nextDate="";
		try{
			Map<String, Object> mapDate = new HashMap<String, Object>();
			mapDate=getCurrentDateAndTime();
			String currentDate="";
			if(mapDate.get("currentDate")!=null){
				currentDate=(String)mapDate.get("currentDate");
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(convertStringTypeDateToDateType(currentDate));
			int dateValue = calendar.get(Calendar.DATE);
			calendar.set(Calendar.DATE, dateValue + diffDays);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			date=calendar.getTime();
			String datetime = dateFormat.format(date);
			StringTokenizer s = new StringTokenizer(datetime," ");
			while(s.hasMoreTokens())
			{
				nextDate  = s.nextToken();
				s.nextToken();
			}


		}catch (Exception e) {
			e.printStackTrace();
		}
		return nextDate;
	}
	/**
	 * return Diffrence calculated Date
	 * @author Mukesh.narayan
	 * @param diffrence Days for Next Date
	 * @return Next Date
	 * @Date 09 July 2010
	 */
	public static String getPrevDate(int diffDays) {
		String nextDate="";
		try{
			Map<String, Object> mapDate = new HashMap<String, Object>();
			mapDate=getCurrentDateAndTime();
			String currentDate="";
			if(mapDate.get("currentDate")!=null){
				currentDate=(String)mapDate.get("currentDate");
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(convertStringTypeDateToDateType(currentDate));
			int dateValue = calendar.get(Calendar.DATE);
			calendar.set(Calendar.DATE, dateValue - diffDays);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			date=calendar.getTime();
			String datetime = dateFormat.format(date);
			StringTokenizer s = new StringTokenizer(datetime," ");
			while(s.hasMoreTokens())
			{
				nextDate  = s.nextToken();
				s.nextToken();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return nextDate;
	}
	/**
	 * return Diffrence calculated Date
	 * @author Mukesh.narayan
	 * @param currentDate and difference Days for Next Date
	 * @return Next Date
	 * @Date 09 July 2010
	 */
	public static String getPrevDate(String currentDate,int diffDays) {
		String nextDate="";
		try{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(convertStringTypeDateToDateType(currentDate));
			int dateValue = calendar.get(Calendar.DATE);
			calendar.set(Calendar.DATE, dateValue - diffDays);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			date=calendar.getTime();
			String datetime = dateFormat.format(date);
			StringTokenizer s = new StringTokenizer(datetime," ");
			while(s.hasMoreTokens())
			{
				nextDate  = s.nextToken();
				s.nextToken();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return nextDate;
	}
	/**
	 * param date less than current date return flase
	 * @author Mukesh.narayan
	 * @param card validity Date
	 * @return boolean
	 * @Date 09 July 2010
	 */
	public static boolean checkCardValidityDate(String cardValidityDate) {
		boolean flag=false;
		try{
			Map<String, Object> mapDate = new HashMap<String, Object>();
			mapDate=getCurrentDateAndTime();
			String currentDate="";
			if(mapDate.get("currentDate")!=null){
				currentDate=(String)mapDate.get("currentDate");
			}
			Date currDate=convertStringTypeDateToDateType(currentDate);
			Date cardValidityDateTemp=convertStringTypeDateToDateType(cardValidityDate);

			if(currDate.compareTo(cardValidityDateTemp)==0){
				flag=false;
			}else if(currDate.compareTo(cardValidityDateTemp)>0){
				flag=false;
			}else{
				flag=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/*
	 * Code for Load Property File and get value of key
	 * Code By Mukesh Narayan SIngh
	 * Date 19 July 2010
	 */
	Properties properties = new Properties();{
		try{
					ClassLoader loader =getClass().getClassLoader();
					InputStream inStream = loader.getResourceAsStream("/WEB-INF/commonFile.properties");
			         properties.load(inStream);

			        }catch (IOException e) {
			    	//
			    	e.printStackTrace();
			       }
		}
	/**
	 * return value on the behalf of key means read property file on the basis of key
	 * @author Mukesh.narayan
	 * @param key
	 * @return value of property file
	 * @date 19 July 2010
	 */
	public String getKeyValueFromPropertyFile(String key) {
		String value="";
		try{
			value=properties.getProperty(key);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
		public static int getAsciiValue(String args) {
		String s = "Java";
		int ascciiValue=0;
		for (int i=0; i<s.length();i++){
			ascciiValue=(int)s.charAt(i);
		}
		return ascciiValue;
		}
	/*
	 * End Code for Load Property File and get value of key
	 * Code By Mukesh Narayan SIngh
	 * Date 19 July 2010
	 */
/*
 * Code for upload image
 */
     /*public static List<Object> uploadTicketFile(MultipartFormDataRequest mrequest, String uploadURL,String whiteList,String fileNameToBeAssigned )
        {

                    List fileUploadedList = new ArrayList();
                boolean fileUploaded = false;
                      try {

                      UploadBean upBean = new UploadBean();
                upBean.setFolderstore(uploadURL);
                upBean.setOverwrite(true);
                upBean.setWhitelist(whiteList);

                //upBean.setFilesizelimit(fileSizeLimit);
                Hashtable files = mrequest.getFiles();
               

                UploadFile file = (UploadFile)
                files.get(RequestConstants.UPLOAD_FILENAME);

                String fileName = file.getFileName();
                System.out.println("dddddd>>"+ fileName);
                      Long fileSize = file.getFileSize();

                if (fileName != null && fileSize > 0 ) //&& fileSize <=2097152 )
                {
                    //SimpleDateFormat sdf = newSimpleDateFormat("yyyyMMdd_HHmmss");
                    //String date = sdf.format(new Date());
                    int length = fileName.length();
                    int index = fileName.indexOf(".");

                    String ext = fileName.substring(index, length);

                    file.setFileName(fileNameToBeAssigned);
                     upBean.store(mrequest,"uploadFilename");
                    

                    fileUploaded = true;
                    fileUploadedList.add(fileUploaded);
                    if(fileUploaded)
                    {
                        fileUploadedList.add(fileName);

                        fileUploadedList.add(file.getFileName());
                    }
                }

              } catch (UploadException e)

              {
                  e.printStackTrace();

              }catch(Exception e)
              {
                  e.printStackTrace();

              }
              return fileUploadedList;
        }*/
		
		 public static List<Object> uploadTicketFile(MultipartFormDataRequest mrequest, String uploadURL,String whiteList,String fileNameToBeAssigned )
	        {

	                    List fileUploadedList = new ArrayList();
	                boolean fileUploaded = false;
	                      try {
	                    	  System.out.println(mrequest+"mrequest");
	                    	  System.out.println(uploadURL+"uploadURL");
	                    	  System.out.println(whiteList+"whiteList");
	                    	  System.out.println(fileNameToBeAssigned+"fileNameToBeAssigned");
	                      UploadBean upBean = new UploadBean();
	                upBean.setFolderstore(uploadURL);
	                upBean.setOverwrite(true);
	                upBean.setWhitelist(whiteList);

	                //upBean.setFilesizelimit(fileSizeLimit);
	                Hashtable files = mrequest.getFiles();
	                System.out.println(files+"files");
	                UploadFile file = (UploadFile)files.get("files");
	                
	                System.out.println(file+"<<<file");
	                String fileName = file.getFileName();

	                      Long fileSize = file.getFileSize();

	                if (fileName != null && fileSize > 0 ) //&& fileSize <=2097152 )
	                {
	                    //SimpleDateFormat sdf = newSimpleDateFormat("yyyyMMdd_HHmmss");
	                    //String date = sdf.format(new Date());
	                    int length = fileName.length();
	                    int index = fileName.indexOf(".");

	                    String ext = fileName.substring(index, length);

	                    file.setFileName(fileNameToBeAssigned);
	                     upBean.store(mrequest,"filee");

	                    fileUploaded = true;
	                    fileUploadedList.add(fileUploaded);
	                    if(fileUploaded)
	                    {
	                        fileUploadedList.add(fileName);

	                        fileUploadedList.add(file.getFileName());
	                    }
	                }

	              } catch (UploadException e) 

	              {
	                  e.printStackTrace();

	              }catch(IOException e)
	              {
	                  e.printStackTrace();

	              }
	              return fileUploadedList;
	        }
		
     /**
 	 * return financial year on the behalf of parameter date
 	 * @author Mukesh.narayan
 	 * @param date in this "11/04/2010" format
 	 * @return financial year
 	 * @date 11 Oct 2010
 	 */
     public static String getfinancialYear(String currentDate) {
    	 String financialYear="";
    	 try{
    		 String[] str = currentDate.split("/");
    		 int month=Integer.parseInt(str[1]);
    		 int temp=0;
    		 int temp1=0;
    		 if(month<=3){
    			 temp=Integer.parseInt(str[2])-1;
    			 financialYear=temp+"-"+str[2].substring(2);
    		 }else{
    			 temp=Integer.parseInt(str[2].substring(1))+1;
    			 financialYear=str[2]+"-"+temp;
    		 }
    	 }catch (Exception e) {
    		 e.printStackTrace();
    	 }
    	 return financialYear;
     }
     //---BY Dipali----
     public static String getFinancialYearYY_YY(String currentDate) {
    	 String financialYear="";
    	 try{
    		 String[] str = currentDate.split("/");
    		 int month=Integer.parseInt(str[1]);
    		 int temp=0;
    		 int temp1=0;
    		 if(month<=3){
    			 temp1=Integer.parseInt(str[2].substring(1));
    			 temp=Integer.parseInt(str[2])-1;
    			 financialYear=temp+"-"+temp1;
    		 }else{
    			 temp1=Integer.parseInt(str[2].substring(1));
    			 temp=Integer.parseInt(str[2].substring(1))+1;
    			 financialYear=temp1+"-"+temp;
    		 }
    	 }catch (Exception e) {
    		 e.printStackTrace();
    	 }

    	 return financialYear;
     }
     public static String getFinancialYearOnlyYY_YY(String currentDate) {
    	 String financialYear="";
    	 try{
    		 String[] str = currentDate.split("/");
    		 int month=Integer.parseInt(str[1]);
    		 int temp=0;
    		 int temp1=0;
    		 if(month<=3){
    			 temp1=Integer.parseInt(str[2].substring(1));
    			 temp=Integer.parseInt(str[2].substring(1))-1;
    			 financialYear=temp+"-"+temp1;
    		 }else{
    			 temp1=Integer.parseInt(str[2].substring(1));
    			 temp=Integer.parseInt(str[2].substring(1))+1;
    			 financialYear=temp1+"-"+temp;
    		 }
    	 }catch (Exception e) {
    		 e.printStackTrace();
    	 }

    	 return financialYear;
     }
     public static String getConvertDateYYYYMMDD(String currentDate) {
    	 String date="";
    	 try{
    		 String[] str = currentDate.split("/");
    		 /*int month=Integer.parseInt(str[1]);
    		 int temp=0;
    		 int temp1=0;
    		 if(month<=3){
    			 temp1=Integer.parseInt(str[2].substring(1));
    			 temp=Integer.parseInt(str[2])-1;
    			 financialYear=temp+"-"+temp1;
    		 }else{
    			 temp1=Integer.parseInt(str[2].substring(1));
    			 temp=Integer.parseInt(str[2].substring(1))+1;
    			 financialYear=temp1+"-"+temp;
    		 }*/
    		 date=str[2]+"-"+str[1]+"-"+str[0];
    	 }catch (Exception e) {
    		 e.printStackTrace();
    	 }

    	 return date;
     }
     

     
     public static HSSFCell getNextCell(HSSFRow row) {
 		int lastCell = row.getLastCellNum();
 		HSSFCell cell = row.createCell((short) (lastCell + 1));
 		return cell;
 	}
     public static Map<String, Object> getDaysDiffBetweenDate(
 			Map<String, Object> parameterMap) {
 		Map<String, Object> map = new HashMap<String, Object>();
    	String prevDate="";
    	String currDate="";
    	String currDate1="";
    	if (parameterMap.get("prevDate") != null) {
    		prevDate = (String) parameterMap.get("prevDate");
		}
    	if (parameterMap.get("currDate") != null) {
    		currDate = (String) parameterMap.get("currDate");
    		currDate1= (String) parameterMap.get("currDate");
		}
    	
 		String splitPrevDate[] = prevDate.split("/");
 		prevDate = splitPrevDate[0] + "" + splitPrevDate[1] + "" + splitPrevDate[2];
		int prevDays1 = Integer.parseInt(prevDate.substring(0, 2));
		int prevMonth1 = Integer.parseInt(prevDate.substring(2, 4));
		int prevYear1 = Integer.parseInt(prevDate.substring(4, 8));
		String splitCurrDate[] = currDate.split("/");
		currDate = splitCurrDate[0] + "" + splitCurrDate[1] + "" + splitCurrDate[2];
		int currDays1 = Integer.parseInt(currDate.substring(0, 2));
		int currMonth1 = Integer.parseInt(currDate.substring(2, 4));
		int currYear1 = Integer.parseInt(currDate.substring(4, 8));
 		// Creates two calendars instances
       
		Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        // Set the date for both of the calendar instance
        cal1.set(prevYear1, prevMonth1, prevDays1);
        cal2.set(currYear1,currMonth1, currDays1);
        
        
        long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();
        
        // Calculate difference in milliseconds
        long diff = milis2 - milis1;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        int diffDaysInt=0;
        diffDaysInt=(int)diffDays;
        int month=0;
        if(diffDaysInt<365){
        	prevDate=getPrevDate(currDate1,diffDaysInt);
        	month=diffDaysInt/30;
        }else{
        	prevDate=getPrevDate(currDate1,365);
        	month=12;
        }
        String splitDate[]=currDate1.split("/");
        currDate1=splitDate[2]+"-"+splitDate[1]+"-"+splitDate[0];
        String splitPrevDateFinal[]=prevDate.split("/");
        prevDate=splitPrevDateFinal[2]+"-"+splitPrevDateFinal[1]+"-"+splitPrevDateFinal[0];
		map.put("currDate", currDate1);
		map.put("prevDate", prevDate);
		map.put("month", month);
        return map;
	}
 	public static List<Object> uploadDCFEntry(MultipartFormDataRequest mrequest, String uploadURL,String whiteList,Long fileSizeLimit,String fileNameToBeAssigned,Connection connection,String inputFieldName)
    {
		
		    List fileUploadedList = new ArrayList();
            boolean fileUploaded = false;
			try {
          
			UploadBean upBean = new UploadBean();
 			try {
				//upBean.setDatabasestore(connection);
				/*Properties props = new Properties();
				  props.put("user","hms_eha");
				  props.put("password","hms_eha");
				  upBean.setDatabasestore("com.mysql.jdbc.Driver",
				   "jdbc:mysql://192.168.203.61:3306/hms_eha", props);*/
 				
 				//upBean.setDatabasestore(connection);
 				upBean.setFolderstore(uploadURL);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            upBean.setOverwrite(true);
            upBean.setWhitelist(whiteList);
            upBean.setFilesizelimit(fileSizeLimit);
           
            Hashtable files = mrequest.getFiles();
            
            UploadFile file = (UploadFile) files.get(inputFieldName);
            String fileName = file.getFileName();

			 Long fileSize = file.getFileSize();
	           
            if (fileName != null && fileSize > 0 && fileSize <= RequestConstants.MAX_FILE_SIZE )
            {
                int length = fileName.length();
                int index = fileName.indexOf(".");
                String ext = fileName.substring(index, length);
                file.setFileName(fileNameToBeAssigned+ext);
                upBean.store(mrequest, inputFieldName);
                fileUploaded = true;
                fileUploadedList.add(fileUploaded);
                if(fileUploaded)
                {
                    fileUploadedList.add(fileName);
                    fileUploadedList.add(file.getFileName());
                }
            
            }
          } catch (UploadException e) 
          {
              e.printStackTrace();
          }catch(IOException e)
          {
              e.printStackTrace();
          }
          return fileUploadedList;
    }
    
     
     //by:Ujjwal for fy format:yyyy-yyyy
     public static String getfinancialYearyyyy(String currentDate) {
    	 String financialYear="";
    	 try{
    		 String[] str = currentDate.split("/");
    		 int month=Integer.parseInt(str[1]);
    		 int temp=0;
    		 @SuppressWarnings("unused")
			int temp1=0;
    		 if(month<=3){
    			 temp=Integer.parseInt(str[2])-1;
    			 financialYear=""+temp;
    		 }else{

    			 financialYear=""+str[2];
    		 }
    	 }catch (Exception e) {
    		 e.printStackTrace();
    	 }
    	 return financialYear;
     }
           //Added by Ramdular 16/04/2011  ++++++++++++++++
     public static List<Object> uploadDocProof(MultipartFormDataRequest mrequest, String uploadURL,String whiteList,Long fileSizeLimit,String fileNameToBeAssigned,Connection connection,String inputFieldName)
     {
 		
 		    List fileUploadedList = new ArrayList();
             boolean fileUploaded = false;
 			try {
           
 			UploadBean upBean = new UploadBean();
  			try {
 				//upBean.setDatabasestore(connection);
 				/*Properties props = new Properties();
 				  props.put("user","hms_eha");
 				  props.put("password","hms_eha");
 				  upBean.setDatabasestore("com.mysql.jdbc.Driver",
 				   "jdbc:mysql://192.168.203.61:3306/hms_eha", props);*/
  				
  				//upBean.setDatabasestore(connection);
  				upBean.setFolderstore(uploadURL);
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
             upBean.setOverwrite(true);
             upBean.setWhitelist(whiteList);
             upBean.setFilesizelimit(fileSizeLimit);
            
             Hashtable files = mrequest.getFiles();
             
             UploadFile file = (UploadFile) files.get(inputFieldName);
             String fileName = file.getFileName();

 			 Long fileSize = file.getFileSize();
 	           
             if (fileName != null && fileSize > 0 && fileSize <= RequestConstants.MAX_FILE_SIZE )
             {
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                 String date = sdf.format(new Date());
                 int length = fileName.length();
                 int index = fileName.indexOf(".");
                 String ext = fileName.substring(index, length);
                 file.setFileName(fileNameToBeAssigned+"_"+date+ext);
                // file.setFileName(fileNameToBeAssigned+"_"+date);
                 upBean.store(mrequest, inputFieldName);
                 fileUploaded = true;
                 fileUploadedList.add(fileUploaded);
                 if(fileUploaded)
                 {
                     fileUploadedList.add(fileName);
                     fileUploadedList.add(file.getFileName());
                 }
             
             }
           } catch (UploadException e) 
           {
               e.printStackTrace();
           }catch(IOException e)
           {
               e.printStackTrace();
           }
           return fileUploadedList;
     }
     public static String getMonthName(String month){
    	 String monthName="";
    	 int months=0;
    	 months=Integer.parseInt(month);
    	 if(months==1){
    		 monthName="January"; 
    	 }
       	 if(months==2){
    		 monthName="February"; 
    	 }
       	 if(months==3){
    		 monthName="March"; 
    	 }
       	 if(months==4){
    		 monthName="April"; 
    	 }
       	 if(months==5){
    		 monthName="May"; 
    	 }
       	 if(months==6){
    		 monthName="June"; 
    	 }
       	 if(months==7){
    		 monthName="July"; 
    	 }
       	 if(months==8){
    		 monthName="August"; 
    	 }
       	 if(months==9){
    		 monthName="September"; 
    	 }
       	 if(months==10){
    		 monthName="October"; 
    	 }
       	 if(months==11){
    		 monthName="November"; 
    	 }
       	 if(months==12){
    		 monthName="December"; 
    	 }
   		 return monthName; 
     }
     public static String countNoOfDays(String Year,String Monthnum) {
 		//Create scanner object to obtain input from user
 		//Scanner input = new Scanner (System.in);
 		String noOfDays="";
 		//int MonthNum; //To hold the month from user input
 		//int Year; //To hold the year
 		String numDays;
 		String Month;
 		int year1=Integer.parseInt(Year);
 		int monthnum1=Integer.parseInt(Monthnum);
 		
 		//MonthNum = input.nextInt();
 		///Year = input.nextInt();
 		if (monthnum1 == 2)
 			{
 			 if ( (year1 % 4 == 0) ||( (year1 % 400 == 0)
 					 && !(year1 % 100 == 0)) ){
 				 numDays = "29";
 			 }
 				else{
 					numDays = "28";
 			}}
 		else if (monthnum1 == 1 || monthnum1 == 3 || monthnum1 == 5 || monthnum1 == 7 || monthnum1 == 8  
 					|| monthnum1 == 10 || monthnum1 == 12)
 		{
 			numDays = "31";
 		}
 		else{
 			numDays = "30";
 			}
 		return numDays;
 	}
/*     public static void main(String[] args) {

  		
    	 Map<String, Object> map = new HashMap<String, Object>();
 		
 		String prevDate="";
 		String currDate="";
 		map.put("prevDate", "01/01/2011");
 		map.put("currDate", "16/07/2011");
 		Map<String, Object> mapData = new HashMap<String, Object>();
 		mapData=getDaysDiffBetweenDate(map);
 		if(mapData.get("prevDate")!=null){
 			prevDate=(String)mapData.get("prevDate");
 		}
 		if(mapData.get("currDate")!=null){
 			currDate=(String)mapData.get("currDate");
 		}
 	}
*/    
     public void doGet(HttpServletRequest request,
             HttpServletResponse response)
            		 throws ServletException, IOException {
    	 response.setContentType("text/html");
    	 PrintWriter out = response.getWriter();

    	 Connection conn = null;

    	 try {
    		 Class.forName("com.ibm.db2.jcc.DB2Driver");
    		 conn =
    				 DriverManager.getConnection
    				 ("jdbc:db2://localhost:50000/JAVATEST",
    						 "<enter_username_here>","<enter_password_here>");
    	 } catch (Exception ex) {
    		 out.println("Connection failed");
    		 //
    		 return;
    	 }

    	 String sql;
    	 Statement stmt;
    	 try {
    		 sql = "DROP TABLE doctors";
    		 stmt = conn.createStatement();
    		 stmt.execute(sql);
    	 } catch (Exception ex) {
    		 //
    	 }

    	 try {
    		 stmt = conn.createStatement();
    		 sql = "CREATE TABLE doctors "+
    				 "(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY "+
    				 " (START WITH 1 INCREMENT BY 1), "+
    				 "data XML)";
    		 stmt.execute(sql);

    		 sql = "INSERT INTO doctors (data) values ('\n"+
    				 "  <doctor>\n"+
    				 "    <name>\n"+
    				 "      <fname>Joe</fname>\n"+
    				 "      <lname>Smith</lname>\n"+
    				 "    </name>\n"+
    				 "    <suffix>MD</suffix>\n"+
    				 "    <title>Doctor of Anesthetics</title>\n"+
    				 "    <specialty>Anesthetics</specialty>\n"+
    				 "    <address>\n"+
    				 "      <street>1280 N 1283 E</street>\n"+
    				 "      <zip>99999</zip>\n"+
    				 "      <state>MO</state>\n"+
    				 "    </address>\n"+
    				 "    <phone>555.555.5554</phone>\n"+
    				 "    <fax>555.555.5553</fax>\n"+
    				 "  </doctor>\n"+
    				 "')";
    		 stmt.executeUpdate(sql);
    		 if(!conn.isClosed())
    				conn.close();
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
}
    public static int getNoOfDays(Date date1,Date date2){
    	int days=0;
		int year = date1.getYear()+1900;
		int month = date1.getMonth();
		int date = date1.getDate();
		Date d1 = new GregorianCalendar(year, month, date).getTime();
		long diff = date2.getTime() - d1.getTime();
		days=Integer.parseInt(""+diff / (1000 * 60 * 60 * 24));
	
    	return days;
    } 
    public static boolean save(Date date1,Date date2,int inptientId){
    	boolean saved=false;
    	/*
    	
    	int days=0;

		int year = date1.getYear()+1900;
		int month = date1.getMonth();
		int date = date1.getDate();
		//Session session=(Session)getSession();
		Date d1 = new GregorianCalendar(year, month, date).getTime();
		long diff = date2.getTime() - d1.getTime();
		days=Integer.parseInt(""+diff / (1000 * 60 * 60 * 24));
		List<BlChargeSlipDetail>dtlList=new ArrayList<BlChargeSlipDetail>();
   	 List<String> aList=new ArrayList<String>();
	 Connection con=null;
	 Statement sstmt=null;
	 try{
	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     // con=DriverManager.getConnection("jdbc:sqlserver://192.168.203.196:1433");
      String url = "jdbc:sqlserver://localhost:1433;databaseName=TEST_SHP";
      String username="sa";
      String password="dbhms";
      
      con=DriverManager.getConnection(url,username,password);
      sstmt= con.createStatement();
      ResultSet rs=sstmt.executeQuery("SELECT count (*) as total FROM BL_CHARGE_SLIP_DETAIL DTL "+
" LEFT OUTER JOIN BL_CHARGE_SLIP_MAIN MAIN ON MAIN.CHARGE_SLIP_MAIN_ID=DTL.CHARGE_SLIP_MAIN_ID "
+" WHERE CHARGE_CODE_ID=1052 AND MAIN.INPATIENT_ID="+inptientId
);
      int totalCount=0;
      while(rs.next()){
    	  totalCount=rs.getInt("total");
    	  }
  int difference=0;
  difference=days-  totalCount;  
for(int i=1;i<=difference;i++){
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);




}
	 }catch(Exception e){
		 e.printStackTrace();
	 }
//		dtlList
    	*/
    	
    	return saved;
    }
    
    public static String getNexAndPreciousDate(Date date){
    	  int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
    	  String newDate="";
    	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    	  String prevDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
    	  String currDate = dateFormat.format(date.getTime());
    	  String nextDate = dateFormat.format(date.getTime() + MILLIS_IN_DAY);
//    	  
//  	  
    	  
    	  newDate=""+nextDate;
    	return newDate;
    }
    public static Date getPreviousDate(Date date){
  	  int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
  	  String newDate="";
  	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
  	  String prevDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
  	  Date previousDate=convertStringTypeDateToDateType(prevDate);
  	  String currDate = dateFormat.format(date.getTime());
  	  String nextDate = dateFormat.format(date.getTime() + MILLIS_IN_DAY);
//  	  
//  	  
  	  
  	  newDate=""+nextDate;
  	return previousDate;
  }
    
    public static void main(String[] args) {
    /*	Date da1=convertStringTypeDateToDateType("28/02/2014");
    	getNexAndPreciousDate(da1);
    	String toemail="ujjwal.kashyap@jktech.com";
    	String fromEmail="ujjwal.kashyap@hotmail.com";
    	List<String>a1=new ArrayList<String>();
    	a1.add(toemail);
    	List<String>a11=new ArrayList<String>();
    	a11.add(fromEmail);
    	//sendMailUsingAuthenticator(a1,"ujjwal.kashyap@hotmail.com",a11,a11,"hello test mail","Test Mai");
    	emailFunctionLeave("ujjwa.kashyap@hotmail.com","ujjwal.kashyap@jktech.com","Hello ","Test Message");
    	SendMail sm=new SendMail();*/
    	//sm.sendMail(host, addressTo, addressFrom, ccTo, bccTo, subject, mailContent)
    	
    	//getBillStatus(1,24,1);
    	System.out.println(now("HHmmss"));
	}
    
    
    
    
    //defined by mritunjay Kumar Singh	30-03-2015
    public static Date getDateWithoutTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
    public static void createFolderFroDocument(String folderName , String pathName)
    {
   	 File folder = new File(pathName+folderName);
   	 if(!folder.exists())
   	 {
   		 System.out.println(folder.mkdir());
   		 
   	 }
    }
    
    
    public static List<IpdCareDetails> getIpdCareDetails(List<IpdCareDetails> careDetails,int careId)
    {
    	List<IpdCareDetails> careDetails2=new ArrayList<IpdCareDetails>();
    	if(careDetails!=null)
    	{
    		for (IpdCareDetails careDetail : careDetails) {
				if(careDetail.getCareHeader().getNursingcareSetup().getNursing().getId()==careId)
				{
					careDetails2.add(careDetail);
				}
			}
    	}
    	return careDetails2;
    	
    }
    
    public static List<IpdVitalcareDetails> getIpdVitalDetails(List<IpdVitalcareDetails> vitalDetails,String vitalName)
    {
    	List<IpdVitalcareDetails> vitalDetails2=new ArrayList<IpdVitalcareDetails>();
    	if(vitalDetails!=null)
    	{
    		for (IpdVitalcareDetails vitalcareDetails : vitalDetails) {
				if(vitalcareDetails.getVitalHeader().getVitalSetup().getVitalName().equalsIgnoreCase(vitalName))
				{
					vitalDetails2.add(vitalcareDetails);
				}
			}
    	}
    	return vitalDetails2;
    	
    }
    
    
    public static List<IpWardConsumptionDetails> getIpWardConsumptionDetails(List<IpWardConsumptionDetails> consumptionDetails,int inpatientPrescriptionId)
    {
    	List<IpWardConsumptionDetails> consumptionDetails2=new ArrayList<IpWardConsumptionDetails>();
    	if(consumptionDetails!=null)
    	{
    		for (IpWardConsumptionDetails details : consumptionDetails) {
    			if(details.getConsumption().getInpatientPrescriptionDetails().getId()==inpatientPrescriptionId)
				{
    				consumptionDetails2.add(details);
				}
			}
    	}
    	return consumptionDetails2;
    	
    }
    public static synchronized boolean emailFunctionLeave(String recepientAddress,String senderEmailId, String emailMessage, String subject)
	{
		
		boolean emailSentSuccesfully = false;
		HMSUtil u=new HMSUtil();
		Authenticator a1 = u.new PopupAuthenticator();
		Properties props=new Properties();
		//props.put("mail.smtp.auth", "false");
	    
		try
		{
			URL resourcePath =  Thread.currentThread().getContextClassLoader().getResource("mail.properties");

			Session sessionForJavaMail = Session.getInstance(props, a1);
			props.load(new FileInputStream(new File(resourcePath.getFile())));
			Message msg = new MimeMessage(sessionForJavaMail);
			InternetAddress[] toAddress = new InternetAddress[2];
			
			toAddress= InternetAddress.parse(recepientAddress);
			msg.addRecipients(Message.RecipientType.TO, toAddress);

			Address ccAddress = new InternetAddress(senderEmailId);
			msg.setRecipient(Message.RecipientType.CC, ccAddress);

			Address fromAddress = new InternetAddress(senderEmailId);
			msg.setFrom(fromAddress);
			
//			Address bcc = new InternetAddress(recepientAddress);
//			msg.setRecipient(Message.RecipientType.BCC, bcc);
		
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText( emailMessage );
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart( messageBodyPart );
			msg.setContent(multipart);
			msg.setSubject(subject);
			Transport.send(msg);
			emailSentSuccesfully = true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emailSentSuccesfully; 
	}
	public static synchronized boolean sendMailUsingAuthenticator(List<String> addressTo,String senderEmailId,
			List<String> ccTo,List<String> bccTo,
			String emailMessage, String subject) {
		
		boolean emailSentSuccesfully = false;
		//Authenticator authenticator = new SMTPAuthenticator();
		Properties props=new Properties();
	    
		try
		{
			URL resourcePath =  Thread.currentThread().getContextClassLoader().getResource("mail.properties");
			props.load(new FileInputStream(new File(resourcePath.getFile())));
			HMSUtil u=new HMSUtil();
			TestAuthenticator  authenticator=u. new TestAuthenticator(props.getProperty("mailUserName"),props.getProperty("mailPassword"));
			Session sessionForJavaMail = Session.getInstance(props,authenticator);
			Message msg = new MimeMessage(sessionForJavaMail);

			InternetAddress[] toAddress = new InternetAddress[addressTo.size()];
			int i = 0;
			for (String to : addressTo) {
				toAddress[i] = new InternetAddress(to);
				i++;
			}
			msg.addRecipients(Message.RecipientType.TO, toAddress);

        	InternetAddress[] ccAddress = new InternetAddress[ccTo.size()];
        	i = 0;
        	for (String cc : ccTo) {
        			ccAddress[i] = new InternetAddress(cc);
        			i++;
        	}
			msg.addRecipients(Message.RecipientType.CC, ccAddress);

        	InternetAddress[] bccAddress = new InternetAddress[bccTo.size()];
        	i = 0;
        	for (String bcc : bccTo) {
    			bccAddress[i] = new InternetAddress(bcc);
    			i++;
        	}
        	msg.addRecipients(Message.RecipientType.BCC, bccAddress);

            Address fromAddress = new InternetAddress(senderEmailId);
			msg.setFrom(fromAddress);
			
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText( emailMessage );
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart( messageBodyPart );
			msg.setContent(multipart);
			msg.setSubject(subject);
			Transport.send(msg);
			emailSentSuccesfully = true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emailSentSuccesfully; 
	}
	class TestAuthenticator extends javax.mail.Authenticator {
		private PasswordAuthentication authentication;
		String username="";
		String password ="";

		public TestAuthenticator(String userName,String password) {
			 username = userName;
			 password = password;
			authentication = new PasswordAuthentication(username, password);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}
	  
	class PopupAuthenticator extends Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {

			return new PasswordAuthentication("","");
		}
	} 
	public static Date getPreviousDate(int diffType,int  noofdiff) {
		Date today=new Date();
		Calendar cl=new GregorianCalendar();
		cl.setTime(today);
		cl.add(diffType,noofdiff);
		Date newDate=cl.getTime();
		return newDate;
	}
	  public static int daysBetween(Date d1, Date d2,int daysOrWeek){
		  if(daysOrWeek==2){
			  return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24)/7);
		  }else {
			  return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
		  }
         
 }
	  public static String now(String dateFormat) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			return sdf.format(cal.getTime());
		}
	
		public static String convertDatetoString(Date DOB) throws ParseException
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			return sdf.format(DOB);
		}
	
		public static String convertSimple(int i) {
			return "" + i;
		}

public static String getBillStatus(int visitId,int orderId,int chargcodeId,int hospitalId){
	System.out.println("in billStatus");
	 String status="Paid";
	 BigDecimal outstanding=new BigDecimal(0);
	 List<String> aList=new ArrayList<String>();
	 Connection con=null;
	 Statement sstmt=null;
	 try{
     con = DBUtils.getConnection();
     sstmt= con.createStatement();
     ResultSet rsw=sstmt.executeQuery("select rate from mas_charge_code_rates where hospital_id="+hospitalId+" and charge_code_id="+chargcodeId);
     BigDecimal rate=new BigDecimal(0);
     
     if(rsw.next())
     {
    	 rate=rsw.getBigDecimal("rate");
     }else{
    	 ResultSet rsw1=sstmt.executeQuery("select rate from mas_charge_code_rates where hospital_id is null and charge_code_id="+chargcodeId);
    	 while(rsw1.next()){
    		 rate=rsw1.getBigDecimal("rate");
    	 }
     }
     System.out.println("rate----------"+rate);
     if((rate.compareTo(new BigDecimal(0)))>0){
    	 
     
     ResultSet rs=sstmt.executeQuery("select outstanding,pay_status from bl_op_bill_details d "+
" left outer join bl_op_bill_header h on h.op_bill_header_id=d.op_bill_header_id"+
" where "+
" d.charge_code_id="+chargcodeId+" and"+ 
" h.visit_id="+visitId);
     int totalCount=0;
     while(rs.next()){
   	   status=rs.getString("pay_status");
   	   outstanding=rs.getBigDecimal("outstanding");
   	  }
     if(status.equals("") || status.equals("P") || status.equalsIgnoreCase("W")){
    	 status="Paid";
     }
     else
     if(outstanding!=null){
     if(outstanding.compareTo(new BigDecimal(0))>0 || status.equals("PL") ){
    	 status="Not Paid";
     }else if(outstanding.compareTo(new BigDecimal(0))>0 || status.equals("P") ){
    	 status="Paid";
     }else{
    	 status="Not Paid";
     }
     }else if(status.equals("PL")){
    	 status="Not Paid";
     }else {
    	 status="Paid";
     }
     
     
     }else {
    	 
    	 status="Free";
    	 
     }
     
	 
	 
	 }catch(Exception e){
		 e.printStackTrace();
	 } finally {
	     DBUtils.closeConnection(con);

     }
//		dtlList
	
   	System.out.println("status--->>"+status);
	
	return status;
}
public static Map<String, Object> getCurrentTime() {
	Map<String, Object> map = new HashMap<String, Object>();
	String currentDate = "";
	String currentTime = "";
	SimpleDateFormat dateFormat = new SimpleDateFormat(	"dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	String datetime = dateFormat.format(date);
	StringTokenizer s = new StringTokenizer(datetime, " ");
	while (s.hasMoreTokens()) {
		currentDate = s.nextToken();
		currentTime = s.nextToken();
	}
	String currentDateYYYYMMDD="";
	String splitDate[]=currentDate.split("/");
	currentDateYYYYMMDD=splitDate[2]+"-"+splitDate[1]+"-"+splitDate[0];

	map.put("currentDateYYYYMMDD", currentDateYYYYMMDD);
	map.put("currentDate", currentDate);
	map.put("currentTime", currentTime);
	return map;
}
public static String addNewTimeToTime(String time,int hh,int mm,int newTimes) {
	String newTime="";
	try{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date=sdf.parse(time);
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		if(hh>0){
			now.add(Calendar.HOUR,hh);
		}
		if(mm>0){
			now.add(Calendar.MINUTE,mm);
		}
		if(newTimes>0){
			now.add(Calendar.SECOND,newTimes);	
		}
		newTime=(String.format("%02d:%02d:%02d",now.get(now.HOUR_OF_DAY),now.get(now.MINUTE),now.get(now.SECOND) ));
	}catch(Exception e){
		e.printStackTrace();
	}
	return newTime;

}

public static String currentTime() {
	String newTime="";
	try{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		Calendar now = Calendar.getInstance();
		
		
		newTime=now.get(now.HOUR_OF_DAY)+":"+now.get(now.MINUTE)+":"+now.get(now.SECOND);
	}catch(Exception e){
		e.printStackTrace();
	}
	return newTime;

}
	public static Date dateFormatterToHHMMSS(String stringDate) {
		SimpleDateFormat dateFormatterHHMMSS = new SimpleDateFormat("HH:mm:ss");
		try {
			return (dateFormatterHHMMSS.parse(stringDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getTimeWithZeroTailedSecond() {
		String dateStr="";
		try{
			String currentTime=(String)((Map)HMSUtil.getCurrentTime()).get("currentTime");
			Date date= HMSUtil.dateFormatterToHHMMSS(currentTime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(cal.SECOND, 0);
			dateStr=(String.format("%02d:%02d:%02d",cal.get(cal.HOUR_OF_DAY),cal.get(cal.MINUTE),cal.get(cal.SECOND) ));
		}catch(Exception e){
			e.printStackTrace();
		}
		return dateStr;
	}
	
	public static String getFutureMonth(int mm) {
		String newTime="";
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String strDate=(String)HMSUtil.getCurrentTime().get("currentDate");
			Date date=sdf.parse(strDate);
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.MONTH, mm-1);
			newTime=(String.format("%02d/%02d/%02d",now.get(now.DATE),now.get(now.MONTH),now.get(now.YEAR) ));
		}catch(Exception e){
			e.printStackTrace();
		}
		return newTime;

	}
	
	public static Date getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(String dateInString){ 
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		try {
		java.util.Date	date = (java.util.Date)formatter.parse(dateInString); 
		return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Date getDateForm_yyyy_mm_dd(String dateInString){ 
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
		java.util.Date	date = (java.util.Date)formatter.parse(dateInString); 
		return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public static String getdiagNosis(int visitId){
		System.out.println("in billStatusIp");
		String diagnosis="";
		 List<String> aList=new ArrayList<String>();
		 Connection con=null;
		 Statement sstmt=null;
		 ResultSet rs=null;
		 try{

	     con=DBUtils.getConnection();
	     sstmt= con.createStatement();
	      rs=sstmt.executeQuery("select mi.icd_name from discharge_icd_code d "+
	    	"	 left outer join visit v on v.visit_id=d.visit_id "+
"	left outer join mas_icd mi on mi.icd_id=d.icd_id  where d.visit_id="+visitId); 

	 
	//);
	     int totalCount=0;
	     while(rs.next()){
	    	 diagnosis=diagnosis.concat(",").concat(rs.getString("icd_name"));
	   	  }
	     if(diagnosis.equals("")){
	     rs=sstmt.executeQuery("select d.initial_diagnosis from opd_patient_details d "+
	    		    	"	 left outer join visit v on v.visit_id=d.visit_id "+
	    	"  where d.visit_id="+visitId); 
	     while(rs.next()){
	    	 diagnosis=rs.getString("initial_diagnosis");
	   	  }

	     }
	     
		 }catch(Exception e){
			 e.printStackTrace();
		 } finally {
		     DBUtils.closeConnection(con);
         }
//			dtlList
	   	
	   	System.out.println("status--->>"+diagnosis);
		
		return diagnosis;
	}

		
	
	public static String getBillStatusIP(int inpatientId,int orderId,int chargcodeId,int hospitalId){
		String status="";
		 List<String> aList=new ArrayList<String>();
		 Connection con=null;
		 Statement sstmt=null;
		 try{
	     con=DBUtils.getConnection();
	     sstmt= con.createStatement();
	     ResultSet rsw=sstmt.executeQuery("select rate from mas_charge_code_rates where hospital_id="+hospitalId+" and charge_code_id="+chargcodeId);
	     BigDecimal rate=new BigDecimal(0);
	     while(rsw.next())
	     {
	    	 rate=rsw.getBigDecimal("rate");
	     }
	     if((rate.compareTo(new BigDecimal(0)))>0){
	    	 
	     
	     ResultSet rs=sstmt.executeQuery("select dt.payment_made from dg_orderdt dt "+
	" left outer join dg_orderhd hd on hd.orderhd_id=dt.orderhd_id "+
	" where hd.orderhd_id="+orderId+" and dt.charge_code_id="+chargcodeId
	 
	);
	     int totalCount=0;
	     while(rs.next()){
	   	  status=rs.getString("payment_made");
	   	  }
	     }else {
	    	 
	    	 status="free";
	    	 
	     }
	     
		 
		 
		 }catch(Exception e){
			 e.printStackTrace();
		 } finally {
		     DBUtils.closeConnection(con);
         }
//			dtlList
		
	   	System.out.println("status--->>"+status);
		
		return status;
	}


public static String getAdmissionRequiredInfo(String type,int visitId){
	String status="";
	 List<String> aList=new ArrayList<String>();
	 Connection con=null;
	 Statement sstmt=null;
	 try{
     con=DBUtils.getConnection();
     sstmt= con.createStatement();
     if(type.equals("OP")){
     ResultSet rsw=sstmt.executeQuery("select admission_advised from opd_patient_details where visit_id="+visitId);
     String  info="";
     while(rsw.next())
     {
    	 info=rsw.getString("admission_advised");
     }
    // if((rate.compareTo(new BigDecimal(0)))>0){}else {}
     if(info!=null && !info.equals("") && !info.equalsIgnoreCase("y")){
    	 status="Yes";
     }else{
    	 status="No";
     }
     }else if(type.equals("IP")){
    	 
    	     ResultSet rsw=sstmt.executeQuery("select admission_advised from opd_patient_details where inpatient_id="+visitId);
    	     String  info="";
    	     while(rsw.next())
    	     {
    	    	 info=rsw.getString("admission_advised");
    	     }
    	    // if((rate.compareTo(new BigDecimal(0)))>0){}else {}
    	     if(info!=null && !info.equals("") && !info.equalsIgnoreCase("y")){
    	    	 status="Yes";
    	     }else{
    	    	 status="No";
    	     }
    	     
     }

	 }catch(Exception e){
		 e.printStackTrace();
	 } finally {
	     DBUtils.closeConnection(con);
     }
//		dtlList
	
   	System.out.println("status--->>"+status);
	
	return status;
}

public static Date getAdmissionDate(String type,int visitId){
	String status="";
	 List<String> aList=new ArrayList<String>();
	 Connection con=null;
	 Statement sstmt=null;
	 Date  admission_date=new Date();
	 try{
		 con=DBUtils.getConnection();
		 sstmt= con.createStatement();
		 if(type.equals("OP")){
			 ResultSet rsw=sstmt.executeQuery("select admission_date from opd_patient_details where visit_id="+visitId);

			 while(rsw.next())
			 {
				 admission_date=rsw.getDate("admission_date");
			 }
			 // if((rate.compareTo(new BigDecimal(0)))>0){}else {}
			 if(admission_date!=null ){
				 status="Yes";
			 }else{
				 status="No";
			 }
		 }else if(type.equals("IP")){
			 ResultSet rsw=sstmt.executeQuery("select admission_date from opd_patient_details where inpatient_id="+visitId);

			 while(rsw.next())
			 {
				 admission_date=rsw.getDate("admission_date");
			 }
			 // if((rate.compareTo(new BigDecimal(0)))>0){}else {}
			 if(admission_date!=null ){
				 status="Yes";
			 }else{
				 status="No";
			 }
		 }


	 }catch(Exception e){
		 e.printStackTrace();
	 } finally {
	     DBUtils.closeConnection(con);
     }

	return admission_date;
}

	 public static String convertDateOneFormatToAnother(String outFormat, Date date) {
		 String formattedDate="";
		try{
			DateFormat targetFormat = new SimpleDateFormat(outFormat);
			formattedDate = targetFormat.format(date);  
		}catch(Exception e){
			e.printStackTrace();
		} 
		return formattedDate;
	 }
	 
	 public static List<Object> opUploadFileMaintenance(MultipartFormDataRequest mrequest, String uploadURL,String whiteList,Long fileSizeLimit,String fileNameToBeAssigned)
	    {
	        
	            List<Object> fileUploadedList = new ArrayList();
	            boolean fileUploaded = false;
	            try {
	          
	            UploadBean upBean = new UploadBean();
	          
	            upBean.setFolderstore(uploadURL);
	            
	            upBean.setOverwrite(true);
	            upBean.setWhitelist(whiteList);
	            upBean.setFilesizelimit(fileSizeLimit);
	           
	            Hashtable files = mrequest.getFiles();
	            
	           // UploadFile file = (UploadFile) files.get(RequestConstants.UPLOAD);
	             UploadFile file = (UploadFile) files.get("image");
	     
	            String fileName = file.getFileName();

	             Long fileSize = file.getFileSize();
	             //System.out.println(file+"file11>>"+fileName+"   "+fileSize);
	            if (fileName != null && fileSize > 0 && fileSize <= RequestConstants.MAX_FILE_SIZE )
	            {//System.out.println(file+"file222>>"+fileName+"   "+fileSize);
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	                String date = sdf.format(new Date());
	                int length = fileName.length();
	                int index = fileName.indexOf(".");
	                String ext = fileName.substring(index, length);
	               // file.setFileName(fileNameToBeAssigned+"_"+date+ext);
	               // file.setFileName(fileNameToBeAssigned+"_"+date);
	                System.out.println("image upload "+upBean.SQLUPLOADID);
	                upBean.store(mrequest, "image");
	                System.out.println("image upload done "+upBean.SQLUPLOADID);
	                fileUploaded = true;
	                fileUploadedList.add(fileUploaded);
	                if(fileUploaded)
	                {
	                    fileUploadedList.add(fileName);
	                    fileUploadedList.add(file.getFileName());
	                    
	                }
	            
	            }
	          } catch (UploadException e)
	          {
	              e.printStackTrace();
	          }catch(IOException e)
	          {
	              e.printStackTrace();
	          }
	          return fileUploadedList;
	    }
		
	 public static List<Object> videoUploadFileMaintenance(MultipartFormDataRequest mrequest, String uploadURL,String whiteList,Long fileSizeLimit,String fileNameToBeAssigned)
	    {
	        
	            List fileUploadedList = new ArrayList();
	            boolean fileUploaded = false;
	            try {
	          
	            UploadBean upBean = new UploadBean();
	          
	            upBean.setFolderstore(uploadURL);
	            
	            upBean.setOverwrite(true);
	            upBean.setWhitelist(whiteList);
	            upBean.setFilesizelimit(fileSizeLimit);
	           
	            Hashtable files = mrequest.getFiles();
	            
	           // UploadFile file = (UploadFile) files.get(RequestConstants.UPLOAD);
	             UploadFile file = (UploadFile) files.get("video");
	        
	            String fileName = file.getFileName();

	             Long fileSize = file.getFileSize();
	             //System.out.println(file+"file11>>"+fileName+"   "+fileSize);
	            if (fileName != null && fileSize > 0 && fileSize <= 60097152 )
	            {//System.out.println(file+"file222>>"+fileName+"   "+fileSize);
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	                String date = sdf.format(new Date());
	                int length = fileName.length();
	                int index = fileName.indexOf(".");
	                String ext = fileName.substring(index, length);
	               // file.setFileName(fileNameToBeAssigned+"_"+date+ext);
	               // file.setFileName(fileNameToBeAssigned+"_"+date);
	                System.out.println(upBean.SQLUPLOADID);
	                upBean.store(mrequest, "video");
	                fileUploaded = true;
	                fileUploadedList.add(fileUploaded);
	                if(fileUploaded)
	                {
	                    fileUploadedList.add(fileName);
	                    fileUploadedList.add(file.getFileName());
	                }
	            
	            }
	          } catch (UploadException e)
	          {
	              e.printStackTrace();
	          }catch(IOException e)
	          {
	              e.printStackTrace();
	          }
	          return fileUploadedList;
	    }
	 
	 // added by amit das on 01-08-2016
	 public static String convertPhoneNumberToHL7(String phoneNumber) {
		StringBuffer hl7PhoneNumber = new StringBuffer();
		if(phoneNumber!=null && phoneNumber.length()==10){
			hl7PhoneNumber.append("(").append(phoneNumber.substring(0, 3)).append(")").append(phoneNumber.substring(3, 6)).append("-").append(phoneNumber.substring(6, 10));
		}
		 
		return hl7PhoneNumber.toString();
	}
	 
	// added by amit das on 01-08-2016
	 public static String convertHL7ToPhoneNumber(String hl7PhoneNumber) {
			String phoneNumber = null;
			if(hl7PhoneNumber!=null && hl7PhoneNumber.length()==13){
				phoneNumber = hl7PhoneNumber;
			   phoneNumber = phoneNumber.replaceAll("\\(", "");
			   phoneNumber = phoneNumber.replaceAll("\\)", "");
			   phoneNumber = phoneNumber.replaceAll("-", "");
			}
			 
			return phoneNumber;
		}
     

public static String getDifferenceBetweenTwoDates(Date prev, Date nextDate) {
	// get todays date
	Calendar now = Calendar.getInstance();
	now.setTime(nextDate);
	// get a calendar representing their birth date

	Calendar cal = Calendar.getInstance();
	cal.setTime(prev);

	// calculate age as the difference in years.
	@SuppressWarnings("unused")
	int calculatedDays, calculatedMonth, calculatedYear;
	int currentDays = now.get(Calendar.DATE);
	int birthDays = cal.get(Calendar.DATE);
	int currentMonth = now.get(Calendar.MONTH);
	int birthMonth = cal.get(Calendar.MONTH);
	int currentYear = now.get(Calendar.YEAR);
	int birthYear = cal.get(Calendar.YEAR);

	// if(currentDays<birthDays)
	// {
	// currentDays=currentDays+30;
	// calculatedDays=currentDays-birthDays;
	// currentMonth=currentMonth-1;
	// }
	// else{
	// calculatedDays=currentDays-birthDays;
	// }
	//
	// if(currentMonth<birthMonth)
	// {
	// currentMonth=currentMonth+12;
	// calculatedMonth=currentMonth-birthMonth;
	// currentYear=currentYear-1;
	// }
	// else{
	// calculatedMonth=currentMonth-birthMonth;
	// }

	calculatedMonth = currentMonth - birthMonth;
	if (calculatedMonth == 1) {
		calculatedDays = currentDays + (31 - birthDays);
	} else {
		calculatedDays = currentDays - birthDays;
	}

	calculatedYear = currentYear - birthYear;
	int age = calculatedYear;
	String agePeriod=""; 
	String period = "";
	
	if (calculatedYear == 0 && calculatedMonth != 0
			&& calculatedDays != 0) {
		if (calculatedMonth == 1 && calculatedDays < 30) {
			age = calculatedDays;
			period = "Days";
		
		} else {
			age = calculatedMonth;
			period = "Months";
		
		}

	} else if (age == 0 && calculatedMonth == 0 && calculatedDays != 0) {
		age = calculatedDays;
		period = "Days";
		
		
	} else if (age == 0 && calculatedMonth == 0 && calculatedDays == 0) {
		age = 0;
		period = "Days";
		
	} else {
		
		period = "Years";
		
	}
	agePeriod = age +" " +period;
	
	return agePeriod;
}



public static void generateReportExl(String jasper_filename, Map parameters,
Connection conn, HttpServletResponse response,
ServletContext context) {
	byte bytes[] = null;
	try {
		//bytes = JasperRunManager.runReportToPdf(getCompiledReport(context,jasper_filename), parameters, conn);
		JasperReport jasperReport=getCompiledReport(context,jasper_filename);
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, parameters,conn);
		JRXlsExporter exporterXLS = new JRXlsExporter();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		exporterXLS.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporterXLS.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));

		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration ();
		//configuration.setOnePagePerSheet(true);
		configuration.setOnePagePerSheet(false); //Changed by Arbind 30-12-2016
		configuration.setDetectCellType(true);
		configuration.setFontSizeFixEnabled(true);
		configuration.setRemoveEmptySpaceBetweenColumns(true);
		configuration.setRemoveEmptySpaceBetweenRows(true);
		configuration.setIgnoreGraphics(true);
		configuration.setIgnoreCellBackground(true);
		configuration.setIgnoreCellBorder(true);
		configuration.setWhitePageBackground(false);
		configuration.setCellLocked(false);
		configuration.setShowGridLines(true);
		configuration.setIgnorePageMargins(true);
		configuration.setWrapText(false);
		exporterXLS.setConfiguration(configuration);


		exporterXLS.exportReport();
		bytes = byteArrayOutputStream.toByteArray();
		ServletOutputStream output=response.getOutputStream();
		if (response != null) {
			response.setContentLength(bytes.length);
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename="+jasper_filename+".xls");
			output.write(bytes);
		}
		if(!conn.isClosed())
			conn.close();
	} catch (JRException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}


public static int generateMobileVerificationOTP() {
	// generate a 4 digit integer 1000 <10000
	int randomPIN = (int) (Math.random() * 9000) + 1000;
	return randomPIN;
}
//generate a 6 charachter otp
public static  String generatePassword() {
	String chars = "abcdefghijklmnopqrstuvwxyz"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789@%$%&^?#+=";

	final int PW_LENGTH = 6;
	Random rnd = new SecureRandom();
	StringBuilder pass = new StringBuilder();
	for (int i = 0; i < PW_LENGTH; i++)
		pass.append(chars.charAt(rnd.nextInt(chars.length())));
	return pass.toString();
}

public static String changeDobFormat(String ekycdob){
	String tempDob[]=null;
	if(ekycdob.contains("-")){
		tempDob=ekycdob.split("-");
		ekycdob=tempDob[0]+"/"+tempDob[1]+"/"+tempDob[2];
	}
	
	return ekycdob;
	
}
public static String[]  calculateEkycAgeByDOB(String dob){
	String[] ageAndUnit=new String[2];
	try{

		Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(dob);
		// get todays date
		Calendar now1 = Calendar.getInstance();
		// get a calendar representing their birth date

		Calendar cal = Calendar.getInstance();
		cal.setTime(dateOfBirth);

		// calculate age as the difference in years.
		@SuppressWarnings("unused")
		int calculatedDays, calculatedMonth, calculatedYear;
		int currentDays = now1.get(Calendar.DATE);
		int birthDays = cal.get(Calendar.DATE);
		int currentMonth = now1.get(Calendar.MONTH);
		//int birthMonth = cal.get(Calendar.MONTH);
		int currentYear = now1.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);

		
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	      Date birthDate = sdf.parse(dob); //Yeh !! It's my date of birth :-)
	   
      int years = 0;
      int months = 0;
      int days = 0;
      //create calendar object for birth day
      Calendar birthDay = Calendar.getInstance();
      birthDay.setTimeInMillis(birthDate.getTime());
      //create calendar object for current day
      long currentTime = System.currentTimeMillis();
      Calendar now = Calendar.getInstance();
      now.setTimeInMillis(currentTime);
      //Get difference between years
      years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
      int currMonth = now.get(Calendar.MONTH) + 1;
      int birthMonth = birthDay.get(Calendar.MONTH) + 1;
      //Get difference between months
      months = currMonth - birthMonth;
      //if month difference is in negative then reduce years by one and calculate the number of months.
      if (months < 0)
      {
         years--;
         months = 12 - birthMonth + currMonth;
         if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
            months--;
      } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
      {
         years--;
         months = 11;
      }
      //Calculate the days
      if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
         days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
      else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
      {
         int today = now.get(Calendar.DAY_OF_MONTH);
         now.add(Calendar.MONTH, -1);
         days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
      } else
      {
         days = 0;
         if (months == 12)
         {
            years++;
            months = 0;
         }
      }
      String daa="ddd"+days+"  mmm "+months+"  yyyy "+years+"";
      //Create new Age object
      String period = "";
      int age=0;

     if(  years<=0 && months!=0){
    	 period="Months";
    	 age=months;
    	 System.out.println(" "+period);
     }
     else{
    	 period="Days";
    	 age=days;
    	 System.out.println(" "+period); 
     }
   if(years>0){
	   period="Years";
  	 age=years;
  	 System.out.println(" "+period);
   }
   if(years==0 && months==0 && days==0){
	   period="Days";
	  	 age=1;
	  	//birthYear="";
	  	 System.out.println(" "+period);
	   
   }
   ageAndUnit[0]=period;
   ageAndUnit[1]=String.valueOf(age);
	
	}
	catch(Exception ex){
		
	}
	return ageAndUnit;
}


public static Date convertStringyyyyMMddTypeToDateType2(String date) {
	Date orderDateTime = null;

	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	if (date != null) {
		try {
			orderDateTime = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	return orderDateTime;
}
public static String convertDateToStringTypeDate2(Date date) {
	int dateOfMonth, month, year;
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	StringBuffer dateOnly = new StringBuffer();
	dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		dateOnly.append("0");
	}
	dateOnly.append(dateOfMonth);
	dateOnly.append("-");
	month = calendar.get(Calendar.MONTH) + 1;
	if (month < 10) {
		dateOnly.append("0");
	}
	dateOnly.append(month);
	dateOnly.append("-");
	year = calendar.get(Calendar.YEAR);

	dateOnly.append(year).append(" ")
			.append(calendar.get(Calendar.HOUR_OF_DAY)).append(":")
			.append(calendar.get(Calendar.MINUTE)).append(":")
			.append(calendar.get(Calendar.SECOND));
	return dateOnly.toString();
}

/** Added by dhananjay on 11-01-17
 *  Method to get year(2-digit numeric value)
 * @param date
 * @return
 */ 
public static String getYear(Date date) {
	
	Calendar cal = Calendar.getInstance();
    cal.setTime(date);  
    String years=String.valueOf(cal.get(Calendar.YEAR));
	return years.substring(2);
}

public static String getFiveDigitsId(int serialId){
	
	String serialNo="";
	//System.out.println("length  "+(int)(Math.log10(serialId)+1));
	if(serialId>0 && (int)(Math.log10(serialId)+1)==1)
	{
		serialNo = "0000" + (serialId);
	
	}
	else if(serialId>0 && (int)(Math.log10(serialId)+1)==2)
	{
		serialNo = "000" + (serialId);
	
	}
	else if(serialId>0 && (int)(Math.log10(serialId)+1)==3)
	{
		serialNo = "00" + (serialId );
	
	}
	else if(serialId>0 && (int)(Math.log10(serialId)+1)==4)
	{
		serialNo = "0" + (serialId);
	
	}
	
	else{
		serialNo = "" + (serialId);
	}
	System.out.println(serialNo);
	return  serialNo;
}

@SuppressWarnings("unchecked")
public static void generateReportForDirectPrintPatient(String jasper_filename, Map parameters,
		Connection conn, HttpServletResponse response,
		ServletContext context, String path,int pHinId,int hospitalId) {
	byte bytes[] = null;
	try {
		
	/*	System.out.println("compiler path is == "+getCompiledReport(context, jasper_filename));
		Set<String> keySet=parameters.keySet();
		for (String key : keySet) {
			System.out.println(key + "/" + parameters.get(key));
		}
		
		System.out.println("connection is == "+conn.toString());
		
		*/
		bytes = JasperRunManager.runReportToPdf(
				getCompiledReport(context, jasper_filename), parameters,
				conn);
		
		FileUtils.writeByteArrayToFile(new File(path+"/"+jasper_filename+pHinId+""+hospitalId+".pdf"), bytes);
	      
		if(!conn.isClosed())
			conn.close();
	} catch (JRException e) {
		e.printStackTrace();
	}catch ( IOException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
/*Added By Srikanth M*/
public static String getDayOfWeek(){
	Calendar cal = Calendar.getInstance();
	return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
}

public static String getDayStringFromDate(String dateString) throws ParseException{
	Date myDate=new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
	Calendar cal = Calendar.getInstance();
	  cal.setTime(myDate);
	  return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
}

public static String calculateYearMonthDay(Date dob){
	int years = 0;
	int months = 0;
	int days = 0;
	//create calendar object for birth day
	Calendar birthDay = Calendar.getInstance();
	birthDay.setTimeInMillis(dob.getTime());
	//create calendar object for current day
	long currentTime = System.currentTimeMillis();
	Calendar now = Calendar.getInstance();
	now.setTimeInMillis(currentTime);
	//Get difference between years
	years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
	int currMonth = now.get(Calendar.MONTH) + 1;
	int birthMonth = birthDay.get(Calendar.MONTH) + 1;
	//Get difference between months
	months = currMonth - birthMonth;
		//if month difference is in negative then reduce years by one and calculate the number of months.
	if (months < 0) {
		years--;
		months = 12 -birthMonth+currMonth;
		if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE) && years!=0)
			months--;
	} else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
		years--;
		months = 11;
	}
	//Calculate the days
	if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
		days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
	else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE )) {
		months--; //Addded by Arbind on 03-05-2017
		int today = now.get(Calendar.DAY_OF_MONTH);
		now.add(Calendar.MONTH, -1);
		//Changed by Arbind on 03-05-2017
		days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
		//days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today + 1;//commented by govind 02-09-2017
	} else {
		days = 0;
		if (months == 12) {
			years++;
			months = 0;
		}
	}
	return years+"&"+months+"&"+days;
}
static int[][] d  = new int[][]
        {
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 0, 6, 7, 8, 9, 5},
                {2, 3, 4, 0, 1, 7, 8, 9, 5, 6},
                {3, 4, 0, 1, 2, 8, 9, 5, 6, 7},
                {4, 0, 1, 2, 3, 9, 5, 6, 7, 8},
                {5, 9, 8, 7, 6, 0, 4, 3, 2, 1},
                {6, 5, 9, 8, 7, 1, 0, 4, 3, 2},
                {7, 6, 5, 9, 8, 2, 1, 0, 4, 3},
                {8, 7, 6, 5, 9, 3, 2, 1, 0, 4},
                {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
        };
static int[][] p = new int[][]
        {
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 5, 7, 6, 2, 8, 3, 0, 9, 4},
                {5, 8, 0, 3, 7, 9, 6, 1, 4, 2},
                {8, 9, 1, 6, 0, 4, 3, 5, 2, 7},
                {9, 4, 5, 3, 1, 2, 6, 8, 7, 0},
                {4, 2, 8, 6, 5, 7, 3, 9, 0, 1},
                {2, 7, 9, 3, 8, 0, 6, 4, 1, 5},
                {7, 0, 4, 6, 9, 1, 3, 2, 5, 8}
        };
public static boolean  VerhoeffAlgorithm(String aadharNo){
	
	/*public static void main(String[] args) {
		String num="355826035920";
		System.out.println(validateVerhoeff(num));
	}*/
        
         int[] inv = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};
		return validateVerhoeff(aadharNo);
}
        public static boolean validateVerhoeff(String num){
            int c = 0;
            int[] myArray = StringToReversedIntArray(num);
            for (int i = 0; i < myArray.length; i++){
                c = d[c][p[(i % 8)][myArray[i]]];
            }

            return (c == 0);
        }
        private static int[] StringToReversedIntArray(String num){
            int[] myArray = new int[num.length()];
            for(int i = 0; i < num.length(); i++){
                myArray[i] = Integer.parseInt(num.substring(i, i + 1));
            }
            myArray = Reverse(myArray);
            return myArray;
        }
        private  static int[] Reverse(int[] myArray){
            int[] reversed = new int[myArray.length];
            for(int i = 0; i < myArray.length ; i++){
                reversed[i] = myArray[myArray.length - (i + 1)];
            }
            return reversed;
        }
        
        /** Method Which will create sequence for token number and OP Serial number
		 * @param sequenceName
		 */
		public static void generateSequence(String sequenceName)	{
			Properties properties = new Properties();
			Connection conn=null;
			String sql=" CREATE SEQUENCE "+sequenceName+" START WITH 1 INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999 ";

			try{
                conn = DBUtils.getConnection();
				Statement st=conn.createStatement();
				st.execute(sql);
				//CallableStatement cals = conn.prepareCall(sql);
				//cals.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			finally{
				DBUtils.closeConnection(conn);
			}
		}
		
		public static Date convertStringToDate(String date) {
			Date orderDateTime = null;

			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			if (date != null) {
				try {
					orderDateTime = df.parse(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			return orderDateTime;
		}
		//Added By Om Tripathi 19/10/2017
		public static Date currentDateToNextYearDate(){
			Date toDates = null;
			Calendar date = Calendar.getInstance();
		    date.setTime(new Date());
		    Format format = new SimpleDateFormat("yyyy-MM-dd");
		    System.out.println(format.format(date.getTime()));
		    date.add(Calendar.YEAR,1);
		    date.add(Calendar.DATE,-1);
		    String modifiedDate=format.format(date.getTime());
		    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    try {
				toDates = df.parse(modifiedDate);
				System.out.println(toDates);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return toDates;
		}
		
		public static Date calculateDateBeforeEighteenYears() {
			/*Date toDates = null;
			Calendar date = Calendar.getInstance();
		    date.setTime(new Date());
		    Format format = new SimpleDateFormat("yyyy-MM-dd");
		    System.out.println(format.format(date.getTime()));
		    date.add(Calendar.YEAR,-18);
		    date.add(Calendar.DATE,-1);
		    String modifiedDate=format.format(date.getTime());
		    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    try {
				toDates = df.parse(modifiedDate);
				System.out.println(toDates);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return toDates;*/
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -18);
			cal.add(Calendar.DATE, -1);
			Date date = cal.getTime();
			
			Date d1=null;
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String d2 = format.format(date);
			
			try{
				DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				 d1=format.parse(d2);
				}
				catch(Exception e)
				{
					
				}
			System.out.println("d1="+d1);
			return d1;
			
		}
			
		public static Date calculateDateBeforeTenMonths(){

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -10);
			cal.add(Calendar.DATE, -1);
			Date date = cal.getTime();
			
			Date d1=null;
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String d2 = format.format(date);
			
			try{
				DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				 d1=format.parse(d2);
				}
				catch(Exception e)
				{
					
				}
			System.out.println("d1="+d1);
			return d1;
		}
			
		public static int caluclateDaysByDOB(Date dob){
			Date now = new Date();
			long diff = now.getTime() - dob.getTime();
	        return (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			
		}
		 public static String convertStringDateFormat(String sdate) throws ParseException
		 {
			 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			 String ds2 = sdf2.format(sdf1.parse(sdate));
			 System.out.println(ds2);
			  return ds2; 
		 }

		@SuppressWarnings("unchecked")
		public static void generateHTMLReport(String jasper_filename, Map parameters,
				Connection conn, HttpServletResponse response,
				ServletContext context) {	
			byte bytes[] = null;
		        try {
		            JasperReport jasperReport=getCompiledReport(context,jasper_filename);
		            JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, parameters,conn);
		        /*    jasperPrint.setTopMargin(0);
		            jasperPrint.setBottomMargin(0);*/
		         
		            ByteArrayOutputStream baos = new ByteArrayOutputStream();
		            HtmlExporter exporter = new HtmlExporter();
		            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		            exporter.setExporterOutput(new SimpleHtmlExporterOutput(baos));
		            SimpleHtmlReportConfiguration configuration = new SimpleHtmlReportConfiguration();
		            configuration.setZoomRatio(1.2f);
		           
		            exporter.setConfiguration(configuration);
		            exporter.exportReport();
		            
		            bytes = baos.toByteArray();
		            ServletOutputStream output=response.getOutputStream();
		            if (response != null) {
		                response.setContentLength(bytes.length);
		                response.setContentType("text/html");
		                response.setHeader("Content-Disposition", "inline; filename="+jasper_filename+".html");
		                output.write(bytes);
		            }
		            if(!conn.isClosed())
		                conn.close();
		        } catch (JRException e) {
		            e.printStackTrace();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }}
		
		public static String getPropertyValue(String propertyFileName, String propertyName) {
			String value = null;
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource(propertyFileName);
			try {
				properties.load(resourcePath.openStream());
				value = properties.getProperty(propertyName);
			} catch (IOException e) {
				LOGGER.error("IOException occurred while loading" + propertyFileName +  "file : " + e.getStackTrace().toString());
			}
			return value;
		}
	
		//get property file
		
		public static Properties  getPropertyFile(String propertiesFileName) {
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource(propertiesFileName);
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
	

			return properties;

		}
		
		public static String convertTimeSlotRangeTo12HourFormat(String startTimeSlot) {
			String startTimeSplit[] = startTimeSlot.split(":");
			String startHour = startTimeSplit[0];
			String startMinutes = startTimeSplit[1];
			int startTimeHour =	Integer.parseInt(startHour);
			int endTimeHour = startTimeHour+1;
			String startTimingAMPM = "AM";
			String endTimingAMPM = "AM";
			
			if (startTimeHour>12){
				startTimeHour = startTimeHour -12;
				startTimingAMPM = "PM";
			} else if (startTimeHour ==12) {
				startTimingAMPM = "PM";
			}
			
			if (endTimeHour>12){
				endTimeHour = endTimeHour -12;
				endTimingAMPM = "PM";
			} else if (endTimeHour ==12) {
				endTimingAMPM = "PM";
			}
			return startTimeHour+":"+startMinutes+" "+startTimingAMPM+"-"+endTimeHour+":"+startMinutes+" "+endTimingAMPM;
		}
		
}
