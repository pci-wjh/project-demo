package cn.demo.jax.service.myserver;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
interface IMyService {
	@WebResult(name="addResult")
	public int add(@WebParam(name="a")int a,@WebParam(name="b")int b);
	
	@WebResult(name="minusResult")
	public int minus(@WebParam(name="a")int a,@WebParam(name="b")int b);
	
	@WebResult(name="loginUser")
	public User login(@WebParam(name="username")String username,@WebParam(name="password")String password);


}
