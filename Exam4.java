
public class Exam4 {

	public static void main(String[] args) {
//
//		countinue문: 369rpdlagkrl
		// 1qnxj 10까지 정수 출력중 3,6,9 일때 박수 소리를 출력하는 프로그램 작성하기
		//__________________________________
		//실행결과
		//-----------------------------
		// 12짝45짝78짝10
		
		for(int i = 1; i<=10; i++) {
		if(i == 3 || i==6 || i ==9) {
			System.out.println("짝");	
			continue;
			
			}
			System.out.printf("%d",i);	
			
		}

		
	}

}
