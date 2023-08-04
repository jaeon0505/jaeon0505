
public class MathTest {

	public static void main(String[] args) {
	
	int mx = Math.max(-5, -8);
	System.out.println("-8과 -5의 최대값:"+mx);
	
	int mn=Math.min(-5, -8);
	System.out.println("-8과 -5의 최대값:"+mx);
	
	double mx2=Math.max(1.23, 3.45);
	System.out.println("1.23과 3.45의 최대값:"+mx2);
	System.out.println("5.67의 천장값:"+Math.ceil(5.67));
	System.out.println("5.67의 마루값: " +Math.floor(5.67));
	
	//문제 3의 7승 값은?
	double pw = Math.pow(3,7);
	System.out.println("3의 7승은: "+pw);
	//64.0의 제곱근은?
	double sq= Math.sqrt(64.0);
	System.out.println("64의 제곱근: "+sq);
	//문제3 반지름이 5인원 면적과 둘레를 계산하세요.
	//hint]Math클래스의 PI라는 필드를 이용해서 
	//*원의 면적 = 반지름*반지름*pi
	//*원의 둘레 = 2*pi* 반지름
	
	int radius = 5;
	double area = radius * radius * Math.PI;
	System.out.println("반지름이" +radius + "인원의 면적은:" +area);
	
	double area2 = 2 * radius * Math.PI;
	System.out.println("반지름이" +radius + "인원의 둘래은:" +area);
	
	
	
		
		
		
		
		
	}

}
