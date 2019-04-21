//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.26 at 02:41:27 PM IST 
//


package in.gov.uidai.authentication.otp._1;

import in.gov.uidai.authentication.uid_auth_request._1.DeviceId;
import in.gov.uidai.authentication.uid_auth_request._1.ReqType;
import in.gov.uidai.authentication.uid_auth_request._1.SubAUACode;
import in.gov.uidai.authentication.uid_auth_request._1.Txn;
import in.gov.uidai.authentication.uid_auth_request._1.UID;
import in.gov.uidai.authentication.uid_auth_request._1.Ver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Otp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Otp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Opts" type="{http://www.uidai.gov.in/authentication/otp/1.0}Opts" minOccurs="0"/>
 *         &lt;element name="Tkn" type="{http://www.uidai.gov.in/authentication/otp/1.0}Tkn" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}uid" />
 *       &lt;attribute name="tid" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}Tid" />
 *       &lt;attribute name="ac" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}AuaCode" />
 *       &lt;attribute name="sa" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}AuaCode" />
 *       &lt;attribute name="ver" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}Ver" />
 *       &lt;attribute name="txn" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}Txn" />
 *       &lt;attribute name="lk" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}LicenseKey" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
/*@XmlType(name = "Otp", propOrder = {
    "opts",
    "tkn"
})*/

@XmlType(name = "Otp", propOrder = {
		"ver",
	    "subAUACode",
	    "txn",
	    "reqType",	
	    "deviceId",    
	    "uid",
	    "ch"
	})
public class Otp {

   /* @XmlElement(name = "Opts")
    protected Opts opts;
    @XmlElement(name = "Tkn")
    protected Tkn tkn;
    @XmlAttribute(required = true)
    protected String uid;
    @XmlAttribute(required = true)
    protected String tid;
    @XmlAttribute(required = true)
    protected String ac;
    @XmlAttribute(required = true)
    protected String sa;
    @XmlAttribute(required = true)
    protected String ver;
    @XmlAttribute(required = true)
    protected String txn;
    @XmlAttribute(required = true)
    protected String lk;*/
	
	@XmlElement(name = "Txn")
    protected Txn txn;
	@XmlElement(name = "Ver")
    protected Ver ver;
	@XmlElement(name = "SubAUACode")
    protected SubAUACode subAUACode;
	@XmlElement(name = "ReqType")
    protected ReqType reqType;
    @XmlElement(name = "DeviceId")
    protected DeviceId deviceId;
    @XmlElement(name = "UID")
    protected UID uid;
    @XmlElement(name = "Ch")
    protected Ch ch;
    
    
    
	public Txn getTxn() {
		return txn;
	}
	public void setTxn(Txn txn) {
		this.txn = txn;
	}
	public Ver getVer() {
		return ver;
	}
	public void setVer(Ver ver) {
		this.ver = ver;
	}
	public SubAUACode getSubAUACode() {
		return subAUACode;
	}
	public void setSubAUACode(SubAUACode subAUACode) {
		this.subAUACode = subAUACode;
	}
	public ReqType getReqType() {
		return reqType;
	}
	public void setReqType(ReqType reqType) {
		this.reqType = reqType;
	}
	public DeviceId getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(DeviceId deviceId) {
		this.deviceId = deviceId;
	}
	public UID getUid() {
		return uid;
	}
	public void setUid(UID uid) {
		this.uid = uid;
	}
	public Ch getCh() {
		return ch;
	}
	public void setCh(Ch ch) {
		this.ch = ch;
	}

    

}
