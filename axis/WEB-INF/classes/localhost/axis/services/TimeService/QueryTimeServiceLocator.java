/**
 * QueryTimeServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.axis.services.TimeService;

public class QueryTimeServiceLocator extends org.apache.axis.client.Service implements localhost.axis.services.TimeService.QueryTimeService {

    public QueryTimeServiceLocator() {
    }


    public QueryTimeServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public QueryTimeServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TimeService
    private java.lang.String TimeService_address = "http://localhost:8080/axis/services/TimeService";

    public java.lang.String getTimeServiceAddress() {
        return TimeService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TimeServiceWSDDServiceName = "TimeService";

    public java.lang.String getTimeServiceWSDDServiceName() {
        return TimeServiceWSDDServiceName;
    }

    public void setTimeServiceWSDDServiceName(java.lang.String name) {
        TimeServiceWSDDServiceName = name;
    }

    public localhost.axis.services.TimeService.QueryTime getTimeService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TimeService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTimeService(endpoint);
    }

    public localhost.axis.services.TimeService.QueryTime getTimeService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.axis.services.TimeService.TimeServiceSoapBindingStub _stub = new localhost.axis.services.TimeService.TimeServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getTimeServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTimeServiceEndpointAddress(java.lang.String address) {
        TimeService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.axis.services.TimeService.QueryTime.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.axis.services.TimeService.TimeServiceSoapBindingStub _stub = new localhost.axis.services.TimeService.TimeServiceSoapBindingStub(new java.net.URL(TimeService_address), this);
                _stub.setPortName(getTimeServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TimeService".equals(inputPortName)) {
            return getTimeService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/axis/services/TimeService", "QueryTimeService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/axis/services/TimeService", "TimeService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TimeService".equals(portName)) {
            setTimeServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
