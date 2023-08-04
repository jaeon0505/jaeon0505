import java.util.Scanner;

public class Iftest4 {

	public static void main(String[] args) {

		System.out.println("=========Game Menu==========");
		System.out.println("1. 가위\t2.바위\t3.보\t9.종료");
		System.out.println("========================");
		System.out.println("입력하세요:");
		
		Scanner scan = new Scanner(System.in);
		int user = scan.nextInt();
		
		//computer가 만든 난수 값
		int com = (int)(Math.random()*3)+1;
		
		//승패 판단하기
		
		System.out.println("User: " + user);
		System.out.println("com: " + com);
		
		//비길 경우
		if((user ==1 && com ==1) || (user == 2 && com ==2) || (user == 3 && com == 3)) {
			System.out.print("비겼습니다.");
		}
		//내가 이길 경우
		else if((user ==1 && com ==3) || (user == 2 && com ==1) || (user == 3 && com == 2)) {
			System.out.print("이겼습니다.");
		}
		else if((user ==1 && com ==2) || (user == 2 && com ==3) || (user == 3 && com == 1)) {
			System.out.print("졌습니다.");
		}
		//내가 질 경우
		
		else {
			System.out.print("종료.");
		}
		
		
		
		
		
		
		
		
		
		
	 }	
	}
