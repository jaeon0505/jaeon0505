import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnnectionExample {

	public static void main(String[] args) throws SQLException{
		
		Connection con = null;
	
		String url = "jdbc:mysql://localhost:3306/mydb";
		String id = "root";
		String pwd = "1234";
		PreparedStatement pst= null;
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, id, pwd);
		
			 
			 System.out.println("연결성공~~~");
				
			 
//			 //2. Users 테이블에 bno =3 사용자 정보 수정하기
//			
			 
			 //2.2 boards 테이블에 새로운 게시물 정보 저장하기
//			 String sql2 = "UPDATE boards SET btitle=?,  bcontent=?, bfilename=?, bfiledata=? WHERE bno =?";
//					
			 String sql3 = "DELETE FROM boards WHERE btitle = ?";
			 
			 //전송객체
//			  pst = con.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
			 pst = con.prepareStatement(sql3);
			 pst.setString(1,"눈");
//			 pst.setString(2,"함박눈이 내려요");
//			 pst.setString(3,"b.txt");
//			 pst.setBlob(4,new FileInputStream("b.txt"));
//			 pst.setInt(5,2);
//			 
			 
			 //데이터 전송하기
			int n = pst.executeUpdate();
			 
			 if(n==1) {
				 
				System.out.println("삭제성공");
				 
			 }else {
				 System.out.println("헤당번호는 존재하지 않습니다");
			 }
			 
			 
			 
					
		}catch(Exception e) {
			System.out.println("삭제실패");
//			e.getMessage();
		}
		finally{
			if(con !=null) {
			try {
				
				con.close();
				
				pst.close();
				System.out.println("연결끊기~~~");
			}catch(SQLException e) {}
				
				
			}
			
		}
		
		
	}

}
