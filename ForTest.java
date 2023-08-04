
public class ForTest {

	public static void main(String[] args) {
	
	//1부터 10까지의 합을 출려하시오. 이때 출력은 결과 만 출력하기
		//출력 결과: 1부터 10까지의 합 55
		
		//2. 구구단 2단 출력하기..
		
//		int dan=2;
//		for(int i=1; i<=9; i++) {
//			
//			System.out.println(dan+"X"+i+"=" +(dan*i));
		
		for(int dan=2; dan<10; dan++) {
			for(int i=1; i<=9; i++) {
				System.out.println(dan+"X"+i+"=" +(dan*i));
		}
		System.out.println("==========");
		
//			int sum=0;
//			for(int i=1; i<=i; i++) {
//			sum =sum+1;
			
		}

//			System.out.println("1부터 10까지의 합" + sum);
			
	}

}
