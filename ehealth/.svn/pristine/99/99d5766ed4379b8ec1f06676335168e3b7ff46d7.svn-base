package in.gov.uidai.sample;

import in.gov.uidai.auth.aua.helper.AuthRequestCreator;
import in.gov.uidai.auth.aua.helper.AuthResponseValidator;
import in.gov.uidai.auth.aua.helper.AuthResponseValidator.ValidationResult;
import in.gov.uidai.auth.aua.helper.BfdRequestCreator;
import in.gov.uidai.auth.aua.helper.DigitalSigner;
import in.gov.uidai.auth.aua.helper.OtpRequestCreator;
import in.gov.uidai.auth.aua.helper.SignatureVerifier;
import in.gov.uidai.auth.aua.httpclient.AuthClient;
import in.gov.uidai.auth.aua.httpclient.BfdClient;
import in.gov.uidai.auth.aua.httpclient.KYCClient;
import in.gov.uidai.auth.aua.httpclient.OtpClient;
import in.gov.uidai.auth.client.biometrics.BiometricIntegrationAPI;
import in.gov.uidai.auth.client.biometrics.CaptureDetails;
import in.gov.uidai.auth.client.biometrics.CaptureHandler;
import in.gov.uidai.auth.device.helper.AuthAUADataCreator;
import in.gov.uidai.auth.device.helper.BfdAUADataCreator;
import in.gov.uidai.auth.device.helper.Encrypter;
import in.gov.uidai.auth.device.helper.PidCreator;
import in.gov.uidai.auth.device.helper.RbdCreator;
import in.gov.uidai.auth.device.model.AuthDataFromDeviceToAUA;
import in.gov.uidai.auth.device.model.AuthResponseDetails;
import in.gov.uidai.auth.device.model.BFDDataFromDeviceToAUA;
import in.gov.uidai.auth.device.model.BfdResponseDetails;
import in.gov.uidai.auth.device.model.DeviceCollectedAuthData;
import in.gov.uidai.auth.device.model.DeviceCollectedBfdData;
import in.gov.uidai.auth.device.model.OtpDataFromDeviceToAUA;
import in.gov.uidai.authentication.common.types._1.FingerPosition;
import in.gov.uidai.authentication.common.types._1.LocationType;
import in.gov.uidai.authentication.common.types._1.Meta;
import in.gov.uidai.authentication.otp._1.Otp;
import in.gov.uidai.authentication.otp._1.OtpRes;
import in.gov.uidai.authentication.otp._1.OtpResult;
import in.gov.uidai.authentication.uid_auth_request._1.Auth;
import in.gov.uidai.authentication.uid_auth_request._1.DataType;
import in.gov.uidai.authentication.uid_auth_request._1.Tkn;
import in.gov.uidai.authentication.uid_auth_request._1.Uses;
import in.gov.uidai.authentication.uid_auth_request._1.UsesFlag;
import in.gov.uidai.authentication.uid_auth_request_data._1.BioMetricType;
import in.gov.uidai.authentication.uid_auth_request_data._1.BiometricPosition;
import in.gov.uidai.authentication.uid_auth_request_data._1.MatchingStrategy;
import in.gov.uidai.authentication.uid_auth_response._1.AuthRes;
import in.gov.uidai.authentication.uid_auth_response._1.AuthResult;
import in.gov.uidai.authentication.uid_bfd_request._1.Bfd;
import in.gov.uidai.authentication.uid_bfd_response._1.BfdRes;
import in.gov.uidai.authentication.uid_bfd_response._1.Rank;
import in.gov.uidai.authentication.uid_bfd_response._1.Ranks;
import in.gov.uidai.kyc.client.utils.XMLUtilities;
import in.gov.uidai.kyc.common.types._1.GenderType;
import in.gov.uidai.kyc.uid_kyc_response._1.KycRes;
import in.gov.uidai.kyc.uid_kyc_response._1.LDataType;
import in.gov.uidai.kyc.uid_kyc_response._1.PoaType;
import in.gov.uidai.kyc.uid_kyc_response._1.PoiType;
import in.gov.uidai.kyc.uid_kyc_response._1.UidDataType;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;


