public class Iftest2 {

	public static void main(String[] args) {

//난수 생성 ... 0.0 <= Math.random()  < 1.0
		//1~6까지 난수 생성..
		int n = (int)(Math.random()*6)+1;
		System.out.println(n);
	
		
		switch (n){
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;
		case 6:
			System.out.println("6번이 나왔습니다.");
			break;
		default:
			System.out.println("헤당되는 값이 존재하지 않습니다.");
			
			
		}
		
		
	 }	
	}
