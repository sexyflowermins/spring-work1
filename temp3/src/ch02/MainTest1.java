package ch02;

public class MainTest1 {

	public static void main(String[] args) {
		
		Button button = new Button("버튼1");
		
		button.setIButtonListener(new IButtonListener() {
			
			@Override
			public void clickEvent(String event) {
				System.out.println("오대기 출발 : "+ event);
			}
		});
		button.click("슬기가 보러가야지");
		button.click("출발");
	}//end of main

}//end of class
