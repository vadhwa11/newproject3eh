
package com.jkt.entities.indent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instituteId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="indentNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "instituteId",
    "indentNo"
})
@XmlRootElement(name = "IndentListRequestType")
public class IndentListRequestType {

    @XmlElement(required = true)
    protected String instituteId;
    @XmlElement(required = true)
    protected String indentNo;

    /**
     * Gets the value of the instituteId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstituteId() {
        return instituteId;
    }

    /**
     * Sets the value of the instituteId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstituteId(String value) {
        this.instituteId = value;
    }

    /**
     * Gets the value of the indentNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndentNo() {
        return indentNo;
    }

    /**
     * Sets the value of the indentNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndentNo(String value) {
        this.indentNo = value;
    }

}
