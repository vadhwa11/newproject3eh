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
package in.gov.uidai.auth.aua.helper;

import in.gov.uidai.auth.device.model.OtpDataFromDeviceToAUA;
import in.gov.uidai.authentication.otp._1.Ch;
import in.gov.uidai.authentication.otp._1.Opts;
import in.gov.uidai.authentication.otp._1.Otp;
import in.gov.uidai.authentication.uid_auth_request._1.Auth;
import in.gov.uidai.authentication.uid_auth_request._1.DeviceId;
import in.gov.uidai.authentication.uid_auth_request._1.ReqType;
import in.gov.uidai.authentication.uid_auth_request._1.SubAUACode;
import in.gov.uidai.authentication.uid_auth_request._1.Txn;
import in.gov.uidai.authentication.uid_auth_request._1.UID;
import in.gov.uidai.authentication.uid_auth_request._1.Ver;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * This class provides a method to generate the Otp request object
 * using information that has been received from Otp client and using the information that
 * is available with AUA.
 *  
 * @author UIDAI
 *
 */
public class OtpRequestCreator {

	/**
	 * Constructor
	 * @param aua AUA code
	 * @param saSub AUA code
	 * @param licenseKey License key
	 * @param token Token element, typically used for authentication requests received over mobile networks.
	 * @param auaData Data received from otp client.
	 * @return Instance of {@link Auth}
	 */
	public Otp createOtpRequest(String aua, String sa, String licenseKey, OtpDataFromDeviceToAUA auaData) {

		try {

			Otp otpReq = new Otp();
			
			UID uid = new UID();
			uid.setValue(auaData.getUid());
			otpReq.setUid(uid);
			Ver ver = new Ver();
			ver.setValue("1.6");
			otpReq.setVer(ver);
			
			//otpReq.setUid(auaData.getUid());

			//otpReq.setVer("1.5");
			
			Txn txn = new Txn();
			String txnVal = createTxn(aua);
			txn.setValue(txnVal);
			otpReq.setTxn(txn);

			SubAUACode subAUACode = new SubAUACode();
			subAUACode.setValue("GEHL845267");
			otpReq.setSubAUACode(subAUACode);
			
			ReqType reqType = new ReqType();
			reqType.setValue("otp");
			otpReq.setReqType(reqType);
			
			DeviceId deviceId = new DeviceId();
			deviceId.setValue(auaData.getTerminalId());
			otpReq.setDeviceId(deviceId);
			
			Ch ch = new Ch();
			ch.setValue("01");
			otpReq.setCh(ch);
			
			
			/*otpReq.setAc(aua);
			otpReq.setSa(sa);

			String txn = createTxn(aua);
			otpReq.setTxn(txn);

			otpReq.setLk(licenseKey);
			otpReq.setTid(auaData.getTerminalId());
			
			
			if (StringUtils.isNotBlank(auaData.getChannel())) {
				Opts c = new Opts();
				c.setCh(auaData.getChannel());
				otpReq.setOpts(c);
			}*/
			
			return otpReq;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Method to construct transaction code based on AUA code and current time.
	 * @param aua AUA code
	 * @return String representing transaction code.
	 */
	private String createTxn(String aua) {
		//changed by govind 20-10-2017
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		//String txn = "AuthDemoClient" + ":" + aua + ":" + dateFormat.format(new Date());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String txn = "EHL" + ":" + dateFormat.format(new Date());
		//changed by govind 20-10-2017 end
		return txn;
	}

}
