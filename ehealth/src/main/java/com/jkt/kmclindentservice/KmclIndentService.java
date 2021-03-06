package com.jkt.kmclindentservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2015-11-19T16:52:34.128+05:30
 * Generated source version: 3.0.2
 * 
 */
@WebServiceClient(name = "KmclIndentService", 
                  wsdlLocation = "file:/D:/New-Spring_Proj/EHealth/src/main/resources/hms/jkt/service/KmclIndentService.wsdl",
                  targetNamespace = "http://www.jkt.com/KmclIndentService/") 
public class KmclIndentService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.jkt.com/KmclIndentService/", "KmclIndentService");
    public final static QName KmclIndentServiceSOAP = new QName("http://www.jkt.com/KmclIndentService/", "KmclIndentServiceSOAP");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/New-Spring_Proj/EHealth/src/main/resources/hms/jkt/service/KmclIndentService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(KmclIndentService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/D:/New-Spring_Proj/EHealth/src/main/resources/hms/jkt/service/KmclIndentService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public KmclIndentService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public KmclIndentService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public KmclIndentService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public KmclIndentService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public KmclIndentService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public KmclIndentService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns IKmclIndentService
     */
    @WebEndpoint(name = "KmclIndentServiceSOAP")
    public IKmclIndentService getKmclIndentServiceSOAP() {
        return super.getPort(KmclIndentServiceSOAP, IKmclIndentService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IKmclIndentService
     */
    @WebEndpoint(name = "KmclIndentServiceSOAP")
    public IKmclIndentService getKmclIndentServiceSOAP(WebServiceFeature... features) {
        return super.getPort(KmclIndentServiceSOAP, IKmclIndentService.class, features);
    }

}
