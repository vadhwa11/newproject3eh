package com.jkt.services.indentservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2015-10-26T18:33:14.040+05:30
 * Generated source version: 3.0.2
 * 
 */
@WebServiceClient(name = "IndentService", 
                  wsdlLocation = "file:/D:/New-Spring_Proj/EHealth/src/main/resources/hms/jkt/service/IndentService.wsdl",
                  targetNamespace = "http://www.jkt.com/services/IndentService/") 
public class IndentService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.jkt.com/services/IndentService/", "IndentService");
    public final static QName IndentService = new QName("http://www.jkt.com/services/IndentService/", "IndentService");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/New-Spring_Proj/EHealth/src/main/resources/hms/jkt/service/IndentService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(IndentService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/D:/New-Spring_Proj/EHealth/src/main/resources/hms/jkt/service/IndentService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public IndentService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public IndentService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IndentService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public IndentService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public IndentService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public IndentService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns IIndentService
     */
    @WebEndpoint(name = "IndentService")
    public IIndentService getIndentService() {
        return super.getPort(IndentService, IIndentService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IIndentService
     */
    @WebEndpoint(name = "IndentService")
    public IIndentService getIndentService(WebServiceFeature... features) {
        return super.getPort(IndentService, IIndentService.class, features);
    }

}