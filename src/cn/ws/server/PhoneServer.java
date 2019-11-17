package cn.ws.server;

import javax.jws.WebService;

import cn.ws.utils.HttpUtils;

@WebService
public class PhoneServer {

	public static final String REGEX_MOBILE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";

	public static final String URL = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=";

	public String getLocation(String phone) {
		if (phone == null || "".equals(phone)) {
			return "手机号码不能为空";
		}

		if (phone.matches(REGEX_MOBILE)) {
			String doGet = HttpUtils.doGet(URL + phone, null);
			return doGet;
		} else {
			return "不是手机号";
		}
	}
}
