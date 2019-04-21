
package com.jkt.services.indentservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.2
 * 2015-10-26T18:33:13.994+05:30
 * Generated source version: 3.0.2
 */

@WebFault(name = "BusinessFaultType", targetNamespace = "http://www.jkt.com/entities/indent")
public class BusinessException extends Exception {
    
    private com.jkt.entities.indent.BusinessFaultType businessFaultType;

    public BusinessException() {
        super();
    }
    
    public BusinessException(String message) {
        super(message);
    }
    
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, com.jkt.entities.indent.BusinessFaultType businessFaultType) {
        super(message);
        this.businessFaultType = businessFaultType;
    }

    public BusinessException(String message, com.jkt.entities.indent.BusinessFaultType businessFaultType, Throwable cause) {
        super(message, cause);
        this.businessFaultType = businessFaultType;
    }

    public com.jkt.entities.indent.BusinessFaultType getFaultInfo() {
        return this.businessFaultType;
    }
}