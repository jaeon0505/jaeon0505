import java.util.Scanner;

public class Exam5 {
	
	public static void main(String[] args) {
		boolean run = true;
		while(run){
		System.out.println("-----------------");
		System.out.println("1.예금  \t2.출금\t3.잔고\t4.종료");
		System.out.println("-----------------");
		System.out.println("선택>");
		
		int balance =0;
		
		Scanner scanner = new Scanner(System.in);
		
		int menuNum = scanner.nextInt();
		
		switch(menuNum) {
		
		case 1:
			System.out.print("예금액> ");
			balance += scanner.nextInt();
			break;
			
		case 2:
			System.out.print("출금액> ");
			balance -= scanner.nextInt();
			break;
			
			
		case 3:
			System.out.print("잔고> ");
			System.out.println(balance);
			break;
		
		
		case 4:
			run = false;
			break;
			}
			
			
			
		}
		
	}

}
