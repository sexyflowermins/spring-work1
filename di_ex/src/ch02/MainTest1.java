package ch02;

public class MainTest1 {

	public static void main(String[] args) {
		
		//중간 클래스 만들었음!
		String Url = "www.naver.com/books/id?=100";
		
		// IEncoder 생성자 타입 --> 의존 주입 설계
		// Base64Encoder <-- 타입으로 바라볼수 있다.
		//UrlEncoder <-- IEncoder 타입으로 바라볼수 있다
		
		//하고 싶은 인코더 클래스를 주입만 하면 그 구현 클래스 에 맞게 기능을 처리 할수있다.
		Encoder encoder = new Encoder(new UrlEncoder());
		String result1 = encoder.encode(Url);
		System.out.println("result : " + result1);
		
		encoder.setiEncoder(new Base64Encoder());
		System.out.println(encoder.encode("반가워"));
		
		Encoder encoder2 = new Encoder(new Base64Encoder());
		String result2 = encoder2.encode(Url);
		System.out.println("result2 : " + result2);

		Encoder encoder3 = new Encoder(new MyEncoder());
		String result3 = encoder3.encode(Url);
		System.out.println("result3 : " + result3);
		
	}

}
