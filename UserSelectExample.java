import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserSelectExample{

	// 필드

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	String url = "jdbc:mysql://localhost:3306/mydb";
	String id = "root";
	String pwd = "1234";

	String sql = "";
	
	

	public UserSelectExample() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결성공");

		} catch (Exception e) {
			e.getMessage();
			System.out.println("연결 실패");
		}
	}

	public List<User> selectAll() {
		sql = "SELECT * FROM users;";
		List<User> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			User user1;
			
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				int age = rs.getInt(4);
				String emaile = rs.getString(5);
				user1 = new User(id, name, password, age, emaile);
				
				list.add(user1);
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return list;

	}
	
	//저장메소드
	public int userInsert(User user) {
		int n = 0;
		sql= "INSERT INTO users (userid, username,userpassword,userage,useremail) VALUES(?,?,?,?,?)";
		try {
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1,user.getUserid());
			pst.setString(2,user.getUsername());
			pst.setString(3,user.getUserpassword());
			pst.setInt(4,user.getUserage());
			pst.setString(5,user.getUseremail());
			n = pst.executeUpdate();
	
		
			
			
		
			
		
		}
		
		catch(Exception e) {
			e.getMessage();
			
		}
		return n;
		
		
		
		
	}

	public static void main(String[] args) {

		UserSelectExample use = new UserSelectExample();
		
		List<User> list = use.selectAll();

		for (User u : list) {
			System.out.println("아이디 " + u.getUserid());
			System.out.println("이름 " + u.getUsername());
			System.out.println("비밀번호 " + u.getUserpassword());
			System.out.println("나이 " + u.getUserage());
			System.out.println("이메일 " + u.getUseremail());

		}
		User user2 =new User("summer","여름","123456",25,"email");
		use.userInsert(user2);
		
	}

}
