package cn.demo.jws;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import org.w3c.dom.Document;



public class Receive {
	
	public static void main(String[] args)throws Exception{
		String ns = "http://axisversion.sample";  
		String wsdlUrl = "http://127.0.0.1:8080/axis2/services/Version?wsdl";  
        //创建服务
		URL url = new URL(wsdlUrl);  
		QName sname = new QName(ns,"Version");  
		Service service = Service.create(url,sname);  
		//创建dispatch
		Dispatch<SOAPMessage> dispatch = service.createDispatch(
				new QName(ns,"VersionHttpSoap11Endpoint"),SOAPMessage.class,Service.Mode.MESSAGE);
		
		 //3、创建SOAPMessage  
		SOAPMessage msg = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createMessage();  
		SOAPEnvelope envelope = msg.getSOAPPart().getEnvelope();  
		SOAPBody body = envelope.getBody(); 
		//4、创建QName来指定消息中传递数据  
		QName ename = new QName(ns,"getVersion","axis");//<nn:add xmlns="xx"/>  
		SOAPBodyElement ele = body.addBodyElement(ename);  

		  msg.writeTo(System.out);  
		  System.out.println("\n invoking.....");  
		  //5、通过Dispatch传递消息,会返回响应消息  
		  SOAPMessage response = dispatch.invoke(msg);  
		  response.writeTo(System.out);  
		 System.out.println();  
		  //6、响应消息处理,将响应的消息转换为dom对象  
		  Document doc = response.getSOAPPart().getEnvelope().getBody().extractContentAsDocument();  
		  String str = doc.getElementsByTagName("ns:return").item(0).getTextContent();  
		  System.out.println(str);  

	}

}
