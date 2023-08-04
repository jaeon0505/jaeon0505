
public class WhileTest1 {

	public static void main(String[] args) {
		// 초기식
		//While (조건식{
//			반복실행 무장
//			증감식;
//		}	)     
		
		//1부터 10까지의 합...
		//while 문으로 작성하기.
		
//		int i = 10;// 카운터변수
////		int sum = 0;
//		
//		while(i>=1) {
//			sum += i; //sum = sum +i;
			//증감식
//			i--;
//		}
//		System.out.println("1부터 10까지의 합:" + i);
//		
		
//		int i = 1;
//		int dan = 2;
//		while(i<10) {
//			System.out.printf("%d X %d = %d\n", dan,i,(dan *1));
//					i++;
			
		
			int dan = 2;
		while (dan<10) {
			int i =1;
			
			while(i<=9) {
				System.out.printf("%d X %d = %d\n",dan,i, (dan *i));
				i++;
				
			}
			System.out.println();
			++dan;
					
					
					
		}
		
	}

}
