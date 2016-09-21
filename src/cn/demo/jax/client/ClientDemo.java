package cn.demo.jax.client;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class ClientDemo {
	
	public static void main(String[] args) throws Exception {
		//获取service
		SayHiService service = new SayHiServiceImplService().getSayHiServiceImplPort();
		
		// sayhi
		service.sayHiDefault();
		service.sayHi("Ahe");
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(new Date(System.currentTimeMillis()));
		XMLGregorianCalendar xmldate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		System.out.println(service.checkTime(xmldate));
	}

}
