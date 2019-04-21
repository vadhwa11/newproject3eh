
package com.jkt.entities.indentkmcl;

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
 *         &lt;element name="item" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.jkt.com/entities/indentkmcl}IndentList"/>
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
    "item",
    "indentList"
})
@XmlRootElement(name = "IndentListResponseType")
public class IndentListResponseType {

    @XmlElement(required = true)
    protected String item;
    @XmlElement(name = "IndentList", required = true)
    protected IndentList indentList;

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItem(String value) {
        this.item = value;
    }

    /**
     * Gets the value of the indentList property.
     * 
     * @return
     *     possible object is
     *     {@link IndentList }
     *     
     */
    public IndentList getIndentList() {
        return indentList;
    }

    /**
     * Sets the value of the indentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndentList }
     *     
     */
    public void setIndentList(IndentList value) {
        this.indentList = value;
    }

}
