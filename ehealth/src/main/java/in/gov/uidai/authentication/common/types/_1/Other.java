//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.08 at 03:19:01 PM IST 
//


package in.gov.uidai.authentication.common.types._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Meta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Meta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="udc" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="20"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="pip" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="60"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="fdc" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="10"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="idc" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="10"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="lot" use="required" type="{http://www.uidai.gov.in/authentication/common/types/1.0}LocationType" />
 *       &lt;attribute name="lov" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="50"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Other")
public class Other {

    @XmlAttribute(name = "udt1", required = true)
    protected String udt1;
    @XmlAttribute(name = "udt2", required = true)
    protected String udt2;
    @XmlAttribute(name = "udt3", required = true)
    protected String udt3;
    @XmlAttribute(name = "adt1", required = true)
    protected String adt1;
    @XmlAttribute(name = "adt2", required = true)
    protected String adt2;
    @XmlAttribute(name = "adt3", required = true)
    protected String adt3;
	public String getUdt1() {
		return udt1;
	}
	public void setUdt1(String udt1) {
		this.udt1 = udt1;
	}
	public String getUdt2() {
		return udt2;
	}
	public void setUdt2(String udt2) {
		this.udt2 = udt2;
	}
	public String getUdt3() {
		return udt3;
	}
	public void setUdt3(String udt3) {
		this.udt3 = udt3;
	}
	public String getAdt1() {
		return adt1;
	}
	public void setAdt1(String adt1) {
		this.adt1 = adt1;
	}
	public String getAdt2() {
		return adt2;
	}
	public void setAdt2(String adt2) {
		this.adt2 = adt2;
	}
	public String getAdt3() {
		return adt3;
	}
	public void setAdt3(String adt3) {
		this.adt3 = adt3;
	}
    
  }