public class SampleClientMainFrame  {
     String uDc="";
	public String getuDc() {
		return uDc;
	}



	public void setuDc(String uDc) {
		this.uDc = uDc;
	}
	private static Map<String, Font> languageToFontMap = new HashMap<String, Font>();
	public static Map<String, byte[]> skeyMap = new HashMap<String, byte[]>();

	static {
		languageToFontMap.put("English", Font.decode("tahoma-plain-10"));
		languageToFontMap.put("Hindi", Font.decode("mangal-plain-10"));
		languageToFontMap.put("Kannada", Font.decode("tunga-plain-10"));
		languageToFontMap.put("Malayalam", Font.decode("kartika-plain-10"));
	}

	private static Map<String, String> languageToCodeMap = new HashMap<String, String>();
	static {
		languageToCodeMap.put("English", "23");
		languageToCodeMap.put("Hindi", "06");
		languageToCodeMap.put("Kannada", "07");
		languageToCodeMap.put("Malayalam", "11");
	}
	

	private static Map<String, String> tokenLabelToTokenTypeMap = new HashMap<String, String>();
	static {
		tokenLabelToTokenTypeMap.put("Mobile", "001");
	}

	private List<DeviceCollectedAuthData.BiometricData> bioCaptures = new ArrayList<DeviceCollectedAuthData.BiometricData>();
	//private List<DeviceCollectedBfdData.BiometricData> bioBfdCaptures = new ArrayList<DeviceCollectedBfdData.BiometricData>();

    private Map<FingerPosition, CaptureDetails> bfdCaptures = new HashMap<FingerPosition, CaptureDetails>();

	private AuthClient authClient;
	private BfdClient bfdClient;
	private OtpClient otpClient;
	private KYCClient kycClient;
	private AuthResponseValidator authResponseValidator;

	private AuthAUADataCreator auaDataCreator = null;
	private BfdAUADataCreator auaDataCreatorForBfd = null;
	String customKYCXML="";

	/**
	 * Name of the class that provides biometric integration API implementation.
	 */
	private String biometricAPIImplementationClass = "in.gov.uidai.auth.sampleapp.DigitalPersonaImpl";

