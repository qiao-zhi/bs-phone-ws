package cn.ws.client;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class PhoneClient {
	public static void main(String[] args) {
		Object ticket = clientGetPhoneLocation("");
		System.out.println(ticket);
	}

	public static String clientGetPhoneLocation(String phone) {
		try {
			// wsdl的地址
			String endpoint = "http://127.0.0.1/ws/phoneService?WSDL";
			// 直接引用远程的wsdl文件
			// 以下都是固定格式
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(endpoint);

			// WSDL里面描述的方法名称 填写方法名是需加上命名空间，否则会找不到对应的方法
			call.setOperationName(new QName("http://server.ws.cn/", "getLocation"));
			// 添加解析类型的地址
			call.setEncodingStyle("server.ws.cn");

			// 给方法传递参数，并且调用方法
			call.addParameter("arg0", XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.XSD_STRING);// 设置返回类型
			return (String) call.invoke(new Object[] { phone });
		} catch (Exception e) {
			return "";
		}
	}
}
