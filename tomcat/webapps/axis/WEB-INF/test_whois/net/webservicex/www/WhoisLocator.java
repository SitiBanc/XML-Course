/**
 * WhoisLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.webservicex.www;

public class WhoisLocator extends org.apache.axis.client.Service implements net.webservicex.www.Whois {

    public WhoisLocator() {
    }


    public WhoisLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WhoisLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for whoisSoap12
    private java.lang.String whoisSoap12_address = "http://www.webservicex.net/whois.asmx";

    public java.lang.String getwhoisSoap12Address() {
        return whoisSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String whoisSoap12WSDDServiceName = "whoisSoap12";

    public java.lang.String getwhoisSoap12WSDDServiceName() {
        return whoisSoap12WSDDServiceName;
    }

    public void setwhoisSoap12WSDDServiceName(java.lang.String name) {
        whoisSoap12WSDDServiceName = name;
    }

    public net.webservicex.www.WhoisSoap getwhoisSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(whoisSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwhoisSoap12(endpoint);
    }

    public net.webservicex.www.WhoisSoap getwhoisSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.webservicex.www.WhoisSoap12Stub _stub = new net.webservicex.www.WhoisSoap12Stub(portAddress, this);
            _stub.setPortName(getwhoisSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwhoisSoap12EndpointAddress(java.lang.String address) {
        whoisSoap12_address = address;
    }


    // Use to get a proxy class for whoisSoap
    private java.lang.String whoisSoap_address = "http://www.webservicex.net/whois.asmx";

    public java.lang.String getwhoisSoapAddress() {
        return whoisSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String whoisSoapWSDDServiceName = "whoisSoap";

    public java.lang.String getwhoisSoapWSDDServiceName() {
        return whoisSoapWSDDServiceName;
    }

    public void setwhoisSoapWSDDServiceName(java.lang.String name) {
        whoisSoapWSDDServiceName = name;
    }

    public net.webservicex.www.WhoisSoap getwhoisSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(whoisSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwhoisSoap(endpoint);
    }

    public net.webservicex.www.WhoisSoap getwhoisSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.webservicex.www.WhoisSoapStub _stub = new net.webservicex.www.WhoisSoapStub(portAddress, this);
            _stub.setPortName(getwhoisSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwhoisSoapEndpointAddress(java.lang.String address) {
        whoisSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.webservicex.www.WhoisSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                net.webservicex.www.WhoisSoap12Stub _stub = new net.webservicex.www.WhoisSoap12Stub(new java.net.URL(whoisSoap12_address), this);
                _stub.setPortName(getwhoisSoap12WSDDServiceName());
                return _stub;
            }
            if (net.webservicex.www.WhoisSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                net.webservicex.www.WhoisSoapStub _stub = new net.webservicex.www.WhoisSoapStub(new java.net.URL(whoisSoap_address), this);
                _stub.setPortName(getwhoisSoapWSDDServiceName());
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
        if ("whoisSoap12".equals(inputPortName)) {
            return getwhoisSoap12();
        }
        else if ("whoisSoap".equals(inputPortName)) {
            return getwhoisSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.webservicex.net", "whois");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.webservicex.net", "whoisSoap12"));
            ports.add(new javax.xml.namespace.QName("http://www.webservicex.net", "whoisSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("whoisSoap12".equals(portName)) {
            setwhoisSoap12EndpointAddress(address);
        }
        else 
if ("whoisSoap".equals(portName)) {
            setwhoisSoapEndpointAddress(address);
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