	/** Creates new form Test */
	

	
	 public SampleClientMainFrame(String publicKeyFile,String signatureVariferKey) {
		 Properties properties = new Properties();
	     URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("authclient.properties");
	     

		 try
	       {
	               properties.load(resourcePath.openStream());
	       }
	       catch (Exception e)
	       {
	               e.printStackTrace();
	       }
	      
	       
		try {
			String authServerUrl=properties.getProperty("authServerUrl");
			String otpServerUrl=properties.getProperty("otpServerUrl");
			String bfdServerUrl=properties.getProperty("bfdServerUrl");
			String ekycServerUrl=properties.getProperty("ekycServerUrl");
			String asaLicenseKey=properties.getProperty("ekycServerUrl");
			//String publicKeyFile=properties.getProperty("publicKeyFile");
			uDc=properties.getProperty("udc");
			setuDc(uDc);
			
			authClient = new AuthClient(new URL(authServerUrl).toURI());
			bfdClient = new BfdClient(new URL(bfdServerUrl).toURI());
			otpClient = new OtpClient(new URL(otpServerUrl).toURI());
			kycClient=new KYCClient(new URL(ekycServerUrl).toURI());
		
			
			authClient.setAsaLicenseKey(asaLicenseKey);
			bfdClient.setAsaLicenseKey(asaLicenseKey);
			otpClient.setAsaLicenseKey(asaLicenseKey);
			kycClient.setAsaLicenseKey(asaLicenseKey);

			authResponseValidator = new AuthResponseValidator(new SignatureVerifier(signatureVariferKey));
			
			auaDataCreator = new AuthAUADataCreator(new Encrypter(publicKeyFile), "YES".equalsIgnoreCase("No"));
			auaDataCreatorForBfd = new BfdAUADataCreator(new Encrypter(publicKeyFile), "YES".equalsIgnoreCase("yes"));

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	  

	private Map<FingerPosition, JLabel> getBFDPositionLabelMap() {
	        Map<FingerPosition, javax.swing.JLabel> fingerPosToLabelMap = new HashMap<FingerPosition, JLabel>();
	      
	        return fingerPosToLabelMap;
	    }

       


	
	/*private DeviceCollectedAuthData constructAuthRequest(String aadharNo,String aadhaarNumberId) {}*/
	
	private DeviceCollectedAuthData constructSeedingAuthRequest(Map<String, String> seedingParams) {
		DeviceCollectedAuthData request = new DeviceCollectedAuthData();


		String uid = seedingParams.get("uid");

		request.setUid(uid);
		request.setLanguage(null);
		

		String name = seedingParams.get("name");
		if ((name != null) && (name.length() > 0)) {
			request.setName(name);
		}

		request.setNameMatchStrategy(MatchingStrategy.P);
		

		String pinCode = seedingParams.get("pinCode");
		if ((pinCode != null) && (pinCode.length() > 0)) {
			request.setPinCode(pinCode);
		}


		String phoneNo = seedingParams.get("phoneNo");
		if ((phoneNo != null) && (phoneNo.length() > 0)) {
			request.setPhoneNo(phoneNo);
		}

		
		request.setGender("Male");

	

		String day = seedingParams.get("day");

		String month = seedingParams.get("month");

		String year = seedingParams.get("year");
		String dob = null;
		if ((year != null) && (year.length() > 0) && (month != null) && (month.length() > 0) && (day != null) && (day.length() > 0)) {
			dob = year + "-" + month + "-" + day;
		} else if ((year != null) && (year.length() > 0) && (month != null) && (month.length() > 0)) {
			dob = year + "-" + month + "-" + "";
		} else if ((year != null) && (year.length() > 0) && (day != null) && (day.length() > 0)) {
			dob = year + "-" + "" + "-" + day;
		} else if ((month != null) && (month.length() > 0) && (day != null) && (day.length() > 0)) {
			dob = "" + "-" + month + "-" + day;
		} else if ((month != null) && (month.length() > 0)) {
			dob = "" + "-" + month + "-" + "";
		} else if ((day != null) && (day.length() > 0)) {
			dob = "" + "-" + "" + "-" + day;
		} else if ((year != null) && (year.length() > 0)) {
			dob = year;
		}

		request.setDob(dob);

		Meta m = createSeedingMeta();
		request.setDeviceMetaData(m);
		
		return request;

	}

	public Meta createMeta() {
		Meta m = new Meta();
		/*m.setFdc("NC");
		m.setIdc("NA");
		m.setPip("127.0.0.1");
		m.setLot(LocationType.valueOf("P"));
		m.setLov("560103");*/
		m.setUdc(uDc);
		m.setRdsId("");
		m.setRdsVer("");
		m.setDpId("");
		m.setDc("");
		m.setMi("");
		m.setMc("");
		return m;
	}
	
	private Meta createSeedingMeta() {
		Meta m = new Meta();
		m.setFdc("NC");
		m.setPip("127.0.0.1");
		m.setLot(LocationType.valueOf("P"));
		m.setLov("560103");
		m.setUdc("EHL99999");
		return m;
	}

	public Map<String,Object> authenticateRequest(DeviceCollectedAuthData authData, boolean useProto,String dynamicPin) {
		Properties properties = new Properties();
	     URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("authclient.properties");
	     

		 try
	       {
	               properties.load(resourcePath.openStream());
	       }
	       catch (Exception e)
	       {
	               e.printStackTrace();
	       }
		
	       
		String terminalId=properties.getProperty("terminalId");
		String udc=properties.getProperty("udc");
		String pauaCode=properties.getProperty("auaCode");
		String serviceAgency=properties.getProperty("sa");
		String licenseKey=properties.getProperty("licenseKey");
		String asaLicenseKey=properties.getProperty("asaLicenseKey");
		
		
		boolean status=false;
		Map<String,Object> eKycResponseMap=null;
		try {
			//String pubkey="C://Users//hms//EhealthWorkSpace//Ehealth_Kerala_new_1//EHealthMVN//src//main//webapp//eKYC//uidai_auth_encrypt_preprodnew.cer";
			
			eKycResponseMap=new HashMap<String,Object>();
			Uses usesElement = createUsesElement();

			AuthDataFromDeviceToAUA auaData = null;
			if (useProto) {
				
				auaData = auaDataCreator.prepareAUAData(authData.getUid(), terminalId, authData.getDeviceMetaData(),
						PidCreator.createProtoPid(authData), DataType.P);
				
			} else {
				
				auaData = auaDataCreator.prepareAUAData(authData.getUid(), terminalId,  authData.getDeviceMetaData(),
						PidCreator.createXmlPid(authData), DataType.X);

			}

			Tkn token = null;
			/*if (StringUtils.isNotBlank(this.jTextFieldToken.getText())) {
				token = new Tkn();
				token.setValue(this.jTextFieldToken.getText());
				token.setType(tokenLabelToTokenTypeMap.get(this.jComboBoxTokenType.getSelectedItem()));
			}*/
			
			
			AuthRequestCreator authRequestCreator = new AuthRequestCreator();
			Auth auth = AuthRequestCreator.createAuthRequest(pauaCode, serviceAgency,
					licenseKey, usesElement, token, auaData, authData.getDeviceMetaData(),authData.getOtpTxn());
			
			AuthResponseDetails data=null;
			
			AuthRes authResult = null;
				
			
			kycClient.setMecLr(true,false);
			kycClient.setDe(false);
			kycClient.setPrf(true);
			String kycResponseXML = kycClient.kycTrans(auth,pauaCode,true,asaLicenseKey, usesElement,customKYCXML);
			
			eKycResponseMap=displayAuthResults(kycResponseXML, useProto);
			
	

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return eKycResponseMap;
	}
	
	
	

	private Uses createUsesElement() {
		
		Uses uses = new Uses();
		uses.setPi(UsesFlag.valueOf("N"));
		uses.setPa(UsesFlag.valueOf( "N"));
		uses.setPin(UsesFlag.valueOf( "N"));
		
			uses.setOtp(UsesFlag.valueOf( "Y"));

		
		uses.setBio(UsesFlag.valueOf( "N"));
		uses.setPfa(UsesFlag.valueOf( "N"));

		String biometricTypes = "";
		
		if (false) {
			biometricTypes += "FMR";
			uses.setBt(biometricTypes);
		}
		
		if (false) {
			if (StringUtils.isNotBlank(biometricTypes)) {
				biometricTypes += ",";
			}
			biometricTypes += "FIR";
			uses.setBt(biometricTypes);
		}
		
		if (false) {
			if (StringUtils.isNotBlank(biometricTypes)) {
				biometricTypes += ",";
			}
			biometricTypes += "IIR";
			uses.setBt(biometricTypes);
		}
		uses.setBt(biometricTypes);
		return uses;
	}

	
	private Map<String,Object> displayAuthResults(String kycResponseXML, boolean useProto)
			throws JAXBException {
		boolean ekycAuthenticateStatus=false;
		String resident_Name="";
		String dob="";
		String phone_no="";
		String email="";
		
		String care_of="";
		String house_no="";
		String Landmark="";
		String Locality="";
		String Vtc="";
		String sub_district="";
		String district="";
		String state="";
		String Pincode="";
		String postoffice="";
		String street="";
		String message="";
		
		Map<String,Object> eKycResponseMap=null;
		eKycResponseMap=new HashMap<String,Object>();
		KycRes kycRes = (KycRes) XMLUtilities.parseXML(KycRes.class,kycResponseXML);
				if (kycRes.getRet().toString().equals(AuthResult.Y.toString())) {
					ekycAuthenticateStatus=true;
					UidDataType uidData = kycRes.getUidData();
					
					
					GenderType gender;
					eKycResponseMap.put("ekycAuthenticateStatus", ekycAuthenticateStatus);
					if (uidData != null) {
						PoiType poi = uidData.getPoi();
						resident_Name=poi.getName();
						eKycResponseMap.put("resident_Name", resident_Name);
						Image image=null;
						byte[] imageBytes = uidData.getPht();
						System.out.println("imageBytes "+imageBytes.length);
						BufferedImage bufImage = null;
						try {
							if(bufImage==null)
							{
								//byte[] faceByteIso=Base64.decodeBase64(uidData.getPht());
								//System.out.println("faceByteIso "+faceByteIso.length);
								bufImage = ImageIO.read(new ByteArrayInputStream(
										imageBytes));
								image = bufImage.getScaledInstance(-1, 270,
										Image.SCALE_AREA_AVERAGING);
							}
							// this.image = Scalr.resize(bufImage, DEFAULT_IMAGE_SIZE);
							else {
								image = bufImage.getScaledInstance(-1, 270,
										Image.SCALE_AREA_AVERAGING);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						eKycResponseMap.put("imageBytes", imageBytes);
						eKycResponseMap.put("image", image);
						dob=poi.getDob();
						
						eKycResponseMap.put("dob", dob);
						
						gender=poi.getGender();
						
						
						eKycResponseMap.put("gender", ((Object)gender).toString());
						
						
						
						phone_no=poi.getPhone();
						
						eKycResponseMap.put("phone_no", phone_no);
						
						email=poi.getEmail();
						
						eKycResponseMap.put("email", email);
					//	LDataType ldataType = uidData.getLData();
						PoaType poa = uidData.getPoa();
						care_of=poa.getCo();
						
						eKycResponseMap.put("care_of",care_of);
						house_no=poa.getHouse();
						
						eKycResponseMap.put("house_no", house_no);
						
						Landmark=poa.getLm();
						
						eKycResponseMap.put("Landmark", Landmark);

						Locality=poa.getLc();
						
						eKycResponseMap.put("Locality", Locality);

						Vtc=poa.getVtc();
						
						eKycResponseMap.put("Vtc", Vtc);

						sub_district=poa.getSubdist();
						
						eKycResponseMap.put("sub_district", sub_district);

						district=poa.getDist();
						
						eKycResponseMap.put("district", district);
						
						state=poa.getState();
						
						eKycResponseMap.put("state", state);
						
						Pincode=poa.getPc();
						eKycResponseMap.put("Pincode", Pincode);
						
						postoffice=poa.getPo();
						eKycResponseMap.put("postoffice", postoffice);
						
						street=poa.getStreet();
						
						eKycResponseMap.put("street", street);
						
					}	
				} 
				else{
					if(kycRes.getErr().equalsIgnoreCase("K-100")){
					message="Resident authentication failed";
					}
					else if(kycRes.getErr().equalsIgnoreCase("K-200")){
						message="Resident data currently not available";
						}
					else if(kycRes.getErr().equalsIgnoreCase("K-552")){
						message="Invalid license key";
						}
					else if(kycRes.getErr().equalsIgnoreCase("K-999")){
						message="Unknown error";
						}
					else if(kycRes.getErr().equalsIgnoreCase("K-955")){
						message="Technical error";
						}
					else{
						
					}
					
					eKycResponseMap.put("message", message);
					eKycResponseMap.put("ekycAuthenticateStatus", ekycAuthenticateStatus);

				}
				

				return eKycResponseMap;
			}

	
	private void displayBFDResults(BfdRes bfdResult, boolean useProto) {
		updateBfdRanks(bfdResult);
		if (useProto) {
			//this.jLabelBFDStatusProto.setText("Proto: " + (bfdResult.getErr() != null ? "Error: " + bfdResult.getErr() + " - " : "")
				//	+ "Action: " + bfdResult.getActn() + " (" + bfdResult.getMsg() + ")");
		} else {
			//this.jLabelBFDStatusXML.setText("XML: " + (bfdResult.getErr() != null ? "Error: " + bfdResult.getErr() + " - " : "")
				//	+ "Action: " + bfdResult.getActn() + " (" + bfdResult.getMsg() + ")");
		}
	}

    private void updateBfdRanks(BfdRes bfdResult) {
        Map<FingerPosition, JLabel> fingerPosToLabelMap = getBFDPositionLabelMap();
        Ranks ranks = bfdResult.getRanks();
        if (ranks != null) {
            for (Rank r : ranks.getRank()) {
            	String text =  fingerPosToLabelMap.get(r.getPos()).getText();
            	if (StringUtils.isNotBlank(text)) {
            		text =  text + "/" + String.valueOf(r.getVal());
            	} else {
            		text = String.valueOf(r.getVal());
            	}
                fingerPosToLabelMap.get(r.getPos()).setText(text);
            }
        }
    }

      private void resetBfdRankAndResults() {
        Map<FingerPosition, JLabel> fingerPosToLabelMap = getBFDPositionLabelMap();
        for (JLabel jl : fingerPosToLabelMap.values()) {
            jl.setText(" ");
        }
        
		//jLabelBFDStatusXML.setText(" ");
		//jLabelBFDStatusProto.setText(" ");
    }
	
	private void fillAuthResponseValidationText(Auth auth, byte[] hashedDemoXML, AuthRes authResult, String responseXML) {
		ValidationResult result = this.authResponseValidator.validateAuthResponse(auth, hashedDemoXML, authResult, responseXML);
		//this.jTextAreaResponseValidationResult.setText(this.jTextAreaResponseValidationResult.getText() + "\n" + result.toString());
		if (!result.isDigitalSignatureVerified()) {
			/*JOptionPane.showMessageDialog(this, "Signature Verification Failed", "UID Authentication Demo Client",
					JOptionPane.ERROR_MESSAGE);*/
		}
	}

	
	private DeviceCollectedBfdData constructBfdRequest() {
		
		String uid = "";
		

		List<DeviceCollectedBfdData.BiometricData> listOfBiometrics = new ArrayList<DeviceCollectedBfdData.BiometricData>();
		if (this.bfdCaptures.size() > 0) {
			for (FingerPosition p : this.bfdCaptures.keySet()) {
				if (this.bfdCaptures.get(p) != null) {
					DeviceCollectedBfdData.BiometricData c = new DeviceCollectedBfdData.BiometricData(p, this.bfdCaptures.get(p).getIsoFeatureSet(), this.bfdCaptures.get(p).getNfiq());
					listOfBiometrics.add(c);
				}
			}
		}

		
		DeviceCollectedBfdData request = new DeviceCollectedBfdData(uid, listOfBiometrics, createMeta());
		return request;

	}
	
	
	private void performBfd(DeviceCollectedBfdData rbdData, boolean useProto) {
		try {


			BFDDataFromDeviceToAUA auaData = null;
			if (useProto) {
				auaData = auaDataCreatorForBfd.prepareAUAData(rbdData.getUid(), "EHL99999", rbdData.getDeviceMetaData(),
						RbdCreator.createProtoRbd(rbdData), in.gov.uidai.authentication.uid_bfd_request._1.DataType.P);
			} else {
				auaData = auaDataCreatorForBfd.prepareAUAData(rbdData.getUid(), "EHL99999",  rbdData.getDeviceMetaData(),
						RbdCreator.createXmlRbd(rbdData), in.gov.uidai.authentication.uid_bfd_request._1.DataType.X);
			}
			
			Bfd bfd = BfdRequestCreator.createBfdRequest("KSITMLAB", "GEHL845267",
					"ME", auaData, rbdData.getDeviceMetaData());

			BfdResponseDetails data = bfdClient.performBfd(bfd);
			BfdRes bfdResult = data.getBfdRes();

			if (bfdResult != null) {
				displayBFDResults(bfdResult, useProto);
			}

		} catch (Exception e) {
			//JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "UID Authentication Demo Client", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	
	/*public void drawFingerprintImage(Image image) {
		jLabelBiometric.setIcon(new ImageIcon(image.getScaledInstance(jLabelBiometric.getWidth(), jLabelBiometric.getHeight(),
				Image.SCALE_DEFAULT)));
	}*/

	public void addToCaptures(BiometricPosition p, BioMetricType biometricType, CaptureDetails d) {
		this.bioCaptures.add(new DeviceCollectedAuthData.BiometricData(p, biometricType, d.getIsoFeatureSet()));
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	private String getPreferredChannel() {
		String channel = "";
		
			channel = OtpDataFromDeviceToAUA.SMS_CHANNEL;
		
		return channel;
	}
	public Map<String,Object> sendOTPRequestActionPerformed(String AadhaarNo) {
		Map<String,Object> map=null;
		map=new HashMap<String,Object>();
		
		boolean status=true;
		String message="";
		String channel = getPreferredChannel();

		OtpDataFromDeviceToAUA auaData = new OtpDataFromDeviceToAUA(AadhaarNo, "EHL99999", channel);

		OtpRequestCreator requestCreator = new OtpRequestCreator();
		Otp otp = requestCreator.createOtpRequest("GEHL", "GEHL845267","ME", auaData);
		try {
			String otpTxn="";
			OtpRes res = otpClient.generateOtp(otp).getOtpRes();
			String retst="";
			if(null !=res.getRet())
			 retst=res.getRet().toString();
			System.out.println(res.getRet()+"===Response=="+res.getCode());
			otpTxn=res.getTxn().toString();
			if (null !=res.getRet() && !retst.equals("") && retst.equals("N") || retst.equals("n")) {
				if(res.getErr().equalsIgnoreCase("998")){
					message="Ensure you have entered correct Aadhaar number.  Please retry with correct Aadhaar number";
				}
				else if(res.getErr().equalsIgnoreCase("999")){
					message="Technical Exception ";
				}
				else if(res.getErr().equalsIgnoreCase("997")){
					message="Your Aadhaar number status is not active. Kindly contact UIDAI Helpline. ";
				}
				else if(res.getErr().equalsIgnoreCase("112")){
					message="Aadhaar number does not have both email and mobile.. ";
				}
				else if(res.getErr().equalsIgnoreCase("110")){
					message="Aadhaar number does not have verified mobile/email.. ";
				}
				else if(res.getErr().equalsIgnoreCase("111")){
					message="Aadhaar number does not have verified mobile ";
				}
				else if(res.getErr().equalsIgnoreCase("521")){
					message="Aadhaar number does not have verified mobile ";
				}
				else if(res.getErr().equalsIgnoreCase("950")){
					message="Could not generate and/or send OTP ";
				}
				
				else{
					message="Technical Exception ";
				}
				status=false;
				
				map.put("status", status);
				map.put("message", message);
				
				
			} 
			else if(null == res.getRet() ){
				status=false;
				message="cidr Server not reachable";
				map.put("status", status);
				map.put("message", message);
			}
			else {
				
				System.out.println("otpTxn ="+otpTxn);
				map.put("otpTxn", otpTxn);
				map.put("status", status);
				map.put("message", message);
				System.out.println("ok OTP GENERATED");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}
	
   
}
	


     

