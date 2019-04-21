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
package in.gov.uidai.auth.device.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import java.io.UnsupportedEncodingException;
/**
 * This class provides utility methods that can be used for
 * encryption of various data as per the UIDAI Authentication API.
 * 
 * It uses <a href="http://www.bouncycastle.org/">Bouncy Castle APIs</a>. 
 * 
 * @author UIDAI
 *
 */
public final class Encrypter {
	private static final String JCE_PROVIDER = "BC";

	private static final String ASYMMETRIC_ALGO = "RSA/ECB/PKCS1Padding";
	private static final int SYMMETRIC_KEY_SIZE = 256;

	private static final String CERTIFICATE_TYPE = "X.509";

	private PublicKey publicKey;
	private Date certExpiryDate;
	public static final int IV_SIZE_BITS = 96;
	public static final int AAD_SIZE_BITS = 128;
	// Authentication tag length - in bits
	public static final int AUTH_TAG_SIZE_BITS = 128;
	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	/**
	 * Constructor
	 * @param publicKeyFileName Location of UIDAI public key file (.cer file)
	 */
	public Encrypter(String publicKeyFileName) {
		FileInputStream fileInputStream = null;
		try {
			CertificateFactory certFactory = CertificateFactory.getInstance(CERTIFICATE_TYPE, JCE_PROVIDER);
			fileInputStream = new FileInputStream(new File(publicKeyFileName));
			X509Certificate cert = (X509Certificate) certFactory.generateCertificate(fileInputStream);
			publicKey = cert.getPublicKey();
			certExpiryDate = cert.getNotAfter();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Could not intialize encryption module", e);
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Creates a AES key that can be used as session key (skey)
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 */
	public byte[] generateSessionKey() throws NoSuchAlgorithmException, NoSuchProviderException {
		KeyGenerator kgen = KeyGenerator.getInstance("AES", JCE_PROVIDER);
		kgen.init(SYMMETRIC_KEY_SIZE);
		SecretKey key = kgen.generateKey();
		byte[] symmKey = key.getEncoded();
		return symmKey;
	}

	/**
	 * Encrypts given data using UIDAI public key
	 * @param data Data to encrypt
	 * @return Encrypted data
	 * @throws IOException
	 * @throws GeneralSecurityException
	 */
	public byte[] encryptUsingPublicKey(byte[] data) throws IOException, GeneralSecurityException {
		// encrypt the session key with the public key
		Cipher pkCipher = Cipher.getInstance(ASYMMETRIC_ALGO, JCE_PROVIDER);
		pkCipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encSessionKey = pkCipher.doFinal(data);
		return encSessionKey;
	}

	/**
	 * Encrypts given data using session key
	 * @param skey Session key
	 * @param data Data to encrypt
	 * @return Encrypted data
	 * @throws InvalidCipherTextException
	 */
	public byte[] encryptUsingSessionKey(byte[] skey, byte[] data) throws InvalidCipherTextException {
		PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new AESEngine(), new PKCS7Padding());

		cipher.init(true, new KeyParameter(skey));

		int outputSize = cipher.getOutputSize(data.length);

		byte[] tempOP = new byte[outputSize];
		int processLen = cipher.processBytes(data, 0, data.length, tempOP, 0);
		int outputLen = cipher.doFinal(tempOP, processLen);

		byte[] result = new byte[processLen + outputLen];
		System.arraycopy(tempOP, 0, result, 0, result.length);
		return result;

	}
	//added by govind 20-10-2017
	public byte[] encryptUsingSessionKey(byte[] skey, byte[] data, String tStamp) throws InvalidCipherTextException {
        byte[] tsBytes = null;
        try {
            tsBytes = tStamp.getBytes("UTF-8");
            //System.out.println(tStamp);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] ivBytes = new byte[IV_SIZE_BITS / 8];
        byte[] aadBytes = new byte[AAD_SIZE_BITS / 8];

        System.arraycopy(tsBytes, tsBytes.length - 12, ivBytes, 0, ivBytes.length);
        System.arraycopy(tsBytes, tsBytes.length - 16, aadBytes, 0, aadBytes.length);

        AEADParameters aeadParam = new AEADParameters(new KeyParameter(skey), AUTH_TAG_SIZE_BITS, ivBytes, aadBytes);
        GCMBlockCipher gcmb = new GCMBlockCipher(new AESEngine());
        gcmb.init(true, aeadParam);
        int outputSize = gcmb.getOutputSize(data.length);
        byte[] result = new byte[outputSize];
        int processLen = gcmb.processBytes(data, 0, data.length, result, 0);
        gcmb.doFinal(result, processLen);
        byte[] packedCipherData = new byte[result.length + tsBytes.length];
        System.arraycopy(tsBytes, 0, packedCipherData, 0, tsBytes.length);
        System.arraycopy(result, 0, packedCipherData, tsBytes.length, result.length);
        return packedCipherData;
    }

	public byte[] encryptUsingSessionKeyNoAdd(byte[] skey, byte[] data, String tStamp) throws InvalidCipherTextException {
        byte[] tsBytes = null;
        try {
            tsBytes = tStamp.getBytes("UTF-8");
            //System.out.println(tStamp);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] ivBytes = new byte[IV_SIZE_BITS / 8];
        byte[] aadBytes = new byte[AAD_SIZE_BITS / 8];

        System.arraycopy(tsBytes, tsBytes.length - 12, ivBytes, 0, ivBytes.length);
        System.arraycopy(tsBytes, tsBytes.length - 16, aadBytes, 0, aadBytes.length);

        AEADParameters aeadParam = new AEADParameters(new KeyParameter(skey), AUTH_TAG_SIZE_BITS, ivBytes, aadBytes);
        GCMBlockCipher gcmb = new GCMBlockCipher(new AESEngine());
        gcmb.init(true, aeadParam);
        int outputSize = gcmb.getOutputSize(data.length);
        byte[] result = new byte[outputSize];
        int processLen = gcmb.processBytes(data, 0, data.length, result, 0);
        gcmb.doFinal(result, processLen);
        //byte[] packedCipherData = new byte[result.length + tsBytes.length];
        //System.arraycopy(tsBytes, 0, packedCipherData, 0, tsBytes.length);
        //System.arraycopy(result, 0, packedCipherData, tsBytes.length, result.length);
        return result;
    }
	public byte[] encrypt(String key, String initVector, String value) {
		byte[] encrypted=null;
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

           encrypted = cipher.doFinal(value.getBytes());
//            System.out.println("encrypted string: "
//                    + Base64.encodeBase64String(encrypted));

            //return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return encrypted;
    }
	//added by govind 20-10-2017 end
	
	/**
	 * Returns UIDAI certificate's expiry date in YYYYMMDD format using GMT time zone. 
	 * It can be used as certificate identifier
	 * @return Certificate identifier for UIDAI public certificate
	 */
	public String getCertificateIdentifier() {
		SimpleDateFormat ciDateFormat = new SimpleDateFormat("yyyyMMdd");
		ciDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		String certificateIdentifier = ciDateFormat.format(this.certExpiryDate);
		return certificateIdentifier;
	}
}
