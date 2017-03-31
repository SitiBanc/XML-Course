/**
 * WorkerServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.axis.services.ObjectService;

public class WorkerServiceServiceLocator extends org.apache.axis.client.Service implements localhost.axis.services.ObjectService.WorkerServiceService {

    public WorkerServiceServiceLocator() {
    }


    public WorkerServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WorkerServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ObjectService
    private java.lang.String ObjectService_address = "http://localhost:8080/axis/services/ObjectService";

    public java.lang.String getObjectServiceAddress() {
        return ObjectService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ObjectServiceWSDDServiceName = "ObjectService";

    public java.lang.String getObjectServiceWSDDServiceName() {
        return ObjectServiceWSDDServiceName;
    }

    public void setObjectServiceWSDDServiceName(java.lang.String name) {
        ObjectServiceWSDDServiceName = name;
    }

    public localhost.axis.services.ObjectService.WorkerService getObjectService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ObjectService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getObjectService(endpoint);
    }

    public localhost.axis.services.ObjectService.WorkerService getObjectService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.axis.services.ObjectService.ObjectServiceSoapBindingStub _stub = new localhost.axis.services.ObjectService.ObjectServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getObjectServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setObjectServiceEndpointAddress(java.lang.String address) {
        ObjectService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.axis.services.ObjectService.WorkerService.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.axis.services.ObjectService.ObjectServiceSoapBindingStub _stub = new localhost.axis.services.ObjectService.ObjectServiceSoapBindingStub(new java.net.URL(ObjectService_address), this);
                _stub.setPortName(getObjectServiceWSDDServiceName());
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
        if ("ObjectService".equals(inputPortName)) {
            return getObjectService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/axis/services/ObjectService", "WorkerServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/axis/services/ObjectService", "ObjectService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ObjectService".equals(portName)) {
            setObjectServiceEndpointAddress(address);
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
