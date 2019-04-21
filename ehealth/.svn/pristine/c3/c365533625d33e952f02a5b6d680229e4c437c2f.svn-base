/*******************************************************************************
 * DISCLAIMER: The sample code or utility or tool described herein
 *    is provided on an "as is" basis, without warranty of any kind.
 *    UIDAI does not warrant or guarantee the individual success
 *    developers may have in implementing the sample code on their
 *    environment. 
 *    
 *    UIDAI does not warrant, guarantee or make any representations
 *    of any kind with respect to the sample code and does not make
 *    any representations or warranties regarding the use, results
 *    of use, accuracy, timeliness or completeness of any data or
 *    information relating to the sample code. UIDAI disclaims all
 *    warranties, express or implied, and in particular, disclaims
 *    all warranties of merchantability, fitness for a particular
 *    purpose, and warranties related to the code, or any service
 *    or software related thereto. 
 *    
 *    UIDAI is not responsible for and shall not be liable directly
 *    or indirectly for any direct, indirect damages or costs of any
 *    type arising out of use or any action taken by you or others
 *    related to the sample code.
 *    
 *    THIS IS NOT A SUPPORTED SOFTWARE.
 ******************************************************************************/
package in.gov.uidai.auth.aua.httpclient;

import in.gov.uidai.auth.aua.helper.DigitalSigner;
import in.gov.uidai.auth.device.model.OtpResponseDetails;
import in.gov.uidai.authentication.otp._1.Otp;
import in.gov.uidai.authentication.otp._1.OtpRes;

import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * <code>OtpClient</code> class can be used for submitting an OTP Generation request to
 * UIDAI OTP Server, and to get the response back
 * 
 * @author UIDAI
 *
 */
public class OtpClient {
	private URI otpServerURI = null;
	
	private String asaLicenseKey;
	private DigitalSigner digitalSignator;

	
	public OtpClient(URI otpServerURI) {
		this.otpServerURI = otpServerURI;
	}
	
	public OtpResponseDetails generateOtp(Otp otp) {
		try {
			String signedXML = generateSignedOtpXML(otp);
			//System.out.println(signedXML);
			
			if(signedXML.contains("<Otp ") || signedXML.contains("</Otp>")) {
				
				signedXML = signedXML.replace("<Otp ",  "<Auth ");
				signedXML = signedXML.replace("</Otp>",  "</Auth>");
			}

           if(signedXML.contains("<Auth xmlns=\"http://www.uidai.gov.in/authentication/otp/1.0\">")) {
				
				signedXML = signedXML.replace("<Auth xmlns=\"http://www.uidai.gov.in/authentication/otp/1.0\">",  "<Auth>");
				
			}
           System.out.println("signedXML--"+signedXML);
         //  System.out.println("After modification====:"+signedXML);
			
			/*String uriString = otpServerURI.toString() + (otpServerURI.toString().endsWith("/") ? "" : "/")
					+ otp.getAc() + "/" + otp.getUid().charAt(0) + "/" + otp.getUid().charAt(1);
			
			if (StringUtils.isNotBlank(asaLicenseKey)) {
				uriString  = uriString + "/" + asaLicenseKey;
			}*/
			
			String uriString =otpServerURI.toString();
			
			URI otpURI = new URI(uriString);

			WebResource webResource = Client.create(HttpClientHelper.getClientConfig(otpServerURI.getScheme())).resource(otpURI);

			/*String responseXML = webResource.header("REMOTE_ADDR", InetAddress.getLocalHost().getHostAddress()).post(String.class,
					signedXML);*/
			System.out.println("signedXML OTP ===:"+signedXML);
			String responseXML = webResource.header("Content-Type", "application/xml").post(String.class,
					signedXML);
			
			System.out.println("Respose of OTP===:"+responseXML);
            //added and commented by govind 20-11-2017
			if(responseXML.contains("&lt;")) {					
				 responseXML = responseXML.replace("&lt;",  "<");					
			}
			if(responseXML.contains("&gt;")) {					
				 responseXML = responseXML.replace("&gt;",  ">");					
			}
			if(responseXML.contains("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")) {					
				 responseXML = responseXML.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>",  "");					
			}
			if(responseXML.contains("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")) {					
				 responseXML = responseXML.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>",  "");					
			}
			if(responseXML.contains("<AuthRes xmlns:ns2=\"http://www.uidai.gov.in/authentication/uid-bfd-response/1.0\"")) {					
				 responseXML = responseXML.replace("<AuthRes xmlns:ns2=\"http://www.uidai.gov.in/authentication/uid-bfd-response/1.0\"",  "<AuthRes");					
			}
			 System.out.println("Respose of OTP new===:"+responseXML);
            /* added for get the original content */
			
			/*DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(responseXML));
			Document doc =dBuilder.parse(is);*/
			
			/*NodeList kycResponseList= doc.getElementsByTagName("KycResponse");
			
			if(null != kycResponseList && kycResponseList.getLength()>0){
				
				responseXML=kycResponseList.item(0).getNodeValue();
			}
			*/
			System.out.println("Original response=====:" + responseXML +"\n  The end");
			String org[]=responseXML.split("<KycResponse>");
		   	String first=org[1];
		   	String org2[]=first.split("</KycResponse>");
		    String second=org2[0];
		    responseXML=second;
			return new OtpResponseDetails(responseXML, parseOtpResponseXML(responseXML));
			//return new OtpResponseDetails(responseXML, otpres);
			//added and commented by govind 20-11-2017 end
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Exception during OTP generation " + e.getMessage(), e);
		}

	}

