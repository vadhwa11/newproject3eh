package jkt.hms.kmscl.Controller;


import jkt.hms.billing.dataservice.BillingDataService;
import jkt.hms.kmscl.util.KmsclDrugData;
import jkt.hms.kmscl.util.KmsclGeneralData;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException; 
import org.springframework.scheduling.quartz.QuartzJobBean; 

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext; 
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.api.MessageMetadataKeys;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.hoh.hapi.client.HohClientSimple; 
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.message.ACK;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@DisallowConcurrentExecution  
public class KmsclIntegrationScheduler extends QuartzJobBean {

	BillingDataService billingDataService = null;

	/**
	 * Getter And Setter of BillingDataService
	 */
	public BillingDataService getBillingDataService() {
		return billingDataService;
	}

	public void setBillingDataService(BillingDataService billingDataService) {
		this.billingDataService = billingDataService;
	}
	
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		System.out.println("KmsclIntegrationScheduler start");
		Map<String,Object> kmsclMap=new HashMap<String,Object>();
		Map<String,Object> map=new HashMap<String,Object>();
		List<KmsclDrugData> kmsclDrugList=new ArrayList<KmsclDrugData>();
		kmsclMap=GetXmlFromKmsclURLContents();
		map=billingDataService.addKmsclData(kmsclMap);
		System.out.println("KmsclIntegrationScheduler end");
	}
	
	public Map<String,Object> GetXmlFromKmsclURLContents() {

		Map<String,Object> kmsclMap=new HashMap<String,Object>();
		Map<String,Object> itemCount=new HashMap<String,Object>();
		Map<String,Object> batchCount=new HashMap<String,Object>();
		List<KmsclGeneralData> kmsclGeneralList=new ArrayList<KmsclGeneralData>();
		List<KmsclDrugData> kmsclDrugList=new ArrayList<KmsclDrugData>();
		//String url = "http://124.124.74.61:82/eHealthServices/Service.asmx/Peroorkada_Issue_Details";
		int storeId=Integer.parseInt(getKmsclUrl("storeId"));
		String url = getKmsclUrl("KmsclUrl");
		String xml = GetXmlFromKmsclURLContents(url);
		//System.out.println(xml);
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xml));
			Document doc =dBuilder.parse(is);
			int drugCount=0;
			NodeList headList = doc.getElementsByTagName("NewDataSet");
		    for (int i = 0; i < headList.getLength(); i++) {
		        NodeList issueNoteList = headList.item(i).getChildNodes();
		        for (int j = 0; j < issueNoteList.getLength(); j++) {
		            Node childNode = issueNoteList.item(j);
		            if ("Table1".equals(childNode.getNodeName())) {
		            	KmsclDrugData drug=new KmsclDrugData();
		            	NodeList drugDetailList = issueNoteList.item(j).getChildNodes();
		            	for (int k = 0; k < drugDetailList.getLength(); k++) {
		            	    Node drugNode = drugDetailList.item(k);	
		            	if ("INVOICENO".equals(drugNode.getNodeName())) {
		            			/*drug.setInvNo(drugDetailList.item(k).getNodeValue()
				                        .trim());*/
		            		drug.setInvNo(drugNode.getFirstChild().getNodeValue().trim());
		            		
		            	}
		            	if ("INVOICEDATE".equals(drugNode.getNodeName())) {
		            		/*drug.setInvDate(drugDetailList.item(k).getNodeValue()
				                        .trim());*/
		            		drug.setInvDate(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("INSTITUTIONID".equals(drugNode.getNodeName())) {
		            		/*drug.setInstId(drugDetailList.item(k).getNodeValue()
				                        .trim());*/
		            		drug.setInstId(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("GSTIN".equals(drugNode.getNodeName())) {
		            		/*drug.setGSTIN(drugDetailList.item(k).getNodeValue()
				                        .trim());*/
		            		drug.setGSTIN(drugNode.getFirstChild().getNodeValue().trim());
			            	}		           
				        			            
		            	if ("ITEMCODE".equals(drugNode.getNodeName())) {
		            		/*drug.setDrugCode(drugDetailList.item(k).getNodeValue()
			                        .trim());
		            		String itemNo=drugDetailList.item(k).getNodeValue().trim();
		            		itemCount.put(itemNo,itemNo);*/
		            		drug.setDrugCode(drugNode.getFirstChild().getNodeValue().trim());
		            		String itemNo=drugNode.getFirstChild().getNodeValue().trim();
		            		itemCount.put(itemNo,itemNo);
		            	}
		            	if ("HSNCODE".equals(drugNode.getNodeName())) {
		            		/*drug.setHSNCode(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setHSNCode(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("PONO".equals(drugNode.getNodeName())) {
		            		/*drug.setPONo(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setPONo(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("PODATE".equals(drugNode.getNodeName())) {
		            		/*drug.setPODate(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setPODate(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("QUANTITY".equals(drugNode.getNodeName())) {
		            		/*drug.setQuantity(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setQuantity(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("BATCHNO".equals(drugNode.getNodeName())) {
		            		/*drug.setBatchNo(drugDetailList.item(k).getNodeValue()
			                        .trim());
		            		String batNo=drugDetailList.item(k).getNodeValue().trim();
		            		batchCount.put(batNo,batNo);*/
		            		drug.setBatchNo(drugNode.getFirstChild().getNodeValue().trim());
		            		String batNo=drugNode.getFirstChild().getNodeValue().trim();
		            		batchCount.put(batNo,batNo);
			            	}
		            	if ("MFGDATE".equals(drugNode.getNodeName())) {
		            		/*drug.setMfgDate(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setMfgDate(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("EXPDATE".equals(drugNode.getNodeName())) {
		            		/*drug.setExpDate(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setExpDate(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("UNITRATE".equals(drugNode.getNodeName())) {
		            		/*drug.setUnitRate(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setUnitRate(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("Ser_Charge".equals(drugNode.getNodeName())) {
		            		/*drug.setSerCharge(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setSerCharge(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("SERVICECHARGE".equals(drugNode.getNodeName())) {
		            		/*drug.setCGSTPer(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setCGSTPer(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("CGSTVAL".equals(drugNode.getNodeName())) {
		            		/*drug.setCGSTVal(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setCGSTVal(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("SGSTPER".equals(drugNode.getNodeName())) {
		            		/*drug.setSGSTPer(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setSGSTPer(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("SGSTVAL".equals(drugNode.getNodeName())) {
		            		/*drug.setSGSTVal(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setSGSTVal(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("VALUE".equals(drugNode.getNodeName())) {
		            		/*drug.setValue(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setValue(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	if ("GSTONSC".equals(drugNode.getNodeName())) {
		            		/*drug.setGSTONSC(drugDetailList.item(k).getNodeValue()
			                        .trim());*/
		            		drug.setGSTONSC(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	//Added by Arbind on 29-01-2018
		            	
		            	if ("OUTWNO".equals(drugNode.getNodeName())) {
		            		drug.setOUTWNO(drugNode.getFirstChild().getNodeValue().trim());
			            	}
		            	}
		              kmsclDrugList.add(drug);
		            }
		        }
		    }
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		kmsclMap.put("kmsclGeneralList", kmsclGeneralList);
		kmsclMap.put("kmsclDrugList", kmsclDrugList);
		kmsclMap.put("storeId", storeId);
		//System.out.println("kmsclGeneralList "+kmsclGeneralList.size());
		System.out.println("XML size "+kmsclDrugList.size());
		System.out.println("itemCount "+itemCount.size()+" batchCount "+batchCount.size());
		return kmsclMap;
	}
	
	public String GetXmlFromKmsclURLContents(String myURL) {
		System.out.println("GetXmlFromKmlsURLContents() is hitting : " + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null){
				urlConn.setReadTimeout(60 * 1000);
			}
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while calling URL:" + myURL, e);
		}
 
		return sb.toString();
	}
	
	public static String getKmsclUrl(String input){
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("kmscl.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String result ="";
		if(input.equalsIgnoreCase("KmsclUrl")){
			result=properties.getProperty("KmsclUrl");
		}
		if(input.equalsIgnoreCase("storeId")){
			result=properties.getProperty("storeId");
		}
		return result;
	}

}
