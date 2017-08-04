package main;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChattingServer extends JFrame {
	private ArrayList<MultiServerThread> list;
	private Socket socket;
	private JTextArea ta;
	private JTextField tf;

	private ServerSocket serverSocket = null;

	public ChattingServer() {
		setTitle("多中チャットサーバー");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ta = new JTextArea();
		add(new JScrollPane(ta));
		tf = new JTextField();
		tf.setEditable(false);
		add(tf, BorderLayout.SOUTH);
		setSize(300, 300);
		setVisible(true);

		list = new ArrayList<MultiServerThread>();
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			MultiServerThread mst = null;
			boolean isStop = true;
			tf.setText("サーバーが正常実行中です。");
			System.out.println("isStop : " + isStop);
			while (isStop) {
				socket = serverSocket.accept();
				mst = new MultiServerThread();
				list.add(mst);
				mst.start();
			} // while
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChattingServer();
	}

	public class MultiServerThread extends Thread {
		InputStream is;
		BufferedReader br_in;
		BufferedWriter bw;
		PrintWriter pw;
		OutputStream os;
		String message;

		public void run() {
			System.out.println("MultiServerThread is called");
			boolean isStop = false;

			try {
				is = socket.getInputStream();
				os = socket.getOutputStream();

				br_in = new BufferedReader(new InputStreamReader(is));
				bw = new BufferedWriter(new OutputStreamWriter(os));
				pw = new PrintWriter(bw, true);

				while (!isStop) {
					message = br_in.readLine();
					String[] str = message.split("#");

					if (str[1].equals("exit")) {
						broadCasting(message);
						isStop = true;
					} else {
						broadCasting(message);
					} // else
				} // while

				list.remove(this);
				ta.append(socket.getInetAddress() + "IPアドレスのユーザーが終了しました。\n");
				tf.setText("残りのユーザー数：" + list.size());
			} catch (Exception e) {
				list.remove(this);
				ta.append(socket.getInetAddress() + "IPアドレスのユーザーが非正常的に終了しました。");
				tf.setText("残りのユーザー数：" + list.size());
			}
		} /// end run

		public void broadCasting(String message) {
			System.out.println("broadcasting is called");
			for (MultiServerThread ct : list) {
				ct.send(message);
			}
		}

		public void send(String message) {
			pw.println(message);
		}
	} // MultiServerThread

}