	private String generateSignedOtpXML(Otp otp) throws JAXBException, Exception {
		StringWriter otpXML = new StringWriter();

		try {
			JAXBElement element = new JAXBElement(new QName(
					"http://www.uidai.gov.in/authentication/otp/1.0", "Otp"), Otp.class, otp);

			JAXBContext.newInstance(Otp.class).createMarshaller().marshal(element, otpXML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean includeKeyInfo = true;

		/*if(System.getenv().get("SKIP_DIGITAL_SIGNATURE") != null) {
			return otpXML.toString();
		} else {
			return this.digitalSignator.signXML(otpXML.toString(), includeKeyInfo);
		}*/
		
		return otpXML.toString();
	}

	private OtpRes parseOtpResponseXML(String xmlToParse) throws JAXBException {
		 
		//Create an XMLReader to use with our filter 
		try {
			//Prepare JAXB objects 
			JAXBContext jc = JAXBContext.newInstance(OtpRes.class); 
			Unmarshaller u = jc.createUnmarshaller(); 

			XMLReader reader;
			reader = XMLReaderFactory.createXMLReader();

			//Create the filter (to add namespace) and set the xmlReader as its parent. 
			//NamespaceFilter inFilter = new NamespaceFilter("http://www.uidai.gov.in/authentication/otp/1.0", true); 
			NamespaceFilter inFilter = new NamespaceFilter("http://www.uidai.gov.in/authentication/uid-bfd-response/1.0", true); 
			inFilter.setParent(reader); 
			 
			//Prepare the input, in this case a java.io.File (output) 
			InputSource is = new InputSource(new StringReader(xmlToParse)); 
			 
			//Create a SAXSource specifying the filter 
			SAXSource source = new SAXSource(inFilter, is); 
			 
			//Do unmarshalling 
			OtpRes res = u.unmarshal(source, OtpRes.class).getValue(); 
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erorr while parsing response XML" + e.getMessage());
		}
	}
	
	
	/**
	 * Method to inject an instance of <code>DigitalSigner</code> class.
	 * @param digitalSignator
	 */
	public void setDigitalSignator(DigitalSigner digitalSignator) {
		this.digitalSignator = digitalSignator;
	}

	public void setAsaLicenseKey(String asaLicenseKey) {
		this.asaLicenseKey = asaLicenseKey;
	}
	
}
