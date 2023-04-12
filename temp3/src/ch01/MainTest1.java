package ch01;

public class MainTest1 {
	
	public static void main(String[] args) {
		//옵저버 패턴을 배워보자
		Button button = new Button("버튼 1 이야");
		//인터페이스 --> 익명클래스 -> 익명 구현 클래스
		button.setIButtonListener(new IButtonListener() {
			
			@Override
			public void clickEvent(String event) {
				// 하고 싶은 동작을 ,알고리즘을 구현 하면된다
				System.out.println("콜백 들어왔어 !!! " + event);
			}
		});
		/////////////////설계 콜백 메서드 = 옵저버패턴
		//오후 -4 시 됨 알람 울림
		button.click("야 너집에 가야지 엄마 기다려!!!");
		button.click("이게정말 콜백이야");
		button.click("맞아 옵저버 패턴이라고 불러");
		
	}
	
}
