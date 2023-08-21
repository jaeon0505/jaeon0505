package my.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BoardTest {

	Connection con = null;

	String url = "jdbc:mysql://localhost:3306/mydb";
	String id = "root";
	String pwd = "1234";

	PreparedStatement pst = null;
	ResultSet rs = null;

	String sql = "";

	String loginOK = "";
	Scanner scanner = new Scanner(System.in);

	public BoardTest() {
		connect();

	}

	public void connect() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("연결성공~~~");

		} catch (Exception e) {
			e.getMessage();
			exit();
		}
	}

	// 게시물 전체 조회
//	public void list() {
//
//		try {
//			sql = "SELECT bno,btitle,bcontent,bwriter,bdate FROM boards ORDER BY bno DESC";
//			pst = con.prepareStatement(sql);
//			
//			
//			rs = pst.executeQuery();
//			
//			while(rs.next()) {
//				int no = rs.getInt(1);
//				String title = rs.getString(2);
//				String content = rs.getString(3);
//				String writer = rs.getString(4);
//				java.sql.Date date =  rs.getDate(5);
//				
//				
//				Board board = new Board(no,title,content,writer,date);
//				System.out.printf("%-6s%-12s%-16s%-40s \n",no,title,content,writer,date);
//				
//			}
//			
//			rs.close();
//			pst.close();
//			
//			
//		}catch(Exception e){
//			e.getMessage();
//		}
//				return list;
//	
//	}

	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("------------------------------------");
		System.out.println("[게시물목록]" + ((loginOK != null)? ("사용자 " +loginOK) : ""));
		System.out.printf("%-6s%-12s%-16s%-40s\n", "bno", "writer", "date", "title");
		System.out.println("------------------------------------");
