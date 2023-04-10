package ch01;

public interface IEncoder {
	//URL 인코딩,Base64 인코딩
	//문자형 데이터 (바이너리 타입을 문자열을 Base64형태)
	String Encode(String message);
	
	
}
