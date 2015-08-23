package hekaton.balapkelerang.ussd;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Helper {
	public static String createUrl(String url, String number, String message) {
		//String query = URLEncoder.encode("apples oranges", "utf-8");
		try {
			String numberSave = URLEncoder.encode(number, "utf-8");
			String messageSave = URLEncoder.encode(message, "utf-8");
			return url + "?n="+numberSave+"&m="+messageSave;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return url + "?n="+number+"&m="+message;
		}
		
	} 
}