//		 System.out.printf("%-6s%-12s%-16s%-40s \n", "1","winter","2022.01.27","게시판에 오신 것을 환영합니다.");
//		 System.out.printf("%-6s%-12s%-16s%-40s \n", "2","winter","2022.01.27","올 겨울은 많이 춥습니다.");

		// board 테이블에서 정보 가져오기

		try {
			sql = "SELECT bno,btitle,bcontent,bwriter,bdate FROM boards ORDER BY bno DESC";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.printf("%-6s%-12s%-16s%-40s\n", board.getBno(), board.getBwriter(), board.getBdate(),
						board.getBtitle());

			}
			rs.close();
			pst.close();

		} catch (Exception e) {
			e.getMessage();
			
			exit();
		}
		mainMenu();

	}

	public void mainMenu() {

		System.out.println();
		System.out.println("--------------------------------------------");
		if(loginOK == null) {
			
			System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Join | 5.Login | 6.Exit");
			System.out.println("메인메뉴 선택");
			String menuNo = scanner.nextLine();
			System.out.println();
			switch (menuNo) {
			case "1" -> create();
			case "2" -> read();
			case "3" -> clear();
			case "4" -> join();
			case "5" -> login();
			case "6"-> exit();
		}

		}else {
			 System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Logout | 5.Exit");
			 System.out.print("메뉴 선택: ");
			 String menuNo = scanner.nextLine();
			 System.out.println();
			 
			 switch(menuNo) {
			 case "1" -> create();
			 case "2" -> read();
			 case "3" -> clear();
			 case "4" -> logout();
			 case "5" -> exit();
		}
		}

	}

	private void login() {
		User user = new User();
		System.out.println("[로그인]");
		System.out.println("아이디");
		user.setUserID(scanner.nextLine());
		System.out.println("비밀번호");
		user.setUserPassword(scanner.nextLine());
		
		//보조 메뉴
		System.out.println("---------------------");
		System.out.println("보조메뉴: 1.Ok  |  2.Cancel");
		System.out.print("메뉴선택");
		String menuNo = scanner.nextLine();
		if (menuNo.equals("1")) {
			try {
				sql = "SELECT userpassword FROM users WHERE userid =?";
				pst = con.prepareStatement(sql);
				pst.setString(1,user.getUserID());
				rs = pst.executeQuery();
				if(rs.next()){
					String dbPassword = rs.getString("userpassword");
					if(dbPassword.equals(user.getUserPassword())) {
						loginOK = user.getUserID();
					}else {
						System.out.println("비밀번호가 일치 하지 않습니다.");
					}
						
					}else{
						System.out.println("아이디가 존재하지 않습니다.");
					}
				rs.close();
				pst.close();
				}catch(Exception e) {
					e.printStackTrace();
					exit();
				}
					list();
				}
			
	}

	private void join() {
		User user = new User();
		System.out.println("[새 사용자 입력]");
		System.out.print("아이디:");
		user.setUserID(scanner.nextLine());
		System.out.print("이름:");
		user.setUserName(scanner.nextLine());
		System.out.print("비밀번호");
		user.setUserPassword(scanner.nextLine());
		System.out.print("나이");
		user.setUserAge(Integer.parseInt(scanner.nextLine()));
		System.out.print("이메일");
		user.setUserEmail(scanner.nextLine());
		
		System.out.println("---------------------");
		System.out.println("보조메뉴: 1.Ok  |  2.Cancel");
		System.out.print("메뉴선택");
		String menuNo = scanner.nextLine();
		
		if (menuNo.equals("1")) {
			try {
				sql = "INSERT INTO users (userid, username, userpassword, userage, useremail) VALUES (?, ?, ?, ?, ?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, user.getUserID());
				pst.setString(2, user.getUserName());
				pst.setString(3, user.getUserPassword());
				pst.setInt(4, user.getUserAge());
				pst.setString(5, user.getUserEmail());
				pst.executeUpdate();
				pst.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}

		}
		list();
	}
		
	

	private void exit() {
		if (con != null) {
			try {
				con.close();

			} catch (Exception e) {

			}
		}
		System.out.println("**게사판 종료 **");
		System.exit(0);

	}

	private void create() {
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.println("제목");
		board.setBtitle(scanner.nextLine());
		System.out.println("내용");
		board.setBcontent(scanner.nextLine());
		System.out.println("작성자");
		board.setBwriter(scanner.nextLine());
		// 보조 메뉴

		System.out.println("---------------------");
		System.out.println("보조메뉴: 1.Ok  |  2.Cancel");
		System.out.println("메뉴선택");
		String menuNo = scanner.nextLine();
		if (menuNo.equals("1")) {
			try {
				sql = "INSERT INTO boards(btitle, bcontent, bwriter, bdate) " + "VALUES (?,?,?,sysdate())";

				pst = con.prepareStatement(sql);

				pst.setString(1, board.getBtitle());
				pst.setString(2, board.getBcontent());
				pst.setString(3, board.getBwriter());

				pst.executeUpdate();
				pst.close();

			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}

		}
		list();
	}

	private void read() {

		System.out.println("[게시물 읽기]");
		System.out.print("bno: ");
		int bno = Integer.parseInt(scanner.nextLine());

		// boards 테이블에서 헤당 게시물을 가져와 출력
		try {
			String sql = "" +

					"SELECT  bno, btitle, bcontent,bwriter,bdate  FROM boards WHERE bno =?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, bno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {

				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));

				System.out.println("#############");
				System.out.println("번호: " + board.getBno());
				System.out.println("제목: " + board.getBtitle());
				System.out.println("내용: " + board.getBcontent());
				System.out.println("작성자: " + board.getBwriter());
				System.out.println("날짜: " + board.getBdate());
				System.out.println("#############");

				// 보조메뉴 출력
				System.out.println("---------------------------------");
				System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
				
				System.out.println("메뉴 선택: ");
				String menuNo = scanner.nextLine();
				System.out.println();

				if (menuNo.equals("1")) {
					update(board);

				} else if (menuNo.equals("2")) {
					delete(board);
				}

			}
			rs.close();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
			exit();

		}

		list();

	}

	private void delete(Board board) {

		try {
			
			String sql = "DELETE FROM boards WHERE bno =?";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, board.getBno());
			pst.executeUpdate();
			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		list();
	}

	private void update(Board board) {
		
		System.out.println("[수정 내용 입력]");
		System.out.print("제목");
		board.setBtitle(scanner.nextLine());
		System.out.print("내용 ");
		board.setBcontent(scanner.nextLine());
		System.out.print("작성자 ");
		board.setBwriter(scanner.nextLine());

		// 보조메뉴 출력
		System.out.println("---------------------------------");
		
		System.out.println("보조메뉴: 1.Ok  |  2.Cancel");
		System.out.print("메뉴 선택: ");
		
		String menuNo = scanner.nextLine();
		

		if (menuNo.equals("1")) {
			try {
				String sql = "" + "UPDATE boards SET btitle = ? , bcontent = ?, bwriter = ? WHERE bno=?";

				PreparedStatement pst = con.prepareStatement(sql);

				pst.setString(1, board.getBtitle());
				pst.setString(2, board.getBcontent());
				pst.setString(3, board.getBwriter());
				pst.setInt(4, board.getBno());

				pst.executeUpdate();
				pst.close();

			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}

		}
		list();

	}

	private void clear() {

		System.out.println("[게시물 전체 삭제]");

		list();

	}
	public void logout() {
		// 로그인 아이디 없애기
		loginOK = null;

		// 게시물 목록 출력
		list();
	}

	public static void main(String[] args) {

//		BoardTest bt = new BoardTest();
//		List<Board>list = new ArrayList<>();
//		
//		list = bt.list(15);
//		for(Board b : list) {
//			System.out.println(b.getBcontent());
//		}
		// bt.list();
		BoardTest boardExample = new BoardTest();
		boardExample.list();

	}

}
