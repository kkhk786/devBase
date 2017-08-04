package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client implements ActionListener, Runnable {
	private static final String SERVER_IP = "192.168.1.49";

	private Socket socket;
	private JFrame jframe;
	private JTextField jtf;
	private JTextArea jta;
	private JLabel jlb1, jlb2;
	private JPanel jp1, jp2;
	private String ip;
	private String chatName;
	private JButton jbtn;
	InputStream is;
	OutputStream os;
	BufferedReader br_in;
	BufferedWriter bw = null;
	PrintWriter pw = null;

	public Client() {
		// 대화명을 다이얼로그로 입력받는다.
		chatName = JOptionPane.showInputDialog(jframe, "会話名を入力してください。", "会話名の入力ダイアログ", JOptionPane.YES_NO_OPTION);
		if (chatName.length() == 0 || chatName == null) {
			System.exit(0);
		}
	}

	public void init() {
		try {
			socket = new Socket(ip, 5000);
			is = socket.getInputStream();
			os = socket.getOutputStream();

			br_in = new BufferedReader(new InputStreamReader(is));
			bw = new BufferedWriter(new OutputStreamWriter(os));
			pw = new PrintWriter(bw, true); // automatic flush

			Thread t = new Thread(this);
			t.start(); // Thread starts.
		} catch (Exception e) {
			e.printStackTrace();
		} // catch
	} // init

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		String msg = jtf.getText();
		if(obj == jtf) {
			if(msg == null || msg.length() == 0) {
				JOptionPane.showMessageDialog(jframe, "内容を書いてください。","警報",JOptionPane.WARNING_MESSAGE);
			} else { // 내용을 입력하고 엔터한 경우
				try {
					pw.println(chatName + "#"+msg);
				} catch(Exception ee) {
					ee.printStackTrace();
				} //catch
			}
		} //actionPerformed
		
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Client cc = new Client();
		cc.init();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String message = null;
		String [] receiveMsg = null;
		boolean isStop = false;
		while(! isStop) {
			try {
				message = (String)br_in.readLine(); // Chat Contents
				receiveMsg = message.split("#");
			} catch (Exception e) {
				e.printStackTrace();
				isStop = true; //반복문 종료로 설정
			} //catch
			
			jta.append(receiveMsg[0] + " : "+receiveMsg[1]+"\n");
		} //while
	} //run

} //end
