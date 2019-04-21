//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.08 at 03:19:01 PM IST 
//


package in.gov.uidai.authentication.uid_bfd_request._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import in.gov.uidai.authentication.common.types._1.Meta;


/**
 * <p>Java class for Bfd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Bfd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Meta" type="{http://www.uidai.gov.in/authentication/common/types/1.0}Meta"/>
 *         &lt;element name="Skey" type="{http://www.uidai.gov.in/authentication/uid-bfd-request/1.0}Skey"/>
 *         &lt;element name="Data">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>base64Binary">
 *                 &lt;attribute name="type" type="{http://www.uidai.gov.in/authentication/uid-bfd-request/1.0}DataType" default="X" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Hmac" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="uid" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}uid" />
 *       &lt;attribute name="ac" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}AuaCode" />
 *       &lt;attribute name="tid" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}Tid" />
 *       &lt;attribute name="ver" type="{http://www.uidai.gov.in/authentication/common/types/1.0}Ver" />
 *       &lt;attribute name="txn" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}Txn" />
 *       &lt;attribute name="lk" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}LicenseKey" />
 *       &lt;attribute name="sa" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}AuaCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bfd", propOrder = {
    "meta",
    "skey",
    "data",
    "hmac"
})
public class Bfd {

    @XmlElement(name = "Meta", required = true)
    protected Meta meta;
    @XmlElement(name = "Skey", required = true)
    protected Skey skey;
    @XmlElement(name = "Data", required = true)
    protected Bfd.Data data;
    @XmlElement(name = "Hmac")
    protected byte[] hmac;
    @XmlAttribute(name = "uid", required = true)
    protected String uid;
    @XmlAttribute(name = "ac", required = true)
    protected String ac;
    @XmlAttribute(name = "tid", required = true)
    protected String tid;
    @XmlAttribute(name = "ver")
    protected String ver;
    @XmlAttribute(name = "txn", required = true)
    protected String txn;
    @XmlAttribute(name = "lk", required = true)
    protected String lk;
    @XmlAttribute(name = "sa", required = true)
    protected String sa;

    /**
     * Gets the value of the meta property.
     * 
     * @return
     *     possible object is
     *     {@link Meta }
     *     
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     * Sets the value of the meta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Meta }
     *     
     */
    public void setMeta(Meta value) {
        this.meta = value;
    }

    /**
     * Gets the value of the skey property.
     * 
     * @return
     *     possible object is
     *     {@link Skey }
     *     
     */
    public Skey getSkey() {
        return skey;
    }

    /**
     * Sets the value of the skey property.
     * 
     * @param value
     *     allowed object is
     *     {@link Skey }
     *     
     */
    public void setSkey(Skey value) {
        this.skey = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link Bfd.Data }
     *     
     */
    public Bfd.Data getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bfd.Data }
     *     
     */
    public void setData(Bfd.Data value) {
        this.data = value;
    }

    /**
     * Gets the value of the hmac property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getHmac() {
        return hmac;
    }

    /**
     * Sets the value of the hmac property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setHmac(byte[] value) {
        this.hmac = ((byte[]) value);
    }

    /**
     * Gets the value of the uid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * Gets the value of the ac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAc() {
        return ac;
    }

    /**
     * Sets the value of the ac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAc(String value) {
        this.ac = value;
    }

    /**
     * Gets the value of the tid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTid() {
        return tid;
    }

    /**
     * Sets the value of the tid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTid(String value) {
        this.tid = value;
    }

    /**
     * Gets the value of the ver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVer() {
        return ver;
    }

    /**
     * Sets the value of the ver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVer(String value) {
        this.ver = value;
    }

    /**
     * Gets the value of the txn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxn() {
        return txn;
    }

    /**
     * Sets the value of the txn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxn(String value) {
        this.txn = value;
    }

    /**
     * Gets the value of the lk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLk() {
        return lk;
    }

    /**
     * Sets the value of the lk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLk(String value) {
        this.lk = value;
    }

    /**
     * Gets the value of the sa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSa() {
        return sa;
    }

    /**
     * Sets the value of the sa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSa(String value) {
        this.sa = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>base64Binary">
     *       &lt;attribute name="type" type="{http://www.uidai.gov.in/authentication/uid-bfd-request/1.0}DataType" default="X" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Data {

        @XmlValue
        protected byte[] value;
        @XmlAttribute(name = "type")
        protected DataType type;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setValue(byte[] value) {
            this.value = ((byte[]) value);
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link DataType }
         *     
         */
        public DataType getType() {
            if (type == null) {
                return DataType.X;
            } else {
                return type;
            }
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link DataType }
         *     
         */
        public void setType(DataType value) {
            this.type = value;
        }

    }

}
