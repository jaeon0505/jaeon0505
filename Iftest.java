import java.util.Scanner;
public class Iftest {

	public static void main(String[] args) {
	int score;
	
	// 2.점수를 입력받아 학점 출력하기
	Scanner scanner = new Scanner(System.in);
	System.out.print("성적을 입력 하시오: ");
	
	
	score = scanner.nextInt();
	// 90점 이상이면 합격을 출력하기...
	if (score >= 90) {
		System.out.println("A");
	}
	else if(score >80) {
		System.out.println("B");
	}
	else if(score >=70) {
		System.out.println("C");
	}
	else if(score >=60) {
		System.out.println("D");
	}
	else {
		System.out.println("F");



	
		
	 }	
	}
}