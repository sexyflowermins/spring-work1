package ch01;

public class MainTest1 {

	public static void main(String[] args) {
		System.out.println("hello world");
		Base64Encoder base64Encoder = new Base64Encoder();
		String result = base64Encoder.Encode("슬기랑 데이트 예정");
		System.out.println("result : "+ result);
		
		UrlEncoder encoder = new UrlEncoder();
		String result2 = encoder.Encode("슬기랑 데이트 예정");
		System.out.println("result2 : "+ result2);
	}

}
