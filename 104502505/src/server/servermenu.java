package server;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import Final.Client;
import server.Server;
import server.serverframe;
import server.Server.RequestThread;

public class servermenu extends JPanel implements ActionListener{
	JButton bserver = new JButton("server");
	JLabel serverwin;
	JLabel serverlose;
	JLabel back;

	private BufferedReader theInputStream;  // 讀取客戶端資料的緩衝區
    private PrintStream theOutputStream;
 
  
    String times;
    static JLabel hit = new JLabel();
	JLabel sec = new JLabel();
	Timer second = new Timer(1000,this);
	Timer score = new Timer(100,this);
	boolean click =false;
	boolean lock =false;
	int n=20;
	int a=0;
	Font font = new Font("OK", 1, 50);
	Server catched =new Server();
	
	Server server = new Server();
	serverframe sf;
	
	servermenu() {
		bserver.setBounds(327, 33, 100, 30);
		
		setLayout(null);
		System.out.println("123456");
		setBounds(0, 0, 580, 100);
		
		back = new JLabel();
		back.setIcon(new ImageIcon("back.png"));
		back.setBounds(0,0,565,100);
		bserver.addActionListener(this);
		this.add(bserver);
		this.add(back);
		back.setVisible(true);
		
	}
	Thread give = new Thread(){
		public void run(){
			while(true){
				try {
	    			
	    			theInputStream = new BufferedReader(
	    			        new InputStreamReader(Server.dsocket.getInputStream()));
	    			theOutputStream = new PrintStream(Server.dsocket.getOutputStream());
	                
	       
	    			times = theInputStream.readLine();
	                System.out.println(times);
	    			servermenu.hit.setText(times);
	    			
	    			if(Integer.valueOf(times)>=5){
	    				 lose();
	    			}
	    			
	             
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
			}	
		}
	};
	void change(){
		hit.setText("0");
		hit.setVisible(true);
		hit.setBounds(159, 45, 70, 70);
		hit.setFont(font);
		sec.setVisible(true);
		sec.setBounds(414, 45, 70, 70);
		sec.setText("20");
		sec.setFont(font);
		bserver.setVisible(false);
		back.add(hit);
		back.setIcon(new ImageIcon("back1_1.png"));
		back.add(sec);
		
		repaint();
		second.start();
		click=true;
		score.start();
		 // Thread b=new Thread ();
		    
		
	}
	void lose(){
		if(lock == false){
			lock = true;
			this.removeAll();
			serverlose = new JLabel();
			serverlose.setIcon(new ImageIcon("serverlose.png"));
			serverlose.setBounds(0,0,565,100);
			this.add(serverlose);
			repaint();
			second.stop();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==second){
			
			n=n-1;
			sec.setText(Integer.toString(n));
			repaint();
			if(n<=0){
				try{
					Thread.sleep(1000);
				}
				catch(Exception e1){
					System.out.println("Exception caught");
				}
				if(lock == false){
					lock = true;
					this.removeAll();
					serverwin = new JLabel();
					serverwin.setIcon(new ImageIcon("serverwin.png"));
					serverwin.setBounds(0,0,565,100);
					this.add(serverwin);
					second.stop();
				}
			}
		}
		if(e.getSource()==bserver){
			try {
				change();
				
				server.listenRequest(sf);
				setFocusable(false);
				sf.g.requestFocusInWindow();
			
			} 
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==score){
			give.start();
		}	 
	}
}

