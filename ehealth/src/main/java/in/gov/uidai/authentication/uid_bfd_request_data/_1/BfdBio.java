//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.08 at 03:19:01 PM IST 
//


package in.gov.uidai.authentication.uid_bfd_request_data._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import in.gov.uidai.authentication.common.types._1.FingerPosition;


/**
 * <p>Java class for BfdBio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BfdBio">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>base64Binary">
 *       &lt;attribute name="nfiq" type="{http://www.uidai.gov.in/authentication/uid-bfd-request-data/1.0}Nfiq" />
 *       &lt;attribute name="na" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="pos" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}FingerPosition" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BfdBio", propOrder = {
    "value"
})
public class BfdBio {

    @XmlValue
    protected byte[] value;
    @XmlAttribute(name = "nfiq")
    protected Integer nfiq;
    @XmlAttribute(name = "na")
    protected Integer na;
    @XmlAttribute(name = "pos", required = true)
    protected FingerPosition pos;

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
     * Gets the value of the nfiq property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNfiq() {
        return nfiq;
    }

    /**
     * Sets the value of the nfiq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNfiq(Integer value) {
        this.nfiq = value;
    }

    /**
     * Gets the value of the na property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNa() {
        return na;
    }

    /**
     * Sets the value of the na property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNa(Integer value) {
        this.na = value;
    }

    /**
     * Gets the value of the pos property.
     * 
     * @return
     *     possible object is
     *     {@link FingerPosition }
     *     
     */
    public FingerPosition getPos() {
        return pos;
    }

    /**
     * Sets the value of the pos property.
     * 
     * @param value
     *     allowed object is
     *     {@link FingerPosition }
     *     
     */
    public void setPos(FingerPosition value) {
        this.pos = value;
    }

}
