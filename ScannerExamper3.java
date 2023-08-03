public class ScannerExamper3 {

	public static void main(String[] args) {
		
//		String name;
//		int age;
//		Double height;
//		String dept;
//		
//		
//		//입력 객체 생성
//		Scanner scan = new Scanner(System.in);
//		
//		
//		//데이터 읽어오기
//		
//		System.out.print("이름을 입력하세요:>>");
//		
//		name = scan.next();
//		
//		System.out.print("나이를 입력하세요:>>");
//		
//		age = scan.nextInt();
//		
//		System.out.print("키를 입력하세요:>>");
//		
//		height = scan.nextDouble();
//		
//		System.out.print("전공를 입력하세요:>>");
//		
//		dept = scan.next();
//		
//		//printf 메소드를 이용해 자신의 정보를 출력해보시요
//		System.out.printf("이름:%s, 나이:%d, 키:%s.1f, 전공:%s",name,age,height,dept);

//		
//		int charCode = 'A'; //65
//		int charCode2 = 11;
//		double charCode3 = 160;
//		
//		if ((65<=charCode) && (charCode<=90))
//			System.out.println("대문자입니다");
//		
//		
//		if ((65<=charCode2) || (charCode3<=160))
//			System.out.println("놀이기구 탑승 가능 이군요");
//		
//		if(charCode2 % 2 ==0) System.out.println("짝수 입니다");
//			
				
//		boolean k;
//		k = (charCode2 % 2) ==0;
//		System.out.println(k ? "짝수": "훌수");
//	
//		if(charCode2 % 2 == 0)
//				System.out.println("짝수입니다.");
//		else
//			System.out.println("홀수입니다.");
		
//		int x = 10;
//		int y = 20;
//		int z = (++x) + (y--);
//		System.out.println(z);
//		System.out.println(x);
//		System.out.println(y);
//		
		
//		int pencils = 534;
//		int students = 30;
//		
//		int pencilsPerStudent = (pencils / students);
//		System.out.println(pencilsPerStudent);
//		
//		int pencilsLeft = (pencils % students);
//		System.out.println(pencilsLeft);
//		
//		int lenghtTop = 5;
//		int lengthBottom = 10;
//		int height = 7;
//		double area = (lenghtTop+lengthBottom) * height/2;
//		System.out.println(area);
//		
//		
//		int x = 10;
//		int y = 5;
//		System.out.println( (x>7) && (y<=5) );
//		System.out.println(x%3 == 2) || (y%2 != 1 ) );
//		
		
		double x = 5.0;
		double y = 0.0;
		double z = 5 % y;
		
		if(Double.isNaN(z))   {
			System.out.println("0.0으로 나눌 수 없습니다.");
		}
		else {
			double result = z + 10;
			System.out.println("결과: " + result);
			
		}
		
		
		
		
		
		
	}

}
