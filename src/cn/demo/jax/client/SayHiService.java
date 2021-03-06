
package cn.demo.jax.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SayHiService", targetNamespace = "http://sayhi.service.jax.demo.cn/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SayHiService {


    /**
     * 
     * @param clientTime
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "valid", partName = "valid")
    @Action(input = "http://sayhi.service.jax.demo.cn/SayHiService/checkTimeRequest", output = "http://sayhi.service.jax.demo.cn/SayHiService/checkTimeResponse")
    public int checkTime(
        @WebParam(name = "clientTime", partName = "clientTime")
        XMLGregorianCalendar clientTime);

    /**
     * 
     */
    @WebMethod
    @Action(input = "http://sayhi.service.jax.demo.cn/SayHiService/sayHiDefaultRequest", output = "http://sayhi.service.jax.demo.cn/SayHiService/sayHiDefaultResponse")
    public void sayHiDefault();

    /**
     * 
     * @param name
     */
    @WebMethod
    @Action(input = "http://sayhi.service.jax.demo.cn/SayHiService/sayHiRequest", output = "http://sayhi.service.jax.demo.cn/SayHiService/sayHiResponse")
    public void sayHi(
        @WebParam(name = "name", partName = "name")
        String name);

}
