package cn.demo.jax.service.sayhi;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(endpointInterface="cn.demo.jax.service.sayhi.SayHiService")
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class SayHiServiceImpl implements SayHiService{

	@Override
	public int checkTime(Date clientTime) {
		String dateService = new java.sql.Date(System.currentTimeMillis()).toString()+
		" "+new Time(System.currentTimeMillis());
		String dateClient = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(clientTime);
		return dateService.equals(dateClient)?0:1;
	}

	@Override
	public void sayHi(String name) {
		 System.out.println("Hi, " + name + "!");
	}

	@Override
	public void sayHiDefault() {
		System.out.println("Hi, Johness!");
	}

}
