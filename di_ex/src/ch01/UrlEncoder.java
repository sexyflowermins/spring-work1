package ch01;

import java.net.URLEncoder;

public class UrlEncoder implements IEncoder {

	@Override
	public String Encode(String message) {

		try {
			return URLEncoder.encode(message, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
