

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
	public class MultiClient extends JFrame implements ActionListener, Runnable{
		
			
			JButton btn1;
			
			JTextArea jta;
			
			JTextField jtf;
			
			//필드
			Socket socket;
			DataInputStream dis;
			DataOutputStream dos;
			
			
			JPanel jp;
			
			
			
			public MultiClient() {
				btn1 = new JButton("전송");
//				btn2 = new JButton("취소");
				jta = new JTextArea();
				jtf = new JTextField(10);
				jp = new JPanel();
				jp.setBackground(Color.gray);
				
				setLayout(new BorderLayout());
				
//			     add(btn1, BorderLayout.NORTH);
////			     add(btn2, BorderLayout.SOUTH);
//			     add(new Button("East"), BorderLayout.EAST);
//			     add(new Button("West"), BorderLayout.WEST);
//			     add(new Button("Center"), BorderLayout.CENTER);
//				setLayout(new BorderLayout());
				jp.add(jtf);
				jp.add(btn1);
				add(jta,"Center");
				add(jp,"South");
			     
				
				
			////////////////////////////////////////////
				btn1.addActionListener(this);
				///////////////////////////////////////
			
				
				setTitle("멀티 채팅 프로그램_ GUT버전");
				setSize(500,500);
				
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				setVisible(true);
				
				/////////////////////////////////
				Thread thread = new Thread(this);
				thread.start();
				////////////////////////////////////
				
				
			}
			
	

		@Override
		public void actionPerformed(ActionEvent e) {
//			String str = e.getActionCommand();
			
			Object obj =e.getSource();
			if(obj == btn1) {
				
				String result = jtf.getText().toString();
				
				try {
					dos.writeUTF(result);
					
					jta.setText("나:" +jtf.getText()+"\n"+jtf.getText());
					
					jtf.setText("");
					
				}catch(Exception e1){
					e1.getMessage();
				}
				
			}
			
		}

	
	


	@Override
	public void run() {
		try{
			socket = new Socket("localhost", 9999);
			System.out.println("서버 연결 성공");
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			System.out.println("[클라이언트] 연결 성공");
			
			while(true) {
				
				String msg = dis.readUTF().toString();
				jta.setText("상대방:" + msg + "\n" + jta.getText()) ;
				System.out.println("Message:" + msg);
			}
			
		}catch(Exception e){
			e.getMessage();
		}
		
		
	}
	

	public static void main(String[] args) {
		new MultiClient();

	}

}
