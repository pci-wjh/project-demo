package cn.demo.jax.service.sayhi;

import javax.xml.ws.Endpoint;

public class StartService {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/testjws/service/sayHi", new SayHiServiceImpl());
	}

}
