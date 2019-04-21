/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package jkt.servlet;

import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.PRESCRIPTION_SLIP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.net.URL;

import jkt.hms.adt.handler.RegistrationHandlerService;
import jkt.hms.adt.handler.RegistrationHandlerServiceImpl;
import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JasperPrintServlet.java,v 1.1 2010/12/03 09:16:29 dipali Exp $
 */
public class JasperPrintServletLabBarCode extends HttpServlet
{


	/**
	 *
	 */
	public void service(
		HttpServletRequest request,
		HttpServletResponse response
		) throws IOException, ServletException
	{
		ServletContext context = this.getServletConfig().getServletContext();
		File reportFile = null;
		//Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		//Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> dataMap = new HashMap<String, Object>();
		Properties prop = new Properties();
		InputStream input = null;
		String report = "";
		Box box=HMSUtil.getBox(request);
		int inv_id = 0;
		int order_id = 0;
		//String hinNo="";
		String subChargeCodeName="";
		String subchargeCodeCode="";
		int hinId=0;
		String invDetails="";
		String collectedBy="";
		String collectionDate="";
		String collectionTime="";
		String sampleCode="";
		String sectionCode="";
		String sampleNumber="";
		String containerCode="";
		String sequenceNo=""; 
		String testUrgentStatus="";
		String orderNo="";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		String currentYear="";
		int visitId=0;
		int inpatientId=0;
		String departName="";
		int orderId=0;
		int dgSampleDetailId=0;
		if(currentDate!=null ){
			currentYear=currentDate.substring(6,10);
		}
		Connection conn = null;
		try {
			//orderId=<%=orderId%>&dgSampleDetailId=<%=sample[14]%>
			if (request.getParameter("orderId") != null
					&& (!request.getParameter("orderId").equals(""))) {
				orderId =Integer.parseInt(request.getParameter("orderId"));// +
																			// "' ";
			} 
			 if(request.getParameter("dgSampleDetailId")!=null && !request.getParameter("dgSampleDetailId").equals("")){
				 dgSampleDetailId=Integer.parseInt(request.getParameter("dgSampleDetailId"));
			 }
			 
			/*if (request.getParameter("order_id") != null
					&& (!request.getParameter("order_id").equals(""))) {
				order_id = Integer.parseInt(request.getParameter("order_id"));// +
																				// "' ";
			}*/
			
			
			System.out.println("currentYear  ----->>"+currentYear);
			//map.put("order_id",order_id);
			//map.put("inpatientId",inpatientId);
			
			//map.put()
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("jdbc.properties");
			try {
				 input = new FileInputStream(new
				 File(resourcePath.getFile()));
				 prop.load(input);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Class.forName(prop.getProperty("database.driver")).newInstance(); 
			conn = DriverManager.getConnection(prop.getProperty("database.url"), prop.getProperty("database.user"), prop.getProperty("database.password"));
			String hinNo=""; 
		
		if(hinNo!=null){
			System.out.println("hinNo-------->>>>"+hinNo);
			if(hinNo.equalsIgnoreCase(RequestConstants.UHID_FOR_QUALITY_TESTING)){
				parameters.put("order_id", order_id);
				parameters.put("inv_id", inv_id);
				parameters.put("hinId",hinId);
				parameters.put("subChargeCodeName",subChargeCodeName);
				parameters.put("subchargeCodeCode",subchargeCodeCode);
				//parameters.put("diag_no",diag_no);
				parameters.put("currentYear",currentYear);
				parameters.put("collectedBy",collectedBy);
				parameters.put("collectionDate",HMSUtil.convertStringTypeDateToDateType(collectionDate));
				parameters.put("collectionTime",collectionTime);
				parameters.put("sampleCode",sampleCode);
				parameters.put("sectionCode",sectionCode);
				parameters.put("sampleNumber",sampleNumber);
				parameters.put("containerCode",containerCode);
				parameters.put("sequenceNo",sequenceNo);
				//parameters.put("patientType",patientType);
				parameters.put("testUrgentStatus",testUrgentStatus);
				parameters.put("orderNo",orderNo);
				parameters.put("departName",departName);
				//parameters.put("query",query);
				
				try {
					reportFile = new File(context.getRealPath("/Reports/"+"print_without_barcode"+".jasper"));
					if (!reportFile.exists())
						throw new JRRuntimeException("File jasper file not found. The report design must be compiled first.");

					/*HMSUtil.generateReport("print_without_barcode", parameters,
							(Connection) detailsMap.get("con"), response,
							getServletContext());*/
				} catch (IllegalStateException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("in else");
				parameters.put("order_id", orderId); 
				parameters.put("currentYear",currentYear); 
				parameters.put("orderNo",dgSampleDetailId); 
				parameters.put("departName",departName);
				try {
					reportFile = new File(context.getRealPath("/Reports/"+"print_barcode2"+".jasper"));
					if (!reportFile.exists())
						throw new JRRuntimeException("File jasper file not found. The report design must be compiled first.");

					/*HMSUtil.generateReport("print_barcode2", parameters,
							(Connection) detailsMap.get("con"), response,
							getServletContext());*/
				} catch (IllegalStateException e) {
					e.printStackTrace();
				}
				}
		
			JasperPrint jasperPrint = null; 
		
		try
		{
			JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportFile);
			
			jasperPrint = 
				JasperFillManager.fillReport(
					jasperReport,
					parameters, 
					conn
					);
		}
		catch (JRException e)
		{
			response.setContentType("text/html");
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>JasperReports - Web Application Sample</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheet.css\" title=\"Style\">");
			out.println("</head>");
			
			out.println("<body bgcolor=\"white\">");

			out.println("<span class=\"bnew\">JasperReports encountered this error :</span>");
			out.println("<pre>");

			e.printStackTrace(out);

			out.println("</pre>");

			out.println("</body>");
			out.println("</html>");

			return;
		}

		if (jasperPrint != null)
		{
			response.setContentType("application/octet-stream");
			ServletOutputStream ouputStream = response.getOutputStream();
			
			ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
			oos.writeObject(jasperPrint);
			oos.flush();
			oos.close();

			ouputStream.flush();
			ouputStream.close();
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>JasperReports - Web Application Sample</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheet.css\" title=\"Style\">");
			out.println("</head>");
			
			out.println("<body bgcolor=\"white\">");
	
			out.println("<span class=\"bold\">Empty response.</span>");
	
			out.println("</body>");
			out.println("</html>");
		}
		} }catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}}
	
}
