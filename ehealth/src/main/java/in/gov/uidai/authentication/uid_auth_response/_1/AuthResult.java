//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.08 at 03:19:01 PM IST 
//


package in.gov.uidai.authentication.uid_auth_response._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthResult.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuthResult">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="y"/>
 *     &lt;enumeration value="n"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuthResult")
@XmlEnum
public enum AuthResult {

    @XmlEnumValue("y")
    Y("y"),
    @XmlEnumValue("n")
    N("n");
    private final String value;

    AuthResult(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AuthResult fromValue(String v) {
        for (AuthResult c: AuthResult.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}