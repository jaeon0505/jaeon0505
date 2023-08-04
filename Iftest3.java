import java.util.Scanner;

public class Iftest3 {

	public static void main(String[] args) {

//  문제1: 0부터 9까지의 정수를 입력받아...
		//짝수, 홀수를 판단하는 코드를 작성하시오...
		///단, if문으로 작성하기...
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하시오:");
		
		int n = scan.nextInt();
		
		if(n % 2 !=0) {
			System.out.print("홀수");
		}else {
			System.out.print("짝수");
			
		}
		
		
		
		
	 }	
	}
