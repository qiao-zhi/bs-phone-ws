package cn.ws.server;

import javax.xml.ws.Endpoint;

public class WsPublicer {

	public static void main(String[] args) {
		// 发布的两个地址
		String address1 = "http://127.0.0.1/ws/phoneService";
		/**
		 * 发布webservice服务 1.address：服务的地址 2：implementor 服务的实现对象
		 */
		Endpoint.publish(address1, new PhoneServer());
		System.out.println("wsdl地址 :" + address1 + "?WSDL");
	}

}
