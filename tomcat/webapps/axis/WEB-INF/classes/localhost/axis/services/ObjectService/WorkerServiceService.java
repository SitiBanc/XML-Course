/**
 * WorkerServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.axis.services.ObjectService;

public interface WorkerServiceService extends javax.xml.rpc.Service {
    public java.lang.String getObjectServiceAddress();

    public localhost.axis.services.ObjectService.WorkerService getObjectService() throws javax.xml.rpc.ServiceException;

    public localhost.axis.services.ObjectService.WorkerService getObjectService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
